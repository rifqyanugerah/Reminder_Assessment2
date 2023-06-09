package org.d3if3095.reminder

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.preference.*
import org.d3if3095.reminder.notifications.AlarmReceiver
import org.d3if3095.reminder.utils.ThemeHelper
import java.util.*

class SettingFragment : PreferenceFragmentCompat() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preference_screen, rootKey)

        // theme preferences
        val themePreference =
            findPreference<ListPreference>("themePref")
        if (themePreference != null) {
            themePreference.onPreferenceChangeListener =
                Preference.OnPreferenceChangeListener { _, newValue ->
                    val themeOption = newValue as String
                    ThemeHelper.applyTheme(themeOption)
                    true
                }
        }

        //notifications preferences
        val notificationPreference = findPreference<SwitchPreferenceCompat>("omo")
        val alarmPreference = findPreference<ListPreference>("schedule")
        var alarmOption =
            context?.let {
                PreferenceManager.getDefaultSharedPreferences(it).getString(
                    "schedule", ""
                )
            } ?: "1"

        Log.i(TAG, "onCreatePreferences: Default value is :$alarmOption")

        if (notificationPreference != null) {
            notificationPreference.onPreferenceChangeListener =
                Preference.OnPreferenceChangeListener { _, newValue ->
                    val switch: Boolean = newValue as Boolean
                    if (switch) {
                        initializeTheAlarm(alarmOption)
                        alarmPreference?.isEnabled = true
                    } else {
                        cancelTheAlarm()
                        alarmPreference?.isEnabled = false
//                        Toast.makeText(context, "no notification!", Toast.LENGTH_SHORT).show()
                    }
                    true
                }
            if (alarmPreference != null) {
                alarmPreference.onPreferenceChangeListener =
                    Preference.OnPreferenceChangeListener { _, newValue ->
                        alarmOption = newValue as String
                        initializeTheAlarm(alarmOption)
                        Log.i(TAG, "onCreatePreferences: $alarmOption")
                        true
                    }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun initializeTheAlarm(times: String) {
        Log.i(TAG, "initializeTheAlarm: $times")

        val interval: Long = when (times.toInt()) {
            1 -> AlarmManager.INTERVAL_DAY
            3 -> AlarmManager.INTERVAL_DAY / 3
            5-> AlarmManager.INTERVAL_DAY / 5
            7 -> AlarmManager.INTERVAL_DAY / 7
            10 -> AlarmManager.INTERVAL_DAY / 2400
            else -> AlarmManager.INTERVAL_DAY
        }
        Log.i(TAG, "initializeTheAlarm: interval = $interval")

        val calendar: Calendar = Calendar.getInstance()
            .apply {
                timeInMillis = System.currentTimeMillis()
                add(Calendar.SECOND, 30)
            }
        startTheAlarm(calendar, interval)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun startTheAlarm(calendar: Calendar, interval: Long) {
        val alarmManager =
            context?.getSystemService(Context.ALARM_SERVICE) as? AlarmManager
        val intent = Intent(context, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            ALARM_REQUEST_CODE,
            intent,
            PendingIntent.FLAG_CANCEL_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        alarmManager?.setRepeating(
            AlarmManager.RTC,
            calendar.timeInMillis,
            interval,
            pendingIntent
        )
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun cancelTheAlarm() {
        val alarmManager =
            context?.getSystemService(Context.ALARM_SERVICE) as? AlarmManager
        val intent = Intent(context, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            ALARM_REQUEST_CODE,
            intent,
            PendingIntent.FLAG_CANCEL_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        alarmManager?.cancel(pendingIntent)
    }

        fun showNextAlarm() {
        val alarmManager =
            context?.getSystemService(Context.ALARM_SERVICE) as? AlarmManager
        val info: AlarmManager.AlarmClockInfo? = alarmManager?.nextAlarmClock
        val nextAlarm = info?.triggerTime
        Log.i(TAG, "showNextAlarm: $nextAlarm")
    }
    companion object {
        const val ALARM_REQUEST_CODE = 0
        private const val TAG = "SettingFragment"
    }
}
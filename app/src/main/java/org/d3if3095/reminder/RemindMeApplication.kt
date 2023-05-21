package org.d3if3095.reminder

import android.app.Application
import android.preference.PreferenceManager
import org.d3if3095.reminder.utils.ThemeHelper

class RemindMeApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val sharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(this)
        val themePref =
            sharedPreferences.getString("themePref", ThemeHelper.DEFAULT_MODE)
        if (themePref != null) {
            ThemeHelper.applyTheme(themePref)
        }
    }

    companion object {
        private const val TAG = "RemindMeApplication"
    }
}
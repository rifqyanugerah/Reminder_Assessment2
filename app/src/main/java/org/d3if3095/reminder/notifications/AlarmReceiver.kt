package org.d3if3095.reminder.notifications

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3095.reminder.database.People
import org.d3if3095.reminder.database.PeopleDatabase

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(
        context: Context?,
        intent: Intent?
    ) {
        Toast.makeText(
            context,
            "BroadcastReceiver is Running...",
            Toast.LENGTH_SHORT
        ).show()

        getFromDataSource(context)
    }

    /**
     * get the data 'people' from the database.
     * @param context represent the current context and
     * we pass to the dataSource.*/
    private fun getFromDataSource(context: Context?) {
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            val dataSource = PeopleDatabase
                .getInstance(context!!.applicationContext).peopleDao
            var peopleList: List<People> = dataSource.getAll()

            sendNotification(context, peopleList)
        }
    }

    /** use the extension function we created in NotificationUtils to show
     * a notification to the users.
     * @param context the current context of the application.
     * @param peopleList represent the data we want to show.
     */
    private fun sendNotification(
        context: Context,
        peopleList: List<People>
    ) {
        val notificationManager = context
            .getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (peopleList.isNotEmpty()) {
            notificationManager.sendNotification(context, peopleList.random())
            Log.i(TAG, "People size is ${peopleList.size}")
        }
    }

    companion object {
        private const val TAG = "AlarmReceiver"
    }
}
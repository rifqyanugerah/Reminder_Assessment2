package org.d3if3095.reminder.screens.people

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import org.d3if3095.reminder.R
import org.d3if3095.reminder.database.People
import org.d3if3095.reminder.utils.convertDateToPassedTime

@BindingAdapter("personFullName")
fun TextView.setFullName(item: People?) {
    item?.let {
        text = item.firstName + " " + item.secondName
    }
}

@BindingAdapter("personMeetingPlace")
fun TextView.setMeetingPlace(item: People?) {
    item?.let {
        text = item.place
    }
}

@BindingAdapter("personMeetingTime")
fun TextView.setMeetingTime(item: People?) {
    item?.let {
        text = item.time
    }
}

@BindingAdapter("personMeetingNote")
fun TextView.setMeetingNote(item: People?) {
    item?.let {
        text = item.note
    }
}

@BindingAdapter("personMeetingRTime")
fun TextView.setRegistrationTime(item: People?) {
    item?.let {
        text =
            convertDateToPassedTime(item.registrationTime)
    }
}

@BindingAdapter("genderImage")
fun ImageView.setGenderImage(item: People?) {
    val gender = item?.gender
    setImageResource(item?.avatar ?: R.drawable.ic_baseline_person_outline_24)
}
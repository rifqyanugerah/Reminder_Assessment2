package org.d3if3095.reminder.utils

import android.util.Log
import org.d3if3095.reminder.R
import org.d3if3095.reminder.database.People
import org.d3if3095.reminder.screens.people.PeopleViewModel
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.roundToInt

private val sDateFormat = SimpleDateFormat("dd MMM")

private const val MINUTE_MILLIS = 1000 * 60.toLong()
private const val HOUR_MILLIS = 60 * MINUTE_MILLIS
private const val DAY_MILLIS = 24 * HOUR_MILLIS

fun convertDateToPassedTime(time: Long): CharSequence? {

    val now = System.currentTimeMillis()

    var rightTime: String?

    if (now - time < DAY_MILLIS) {
        if (now - time < HOUR_MILLIS) {
            if (now - time < MINUTE_MILLIS) {
                rightTime = "Now"
            } else {
                val minutes = (now - time).toDouble().roundToInt() / MINUTE_MILLIS
                rightTime = minutes.toString() + "M"
                println("less than hour $rightTime")
            }
        } else {
            val minutes: Int = ((now - time) / HOUR_MILLIS).toDouble().roundToInt()
            rightTime = minutes.toString() + "H"
            println("more than hour $rightTime")
        }
    } else {
        val dateDate = Date(time)
        rightTime = sDateFormat.format(dateDate)
        println("more than day $rightTime")

    }
    // Add a dot to the date string
    val result = "\u2022 $rightTime"
    return result
}

fun selectFemaleVector(): Int {
    val vectors = listOf(
        R.drawable.ic_f1,
        R.drawable.ic_f2,
        R.drawable.ic_f3,
        R.drawable.ic_f4,
        R.drawable.ic_f5
    ).shuffled()
    return vectors[0]
}

fun selectMaleVector(): Int {
    val vectors = listOf(
        R.drawable.ic_m1,
        R.drawable.ic_m2,
        R.drawable.ic_m3,
        R.drawable.ic_m4,
        R.drawable.ic_m5
    ).shuffled()
    return vectors[0]
}

fun groupOfPeople(): List<People> {
    val arrayList = ArrayList<People>()
    arrayList.add(
        People(
            firstName = "Alnoor",
            secondName = "Abdo Algader",
            place = "Home",
            time = "2020-07-01 15:59",
            note = "this element for test proposes",
            gender = "male",
            avatar = selectMaleVector()
        )
    )
    arrayList.add(
        People(
            firstName = "Mona",
            secondName = "Yahia",
            place = "Home",
            time = "2020-07-01 15:59",
            note = "this element for test proposes",
            gender = "female",
            avatar = selectFemaleVector()
        )
    )
    arrayList.add(
        People(
            firstName = "Tareg",
            secondName = "Zain",
            place = "Home",
            time = "2020-07-01 15:59",
            note = "this element for test proposes",
            gender = "male",
            avatar = selectMaleVector()
        )
    )
    arrayList.add(
        People(
            firstName = "Eshraga",
            secondName = "Khaled",
            place = "Home",
            time = "2020-07-01 15:59",
            note = "this element for test proposes",
            gender = "female",
            avatar = selectFemaleVector()
        )
    )
    arrayList.add(
        People(
            firstName = "Alhade",
            secondName = "Abase",
            place = "Home",
            time = "2020-07-01 15:59",
            note = "this element for test proposes",
            gender = "male",
            avatar = selectMaleVector()
        )
    )
    arrayList.add(
        People(
            firstName = "Rian",
            secondName = "Ibrahim",
            place = "Home",
            time = "2020-07-01 15:59",
            note = "this element for test proposes",
            gender = "female",
            avatar = selectFemaleVector()
        )
    )
    arrayList.add(
        People(
            firstName = "Hosham",
            secondName = "Mohamed",
            place = "Home",
            time = "2020-07-01 15:59",
            note = "this element for test proposes",
            gender = "male",
            avatar = selectMaleVector()
        )
    )
    arrayList.add(
        People(
            firstName = "Tanzeel",
            secondName = "Mokhtar",
            place = "Home",
            time = "2020-07-01 15:59",
            note = "this element for test proposes",
            gender = "female",
            avatar = selectFemaleVector()
        )
    )
    arrayList.add(
        People(
            firstName = "Yassir",
            secondName = "Fadule",
            place = "Home",
            time = "2020-07-01 15:59",
            note = "this element for test proposes",
            gender = "male",
            avatar = selectMaleVector()
        )
    )
    arrayList.add(
        People(
            firstName = "Sara",
            secondName = "Mostafa",
            place = "Home",
            time = "2020-07-01 15:59",
            note = "this element for test proposes",
            gender = "female",
            avatar = selectFemaleVector()
        )
    )
    arrayList.add(
        People(
            firstName = "Ahmed",
            secondName = "Logman",
            place = "Home",
            time = "2020-07-01 15:59",
            note = "this element for test proposes",
            gender = "male",
            avatar = selectMaleVector()
        )
    )
    arrayList.add(
        People(
            firstName = "Tafakur",
            secondName = "Musa",
            place = "Home",
            time = "2020-07-01 15:59",
            note = "this element for test proposes",
            gender = "female",
            avatar = selectFemaleVector()
        )
    )
    arrayList.add(
        People(
            firstName = "Adnan",
            secondName = "Yossif",
            place = "Home",
            time = "2020-07-01 15:59",
            note = "this element for test proposes",
            gender = "male",
            avatar = selectMaleVector()
        )
    )
    arrayList.add(
        People(
            firstName = "Wala",
            secondName = "Salah",
            place = "Home",
            time = "2020-07-01 15:59",
            note = "this element for test proposes",
            gender = "female",
            avatar = selectFemaleVector()
        )
    )
    arrayList.add(
        People(
            firstName = "Mazin",
            secondName = "Joda",
            place = "Home",
            time = "2020-07-01 15:59",
            note = "this element for test proposes",
            gender = "male",
            avatar = selectMaleVector()
        )
    )
    arrayList.add(
        People(
            firstName = "Assma",
            secondName = "Babiker",
            place = "Home",
            time = "2020-07-01 15:59",
            note = "this element for test proposes",
            gender = "female",
            avatar = selectFemaleVector()
        )
    )
    arrayList.add(
        People(
            firstName = "Yones",
            secondName = "Khaled",
            place = "Home",
            time = "2020-07-01 15:59",
            note = "this element for test proposes",
            gender = "male",
            avatar = selectMaleVector()
        )
    )
    arrayList.add(
        People(
            firstName = "Rassh",
            secondName = "Monzer",
            place = "Home",
            time = "2020-07-01 15:59",
            note = "this element for test proposes",
            gender = "female",
            avatar = selectFemaleVector()
        )
    )
    arrayList.add(
        People(
            firstName = "Musa",
            secondName = "Abdo Allah",
            place = "Home",
            time = "2020-07-01 15:59",
            note = "this element for test proposes",
            gender = "male",
            avatar = selectMaleVector()
        )
    )
    arrayList.add(
        People(
            firstName = "Reem",
            secondName = " Ali",
            place = "Home",
            time = "2020-07-01 15:59",
            note = "this element for test proposes",
            gender = "female",
            avatar = selectFemaleVector()
        )
    )
    arrayList.add(
        People(
            firstName = "Rian",
            secondName = "Alsaid",
            place = "Home",
            time = "2020-07-01 15:59",
            note = "this element for test proposes",
            gender = "male",
            avatar = selectMaleVector()
        )
    )
    arrayList.add(
        People(
            firstName = "Montaha",
            secondName = "Alsadige",
            place = "Home",
            time = "2020-07-01 15:59",
            note = "this element for test proposes",
            gender = "female",
            avatar = selectFemaleVector()
        )
    )
    arrayList.add(
        People(
            firstName = "yassir",
            secondName = "Alasdige",
            place = "Home",
            time = "2020-07-01 15:59",
            note = "this element for test proposes",
            gender = "male",
            avatar = selectMaleVector()
        )
    )
    arrayList.add(
        People(
            firstName = "Salwa",
            secondName = "Mosab",
            place = "Home",
            time = "2020-07-01 15:59",
            note = "this element for test proposes",
            gender = "female",
            avatar = selectFemaleVector()
        )
    )
    arrayList.add(
        People(
            firstName = "Salah",
            secondName = "Khatir",
            place = "Home",
            time = "2020-07-01 15:59",
            note = "this element for test proposes",
            gender = "male",
            avatar = selectMaleVector()
        )
    )
    arrayList.add(
        People(
            firstName = "Mozan",
            secondName = "Osman",
            place = "Home",
            time = "2020-07-01 15:59",
            note = "this element for test proposes",
            gender = "female",
            avatar = selectFemaleVector()
        )
    )
    Log.i(PeopleViewModel.TAG, "groupOfPeople: ${arrayList.size}")
    arrayList.toList().shuffled()
    return arrayList
}
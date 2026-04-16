package com.iprism.swenhealth.utils

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale

object DateTimeUtils {

    var dateMonthYear: String = ""


    fun getDate(dateTxt: TextView, isPreviousCalendar: Boolean): String {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            dateTxt.context,
            { _: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                c.set(year, monthOfYear , dayOfMonth)

                val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                val formattedDate = sdf.format(c.time)
                dateTxt.text = formattedDate
                dateMonthYear = "$year-${monthOfYear + 1}-$dayOfMonth"
            },
            year, month, day
        )

        if (isPreviousCalendar) {
            datePickerDialog.datePicker.maxDate = c.timeInMillis
        } else {
            datePickerDialog.datePicker.minDate = c.timeInMillis
        }
        datePickerDialog.show()

        return dateMonthYear
    }

    @SuppressLint("SetTextI18n")
    fun getTime(timeTxt: TextView) {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(
            timeTxt.context,
            { _: TimePicker, hourOfDay: Int, selectedMinute: Int ->

//                val (roundedHour24, roundedMinute) = when {
//                    selectedMinute < 15 -> Pair(hourOfDay, 0)
//                    selectedMinute in 15..44 -> Pair(hourOfDay, 30)
//                    else -> Pair((hourOfDay + 1) % 24, 0)
//                }

                val amPm: String
                var hourToShow = hourOfDay
                when {
                    hourToShow == 0 -> {
                        amPm = "AM"
                        hourToShow = 12
                    }

                    hourToShow == 12 -> amPm = "PM"
                    hourToShow > 12 -> {
                        amPm = "PM"
                        hourToShow -= 12
                    }

                    else -> amPm = "AM"
                }

                val formattedTime = String.format(
                    Locale.getDefault(),
                    "%02d:%02d %s",
                    hourToShow,
                    selectedMinute,
                    amPm
                )

                timeTxt.text = formattedTime
            },
            hour, minute, false
        )
        timePickerDialog.show()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getDate(
        dateTxt: TextView,
        ageTxt: TextView,
        isPreviousCalendar: Boolean
    ): String {

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            dateTxt.context,
            { _: DatePicker, yearSelected: Int, monthOfYear: Int, dayOfMonth: Int ->

                c.set(yearSelected, monthOfYear, dayOfMonth)

                val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                val formattedDate = sdf.format(c.time)

                dateTxt.text = formattedDate

                dateMonthYear = "$yearSelected-${monthOfYear + 1}-$dayOfMonth"


                try {
                    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                    val birthDate = LocalDate.parse(formattedDate, formatter)
                    val currentDate = LocalDate.now()
                    val age = Period.between(birthDate, currentDate).years

                    ageTxt.text = age.toString()
                } catch (_: Exception) { }
            },
            year, month, day
        )

        if (isPreviousCalendar) {
            datePickerDialog.datePicker.maxDate = c.timeInMillis
        } else {
            datePickerDialog.datePicker.minDate = c.timeInMillis
        }

        datePickerDialog.show()
        return dateMonthYear
    }


}

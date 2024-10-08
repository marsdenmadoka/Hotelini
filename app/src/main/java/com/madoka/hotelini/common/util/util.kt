package com.madoka.hotelini.common.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


/*@RequiresApi(Build.VERSION_CODES.O)*/
val currentDate: String = SimpleDateFormat("yyyy-MM-dd",
    Locale.getDefault()).format(Date())




/*@RequiresApi(Build.VERSION_CODES.O)
val currentDate : LocalDate = LocalDate.now()

@RequiresApi(Build.VERSION_CODES.O)
val formattedDate: String = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))*/


/*Assigning Locale.getDefault() to a final static field is suspicious; this code will not work correctly if the user changes locale while the app is running More
Inspection info: Assigning Locale.getDefault() to a constant is suspicious, because the locale can change while the app is running.*/
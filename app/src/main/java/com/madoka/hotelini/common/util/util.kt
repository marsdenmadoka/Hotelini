package com.madoka.hotelini.common.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale


//getting current date
//@RequiresApi(Build.VERSION_CODES.O)
val currentDate: String = SimpleDateFormat("yyyy-MM-dd",
    Locale.getDefault()).format(Date())

    //LocalDate = LocalDate.now()

/*
@RequiresApi(Build.VERSION_CODES.O)
val currentDate : LocalDate = LocalDate.now()

@RequiresApi(Build.VERSION_CODES.O)
val formattedDate: String =
    currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))*/
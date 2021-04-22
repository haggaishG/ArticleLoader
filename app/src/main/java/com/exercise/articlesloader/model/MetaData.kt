package com.exercise.articlesloader.model

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class MetaData(val creationTime: String, val updateTime: String) {
        //        {
        //            "creationTime": "2017-03-14T06:44:19.000Z",
        //                "updateTime": "2017-06-19T14:29:25.000Z"
        //        }

    companion object {
        @JvmStatic
        fun formatDate(date: String?): String? {
            //"2017-03-14T06:44:19.000Z",
            var date = date
            var spf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX")
            var newDate: Date? = null
            try {
                newDate = spf.parse(date)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            spf = SimpleDateFormat("dd MMM, yyyy")
            date = spf.format(newDate)
            return date
        }
    }

}
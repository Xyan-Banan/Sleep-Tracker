package com.example.android.trackmysleepquality.sleeptracker

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.android.trackmysleepquality.convertDurationToFormatted
import com.example.android.trackmysleepquality.convertNumericQualityToImage
import com.example.android.trackmysleepquality.convertNumericQualityToString
import com.example.android.trackmysleepquality.database.SleepNight

@BindingAdapter("sleepImage")
fun ImageView.setSleepImage(item: SleepNight?) {
    Log.i("Bind image", "Going to bind image")
    item?.let {
        setImageResource(convertNumericQualityToImage(item.sleepQuality))
        Log.i("Binding image", "item: $item")
    }
}

@BindingAdapter("sleepDurationFormatted")
fun TextView.setSleepDurationFormatted(item: SleepNight?) {
    Log.i("Bind duration", "Going to bind duration")
    item?.let {
        text = convertDurationToFormatted(item.startTimeMilli, item.endTimeMilli, context.resources)
        Log.i("Binding duration", "item: $item")
    }
}

@BindingAdapter("sleepQualityString")
fun TextView.setSleepQualityString(item: SleepNight?) {
    Log.i("Bind quality", "Going to bind quality")
    item?.let {
        text = convertNumericQualityToString(item.sleepQuality, context.resources)
        Log.i("Binding quality", "item: $item")
    }
}
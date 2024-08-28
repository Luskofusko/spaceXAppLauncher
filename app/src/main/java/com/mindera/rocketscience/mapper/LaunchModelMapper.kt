package com.mindera.rocketscience.mapper

import com.mindera.rocketscience.domain.dto.LaunchDto
import com.mindera.rocketscience.model.LaunchModel
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.temporal.ChronoUnit
import java.util.Calendar
import java.util.Date

fun LaunchDto.toPresentation(id: Int, timeInMillis: Long): LaunchModel {
    return LaunchModel(
        missionName,
        launchTimestamp,
        mapDate(),
        mapTime(),
        rocketName,
        rocketType,
        missionPatchImageUrl,
        launchSuccessful,
        calculateDaysLeft(timeInMillis),
        links.toPresentation(),
        id
    )
}

fun List<LaunchDto>.toPresentation(timeInMillis: Long) = mapIndexed { index, launchDto ->
    launchDto.toPresentation(
        index,
        timeInMillis
    )
}

private fun dateToCalendar(date: Date): Calendar{
    val calendar = Calendar.getInstance()
    calendar.time = date
    return calendar
}

private fun LaunchDto.mapDate(): String {
    val calendar = dateToCalendar(Date(launchTimestamp))
    return "${calendar.get(Calendar.YEAR)}/${calendar.get(Calendar.MONTH)}/${calendar.get(Calendar.DAY_OF_MONTH)}"
}

private fun LaunchDto.mapTime(): String {
    val calendar = dateToCalendar(Date(launchTimestamp))
    return "${calendar.get(Calendar.HOUR_OF_DAY)}:${calendar.get(Calendar.MINUTE)}"
}

private fun LaunchDto.calculateDaysLeft(timeInMillis: Long): Long {
    val launchDate: LocalDate =
        Instant.ofEpochMilli(launchTimestamp).atZone(ZoneId.systemDefault()).toLocalDate()
    val currentDate: LocalDate =
        Instant.ofEpochMilli(timeInMillis).atZone(ZoneId.systemDefault()).toLocalDate()
    val daysLeft = ChronoUnit.DAYS.between(currentDate, launchDate)
    return daysLeft

}
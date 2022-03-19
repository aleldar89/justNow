fun agoText(seconds: Int): String {

    val time = when (seconds) {
        in 0..60 -> "только что"
        in 61..3_600 -> minutesText(seconds)
        in 3_601..86_400 -> hoursText(seconds)
        in 86_401..172_800 -> "сегодня"
        in 172_801..259_200 -> "вчера"
        else -> "давно"
    }
    return "был(а) $time"

}

fun minutesText(seconds: Int): String {
    val secondsToMinutes = seconds/60
    val minutes =
        when {
            secondsToMinutes == 1 || secondsToMinutes % 10 == 1 && secondsToMinutes != 11 -> "$secondsToMinutes минуту назад"
            secondsToMinutes % 5 == 0 || secondsToMinutes % 10 in 6..9 -> "$secondsToMinutes минут назад"
            else -> "$secondsToMinutes минуты назад"
        }
    return minutes
}

fun hoursText(seconds: Int): String {
    val hours =
        when (val secondsToHours = seconds/3600) {
            1, 21 -> "$secondsToHours час назад"
            in 2..4, in 22..24 -> "$secondsToHours часа назад"
            else -> "$secondsToHours часов назад"
        }
    return hours
}
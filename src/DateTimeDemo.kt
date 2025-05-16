import java.time.*

fun main() {
    // 需要时区：ZonedDateTime
    // 不需要时区：LocalDate/LocalTime/LocalDateTime

    val localDateTime = LocalDateTime.now() // 本地日期时间
    val systemZoneId = ZoneId.systemDefault() // 系统默认时区ID
    val zonedDateTime = localDateTime.atZone(systemZoneId) // 带时区的日期时间
    println("localDateTime=$localDateTime, ${localDateTime.year}-${localDateTime.monthValue}-${localDateTime.dayOfMonth} ${localDateTime.hour}:${localDateTime.minute}:${localDateTime.second}")
    println("systemZoneId=$systemZoneId, zonedDateTime=$zonedDateTime")

    println("\n\n")
    val newYorkZoneId = ZoneId.of("America/New_York")
    val newYorkDateTime1 = zonedDateTime.withZoneSameInstant(newYorkZoneId)
    val newYorkDateTime2 = ZonedDateTime.now(newYorkZoneId)
    println("newYorkDateTime1=$newYorkDateTime1, newYorkDateTime2=$newYorkDateTime2")
    val newYorkLocalDateTime1 = newYorkDateTime1.toLocalDateTime()
    val newYorkLocalDateTime2 = LocalDateTime.now(newYorkZoneId)
    println("newYorkLocalDateTime1=$newYorkLocalDateTime1, newYorkLocalDateTime2=$newYorkLocalDateTime2")
    val newYorkEpochSecond1 = Instant.now(Clock.system(newYorkZoneId)).epochSecond
    val newYorkEpochSecond2 = newYorkDateTime2.toEpochSecond()
    println("newYorkEpochSecond1=$newYorkEpochSecond1, newYorkEpochSecond2=$newYorkEpochSecond2")

}
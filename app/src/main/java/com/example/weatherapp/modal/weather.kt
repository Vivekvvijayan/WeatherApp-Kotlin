data class WeatherResponse(
    val weather:List<Weather>,
    val sys:Sys,
    val main:Main,
    val name:String
)
data class Sys(
    val country:String
)
data class Weather(
    val id:Int,
    val main:String,
    val description:String
)

data class Main(
    val temp: Double,
    val humidity: Int,
    var pressure:Int
)
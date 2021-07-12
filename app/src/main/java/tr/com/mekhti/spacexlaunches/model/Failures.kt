import com.google.gson.annotations.SerializedName

data class Failures (

	@SerializedName("time") val time : Int,
	@SerializedName("altitude") val altitude : String,
	@SerializedName("reason") val reason : String
)
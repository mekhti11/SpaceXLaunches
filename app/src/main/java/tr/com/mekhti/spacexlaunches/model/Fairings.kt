import com.google.gson.annotations.SerializedName

data class Fairings (

	@SerializedName("reused") val reused : Boolean,
	@SerializedName("recovery_attempt") val recovery_attempt : Boolean,
	@SerializedName("recovered") val recovered : Boolean,
	@SerializedName("ships") val ships : List<String>
)
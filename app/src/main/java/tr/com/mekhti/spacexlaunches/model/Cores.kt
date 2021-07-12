import com.google.gson.annotations.SerializedName

data class Cores (

	@SerializedName("core") val core : String,
	@SerializedName("flight") val flight : Int,
	@SerializedName("gridfins") val gridfins : Boolean,
	@SerializedName("legs") val legs : Boolean,
	@SerializedName("reused") val reused : Boolean,
	@SerializedName("landing_attempt") val landing_attempt : Boolean,
	@SerializedName("landing_success") val landing_success : String,
	@SerializedName("landing_type") val landing_type : String,
	@SerializedName("landpad") val landpad : String
)
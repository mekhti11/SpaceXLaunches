import com.google.gson.annotations.SerializedName

data class Links (

	@SerializedName("patch") val patch : Patch,
	@SerializedName("reddit") val reddit : Reddit,
	@SerializedName("flickr") val flickr : Flickr,
	@SerializedName("presskit") val presskit : String,
	@SerializedName("webcast") val webcast : String,
	@SerializedName("youtube_id") val youtube_id : String,
	@SerializedName("article") val article : String,
	@SerializedName("wikipedia") val wikipedia : String
)
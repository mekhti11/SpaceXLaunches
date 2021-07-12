package tr.com.mekhti.spacexlaunches.model

import com.google.gson.annotations.SerializedName

data class Docs (
    @SerializedName("docs") val docs : ArrayList<Launch>,
    @SerializedName("totalDocs") val totalDocs : Int,
    @SerializedName("limit") val limit : Int,
    @SerializedName("totalPages") val totalPages : Int,
    @SerializedName("page") val page : Int,
    @SerializedName("pagingCounter") val pagingCounter : Int,
    @SerializedName("hasPrevPage") val hasPrevPage : Boolean,
    @SerializedName("hasNextPage") val hasNextPage : Boolean,
    @SerializedName("prevPage") val prevPage : Int,
    @SerializedName("nextPage") val nextPage : Int
)
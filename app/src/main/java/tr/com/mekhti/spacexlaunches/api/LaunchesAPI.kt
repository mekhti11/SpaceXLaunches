package tr.com.mekhti.spacexlaunches.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import tr.com.mekhti.spacexlaunches.model.Docs
import tr.com.mekhti.spacexlaunches.model.Launch

interface LaunchesAPI {
    @GET("/v4/launches")
    fun getLaunches(): Call<ArrayList<Launch>>

    @GET("launches/query")
    fun getLaunchesPagination(@Query("page")page : Int,
                              @Query("limit")limit:Int):Call<Docs>
}
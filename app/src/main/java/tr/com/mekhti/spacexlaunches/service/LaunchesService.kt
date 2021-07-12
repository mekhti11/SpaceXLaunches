package tr.com.mekhti.spacexlaunches.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tr.com.mekhti.spacexlaunches.api.LaunchesAPI

class LaunchesService {
    private val BASEURL = "https://api.spacexdata.com"
    private val api : LaunchesAPI = Retrofit.Builder()
        .baseUrl(BASEURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(LaunchesAPI::class.java)

    fun getApiService(): LaunchesAPI {

        return api
    }

//    fun getLaunches():ArrayList<Launch> {
//        return api.getLaunches()
//    }
//
//
//
//    fun getLaunchesPagination(page:Int,limit:Int):Docs{
//        return api.getLaunchesPagination(page, limit)
//    }
}
package tr.com.mekhti.spacexlaunches.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tr.com.mekhti.spacexlaunches.model.Launch
import tr.com.mekhti.spacexlaunches.service.LaunchesService

class LaunchesViewModel : ViewModel(){


    private val countriesService = LaunchesService()

    val launches = MutableLiveData<ArrayList<Launch>>()
    val loading = MutableLiveData<Boolean>()

    init {
        fetchLaunches()
    }

    private fun fetchLaunches(){
        loading.value = true

        countriesService.getApiService().getLaunches().enqueue(object : Callback<ArrayList<Launch>> {
            override fun onFailure(call: Call<ArrayList<Launch>>, t: Throwable) {
                Log.d("FETCH","ERROR")
            }

            override fun onResponse(
                call: Call<ArrayList<Launch>>,
                response: Response<ArrayList<Launch>>
            ) {
                if (response.code()==200){
                    val data = response.body()
                    data?.forEach { it:Launch? ->it?.formatYear() }
                    launches.value = data
                }
            }

        })
    }
}
package tr.com.mekhti.spacexlaunches.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import tr.com.mekhti.spacexlaunches.R
import tr.com.mekhti.spacexlaunches.listener.LaunchClickListener
import tr.com.mekhti.spacexlaunches.model.Launch
import tr.com.mekhti.spacexlaunches.viewmodel.LaunchesViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : LaunchesViewModel
    private lateinit var  launchListAdapter : LaunchListAdapter
    private var allData : ArrayList<Launch> = arrayListOf()
    private var list : ArrayList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(LaunchesViewModel::class.java)

        launchListAdapter = LaunchListAdapter(arrayListOf(), applicationContext , object : LaunchClickListener {
            override fun onClick(launch: Launch) {
                val i = Intent(applicationContext,DetailActivity::class.java)
                val b = Bundle()
                b.putString("imgUrl",launch.links.patch.large)
                b.putString("detail",launch.details)
                b.putString("name",launch.name)
                b.putInt("date",launch.date_unix)
                i.putExtras(b)
                startActivity(i)
            }
        })

        launchesRV.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = launchListAdapter
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.launches.observe(this, Observer { launches ->
            launchesRV.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
            launches?.let {
                launchListAdapter.updateCountries(it)
                allData = it
            }

            list.add("All")
            for ( i in launches[0].year..launches[launches.size-1].year){
                list.add(i.toString())
            }

            val adapter = ArrayAdapter(applicationContext,R.layout.support_simple_spinner_dropdown_item,list)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    filterData(position)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }
        })

        viewModel.loading.observe(this, Observer { isloading ->
            isloading?.let {
                progressBar.visibility = if (it) View.VISIBLE else View.GONE
                if (it){
                    errorTxt.visibility = View.INVISIBLE
                    launchesRV.visibility = View.INVISIBLE
                }
            }
        })
    }

    private fun filterData(position: Int) {
        val tmpData : ArrayList<Launch>
        if(list[position].equals(list[0])){
            tmpData = allData
        }else{
            tmpData = ArrayList(allData.filter { it.year == list[position].toInt() })
        }

        launchListAdapter.updateCountries(tmpData)
    }
}

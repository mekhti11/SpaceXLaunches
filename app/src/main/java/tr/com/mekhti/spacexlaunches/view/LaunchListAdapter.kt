package tr.com.mekhti.spacexlaunches.view

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.launch_item.view.*
import tr.com.mekhti.spacexlaunches.R
import tr.com.mekhti.spacexlaunches.listener.LaunchClickListener
import tr.com.mekhti.spacexlaunches.model.Launch

class LaunchListAdapter (private var launches:ArrayList<Launch>,
                         private var context : Context,
                        private var listener : LaunchClickListener) :
    RecyclerView.Adapter<LaunchListAdapter.LaunchViewHolder>(){

    fun updateCountries(data:ArrayList<Launch>){
        launches.clear()
        launches.addAll(data)
        notifyDataSetChanged()
    }

    class LaunchViewHolder(view: View): RecyclerView.ViewHolder(view){

        var container : ConstraintLayout = view.container
        var launchName: TextView = view.name
        var launchDetail: TextView = view.detail
        var launchImg: ImageView = view.img
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LaunchViewHolder(
        LayoutInflater
            .from(parent.context)
            .inflate(R.layout.launch_item , parent , false)
    )

    override fun getItemCount() =  launches.size

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        val launch = launches[position]
        Glide.with(context).load(launch.links.patch.small).into(holder.launchImg)
        (launch.name + " : " + launch.year).also { holder.launchName.text = it }
        holder.launchDetail.text = launch.details

        holder.container.setOnClickListener { listener.onClick(launch) }
    }
}
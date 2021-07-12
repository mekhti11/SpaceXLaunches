package tr.com.mekhti.spacexlaunches.listener

import tr.com.mekhti.spacexlaunches.model.Launch

interface LaunchClickListener {
    fun onClick(launch:Launch)
}
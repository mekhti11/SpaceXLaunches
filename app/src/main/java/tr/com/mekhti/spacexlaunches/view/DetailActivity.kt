package tr.com.mekhti.spacexlaunches.view

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import tr.com.mekhti.spacexlaunches.R
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val bundle :Bundle ?=intent.extras
        val imageUrl = bundle?.getString("imgUrl")
        val n = bundle?.getString("name")
        val d = bundle?.getString("detail")
        val  date_unix = bundle?.getInt("date")

        date_unix?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val d =  Instant.ofEpochSecond(it.toLong())
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime()
                date.text = d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString()
            } else {
                TODO("VERSION.SDK_INT < O")
            }
        }

        Glide.with(this).load(imageUrl).into(img)
        detail.text = d
        name.text = n
    }
}
package com.example.tablayout001

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.tablayout001.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding

    private val fragList = listOf(
        Fragment1.newInstance(),
        Fragment2.newInstance(),
        Fragment3.newInstance()
    )
    private val fragText = listOf(
        "Музыка",
        "Фотографии",
        "Видео"
    )
    private val fragIcon = listOf(
        R.drawable.ic_baseline_library_music_24,
        R.drawable.ic_baseline_image_24,
        R.drawable.ic_baseline_video_library_24
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val adapter = VpAdapter(this, fragList)
        bind.vp2.adapter = adapter
        TabLayoutMediator(bind.tabV, bind.vp2) {
            tab, pos ->
            //tab.text = fragText[pos]
            tab.icon = ContextCompat.getDrawable(this, fragIcon[pos] )
        }.attach()



//        supportFragmentManager.
//        beginTransaction().replace(R.id.placeHolder, fragList[0]).commit()
//        bind.tabV.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                supportFragmentManager.
//                    beginTransaction().replace(R.id.placeHolder, fragList[tab?.position!!]).commit()
//                Toast.makeText(this@MainActivity, "Выбран раздел ${tab?.text} Pos ${tab?.position} ", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//                Toast.makeText(this@MainActivity, "Повторно выбран раздел ${tab?.text}", Toast.LENGTH_SHORT).show()
//
//            }
//
//        })
    }
}
package mx.com.earr.earthquakemonitorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import mx.com.earr.earthquakemonitorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.eqRecycler.layoutManager = LinearLayoutManager(this)

        val eqList = mutableListOf<Earthquake>()
        eqList.add(Earthquake("1", "MX", 5.8, 23485955, -102.45, 23.90))
        eqList.add(Earthquake("1", "AR", 5.8, 23485955, -102.45, 23.90))
        eqList.add(Earthquake("1", "BR", 5.8, 23485955, -102.45, 23.90))
        eqList.add(Earthquake("1", "IT", 5.8, 23485955, -102.45, 23.90))
        eqList.add(Earthquake("1", "JP", 5.8, 23485955, -102.45, 23.90))
        eqList.add(Earthquake("1", "CH", 5.8, 23485955, -102.45, 23.90))

        val adapter = EarthquakeAdapter()
        binding.eqRecycler.adapter = adapter
        adapter.submitList(eqList)

        if (eqList.isEmpty()) {
            binding.eqEmptyView.visibility = View.VISIBLE
        } else {
            binding.eqEmptyView.visibility = View.GONE
        }

    }
}
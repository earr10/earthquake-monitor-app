package mx.com.earr.earthquakemonitorapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class EarthquakeAdapter :
    ListAdapter<Earthquake, EarthquakeAdapter.EarthquakeViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Earthquake>() {
        override fun areItemsTheSame(oldItem: Earthquake, newItem: Earthquake): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Earthquake, newItem: Earthquake): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EarthquakeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.eq_list_item, parent, false)
        return EarthquakeViewHolder(view)
    }

    override fun onBindViewHolder(holder: EarthquakeViewHolder, position: Int) {
        val earthquake = getItem(position)
        holder.magnitudeText.text = earthquake.magnitude.toString()
        holder.placeText.text = earthquake.place.toString()
    }

    inner class EarthquakeViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val magnitudeText = view.findViewById<TextView>(R.id.eqMagnitudeText)
        val placeText = view.findViewById<TextView>(R.id.eqPlaceText)
    }
}
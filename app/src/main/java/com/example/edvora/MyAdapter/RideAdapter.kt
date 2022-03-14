package com.example.edvora.MyAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.edvora.Model.Rides
import com.example.edvora.databinding.RidesListBinding

class RideAdapter : RecyclerView.Adapter<RideAdapter.MyViewHolder>() {

    private var myList = emptyList<Rides>()

    inner class MyViewHolder(val binding: RidesListBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            RidesListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        myList[position].let {
            holder.binding.cityName.text = it.city
            holder.binding.stateName.text = it.state
            holder.binding.rideId.text = it.id.toString()
            holder.binding.originStation.text = it.originStationCode.toString()
            holder.binding.stationPath.text = it.stationPath.toString()
            holder.binding.date.text = it.date
            holder.binding.distance.text =
                (Math.abs(it.destinationStationCode - it.originStationCode)).toString()

            Glide.with(holder.itemView.context)
                .load(it.mapUrl)
                .centerCrop()
                .into(holder.binding.imageView)
        }
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    fun setData(list: List<Rides>) {
        myList = list
        notifyDataSetChanged()
    }
}
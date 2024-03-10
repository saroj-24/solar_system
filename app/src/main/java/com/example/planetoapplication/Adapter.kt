package com.example.planetoapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.planetoapplication.databinding.ViewBinding



class Adapter(var planet:List<PlanetData>):RecyclerView.Adapter<Adapter.myViewHolder>(){

    class myViewHolder(val itemViewBinding:ViewBinding): RecyclerView.ViewHolder(itemViewBinding.root) {
        var title = itemViewBinding.title
        var planetimg = itemViewBinding.planetImg
        var galaxy= itemViewBinding.galaxy
        var distance= itemViewBinding.distance
        var gravity= itemViewBinding.gravity

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {

        return myViewHolder(ViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }


    override fun getItemCount(): Int {
        return  planet.size
    }


    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        var dummyImage :Int?= null

        holder.itemViewBinding.title.text= planet[position].title
      //  holder.title.text=planet[position].title
        holder.itemViewBinding.galaxy.text = planet[position].galaxy
       // holder.galaxy.text=planet[position].galaxy
        holder.itemViewBinding.distance.text =  planet[position].distance + " mm of km"

       // holder.distance.text=planet[position].distance+" m Km"
        holder.itemViewBinding.gravity.text =  planet[position].gravity + " m/s"
            //  holder.gravity.text = planet[position].title+" m/s"

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context,SolarDetailsActivity::class.java)
            intent.putExtra("planet",planet[position])
            intent.putExtra("planetImage",dummyImage)
            holder.itemView.context.startActivity(intent)

        }

        when (planet[position].title!!.toLowerCase()) {
            "mars" -> {
                dummyImage = R.drawable.mars
            }
            "neptune" -> {
                dummyImage = R.drawable.neptune
            }
            "earth" -> {
                dummyImage = R.drawable.earth
            }
            "moon" -> {
                dummyImage = R.drawable.moon
            }
            "venus" -> {
                dummyImage = R.drawable.venus
            }
            "jupiter" -> {
                dummyImage = R.drawable.jupiter
            }
            "saturn" -> {
                dummyImage = R.drawable.saturn
            }
            "uranus" -> {
                dummyImage = R.drawable.uranus
            }
            "mercury" -> {
                dummyImage = R.drawable.mercury
            }
            "sun" -> {
                dummyImage = R.drawable.sun
            }
            "astriods" ->{
                dummyImage=R.drawable.asteroids
            }
        }
        holder.itemViewBinding.planetImg.setImageResource(dummyImage!!)

    }
}
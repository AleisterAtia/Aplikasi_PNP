import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.fadhiil2010.latihan13.Modul.ModelGaleri

import com.fadhiil2010.latihan13.R
import com.fadhiil2010.latihan13.RecycleViewCard

class MovieAdapter constructor(
    private val getActivity: RecycleViewCard,
    private val movieList: List<ModelGaleri>,
    private val itemClickListener: (Int) -> Unit) :
    RecyclerView.Adapter<MovieAdapter.MyViewHolder>()
{
    class MyViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        val txtMovie : TextView = itemView.findViewById(R.id.txtMovie)
        val imgMovie : ImageView = itemView.findViewById(R.id.imgMovie)
        val cardView : CardView = itemView.findViewById(R.id.cardView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_foto, parent, false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtMovie.text = movieList[position].title
        holder.imgMovie.setImageResource(movieList[position].image)

//        holder.cardView.setOnClickListener(){
//            Toast.makeText(
//                getActivity, movieList[position].title,
//                Toast.LENGTH_SHORT
//            ).show()
//        }
        holder.itemView.setOnClickListener {
            itemClickListener(position)
        }

    }
}
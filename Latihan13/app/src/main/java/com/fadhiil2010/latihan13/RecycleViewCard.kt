package com.fadhiil2010.latihan13

import MovieAdapter
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fadhiil2010.latihan13.Modul.ModelGaleri

class RecycleViewCard : AppCompatActivity() {

    private var recyclerView : RecyclerView? = null
    private var movieAdapter : MovieAdapter? = null
    private var movieList = mutableListOf<ModelGaleri>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycle_view_card)

        movieList = ArrayList()
        recyclerView = findViewById(R.id.rvMovieList) as RecyclerView

        movieAdapter = MovieAdapter(this@RecycleViewCard, movieList) { position ->
            // Menampilkan dialog gambar detail ketika item di-klik
            showDetailDialog(position)
        }
        
        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(this, 2)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = movieAdapter



        prepareMovieList()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun showDetailDialog(position: Int) {
        val intent = Intent(this, DetailPage::class.java) // Pastikan kelas "PhotoDetail" benar
        intent.putExtra("imageResId", movieList[position].image) // Mengirim imageResId ke Activity PhotoDetail
        intent.putExtra("title", movieList[position].title)
        startActivity(intent)
    }

    private fun prepareMovieList() {
        var movie = ModelGaleri("Avatar", R.drawable.avatar)
        movieList.add(movie)

        movie = ModelGaleri("Batman", R.drawable.batman)
        movieList.add(movie)
        movie = ModelGaleri("End Game", R.drawable.end_game)
        movieList.add(movie)
        movie = ModelGaleri("Venom", R.drawable.venom)
        movieList.add(movie)
        movie = ModelGaleri("Spiderman", R.drawable.spider_man)
        movieList.add(movie)
        movie = ModelGaleri("Inception", R.drawable.inception)
        movieList.add(movie)


        movieAdapter!!.notifyDataSetChanged()
    }
}
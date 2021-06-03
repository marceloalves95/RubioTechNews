package br.com.rubiotechnews.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import br.com.rubiotechnews.data.remote.model.Artigo
import br.com.rubiotechnews.databinding.FeedAdapterBinding
import com.bumptech.glide.Glide
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

/**
 * Created by RubioAlves on 03/06/2021
 *
 */
class FeedAdapter(private val lista: List<Artigo>) : RecyclerView.Adapter<FeedAdapter.FeedAdapterViewHolder>() {

    inner class FeedAdapterViewHolder(private val itemBinding: FeedAdapterBinding) : RecyclerView.ViewHolder(itemBinding.root) {

        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(artigo: Artigo) {

            with(artigo){

                Glide.with(itemView.context).load(urlToImage).into(itemBinding.imageArtigo)
                itemBinding.titulo.text = title
                itemBinding.autor.text = author as String
                itemBinding.fonte.text = source.nome
                itemBinding.dataPublicacao.text = initDatas(publishedAt)

            }

        }

        @RequiresApi(Build.VERSION_CODES.O)
        private fun initDatas(data: String): String {

            val pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'"
            val dtf = DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH)
            val localDate = LocalDate.parse(data, dtf)

            val dia = localDate.dayOfMonth.toString()
            val mes = localDate.month
            val ano = localDate.year

            val mesReduzido = DateTimeFormatter.ofPattern("MMM")
            val mesCompleto = mesReduzido.format(mes)

            return "$dia de $mesCompleto de $ano"


        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedAdapterViewHolder {

        val itemBinding = FeedAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FeedAdapterViewHolder(itemBinding)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: FeedAdapterViewHolder, position: Int) {

        holder.bind(lista[position])
    }

    override fun getItemCount(): Int = lista.size

}
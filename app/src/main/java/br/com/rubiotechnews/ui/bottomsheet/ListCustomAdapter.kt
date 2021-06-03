package br.com.rubiotechnews.ui.bottomsheet

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import br.com.rubiotechnews.R


/**
 * Created by RubioAlves on 02/06/2021
 */
class ListCustomAdapter(private val lista:Array<String>, private val imagens:Array<Int>, private val context:Activity, id_list:Int):ArrayAdapter<String>(context, id_list, lista) {

    class ViewHolder{
        lateinit var tema_claro:TextView
        lateinit var light_mode:ImageView
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = context.layoutInflater
        val rowView:View = inflater.inflate(R.layout.list_adapter, null, true)

        val viewHolder = ViewHolder()
        viewHolder.tema_claro = rowView.findViewById(R.id.tema_claro) as TextView
        viewHolder.light_mode = rowView.findViewById(R.id.light_mode) as ImageView

        viewHolder.tema_claro.text = lista[position]
        viewHolder.light_mode.setImageResource(imagens[position])

        return rowView
    }


}
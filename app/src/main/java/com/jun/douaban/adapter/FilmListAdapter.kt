package com.jun.douaban.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.jun.douaban.R
import com.jun.douaban.entity.Film
import kotlinx.android.synthetic.main.list_item_film.view.*

class FilmListAdapter : BaseAdapter {

    var context: Context? = null
    var list: List<Film.SubjectsBean>? = null

    constructor(context: Context, list: List<Film.SubjectsBean>) {
        this.context = context
        this.list = list
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var viewHolder: ViewHolder? = null
        var convertView: View? = convertView
        if (null == convertView) {
            viewHolder = ViewHolder()
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_film, null)
            viewHolder.title = convertView.title
            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
        }
        viewHolder.title!!.text = list!![position].title
        return convertView!!
    }

    override fun getItem(position: Int): Film.SubjectsBean {
        return list!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list!!.size
    }

    private class ViewHolder {
        var title: TextView? = null
    }

}
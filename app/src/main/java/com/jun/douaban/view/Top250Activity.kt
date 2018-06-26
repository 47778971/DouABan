package com.jun.douaban.view

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import com.jun.douaban.R
import com.jun.douaban.adapter.FilmListAdapter
import com.jun.douaban.contract.Top250Contract
import com.jun.douaban.entity.Film
import com.jun.douaban.presenter.Top250Presenter
import kotlinx.android.synthetic.main.activity_main.*


class Top250Activity : Activity(), Top250Contract.IView {

    var progressBar: ProgressBar? = null

    override fun showDialog() {
        progressBar?.visibility = View.VISIBLE
    }

    override fun dismissDialog() {
        progressBar?.visibility = View.GONE
    }

    override fun showData(films: Film) {
        listView.adapter = FilmListAdapter(this, films.subjects)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar = ProgressBar(this)
        var top250Presenter : Top250Presenter = Top250Presenter(this)
        top250Presenter.present()
    }
}

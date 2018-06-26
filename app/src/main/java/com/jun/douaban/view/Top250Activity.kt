package com.jun.douaban.view

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import com.jun.douaban.R
import com.jun.douaban.adapter.FilmListAdapter
import com.jun.douaban.contract.Top250Contract
import com.jun.douaban.entity.Film
import com.jun.douaban.presenter.Top250Presenter
import kotlinx.android.synthetic.main.activity_main.*


class Top250Activity : Activity(), Top250Contract.IView {

    var dialog: ProgressDialog? = null

    override fun showDialog() {
        dialog = ProgressDialog.show(this, "获取影片信息", "加载中...")
    }

    override fun dismissDialog() {
        dialog?.dismiss()
    }

    override fun showData(films: Film) {
        listView.adapter = FilmListAdapter(this, films.subjects)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Top250Presenter(this).getTop250()


        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            var intent: Intent = Intent(this@Top250Activity, FilmDetailActivity::class.java)
            intent.putExtra(FilmDetailActivity.TITLE_EXTRA, "")
            startActivity(intent)
        }
    }
}

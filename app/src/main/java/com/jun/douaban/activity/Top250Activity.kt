package com.jun.douaban.activity

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import com.jun.douaban.R
import com.jun.douaban.adapter.FilmListAdapter
import com.jun.douaban.common.BaseActivity
import com.jun.douaban.contract.BaseContract
import com.jun.douaban.entity.Film
import com.jun.douaban.presenter.Top250Presenter
import kotlinx.android.synthetic.main.activity_main.*


class Top250Activity : BaseActivity(), BaseContract.IView {


    var subjects: List<Film.SubjectsBean>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Top250Presenter(this).getData()

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            var intent: Intent = Intent(this@Top250Activity, FilmDetailActivity::class.java)
            intent.putExtra(FilmDetailActivity.ID_EXTRA, subjects!![position].id)
            startActivity(intent)
        }
    }

    override fun <T> showData(t: T) {
        subjects = (t as Film).subjects
        listView.adapter = FilmListAdapter(this, subjects!!)
    }

    override fun showDialog() {
        showDialog(resources.getString(R.string.get_top_250))
    }

}

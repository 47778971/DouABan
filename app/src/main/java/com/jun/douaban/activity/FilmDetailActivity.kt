package com.jun.douaban.activity

import android.os.Bundle
import com.jun.douaban.R
import com.jun.douaban.common.BaseActivity
import com.jun.douaban.entity.Film
import com.jun.douaban.presenter.FilmDetailPresenter
import com.jun.douaban.view.FilmDetailView
import kotlinx.android.synthetic.main.activity_film_detail.*

class FilmDetailActivity : BaseActivity(), FilmDetailView {

    companion object {
        val ID_EXTRA: String = "id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_detail)

        var id = intent.getStringExtra(ID_EXTRA)
        FilmDetailPresenter(this).getFilmDetail(id)
        FilmDetailPresenter(this).getCastsDetail(id)
    }

    override fun <T> showData(t: T) {

    }

    override fun <T> showSubjectData(t: T) {
        titleTextView.text = (t as Film.SubjectsBean).title
    }

    override fun <T> showCastsData(t: T) {
        celebrityTextView.text = (t as Film.SubjectsBean.CastsBean).name
    }

    override fun showDialog() {
        showDialog(resources.getString(R.string.get_film_detail))
    }
}

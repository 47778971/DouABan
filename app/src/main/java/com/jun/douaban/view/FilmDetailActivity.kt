package com.jun.douaban.view

import android.os.Bundle
import com.jun.douaban.R
import com.jun.douaban.common.BaseActivity
import com.jun.douaban.contract.BaseContract
import com.jun.douaban.entity.Film
import com.jun.douaban.presenter.FilmDetailPresenter
import kotlinx.android.synthetic.main.activity_film_detail.*

class FilmDetailActivity : BaseActivity(), BaseContract.IView<Film.SubjectsBean> {

    companion object {
        val ID_EXTRA: String = "id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_detail)

        var id = intent.getStringExtra(ID_EXTRA)
        FilmDetailPresenter(this).getFilmDetail(id)
    }

    override fun showData(film: Film.SubjectsBean) {
        titleTextView.text = film.title
    }
}

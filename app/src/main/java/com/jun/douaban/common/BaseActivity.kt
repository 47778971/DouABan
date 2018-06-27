package com.jun.douaban.common

import android.app.Activity
import android.app.ProgressDialog
import android.os.Bundle
import android.widget.Toast

open class BaseActivity : Activity() {
    var dialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun showDialog(content: String) {
        dialog = ProgressDialog.show(this, content, "加载中...")
    }

    fun dismissDialog() {
        dialog?.dismiss()
    }

    fun showToast(toast: String) {
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show()
    }
}
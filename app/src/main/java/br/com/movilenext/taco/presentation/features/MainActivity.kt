package br.com.movilenext.taco.presentation.features

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.movilenext.taco.R
import br.com.movilenext.taco.presentation.features.category.CategoryActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this, CategoryActivity::class.java))
    }
}

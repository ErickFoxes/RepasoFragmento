package com.echavez.repasofragmento

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.echavez.repasofragmento.fragmentos.ArticleFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ArticleFragment.OnArticleInteraction {
    override fun onSaveArticle(article: Article) {
        Snackbar.make(fg_article,"Se a guardado con exito",Snackbar.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val article = Article("Elsy, rompe corazones", "Manda a volar a chico",
                "El la tomo de la mano y ella se aparto !!", "sin/amor.jpg")

       supportFragmentManager.beginTransaction().add(fg_article.id, ArticleFragment.newInstance(article)).commit()

    }
}

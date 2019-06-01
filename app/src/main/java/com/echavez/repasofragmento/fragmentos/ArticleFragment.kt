package com.echavez.repasofragmento.fragmentos

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.echavez.repasofragmento.Article

import com.echavez.repasofragmento.R
import kotlinx.android.synthetic.main.fragment_article.view.*
import java.lang.Exception

private const val ARG_ARTICLE = "ARTICLE_OBJECT"

/**
 * A simple article display
 *
 * @author Elsy
 *
 */
class ArticleFragment : Fragment() {

    private var article: Article? = null
    private var listener: OnArticleInteraction? = null

    interface OnArticleInteraction {
        fun onSaveArticle(article: Article)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnArticleInteraction) {
            listener = context as OnArticleInteraction
        } else {
            throw Exception("Se debe implementar la interface OnArticleInteraction")
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            article = it.getParcelable(ARG_ARTICLE)

        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article, container, false).apply {
            article?.let {
                tv_titulo.text = it.title
                tv_subtitulo.text = it.subTitle
                tv_content.text = it.content
            }

            bt_save.setOnClickListener{
                article?.let { it1 -> listener?.onSaveArticle(it1) }
            }
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param article to show [Article]
         * @return A new instance of fragment ArticleFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(article: Article) =
                ArticleFragment().apply {
                    arguments = Bundle().apply {
                        putParcelable(ARG_ARTICLE, article)
                    }
                }
    }
}

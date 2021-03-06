package com.muvasia.driver.articleapp.Adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.muvasia.driver.articleapp.Activity.ArticleDetailsActivity
import com.muvasia.driver.articleapp.Model.Article
import com.muvasia.driver.articleapp.R
import kotlinx.android.synthetic.main.list_each_row_articles.view.*

class ArticleAdapter(
        private val articleList: ArrayList<Article>,
        private val context: Context
) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    companion object {
        private val TAG: String = ArticleAdapter::class.java.simpleName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_each_row_articles, parent, false))
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val article = articleList[position]

        holder.itemView.setOnClickListener {
            val intent = Intent(context, ArticleDetailsActivity::class.java)
            intent.putExtra("-article-id", article.id)
            context.startActivity(intent)
        }

        holder.tvArticleTitle.text = article.title
        holder.tvArticleAuthor.text = article.author
        holder.tvArticlePostedAt.text = article.postedAt
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvArticleTitle: TextView = itemView.tvArticleTitle
        val tvArticleAuthor: TextView = itemView.tvArticleAuthor
        val tvArticlePostedAt: TextView = itemView.tvArticlePostedAt
    }


}
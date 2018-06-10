

package net.kwmt27.codesearch.ui.event

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import net.kwmt27.codesearch.R
import net.kwmt27.codesearch.domain.model.Event

/**
 * View Holder for a [Event] RecyclerView list item.
 */
class EventViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val name: TextView = view.findViewById(R.id.name)
//    private val description: TextView = view.findViewById(R.id.repo_description)
//    private val stars: TextView = view.findViewById(R.id.repo_stars)
//    private val language: TextView = view.findViewById(R.id.repo_language)
//    private val forks: TextView = view.findViewById(R.id.repo_forks)

    private var event: Event? = null

    init {
        view.setOnClickListener {
//            event?.url?.let { url ->
//                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//                view.context.startActivity(intent)
//            }
        }
    }

    fun bind(event: Event?) {
        if (event == null) {
            val resources = itemView.resources
            name.text = resources.getString(R.string.loading)
//            description.visibility = View.GONE
//            language.visibility = View.GONE
//            stars.text = resources.getString(R.string.unknown)
//            forks.text = resources.getString(R.string.unknown)
        } else {
            showRepoData(event)
        }
    }

    private fun showRepoData(event: Event) {
        this.event = event
        name.text = event.githubUser.name

//        // if the description is missing, hide the TextView
//        var descriptionVisibility = View.GONE
//        if (event.description != null) {
//            description.text = event.description
//            descriptionVisibility = View.VISIBLE
//        }
//        description.visibility = descriptionVisibility
//
//        stars.text = event.stars.toString()
//        forks.text = event.forks.toString()
//
//        // if the language is missing, hide the label and the value
//        var languageVisibility = View.GONE
//        if (!event.language.isNullOrEmpty()) {
//            val resources = this.itemView.context.resources
//            language.text = resources.getString(R.string.language, event.language)
//            languageVisibility = View.VISIBLE
//        }
//        language.visibility = languageVisibility
    }

    companion object {
        fun create(parent: ViewGroup): EventViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.event_list_item, parent, false)
            return EventViewHolder(view)
        }
    }
}
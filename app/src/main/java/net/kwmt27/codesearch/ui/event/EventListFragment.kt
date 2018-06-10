package net.kwmt27.codesearch.ui.event

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import net.kwmt27.codesearch.R
import net.kwmt27.codesearch.domain.model.Event
import net.kwmt27.codesearch.ui.Injection

class EventListFragment : Fragment() {

    private lateinit var viewModel: EventListViewModel
    private val adapter = EventListAdapter()

    private lateinit var list : RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
//        binding = DataBindingUtil.inflate(inflater, R.layout.event_list_fragment, container, false)
        return inflater.inflate(R.layout.event_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list = view.findViewById(R.id.list)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val context = activity ?: return
        // get the view model
        viewModel = ViewModelProviders.of(this, Injection.provideViewModelFactory(context))
                .get(EventListViewModel::class.java)

        viewModel.initialize("kwmt")

        // add dividers between RecyclerView's row items
        val decoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        list.addItemDecoration(decoration)

        initAdapter()
    }

    private fun initAdapter() {
        list.adapter = adapter

        viewModel.eventList.observe(this, Observer<List<Event>> {
            //            Timber.d("Activity", "list: ${it?.size}")
//            showEmptyList(it?.size == 0)
            adapter.submitList(it)
        })
//        viewModel.networkErrors.observe(this, Observer<String> {
//            Toast.makeText(this, "\uD83D\uDE28 Wooops ${it}", Toast.LENGTH_LONG).show()
//        })

    }

}

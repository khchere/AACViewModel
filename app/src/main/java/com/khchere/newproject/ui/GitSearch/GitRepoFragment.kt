package com.khchere.newproject.ui.GitSearch

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.khchere.newproject.R

import com.khchere.newproject.ui.GitSearch.dummy.DummyContent
import com.khchere.newproject.ui.GitSearch.dummy.DummyContent.DummyItem
import com.khchere.newproject.ui.profile.ProfileFragment
import kotlinx.android.synthetic.main.main_fragment.*

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [GitRepoFragment.OnListFragmentInteractionListener] interface.
 */
class GitRepoFragment : Fragment() {

    // TODO: Customize parameters
    private var columnCount = 1
    private var listener: OnListFragmentInteractionListener? = null
    private lateinit var viewModel: SearchRepositoriesViewModel

    companion object {
        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"
        private const val DEFAULT_QUERY = "Android"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            GitRepoFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MyItemRecyclerViewAdapter(DummyContent.ITEMS, listener)
            }
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: DummyItem?)
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val query = savedInstanceState?.getString("SEARCH_QUERY")?: DEFAULT_QUERY
        Log.d("GitRepoFragment","onActivityCreated")

        viewModel = ViewModelProviders.of(this).get(SearchRepositoriesViewModel::class.java)
        viewModel.searchRepo(query)

        viewModel.user.observe(this, Observer {
            Log.d("MyRepository","observeData !! :  $it")
//            message.text = it.toString()
        })
    }
}

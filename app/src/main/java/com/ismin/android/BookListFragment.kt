package com.ismin.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM = "books"


/**
 * A simple [Fragment] subclass.
 * Use the [BookListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookListFragment() : Fragment() {
    // TODO: Rename and change types of parameters
    private var books: ArrayList<Book>? = null

    private lateinit var adapter: BookAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            books = it.getSerializable(ARG_PARAM) as ArrayList<Book>
            adapter = BookAdapter(books!!)
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_book_list, container, false)
        val rcvBooks = view.findViewById<RecyclerView>(R.id.a_main_rcv_books)
        rcvBooks.layoutManager = LinearLayoutManager(context)
        rcvBooks.adapter = adapter
        // Inflate the layout for this fragment
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param books Parameter 1.
         * @return A new instance of fragment BookListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(books: ArrayList<Book>): BookListFragment {
            val fragment = BookListFragment()
            BookListFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM, books)
                }
            }
            return fragment
        }
    }
}
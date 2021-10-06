package com.ismin.android

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import java.lang.RuntimeException

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CreateBookFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateBookFragment : Fragment() {

    private var listener: BookCreator? = null
    private lateinit var author: TextInputEditText
    private lateinit var title: TextInputEditText
    private lateinit var date: TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private fun saveBook() {
        val book = Book(title.text.toString(), author.text.toString(), date.text.toString())
        listener?.onBookCreated(book)
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is BookCreator)
            listener = context
        else throw RuntimeException("Error")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_create_book, container, false)
        author = view.findViewById<TextInputEditText>(R.id.f_create_book_edt_author)
        title = view.findViewById<TextInputEditText>(R.id.f_create_book_edt_title)
        date = view.findViewById<TextInputEditText>(R.id.f_create_book_edt_date)
        view.findViewById<Button>(R.id.f_create_book_btn_save).setOnClickListener{
            saveBook()
        }
        // Inflate the layout for this fragment
        return view
    }

}
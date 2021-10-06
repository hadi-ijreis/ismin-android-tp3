package com.ismin.android

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), BookCreator {

    private val TAG = MainActivity::class.java.simpleName
    private val bookshelf = Bookshelf()
    private lateinit var btnCreateBook: FloatingActionButton

    private val startForResult = registerForActivityResult(StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val book = result.data?.getSerializableExtra(BOOK_TO_CREATE_KEY) as Book
            bookshelf.addBook(book);
            Log.d(TAG, "Number of books:" + bookshelf.getTotalNumberOfBooks())
            displayList()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCreateBook = findViewById<FloatingActionButton>(R.id.a_main_btn_create_book)

        btnCreateBook.setOnClickListener {
            val intent = Intent(this, CreateBookFragment::class.java)
            goToCreateBook()
        }


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }


    fun displayList(){
        val bundle = Bundle()
        bundle.putSerializable("books",bookshelf.getAllBooks())
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = BookListFragment()
        fragment.arguments = bundle
        fragmentTransaction.replace(R.id.constraint_layout_display, fragment)
        fragmentTransaction.commit()
        btnCreateBook.visibility = View.VISIBLE
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.main_menu_delete -> {
                bookshelf.clear()
                displayList()
                true
            }
            // If we got here, the user's action was not recognized.
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBookCreated(book: Book){
        this.bookshelf.addBook(book)
        displayList()

    }

    fun goToCreateBook(){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = CreateBookFragment()
        fragmentTransaction.replace(R.id.constraint_layout_display, fragment)
        fragmentTransaction.commit()
        btnCreateBook.visibility = View.INVISIBLE
    }
}
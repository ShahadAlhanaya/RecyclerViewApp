package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityLayout : ConstraintLayout
    lateinit var addButton : Button
    lateinit var itemEditText: EditText
    lateinit var wishListRV: RecyclerView
    val items = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityLayout = findViewById(R.id.mainActivityLayout_cl)
        addButton = findViewById(R.id.add_button)
        itemEditText = findViewById(R.id.item_editText)
        wishListRV = findViewById(R.id.wishlist_recyclerView)

        wishListRV.adapter = WishListRecyclerViewAdapter(items)
        var wishListAdapter = wishListRV.adapter!!
        wishListRV.layoutManager = LinearLayoutManager(this)

        fun addItem(item :String){
            items.add(item)
            wishListAdapter.notifyItemChanged(items.size)
        }

        addButton.setOnClickListener {
            if(itemEditText.text.isEmpty() || itemEditText.text.toString().trim(' ')==""){
                Snackbar.make(mainActivityLayout, "Please enter an item", Snackbar.LENGTH_LONG).show()
            }else{
                addItem(itemEditText.text.toString())
                itemEditText.text.clear()
            }
        }
    }


}
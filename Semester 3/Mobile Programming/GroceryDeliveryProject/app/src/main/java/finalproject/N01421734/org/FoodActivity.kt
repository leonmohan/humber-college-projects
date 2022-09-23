package finalproject.N01421734.org

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.edit
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import org.w3c.dom.Text

class FoodActivity : AppCompatActivity() {
    private lateinit var mDb:GroceryDirectDatabase
    private lateinit var foodArrayList: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)
    }

    //Cart Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.cart_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val cartIntent = Intent(this, CartActivity::class.java)
        cartIntent.putExtra("PREVIOUS", "FoodActivity")
        startActivity(cartIntent)
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        //Populate listview with foods under the category (use sql)
        //Initialize listview, mDb, sharedPref, foodArrayList
        val listView = findViewById<ListView>(R.id.foodList)
        mDb = GroceryDirectDatabase.getInstance(applicationContext)
        val sharedPref = getSharedPreferences("rememberUser", MODE_PRIVATE)
        val category = sharedPref.getString("CATEGORY", "").toString()
        val location = sharedPref.getString("STORE", "").toString()
        foodArrayList = ArrayList()

        //Do this in the background: Select all foods from database then add it to a list
        val list = mDb.groceryDao().selectFood(location, category)
        for (i in list){
            foodArrayList.add("\n${i.product_name}\n$${i.price}\n")
        }

        //Convert that list to an array called foods and populate that adapter with the array contents
        val foods: Array<String> = foodArrayList.toTypedArray()

        val arrayAdapter:ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, foods)
        listView.adapter = arrayAdapter

        //When a listView item is clicked, add to cart
        listView.setOnItemClickListener{adapterView, view, i, l ->
            var foodName = foods[i].toString()
            toast("Added ${foodName.split("\n")[1]} to cart!")
            val newCart = CartEntity(0, sharedPref.getString("USERNAME", "").toString(), foodName.split("\n")[1].toString(), sharedPref.getString("STORE", "").toString())
            doAsync {
                mDb.groceryDao().insertCart(newCart)
            }
        }

        //Changing view name to the category user picked
        val foodText = findViewById<TextView>(R.id.foodText)
        foodText.text = category
        super.onResume()
    }

    fun cancelOnClick(view: android.view.View) {
        val storeIntent = Intent(this, StoreActivity::class.java)
        startActivity(storeIntent)
    }
}
package finalproject.N01421734.org

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast

class CartActivity : AppCompatActivity() {
    private lateinit var mDb:GroceryDirectDatabase
    private lateinit var foodArrayList: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
    }

    override fun onResume() {
        populate()
        super.onResume()
        mDb = GroceryDirectDatabase.getInstance(applicationContext)
    }

    //Back button: Decide which activity user previously was on
    fun backBtn(view: android.view.View) {
        if (intent.getStringExtra("PREVIOUS") == "AccountMenuActivity"){
            val previousIntent = Intent(this, AccountMenuActivity::class.java)
            startActivity(previousIntent)
        }
        else if (intent.getStringExtra("PREVIOUS") == "BrowseActivity"){
            val previousIntent = Intent(this, BrowseActivity::class.java)
            startActivity(previousIntent)
        }
        else if (intent.getStringExtra("PREVIOUS") == "StoreActivity"){
            val previousIntent = Intent(this, StoreActivity::class.java)
            startActivity(previousIntent)
        }
        else if (intent.getStringExtra("PREVIOUS") == "FoodActivity"){
            val previousIntent = Intent(this, FoodActivity::class.java)
            startActivity(previousIntent)
        }
        else if (intent.getStringExtra("PREVIOUS") == "OrderHistoryActivity"){
            val previousIntent = Intent(this, OrderHistoryActivity::class.java)
            startActivity(previousIntent)
        }
        else{
            val previousIntent = Intent(this, AccountMenuActivity::class.java)
            startActivity(previousIntent)
        }
    }

    //Checkout button
    fun checkoutBtn(view: android.view.View) {
        val list = mDb.groceryDao().selectCart(getSharedPreferences("rememberUser", MODE_PRIVATE).getString("USERNAME", "").toString())
        if(list.isEmpty()){
            toast("Cart is empty")
        }
        else{
            val checkoutIntent = Intent(this, CheckoutActivity::class.java)
            startActivity(checkoutIntent)
        }
    }

    //Clear button
    fun clearBtn(view: android.view.View) {
        mDb.groceryDao().clearCart(getSharedPreferences("rememberUser", MODE_PRIVATE).getString("USERNAME", "").toString())
        populate()
    }

    //Populate listview
    fun populate(){
        //Populate listview with foods under the category (use sql)
        //Initialize listview, mDb, sharedPref, foodArrayList
        mDb = GroceryDirectDatabase.getInstance(applicationContext)
        val listView = findViewById<ListView>(R.id.cartList)
        val sharedPref = getSharedPreferences("rememberUser", MODE_PRIVATE)
        val username = sharedPref.getString("USERNAME", "").toString()
        foodArrayList = ArrayList()

        //Select all orders from Cart based off username
        val list = mDb.groceryDao().selectCart(username)

        if (!list.isEmpty()){
            for (i in list){
                foodArrayList.add("\n${i.store}\n${i.product_name}\n")
            }
        }

        //Convert that list to an array called foods and populate that adapter with the array contents
        val foods: Array<String> = foodArrayList.toTypedArray()

        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, foods)
        listView.adapter = arrayAdapter
    }
}
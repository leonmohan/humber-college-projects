package finalproject.N01421734.org

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.content.edit

class BrowseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browse)
    }

    //Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.cart_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val cartIntent = Intent(this, CartActivity::class.java)
        cartIntent.putExtra("PREVIOUS", "BrowseActivity")
        startActivity(cartIntent)
        return super.onOptionsItemSelected(item)
    }

    //Cancel button clicked
    fun browseCancelOnClick(view: android.view.View) {
        val mainIntent = Intent(this, MainActivity::class.java)
        startActivity(mainIntent)
    }

    //Walmart button
    fun walmartOnClick(view: android.view.View) {
        val storeIntent = Intent(this, StoreActivity::class.java)
        startActivity(storeIntent)
        getSharedPreferences("rememberUser", MODE_PRIVATE).edit {
            putString("STORE", "Walmart")
            apply()
        }
    }

    //Food basics button
    fun foodbasicsOnClick(view: android.view.View) {
        val storeIntent = Intent(this, StoreActivity::class.java)
        startActivity(storeIntent)
        getSharedPreferences("rememberUser", MODE_PRIVATE).edit {
            putString("STORE", "Food Basics")
            apply()
        }
    }

    //Superstore button
    fun superstoreOnClick(view: android.view.View) {
        val storeIntent = Intent(this, StoreActivity::class.java)
        startActivity(storeIntent)
        getSharedPreferences("rememberUser", MODE_PRIVATE).edit {
            putString("STORE", "Superstore")
            apply()
        }
    }

    //Metro button
    fun metroOnClick(view: android.view.View) {
        val storeIntent = Intent(this, StoreActivity::class.java)
        startActivity(storeIntent)
        getSharedPreferences("rememberUser", MODE_PRIVATE).edit {
            putString("STORE", "Metro")
            apply()
        }
    }


}
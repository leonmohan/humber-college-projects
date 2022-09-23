package finalproject.N01421734.org

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.content.edit

class StoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        val dairyBtn = findViewById<ImageButton>(R.id.dairyBtn)
        val produceBtn = findViewById<ImageButton>(R.id.produceBtn)
        val frozenBtn = findViewById<ImageButton>(R.id.frozenFoodBtn)
        val pantryBtn = findViewById<ImageButton>(R.id.pantryBtn)
        val cancelBtn = findViewById<Button>(R.id.cancelBtn)

        //Cancel
        cancelBtn.setOnClickListener {
            val browseIntent = Intent(this, BrowseActivity::class.java)
            startActivity(browseIntent)
        }

        //Dairy
        dairyBtn.setOnClickListener {
            val foodIntent = Intent(this, FoodActivity::class.java)
            startActivity(foodIntent)

            getSharedPreferences("rememberUser", MODE_PRIVATE).edit {
                putString("CATEGORY", "Dairy")
                apply()
            }
        }

        //Frozen
        frozenBtn.setOnClickListener {
            val foodIntent = Intent(this, FoodActivity::class.java)
            startActivity(foodIntent)

            getSharedPreferences("rememberUser", MODE_PRIVATE).edit {
                putString("CATEGORY", "Frozen")
                apply()
            }
        }

        //Pantry
        pantryBtn.setOnClickListener {
            val foodIntent = Intent(this, FoodActivity::class.java)
            startActivity(foodIntent)

            getSharedPreferences("rememberUser", MODE_PRIVATE).edit {
                putString("CATEGORY", "Pantry")
                apply()
            }
        }

        //Produce
        produceBtn.setOnClickListener {
            val foodIntent = Intent(this, FoodActivity::class.java)
            startActivity(foodIntent)

            getSharedPreferences("rememberUser", MODE_PRIVATE).edit {
                putString("CATEGORY", "Produce")
                apply()
            }
        }
    }

    //Cart Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.cart_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val cartIntent = Intent(this, CartActivity::class.java)
        cartIntent.putExtra("PREVIOUS", "StoreActivity")
        startActivity(cartIntent)
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        val sharedPref = getSharedPreferences("rememberUser", MODE_PRIVATE)
        val location = sharedPref.getString("STORE", "")
        val logoImage = findViewById<ImageView>(R.id.companyLogo)

        //What to change the logo to
        when (location) {
            "Walmart" -> {
                logoImage.setImageResource(R.drawable.walmart_logo)
            }
            "Food Basics" -> {
                logoImage.setImageResource(R.drawable.foodbasics_logo)
            }
            "Superstore" -> {
                logoImage.setImageResource(R.drawable.superstore_logo)
            }
            "Metro" -> {
                logoImage.setImageResource(R.drawable.metro_logo)
            }
        }
        super.onResume()
    }
}
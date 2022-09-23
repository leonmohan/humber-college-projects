package finalproject.N01421734.org

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.core.content.edit

class AccountMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accountmenu)
        //Initializing views
        val welcomeText = findViewById<TextView>(R.id.welcomeText)
        val browseBtn = findViewById<Button>(R.id.browseBtn)
        val orderHistoryBtn = findViewById<Button>(R.id.orderHistoryBtn)
        val logoutBtn = findViewById<Button>(R.id.logoutBtn)

        //Initializing sharedPref
        val sharedPref = getSharedPreferences("rememberUser", MODE_PRIVATE)
        val username = sharedPref.getString("USERNAME", "")

        //Display username
        welcomeText.setText(getString(R.string.welcome_user) + " " + username)

        //When logout is clicked
        logoutBtn.setOnClickListener {
            sharedPref.edit {
                putString("USERNAME", "")
                apply()
            }
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
        }

        //When browse is clicked
        browseBtn.setOnClickListener {
            val browseIntent = Intent(this, BrowseActivity::class.java)
            startActivity(browseIntent)
        }

        //When order history is clicked
        orderHistoryBtn.setOnClickListener {
            val orderHistory = Intent(this, OrderHistoryActivity::class.java)
            startActivity(orderHistory)
        }
    }

    override fun onResume() {
        //Checks if actor is still logged in
        val sharedPref = getSharedPreferences("rememberUser", MODE_PRIVATE)
        val username = sharedPref.getString("USERNAME", "")
        if (username.equals("")){
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
        }
        super.onResume()
    }

    //Cart menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.cart_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val cartIntent = Intent(this, CartActivity::class.java)
        cartIntent.putExtra("PREVIOUS", "AccountMenuActivity")
        startActivity(cartIntent)
        return super.onOptionsItemSelected(item)
    }
}
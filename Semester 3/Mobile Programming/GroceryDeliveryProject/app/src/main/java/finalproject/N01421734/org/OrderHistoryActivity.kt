package finalproject.N01421734.org

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.TextView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class OrderHistoryActivity : AppCompatActivity() {
    private lateinit var mDb:GroceryDirectDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orderhistory)
    }

    override fun onResume() {
        val ordersText = findViewById<TextView>(R.id.ordersText)
        ordersText.movementMethod = ScrollingMovementMethod()

        mDb = GroceryDirectDatabase.getInstance(applicationContext)

        doAsync {
            val list = mDb.groceryDao().selectOrders(getSharedPreferences("rememberUser", MODE_PRIVATE).getString("USERNAME", "").toString())
            uiThread {
                for (order in list){
                    ordersText.append("${order.date}\n\n${order.order_content}\n\n\n")
                }
            }
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
        cartIntent.putExtra("PREVIOUS", "OrderHistoryActivity")
        startActivity(cartIntent)
        return super.onOptionsItemSelected(item)
    }

    //When back is clicked
    fun backOnClick(view: android.view.View) {
        val menuIntent = Intent(this, AccountMenuActivity::class.java)
        startActivity(menuIntent)
    }
}
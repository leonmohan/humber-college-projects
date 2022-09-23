package finalproject.N01421734.org

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*

class CheckoutActivity : AppCompatActivity() {
    private lateinit var mDb: GroceryDirectDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)
    }

    override fun onResume() {
        val cartItemsText = findViewById<TextView>(R.id.cartItemsText)
        val purchaseBtn = findViewById<Button>(R.id.purchaseBtn)
        val cancelBtn = findViewById<Button>(R.id.cancelBtn)
        val enterNameText = findViewById<TextView>(R.id.nameText)
        val enterNameEdit = findViewById<EditText>(R.id.nameEdit)
        val enterNameErrorText = findViewById<TextView>(R.id.checkoutNameError)
        val enterAddressText = findViewById<TextView>(R.id.addressText)
        val enterAddressEdit = findViewById<EditText>(R.id.addressEdit)
        val enterAddressErrorText = findViewById<TextView>(R.id.checkoutNameError2)
        val userAccountDetailsText = findViewById<TextView>(R.id.userAccountDetails)
        mDb = GroceryDirectDatabase.getInstance(applicationContext)
        cartItemsText.setText("")
        cartItemsText.movementMethod = ScrollingMovementMethod()
        val username = getSharedPreferences("rememberUser", MODE_PRIVATE).getString("USERNAME", "").toString()


        //Prepopulate
        var total = 0.0000
        doAsync {
            val list = mDb.groceryDao().selectCart(username)
            uiThread {
                for (item in list) {
                    var store = item.store.toString()
                    var product_name = item.product_name.toString()
                    var price = calculatePrice(store, product_name)
                    cartItemsText.append("${store}\n${product_name}\n\n")
                    total += price.toDouble()
                }
                cartItemsText.append("TOTAL: $${total.toString().substring(0, 4)}\n")
            }
        }


        if(getSharedPreferences("rememberUser", MODE_PRIVATE).getString("USERNAME", "").toString() == ""){
            enterNameText.visibility = View.VISIBLE
            enterNameEdit.visibility = View.VISIBLE
            enterAddressText.visibility = View.VISIBLE
            enterAddressEdit.visibility = View.VISIBLE
            userAccountDetailsText.visibility = View.INVISIBLE
        }
        else{
            enterNameText.visibility = View.INVISIBLE
            enterNameEdit.visibility = View.INVISIBLE
            enterNameErrorText.visibility = View.INVISIBLE
            enterAddressText.visibility = View.INVISIBLE
            enterAddressEdit.visibility = View.INVISIBLE
            enterAddressErrorText.visibility = View.INVISIBLE
            userAccountDetailsText.setText("")
            userAccountDetailsText.visibility = View.VISIBLE

            doAsync {
                val list = mDb.groceryDao().findUser(username)

                uiThread {
                    for (user in list){
                        userAccountDetailsText.append("\nCUSTOMER DETAILS:\n${user.username}\n${user.address}\n${user.email}\n${user.phone}")
                    }
                }
            }
        }

        //Cancel button
        cancelBtn.setOnClickListener {
            val cartIntent = Intent(this, CartActivity::class.java)
            startActivity(cartIntent)
        }

        //Purchase button
        purchaseBtn.setOnClickListener {
            var error = false

            if(username == ""){
                if (enterNameEdit.text.isBlank()){
                    enterNameErrorText.visibility = View.VISIBLE
                    error = true
                }
                if(enterAddressEdit.text.isBlank()){
                    enterAddressErrorText.visibility = View.VISIBLE
                    error = true
                }
                val list = mDb.groceryDao().selectCart(username)

                if(list.isEmpty()){
                    error = true
                    toast("Not cart items found")
                }
                if(!error){
                    doAsync {
                        mDb.groceryDao().insertHistory(OrdersEntity(0, "", cartItemsText.text.toString() + "\n\n" + enterNameEdit.text.toString() + "\n" + enterAddressEdit.text.toString(), SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().time)))
                        mDb.groceryDao().clearCart(getSharedPreferences("rememberUser", MODE_PRIVATE).getString("USERNAME", "").toString())
                    }
                    toast("Purchased Successfully")
                    val mainActivity = Intent(this, MainActivity::class.java)
                    startActivity(mainActivity)
                }
            }
            else{
                val list = mDb.groceryDao().selectCart(username)

                if(list.isEmpty()){
                    toast("Not cart items found")
                }
                else{
                    mDb.groceryDao().insertHistory(OrdersEntity(0, username, cartItemsText.text.toString() + userAccountDetailsText.text.toString(), SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().time)))
                    mDb.groceryDao().clearCart(username)
                    toast("Purchased Successfully")
                    val mainActivity = Intent(this, MainActivity::class.java)
                    startActivity(mainActivity)
                }
            }
        }
        super.onResume()
    }

    fun calculatePrice(store: String, product_name: String): String {
        var price = ""

        val list = mDb.groceryDao().selectPrice(store, product_name)

        for (i in list) {
            price = i.price.toString()
        }

        return price
    }
}
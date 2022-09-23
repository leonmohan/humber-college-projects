package finalproject.N01421734.org

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class LoginActivity : AppCompatActivity() {
    private lateinit var mDb:GroceryDirectDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEdit = findViewById<EditText>(R.id.loginUsernameEdit)
        val passwordEdit = findViewById<EditText>(R.id.loginPasswordEdit)
        val cancelBtn = findViewById<Button>(R.id.loginCancelBtn)
        val loginBtn = findViewById<Button>(R.id.loginConfirmBtn)
        val usernameError = findViewById<TextView>(R.id.loginUsernameErrorText)
        val passwordError = findViewById<TextView>(R.id.loginPasswordErrorText)

        //Initialize db
        mDb = GroceryDirectDatabase.getInstance(applicationContext)

        //Initialize sharedPref
        val sharedPref = getSharedPreferences("rememberUser", MODE_PRIVATE)

        //When cancel button is clicked
        cancelBtn.setOnClickListener{
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
        }

        //When login button is clicked
        loginBtn.setOnClickListener{
            //FRONT-END VALIDATION
            var error = false
            if(usernameEdit.text.isBlank()){
                usernameError.visibility = View.VISIBLE
                error = true
            }
            else{
                usernameError.visibility = View.INVISIBLE
            }
            if(passwordEdit.text.isBlank()){
                passwordError.visibility = View.VISIBLE
                error = true
            }
            else{
                passwordError.visibility = View.INVISIBLE
            }

            //PASSED FRONT-END VALIDATION. START BACK-END VALIDATION
            if(!error){
                doAsync {
                    val list = mDb.groceryDao().findUser(usernameEdit.text.toString())

                    uiThread {
                        if(list.size == 0){
                            usernameError.visibility = View.VISIBLE
                            usernameError.text = getString(R.string.username_error3)
                        }
                        else{
                            for(user in list){
                                if(user.password == passwordEdit.text.toString()){ //PASSED BACK-END VALIDATION
                                    rememberUser(sharedPref, usernameEdit.text.toString())
                                }
                                else{ //FAILED BACK-END VALIDATION
                                    usernameError.visibility = View.VISIBLE
                                    usernameError.text = getString(R.string.username_error3)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onResume() {
        //Check if user was previously logged in
        if(getSharedPreferences("rememberUser", MODE_PRIVATE).getString("USERNAME", "") != "")
        {
            val menuIntent = Intent(this, AccountMenuActivity::class.java)
            startActivity(menuIntent)
        }
        super.onResume()
    }

    fun rememberUser(sharedPref: SharedPreferences, username: String){
        sharedPref.edit().apply{
            putString("USERNAME", username)
            apply()
        }

        val accountMenuIntent = Intent(this, AccountMenuActivity::class.java)
        startActivity(accountMenuIntent)
    }

}
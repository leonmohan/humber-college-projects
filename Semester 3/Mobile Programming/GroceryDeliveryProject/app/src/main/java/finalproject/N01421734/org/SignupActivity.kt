package finalproject.N01421734.org

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class SignupActivity : AppCompatActivity() {
    private lateinit var mDb:GroceryDirectDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val usernameEdit = findViewById<EditText>(R.id.signupUsernameEdit)
        val passwordEdit = findViewById<EditText>(R.id.signupPasswordEdit)
        val emailEdit = findViewById<EditText>(R.id.signupEmailEdit)
        val phoneEdit = findViewById<EditText>(R.id.signupPhoneEdit)
        val addressEdit = findViewById<EditText>(R.id.signupAddressEdit)
        val usernameError = findViewById<TextView>(R.id.signupUsernameErrorText)
        val passwordError = findViewById<TextView>(R.id.signupPasswordErrorText)
        val emailError = findViewById<TextView>(R.id.signupEmailErrorText)
        val phoneError = findViewById<TextView>(R.id.signupPhoneErrorText)
        val addressError = findViewById<TextView>(R.id.signupAddressErrorText)
        val cancelBtn = findViewById<Button>(R.id.signupCancelBtn)
        val confirmBtn = findViewById<Button>(R.id.signupConfirmBtn)

        //Initialize db
        mDb = GroceryDirectDatabase.getInstance(applicationContext)

        //When cancel button is clicked
        cancelBtn.setOnClickListener{
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
        }

        //When confirm button is clicked
        confirmBtn.setOnClickListener{
            //Validates fields and starts browse intent if error remains false
            var error = false

            if(usernameEdit.text.isBlank()){
                usernameError.visibility = View.VISIBLE
                usernameError.text = getString(R.string.username_error)
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
            if(emailEdit.text.isBlank() || !TextUtils.isEmpty(emailEdit.text) && !Patterns.EMAIL_ADDRESS.matcher(emailEdit.text).matches()){
                emailError.visibility = View.VISIBLE
                error = true
            }
            else{
                emailError.visibility = View.INVISIBLE
            }
            if (phoneEdit.text.length != 10){
                phoneError.visibility = View.VISIBLE
                error = true
            }
            else{
                phoneError.visibility = View.INVISIBLE
            }
            if(addressEdit.text.isBlank()){
                addressError.visibility = View.VISIBLE
                error = true
            }
            else{
                addressError.visibility = View.INVISIBLE
            }

            if(!error){
                val newUser = UserEntity(usernameEdit.text.toString(), passwordEdit.text.toString(), emailEdit.text.toString(), phoneEdit.text.toString(), addressEdit.text.toString())
                doAsync {
                    val list = mDb.groceryDao().findUser(usernameEdit.text.toString())

                    uiThread {
                        //Username not taken
                        if (list.size == 0){
                            doAsync {
                                mDb.groceryDao().insertUser(newUser)

                                uiThread {
                                    toast("Successfully registered")
                                    redirect()
                                }
                            }
                        }
                        //Username taken
                        else{
                            usernameError.visibility = View.VISIBLE
                            usernameError.text = getString(R.string.username_error2)
                        }
                    }
                }
            }
        }
    }

    //Redirects user to login page
    fun redirect(){
        val loginIntent = Intent(this, LoginActivity::class.java)
        startActivity(loginIntent)
    }
}
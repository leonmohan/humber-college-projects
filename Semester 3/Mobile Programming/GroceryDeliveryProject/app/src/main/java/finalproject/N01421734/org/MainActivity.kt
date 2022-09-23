package finalproject.N01421734.org

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Vars needed for the facts changing algorithm
    var handler: Handler = Handler()
    var runnable: Runnable? = null
    var delay = 3000
    val swipe = arrayOf(R.drawable.swipe_1,R.drawable.swipe_2,R.drawable.swipe_3)
    var swipeIndex = 0

    //Changes factsImage's Image src randomly every 3 seconds
    override fun onResume() {
        val factsImage = findViewById<ImageView>(R.id.factsImage)
        handler.postDelayed(Runnable
        {
            handler.postDelayed(runnable!!, delay.toLong())
            //Resets swipeIndex if its over the arrayLength
            if(swipeIndex > 1)
                swipeIndex = 0
            else
                swipeIndex++

            factsImage.setImageResource(swipe[swipeIndex])
        }.also { runnable = it }, delay.toLong())


        //Check if user was previously logged in
        if(getSharedPreferences("rememberUser", MODE_PRIVATE).getString("USERNAME", "") != "")
        {
            val menuIntent = Intent(this, AccountMenuActivity::class.java)
            startActivity(menuIntent)
        }
        super.onResume()
    }

    //Stops the image change loop from running when activity is paused
    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable!!)
    }

    fun signupOnClick(view: android.view.View) {
        val signupIntent = Intent(this, SignupActivity::class.java)
        startActivity(signupIntent)
    }

    fun loginOnClick(view: android.view.View) {
        val loginIntent = Intent(this, LoginActivity::class.java)
        startActivity(loginIntent)
    }

    fun continueGuestOnClick(view: android.view.View) {
        val browseIntent = Intent(this, BrowseActivity::class.java)
        startActivity(browseIntent)
    }

    //Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.help_info_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.help -> {
                val helpIntent = Intent(this, HelpActivity::class.java)
                startActivity(helpIntent)
            }
            R.id.about -> {
                val aboutIntent = Intent(this, AboutActivity::class.java)
                startActivity(aboutIntent)
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }

        return super.onOptionsItemSelected(item)
    }

}
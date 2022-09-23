package finalproject.N01421734.org

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }

    //Back button
    fun backOnClick(view: android.view.View) {
        val mainIntent = Intent(this, MainActivity::class.java)
        startActivity(mainIntent)
    }
}
package finalproject.N01421734.org

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.TextView

class HelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)
        findViewById<TextView>(R.id.helpInfoText).movementMethod = ScrollingMovementMethod()
    }

    //With account
    fun withAccountOnclick(view: android.view.View) {
        findViewById<TextView>(R.id.helpInfoText).text =
            "HOW TO USE APP WITH AN ACCOUNT:\n" +
                    "\n" +
                    "Step 1: Create an account and log in\n" +
                    "In the main menu, select the 'Sign up' button. Fill out all the fields and press the 'Confirm' button. If you would like to go back to the main menu, press 'Cancel'. " +
                    "If red errors appear next to a field, follow the instructions and press 'Confirm' again. If everything is done correctly, you will be redirected to the 'Log in' page. " +
                    "Enter the details of your newly created account and press the 'Log in' button. If you do not want to Log in, press the 'Cancel' button\n\n" +
                    "Step 2: Using the account menu\n" +
                    "When you're successfully logged into your account, you will have four options to choose from. 'Browse groceries' will start the process of grocery shopping. " +
                    "The 'My order history' button will take you to a page containing all your past orders. If you would like to log out of your account, press the 'Log out button'. " +
                    "On the top right there is a cart icon, this will redirect you to your virtual shopping cart.\n\n" +
                    "Step 3: Add items to your cart\n" +
                    "To make an order, click the 'Browse groceries' button (Refer to step 2). After that, select the store you would like to purchase an item from. After you've " +
                    "selected your desired store, select the category of foods you want to buy. When you select the category of food you want to buy, select an item from the list to " +
                    "add it to your virtual shopping cart. Repeat this process until you have the desired amount of products added to your cart.\n\n" +
                    "Step 4: Review your cart\n" +
                    "After you have filled your cart, select the cart icon on the top right corner of the screen. This will display all the items you've added to your cart including " +
                    "their store locations. If you are satisfied with the items in your cart, press the 'Checkout' button. If you are not satisfied the with items in your cart, press " +
                    "the 'Clear' button. If you've forgotten to add an item to your cart, press the 'Back' button.\n\n" +
                    "Step 5: Make an order\n" +
                    "If you've selected the 'Checkout' button (Refer to step 3), it will display you a list of all the items in your cart along with the total. It will also show your " +
                    "account details at the bottom. If you want to make this purchase, make sure all information is correct and click the 'Purchase' button. Otherwise, click the 'Cancel' " +
                    "button. And that's it! A message at the bottom will confirm with you that your order has been made. To review your order refer to step 2. "
    }

    //Without account
    fun withoutAccountBtn(view: android.view.View) {
        findViewById<TextView>(R.id.helpInfoText).text =
            "HOW TO USE APP WITHOUT AN ACCOUNT:\n" +
                    "\n" +
                    "Step 1: Add items to your cart as a guest\n" +
                    "In the main menu, select the 'Continue as guest' button. Select the store you would like to purchase an item from. After selecting your desired store, " +
                    "select an item from the list to add it to your virtual shopping cart. Repeat this process until you have the desired amount of products added to your cart.\n\n" +
                    "Step 2: Review your cart\n" +
                    "After you have filled your cart, select the cart icon on the top right corner of the screen. This will display all the items you've added to your cart including " +
                    "their store locations. If you are satisfied with the items in your cart, press the 'Checkout' button. If you are not satisfied the with items in your cart, press " +
                    "the 'Clear' button. If you've forgotten to add an item to your cart, press the 'Back' button.\n\n" +
                    "Step 3: Make an order\n" +
                    "If you've selected the 'Checkout' button (Refer to step 2), it will display you a list of all the items in your cart along with the total. You will be presented with two fields " +
                    "that ask for a name and address. Once you've filled both fields, click the 'Purchase' button. Otherwise, click the 'Cancel' " +
                    "button. And that's it! A message at the bottom will confirm with you that your order has been made. Guests will not be able to review their order history "
    }

    //Back button
    fun backOnClick(view: android.view.View) {
        val mainIntent = Intent(this, MainActivity::class.java)
        startActivity(mainIntent)
    }
}
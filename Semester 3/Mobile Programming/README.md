# Mobile Programming Final - Grocery Delivery Project
![GroceryDeliveryProject](https://user-images.githubusercontent.com/101066826/191895928-61ea9143-7154-477f-8ff5-7785daf187f9.png)


### I created this app in 2021 in the third semester as a final for the "Mobile Programming" course at Humber. I was instructed to create an app that solves a problem and contains a database. Since at the time COVID-19 lockdown was happening, I decided to create an app that mimics DoorDash or Instacart. Basically it's an app that allows you to order groceries from different stores and have it delived to your home.

## Tech used: ![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white) ![Android](https://img.shields.io/badge/RoomDB-3DDC84?style=for-the-badge&logo=android&logoColor=white)
The app has 12 activities, 4 entities, 2 fragments, a database access object class, a database class, 17 drawables, 12 layouts (portrait & landscape), and two menus.

Video demo explaining the main functionality: <a href="https://www.youtube.com/watch?v=gDQBWiqnc2c">Demo video</a>

In MainActivty's onResume method, Runnable is used to change the facts image every three seconds. The onResume method also checks if there was any user
that was previously logged in by checking the sharedPreferences file. The rest of the class is button and menu item click listeners that redirect
to a new activity.

The AboutActivity just displays a simple TextView that describes the app. The back button's click listener will redirect to the MainActivity.

The HelpActivity displays how to use the app with and without an account. The TextView's text will change depending on which button you click. The back button listener will redirect to MainActivity.

The SignupActivity has 2 click listeners. The cancel button listener redirects back to the MainActivity. The confirm button listener validates all the fields and checks if the entered username is already taken. If the username isn't taken, a UserEntity object is stored in the database. After this, the user is redirected to LoginActivity.

The LoginActivity also has 2 click listeners. The cancel button listener will redirect the user back to the MainActivity. The login button listener will validate the text fields, and check if a user with those details is registered using the database. If the user passes all the validations, there username
is gets stored in sharedPreferences and they're redirected to the AccountMenuActivity

The AccountMenuActivity has 4 click listners. The logout listner clears sharedPreferences and redirects the user back to the MainActivity. The browse button listener redirects the user to the BrowseActivity. The order history button listener redirects the user to the OrderHistoryActivity. I will write about onOptionsMenu later in this file.

BrowseActivity contains 5 click listeners. The cancel button listener will redirect the app back to the MainActivity. The rest of the store button listeners set the store's name in sharedPreferences under the variable "STORE" and redirect to the StoreActivity. 

OrderHistoryActivity searches the database for the user's previous orders and adds that information to a scrollable text area. It also has a back button listener that redirects to AccountMenuActivity.

StoreActivity contains 5 button click listeners. The cancel button listener redirects to BrowseActivity. The rest of the listeners store what was clicked into sharedPreferences under the variable "CATEGORY". The listener then redirects the app to FoodActivity. The logo of the store is decided by checking what is stored in the "STORE" variable in the sharedPreferences file. 

FoodActivity populates its ListView based on the button that was clicked in StoreActivity. For example, if the "produce" button was clicked, the ListView would be populated with all produce foods sold at that store. FoodActivity knows what was clicked by checking the "CATEGORY" and "STORE" variables from the sharedPreferences file.

CartActivity will populate a listview by using the database to find what they have stored in the cart. The back button listener will redirect to either AccountMenuActivity, BrowseActivity, StoreActivity, FoodActivity, or OrderHistoryActivity. The clear button listener will clear the user's cart from the database. The checkout button listener will first validate if the user has anything stored in their cart. If the validation passes, the app is redirected to the CheckoutActivity.

CheckoutActivity will populate a scrollable TextView with whatever's stored for the user's cart in the database along with a calculated total. If the user is a guest, they will be able to write their information with text boxes. There are 2 button click listeners. The cancel button listener will redirect the app back to CartActivity. The purchase button listener will validate the text fields (if the user is a guest) and then store the order in the database using an OrdersEntity object.

BrowseActivity, AccountMenuActivity, FoodActivity, OrderHistoryActivty, MainActivity, and StoreActivity all contain a method called "onCreateOptionsMenu" and "OnOptionsItemSelected". What these two methods do in these activities is populate the menu with the shopping cart_menu.xml and redirect the user to the CartActivity.

The four entities are: CartEntity, OrdersEntity, ProductsEntity, and UserEntity. CartEntity represents the table that stores' the user's cart. OrdersEntity stores orders that were made on the app. ProductsEntity stores the product information from the other stores. Lastly, UserEntity stores the account details of each user that uses the app.

The database access object class (GroceryDirectDao) provides methods that activities can use to interact with the database. The actual database class has code that creates the database and then prepopulates the data with product information.

## Optimizations
Some areas of improvement this project could use are increasing the readability. For example, In most of the activities, you will see code that checks if the "USERNAME" variable in sharedPreferences is empty or not. This code checks if the user was previously logged in. A potential problem with that code is that it could be unnecessarily repeated throughout the program which means it violates the DRY principle. One way I could fix this is by creating a class that has a method that would automatically run this code. This way I wouldn't have to copy and paste the same code. Another this regarding readability is the project structure. All the Activities, Entities, Fragments, and Database classes are contained in one folder. This makes it harder for someone to navigate the project structure. A simple fix I could implement is creating folders that hold Activities, Entities, Fragments, and Database classes.

## Lessons Learned:
Although I've done labs and assignments, this was the first big project that I created in Android Studio. I learned a lot of new ways to contain data. For example, ScrollViews were very helpful when it came to making the landscape layouts of the app. I also learned a little bit about how I can use Runnable to constantly run code. This project also got me thinking more about planning my projects. For instance, I created the project using ROOM DB, but if I were to do it again I would use a database that saves to a cloud (like Firebase).

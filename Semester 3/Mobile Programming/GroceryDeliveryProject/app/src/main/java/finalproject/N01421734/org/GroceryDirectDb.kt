package finalproject.N01421734.org

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import android.widget.Toast
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [UserEntity::class, ProductsEntity::class, OrdersEntity::class, CartEntity::class], version = 1)
abstract class GroceryDirectDatabase : RoomDatabase() {
    abstract fun groceryDao():GroceryDirectDao

    companion object {
        @Volatile
        private var INSTANCE: GroceryDirectDatabase? = null
        private val CALLBACK = object : RoomDatabase.Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                prepopulateProducts(db)
            }
        }

        fun getInstance(context: Context): GroceryDirectDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    GroceryDirectDatabase::class.java,
                    "GroceryDirect.db")
                    .allowMainThreadQueries()
                    .addCallback(CALLBACK)
                    .build()
            }
            return INSTANCE as GroceryDirectDatabase
        }

        fun prepopulateProducts(db: SupportSQLiteDatabase){
            //Metro
            //Produce
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (1, 'Apple', '0.43', 'Produce', 'Metro')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (2, 'Banana', '0.39', 'Produce', 'Metro')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (3, 'Lime', '0.59', 'Produce', 'Metro')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (4, 'Kiwi', '0.49', 'Produce', 'Metro')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (5, 'Pear', '0.38', 'Produce', 'Metro')")
            //Frozen
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (6, 'Vanilla Ice Cream', '2.97', 'Frozen', 'Metro')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (7, 'Cookie Dough Ice Cream', '1.97', 'Frozen', 'Metro')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (8, 'Frozen Pizza', '7.49', 'Frozen', 'Metro')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (9, 'Frozen Peas', '2.99', 'Frozen', 'Metro')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (10, 'Waffles', '8.99', 'Frozen', 'Metro')")
            //Dairy
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (11, '2% Milk', '7.69', 'Dairy', 'Metro')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (12, 'Large Eggs', '4.99', 'Dairy', 'Metro')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (13, 'Salted Butter', '2.29', 'Dairy', 'Metro')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (14, 'Cream Cheese', '3.99', 'Dairy', 'Metro')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (15, 'Shredded Mozzarella Cheese', '2.79', 'Dairy', 'Metro')")
            //Pantry
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (16, 'Peanut Butter', '3.99', 'Pantry', 'Metro')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (17, 'Tomato Paste', '1.69', 'Pantry', 'Metro')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (18, 'Brown Sugar', '3.99', 'Pantry', 'Metro')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (19, 'Chickpeas', '2.99', 'Pantry', 'Metro')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (20, 'Quick Oats', '1.49', 'Pantry', 'Metro')")

            //Walmart
            //Produce
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (21, 'Apple', '0.83', 'Produce', 'Walmart')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (22, 'Banana', '0.29', 'Produce', 'Walmart')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (23, 'Lime', '0.79', 'Produce', 'Walmart')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (24, 'Kiwi', '0.99', 'Produce', 'Walmart')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (25, 'Pear', '0.88', 'Produce', 'Walmart')")
            //Frozen
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (26, 'Vanilla Ice Cream', '3.97', 'Frozen', 'Walmart')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (27, 'Cookie Dough Ice Cream', '3.97', 'Frozen', 'Walmart')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (28, 'Frozen Pizza', '5.49', 'Frozen', 'Walmart')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (29, 'Frozen Peas', '3.99', 'Frozen', 'Walmart')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (30, 'Waffles', '2.99', 'Frozen', 'Walmart')")
            //Dairy
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (31, '2% Milk', '4.69', 'Dairy', 'Walmart')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (32, 'Large Eggs', '4.99', 'Dairy', 'Walmart')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (33, 'Salted Butter', '7.29', 'Dairy', 'Walmart')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (34, 'Cream Cheese', '4.99', 'Dairy', 'Walmart')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (35, 'Shredded Mozzarella Cheese', '5.79', 'Dairy', 'Walmart')")
            //Pantry
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (36, 'Peanut Butter', '7.99', 'Pantry', 'Walmart')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (37, 'Tomato Paste', '0.69', 'Pantry', 'Walmart')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (38, 'Brown Sugar', '2.99', 'Pantry', 'Walmart')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (39, 'Chickpeas', '0.99', 'Pantry', 'Walmart')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (40, 'Quick Oats', '4.49', 'Pantry', 'Walmart')")

            //Superstore
            //Produce
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (41, 'Apple', '0.13', 'Produce', 'Superstore')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (42, 'Banana', '0.39', 'Produce', 'Superstore')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (43, 'Lime', '0.99', 'Produce', 'Superstore')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (44, 'Kiwi', '0.49', 'Produce', 'Superstore')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (45, 'Pear', '0.38', 'Produce', 'Superstore')")
            //Frozen
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (46, 'Vanilla Ice Cream', '3.37', 'Frozen', 'Superstore')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (47, 'Cookie Dough Ice Cream', '3.27', 'Frozen', 'Superstore')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (48, 'Frozen Pizza', '5.29', 'Frozen', 'Superstore')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (49, 'Frozen Peas', '3.59', 'Frozen', 'Superstore')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (50, 'Waffles', '2.69', 'Frozen', 'Superstore')")
            //Dairy
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (51, '2% Milk', '4.39', 'Dairy', 'Superstore')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (52, 'Large Eggs', '4.29', 'Dairy', 'Superstore')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (53, 'Salted Butter', '7.19', 'Dairy', 'Superstore')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (54, 'Cream Cheese', '4.39', 'Dairy', 'Superstore')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (55, 'Shredded Mozzarella Cheese', '5.39', 'Dairy', 'Superstore')")
            //Pantry
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (56, 'Peanut Butter', '7.29', 'Pantry', 'Superstore')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (57, 'Tomato Paste', '0.39', 'Pantry', 'Superstore')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (58, 'Brown Sugar', '2.79', 'Pantry', 'Superstore')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (59, 'Chickpeas', '1.49', 'Pantry', 'Superstore')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (60, 'Quick Oats', '4.39', 'Pantry', 'Superstore')")

            //Food Basics
            //Produce
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (61, 'Apple', '0.83', 'Produce', 'Food Basics')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (62, 'Banana', '0.29', 'Produce', 'Food Basics')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (63, 'Lime', '0.79', 'Produce', 'Food Basics')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (64, 'Kiwi', '0.99', 'Produce', 'Food Basics')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (65, 'Pear', '0.88', 'Produce', 'Food Basics')")
            //Frozen
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (66, 'Vanilla Ice Cream', '3.97', 'Frozen', 'Food Basics')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (67, 'Cookie Dough Ice Cream', '3.97', 'Frozen', 'Food Basics')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (68, 'Frozen Pizza', '5.49', 'Frozen', 'Food Basics')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (69, 'Frozen Peas', '3.99', 'Frozen', 'Food Basics')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (70, 'Waffles', '2.99', 'Frozen', 'Food Basics')")
            //Dairy
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (71, '2% Milk', '4.69', 'Dairy', 'Food Basics')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (72, 'Large Eggs', '4.99', 'Dairy', 'Food Basics')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (73, 'Salted Butter', '7.29', 'Dairy', 'Food Basics')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (74, 'Cream Cheese', '4.99', 'Dairy', 'Food Basics')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (75, 'Shredded Mozzarella Cheese', '5.79', 'Dairy', 'Food Basics')")
            //Pantry
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (76, 'Peanut Butter', '7.99', 'Pantry', 'Food Basics')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (77, 'Tomato Paste', '0.69', 'Pantry', 'Food Basics')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (78, 'Brown Sugar', '2.99', 'Pantry', 'Food Basics')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (79, 'Chickpeas', '0.99', 'Pantry', 'Food Basics')")
            db.execSQL("INSERT INTO Products (product_id, product_name, price, category, location) VALUES (80, 'Quick Oats', '4.49', 'Pantry', 'Food Basics')")
        }
    }
}
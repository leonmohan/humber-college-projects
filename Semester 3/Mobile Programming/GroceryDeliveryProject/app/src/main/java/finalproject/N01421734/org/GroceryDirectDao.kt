package finalproject.N01421734.org

import androidx.room.*

@Dao
interface GroceryDirectDao {

    @Query("SELECT * FROM Users WHERE username = :userInput")
    fun findUser(userInput: String): List<UserEntity>

    @Query("SELECT * FROM Products WHERE location = :location AND category = :category")
    fun selectFood(location: String, category: String): List<ProductsEntity>

    @Query("DELETE FROM Cart WHERE username = :username")
    fun clearCart(username: String)

    @Query("SELECT * FROM Cart WHERE username = :username")
    fun selectCart(username: String): List<CartEntity>

    @Query("SELECT * FROM Products WHERE location = :location AND product_name = :product_name")
    fun selectPrice(location: String, product_name: String): List<ProductsEntity>

    @Query("SELECT * FROM Orders WHERE username = :username")
    fun selectOrders(username: String): List<OrdersEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHistory(record: OrdersEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCart(cart: CartEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserEntity)

}
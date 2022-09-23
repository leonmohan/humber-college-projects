package finalproject.N01421734.org

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//order_id, username, product_id, quantity, date, paid
@Entity(tableName = "Orders")
data class OrdersEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name= "order_id")
    var orderId: Int,
    @ColumnInfo(name = "username")
    var customerUsername: String,
    var order_content: String,
    var date: String
)
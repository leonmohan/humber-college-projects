package finalproject.N01421734.org

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//username, product_id, quantity
@Entity(tableName = "Cart")
data class CartEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name= "username")
    var customerUsername: String,
    var product_name: String,
    var store: String
)
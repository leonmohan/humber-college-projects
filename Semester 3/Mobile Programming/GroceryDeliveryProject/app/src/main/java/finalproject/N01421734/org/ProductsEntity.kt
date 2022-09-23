package finalproject.N01421734.org

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

//id, fullName/product_name, price, stock, category location
@Entity(tableName = "Products")
data class ProductsEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "product_id")
    var productId: Int = 0,
    var product_name: String = "",
    var price: String = "",
    var category: String = "",
    var location: String = ""
)
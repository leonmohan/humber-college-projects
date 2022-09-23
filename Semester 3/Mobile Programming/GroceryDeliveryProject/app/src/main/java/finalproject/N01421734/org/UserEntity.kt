package finalproject.N01421734.org

import androidx.room.Entity
import androidx.room.PrimaryKey

//username, password, email, phone, address
@Entity(tableName = "Users")
data class UserEntity(
    @PrimaryKey()
    var username: String,
    var password: String,
    var email: String,
    var phone: String,
    var address: String
)
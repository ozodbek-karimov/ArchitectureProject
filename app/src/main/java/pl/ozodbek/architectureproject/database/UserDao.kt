package pl.ozodbek.architectureproject.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    fun addUser(userEntity: UserEntity)

    @Query("Select * from UserEntity order by name asc, age asc ")
    fun getUsers(): List<UserEntity>

}
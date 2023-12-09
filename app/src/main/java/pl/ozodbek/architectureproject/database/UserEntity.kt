package pl.ozodbek.architectureproject.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(

    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val age: Int

)
package pl.ozodbek.architectureproject.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [UserEntity::class], version = 2)
abstract class AppDatabase: RoomDatabase(){

    abstract fun userDao(): UserDao

    companion object{
        private var INSTANCE : AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "my_database")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE!!
        }
    }
}
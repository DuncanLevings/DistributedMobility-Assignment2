package sheridan.levings.assignment2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DiceRoll::class], version = 1, exportSchema = false)
abstract class DiceRollDatabase: RoomDatabase() {
    abstract val diceRollDao: DiceRollDao

    companion object{

        @Volatile
        private var INSTANCE: DiceRollDatabase? = null

        fun getInstance(context: Context): DiceRollDatabase {

            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DiceRollDatabase::class.java,
                        "diceRoll_database"
                    ).fallbackToDestructiveMigration().build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}

package sheridan.levings.assignment2.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DiceRollDao {
    @Insert
    suspend fun insert(diceRoll: DiceRoll): Long

    @Query("SELECT * FROM diceRoll WHERE id=:key")
    fun get(key: Long) : LiveData<DiceRoll>

    @Query("SELECT * FROM diceRoll ORDER BY id")
    fun getAll() : LiveData<List<DiceRoll>>

    @Delete
    suspend fun delete(diceRoll: DiceRoll)

    @Query("DELETE FROM diceRoll")
    suspend fun deleteAll()
}

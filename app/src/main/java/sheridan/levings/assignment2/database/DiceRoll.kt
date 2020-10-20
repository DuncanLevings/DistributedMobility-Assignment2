package sheridan.levings.assignment2.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "diceRoll")
data class DiceRoll (
    @PrimaryKey(autoGenerate = true)
    var id: Long,

    @ColumnInfo(name = "dice_total")
    val diceTotal: String,
)
package sheridan.levings.assignment2.history

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import sheridan.levings.assignment2.database.DiceRoll
import sheridan.levings.assignment2.database.DiceRollDao
import sheridan.levings.assignment2.database.DiceRollDatabase
import kotlinx.coroutines.launch

class HistoryViewModel(application: Application) : AndroidViewModel(application) {

    private val diceRollDao: DiceRollDao =
        DiceRollDatabase.getInstance(application).diceRollDao

    val history: LiveData<List<DiceRoll>> = diceRollDao.getAll()

    fun clear(){
        viewModelScope.launch {
            diceRollDao.deleteAll()
        }
    }

}
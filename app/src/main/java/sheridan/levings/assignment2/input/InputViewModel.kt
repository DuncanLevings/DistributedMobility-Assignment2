package sheridan.levings.assignment2.input

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import sheridan.levings.assignment2.database.DiceRoll
import sheridan.levings.assignment2.database.DiceRollDao
import sheridan.levings.assignment2.database.DiceRollDatabase
import kotlinx.coroutines.launch

class InputViewModel(application: Application) : AndroidViewModel(application) {

    private val _diceRollId = MutableLiveData<Long?>().apply{
        value = null
    }

    val diceRollId: LiveData<Long?> = _diceRollId

    private val diceRollDao: DiceRollDao =
        DiceRollDatabase.getInstance(application).diceRollDao

    fun send(diceRoll: DiceRoll){
        viewModelScope.launch {
            println(diceRoll)
            _diceRollId.value = diceRollDao.insert(diceRoll)
        }
    }

    fun reset(){
        _diceRollId.value = null
    }
}
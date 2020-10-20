package sheridan.levings.assignment2.input

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import sheridan.levings.assignment2.database.DiceRoll
import sheridan.levings.assignment2.databinding.InputFragmentBinding
import java.util.*

class InputFragment : Fragment() {

    private lateinit var binding: InputFragmentBinding
    private val viewModel: InputViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = InputFragmentBinding.inflate(inflater, container, false)

        super.onCreate(savedInstanceState);
        // recovering the instance state
        if (savedInstanceState != null) {
            binding.txtDice1.text = savedInstanceState.getString("dice1")
            binding.txtDice2.text = savedInstanceState.getString("dice2")
            binding.txtDice3.text = savedInstanceState.getString("dice3")
        }

        binding.btnRoll.setOnClickListener { send() }

        return binding.root
    }

    private fun send(){
        //generate dice rolls and display
        val roll1 = Random().nextInt(6) + 1
        val roll2 = Random().nextInt(6) + 1
        val roll3 = Random().nextInt(6) + 1

        val total = roll1 + roll2 + roll3

        binding.txtDice1.text = roll1.toString()
        binding.txtDice2.text = roll2.toString()
        binding.txtDice3.text = roll3.toString()

        viewModel.send(DiceRoll(0, "$roll1 + $roll2 + $roll3 = $total"))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("dice1", binding.txtDice1.text.toString())
        outState.putString("dice2", binding.txtDice2.text.toString())
        outState.putString("dice3", binding.txtDice3.text.toString())

        super.onSaveInstanceState(outState)
    }
}
package sheridan.levings.assignment2.input

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import sheridan.levings.assignment2.R
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
}
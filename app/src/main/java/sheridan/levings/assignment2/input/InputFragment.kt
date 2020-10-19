package sheridan.levings.assignment2.input

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sheridan.levings.assignment2.R
import androidx.lifecycle.ViewModelProvider as ViewModelProvider1

class InputFragment : Fragment() {

    companion object {
        fun newInstance() = InputFragment()
    }

    private lateinit var viewModel: InputViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.input_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider1(this).get(InputViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
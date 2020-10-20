package sheridan.levings.assignment2.history

import android.app.Activity
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import sheridan.levings.assignment2.R
import sheridan.levings.assignment2.database.DiceRoll
import sheridan.levings.assignment2.databinding.HistoryFragmentBinding

class HistoryFragment : Fragment() {

    private lateinit var binding: HistoryFragmentBinding

    private lateinit var adapter: HistoryRecyclerFragment

    private val viewModel: HistoryViewModel by viewModels()

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = HistoryFragmentBinding.inflate(inflater, container, false)

        // make the adapter
        adapter = HistoryRecyclerFragment(requireContext())

        with(binding){
            val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            recyclerView.addItemDecoration(divider)
            recyclerView.adapter = adapter
        }

        viewModel.history.observe(viewLifecycleOwner){ refreshHistory(it) }

        navController = findNavController()

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_history, menu)
    }

    private fun refreshHistory(list: List<DiceRoll>?) {
        adapter.history = list
        val count = list?.size ?: 0
        binding.historyTotal.text =
            resources.getQuantityString(R.plurals.history_total, count, count)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.clear -> {
                clear()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun clear(){
        viewModel.clear()
    }
}
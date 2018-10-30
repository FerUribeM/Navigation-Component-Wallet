package com.ferbajoo.personal_wallet.fragments

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.*
import androidx.navigation.NavHost
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.ferbajoo.personal_wallet.R
import com.ferbajoo.personal_wallet.adapters.ExpensesAdapter
import com.ferbajoo.personal_wallet.adapters.onListenerExpenses
import com.ferbajoo.personal_wallet.models.DummyExpensed
import com.ferbajoo.personal_wallet.viewmodels.ExpensesViewModel
import kotlinx.android.synthetic.main.expenses_fragment.*

class ExpensesFragment : Fragment() {

    private lateinit var viewModel: ExpensesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mView = inflater.inflate(R.layout.expenses_fragment, container, false)
        setHasOptionsMenu(true)

        return mView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ExpensesViewModel::class.java)

        initRecycler()

        viewModel.loadDummyData()

        viewModel.getDataDummy().subscribe(this::setData).dispose()
    }

    private fun initRecycler() {
        rv_expenses.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_expenses.itemAnimator = DefaultItemAnimator()
        rv_expenses.adapter = ExpensesAdapter()
    }

    private fun setData(list: List<DummyExpensed>) {
        (rv_expenses.adapter as ExpensesAdapter).setData(list)
        (rv_expenses.adapter as ExpensesAdapter).setListener(object : onListenerExpenses {
            override fun onClickItem(name: String) {
                val direction = ExpensesFragmentDirections.actionNavExpensedToDetailExpenses()
                direction.setNameProduct(name)
                direction.setCost(10)
                findNavController().navigate(direction)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.expenses_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.filter_zone -> {
                Log.e("Mensaje", "Filter")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}

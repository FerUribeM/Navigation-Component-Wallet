package com.ferbajoo.personal_wallet.adapters

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.android.databinding.library.baseAdapters.BR
import com.ferbajoo.personal_wallet.R
import com.ferbajoo.personal_wallet.databinding.ItemExpensesBinding
import com.ferbajoo.personal_wallet.models.DummyExpensed

class ExpensesAdapter : RecyclerView.Adapter<ExpensesAdapter.ExpensedViewHolder>() {

    private val list = mutableListOf<DummyExpensed>()

    private var listener: onListenerExpenses? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpensedViewHolder {
        val binding = ItemExpensesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExpensedViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ExpensedViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setData(data: List<DummyExpensed>) {
        list.addAll(data)
        notifyDataSetChanged()
    }

    fun setListener(listener: onListenerExpenses) {
        this.listener = listener
    }

    inner class ExpensedViewHolder(val binding: ItemExpensesBinding?) : RecyclerView.ViewHolder(binding?.root) {

        fun bind(item: DummyExpensed) {
            binding?.setVariable(BR.model, item)
            binding?.executePendingBindings()

            binding?.root?.findViewById<CardView>(R.id.cv_item)?.setOnClickListener {
                listener?.onClickItem(item.name)
            }
        }

    }

}

interface onListenerExpenses {
    fun onClickItem(name: String)
}

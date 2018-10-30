package com.ferbajoo.personal_wallet.viewmodels

import android.arch.lifecycle.ViewModel
import com.ferbajoo.personal_wallet.models.DummyExpensed
import io.reactivex.subjects.BehaviorSubject

class ExpensesViewModel : ViewModel() {

    private val dataDummy = BehaviorSubject.create<List<DummyExpensed>>()

    fun loadDummyData() {
        val list = mutableListOf<DummyExpensed>()
        list.add(DummyExpensed("Refresco", 10.5))
        list.add(DummyExpensed("Atun", 30.4))
        list.add(DummyExpensed("Pan",11.2))
        list.add(DummyExpensed("Tacos", 23.8))
        list.add(DummyExpensed("Otro", 10.5))
        dataDummy.onNext(list)
    }


    fun getDataDummy(): BehaviorSubject<List<DummyExpensed>> {
        return dataDummy
    }

}

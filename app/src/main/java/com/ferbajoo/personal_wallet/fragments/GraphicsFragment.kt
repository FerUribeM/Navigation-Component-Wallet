package com.ferbajoo.personal_wallet.fragments

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ferbajoo.personal_wallet.R
import com.ferbajoo.personal_wallet.viewmodels.GraphicsViewModel

class GraphicsFragment : Fragment() {

    private lateinit var viewModel: GraphicsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.graphics_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GraphicsViewModel::class.java)
    }

}

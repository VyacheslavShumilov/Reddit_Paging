package com.vshum.reddit.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.ExperimentalPagingApi
import com.vshum.reddit.R
import com.vshum.reddit.base.BaseFragment
import com.vshum.reddit.databinding.FragmentMainBinding
import org.koin.java.KoinJavaComponent

@ExperimentalPagingApi
class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private val scope = KoinJavaComponent.getKoin().createScope<MainFragment>()
    private val viewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


}
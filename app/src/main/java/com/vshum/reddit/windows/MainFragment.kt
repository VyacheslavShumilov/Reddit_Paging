package com.vshum.reddit.windows

import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.vshum.reddit.base.BaseFragment
import com.vshum.reddit.databinding.FragmentMainBinding
import com.vshum.reddit.di.Scopes
import com.vshum.reddit.windows.adapter.MainAdapter
import kotlinx.coroutines.launch
import org.koin.core.qualifier.named
import org.koin.java.KoinJavaComponent

@ExperimentalPagingApi
class MainFragment: BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private val scope = KoinJavaComponent.getKoin().createScope<MainFragment>()
    private val viewModel: MainViewModel = scope.get(qualifier = named(Scopes.MAIN_VIEW_MODEL))
    private val adapter = MainAdapter()

    override fun afterOnCreateView() {
        viewModel.getPostsLiveData().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                adapter.submitData(it)
            }
        }

        initViews()
    }

    /** Инициализация view на экране */
    private fun initViews() {
        binding?.let {
            it.recyclerview.adapter = adapter
            it.recyclerview.layoutManager = LinearLayoutManager(requireContext())
            it.recyclerview.itemAnimator = DefaultItemAnimator()
            it.recyclerview.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        }
    }
}
package com.boostcampwm2023.snappoint.presentation.viewpost.post

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.boostcampwm2023.snappoint.R
import com.boostcampwm2023.snappoint.databinding.FragmentPostBinding
import com.boostcampwm2023.snappoint.presentation.base.BaseFragment
import com.boostcampwm2023.snappoint.presentation.viewpost.ViewPostViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PostFragment : BaseFragment<FragmentPostBinding>(R.layout.fragment_post) {

    private val postViewModel: PostViewModel by viewModels()
    private val viewPostViewModel: ViewPostViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postViewModel.updatePost(viewPostViewModel.posts.value[viewPostViewModel.selectedIndex.value])

        initBinding()

        collectViewModelData()
    }

    private fun initBinding() {
        with(binding) {
            vm = postViewModel
        }
    }

    private fun collectViewModelData() {
        lifecycleScope.launch {
            postViewModel.event.collect {
                when (it) {
                    PostEvent.navigatePrev -> {
                        if (!findNavController().popBackStack()) {
                            viewPostViewModel.finishPostView()
                        }
                    }
                }
            }
        }
    }
}
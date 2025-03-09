package com.hepsihikaye.android.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hepsihikaye.android.R
import com.hepsihikaye.android.databinding.FragmentHomeBinding
import com.hepsihikaye.android.ui.home.adapter.FeaturedPostsAdapter
import com.hepsihikaye.android.ui.home.adapter.PostAdapter
import com.hepsihikaye.android.util.Resource

class HomeFragment : Fragment() {
    
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    
    private lateinit var viewModel: HomeViewModel
    private lateinit var featuredAdapter: FeaturedPostsAdapter
    private lateinit var recentAdapter: PostAdapter
    private lateinit var popularAdapter: PostAdapter
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupViewModel()
        setupRecyclerViews()
        setupObservers()
        setupSwipeRefresh()
        
        // Initial data load
        viewModel.loadHomeData()
    }
    
    private fun setupViewModel() {
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
    }
    
    private fun setupRecyclerViews() {
        // Featured posts adapter
        featuredAdapter = FeaturedPostsAdapter { postId ->
            navigateToPostDetail(postId)
        }
        binding.rvFeaturedStories.adapter = featuredAdapter
        
        // Recent posts adapter
        recentAdapter = PostAdapter { postId ->
            navigateToPostDetail(postId)
        }
        binding.rvRecentPosts.adapter = recentAdapter
        
        // Popular posts adapter
        popularAdapter = PostAdapter { postId ->
            navigateToPostDetail(postId)
        }
        binding.rvPopularPosts.adapter = popularAdapter
    }
    
    private fun setupObservers() {
        viewModel.homeData.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.swipeRefresh.isRefreshing = true
                }
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.swipeRefresh.isRefreshing = false
                    
                    resource.data?.let { homeResponse ->
                        // Show content
                        binding.contentLayout.visibility = View.VISIBLE
                        binding.errorLayout.visibility = View.GONE
                        
                        // Update adapters
                        featuredAdapter.submitList(homeResponse.featured_posts)
                        recentAdapter.submitList(homeResponse.recent_posts)
                        popularAdapter.submitList(homeResponse.most_liked_posts)
                    }
                }
                is Resource.Error -> {
                    binding.progressBar.visibility = View.GONE
                    binding.swipeRefresh.isRefreshing = false
                    
                    // Show error layout
                    binding.contentLayout.visibility = View.GONE
                    binding.errorLayout.visibility = View.VISIBLE
                    binding.errorMessage.text = resource.message
                    
                    Toast.makeText(context, resource.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    
    private fun setupSwipeRefresh() {
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.loadHomeData()
        }
    }
    
    private fun navigateToPostDetail(postId: Int) {
        // Will implement navigation to post detail
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 
package com.apna.darzi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.apna.darzi.databinding.FragmentBuyBinding
import com.apna.darzi.ui.BuyViewModel
import kotlinx.coroutines.launch

class BuyFragment : Fragment() {

    private var _binding: FragmentBuyBinding? = null
    private val binding get() = _binding!!
    private val viewModel: BuyViewModel by viewModels()
    private val shopAdapter = ShopAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBuyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.allshopsRecyclerview.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = shopAdapter
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.shops.collect { shops ->
                    shopAdapter.submitList(shops)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

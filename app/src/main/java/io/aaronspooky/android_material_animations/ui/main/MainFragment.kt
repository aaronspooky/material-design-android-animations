package io.aaronspooky.android_material_animations.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import io.aaronspooky.android_material_animations.R
import io.aaronspooky.android_material_animations.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        binding = MainFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        didTapNextFragment()
    }

    private fun didTapNextFragment() {
        binding.button.setOnClickListener {
            val extras = FragmentNavigatorExtras(binding.root to "shared_element_container")
            findNavController().navigate(R.id.action_mainFragment_to_secondFragment, null, null, extras)
        }
    }
}
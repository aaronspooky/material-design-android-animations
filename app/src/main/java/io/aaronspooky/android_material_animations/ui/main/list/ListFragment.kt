package io.aaronspooky.android_material_animations.ui.main.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.transition.MaterialElevationScale
import io.aaronspooky.android_material_animations.R
import io.aaronspooky.android_material_animations.databinding.FragmentListBinding
import io.aaronspooky.android_material_animations.ui.main.list.adapter.ListAdapter

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var viewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        exitTransition = MaterialElevationScale(false)
        reenterTransition = MaterialElevationScale(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.simpleRecyclerView.apply {
            adapter = ListAdapter(::nextFragment)
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }
    
    private fun nextFragment(itemView: View) {
//        val transform = MaterialContainerTransform().apply {
//            startView = itemView
//            endView = binding.root
//            scrimColor = Color.TRANSPARENT
//        }
//
//        TransitionManager.beginDelayedTransition(binding.simpleRecyclerView, transform)

        val extras = FragmentNavigatorExtras(binding.root to "shared_element_detail")
        findNavController().navigate(R.id.action_listFragment_to_detailFragment, null, null, extras)
    }

}
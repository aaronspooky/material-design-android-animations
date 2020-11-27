package io.aaronspooky.android_material_animations.ui.main.animations.axis_y

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialSharedAxis
import io.aaronspooky.android_material_animations.R
import io.aaronspooky.android_material_animations.databinding.FragmentAxisYBinding

class AxisYFragment : Fragment() {

    private lateinit var binding: FragmentAxisYBinding
    private lateinit var viewModel: AxisYViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        exitTransition = MaterialSharedAxis(MaterialSharedAxis.Y, true)
        reenterTransition = MaterialSharedAxis(MaterialSharedAxis.Y, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAxisYBinding.inflate(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AxisYViewModel::class.java)
        didTapTestButton()
    }

    private fun didTapTestButton() {
        binding.button2.setOnClickListener {
            val extras = FragmentNavigatorExtras(binding.root to "shared_element_axis_y")
            findNavController().navigate(R.id.action_axisYFragment_to_axisYAnimationFragment, null, null, extras)
        }
    }

}
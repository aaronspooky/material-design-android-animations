package io.aaronspooky.android_material_animations.ui.main.animations.axis_y

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialSharedAxis
import io.aaronspooky.android_material_animations.R
import io.aaronspooky.android_material_animations.databinding.FragmentAxisYBinding
import io.aaronspooky.android_material_animations.ui.main.second_fragment.AnimationType

class AxisYFragment : Fragment() {

    private lateinit var binding: FragmentAxisYBinding
    private lateinit var viewModel: AxisYViewModel
    private val args: AxisYFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        exitTransition = exitTransitionAnimation(AnimationType.fromInt(args.animationType))
        reenterTransition = reenterTransitionAnimation(AnimationType.fromInt(args.animationType))
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
            val action = AxisYFragmentDirections.actionAxisYFragmentToAxisYAnimationFragment(args.animationType)
            findNavController().navigate(action, extras)
        }
    }

    /**
     *
     */
    private fun exitTransitionAnimation(type: AnimationType): MaterialSharedAxis? =
        when(type) {
            AnimationType.AXIS_Y -> MaterialSharedAxis(MaterialSharedAxis.Y, true)
            AnimationType.AXIS_X -> MaterialSharedAxis(MaterialSharedAxis.X, true)
            AnimationType.AXIS_Z -> MaterialSharedAxis(MaterialSharedAxis.Z, true)
            AnimationType.UNKNOWN -> null
        }

    /**
     *
     */
    private fun reenterTransitionAnimation(type: AnimationType): MaterialSharedAxis? =
        when(type) {
            AnimationType.AXIS_Y -> MaterialSharedAxis(MaterialSharedAxis.Y, false)
            AnimationType.AXIS_X -> MaterialSharedAxis(MaterialSharedAxis.X, false)
            AnimationType.AXIS_Z -> MaterialSharedAxis(MaterialSharedAxis.Z, false)
            AnimationType.UNKNOWN -> null
        }
}
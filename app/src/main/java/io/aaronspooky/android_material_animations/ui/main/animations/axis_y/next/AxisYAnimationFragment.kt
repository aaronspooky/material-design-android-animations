package io.aaronspooky.android_material_animations.ui.main.animations.axis_y.next

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.google.android.material.transition.MaterialSharedAxis
import io.aaronspooky.android_material_animations.databinding.FragmentAxisYAnimationBinding
import io.aaronspooky.android_material_animations.ui.main.second_fragment.AnimationType

class AxisYAnimationFragment : Fragment() {

    private lateinit var binding: FragmentAxisYAnimationBinding
    private lateinit var viewModel: AxisYAnimationViewModel
    private val args: AxisYAnimationFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enterTransition = enterTransitionAnimation(AnimationType.fromInt(args.animationType))
        returnTransition = returnTransitionAnimation(AnimationType.fromInt(args.animationType))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAxisYAnimationBinding.inflate(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AxisYAnimationViewModel::class.java)
    }

    /**
     *
     */
    private fun enterTransitionAnimation(type: AnimationType): MaterialSharedAxis? {
        val customAnimation = when (type) {
            AnimationType.AXIS_Y -> MaterialSharedAxis(MaterialSharedAxis.Y, true)
            AnimationType.AXIS_X -> MaterialSharedAxis(MaterialSharedAxis.X, true)
            AnimationType.AXIS_Z -> MaterialSharedAxis(MaterialSharedAxis.Z, true)
            AnimationType.UNKNOWN -> null
        }
        customAnimation?.duration = 1000L
        return customAnimation
    }

    /**
     *
     */
    private fun returnTransitionAnimation(type: AnimationType): MaterialSharedAxis? =
        when(type) {
            AnimationType.AXIS_Y -> MaterialSharedAxis(MaterialSharedAxis.Y, false)
            AnimationType.AXIS_X -> MaterialSharedAxis(MaterialSharedAxis.X, false)
            AnimationType.AXIS_Z -> MaterialSharedAxis(MaterialSharedAxis.Z, false)
            AnimationType.UNKNOWN -> null
        }

}
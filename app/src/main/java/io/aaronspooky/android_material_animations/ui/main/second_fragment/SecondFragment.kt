package io.aaronspooky.android_material_animations.ui.main.second_fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.transition.MaterialContainerTransform
import io.aaronspooky.android_material_animations.R
import io.aaronspooky.android_material_animations.databinding.FragmentSecondBinding
import io.aaronspooky.android_material_animations.ui.main.animations.axis_y.AxisYFragmentDirections

enum class AnimationType(val type: Int) {
    AXIS_Y(1),
    AXIS_X(2),
    AXIS_Z(3),
    UNKNOWN(-1);

    /**
     *
     */
    companion object {
        fun fromInt(value: Int): AnimationType =
            when(value) {
                1 -> AXIS_Y
                2 -> AXIS_X
                3 -> AXIS_Z
                else -> UNKNOWN
            }
    }
}

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private lateinit var viewModel: SecondViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedElementEnterTransition = MaterialContainerTransform()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SecondViewModel::class.java)
        didTapAxisYButton()
        didTapAxisXButton()
        didTapAxisZButton()
        didTapAnimationOnRow()
    }

    private fun didTapAxisYButton() {
        binding.buttonAxisY.setOnClickListener {
            val action = SecondFragmentDirections.actionSecondFragmentToAxisYFragment(
                animationType = AnimationType.AXIS_Y.type
            )
            findNavController().navigate(action)
        }
    }

    private fun didTapAxisXButton() {
        binding.buttonAxisX.setOnClickListener {
            val action = SecondFragmentDirections.actionSecondFragmentToAxisYFragment(
                animationType = AnimationType.AXIS_X.type
            )
            findNavController().navigate(action)
        }
    }

    private fun didTapAxisZButton() {
        binding.buttonAxisZ.setOnClickListener {
            val action = SecondFragmentDirections.actionSecondFragmentToAxisYFragment(
                animationType = AnimationType.AXIS_Z.type
            )
            findNavController().navigate(action)
        }
    }

    private fun didTapAnimationOnRow() {
        binding.buttonRowAnimation.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_listFragment)
        }
    }
}
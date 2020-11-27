package io.aaronspooky.android_material_animations.ui.main.animations.axis_y.next

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialSharedAxis
import io.aaronspooky.android_material_animations.R
import io.aaronspooky.android_material_animations.databinding.FragmentAxisYAnimationBinding

class AxisYAnimationFragment : Fragment() {

    private lateinit var binding: FragmentAxisYAnimationBinding
    private lateinit var viewModel: AxisYAnimationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val enterTransitionCustom = MaterialSharedAxis(MaterialSharedAxis.Y, true)
        enterTransitionCustom.duration = 1000L
        enterTransition = enterTransitionCustom
        returnTransition = MaterialSharedAxis(MaterialSharedAxis.Y, false)
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

}
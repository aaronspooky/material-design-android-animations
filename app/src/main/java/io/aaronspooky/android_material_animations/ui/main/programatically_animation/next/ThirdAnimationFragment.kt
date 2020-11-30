package io.aaronspooky.android_material_animations.ui.main.programatically_animation.next

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.transition.MaterialSharedAxis
import io.aaronspooky.android_material_animations.R
import io.aaronspooky.android_material_animations.databinding.FragmentThirdAnimationBinding
import io.aaronspooky.android_material_animations.ui.main.programatically_animation.ThirdFragment

class ThirdAnimationFragment : Fragment() {

    private lateinit var binding: FragmentThirdAnimationBinding
    private lateinit var viewModel: ThirdAnimationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ true)
        returnTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ false)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdAnimationBinding.inflate(inflater)
        val args = requireArguments().getString(ThirdFragment.Constants.BUNDLE_ANIMATION_NAME)
        args?.let { binding.root.transitionName = it }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ThirdAnimationViewModel::class.java)
    }

}
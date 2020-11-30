package io.aaronspooky.android_material_animations.ui.main.programatically_animation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.google.android.material.transition.MaterialSharedAxis
import io.aaronspooky.android_material_animations.R
import io.aaronspooky.android_material_animations.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private lateinit var binding: FragmentThirdBinding
    private lateinit var viewModel: ThirdViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        exitTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ true)
        reenterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ false)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdBinding.inflate(inflater)
        // Set transition name programmatically
        binding.root.transitionName = Constants.TRANSITION_NAME
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ThirdViewModel::class.java)
        didTapNextButton()
    }

    private fun didTapNextButton() {
        binding.button3.setOnClickListener {
            // Set bundle name with its transition name
            val bundle = bundleOf(Constants.BUNDLE_ANIMATION_NAME to Constants.TRANSITION_NAME)
            // Pass transition name by navigator extras
            val extras = FragmentNavigatorExtras(binding.root to Constants.TRANSITION_NAME)
            // Add bundle and extras to next destination
            findNavController().navigate(R.id.thirdAnimationFragment, bundle, null, extras)
        }
    }

    /**
     *
     */
    object Constants {
        const val TRANSITION_NAME = "custom_animation"
        const val BUNDLE_ANIMATION_NAME = "animation_name"
    }
}
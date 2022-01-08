package com.olx.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.olx.android.databinding.FragmentSecondBinding
import com.olx.android.models.Ads

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (arguments?.get("ads") as Ads?)?.let { ads ->
            binding.tvTitleDetail.text = ads.title
            binding.tvAuthorDetail.text = ads.author
            binding.tvDescDetail.text = ads.description
            binding.tvPriceDetail.text = ads.price
            binding.tvLocationDetail.text = ads.location
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
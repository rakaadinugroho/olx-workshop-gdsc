package com.olx.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.olx.android.adapters.AdsAdapter
import com.olx.android.adapters.AdsListener
import com.olx.android.databinding.FragmentFirstBinding
import com.olx.android.models.Ads

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), AdsListener {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val listOfAds: List<Ads> by lazy { Ads.generateDummyAds() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // handle list of ads
        val adapter = AdsAdapter(listOfAds, this)

        with(binding.rvListAds) {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClickAds(ads: Ads) {
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundleOf("ads" to  ads))
    }
}
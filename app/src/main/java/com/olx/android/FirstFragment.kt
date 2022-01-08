package com.olx.android

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.olx.android.adapters.AdsAdapter
import com.olx.android.adapters.AdsListener
import com.olx.android.databinding.FragmentFirstBinding
import com.olx.android.models.Ads
import com.olx.android.utils.Database

class FirstFragment : Fragment(), AdsListener {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val database by lazy { Database() }

    private var listOfAds: ArrayList<Ads>  = arrayListOf()
    private lateinit var adsAdapter : AdsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        adsAdapter = AdsAdapter(listOfAds, this)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.rvListAds) {
            adapter = adsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        binding.fabCreateAds.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_createAdsFragment)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database.readAds(
            onError = { err ->
                Toast.makeText(requireContext(), "Error: $err", Toast.LENGTH_SHORT).show()
            } , onSuccess = { items ->
                listOfAds.clear()
                listOfAds.addAll(items)
                adsAdapter.notifyDataSetChanged()
            } )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClickAds(ads: Ads) {
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundleOf("ads" to  ads))
    }
}
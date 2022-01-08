package com.olx.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.olx.android.databinding.FragmentCreateAdsBinding
import com.olx.android.models.Ads
import com.olx.android.utils.Database

class CreateAdsFragment : Fragment() {
    private var _binding: FragmentCreateAdsBinding? = null
    private val binding get() = _binding!!

    private val database by lazy { Database() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCreateAdsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {
            database.createAds(
                Ads(
                    author = binding.etAuthor.text.toString(),
                    title = binding.etTitle.text.toString(),
                    price = binding.etPrice.text.toString(),
                    location = binding.etLocation.text.toString(),
                    description = binding.etDesc.text.toString()
                )
            )
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
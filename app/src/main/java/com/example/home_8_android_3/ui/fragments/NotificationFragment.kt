package com.example.home_8_android_3.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.home_8_android_3.databinding.FragmentNotificationBinding
import com.example.home_8_android_3.ui.utils.DESCRIPTION
import com.example.home_8_android_3.ui.utils.MyNotificationService

class NotificationFragment : Fragment() {

    private var binding: FragmentNotificationBinding? = null
    private lateinit var service: MyNotificationService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotificationBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        onClickListener()
    }

    private fun initialize() {
        service = MyNotificationService(requireContext())
    }

    private fun onClickListener() {
        binding?.sendButton?.setOnClickListener {
            DESCRIPTION = binding?.etMessage?.text.toString()
            service.showNotification()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
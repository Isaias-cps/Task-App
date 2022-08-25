package com.example.myapplication.Ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.Ui.adapter.ViewPagerAdapter
import com.example.myapplication.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = Firebase.auth

        configTablayiut()

        initClicks()
    }

    private fun initClicks(){
        binding.ibLogout.setOnClickListener{logoutApp()}
    }

    private fun logoutApp(){
        auth.signOut()
        findNavController().navigate(R.id.action_homeFragment_to_authentication)

    }

    private fun configTablayiut(){
        val adapter = ViewPagerAdapter(requireActivity())
        binding.viewPager.adapter = adapter

        adapter.addFragment(TodoFragment(), "Afazer")
        adapter.addFragment(DoingFragment(), "fazendo")
        adapter.addFragment(DoneFragment(), "Feitas")

        binding.viewPager.offscreenPageLimit = adapter.itemCount

        TabLayoutMediator(
            binding.tabs, binding.viewPager
        ) {tab, position ->
            tab.text = adapter.getTitle(
                position
            )
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.d2vlogin.LoginFeature.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.example.d2vlogin.R
import com.example.d2vlogin.databinding.FragmentLogInBinding
import com.example.d2vlogin.databinding.FragmentOnBoardBinding

class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHostFragment =
            requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.loginButton.setOnClickListener {
            navController.navigate(R.id.action_onBoardFragment2_to_logInFragment)
        }

        binding.signupButton.setOnClickListener {
            navController.navigate(R.id.action_onBoardFragment2_to_signUpFragment)
        }

    }


}

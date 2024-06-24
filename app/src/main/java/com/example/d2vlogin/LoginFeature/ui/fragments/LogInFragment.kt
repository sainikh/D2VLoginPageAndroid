package com.example.d2vlogin.LoginFeature.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import com.example.d2vlogin.LoginFeature.ui.Entity.UserAuth.isPasswordValid
import com.example.d2vlogin.LoginFeature.ui.Entity.UserAuth.isValidEmail
import com.example.d2vlogin.LoginFeature.ui.Entity.UserAuth.isValidMobile
import com.example.d2vlogin.R
import com.example.d2vlogin.databinding.ActivityMainBinding
import com.example.d2vlogin.databinding.FragmentLogInBinding


class LogInFragment : Fragment() {
    private lateinit var binding: FragmentLogInBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLogInBinding.inflate(layoutInflater,container,false)
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.backButton.setOnClickListener{
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        fun validateLogin(): Boolean {
            val email = binding.loginEmail.getText().toString().trim();
            val password = binding.loginPassword.getText().toString().trim();

            if (email.isEmpty()) {
                binding.loginEmail.error = "Email is required";
                return false;
            } else if (!email.trim().isValidEmail()) {
                binding.loginEmail.error = "Invalid Email";
                return false;
            }

            if (password.isEmpty()) {
                binding.loginPassword.error = "Password is required";
                return false;
            } else if (!password.isPasswordValid()) {
                binding.loginPassword.error = "Invalid Password";
                return false;
            }

            return true;
        }



        binding.loginButton.setOnClickListener{
            if (validateLogin()) {
                Toast.makeText(requireActivity(), "User Auth Successfully", Toast.LENGTH_LONG).show()
            }
        }

    }

}
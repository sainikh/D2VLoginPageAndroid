package com.example.d2vlogin.LoginFeature.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.d2vlogin.LoginFeature.ui.Entity.UserAuth.isPasswordValid
import com.example.d2vlogin.LoginFeature.ui.Entity.UserAuth.isValidEmail
import com.example.d2vlogin.LoginFeature.ui.Entity.UserAuth.isValidMobile
import com.example.d2vlogin.R
import com.example.d2vlogin.databinding.FragmentLogInBinding
import com.example.d2vlogin.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backButton.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        fun validateSignup(): Boolean {
            val name = binding.signupName.getText().toString().trim();
            val email = binding.signupEmail.getText().toString().trim();
            val password = binding.signupPassword.getText().toString().trim();

            if (name.isEmpty()) {
                binding.signupName.error = "Name is required";
                return false;
            }

            if (email.isEmpty()) {
                binding.signupEmail.error = "Email is required";
                return false;
            } else if (name.trim().isValidEmail() && email.isValidMobile()) {
                binding.signupEmail.error = "Invalid  Email";
                return false;
            }

            if (password.isEmpty()) {
                binding.signupPassword.error = "Password is required";
                return false;
            } else if (!password.isPasswordValid()) {
                binding.signupPassword.error = "Invalid Password";
                return false;
            }

            return true;
        }

        binding.signupButton.setOnClickListener {
            if (validateSignup()) {
                Toast.makeText(requireActivity(), "User Auth Successfully", Toast.LENGTH_LONG)
                    .show()
            }
        }

    }
}
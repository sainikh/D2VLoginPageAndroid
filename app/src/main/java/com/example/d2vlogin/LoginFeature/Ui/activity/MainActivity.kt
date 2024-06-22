package com.example.d2vlogin.LoginFeature.Ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.d2vlogin.LoginFeature.Ui.Entity.UserAuth.isPasswordValid
import com.example.d2vlogin.LoginFeature.Ui.Entity.UserAuth.isValidEmail
import com.example.d2vlogin.LoginFeature.Ui.Entity.UserAuth.isValidMobile

import com.example.d2vlogin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.switchToSignup.setOnClickListener {
            binding.viewSwitcher.showNext()
        }
        binding.switchToLogin.setOnClickListener {
            binding.viewSwitcher.showPrevious()

        }

        fun validateSignup(): Boolean {
            val emailOrMobile = binding.signupEmailOrMobile.getText().toString().trim();
            val password = binding.signupPassword.getText().toString().trim();
            val confirmPassword = binding.signupConfirmPassword.getText().toString().trim();

            if (emailOrMobile.isEmpty()) {
                binding.signupEmailOrMobile.error = "Email or Mobile Number is required";
                return false;
            } else if (emailOrMobile.trim().isValidEmail() && emailOrMobile.isValidMobile()) {
                binding.signupEmailOrMobile.error = "Invalid Phone / Email";
                return false;
            }

            if (password.isEmpty()) {
                binding.signupPassword.error = "Password is required";
                return false;
            } else if (!password.isPasswordValid()) {
                binding.signupPassword.error = "Invalid Password";
                return false;
            }

            if (!password.equals(confirmPassword)) {
                binding.signupConfirmPassword.error = "Passwords do not match";
                return false;
            }

            return true;
        }

        fun validateLogin(): Boolean {
            val emailOrMobile = binding.loginEmailOrMobile.getText().toString().trim();
            val password = binding.loginPassword.getText().toString().trim();

            if (emailOrMobile.isEmpty()) {
                binding.loginEmailOrMobile.error = "Email or Mobile Number is required";
                return false;
            } else if (!emailOrMobile.trim().isValidEmail() && !emailOrMobile.isValidMobile()) {
                binding.loginEmailOrMobile.error = "Invalid Phone / Email";
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

        binding.signupButton.setOnClickListener {

            if (validateSignup()) {
                Toast.makeText(this, "User Auth Successfully", Toast.LENGTH_LONG).show()

            }
        }


        binding.loginButton.setOnClickListener {

            if (validateLogin()) {
                Toast.makeText(this, "User Auth Successfully", Toast.LENGTH_LONG).show()
            }

        }
    }
}
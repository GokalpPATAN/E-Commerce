package com.patan.commerce.fragments.user

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.patan.commerce.databinding.FragmentEditUserBinding
import com.patan.commerce.fragments.BaseFragment
import com.patan.commerce.viewmodels.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditUserFragment : BaseFragment<FragmentEditUserBinding>(FragmentEditUserBinding::inflate) {
    private val viewModel by viewModels<UserViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val pref = activity?.getSharedPreferences("my_shared_pref", Context.MODE_PRIVATE)
        val token = pref?.getString("token", "default")
        getUser()

        binding.saveButton.setOnClickListener {
            saveUser()
            getUser()
        }

        editTextVisibilityVisible()
    }

    private fun getUser() {
        viewModel.getUserInfos()
        viewModel._userInfos.observe(viewLifecycleOwner) { user ->
            binding.apply {
                textUserName.text = user?.userName
                textName.text = user?.name
                textSurname.text = user?.surname
                textEmail.text = user?.email
                textPhoneNumber.text = user?.phoneNumber

                editUserName.setText(user?.userName)
                editName.setText(user?.name)
                editSurname.setText(user?.surname)
                editEmail.setText(user?.email)
                editPhoneNumber.setText(user?.phoneNumber)
            }
        }
    }

    private fun editTextVisibilityVisible() {
        binding.apply {
            textUserName.setOnClickListener {
                textUserName.isVisible = false
                editUserName.isVisible = true
            }
            textName.setOnClickListener {
                textName.isVisible = false
                editName.isVisible = true
            }
            textSurname.setOnClickListener {
                textSurname.isVisible = false
                editSurname.isVisible = true
            }
            textEmail.setOnClickListener {
                textEmail.isVisible = false
                editEmail.isVisible = true
            }
            textPhoneNumber.setOnClickListener {
                textPhoneNumber.isVisible = false
                editPhoneNumber.isVisible = true
            }
        }
    }

    private fun editTextVisibilityInvisible() {
        binding.apply {

            textUserName.isVisible = true
            editUserName.isVisible = false

            textName.isVisible = true
            editName.isVisible = false

            textSurname.isVisible = true
            editSurname.isVisible = false

            textEmail.isVisible = true
            editEmail.isVisible = false

            textPhoneNumber.isVisible = true
            editPhoneNumber.isVisible = false

        }
    }

    private fun saveUser() {
        binding.apply {
            val userName = editUserName.text.toString()
            val name = editName.text.toString()
            val email = editEmail.text.toString()
            val surName = editSurname.text.toString()
            val phoneNumber = editPhoneNumber.text.toString()
            viewModel._userInfos.observe(viewLifecycleOwner) { user ->
                viewModel.updateUser(
                    email = email.ifEmpty { user?.email },
                    gender = null,
                    name = name.ifEmpty { user?.name },
                    phoneNumber = phoneNumber.ifEmpty { user?.phoneNumber },
                    surname = surName.ifEmpty { user?.surname },
                    userName = userName.ifEmpty { user?.userName })
            }
            editTextVisibilityInvisible()
        }
    }
}

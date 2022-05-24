package com.kelani.androidstudio_with_firebase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.FirebaseFirestore
import com.kelani.androidstudio_with_firebase.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    var db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSave.setOnClickListener {
            val personFirstName = binding.textFirstName.text.toString()
            val personLastName = binding.textLastName.text.toString()
            val age = binding.textAge.text.toString()

            var user = mapOf("personFirstName" to personFirstName, "personLastName" to personLastName, "age" to age)
            db.collection("user").add(user)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
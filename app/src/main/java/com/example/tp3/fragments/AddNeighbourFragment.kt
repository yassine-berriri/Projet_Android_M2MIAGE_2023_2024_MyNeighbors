package com.example.tp3.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tp3.NavigationListener
import com.example.tp3.R
import com.example.tp3.data.NeighborRepository
import com.example.tp3.databinding.ActivityMainBinding
import com.example.tp3.databinding.AddNeighborBinding
import com.example.tp3.models.Neighbor

class AddNeighbourFragment: Fragment() {
    // Define a binding variable with a nullable type of your generated binding class
    private var _binding: AddNeighborBinding? = null

    // Define a non-nullable binding variable and use it to access views
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AddNeighborBinding.inflate(inflater, container, false)
        initializeFormValidation()
        return binding.root
    }

    private fun initializeFormValidation() {
        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkFormValidity()
            }

            override fun afterTextChanged(s: Editable?) {

            }
        }

        // Ajouter le TextWatcher à tous les champs EditText
        binding.nameEditText.addTextChangedListener(textWatcher)
        binding.addressEditText.addTextChangedListener(textWatcher)
        binding.phoneEditText.addTextChangedListener(textWatcher)
        binding.websiteEditText.addTextChangedListener(textWatcher)
        binding.imageEditText.addTextChangedListener(textWatcher)
        binding.editTextDescription.addTextChangedListener(textWatcher)

        // Vérifier l'état initial du formulaire
        checkFormValidity()
    }

    private fun checkFormValidity() {
        val name = binding.nameEditText.text.toString()
        val email = binding.addressEditText.text.toString() // Supposons que c'est l'email.
        val phone = binding.phoneEditText.text.toString()
        val website = binding.websiteEditText.text.toString()
        val imageLink = binding.imageEditText.text.toString()
        val aboutMe = binding.editTextDescription.text.toString()

        var isValid = true

        // Validation du nom
        if (name.isEmpty()) {
            binding.nameEditText.error = "Le champ nom est obligatoire."
            isValid = false
        } else {
            binding.nameEditText.error = null
        }

        // Validation de l'email
        if (email.isEmpty()) {
            binding.addressEditText.error = "Le champ email est obligatoire."
            isValid = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.addressEditText.error = "L'adresse email n'est pas valide."
            isValid = false
        } else {
            binding.addressEditText.error = null
        }

        // Validation du téléphone
        if (phone.isEmpty()) {
            binding.phoneEditText.error = "Le champ téléphone est obligatoire."
            isValid = false
        } else if (!phone.matches(Regex("0[67]\\d{8}"))) {
            binding.phoneEditText.error = "Le format doit être 06 XX XX XX XX ou 07 XX XX XX XX."
            isValid = false
        } else {
            binding.phoneEditText.error = null
        }

        // Validation de la bio
        if (aboutMe.length > 30) {
            binding.editTextDescription.error = "La bio ne doit pas dépasser 30 caractères."
            isValid = false
        } else {
            binding.editTextDescription.error = null
        }

        // Validation de l'image
        if (imageLink.isEmpty()) {
            binding.imageEditText.error = "Le champ image est obligatoire."
            isValid = false
        } else if (!URLUtil.isValidUrl(imageLink)) {
            binding.imageEditText.error = "Le lien de l'image n'est pas valide."
            isValid = false
        } else {
            binding.imageEditText.error = null
            Glide.with(this)
                .load(imageLink)
                .apply(RequestOptions.circleCropTransform())
                .placeholder(R.drawable.baseline_person_outline_24)
                .error(R.drawable.baseline_person_outline_24)
                .skipMemoryCache(false)
                .into(binding.neighborImage)
        }

        // Validation du site web
        if (website.isEmpty()) {
            binding.websiteEditText.error = "Le champ site web est obligatoire."
            isValid = false
        } else if (!URLUtil.isValidUrl(website)) {
            binding.websiteEditText.error = "Le lien du site web n'est pas valide."
            isValid = false
        } else {
            binding.websiteEditText.error = null
        }

        // Activer ou désactiver le bouton en fonction de la validité du formulaire
        binding.saveButton.isEnabled = isValid
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveButton.setOnClickListener {
            val neighbor = Neighbor(
                    id = NeighborRepository.getInstance().getNeighbours().size.toLong(),
                    name =  binding.nameEditText.text.toString(),
                    avatarUrl = binding.imageEditText.text.toString(),
                    address =  binding.addressEditText.text.toString(),
                    phoneNumber =  binding.phoneEditText.text.toString(),
                    aboutMe = binding.editTextDescription.text.toString(),
                    favorite = true,
                    webSite =  binding.websiteEditText.text.toString())

            if (NeighborRepository.getInstance().addNeighbor(neighbor)) {
                    Toast.makeText(context, "Utilisateur créé avec succès.", Toast.LENGTH_SHORT).show()
                (activity as? NavigationListener)?.let {
                    it.showFragment(ListNeighborsFragment())
                }
                } else {
                    Toast.makeText(context, "La création de l'utilisateur a échoué. Veuillez réessayer.", Toast.LENGTH_SHORT).show()
                }
            }

        }

    }


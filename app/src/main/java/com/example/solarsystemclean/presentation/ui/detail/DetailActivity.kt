package com.example.solarsystemclean.presentation.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.navArgs
import com.example.solarsystemclean.R
import com.example.solarsystemclean.databinding.ActivityDetailBinding
import com.example.solarsystemclean.domain.model.Planets
import com.example.solarsystemclean.presentation.ui.model.PlanetUiModel

class DetailActivity : AppCompatActivity() {

    var planet: PlanetUiModel? = null
    private val args by navArgs<DetailActivityArgs>()

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        args.let {
            planet = it.planet

            binding.txtName.text = planet?.name
        }
    }
}
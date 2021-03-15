package com.example.solarsystemclean.presentation.ui.main.components.favorites

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.solarsystemclean.R
import com.example.solarsystemclean.databinding.FragmentFavoritesBinding
import com.example.solarsystemclean.presentation.common.BaseFragment
import com.example.solarsystemclean.presentation.ui.model.PlanetUiModel
import com.example.solarsystemclean.util.LoadingUtil
import com.example.solarsystemclean.util.noResultAdapter
import com.example.solarsystemclean.util.observeOnce
import com.google.gson.Gson
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FavoritesFragment : BaseFragment<FavoritesViewState>() {

    private val viewModel: FavoritesViewModel by sharedViewModel()

    private lateinit var binding: FragmentFavoritesBinding

    private val mAdapter by lazy { FavoritesAdapter(arrayListOf(), viewModel) }

    private val favoritePlanetDataObserver = Observer<List<PlanetUiModel>> { list ->
        binding.rvFavorites.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapter
        }

        list?.let { mAdapter.setData(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoritesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getPlanetsFavorite()

        viewModel.viewState
            .observe(viewLifecycleOwner, { state ->
                updateViewState(state)
            })

        viewModel.planets.observeOnce(viewLifecycleOwner, favoritePlanetDataObserver)
    }

    override fun updateViewState(viewState: FavoritesViewState) {
        if (viewState.isLoading) {
            LoadingUtil.onStartLoading(requireContext())
        } else {
            LoadingUtil.onStopLoading()

            if (viewState.hasError == FavoritesViewState.Companion.FavoritesError.EMPTY) {
                binding.rvFavorites.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = noResultAdapter(
                        requireContext(),
                        requireContext().getString(R.string.txt_planets_favorites_empty),
                        R.drawable.ic_sad
                    )
                }
            }
        }
    }
}
package com.example.solarsystemclean.presentation.ui.main.components.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.solarsystemclean.R
import com.example.solarsystemclean.databinding.SearchFragmentBinding
import com.example.solarsystemclean.presentation.common.BaseFragment
import com.example.solarsystemclean.presentation.ui.common.adapter.PlanetSuggestedAdapter
import com.example.solarsystemclean.presentation.ui.main.components.favorites.FavoritesViewModel
import com.example.solarsystemclean.presentation.ui.model.PlanetUiModel
import com.example.solarsystemclean.util.LoadingUtil
import com.example.solarsystemclean.util.noResultAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<SearchViewState>() {

    private val viewModel: SearchViewModel by viewModel()
    private val favoritesViewModel: FavoritesViewModel by sharedViewModel()

    private lateinit var binding: SearchFragmentBinding

    private val mSearchPlanetsAdapter by lazy { SearchAdapter(arrayListOf(), favoritesViewModel) }

    private val suggestedPlanetDataObserver = Observer<List<PlanetUiModel>> { list ->
        val rnds = (list.indices).random()
        val mPlanetSuggestedAdapter = PlanetSuggestedAdapter(planet = list[rnds])

        binding.rvSuggestionPlanets.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mPlanetSuggestedAdapter
        }
    }

    private val searchPlanetDataObserver = Observer<List<PlanetUiModel>> { list ->
        binding.rvSearch.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mSearchPlanetsAdapter
        }

        list?.let { mSearchPlanetsAdapter.setData(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SearchFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchPlanets()
        searchData()

        viewModel.viewState
            .observe(viewLifecycleOwner, { state ->
                updateViewState(state)
            })
    }

    override fun updateViewState(viewState: SearchViewState) {
        if (viewState.isLoading) {
            LoadingUtil.onStartLoading(requireContext())
        } else {
            LoadingUtil.onStopLoading()

            if (viewState.hasError == SearchViewState.Companion.SearchError.NO_ERROR) {
                viewModel.planets.observe(viewLifecycleOwner, suggestedPlanetDataObserver)
                viewModel.planets.observe(viewLifecycleOwner, searchPlanetDataObserver)
            } else if (viewState.hasError == SearchViewState.Companion.SearchError.EMPTY) {
                binding.txtLabelLike.isVisible = false
                binding.rvSearch.isVisible = false

                binding.rvSuggestionPlanets.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = noResultAdapter(
                        requireContext(),
                        requireContext().getString(R.string.txt_planets_empty),
                        R.drawable.ic_sad
                    )
                }
            }
        }
    }

    private fun searchData() {
        binding.edtSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                mSearchPlanetsAdapter.filter.filter(p0.toString())

                visibilitySuggestion(p0.toString())
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                mSearchPlanetsAdapter.filter.filter(p0.toString())

                visibilitySuggestion(p0.toString())
            }

            override fun afterTextChanged(p0: Editable?) {
                mSearchPlanetsAdapter.filter.filter(p0.toString())

                visibilitySuggestion(p0.toString())
            }
        })
    }

    private fun visibilitySuggestion(search: String) {
        if (search.isNotEmpty()) {
            binding.rvSuggestionPlanets.isVisible = true
            binding.txtLabelLike.isVisible = true
        } else {
            binding.rvSuggestionPlanets.isVisible = false
            binding.txtLabelLike.isVisible = false
        }
    }
}
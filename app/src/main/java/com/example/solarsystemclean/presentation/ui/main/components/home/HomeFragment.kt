package com.example.solarsystemclean.presentation.ui.main.components.home

import android.os.Bundle
import android.text.Editable
import android.text.SpannableString
import android.text.Spanned
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.solarsystemclean.R
import com.example.solarsystemclean.SolarSystemApplication
import com.example.solarsystemclean.databinding.FragmentHomeBinding
import com.example.solarsystemclean.presentation.common.BaseFragment
import com.example.solarsystemclean.presentation.ui.common.adapter.PlanetsAdapter
import com.example.solarsystemclean.presentation.ui.model.PlanetUiModel
import com.example.solarsystemclean.util.LoadingUtil
import com.example.solarsystemclean.util.noResultAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<HomeViewState>() {

    private val viewModel: HomeViewModel by viewModel()

    private lateinit var binding: FragmentHomeBinding

    private val mAdapter by lazy { PlanetsAdapter(arrayListOf()) }

    private val planetDataObserver = Observer<List<PlanetUiModel>> { list ->
        binding.rvPlanets.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = mAdapter
        }

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.rvPlanets)
        binding.rvPlanets.onFlingListener = null

        list?.let { mAdapter.setData(it) }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchPlanets()
        viewModel.getUser()
        searchData()

        viewModel.name.observe(viewLifecycleOwner, Observer {
            it.let {
                val string = SpannableString("Olá, $it")
                string.setSpan(
                    ForegroundColorSpan(
                        ContextCompat.getColor(
                            SolarSystemApplication.appContext!!,
                            R.color.pink
                        )
                    ), 4, 5 + it.length, Spanned.SPAN_INCLUSIVE_INCLUSIVE
                )
                binding.txtName.text = string
            }
        })

        viewModel.viewState
            .observe(viewLifecycleOwner, { state ->
                updateViewState(state)
            })
    }

    override fun updateViewState(viewState: HomeViewState) {
        if (viewState.isLoading) {
            LoadingUtil.onStartLoading(requireContext())
        } else {
            LoadingUtil.onStopLoading()

            if (viewState.hasError == HomeViewState.Companion.HomeError.NO_ERROR) {
                viewModel.planets.observe(viewLifecycleOwner, planetDataObserver)
            } else if (viewState.hasError == HomeViewState.Companion.HomeError.EMPTY) {
                binding.rvPlanets.apply {
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
                mAdapter.filter.filter(p0.toString())
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                mAdapter.filter.filter(p0.toString())
            }

            override fun afterTextChanged(p0: Editable?) {
                mAdapter.filter.filter(p0.toString())
            }
        })
    }
}
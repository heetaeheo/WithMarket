package com.project.navermap.di.ModuleComponent.FragmentComponent

import androidx.fragment.app.Fragment
import com.naver.maps.map.NaverMap
import com.project.navermap.presentation.MainActivity.map.mapFragment.MapFragment
import com.project.navermap.presentation.MainActivity.map.mapFragment.navermap.MarkerFactory
import com.project.navermap.presentation.MainActivity.map.mapFragment.navermap.NaverMapHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Module
@InstallIn(FragmentComponent::class)
object MapModule {
    @Provides
    fun provideMapFragment(fragment: Fragment) = fragment as MapFragment

    @Provides
    fun provideNaverMap(mapFragment: MapFragment) = mapFragment.naverMap

    @Provides
    @FragmentScoped
    fun provideNaverMapHandler(
        markerFactory: MarkerFactory,
        naverMap: NaverMap
    ) = NaverMapHandler(markerFactory, naverMap)

}
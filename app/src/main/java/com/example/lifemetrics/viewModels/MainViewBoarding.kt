package com.example.lifemetrics.viewModels

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.lifemetrics.R
import com.example.lifemetrics.data.PageData
import com.example.lifemetrics.dataStore.StoreBoarding
import com.example.lifemetrics.onBoardViews.OnBoardingPager
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class, ExperimentalFoundationApi::class)
@Composable
fun MainViewBoarding(navController: NavController, store: StoreBoarding) {
    val items = ArrayList<PageData> ()

    items.add(
        PageData(
            R.raw.page1,
            "Bienvenido",
            "Bienvenidos a la aplicación para mostrar el uso de onBoarding."
        )
    )

    items.add(
        PageData(
            R.raw.page2,
            "Uso de onBoarding",
            "Esta es la segunda página de onBoarding mostrando una descripción."
        )
    )

    items.add(
        PageData(
            R.raw.page3,
            "Fin de Boarding",
            "Esta es la página final del Boarding y ya debe aparecer el botón."
        )
    )

    val pagerState = rememberPagerState(
        pageCount = items.size,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0
    )

    OnBoardingPager(
        item = items,
        pagerState = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White),
        navController,
        store
    )
}


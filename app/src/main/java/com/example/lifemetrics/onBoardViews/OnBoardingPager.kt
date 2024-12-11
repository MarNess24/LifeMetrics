package com.example.lifemetrics.onBoardViews

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lifemetrics.R
import com.example.lifemetrics.data.PageData
import com.example.lifemetrics.dataStore.StoreBoarding
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingPager(
    item:List<PageData>,
    pagerState: PagerState,
    modifier: Modifier,
    navController: NavController,
    store: StoreBoarding
) {
    Box ( modifier = Modifier) {
        Column ( horizontalAlignment = Alignment.CenterHorizontally ) {
            HorizontalPager ( state = pagerState ) {
                page ->
                when(page){
                    0 -> { Image(painter = painterResource(id = R.drawable.item1), contentDescription = "Imagen1",
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop)
                    }
                    1 -> { Image(painter = painterResource(id = R.drawable.item2), contentDescription = "Imagen2",
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop)
                    }
                    2 -> { Image(painter = painterResource(id = R.drawable.item4), contentDescription = "Imagen3",
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop)
                    }
                    else -> { Image(painter = painterResource(id = R.drawable.item4  ), contentDescription = "Imagen3",
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop)
                    }
                }
                Column (
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LoaderData ( modifier = Modifier
                        .size(400.dp)
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                        .offset(y = (-100).dp),
                                 item[page].image )
                    Text (
                        text = item[page].title,
                        modifier = Modifier
                            .padding( top = 10.dp)
                            .offset(y = (-100).dp),
                        color = Color(73,104,141),
                        style = MaterialTheme.typography.displayMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Text (
                        text = item[page].description,
                        modifier = Modifier
                            .offset(y = (-80).dp),
                        color = Color(73,104,141),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )

                }
            }
            PagerIndicator( item.size, pagerState.currentPage )
        }

        Box ( modifier = Modifier.align( Alignment.BottomCenter)
            .padding(bottom = 16.dp)) {
            ButtonFinish( pagerState.currentPage, navController, store )
        }
    }
}
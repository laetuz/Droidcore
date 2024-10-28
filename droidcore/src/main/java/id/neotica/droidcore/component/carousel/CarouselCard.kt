package id.neotica.droidcore.component.carousel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import kotlin.math.absoluteValue

/**
 * This CarouselCard Component was originally contributed by Irfan.rev during the 'Bangkit Academy' (all rights reserved) Capstone project.
 * The capstone project during that time of the event (March-July 2023) was called 'Arvigo',
 * a marketplace companion app which enables users to have a direct try on, using Augmented Reality technology.
 *
 * During the time of the making of my other app codenamed 'Neoverse' (c. October 2024), I struggled to find a
 * simple and minimalistic approach to implement a simple Carousel component.
 * That's where I remembered about this component. So I retrieved this component from the original
 * Repository: [https://github.com/C23-PS191-Arvigo/arvigo-mobile-app/blob/master/app/src/main/java/id/arvigo/arvigobasecore/ui/component/CarouselCard.kt]
 * and put it on 'Neoverse'. Because the project from which I retrieve this component
 * is still using an older version of composeBOM; it still uses experimentalPaging/ experimentalFoundation API.
 * Also the accompanist library is still on a different repo back then before it was
 * merged into the Compose library. So I made a few refactoring to comply with the new compose version.
 * So after a few changes it just worked smoothly and blazingly fast.
 * I made a few more changes to make the CarouselCard component stateless, and here it is now, enjoy! - Martin
 * **/
@Composable
fun <T> CarouselCard(
    list: List<T>, /** You can put the list in this parameter **/
    currentPageState: MutableState<Int>, /** Use remember { mutableIntStateOf(0) } in the parent composable for the page state. **/
    enableIndicator: Boolean = false, /** Enable indicator for the carousel. **/
    content: @Composable (T) -> Unit /** Put the composable content here, I usually just use lambda for this. **/
) {
    val pageState = rememberPagerState(pageCount = { list.size })

    LaunchedEffect(pageState) {
        snapshotFlow { pageState.currentPage }.collect { page ->
            currentPageState.value = page
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        HorizontalPager(
            state = pageState,
            contentPadding = PaddingValues(horizontal = 50.dp),
            modifier = Modifier
                .height(200.dp)
        ) {
            page ->
            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .graphicsLayer {
                        val pageOffset =
                            ((pageState.currentPage - page) + pageState.currentPageOffsetFraction).absoluteValue
                        lerp(
                            start = 0.85f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }
                        alpha = lerp(
                            start = 0.5f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                    }
            ) {
                content(list[page])
            }
        }
    }
    if (enableIndicator) {
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            repeat(list.size) {
                val color = if (pageState.currentPage == it) {
                    MaterialTheme.colorScheme.primary
                } else {
                    Color.LightGray
                }
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .size(8.dp)
                        .background(color)
                )
            }
        }
    }
}
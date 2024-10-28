package id.neotica.droidcore

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import id.neotica.droidcore.component.alert.NeoAlert
import id.neotica.droidcore.component.cards.ButtonCard
import id.neotica.droidcore.component.cards.Pocket
import id.neotica.droidcore.component.carousel.CarouselCard
import id.neotica.droidcore.component.icon.AlertEnum
import id.neotica.droidcore.component.image.NetworkImage
import id.neotica.droidcore.component.textfield.NeoTextField
import id.neotica.droidcore.component.textfield.NumberField
import id.neotica.droidcore.component.textfield.PasswordTextField
import id.neotica.droidcore.ui.theme.DroidcoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DroidcoreTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TestContent()
                }
            }
        }
    }
}
@Composable
fun TestContent() {
    val openDialog = remember { mutableStateOf(false) }
    var textFieldValue = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val numberState = remember { mutableIntStateOf(0) }
    val text by remember { mutableStateOf("") }
    val context = LocalContext.current

    val carouselList = listOf(
        CarouselObject(
            "Carousel Content",
            "https://firebasestorage.googleapis.com/v0/b/neoverse-neotica.appspot.com/o/heroPicture%2FIMG_730510416183.jpeg?alt=media&token=246027e3-27b6-48df-8be7-01b66067c68f"
        ),
        CarouselObject(
            "Carousel Content",
            "https://firebasestorage.googleapis.com/v0/b/neoverse-neotica.appspot.com/o/heroPicture%2FIMG_730510416183.jpeg?alt=media&token=246027e3-27b6-48df-8be7-01b66067c68f"
        ),
        CarouselObject(
            "Carousel Content",
            "https://firebasestorage.googleapis.com/v0/b/neoverse-neotica.appspot.com/o/heroPicture%2FIMG_730510416183.jpeg?alt=media&token=246027e3-27b6-48df-8be7-01b66067c68f"
        ),
    )
    val carouselPageState = rememberSaveable { mutableIntStateOf(0) }

    LazyColumn {
        item {
            Spacer(Modifier.padding(18.dp))
            Column {
                Pocket(
                    title = "Pocket",
                    titleBody = "This is Pocket's Title Body.",
                ) {
                    Text("This is Pocket's Content.")
                    CarouselCard(
                        list = carouselList,
                        currentPageState = carouselPageState,
                        enableIndicator = true
                    ) {
                        Box(
                            Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            NetworkImage(
                                url = it.imageUrl,
                                modifier = Modifier.fillMaxSize()
                            )
                            Text(
                                it.name,
                                Modifier.fillMaxSize().align(Alignment.BottomCenter)
                            )
                        }
                    }
                    Spacer(Modifier.padding(5.dp))
                    ButtonCard(
                        title = "ButtonCard",
                        desc = "This is ButtonCard",
                        button = "NeoAlert"
                    ) {
                        openDialog.value = true
                    }
                    Spacer(Modifier.padding(5.dp))
                    Spacer(Modifier.padding(5.dp))
                    ButtonCard(desc = "ButtonCard without title") {
                    }
                    Spacer(Modifier.padding(5.dp))
                    NeoTextField(textFieldValue, label = "NeoTextField")
                    Spacer(Modifier.padding(5.dp))
                    Spacer(Modifier.padding(5.dp))
                    PasswordTextField(
                        value = passwordState,
                        placeholder = "password",
                    )
                    Spacer(Modifier.padding(5.dp))
                    NumberField(numberState, label = "NumberField")
                }
            }


            Spacer(Modifier.padding(12.dp))

            if (openDialog.value) {
                NeoAlert(
                    openDialog = openDialog,
                    title = "NeoAlert",
                    desc = "This is NeoAlert",
                    hasIcon = true,
                    iconType = AlertEnum.SUCCESS,
                )
            }
        }
    }
}

const val wallpaperScheme = Wallpapers.NONE

@Preview(
    wallpaper = wallpaperScheme,
    )
@Composable
fun DroidcorePreview() {
    DroidcoreTheme {
        TestContent()
    }
}

@Preview(
    wallpaper = wallpaperScheme,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun DroidcorePreviewDark() {
    DroidcoreTheme {
        TestContent()
    }
}

data class CarouselObject(
    val name: String,
    val imageUrl: String
)
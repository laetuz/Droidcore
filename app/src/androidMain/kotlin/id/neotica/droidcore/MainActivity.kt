package id.neotica.droidcore

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
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
                    CommonApp()
                }
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
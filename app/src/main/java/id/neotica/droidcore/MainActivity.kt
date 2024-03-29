package id.neotica.droidcore

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import id.neotica.droidcore.component.alert.NeoAlert
import id.neotica.droidcore.component.cards.ButtonCard
import id.neotica.droidcore.component.cards.Pocket
import id.neotica.droidcore.component.icon.AlertEnum
import id.neotica.droidcore.component.textfield.NeoTextField
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
    val textFieldValue by remember { mutableStateOf("") }
    val passwordState by remember { mutableStateOf("") }

    LazyColumn {
        item {
            Spacer(Modifier.padding(5.dp))

            Pocket(
                title = "Pocket Title",
                  titleBody = "Body Title"
            ) {
                Text("Body Content")
            }
            Spacer(Modifier.padding(5.dp))
            Pocket(
                title = "Pocket",
                titleBody = "This is Pocket's Body.",
            ) {
                Text("This is Pocket's Content.")
                Spacer(Modifier.padding(5.dp))
                ButtonCard(
                    title = "ButtonCard",
                    desc = "This is ButtonCard",
                    button = "NeoAlert"
                ) {
                    openDialog.value = true
                }
                Spacer(Modifier.padding(5.dp))
                ButtonCard(desc = "ButtonCard without title") {
                }
                NeoTextField(textFieldValue)
                Spacer(Modifier.padding(5.dp))
                PasswordTextField(
                    value = passwordState,
                    placeHolder = "password"
                )
            }


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
        //TestContent()
        /*Column(modifier = Modifier.height(150.dp)) {
            Pocket(
                title = "Pocket Title",
              //  titleBody = "Body Title"
            ) {
                Text("Body Content")
                ButtonCard(desc = "dfsd") {
                    
                }
            }
        }*/
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
package id.neotica.droidcore

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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.neotica.droidcore.component.alert.NeoAlert
import id.neotica.droidcore.component.cards.NeoCard
import id.neotica.droidcore.component.cards.NeoCard2
import id.neotica.droidcore.component.icon.AlertEnum
import id.neotica.droidcore.component.textfield.NeoTextField
import id.neotica.droidcore.component.textfield.PasswordTextField
//import id.neotica.droidcore.component.textfield.PasswordTextField
import id.neotica.droidcore.ui.theme.DroidcoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val openDialog = remember { mutableStateOf(false) }
            var textFieldValue by remember { mutableStateOf("") }
            var passwordState by remember { mutableStateOf("") }

            DroidcoreTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyColumn {
                        item {
                            Spacer(Modifier.padding(5.dp))
                            NeoCard2(
                                columnOne = { Text("NeoCard2") },
                                columnTwo = { Text("Title for columnTwo") }) {
                                Text("This is NeoCard2 content")
                                Spacer(Modifier.padding(5.dp))
                                NeoCard(
                                    title = "NeoCard",
                                    desc = "This is NeoCard",
                                    button = "Click to view NeoAlert"
                                ) {
                                    openDialog.value = true
                                }
                                Spacer(Modifier.padding(5.dp))
                                NeoCard(desc = "NeoCard without title") {
                                }
                                NeoTextField(value = textFieldValue)
                                Spacer(Modifier.padding(5.dp))
                                PasswordTextField(value = passwordState, placeHolder = "password")
                            }
                            

                            if (openDialog.value) {
                                NeoAlert(
                                    openDialog = openDialog,
                                    title = "NeoAlert",
                                    desc = "This is NeoAlert",
                                    hasIcon = true,
                                    iconType = AlertEnum.SUCCESS,
                                )
                                //AlertFeatureUnavailable(openDialog = openDialog)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DroidcoreTheme {
        Greeting("Android")
    }
}
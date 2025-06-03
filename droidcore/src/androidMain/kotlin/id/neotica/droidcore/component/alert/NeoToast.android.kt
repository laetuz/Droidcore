package id.neotica.droidcore.component.alert

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import id.neotica.droidcore.component.context.AppContext
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
actual fun NeoToast(text: String, appear: MutableState<Boolean>) {
//    val context = AppContext.get().applicationContext
//    LaunchedEffect(Unit) {
//        if (appear.value) {
//            delay(1000)
//            appear.value = false
//        }
//    }
//    if (appear.value) {
//        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
//    }

    LaunchedEffect(Unit) {
        if (appear.value) {
            delay(1000)
            appear.value = false
        }
    }

    BasicAlertDialog(
        onDismissRequest = { appear.value = false },
        content = {
            Card {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = text,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                )
            }
        },
    )
}
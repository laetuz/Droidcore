package id.neotica.droidcore.component.pinview

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PinInputExperimental(
    text: String
) {
    val text = remember { mutableStateOf(text) }
    com.yogeshpaliyal.speld.PinInput(
        cellModifier = Modifier.border(
            BorderStroke(2.dp, Color.Red),
            shape = RoundedCornerShape(3.dp)
        ), value = text.value,
        obscureText = "*",
        length = 6,
        disableKeypad = false // Optional
    ) {
        text.value = it
    }
}
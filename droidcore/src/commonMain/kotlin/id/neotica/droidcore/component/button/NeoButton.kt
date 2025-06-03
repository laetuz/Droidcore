package id.neotica.droidcore.component.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@Composable
fun NeoButton(
    text: String,
    modifier: Modifier = Modifier,
    maxWidth: Boolean = false,
    width: Dp = Dp.Unspecified,
    backgroundColor: Color? = null,
    negativeColor: Color? = null,
    contentColor: Color? = null,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
) {
    val buttonColors = ButtonDefaults.buttonColors(
        containerColor = negativeColor ?: backgroundColor ?: MaterialTheme.colorScheme.primary,
        contentColor = contentColor ?: MaterialTheme.colorScheme.onPrimary
    )

    val finalModifier = modifier.then(
        if (maxWidth) Modifier.fillMaxWidth() else Modifier.width(width)
    )

    Button(
        modifier = finalModifier,
        onClick = onClick,
        enabled = enabled,
        colors = buttonColors,
        shape = RoundedCornerShape(20)
    ) {
        Text(text)
    }
}
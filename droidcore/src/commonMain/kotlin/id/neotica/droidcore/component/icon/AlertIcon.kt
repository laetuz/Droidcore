package id.neotica.droidcore.component.icon

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

@Composable
fun AlertIcon(
    icon: Painter,
    desc: String? = "Alert Icon"
) {
    Icon(
        painter = icon,
        contentDescription = desc,
        tint = MaterialTheme.colorScheme.primary
    )
}
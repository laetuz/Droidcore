package id.neotica.droidcore.ui.component.icon

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun AlertIcon(
    icon: ImageVector,
    desc: String? = "Alert Icon"
) {
    Icon(
        imageVector = icon,
        contentDescription = desc,
        tint = MaterialTheme.colorScheme.primary
    )
}
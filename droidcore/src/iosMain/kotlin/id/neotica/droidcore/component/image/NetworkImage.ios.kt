package id.neotica.droidcore.component.image

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
actual fun NetworkImage(
    url: String,
    contentDescription: String?,
    modifier: Modifier
) {
    Text(url)
}
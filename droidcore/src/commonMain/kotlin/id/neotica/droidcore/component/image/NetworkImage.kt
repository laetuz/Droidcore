package id.neotica.droidcore.component.image

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

interface NetworkImageInterface {
    val url: String
    val contentDescription: String?
    val modifier: Modifier
}

@Composable
expect fun NetworkImage(url: String, contentDescription: String? = null, modifier: Modifier)
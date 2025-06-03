package id.neotica.droidcore.component.alert

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@Composable
expect fun NeoToast(text: String, appear: MutableState<Boolean>)
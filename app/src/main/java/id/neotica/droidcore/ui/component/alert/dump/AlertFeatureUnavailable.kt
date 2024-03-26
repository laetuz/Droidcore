package id.neotica.droidcore.ui.component.alert.dump

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import id.neotica.droidcore.ui.component.alert.NeoAlert

@Composable
fun AlertFeatureUnavailable(
    openDialog: MutableState<Boolean>
) {
    NeoAlert(
        openDialog = openDialog,
        title = "Fitur dalam pengembangan",
        desc = "Mohon maaf untuk saat ini fitur masih dalam tahap pengembangan."
    )
}
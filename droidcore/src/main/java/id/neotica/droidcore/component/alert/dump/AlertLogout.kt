package id.neotica.droidcore.ui.component.alert.dump

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import id.neotica.droidcore.component.alert.AlertDialogCustom

@Composable
fun AlertLogout(
    openDialog : MutableState<Boolean>,
    onClick: () -> Unit
) {
    AlertDialogCustom(
        openDialog = { openDialog.value = false },
        title = "Logout",
        desc = "Apakah kamu yakin bahwa kamu ingin logout?",
        backButton = "Tidak",
        confirmButton = {
            TextButton(
                onClick = onClick
            ) {
                Text("Logout")
            }
        }
    )
}
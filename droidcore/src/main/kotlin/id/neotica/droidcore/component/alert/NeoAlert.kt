package id.neotica.droidcore.component.alert

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import id.neotica.droidcore.component.icon.AlertEnum
import id.neotica.droidcore.component.icon.AlertIcon


@Composable
fun NeoAlert(
    openDialog: MutableState<Boolean>,
    title: String,
    desc: String? = null,
    hasIcon: Boolean = false,
    iconType: AlertEnum = AlertEnum.INFO,
    backButton: String? = "Ok",
    confirmButton: (@Composable () -> Unit)? = null
) {
    val icon = when (iconType) {
        AlertEnum.INFO -> Icons.Filled.Info
        AlertEnum.WARNING -> Icons.Filled.Warning
        AlertEnum.SUCCESS -> Icons.Filled.CheckCircle
    }

    AlertDialogCustomCentered(
        openDialog = { openDialog.value = false },
        title = title,
        desc = desc ?: "",
        backButton = backButton ?: "Ok",
        confirmButton = confirmButton,
        icon = if (hasIcon) {
            { AlertIcon(icon = icon) }
        } else {
            null
        }
    )
}
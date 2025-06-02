package id.neotica.droidcore.component.alert

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import droidcore.droidcore.generated.resources.Res
import droidcore.droidcore.generated.resources.ic_check_circle
import droidcore.droidcore.generated.resources.ic_info_filled
import droidcore.droidcore.generated.resources.ic_warning_filled
import id.neotica.droidcore.component.icon.AlertEnum
import id.neotica.droidcore.component.icon.AlertIcon
import org.jetbrains.compose.resources.painterResource

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
        AlertEnum.INFO -> painterResource(Res.drawable.ic_info_filled)
        AlertEnum.WARNING -> painterResource(Res.drawable.ic_warning_filled)
        AlertEnum.SUCCESS -> painterResource(Res.drawable.ic_check_circle)
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
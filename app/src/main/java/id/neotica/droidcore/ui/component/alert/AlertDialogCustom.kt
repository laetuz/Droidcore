package id.neotica.droidcore.ui.component.alert

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign

@Composable
fun AlertDialogCustom(
    openDialog: () -> Unit,
    icon: (@Composable () -> Unit)? = null,
    confirmButton: (@Composable () -> Unit)? = null,
    title: String,
    desc: String,
    backButton: String
) {
    AlertDialogCustomDesc(
        openDialog = { openDialog() },
        title = title,
        desc = { Text(text = desc) },
        backButton = backButton,
        confirmButton = confirmButton,
        icon = icon
    )
}

@Composable
fun AlertDialogCustomCentered(
    openDialog: () -> Unit,
    icon: (@Composable () -> Unit)? = null,
    confirmButton: (@Composable () -> Unit)? = null,
    title: String,
    desc: String? = null,
    backButton: String
) {
    if (desc.isNullOrEmpty()) {
        AlertDialog(
            onDismissRequest = openDialog,
            icon = icon,
            title = {
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center,
                )
            },
            confirmButton = { confirmButton?.invoke() },
            dismissButton = {
                TextButton(
                    onClick = openDialog
                ) {
                    Text(backButton)
                }
            }
        )
    } else {
        AlertDialog(
            onDismissRequest = openDialog,
            icon = icon,
            title = {
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center,
                )
            },
            text = {
                Text(
                    text = "$desc",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center,
                )
            },
            confirmButton = { confirmButton?.invoke() },
            dismissButton = {
                TextButton(
                    onClick = openDialog
                ) {
                    Text(backButton)
                }
            }
        )
    }

}

@Composable
fun AlertDialogCustomDesc(
    openDialog: () -> Unit,
    icon: (@Composable () -> Unit)? = null,
    confirmButton: (@Composable () -> Unit)? = null,
    title: String,
    desc: (@Composable () -> Unit)? = null,
    backButton: String,
) {
    AlertDialog(
        onDismissRequest = openDialog,
        icon = icon,
        title = {
            Text(text = title)
        },
        text = desc,
        confirmButton = { confirmButton?.invoke() },
        dismissButton = {
            TextButton(onClick = openDialog) {
                Text(backButton)
            }
        },
    )
}
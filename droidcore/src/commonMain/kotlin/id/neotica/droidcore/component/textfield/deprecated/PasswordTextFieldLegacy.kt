package id.neotica.droidcore.component.textfield.deprecated

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import droidcore.droidcore.generated.resources.Res
import droidcore.droidcore.generated.resources.ic_lock
import droidcore.droidcore.generated.resources.visibility_off
import droidcore.droidcore.generated.resources.visibility_on
import id.neotica.droidcore.component.textfield.NeoTextField
import org.jetbrains.compose.resources.painterResource


@Composable
@Deprecated(
    level = DeprecationLevel.WARNING,
    message = "Use PasswordTextField instead",
    replaceWith = ReplaceWith("PasswordTextField()")
)
fun PasswordTextFieldLegacy(
    value: MutableState<String>,
    placeHolder: String? = null
) {
    var showError by remember { mutableStateOf(false) }
    var errorText by remember { mutableStateOf("") }
    val isPasswordValid = value.value.length >= 6 // Minimum password length requirement
    var passwordVisible by remember { mutableStateOf(false) }

    if (!isPasswordValid && value.value.isNotEmpty()) {
        showError = true
        errorText = "Password must be at least 6 characters long"
    } else {
        showError = false
        errorText = ""
    }

    NeoTextField(
        value = value,
       // onValueChange = onValueChange,
        placeHolder = placeHolder,
        icon = {
            Icon(
                painter = painterResource(Res.drawable.ic_lock),
                contentDescription = null,
            )
        },
        trailingIcon = {
            IconButton(
                onClick = { passwordVisible = !passwordVisible }
            ) {
                val visibilityIcon = if (passwordVisible) {
                    painterResource(Res.drawable.visibility_on)
                } else {
                    painterResource(Res.drawable.visibility_off)
                }
                Icon(
                    painter = visibilityIcon,
                    contentDescription = "Toggle Password Visibility",
                    modifier = Modifier.size(24.dp)
                )
            }
        },
        isError = showError,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
    )

    if (showError) {
        Text(
            text = "Password harus memiliki panjang diatas 6 karakter.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.error,
            modifier = Modifier.padding(start = 16.dp, top = 4.dp)
        )
    }
}
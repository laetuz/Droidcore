package id.neotica.droidcore.component.textfield.deprecated

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import id.neotica.droidcore.R
import id.neotica.droidcore.component.textfield.NeoTextField

@Composable
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
                imageVector = Icons.Default.Lock,
                contentDescription = null,
            )
        },
        trailingIcon = {
            IconButton(
                onClick = { passwordVisible = !passwordVisible }
            ) {
                val visibilityIcon = if (passwordVisible) {
                    painterResource(R.drawable.visibility_on)
                } else {
                    painterResource(R.drawable.visibility_off)
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
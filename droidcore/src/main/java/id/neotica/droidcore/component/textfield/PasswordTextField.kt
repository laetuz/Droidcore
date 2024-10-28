package id.neotica.droidcore.component.textfield

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import id.neotica.droidcore.R

@Composable
fun PasswordTextField(
    value: MutableState<String>,
    onValueChange: ((String) -> Unit)? = null,
    icon: (@Composable () -> Unit)? = null,
    placeholder: String? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    isError: Boolean? = false,
    trailingIcon: (@Composable () -> Unit)? = null,
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

    var textFieldValue by remember { mutableStateOf(value) }
    if (onValueChange == null) {
        OutlinedTextField(
            value = textFieldValue.value,
            onValueChange = {
                textFieldValue.value = it
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null,
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = Color.LightGray,
            ),
            placeholder = { Text(placeholder ?: "") },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 48.dp),
            shape = RoundedCornerShape(10.dp),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            isError = isError ?: false,
            trailingIcon = {
                Row {
                    Spacer(Modifier.padding())
                    if (textFieldValue.value.isNotEmpty()) {
                        IconButton(onClick = { textFieldValue.value = "" }) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = null,
                            )
                        }
                    }
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
                }
            },
            maxLines = 1
        )
    }
}

@Composable
fun RePasswordTextField(
    value: MutableState<String>
) {
    PasswordTextField(value = value, placeholder = "Retype your password.")
}

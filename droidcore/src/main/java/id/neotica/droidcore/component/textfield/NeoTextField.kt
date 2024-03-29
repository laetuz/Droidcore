package id.neotica.droidcore.component.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NeoTextField(
    value: String,
    onValueChange: ((String) -> Unit)? = null,
    icon: (@Composable () -> Unit)? = null,
    placeHolder: String? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    isError: Boolean? = false,
    trailingIcon: (@Composable () -> Unit)? = null,
) {
    var textFieldValue by remember { mutableStateOf(value) }
    if (onValueChange == null) {
        OutlinedTextField(
            value = textFieldValue,
            onValueChange =  {
                textFieldValue = it
            },
            leadingIcon = icon,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = Color.LightGray,
            ),
            placeholder = { Text(placeHolder?: "") },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 48.dp),
            shape = RoundedCornerShape(10.dp),
            visualTransformation = visualTransformation,
            isError = isError?: false,
            trailingIcon = trailingIcon,
            maxLines = 1
        )
    }
}
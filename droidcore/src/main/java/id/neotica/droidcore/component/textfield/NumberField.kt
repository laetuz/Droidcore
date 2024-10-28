package id.neotica.droidcore.component.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun NumberField(
    value: MutableState<Int>,
    onValueChange: ((String) -> Unit)? = null,
    icon: (@Composable () -> Unit)? = null,
    placeHolder: String? = null,
    imeAction: ImeAction = ImeAction.Done,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    isError: Boolean? = false,
    trailingIcon: (@Composable () -> Unit)? = null,
    label: String? = null
) {
    var textFieldValue by remember { value }

    OutlinedTextField(
        value = if (textFieldValue != 0) textFieldValue.toString() else "",
        onValueChange =  {
            textFieldValue = if (it == "") 0 else it.toInt()
            onValueChange?.invoke(it)
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
        isError = isError == true,
        trailingIcon = trailingIcon,
        maxLines = 1,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number,
            imeAction = imeAction
        ),
        label = {
            if (label != null) {
                Text(text = label)
            }
        }
    )
}
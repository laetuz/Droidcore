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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

/**
 * A Composable function that provides a styled OutlinedTextField for number input.
 *
 * This field is specifically designed for numeric input and includes features like
 * leading/trailing icons, placeholder text, error state indication, and custom IME actions.
 * It uses a `MutableState<Long>` to hold and update the numeric value.
 *
 * @param value The [MutableState] holding the `Long` value of the text field.
 * @param onValueChange An optional lambda that is triggered when the text field's value changes.
 *                      It receives the new string value as input.
 * @param icon An optional composable lambda for displaying a leading icon.
 * @param placeHolder An optional string to be displayed as a placeholder when the field is empty.
 * @param imeAction The [ImeAction] to be performed when the user interacts with the keyboard's action button.
 *                  Defaults to [ImeAction.Done].
 * @param visualTransformation An optional [VisualTransformation] to apply to the input text (e.g., for password masking).
 *                             Defaults to [VisualTransformation.None].
 * @param isError An optional boolean indicating whether the text field is in an error state.
 *                Defaults to `false`.
 * @param trailingIcon An optional composable lambda for displaying a trailing icon.
 * @param label An optional string to be displayed as a label above the text field.
 */
@Composable
fun NumberField(
    value: MutableState<Long>,
    onValueChange: ((String) -> Unit)? = null,
    icon: (@Composable () -> Unit)? = null,
    placeHolder: String? = null,
    imeAction: ImeAction = ImeAction.Done,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    isError: Boolean? = false,
    trailingIcon: (@Composable () -> Unit)? = null,
    label: String? = null
) {
    var textFieldValue by remember { mutableStateOf(value.value.toString()) }

    OutlinedTextField(
        value = if (value.value.toInt() != 0) textFieldValue else "",
        onValueChange =  {
            val newValue = it.toLongOrNull()
            if (newValue != null) {
                textFieldValue = it
                value.value = newValue
                onValueChange?.invoke(it)
            } else {
                textFieldValue = ""
                value.value = 0
                onValueChange?.invoke("")
            }
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
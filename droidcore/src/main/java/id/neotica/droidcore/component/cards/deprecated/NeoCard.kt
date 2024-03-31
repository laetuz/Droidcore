package id.neotica.droidcore.component.cards.deprecated

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun NeoCard(
    title: String? = null, /**Enter Card title here, value can be null.**/
    desc: String, /**Enter Card desc here**/
    button: String? = "NeoButton",  /**Enter Button title here, value will be assigned to "NeoButton if null.**/
    onClick: () -> Unit /**Enter the Button onClick here**/
) {
    if (title.isNullOrEmpty()) {
        NeoCardItemDesc(
            desc = desc,
            button = "$button",
            onClick = onClick
        )
    } else {
        /**Value with title**/
        NeoCardItemDesc(
            title = {
                Text(
                    text = "$title",
                    style = MaterialTheme.typography.titleSmall.copy(color = Color.Gray)
                )
                Spacer(modifier = Modifier.padding(top = 5.dp))
            },
            desc = desc,
            button = "$button",
            onClick = onClick
        )
    }

}
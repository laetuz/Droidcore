package id.neotica.droidcore.component.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun ButtonCard(
    title: String? = null, /**Enter Card title here, value can be null.**/
    desc: String, /**Enter Card desc here**/
    button: String? = "NeoButton",  /**Enter Button title here, value will be assigned to "NeoButton if null.**/
    onClick: () -> Unit /**Enter the Button onClick here**/
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 8.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                if (title != null) {
                    Text(
                        text = "$title",
                        style = MaterialTheme.typography.titleSmall.copy(color = Color.Gray)
                    )
                    Spacer(modifier = Modifier.padding(top = 5.dp))
                }
                Text(
                    text = desc,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            Button(
                onClick = onClick,
                modifier = Modifier,
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "$button")
            }
        }
    }
}
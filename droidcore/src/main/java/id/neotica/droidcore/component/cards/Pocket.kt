package id.neotica.droidcore.component.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Pocket(
    header: (@Composable () -> Unit)?=null,
    title: String? = null,
    titleBody: String? = null,
    paddingValues: PaddingValues = PaddingValues(10.dp),
    content: (@Composable () -> Unit) ? = null,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingValues),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Spacer(modifier = Modifier.height(18.dp))
        Column(
            modifier = Modifier.padding(10.dp, 10.dp)
        ) {
            header?.invoke()
            if (title != null) {
                Text(text = title, color = Color.White, style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold), modifier = Modifier.padding(horizontal = 16.dp))
            }
        }
        Spacer(modifier = Modifier.height(18.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 18.dp),
            ) {
                if (titleBody != null) {
                    Text(text = titleBody, color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold))
                }
                content?.invoke()
            }
        }
    }
}
package id.neotica.droidcore.ui.component.alert.dump

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import id.neotica.droidcore.component.alert.NeoAlert

@Composable
fun PrimaryAlert(
    openDialog: MutableState<Boolean>,
    ctx: Context,
    url: String,
) {
    NeoAlert(
        openDialog = openDialog,
        confirmButton = {
            TextButton(
                onClick = {
                    val urlIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(url)
                    )
                    ctx.startActivity(urlIntent)
                }
            ) {
                Text("Coba")
            }
                        },
        title = "Fitur dalam pengembangan",
        desc = "Mohon maaf untuk saat ini fitur yang anda pilih masih dalam tahap pengembangan. Namun anda dapat mencoba fitur ini dengan dengan browser anda."
    )
}
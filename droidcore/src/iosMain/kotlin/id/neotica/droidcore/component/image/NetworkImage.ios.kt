package id.neotica.droidcore.component.image

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kotlinx.coroutines.suspendCancellableCoroutine
import platform.Foundation.*
import platform.UIKit.*
import kotlin.coroutines.resume
import androidx.compose.ui.graphics.ImageBitmap

@Composable
actual fun NetworkImage(
    url: String,
    contentDescription: String?,
    modifier: Modifier
) {
    var imageBitmap by remember { mutableStateOf<ImageBitmap?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    var hasSuccessfullyLoadedOnce by remember(url) { mutableStateOf(false) }

    Text(url)

}

suspend fun loadImage(url: String): ImageBitmap? {
    if (url.isBlank()) return null

    val nsUrl = NSURL.URLWithString(url) ?: run {
        println("iOS loadImage Error: Invalid URL string $url")
        return null
    }

    return suspendCancellableCoroutine { continuation ->
        val session = NSURLSession.sharedSession
        val task = session.dataTaskWithURL(
            url = nsUrl
        )
        { data: NSData?, response: NSURLResponse?, error: NSError? ->
            if (error != null) {
                println("iOS loadImage NSURLSession Error: ${error.localizedDescription}")
                continuation.resume(null)
                return@dataTaskWithURL
            }

            val httpResponse = response as? NSHTTPURLResponse
            if (httpResponse != null && httpResponse.statusCode.toInt() !in 200..299) {
                println("iOS loadImage HTTP Error: Status ${httpResponse.statusCode}")
                continuation.resume(null)
                return@dataTaskWithURL
            }

            if (data != null) {
                val image = UIImage.imageWithData(data)
                if (image != null) {
                    try {
//                        val imageBitmap = image.toComposeImageBitmap()
//                        continuation.resume(imageBitmap)
                    } catch (e: Exception) {
                        println("iOS loadImage toComposeImageBitmap Error: ${e.message}")
                        continuation.resume(null)
                    }
                } else {
                    println("iOS loadImage Error: Failed to create UIImage from data.")
                    continuation.resume(null)
                }
            } else {
                println("iOS loadImage Error: No data received for URL.")
                continuation.resume(null)
            }
        }

        continuation.invokeOnCancellation {
            task.cancel() // Cancel the network request if the coroutine is cancelled
        }
        task.resume() // Start the data task
    }
}
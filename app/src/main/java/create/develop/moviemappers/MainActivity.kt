package create.develop.moviemappers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import create.develop.moviemappers.presentatioin.screen.StarScreen
import create.develop.moviemappers.ui.theme.SixthAttemptTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SixthAttemptTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   StarScreen(modifier = Modifier.padding(innerPadding))

                }
            }
        }
    }
}
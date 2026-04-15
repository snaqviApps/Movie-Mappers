package create.develop.moviemappers.presentatioin.screen

import android.net.ipsec.ike.TunnelModeChildSessionParams
import android.widget.Button
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.time.Duration.Companion.seconds

@Composable
fun TunnelModeChildSessionParams(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Spacer(
            modifier = Modifier
                .weight(1f)
        )
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
        ) {
            Text(text = "Preview")
        }
        Spacer(modifier = Modifier
            .weight(1f)
        )
        Text("Sibling Composed",
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
                .padding(bottom = 16.dp, start = 16.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier
            .weight(1f)
        )
    }
}

@PreviewLightDark
@Composable
private fun TunnelModeChildSessionParamsPreview() {
    TunnelModeChildSessionParams()
}
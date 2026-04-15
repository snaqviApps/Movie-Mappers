package create.develop.moviemappers.presentatioin.screen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun StarCard(
    name: String,
    distanceFromSun: Double,
    description: String,
    onItemClicked: (String, Double) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 4.dp)
            .clickable {
                onItemClicked(name, distanceFromSun)
            }
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Column(modifier = Modifier.padding(4.dp)) {
                    Text("Star", fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.width(18.dp))
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(name, textAlign = TextAlign.End)
                }
            }
            Spacer(Modifier.height(5.dp))

            Row(
                modifier = Modifier.padding(4.dp)
            ) {
                Column {
                    Text("Distance", fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.width(18.dp))
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(end = 4.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Text("$distanceFromSun", textAlign = TextAlign.End)
                }
            }
            Spacer(Modifier.height(5.dp))

            Row(
                modifier = Modifier.padding(4.dp)
            ) {
                Column {
                    Text("Description", fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.width(18.dp))
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(end = 4.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(description, textAlign = TextAlign.End, softWrap = true)
                }
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun StarCardPreview() {
    StarCard(
        "Proxima Centauri",
        4.24,
        "The closest known star to the Sun.",
        { name, distance ->
            Log.d("TAG", "StarCardPreview: $name, $distance")
        }
    )
}

package create.develop.moviemappers.presentatioin.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MovieCard(
    title: String,
    poster: String,
    plot: String,
    onItemClicked: (String, Double) -> Unit,
    year: String
) {
    Card(
        elevation = CardDefaults.elevatedCardElevation(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp, start = 8.dp, end = 8.dp, bottom = 4.dp)
    )
    {
        Row(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
            ) {
                MoviePoster(poster, onItemClicked = onItemClicked)
            }
            Spacer(modifier = Modifier.width(4.dp))
            Column(
                modifier = Modifier
                    .padding(4.dp)
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 4.dp, end = 4.dp),
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = plot,
                    modifier = Modifier.padding(start = 4.dp, end = 4.dp)
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = year,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 4.dp, end = 4.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieCardPreview() {
    MovieCard(
        title = "The Shawshank Redemption",
        poster = "https://m.media-amazon.com/images/M/MV5BMDFkYTc",
        year = "1994",
        plot = "Two imprisoned men bond over a number of years",
        onItemClicked = { name, distance -> }
    )
}
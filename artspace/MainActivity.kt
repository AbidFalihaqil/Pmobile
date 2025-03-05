package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

data class Artwork(
    val imageRes: Int,
    val title: String,
    val artist: String,
    val year: Int,
    val description: String,
    val genre: String,
)

@Composable
fun ArtSpaceApp() {
    val artworks = listOf(
        Artwork(R.drawable.rap1, "Travis Scott ", "Jacques Bermon Webster II", 1991, "An American Rapper, Singer, Songwriter And Record Producer", "Hip-Hop/Rap"),
        Artwork(R.drawable.rap2, "ASAP Rocky", "Rakim Athelaston Mayers", 1988, "An American Rapper", "Hip-Hop"),
        Artwork(R.drawable.rap3, "21 Savage", "Sheyaa Bin Abrahan-Joseph", 1992, "An American and British rapper", "Rap"),
        Artwork(R.drawable.rap4, "Juice WRLD", "Jarad Anthony Higgins", 1998, "An American rapper and singer-songwriter", "Rap/Emo"),
        Artwork(R.drawable.rap5, "Central Cee", "Oakley Neil Caesar-Su", 1998, "An British Rapper from Sephred Bush, London", "Rap/Drill")
    )

    var currentArtworkIndex by remember { mutableStateOf(0) }
    val currentArtwork = artworks[currentArtworkIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = currentArtwork.imageRes),
            contentDescription = currentArtwork.title,
            modifier = Modifier
                .size(300.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "${currentArtwork.title} (${currentArtwork.year})",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = " ${currentArtwork.artist}",
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Genre: ${currentArtwork.genre}",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF8B4513) // Warna coklat
        )

        Text(
            text = currentArtwork.description,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                onClick = { if (currentArtworkIndex > 0) currentArtworkIndex-- },
                enabled = currentArtworkIndex > 0,
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Sebelumnya")
            }

            Button(
                onClick = { if (currentArtworkIndex < artworks.size - 1) currentArtworkIndex++ },
                enabled = currentArtworkIndex < artworks.size - 1,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green), // Warna hijau
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Berikutnya")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}

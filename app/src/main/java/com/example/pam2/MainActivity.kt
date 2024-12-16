package com.example.pam2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pam2.ui.theme.Pam2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pam2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(Modifier.padding(innerPadding)) {
                        Header("Available weather icons:")
                        Prognosis(
                            listOf(
                                R.drawable.ic_cloudy,
                                R.drawable.ic_sunny_and_cloudy,
                                R.drawable.ic_sunny,
                                R.drawable.ic_moon,
                                R.drawable.ic_moon_clouds
                            )
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun Prognosis(icons: List<Int>, modifier: Modifier = Modifier) {
    LazyRow(Modifier.background(Color(0xff691996))) {
        items(icons) {
            Image(
                painterResource(it),
                contentDescription = "weather icon",
                modifier = modifier
                    .padding(15.dp, 10.dp)
                    .size(80.dp)
            )
        }
    }
}

@Composable
fun Header(text: String, modifier: Modifier = Modifier) = Text(
    text,
    fontWeight = FontWeight.Bold,
    fontSize = 45.sp,
    lineHeight = 50.sp,
    modifier = modifier.padding(15.dp)
)

@Preview
@Composable
fun Preview(){
    Column {
        Header("Available weather icons:")
        Prognosis(
            listOf(
                R.drawable.ic_cloudy,
                R.drawable.ic_sunny_and_cloudy,
                R.drawable.ic_sunny,
                R.drawable.ic_moon,
                R.drawable.ic_moon_clouds
            )
        )
    }
}

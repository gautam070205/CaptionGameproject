package eu.tutorials.treasure

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.tutorials.treasure.ui.theme.TreasureTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TreasureTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorScheme.background
                ) {
                    CaptionGame()
                }
            }
        }
    }
}

@Composable
fun CaptionGame() {
    val treasureFound= remember{ mutableStateOf(0) }
    val direction= remember {
        mutableStateOf("North")
    }
    val stormOrTreasure=remember{ mutableStateOf("") }
    Column(modifier=Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment =Alignment.CenterHorizontally ) {
        Text(text = "Treasure Found: ${treasureFound.value}")
        Spacer(modifier=Modifier.height(
            24.dp))
        Text(text = "Direction: ${direction.value}")
        Spacer(modifier=Modifier.height(
            24.dp))
        Text(text =" Result: ${stormOrTreasure.value}")
        Spacer(modifier=Modifier.height(
            24.dp))
        Button(onClick = {
            direction.value = "East"
            if (Random.nextBoolean()) {
                treasureFound.value += 1
                stormOrTreasure.value = "FOUNDED THE TREASURE"
            }else stormOrTreasure.value = "STORM AHEAD!!"
        }) {
            Text("Sail East")
        }
        Spacer(modifier=Modifier.height(
            24.dp))
        Button(onClick = {
            direction.value = "North"
            if (Random.nextBoolean()) {
                treasureFound.value += 1
                stormOrTreasure.value = "FOUNDED THE TREASURE"
            }else stormOrTreasure.value = "STORM AHEAD!!"
        }) {
            Text("Sail North")
        }
        Spacer(modifier=Modifier.height(
            24.dp))
        Button(onClick = {
            direction.value = "West"
            if (Random.nextBoolean()) {
                treasureFound.value += 1
                stormOrTreasure.value = "FOUNDED THE TREASURE"
            }else stormOrTreasure.value = "STORM AHEAD!!"
        }) {
            Text("Sail West")
        }
        Spacer(modifier=Modifier.height(
            24.dp))
        Button(onClick = {
            direction.value = "South"
            if (Random.nextBoolean()) {
                treasureFound.value += 1
                stormOrTreasure.value = "FOUNDED THE TREASURE"
            }else stormOrTreasure.value = "STORM AHEAD!!"
        }) {
            Text("Sail South")
        }

    }
}

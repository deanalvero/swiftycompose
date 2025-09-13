package io.github.deanalvero.swiftycompose.demoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.deanalvero.swiftycompose.background
import io.github.deanalvero.swiftycompose.components.Button
import io.github.deanalvero.swiftycompose.components.ForEach
import io.github.deanalvero.swiftycompose.components.HStack
import io.github.deanalvero.swiftycompose.components.Image
import io.github.deanalvero.swiftycompose.components.LazyVStack
import io.github.deanalvero.swiftycompose.components.ProgressView
import io.github.deanalvero.swiftycompose.components.Slider
import io.github.deanalvero.swiftycompose.components.Text
import io.github.deanalvero.swiftycompose.components.TextField
import io.github.deanalvero.swiftycompose.components.Toggle
import io.github.deanalvero.swiftycompose.components.VStack
import io.github.deanalvero.swiftycompose.data.stateBinding
import io.github.deanalvero.swiftycompose.demoapp.ui.theme.SwiftyComposeTheme
import io.github.deanalvero.swiftycompose.frame
import io.github.deanalvero.swiftycompose.padding

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SwiftyComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DemoApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun DemoApp(modifier: Modifier = Modifier) {
    val toggleValue = stateBinding(false)
    val sliderValue = stateBinding(0.5f)
    val textValue = stateBinding("")

    !HStack {
        !Text(
            text = "Swifty"
        ).background(color = Color.Blue)
            .strikethrough()
            .underline()

        !Text(
            text = "Compose"
        ).bold()
    }.background(color = Color.Red)

    !VStack {
        !Text(
            text = "SwiftyCompose"
        )
            .fontWeight(FontWeight.Normal)
            .background(color = Color.Red)
            .padding(15.dp)
            .background(color = Color.Blue)

        !Text(
            text = "Android"
        )
            .bold()
            .frame(width = 30.dp)
            .background(color = Color.Red)
            .padding(5.dp)
            .background(Color.Blue)
            .fontDesign(FontFamily.Monospace)
            .lineLimit(2)
            .strikethrough()
            .underline()
            .italic()

        !Toggle(
            title = "ABC",
            isOn = toggleValue
        ).background(color = Color.Yellow)

        Slider(
            value = sliderValue,
            bounds = 0f..2f
        )()

        ProgressView()()
        !ProgressView(value = 0.5f)
            .frame(width = Dp.Infinity, height = 10.dp)
        !TextField(
            title = "Sample",
            text = textValue
        )
        !TextField(
            title = "Sample",
            text = textValue
        )

        !Button(
            title = "Test",
            action = {

            }
        )

        !LazyVStack {
            ForEach(1..2) {
                !Text(text = it.toString())
            }
        }

        !Image(
            painter = painterResource(R.drawable.ic_launcher_background)
        )
            .opacity(0.5f)
    }
}

@Preview(showBackground = true)
@Composable
fun DemoAppPreview() {
    SwiftyComposeTheme {
        DemoApp()
    }
}

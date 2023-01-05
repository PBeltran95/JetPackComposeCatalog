package com.example.jetpackcomposecatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecatalogo.ui.theme.JetPackComposeCatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyStateExample()
                }
            }
        }
    }
}

@Composable
fun MyStateExample() {

    var counter by rememberSaveable { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = { counter ++ }) {
            Text(text = "Pulsar")
        }

        Text(text = "He sido pulsado $counter veces")

    }
}

@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .background(Color.Cyan), contentAlignment = Alignment.Center) {

            Text(text = "Hola esto es un ejemplo")
        }

        MySpacer(30)

        Row(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)) {
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Magenta), contentAlignment = Alignment.Center) {

                Text(text = "Hola esto es un ejemplo")
            }
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Red), contentAlignment = Alignment.Center) {
                Text(text = "Hola esto es un ejemplo")
            }
        }

        MySpacer(80)

        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .background(Color.Green), contentAlignment = Alignment.BottomCenter) {

            Text(text = "Hola esto es un ejemplo")
        }
    }
}

@Composable
fun MyRow() {
    Row(modifier = Modifier.fillMaxSize()) {
        Text(text = "Ejemplo 1", modifier = Modifier
            .background(Color.Blue)
            .weight(1f)
            .height(100.dp))

        Text(text = "Ejemplo 1", modifier = Modifier
            .background(Color.Red)
            .weight(1f)
            .height(100.dp))

        Text(text = "Ejemplo 1", modifier = Modifier
            .background(Color.Cyan)
            .weight(1f)
            .height(100.dp))

    }
}

@Composable
fun MyColumn() {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween) {
        Text(text = "Ejemplo 1", modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo 1", modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo 1", modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo 1", modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .height(100.dp))
    }
}

@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
        Box(modifier = Modifier
            .width(300.dp)
            .height(300.dp)
            .background(Color.Cyan)
            .verticalScroll(rememberScrollState()),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Este es un EJEMPLO")
        }

        SecondBox(text = "Probando mi propia box")
    }
}

@Composable
fun SecondBox(text: String) {
    Box(modifier = Modifier
        .height(50.dp)
        .height(100.dp)
        .background(Color.LightGray),
    contentAlignment = Alignment.BottomStart) {
        Text(text = text)
    }
}

@Composable
fun MySpacer(size: Int) {
    Spacer(modifier = Modifier
        .width(0.dp)
        .height(size.dp))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackComposeCatalogoTheme {
        MyStateExample()
    }
}
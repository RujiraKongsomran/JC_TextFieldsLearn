package com.rujirakongsomran.jc_textfieldslearn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rujirakongsomran.jc_textfieldslearn.ui.theme.JC_TextFieldsLearnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JC_TextFieldsLearnTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    TextField(
        value = "Type here...",
        onValueChange = {})
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JC_TextFieldsLearnTheme {
        Greeting()
    }
}
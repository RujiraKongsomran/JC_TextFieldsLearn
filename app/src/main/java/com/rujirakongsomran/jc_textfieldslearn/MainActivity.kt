package com.rujirakongsomran.jc_textfieldslearn

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var text by remember {
            mutableStateOf("Type here...")
        }
        BasicTextField(
            modifier = Modifier
                .background(Color.LightGray)
                .padding(16.dp),
            value = text,
            onValueChange = {
                text = it
            },
//            label = {
//                Text(text = "Title")
//            },
//            leadingIcon = {
//                IconButton(onClick = { /*TODO*/ }) {
//                    Icon(
//                        imageVector = Icons.Filled.Email,
//                        contentDescription = null
//                    )
//                }
//            },
//            trailingIcon = {
//                IconButton(onClick = {
//                    Log.d("Trailing Icon", "Clicked")
//                }) {
//                    Icon(
//                        imageVector = Icons.Filled.Check,
//                        contentDescription = null
//                    )
//                }
//            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    Log.d("ImeAction", "Clicked")
                }
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JC_TextFieldsLearnTheme {
        Greeting()
    }
}
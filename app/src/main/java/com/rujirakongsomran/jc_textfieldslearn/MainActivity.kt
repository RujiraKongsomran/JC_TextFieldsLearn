package com.rujirakongsomran.jc_textfieldslearn

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rujirakongsomran.jc_textfieldslearn.ui.theme.JC_TextFieldsLearnTheme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JC_TextFieldsLearnTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
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

@Composable
fun PasswordTextField() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var password by rememberSaveable { mutableStateOf("") }
        var passwordVisibility by remember {
            mutableStateOf(false)
        }

        val icon = if (passwordVisibility)
            painterResource(id = R.drawable.design_ic_visibility)
        else
            painterResource(id = R.drawable.design_ic_visibility_off)

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            placeholder = {
                Text(text = "Password")
            },
            label = {
                Text(text = "Password")
            },
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(
                        painter = icon,
                        contentDescription = "Visibility Icon"
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if (passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JC_TextFieldsLearnTheme {

    }
}
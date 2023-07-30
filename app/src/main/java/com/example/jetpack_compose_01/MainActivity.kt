package com.example.jetpack_compose_01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            login()
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Preview
    @Composable
    fun login()
    {
    Column(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color(android.graphics.Color.parseColor("#ffffff"))),
        horizontalAlignment = Alignment.CenterHorizontally)
        {
        Image(
            painterResource(id = R.drawable.top_background),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Image(
            painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier.height(100.dp)
        )
        Text("JAVASATU.COM",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(android.graphics.Color.parseColor("#7d32a8"))
        )

        var user by remember{mutableStateOf("")}
        var pass by remember{mutableStateOf("")}
        var passwordvisible by rememberSaveable {mutableStateOf(false)}

        TextField(
            value = user,
            onValueChange = { user = it },
            label = { Text("E-Mail") },
            modifier = Modifier
                .fillMaxWidth()
//                .height(66.dp)
                .padding(start = 64.dp, end = 64.dp, top = 4.dp, bottom = 4.dp)
                .border(
                    2.dp,
                    Color(android.graphics.Color.parseColor("#7d32a8")),
                    shape = RoundedCornerShape(25)
                ),
            shape = RoundedCornerShape(25),
            textStyle = TextStyle(
                textAlign = TextAlign.Center,
                color = Color(android.graphics.Color.parseColor("#7d32a8")),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            ),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)

        )

        TextField(
            value = pass,
            onValueChange = { pass = it },
            label = { Text("Sandi") },
            modifier = Modifier
                .fillMaxWidth()
//                .height(66.dp)
                .padding(start = 64.dp, end = 64.dp, top = 4.dp, bottom = 4.dp)
                .border(
                    2.dp,
                    Color(android.graphics.Color.parseColor("#7d32a8")),
                    shape = RoundedCornerShape(25)
                ),
            shape = RoundedCornerShape(25),
            textStyle = TextStyle(
                textAlign = TextAlign.Center,
                color = Color(android.graphics.Color.parseColor("#7d32a8")),
                fontSize = 16.sp
            ),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            visualTransformation = if(passwordvisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)

        )

        Button(onClick = { /*TODO*/ },
            Modifier
                .fillMaxWidth()
                .height(66.dp)
                .padding(start = 64.dp, end = 64.dp, top = 8.dp, bottom = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(android.graphics.Color.parseColor("#7d32a8")))
        ) {
            Text(
                text = "Login",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
                )
        }

            Text("Lupa sandi? Klik sini",
                Modifier.padding(bottom = 16.dp),
                fontSize = 14.sp,
                color = Color(android.graphics.Color.parseColor("#7d32a8"))
            )

        Button(onClick = { /*TODO*/ },
            Modifier
                .fillMaxWidth()
                .height(66.dp)
                .padding(start = 64.dp, end = 64.dp, top = 8.dp, bottom = 8.dp)
                .border(
                    2.dp,
                    color = Color(android.graphics.Color.parseColor("#7d32a8")),
                    shape = RoundedCornerShape(50)),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        ) {
            Text(
                text = "Daftar",
                color = Color(android.graphics.Color.parseColor("#7d32a8")),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Row(){
            Image(painter = painterResource(id = R.drawable.google),contentDescription = "",Modifier.padding(6.dp))
            Image(painter = painterResource(id = R.drawable.twitter),contentDescription = "",Modifier.padding(6.dp))
            Image(painter = painterResource(id = R.drawable.facebook),contentDescription = "",Modifier.padding(6.dp))
        }
        Image(painter = painterResource(
            id = R.drawable.bottom_background),
            contentDescription = "",
            contentScale = ContentScale.FillBounds)
    }
    }
}
package br.com.fiap.userdata

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.userdata.ui.theme.UserDataTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UserDataTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    
    var name by remember {
        mutableStateOf("")
    }

    var age by remember {
        mutableStateOf("")
    }
    
    Column (
        modifier = Modifier.
                    padding(32.dp)
    ) {
        Text(text = name)
        TextField(
            value = name,
            placeholder = {
                Text(text = "Digite seu nome")
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.person_24),
                    contentDescription = "user icon"
                )
            },
            modifier = Modifier
                .fillMaxWidth(),
            onValueChange = { value ->
                name = value
            },
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words)
        )
        TextField(
            value = age,
            placeholder = {
                Text(text = "Digite sua idade")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "user icon"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            onValueChange = { value ->
                age = value
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            textStyle = TextStyle(
                // color = Color.Red,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                // textAlign = TextAlign.Center
            ),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Magenta,
                unfocusedTextColor = Color.DarkGray,
                disabledTextColor = Color.Gray,
                cursorColor = Color.Cyan,
            )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    UserDataTheme {
        Greeting()
    }
}
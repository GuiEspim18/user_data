package br.com.fiap.userdata

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.Alignment
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
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

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

@SuppressLint("InvalidColorHexValue")
@Composable
fun Greeting() {
    
    var name by remember {
        mutableStateOf("")
    }

    var age by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var java by remember {
        mutableStateOf(false)
    }

    var kotlin by remember {
        mutableStateOf(false)
    }

    var opSystems by remember {
        mutableStateOf(-1)
    }

    var color by remember {
        mutableStateOf(Color(0xFFFF5500))
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
        Spacer(modifier = Modifier.height(32.dp))
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth(),
            label = {
                Text(text = "Digite o seu email")
            },
            placeholder = {
                Text(text = "example@gmail.com")
            },
            shape = RoundedCornerShape(32.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Magenta
            )
        )
        Spacer(modifier = Modifier.height(32.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = java, onCheckedChange = {
                java = it
            })
            Text(text = "Java")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = kotlin, onCheckedChange = {
                kotlin = it
            })
            Text(text = "Kotlin")
        }
        Spacer(modifier = Modifier.height(32.dp))
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = opSystems == 0,
                onClick = {
                    opSystems = 0
                }
            )
            Text(text = "Windows")
        }
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = opSystems == 1,
                onClick = {
                    opSystems = 1
                }
            )
            Text(text = "Macos")
        }
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = opSystems == 2,
                onClick = {
                    opSystems = 2
                }
            )
            Text(text = "Linux")
        }
        Spacer(modifier = Modifier.height(32.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Button(
                onClick = {
                    color = Color.Cyan
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = color,
                    contentColor = Color(0xFFF0F0F0)
                ),
                modifier = Modifier
                    .size(height = 48.dp, width = 250.dp),
                border = BorderStroke(4.dp, Color(0xFFCECECE)),
                shape = RoundedCornerShape(10.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Icon(imageVector = Icons.Default.Share, contentDescription = "Share")
                    Text(text = "Compartilhar")
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    UserDataTheme {
        Greeting()
    }
}
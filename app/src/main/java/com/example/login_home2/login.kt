package com.example.login_home2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.text.font.FontStyle
import com.example.login_home2.ui.theme.Login_home2Theme
import androidx.compose.ui.platform.LocalContext

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Login_home2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen() {
    val context = LocalContext.current // Obtém o contexto do composable

    // Armazenar o texto do campo de entrada
    var username by remember { mutableStateOf(TextFieldValue("")) }

    // Fundo azul centralizado
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2196F3)) // azul
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(128.dp))

            // Texto centralizado
            Text(
                text = "ESG Connect",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(bottom = 28.dp)
                    .align(Alignment.CenterHorizontally)
            )

            // Campo usuário
            BasicTextField(
                value = username,
                onValueChange = { username = it },
                modifier = Modifier
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(50.dp)
                    .clip(RoundedCornerShape(8.dp)),
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .background(Color.White)
                            .padding(16.dp)
                    ) {
                        if (username.text.isEmpty()) {
                            Text(
                                text = "Usuário",
                                color = Color.Gray,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        innerTextField()
                    }
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botão laranja
            Button(
                onClick = {
                    val intent = Intent(context, PrincipalActivity::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF9800) // laranja
                )
            ) {
                Text(
                    text = "Login",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Login_home2Theme {
        LoginScreen()
    }
}

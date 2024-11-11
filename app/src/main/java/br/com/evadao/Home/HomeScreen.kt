package br.com.evadao.Home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.evadao.AppBarTop
import br.com.evadao.BottomAppBar
import br.com.evadao.R
import br.com.evadao.ui.theme.EvadãoTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    //   val navController = rememberNavController()

//    NavHost(navController = navController, startDestination = "home_Screen"){
    //     composable("home_Screen"){
    //        HomeScreen(navController = navController)
    //    }
    //      composable("versiculos_Screen"){
    //         VersiculosScreen(navController = navController)
    //  }
    Scaffold(
        topBar = {
            AppBarTop() // Chamando a TopAppBar no Scaffold
        },
        bottomBar = {
            BottomAppBar() // Chamando a BottomAppBar no Scaffold
        },
        content = {
            Home()
        }
    )
}

@Composable
fun Home() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0x54D8D8D8)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Conectados pela Fé",
            color = Color.Yellow,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            modifier = Modifier.padding(16.dp)
        )
        Button(onClick = { /* Ação do botão 1 */ }) {
            Text(text = "Botão 1")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { /* Ação do botão 2 */ }) {
            Text(text = "Botão 2")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { /* Ação do botão 3 */ }) {
            Text(text = "Botão 3")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { /* Ação do botão 4 */ }) {
            Text(text = "Botão 4")
        }
    }
}

val customFontFamily = FontFamily(
    Font(R.font.italiano_regular)
)

@Preview(showBackground = true)
@Composable
fun Aplicacao() {
    EvadãoTheme {
        Surface {
            HomeScreen()
        }
    }
}

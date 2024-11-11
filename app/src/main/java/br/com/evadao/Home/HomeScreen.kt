package br.com.evadao.Home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import br.com.evadao.AppBarTop
import br.com.evadao.BottomAppBar
import br.com.evadao.ui.theme.EvadãoTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    
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
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0x54D8D8D8))
    ) {
        Text(text = "Conteúdo da Home", color = Color(0xFF216216))
    }
}

@Preview(showBackground = true)
@Composable
fun Aplicacao() {
    EvadãoTheme {
        Surface {
            HomeScreen()
        }
    }
}
package br.com.evadao.Oracao

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.evadao.AppBarTop
import br.com.evadao.BottomAppBar
import br.com.evadao.Home.Home
import br.com.evadao.R
import br.com.evadao.Versiculos.VersiculosScreen
import br.com.evadao.ui.theme.EvadãoTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MenuFunction4() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            AppBarTop()
        },
        bottomBar = {
            BottomAppBar(navController = navController)
        },
        content = {
            NavHost(navController = navController, startDestination = "home_screen") {
                composable("home_screen") {
                    Home(navController = navController)
                }
                composable("versiculos_screen") {
                    VersiculosScreen().Aplicacao()
                }
                composable("gloria_screen") {
                    Gloria()
                }
            }
        }
    )
}

@Composable
fun Gloria() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Gloria",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontFamily = customFontFamilyGloria,
            fontSize = 32.sp,
            modifier = Modifier
                .padding(120.dp),
            maxLines = 1
        )
        Text(
            text = "Glória ao Pai, ao Filho e ao Espírito Santo. Assim como era no princípio, agora e sempre. Amém.",
            color = Color.Black,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            fontFamily = FontFamily.SansSerif,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

val customFontFamilyGloria = FontFamily(
    Font(R.font.kaisei_decol)
)

@Preview(showBackground = true)
@Composable
fun PreviewTelaGloria() {
    EvadãoTheme {
        Surface {
            Gloria()
        }
    }
}
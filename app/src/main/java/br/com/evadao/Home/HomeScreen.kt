package br.com.evadao.Home

import EvadaoSobre
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.evadao.AppBarTop
import br.com.evadao.BottomAppBar
import br.com.evadao.Oracao.OracaoSelection
import br.com.evadao.R
import br.com.evadao.Versiculos.VersiculosScreen
import br.com.evadao.ui.theme.EvadãoTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            AppBarTop() // Calling the TopAppBar in the Scaffold
        },
        bottomBar = {
            BottomAppBar(navController = navController) // Passing NavController to BottomAppBar
        },
        content = {
            NavHost(navController = navController, startDestination = "home_screen") {
                composable("home_screen") {
                    Home(navController = navController)
                }
                composable("versiculos_screen") {
                    VersiculosScreen().Aplicacao()
                }
                composable("oracao_screen"){
                    OracaoSelection()
                }
                composable("EvadaoSobre"){
                    EvadaoSobre().SobreScreen()
                }
            }
        }
    )
}

@Composable
fun Home(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0x54D8D8D8)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(70.dp))
        Text(
            text = "Conectados pela \n\n         Fé",
            color = Color.Black,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            fontSize = 55.sp,
            fontFamily = customFontFamily,
            modifier = Modifier.padding(30.dp)
        )
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                SquareButton(
                    buttonText = "",
                    label = "Versículos",
                    colorResourceId = R.color.marrom_ciclista,
                    imageResId = R.drawable.cruz
                ) {
                    navController.navigate("versiculos_screen")
                }
                SquareButton(
                    buttonText = "",
                    label = "História",
                    colorResourceId = R.color.marrom_ciclista,
                    imageResId = R.drawable.livro
                ) { /* Button 2 action */ }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                SquareButton(
                    buttonText = "",
                    label = "Orações",
                    colorResourceId = R.color.marrom_ciclista,
                    imageResId = R.drawable.vela
                ) {
                    navController.navigate("oracao_screen")
                }
                SquareButton(
                    buttonText = "",
                    label = "Sobre",
                    colorResourceId = R.color.marrom_ciclista,
                    imageResId = R.drawable.info
                ) {navController.navigate("EvadaoSobre")}
            }
        }
    }
}

@Composable
fun SquareButton(
    buttonText: String,
    label: String,
    colorResourceId: Int,
    imageResId: Int,
    onClick: () -> Unit
) {
    val color = colorResource(id = colorResourceId)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(4.dp)
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .size(150.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = color)
        ) {
            Icon(
                painter = painterResource(id = imageResId),
                contentDescription = label,
                modifier = Modifier.size(80.dp),
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.height(3.dp))
        Text(text = label, fontSize = 20.sp)
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
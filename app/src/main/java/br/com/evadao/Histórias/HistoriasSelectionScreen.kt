package br.com.evadao.Histórias

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
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
import br.com.evadao.Home.Home
import br.com.evadao.R
import br.com.evadao.Versiculos.VersiculosScreen
import br.com.evadao.ui.theme.EvadãoTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavigationSelection() {
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
                composable("historias_screen") {
                    // HistoriasScreen()
                }
                composable("HistoriaAbraao"){
                    Abraão()
                }
                composable("HistoriaDavi") {
                    Davi()
                }
                composable("HistoriaIsaque") {
                    Isaque()
                }
                composable("HistoriaJó"){
                    Jó()
                }
                composable("HistoriaMoisés") {
                    Moises()
                }
            }
        }
    )
}

@Composable
fun HistoriaSelection(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(90.dp))
        Text(
            text = "Histórias",
            color = Color.Black,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            fontFamily = FontFamily.SansSerif,
            fontSize = 40.sp,
            modifier = Modifier.padding(20.dp)
        )
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            RectangleButton(
                buttonText = "",
                label = "Abraão",
                colorResourceId = R.color.marrom_ciclista,
            ) {
                navController.navigate("HistoriaAbraao")
            }
            RectangleButton(
                buttonText = "",
                label = "Davi",
                colorResourceId = R.color.marrom_ciclista,
            ) {
                navController.navigate("HistoriaDavi")
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Column(
            modifier = Modifier.padding(16.dp),

            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            RectangleButton(
                buttonText = "",
                label = "Isaque",
                colorResourceId = R.color.marrom_ciclista,
            ) {
                navController.navigate("HistoriaIsaque")
            }
            RectangleButton(
                buttonText = "",
                label = "Moisés",
                colorResourceId = R.color.marrom_ciclista,
            ) {
                navController.navigate("HistóriaMoisés")
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        RectangleButton(
            buttonText = "",
            label = "Jó",
            colorResourceId = R.color.marrom_ciclista,
        ) {
            navController.navigate("HistoriaJó")
        }
    }
}

@Composable
fun RectangleButton(
    buttonText: String,
    label: String,
    colorResourceId: Int,
    onClick: () -> Unit
) {
    val color = colorResource(id = colorResourceId)

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            shape = RoundedCornerShape(2.dp),
            colors = ButtonDefaults.buttonColors(containerColor = color)
        ) {
            // Empty content for the button
        }
        Text(text = label, fontSize = 20.sp, color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun AplicaçãoHome() {
    EvadãoTheme {
        Surface {
            NavigationSelection()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AplicacaoSelectionHistoria() {
    EvadãoTheme {
        Surface {
            HistoriaSelection(navController = rememberNavController())
            AppBarTop()
        }
    }
}
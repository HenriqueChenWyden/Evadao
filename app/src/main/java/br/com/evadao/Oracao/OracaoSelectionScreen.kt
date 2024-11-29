package br.com.evadao.Oracao

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
                composable("pai_nosso_screen"){
                    PaiNosso()
                }
                composable("ave_maria_screen") {
                    AveMaria()
                }
                composable("sinal_cruz_screen") {
                    SinalCruz()
                }
                composable("credo_screen"){
                    Credo()
                }
                composable("gloria_screen") {
                    Gloria()
                }
            }
        }
    )
}

@Composable
fun OracaoSelection(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Escolha a sua oração",
            color = Color.Black,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            fontFamily = FontFamily.SansSerif,
            fontSize = 20.sp,
            modifier = Modifier.padding(30.dp)
        )
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            RectangleButton(
                buttonText = "",
                label = "Pai-Nosso",
                colorResourceId = R.color.marrom_ciclista,
            ) {
                navController.navigate("pai_nosso_screen")
            }
            RectangleButton(
                buttonText = "",
                label = "Ave-Maria",
                colorResourceId = R.color.marrom_ciclista,
            ) {
                navController.navigate("ave_maria_screen")
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Column(
            modifier = Modifier.padding(16.dp),

            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            RectangleButton(
                buttonText = "",
                label = "Sinal da Cruz",
                colorResourceId = R.color.marrom_ciclista,
            ) {
                navController.navigate("sinal_cruz_screen")
            }
            RectangleButton(
                buttonText = "",
                label = "Credo",
                colorResourceId = R.color.marrom_ciclista,
            ) {
                navController.navigate("credo_screen")
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        RectangleButton(
            buttonText = "",
            label = "Glória",
            colorResourceId = R.color.marrom_ciclista,
        ) {
            navController.navigate("gloria_screen")
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
fun AplicacaoSelectionOracao() {
    EvadãoTheme {
        Surface {
            OracaoSelection(navController = rememberNavController())
        }
    }
}
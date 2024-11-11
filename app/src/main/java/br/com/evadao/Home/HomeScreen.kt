package br.com.evadao.Home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
        verticalArrangement = Arrangement.Top // Alinha tudo no topo
    ) {
        Spacer(modifier = Modifier.height(70.dp)) // Altere este valor para mover o texto para cima ou para baixo
        Text(
            text = "Conectados pela \n\n         Fé",
            color = Color.Black,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            fontSize = 55.sp,
            fontFamily = customFontFamily,
            modifier = Modifier.padding(16.dp)
        )
        // Organize os botões em uma grade 2x2 com texto abaixo do botão
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
                    imageResId = R.drawable.cruz // Adicione a imagem desejada
                ) { /* Ação do botão 1 */ }
                SquareButton(
                    buttonText = "",
                    label = "História",
                    colorResourceId = R.color.marrom_ciclista,
                    imageResId = R.drawable.livro // Adicione a imagem desejada
                ) { /* Ação do botão 2 */ }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                SquareButton(
                    buttonText = "",
                    label = "Orações",
                    colorResourceId = R.color.marrom_ciclista,
                    imageResId = R.drawable.vela // Adicione a imagem desejada
                ) { /* Ação do botão 3 */ }
                SquareButton(
                    buttonText = "",
                    label = "Sobre",
                    colorResourceId = R.color.marrom_ciclista,
                    imageResId = R.drawable.info // Adicione a imagem desejada
                ) { /* Ação do botão 4 */ }
            }
        }
    }
}

@Composable
fun SquareButton(
    buttonText: String,
    label: String,
    colorResourceId: Int,
    imageResId: Int, // Novo parâmetro para imagem
    onClick: () -> Unit
) {
    val color = colorResource(id = colorResourceId) // Obtém a cor corretamente

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp), // Alinha a imagem e o texto
        modifier = Modifier.padding(4.dp)
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .size(150.dp), // Define o tamanho do botão como 100x100 dp
            shape = RoundedCornerShape(8.dp), // Ajuste para um formato quadrado ou arredondado
            colors = ButtonDefaults.buttonColors(containerColor = color) // Use containerColor para cor de fundo
        ) {
            Icon(
                painter = painterResource(id = imageResId), // Exibe a imagem centralizada no botão
                contentDescription = label,
                modifier = Modifier.size(80.dp), // Tamanho da imagem
                tint = Color.White // Cor da imagem
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = label, fontSize = 20.sp) // Texto abaixo do botão
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

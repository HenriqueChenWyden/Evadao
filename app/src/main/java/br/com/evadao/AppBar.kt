package br.com.evadao

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.evadao.ui.theme.EvadãoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarTop() {
    val context = LocalContext.current.applicationContext

    TopAppBar(
        title = {
            Spacer(
                modifier = Modifier
                    .width(2.dp)
                    .fillMaxWidth()
            )
        },
        navigationIcon = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    Toast.makeText(context, "Menu clicado!", Toast.LENGTH_SHORT).show()
                }) {
                    Icon(
                        imageVector = Icons.Default.Menu, // Menu Hambuguer icone
                        contentDescription = "Menu",
                        modifier = Modifier.size(24.dp), // Tamanho Menu
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(id = R.drawable.icone),
                        contentDescription = "Icone do App",
                        modifier = Modifier.size(120.dp), // Tamanho do ícone
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.weight(1.3f))
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(context.getColor(R.color.marrom_ciclista)), //Cor do fundo
            titleContentColor = Color.White //Cor do texto
        )
    )
}

@Composable
fun BottomAppBar(navController: NavController) {
    val context = LocalContext.current
    BottomAppBar {
        Box(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconWithText(
                        iconResId = R.drawable.home,
                        contentDescription = "Home",
                        text = "Home",
                        onClick = {
                            navController.navigate("home_screen")
                        }
                    )
                    IconWithText(
                        iconResId = R.drawable.book,
                        contentDescription = "Book",
                        text = "Histórias",
                        onClick = {
                           // navController.navigate("historias")
                            Toast.makeText(context, "Histórias clicado!", Toast.LENGTH_SHORT).show()
                        }
                    )
                    IconWithText(
                        iconResId = R.drawable.auto_stories,
                        contentDescription = "Auto Stories",
                        text = "Versículos",
                        onClick = {
                            navController.navigate("versiculos_screen")
                        }
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                IconButton(
                    onClick = {
                        //navController.navigate("perfil")
                        Toast.makeText(context, "Perfil clicado!", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier.padding(end = 16.dp)
                ) {
                    Icon(
                        Icons.Filled.AccountCircle,
                        contentDescription = "Profile",
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun IconWithText(
    iconResId: Any,
    contentDescription: String,
    text: String,
    modifier: Modifier = Modifier,
    iconSize: Dp = 24.dp,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy((-10).dp),
        modifier = modifier
    ) {
        IconButton(onClick = onClick) {
            when (iconResId) {
                is Int -> {
                    Icon(
                        painter = painterResource(id = iconResId),
                        contentDescription = contentDescription,
                        modifier = Modifier.size(iconSize)
                    )
                }
                is ImageVector -> {
                    Icon(
                        imageVector = iconResId,
                        contentDescription = contentDescription,
                        modifier = Modifier.size(iconSize)
                    )
                }
            }
        }
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Aplicacao() {
    EvadãoTheme {
        Surface {
            AppBarTop()
        }
    }
}

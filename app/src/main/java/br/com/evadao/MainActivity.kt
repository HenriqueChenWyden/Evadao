package br.com.evadao

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.evadao.ui.theme.EvadãoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EvadãoTheme {
                Surface {
                    Background()
                    AppBarTop()
                }
            }
        }
    }
}

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
                // Sandwich menu on the left
                IconButton(onClick = {
                    Toast.makeText(context, "Clicou!", Toast.LENGTH_SHORT).show()
                }) {
                    Icon(
                        imageVector = Icons.Default.Menu, // Menu Hambuguer icone
                        contentDescription = "Menu",
                        modifier = Modifier.size(24.dp) // Tamanho Menu
                    )
                }

                // Spacer to push the custom icon to the center
                Spacer(modifier = Modifier.weight(1f))

                // Custom centered icon
                IconButton(onClick = {
                    Toast.makeText(context, "Custom icon clicked", Toast.LENGTH_SHORT).show()
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.icone),
                        contentDescription = "Icone do App",
                        modifier = Modifier.size(64.dp) // Tamanho do ícone
                    )
                }

                Spacer(modifier = Modifier.weight(1.3f)) // Ajuste do espaço
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color(context.getColor(R.color.gray_app)), // Fundo do Menu
            titleContentColor = Color.White, // Fundo dos Textos
        )
    )
}

@Composable
fun Background() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Content goes here
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    EvadãoTheme {
        Surface {
            Background()
            AppBarTop()
        }
    }
}
package br.com.evadao

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
                    BottomAppBar()
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomAppBar() {
    Scaffold(
        bottomBar = {
            BottomAppBar {
                // Create a Box to hold the icons and position them
                Box(modifier = Modifier.fillMaxSize()) {
                    // Centered icons
                    Row(
                        modifier = Modifier.align(Alignment.Center), // Center the Row
                        verticalAlignment = Alignment.CenterVertically // Align items vertically in the center
                    ) {
                        IconButton(onClick = { /* do something */ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.home),
                                contentDescription = "Home",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp)) // Add space between icons

                        IconButton(onClick = { /* do something */ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.book),
                                contentDescription = "Book",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp)) // Add space between icons

                        IconButton(onClick = { /* do something */ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.auto_stories),
                                contentDescription = "Auto Stories",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp)) // Add space between icons

                        IconButton(onClick = { /* do something */ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.groups),
                                contentDescription = "Groups",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }

                    // Profile icon on the right
                    IconButton(
                        onClick = { /* do something */ },
                        modifier = Modifier.align(Alignment.CenterEnd) // Align to the end
                    ) {
                        Icon(Icons.Filled.AccountCircle, contentDescription = "Profile")
                    }
                }
            }
        }
    ) {
        // Outros conteúdos
    }
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
            BottomAppBar()
            AppBarTop()
        }
    }
}
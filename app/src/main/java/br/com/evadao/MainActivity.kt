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
import androidx.compose.material3.Scaffold
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
                        modifier = Modifier.size(120.dp) // Tamanho do ícone
                    )
                }

                Spacer(modifier = Modifier.weight(1.3f)) // Ajuste do espaço
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(context.getColor(R.color.gray_app)), //Cor do fundo
            titleContentColor = Color.White //Cor do texto
        )
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomAppBar() {
    val context = LocalContext.current
    Scaffold(
        bottomBar = {
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
                            // Home icon with text
                            IconWithText(
                                iconResId = R.drawable.home,
                                contentDescription = "Home",
                                text = "Home",
                                onClick = {
                                    Toast.makeText(context, "Home clicado!", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            )

                            // Book icon with text
                            IconWithText(
                                iconResId = R.drawable.book,
                                contentDescription = "Book",
                                text = "Histórias",
                                onClick = {
                                    Toast.makeText(
                                        context,
                                        "Histórias clicado!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            )

                            // Auto Stories icon with text
                            IconWithText(
                                iconResId = R.drawable.auto_stories,
                                contentDescription = "Auto Stories",
                                text = "Vesículos",
                                onClick = {
                                    Toast.makeText(
                                        context,
                                        "Vesículos clicado!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            )
                        }

                        Spacer(modifier = Modifier.width(16.dp))
                        // Icone de Perfil no lado direito
                        IconButton(
                            onClick = {
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
    ) {
        //Qualquer outra coisa aqui
    }
}

@Composable
fun IconWithText(
    iconResId: Any,
    contentDescription: String,
    text: String,
    modifier: Modifier = Modifier,
    iconSize: Dp = 24.dp,
    onClick: () -> Unit // Add onClick parameter
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
        // Text below the icon
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium // Change this to your desired text style
        )
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
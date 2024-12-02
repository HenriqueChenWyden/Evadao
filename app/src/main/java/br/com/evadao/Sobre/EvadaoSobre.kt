import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.evadao.ui.theme.EvadãoTheme

class EvadaoSobre {

    @Composable
    fun SobreScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Text(
                text = "Sobre o Aplicativo",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Este aplicativo foi criado para trazer versículos bíblicos diretamente para você. A ideia é que seja uma ferramenta simples e prática para quem busca inspiração diária nas Escrituras.",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Gray
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewSobreScreen() {
        EvadãoTheme {
            Surface {
                SobreScreen()
            }
        }
    }
}


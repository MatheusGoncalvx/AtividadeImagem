package com.example.atividadeimagem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.atividadeimagem.ui.theme.AtividadeImagemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AtividadeImagemTheme {
                // Define a superfície (Surface) como a tela principal do aplicativo
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Renderiza o componente GreetingImage com os textos desejados
                    GreetingImage(
                        stringResource(R.string.happy_birthday_text),
                        stringResource(R.string.signature_text)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    // Cria uma coluna para que os textos não se sobreponham
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        // Renderiza o texto de saudação com tamanho e alinhamento específicos
        Text(
            text = message,
            fontSize = 65.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 16.dp)
        )
        // Renderiza o texto de assinatura com estilo específico
        Text(
            text = from,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(top = 16.dp)
                .padding(end = 16.dp)
                .align(alignment = Alignment.End)

        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    // Cria uma caixa para sobrepor imagem e textos
    Box(modifier) {
        // Renderiza a imagem com escala e opacidade específicas
        Image(
            painter = painterResource(id = R.drawable.tecnologia),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        // Renderiza os textos sobre a imagem
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    AtividadeImagemTheme {
        // Visualização em tempo de design do componente GreetingImage
        GreetingImage(
            message = "3º Novotec Desenvolvimento de Sistemas",
            from = "Matheus Gonçalves Lima"
        )
    }
}
package uz.ilhomjon.jetpackinstagram

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.ilhomjon.jetpackinstagram.ui.theme.JetpackInstagramTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                colum1()
                row()
                row2()
            }
        }
    }
}

@Composable
fun colum1() {

    Column(
        modifier = Modifier
            .fillMaxHeight(0.9f)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Greeting(
            "Instagram", TextStyle(
                fontSize = 50.sp, fontFamily = FontFamily(
                    Font(R.font.font2, FontWeight.Thin)
                )
            )
        )
        CircleImage()
        Greeting(name = "jacob_w", TextStyle(fontSize = 18.sp))
        SimpleCardComponent()
        Greeting(
            name = "Switch accounts",
            style = TextStyle(fontSize = 18.sp, color = Color.Blue)
        )
    }

}

@Composable
fun Greeting(name: String, style: TextStyle? = null, maxLines: Int? = null) {
    Text(
        text = name,
        modifier = Modifier.padding(16.dp),
        style = style ?: TextStyle.Default,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines ?: Int.MAX_VALUE
    )
}

@Composable
fun CircleImage() {
    Image(
            painter = painterResource(id = R.drawable.profile_image),
        contentDescription = null,
        modifier = Modifier.clip(CircleShape),
    )
}

@Composable
fun SimpleCardComponent() {
    val blue = Color(55, 151, 239, 1)
    val context = LocalContext.current
    Button(
        shape = RoundedCornerShape(8.dp),
        onClick = {
            context.startActivity(Intent(context, MainActivity2::class.java))
            Log.d("TAG", "SimpleCardComponent: ")
        }
    ) {
        Column(
            modifier = Modifier
                .width(300.dp)
                .height(40.dp)
                .padding(5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Log in", color = Color.White)
        }
    }
}


@Composable
fun row() {
    Row(
        modifier = Modifier
            .alpha(0.5f)
            .fillMaxWidth()
            .background(Color.Gray)
            .padding(0.5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

    }
}

@Composable
fun row2() {
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        Arrangement.Center
            ){
        Greeting(name = "Don’t have an account?", style = TextStyle(fontSize = 10.sp, color = Color.Gray))
        Greeting(name = "Sign up.", style = TextStyle(fontSize = 10.sp, color = Color.Black))
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackInstagramTheme {
        Greeting("Android")
    }
}
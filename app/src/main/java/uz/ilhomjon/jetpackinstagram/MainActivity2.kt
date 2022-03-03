package uz.ilhomjon.jetpackinstagram

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(35.dp)
                        .padding(10.dp),
                    alignment = Alignment.BottomStart
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.1f)
                )
                Text(
                    text = "Instagram",
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(
                        fontSize = 50.sp,
                        fontFamily = FontFamily(
                            Font(R.font.font2, FontWeight.Thin)
                        )
                    ),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = Int.MAX_VALUE
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    TextField(hint = "Username")
                    TextField(hint = "Password")
                }

                Text(
                    text = "Forgot password?",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    textAlign = TextAlign.End,
                    style = TextStyle(color = Color.Blue)
                )
                Button(
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .alpha(0.5f)
                        .padding(10.dp)
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                    onClick = {
                        Toast.makeText(this@MainActivity2, "Click log in", Toast.LENGTH_SHORT)
                            .show()
                    }
                ) {
                    Text(text = "Log in", style = TextStyle(color = Color.White))
                }

                Row(
                    modifier = Modifier.padding(horizontal = 0.dp, vertical = 10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_facenook),
                        contentDescription = null,
                        modifier = Modifier.padding(2.dp)
                    )
                    Text(
                        text = "Log in with Facebook",
                        style = TextStyle(color = Color.Blue),
                        modifier = Modifier.padding(2.dp)
                    )
                }

                rowUnderscore()

                Row(
                    modifier = Modifier.padding(horizontal = 0.dp, vertical = 5.dp)
                ) {
                    Text(
                        text = "Don’t have an account? Sign up.",
                        modifier = Modifier.padding(2.dp)
                    )
                    Text(
                        text = "Sign up.",
                        style = TextStyle(color = Color.Blue),
                        modifier = Modifier.padding(2.dp)
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.6f)
                ) {}

                Row(
                    modifier = Modifier
                        .alpha(0.5f)
                        .background(Color.Gray)
                        .height(1.dp)
                        .fillMaxWidth()
                ) {}

                Text(
                    text = "Instagram от Facebook",
                    modifier = Modifier
                        .padding(0.dp, 15.dp, 0.dp, 5.dp)
                )
            }
        }
    }

    @Composable
    fun TextField(hint: String) {
        var textFieldState by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = textFieldState,
            label = {
                Text(hint)
            },
            onValueChange = {
                textFieldState = it
//                        Toast.makeText(this@MainActivity2, "$it", Toast.LENGTH_SHORT).show()
            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
//                .height(52.dp)
                .padding(3.dp),
            shape = RoundedCornerShape(12.dp)
        )
    }

    @Composable
    fun rowUnderscore() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .wrapContentWidth(Alignment.CenterHorizontally)
                .wrapContentHeight(Alignment.CenterVertically)
        ) {
            underscore()
            Text(
                text = "\tor\t", style = TextStyle(fontSize = 18.sp)
            )
            underscore()
        }
    }

    @Composable
    fun underscore() {
        Column(

        ) {
            Box(
                modifier = Modifier
                    .width(150.dp)
                    .height(13.dp)
                    .padding(start = 6.dp, top = 0.dp, end = 6.dp, bottom = 0.dp)
            ) {}
            Box(
                modifier = Modifier
                    .width(150.dp)
                    .height(2.dp)
                    .padding(start = 6.dp, top = 1.dp, end = 6.dp, bottom = 0.dp)
                    .alpha(0.5f)
                    .background(Color.Gray)
            ) {}
        }
    }
}
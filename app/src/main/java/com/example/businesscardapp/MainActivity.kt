package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme
import com.example.businesscardapp.ui.theme.Green

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme(darkTheme = true) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        Identity(Modifier.weight(2f))
                        Contact(Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Composable
fun Identity(modifier: Modifier) {
    val image = painterResource(id = R.drawable.android_logo)

    Column(
        modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .padding(bottom = 8.dp)
        )
        Text(
            text = stringResource(R.string.name),
            fontSize = 40.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = stringResource(R.string.title),
            fontWeight = FontWeight.Bold,
            color = Green,
        )
    }
}

@Composable
fun Contact(modifier: Modifier) {
    Column(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Divider()
        ContactItem(
            stringResource(R.string.phone),
            R.drawable.ic_phone,
        )
        Divider()
        ContactItem(
            stringResource(R.string.github),
            R.drawable.ic_share,
        )
        Divider()
        ContactItem(
            stringResource(R.string.email),
            R.drawable.ic_email,
        )
    }
}

@Composable
fun ContactItem(label: String, icon: Int) {
    Row(Modifier.padding(10.dp)) {
        Icon(
            painter = painterResource(id = icon),
            tint = Green,
            contentDescription = null,
        )
        Text(
            text = label,
            modifier = Modifier.padding(start = 12.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardAppTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column {
                Identity(Modifier.weight(2f))
                Contact(Modifier.weight(1f))
            }
        }
    }
}
package com.hossein.dev.newsapp.presentation.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hossein.dev.newsapp.ui.theme.CustomColorsPalette
import com.hossein.dev.newsapp.ui.theme.NewsAppTheme

@Composable
fun HButton(
    buttonText: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int = 0,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        shape = RoundedCornerShape(8.dp),
        onClick = onClick
    ) {
        if (icon != 0) {
            Image(painter = painterResource(id = icon), contentDescription = "", Modifier.size(24.dp))
            Spacer(modifier = modifier.width(6.dp))
        }
        Text(
            text = buttonText,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun HTextButton(
    buttonText: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int = 0,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.textButtonColors(
            contentColor = CustomColorsPalette.current.colorGrey500
        ),
        shape = RoundedCornerShape(8.dp),
        onClick = onClick
    ) {
        if (icon != 0) {
            Image(painter = painterResource(id = icon), contentDescription = "", Modifier.size(24.dp))
            Spacer(modifier = modifier.width(6.dp))
        }
        Text(
            text = buttonText,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HButtonPreview() {
    NewsAppTheme {
        HButton(buttonText = "Click me ...",) {

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HTextButtonPreview() {
    NewsAppTheme {
        HTextButton(buttonText = "Click me ...",) {

        }
    }
}
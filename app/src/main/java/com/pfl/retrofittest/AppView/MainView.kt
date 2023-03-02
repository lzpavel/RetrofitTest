package com.pfl.retrofittest.AppView

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pfl.retrofittest.ui.theme.RetrofitTestTheme

class MainView {

    var onClickButtonUpdate : (() -> Unit)? = null

    @Composable
    fun setContent() {
        MainViewContent()
    }

    @Preview(showBackground = true)
    @Composable
    fun MainViewContent() {
        RetrofitTestTheme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Column {
                    Button(
                        onClick = {onClickButtonUpdate?.invoke()},
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Update")
                    }
                    Text(text = "Hello Android!")
                }

            }
        }
    }

    fun onClickButtonUpdate(click: () -> Unit) {
        onClickButtonUpdate = click
    }

}
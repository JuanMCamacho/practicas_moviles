package com.juan.viewmodels

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.juan.viewmodels.ui.theme.ViewModelsTheme
import com.juan.viewmodels.viewModels.CounterViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val counterViewModel : CounterViewModel by viewModels()
        enableEdgeToEdge()
        setContent {
            ViewModelsTheme {
                Scaffold( modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Content(innerPadding, counterViewModel)
                }
            }
        }
    }
}

@Composable
fun Content(paddingValues: PaddingValues, counterViewModel: CounterViewModel){
    var counter by remember { mutableIntStateOf(0) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .wrapContentSize(Alignment.Center)
    ){
        Text("Counter: ${counterViewModel.counter.value}")
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                counterViewModel.add()
            }
        ) {
            Text("Add")
        }
    }

}

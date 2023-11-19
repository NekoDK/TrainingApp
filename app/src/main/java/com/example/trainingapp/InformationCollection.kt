package com.example.trainingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainingapp.ui.theme.TrainingAppTheme

class InformationCollection : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            TrainingAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(modifier = Modifier.padding(12.dp),
                            contentAlignment = Alignment.TopCenter){
                            Text(text = "Выберите свой пол")

                        }
                        Genderselection()
                        Box(modifier = Modifier.padding(12.dp),
                            contentAlignment = Alignment.TopCenter){
                            Text(text = "Выберите свой тип тела")

                        }
                        BodySelection()
                        Box(modifier = Modifier.padding(12.dp),
                            contentAlignment = Alignment.TopCenter){
                            Text(text = "Выберите место тренировок")

                        }
                        TrainingLocation()
                    }
                }
            }
        }
    }
}

@Composable
fun Genderselection(){

    val genders = listOf(stringResource(R.string.man), stringResource(R.string.woman))
    val (selectedOption, onOptionSelected) = remember { mutableStateOf<String?>(null) }

    Column(Modifier.selectableGroup()){

        genders.forEach {text ->
            Row(Modifier
                .fillMaxWidth()
                .height(56.dp)
                .selectable(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) }
                ),
                verticalAlignment = Alignment.CenterVertically){
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = null
                )
                Text( text = text, fontSize = 22.sp )
            }

        }
    }
}

@Composable
fun BodySelection(){
    val bodyType = listOf("Ectomorph","Mesomorph","Endomorph")
    val (selectedOption, onOptionSelected) = remember {  mutableStateOf<String?>(null)}

    Column(Modifier.selectableGroup()){

        bodyType.forEach {text ->
            Row(Modifier
                .fillMaxWidth()
                .height(56.dp)
                .selectable(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) }
                ),
                verticalAlignment = Alignment.CenterVertically){
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = null
                )
                Text( text = text, fontSize = 22.sp )
            }

        }
        selectedOption?.let { selectedValue ->
            Text(text = selectedValue)
        }
    }
}

@Composable
fun TrainingLocation (){
    val checkedState1 = remember { mutableStateOf(false) }
    val checkedState2 = remember { mutableStateOf(false) }
    val checkedState3 = remember { mutableStateOf(false) }

    Row{
        Checkbox(
            checked = checkedState1.value,
            onCheckedChange = { checkedState1.value = it },
            modifier = Modifier.padding(5.dp)
        )
        Text("Зал", fontSize = 22.sp)

        Checkbox(
            checked = checkedState2.value,
            onCheckedChange = { checkedState2.value = it },
            modifier = Modifier.padding(5.dp)
        )
        Text("Дома", fontSize = 22.sp)

        Checkbox(
            checked = checkedState3.value,
            onCheckedChange = { checkedState3.value = it },
            modifier = Modifier.padding(5.dp)
        )
        Text("Улица", fontSize = 22.sp)
    }

}




@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    TrainingLocation()
}
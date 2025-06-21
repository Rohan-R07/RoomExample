package com.practice.roomdb

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.practice.roomdb.RoomDB.Data
import com.practice.roomdb.ui.theme.RoomDBTheme

class MainActivity : ComponentActivity() {

    val viewModel by viewModels<RoomViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return RoomViewModel(application) as T
                }
            }
        }
    )

    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val data = viewModel.user.collectAsState(initial = emptyList())

            var updataedText = remember {

                mutableStateOf("")
            }

            var updatedAge = remember {

                mutableStateOf("")
            }

            var nameText = remember {
                mutableStateOf("")
            }
            var ageText = remember {
                mutableStateOf("")
            }


            var dialogOpenState by remember {
                mutableStateOf(false)
            }
            RoomDBTheme {
//                var name = nameText.value
//                var age = ageText.value
                val datas = Data(nameText.value, ageText.value)
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    item {


                        TextField(
                            value = nameText.value,
                            onValueChange = { nameText.value = it },
                            modifier = Modifier.padding(16.dp),
                            placeholder = {
                                Text(text = "Name")
                            }

                        )

                        TextField(
                            value = ageText.value,
                            onValueChange = { ageText.value = it },
                            modifier = Modifier.padding(16.dp),
                            placeholder = {
                                Text(text = "age")
                            }

                        )
                        Button(
                            onClick = {
                                viewModel.upserData(datas)
                            }
                        ) {
                            Text(text = "Add Data")

                        }
                    }
                    items(data.value) { dta ->

                        Row(
                            modifier = Modifier
                                .clickable {
                                    dialogOpenState = !dialogOpenState
                                }
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {

                            Text(
                                text = "Name: ${dta.name}",
                                fontSize = 22.sp,
                                modifier = Modifier.padding(16.dp)
                            )
                            Text(
                                text = "Age: ${dta.age}",
                                fontSize = 22.sp,
                            )
                            IconButton(
                                onClick = {
                                    viewModel.deleteData(dta)

                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "Delete"
                                )
                            }

                        }
                        Log.d("Tag", dialogOpenState.toString())

                        if (dialogOpenState) {
//                            Toast.makeText(applicationContext,"Nihha",Toast.LENGTH_SHORT).show()
//                            dialogOpenState = false
                            var newtext by remember {
                                mutableStateOf("")

                            }
                            var newAge by remember {

                                mutableStateOf("")
                            }

                            Dialog(
                                onDismissRequest = {
                                    dialogOpenState = false
                                },
                                content = {
                                    Column(
                                        modifier = Modifier
                                            .wrapContentSize()
                                            .padding(20.dp)
                                    ) {
                                        TextField(
                                            value = newtext,
                                            onValueChange = { newtext = it },
                                        )

                                        TextField(
                                            value = newAge,
                                            onValueChange = { newAge = it },
                                        )

                                       Button(
                                           onClick = {
                                               viewModel.updateUser(dta,newtext,newAge)
                                               dialogOpenState = false

                                           }
                                       ) {
                                           Text(text = "Update")
                                       }
                                    }
                                }
                            )
                        }

                    }


                }
            }
        }
    }
}


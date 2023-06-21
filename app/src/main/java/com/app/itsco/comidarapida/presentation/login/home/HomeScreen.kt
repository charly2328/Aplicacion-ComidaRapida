package com.app.itsco.comidarapida.presentation.login.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.app.itsco.comidarapida.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Icon(Icons.Default.Folder, "Menu") },
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.food),
                        contentDescription = "logo de barra",
                        modifier = Modifier.size(24.dp)
                    )
                }
            )
        },
        content = {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(10) { index ->
                    androidx.compose.material3.ListItem(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.coctel),
                                contentDescription = "coctel de camaron",
                                modifier = Modifier
                                    .fillMaxWidth(0.5f)
                                    .height(200.dp)
                            )
                            Text(
                                text = "Item $index",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                                    .padding(start = 16.dp)
                                    .align(Alignment.CenterVertically)
                            )
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(Icons.Default.Remove, "Minus")
                            }
                            Text(
                                text = "0",
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(Icons.Default.Add, "Mas")
                            }
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.salmon),
                                contentDescription = "salmon aumado",
                                modifier = Modifier
                                    .fillMaxWidth(0.5f)
                                    .height(200.dp)
                            )
                            Text(
                                text = "Item $index",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                                    .padding(start = 16.dp)
                                    .align(Alignment.CenterVertically)
                            )
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(Icons.Default.Remove, "Minus")
                            }
                            Text(
                                text = "0",
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(Icons.Default.Add, "Mas")
                            }
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.salmon2),
                                contentDescription = "salmon asado",
                                modifier = Modifier
                                    .fillMaxWidth(0.5f)
                                    .height(200.dp)
                            )
                            Text(
                                text = "Item $index",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                                    .padding(start = 16.dp)
                                    .align(Alignment.CenterVertically)
                            )
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(Icons.Default.Remove, "Minus")
                            }
                            Text(
                                text = "0",
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(Icons.Default.Add, "Mas")
                            }
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.pozole),
                                contentDescription = "pozole",
                                modifier = Modifier
                                    .fillMaxWidth(0.5f)
                                    .height(200.dp)
                            )
                            Text(
                                text = "Item $index",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                                    .padding(start = 16.dp)
                                    .align(Alignment.CenterVertically)
                            )
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(Icons.Default.Remove, "Minus")
                            }
                            Text(
                                text = "0",
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(Icons.Default.Add, "Mas")
                            }
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.sopa),
                                contentDescription = "sopa",
                                modifier = Modifier
                                    .fillMaxWidth(0.5f)
                                    .height(200.dp)
                            )
                            Text(
                                text = "Item $index",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                                    .padding(start = 16.dp)
                                    .align(Alignment.CenterVertically)
                            )
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(Icons.Default.Remove, "Minus")
                            }
                            Text(
                                text = "0",
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(Icons.Default.Add, "Mas")
                            }
                        }
                    }
                }
            }
        }
    )
}
package com.example.banksampah.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.banksampah.model.SetoranSampah
import com.example.banksampah.ui.theme.Purple40
import com.example.banksampah.ui.theme.PurpleGrey40
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormPencatatanSampah(onSimpan: (SetoranSampah) -> Unit) {
    val tanggal = remember { mutableStateOf(TextFieldValue("")) }
    val nama = remember { mutableStateOf(TextFieldValue("")) }
    val berat = remember { mutableStateOf(TextFieldValue("")) }
    Box {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            OutlinedTextField(
                label = { Text(text = "Tanggal") },
                value = tanggal.value,
                onValueChange = {
                    tanggal.value = it
                },
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                placeholder = { Text(text = "yyyy-mm-dd") }
            )
            OutlinedTextField(
                label = { Text(text = "Nama") },
                value = nama.value,
                onValueChange = {
                    nama.value = it
                },
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    capitalization =
                    KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text
                ),
                placeholder = { Text(text = "XXXXX") }
            )
            OutlinedTextField(
                label = { Text(text = "Berat") },
                value = berat.value,
                onValueChange = {
                    berat.value = it
                },
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType =
                    KeyboardType.Decimal
                ),
                placeholder = { Text(text = "5") }
            )
            val loginButtonColors = ButtonDefaults.buttonColors(
                containerColor = Purple40,
                contentColor = PurpleGrey40
            )
            val resetButtonColors = ButtonDefaults.buttonColors(
                containerColor = PurpleGrey40,
                contentColor = Purple40
            )
            Row(modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()) {
                Button(modifier = Modifier.weight(5f), onClick = {
                    val item = SetoranSampah(
                        tanggal.value.text, nama.value.text,
                        berat.value.text
                    )
                    onSimpan(item)
                    tanggal.value = TextFieldValue("")
                    nama.value = TextFieldValue("")
                    berat.value = TextFieldValue("")
                }, colors = loginButtonColors) {
                    Text(
                        text = "Simpan",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 18.sp
                        ), modifier = Modifier.padding(8.dp)
                    )
                }
                Button(modifier = Modifier.weight(5f), onClick = {
                    tanggal.value = TextFieldValue("")
                    nama.value = TextFieldValue("")
                    berat.value = TextFieldValue("")
                }, colors = resetButtonColors) {
                    Text(
                        text = "Reset",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 18.sp
                        ), modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}
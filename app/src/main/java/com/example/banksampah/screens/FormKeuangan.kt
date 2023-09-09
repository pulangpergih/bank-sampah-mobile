package com.example.banksampah.screens

import android.widget.Toast
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
import com.example.banksampah.model.Setoran
import com.example.banksampah.ui.theme.Purple40
import com.example.banksampah.ui.theme.PurpleGrey40
import androidx.compose.ui.platform.LocalContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormPencatatanSampah(onSimpan: (Setoran) -> Unit) {
    val context = LocalContext.current
    val tanggal = remember { mutableStateOf(TextFieldValue("")) }
    val keterangan = remember { mutableStateOf(TextFieldValue("")) }
    val pemasukan = remember { mutableStateOf(TextFieldValue("")) }
    val pengeluaran = remember { mutableStateOf(TextFieldValue("")) }
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
                label = { Text(text = "Keterangan") },
                value = keterangan.value,
                onValueChange = {
                    keterangan.value = it
                },
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    capitalization =
                    KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text
                ),
                placeholder = { Text(text = "Pemasukan") }
            )
            OutlinedTextField(
                label = { Text(text = "Pemasukan") },
                value = pemasukan.value,
                onValueChange = {
                    pemasukan.value = it
                },
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType =
                    KeyboardType.Decimal
                ),
                placeholder = { Text(text = "0") }
            )
            OutlinedTextField(
                label = { Text(text = "Pengeluaran") },
                value = pengeluaran.value,
                onValueChange = {
                    pengeluaran.value = it
                },
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType =
                    KeyboardType.Decimal
                ),
                placeholder = { Text(text = "0") }
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
                        val item = Setoran(
                        tanggal.value.text,
                        keterangan.value.text,
                        pemasukan.value.text,
                        pengeluaran.value.text
                    )
                    if ( tanggal.value.text == "") {
                        Toast.makeText(context, "Tanggal harus diisi", Toast.LENGTH_SHORT).show()
                } else {
                        if ( keterangan.value.text == "") {
                            Toast.makeText(context, "Keterangan harus diisi", Toast.LENGTH_SHORT).show()
                        }else{
                            if ( pemasukan.value.text == "") {
                                Toast.makeText(context, "Pemasukan harus diisi", Toast.LENGTH_SHORT).show()
                            } else{
                                if ( pengeluaran.value.text == "") {
                                    Toast.makeText(context, "Pengeluaran harus diisi", Toast.LENGTH_SHORT).show()
                                }else{
                                    onSimpan(item)
                                    tanggal.value = TextFieldValue("")
                                    keterangan.value = TextFieldValue("")
                                    pemasukan.value = TextFieldValue("")
                                    pengeluaran.value = TextFieldValue("")
                                }
                            }
                        }
                    }

//
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
                    keterangan.value = TextFieldValue("")
                    pemasukan.value = TextFieldValue("")
                    pengeluaran.value = TextFieldValue("")
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
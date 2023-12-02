package com.example.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.LightGray
import com.example.calculator.ui.theme.Orange

@Composable
fun calculator(
    state: calculaterState,
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 8.dp,
    onAction: (calculatorAction) -> Unit
): Unit {
    Box(modifier = modifier){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),//it is only possible because this column is inside of the box
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)//will make sure that it is 8 dp of space betweenall items of the column in a vertical direction
        ){
                Text(
                    text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 32.dp),
                    fontWeight = FontWeight.Light,
                    fontSize = 80.sp,
                    color = Color.White,
                    maxLines = 2
                )
            //ROW 1
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                smallCalculaterButton(
                    symbol = "AC",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(2f)//width of the button is twice as wide as it is high
                        .weight(2f),//vai ocupar o space dependente do weight dos outros butoes do resto da row assim o composable ira definir automaticamente
                        onClick = {
                            onAction(calculatorAction.Clear)
                    }
                )
                smallCalculaterButton(
                    symbol = "Delete",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(1f)//width of the button is twice as wide as it is high
                        .weight(1f),//vai ocupar o space dependente do weight dos outros butoes do resto da row assim o composable ira definir automaticamente
                    onClick = {
                        onAction(calculatorAction.Delete)
                    }
                )
                smallCalculaterButton(
                    symbol = "/",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)//width of the button is twice as wide as it is high
                        .weight(1f),//vai ocupar o space dependente do weight dos outros butoes do resto da row assim o composable ira definir automaticamente
                    onClick = {
                        onAction(calculatorAction.Operation(calculatorOperation.Divide))
                    }
                )
            }
            //ROW 2
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                smallCalculaterButton(
                    symbol = "7",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)//width of the button is twice as wide as it is high
                        .weight(1f),//vai ocupar o space dependente do weight dos outros butoes do resto da row assim o composable ira definir automaticamente
                    onClick = {
                        onAction(calculatorAction.Number(7))
                    }
                )
                smallCalculaterButton(
                    symbol = "8",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)//width of the button is twice as wide as it is high
                        .weight(1f),//vai ocupar o space dependente do weight dos outros butoes do resto da row assim o composable ira definir automaticamente
                    onClick = {
                        onAction(calculatorAction.Number(8))
                    }
                )
                smallCalculaterButton(
                    symbol = "9",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)//width of the button is twice as wide as it is high
                        .weight(1f),//vai ocupar o space dependente do weight dos outros butoes do resto da row assim o composable ira definir automaticamente
                    onClick = {
                        onAction(calculatorAction.Number(9))
                    }
                )
                smallCalculaterButton(
                    symbol = "x",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)//width of the button is twice as wide as it is high
                        .weight(1f),//vai ocupar o space dependente do weight dos outros butoes do resto da row assim o composable ira definir automaticamente
                    onClick = {
                        onAction(calculatorAction.Operation(calculatorOperation.Multiply))
                    }
                )
            }
            //ROW 3
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                smallCalculaterButton(
                    symbol = "4",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)//width of the button is twice as wide as it is high
                        .weight(1f),//vai ocupar o space dependente do weight dos outros butoes do resto da row assim o composable ira definir automaticamente
                    onClick = {
                        onAction(calculatorAction.Number(4))
                    }
                )
                smallCalculaterButton(
                    symbol = "5",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)//width of the button is twice as wide as it is high
                        .weight(1f),//vai ocupar o space dependente do weight dos outros butoes do resto da row assim o composable ira definir automaticamente
                    onClick = {
                        onAction(calculatorAction.Number(5))
                    }
                )
                smallCalculaterButton(
                    symbol = "6",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)//width of the button is twice as wide as it is high
                        .weight(1f),//vai ocupar o space dependente do weight dos outros butoes do resto da row assim o composable ira definir automaticamente
                    onClick = {
                        onAction(calculatorAction.Number(6))
                    }
                )
                smallCalculaterButton(
                    symbol = "-",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)//width of the button is twice as wide as it is high
                        .weight(1f),//vai ocupar o space dependente do weight dos outros butoes do resto da row assim o composable ira definir automaticamente
                    onClick = {
                        onAction(calculatorAction.Operation(calculatorOperation.Subtract))
                    }
                )
            }
            //ROW 4
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                smallCalculaterButton(
                    symbol = "1",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)//width of the button is twice as wide as it is high
                        .weight(1f),//vai ocupar o space dependente do weight dos outros butoes do resto da row assim o composable ira definir automaticamente
                    onClick = {
                        onAction(calculatorAction.Number(1))
                    }
                )
                smallCalculaterButton(
                    symbol = "2",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)//width of the button is twice as wide as it is high
                        .weight(1f),//vai ocupar o space dependente do weight dos outros butoes do resto da row assim o composable ira definir automaticamente
                    onClick = {
                        onAction(calculatorAction.Number(2))
                    }
                )
                smallCalculaterButton(
                    symbol = "3",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)//width of the button is twice as wide as it is high
                        .weight(1f),//vai ocupar o space dependente do weight dos outros butoes do resto da row assim o composable ira definir automaticamente
                    onClick = {
                        onAction(calculatorAction.Number(3))
                    }
                )
                smallCalculaterButton(
                    symbol = "+",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)//width of the button is twice as wide as it is high
                        .weight(1f),//vai ocupar o space dependente do weight dos outros butoes do resto da row assim o composable ira definir automaticamente
                    onClick = {
                        onAction(calculatorAction.Operation(calculatorOperation.Add))
                    }
                )
            }
            //ROW 5
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                smallCalculaterButton(
                    symbol = "0",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(2f)//width of the button is twice as wide as it is high
                        .weight(2f),//vai ocupar o space dependente do weight dos outros butoes do resto da row assim o composable ira definir automaticamente
                    onClick = {
                        onAction(calculatorAction.Number(0))
                    }
                )
                smallCalculaterButton(
                    symbol = ".",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)//width of the button is twice as wide as it is high
                        .weight(1f),//vai ocupar o space dependente do weight dos outros butoes do resto da row assim o composable ira definir automaticamente
                    onClick = {
                        onAction(calculatorAction.Decimal)
                    }
                )
                smallCalculaterButton(
                    symbol = "=",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)//width of the button is twice as wide as it is high
                        .weight(1f),//vai ocupar o space dependente do weight dos outros butoes do resto da row assim o composable ira definir automaticamente
                    onClick = {
                        onAction(calculatorAction.Calculate)
                    }
                )
            }

        }
    }
}
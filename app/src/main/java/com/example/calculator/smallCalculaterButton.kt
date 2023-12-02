package com.example.calculator

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun smallCalculaterButton(
    symbol: String,
    modifier: Modifier,
    onClick: () -> Unit
): Unit {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(CircleShape)
            .clickable { onClick() }
            .then(modifier)
        //passa o modifier da função para os parametros da funcao serem aplicados dps do Modifier criado na box
    ){
        Text(
            text = symbol,
            fontSize = 36.sp,
            //color = MaterialTheme.colorScheme.onBackground muda a cor consoante o theme do user
            color = Color.White
        )
    }
}
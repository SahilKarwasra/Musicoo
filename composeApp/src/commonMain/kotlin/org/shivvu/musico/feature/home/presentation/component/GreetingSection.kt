package org.shivvu.musico.feature.home.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import musico.composeapp.generated.resources.Res
import musico.composeapp.generated.resources.settings
import org.jetbrains.compose.resources.painterResource

@Composable
fun GreetingSection(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Column {
            Text("Good Morning", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, color = Color.Green, modifier = Modifier.padding(bottom = 3.dp))
            Text("Username", style = MaterialTheme.typography.titleMedium, color = Color.Gray)
        }
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(Res.drawable.settings),
            contentDescription = null,
            modifier = Modifier.size(34.dp),
            tint = Color.White
        )
    }
}
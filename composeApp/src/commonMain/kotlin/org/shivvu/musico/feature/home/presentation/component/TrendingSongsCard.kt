package org.shivvu.musico.feature.home.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun TrendingSongsCard(
    image: String,
    title: String,
    subtitle: String?
) {
    Column {
        AsyncImage(
            model = image,
            contentDescription = null,
            modifier = Modifier.padding(horizontal = 6.dp).size(170.dp).aspectRatio(9f / 16f)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.width(170.dp).padding(horizontal = 6.dp),
            maxLines = 1,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(12.dp))
        if (subtitle != null) {
            Text(
                text = subtitle,
                style = MaterialTheme.typography.titleSmall,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.width(170.dp).padding(horizontal = 6.dp),
                maxLines = 1,
                color = Color.Gray
            )
        }
    }


}
package org.shivvu.musico.feature.home.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun DiscoverCard(
    onClick: () -> Unit = {}, image: String?, title: String?, type: String?
) {
    Column(
        modifier = Modifier.clickable(onClick = onClick).padding(horizontal = 12.dp)
    ) {
        AsyncImage(
            model = image,
            contentDescription = null,
            modifier = Modifier
                .clip(
                    shape = RoundedCornerShape(52.dp)
                )
                .size(170.dp)
                .aspectRatio(9f / 16f)

        )
        Spacer(modifier = Modifier.height(12.dp))
        title?.let {
            Text(
                it,
                style = MaterialTheme.typography.titleMedium,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.width(170.dp),
                maxLines = 2,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(2.dp))
        type?.let {
            Text(
                it,
                style = MaterialTheme.typography.titleSmall,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.width(170.dp),
                maxLines = 1,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
        }
    }
}
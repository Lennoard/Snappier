package presentation.ui.components.social

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.androidvip.snappier.data.models.IconDTO
import br.com.androidvip.snappier.domain.component.SnappierObservableComponent
import br.com.androidvip.snappier.domain.component.base.Element
import br.com.androidvip.snappier.domain.entities.Card
import br.com.androidvip.snappier.domain.entities.Video
import br.com.androidvip.snappier.ui.NativeVideoPlayer
import br.com.androidvip.snappier.ui.component.SnappierIconButton
import br.com.androidvip.snappier.ui.component.SnappierImage
import br.com.androidvip.snappier.ui.component.SnappierText
import br.com.androidvip.snappier.ui.utils.composeColor
import kotlinx.coroutines.launch

class SocialFeedComponent : SnappierObservableComponent("social-feed") {
    @Composable
    override fun View(data: Element, extras: Map<String, Any?>?) {
        val bgColor = data.contents.firstOrNull()?.backgroundColor.composeColor()

        Column(
            modifier = Modifier
                .background(bgColor)
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.size(16.dp))
            data.contents.firstOrNull()?.cards?.forEach { card ->
                SocialCard(card = card)
                Spacer(modifier = Modifier.size(16.dp))
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun SocialCard(card: Card) {
        var comments by rememberSaveable { mutableStateOf(listOf<String>()) }
        var showCommentUi by rememberSaveable { mutableStateOf(false) }

        ElevatedCard(
            modifier = Modifier.padding(horizontal = 12.dp),
            shape = RoundedCornerShape(2.dp),
            colors = CardDefaults.elevatedCardColors(
                containerColor = card.backgroundColor.composeColor()
            )
        ) {
            val hasPostImage = card.content.images.orEmpty().size > 1
            val hasPostVideo = card.content.videos.orEmpty().isNotEmpty()
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                var expanded by remember { mutableStateOf(true) }
                val rotationState = animateFloatAsState(
                    targetValue = if (expanded) 0F else 180F,
                    label = "rotation"
                )
                Row(
                    verticalAlignment = Alignment.Top
                ) {
                    card.content.images?.firstOrNull()?.let { profilePic ->
                        SnappierImage(image = profilePic)
                    }

                    Column(
                        modifier = Modifier
                            .weight(1F)
                            .padding(start = 16.dp),
                        verticalArrangement = Arrangement.Top
                    ) {
                        card.content.texts?.forEachIndexed { index, text ->
                            if (index < 2) {
                                SnappierText(content = null, text = text)
                            }
                        }
                    }

                    if (hasPostImage || hasPostVideo) {
                        IconButton(
                            onClick = { expanded = !expanded },
                            modifier = Modifier.rotate(rotationState.value)
                        ) {
                            Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "")
                        }
                    }
                }

                card.content.texts?.lastOrNull()?.let { postText ->
                    Spacer(modifier = Modifier.height(16.dp))
                    SnappierText(content = null, text = postText)
                }
                AnimatedVisibility(visible = expanded && (hasPostImage || hasPostVideo)) {
                    Column {
                        if (hasPostImage) {
                            card.content.images?.lastOrNull()?.let { postImage ->
                                Spacer(modifier = Modifier.height(16.dp))
                                SnappierImage(image = postImage)
                            }
                        }

                        card.content.videos?.firstOrNull()?.let { postVideo ->
                            Spacer(modifier = Modifier.height(8.dp))
                            NativeVideoPlayer(
                                modifier = postVideo.constraintsModifier2(),
                                video = postVideo
                            )
                        }
                    }
                }
            }

            AnimatedVisibility(visible = comments.isNotEmpty()) {
                Comments(comments = comments)
                HorizontalDivider(modifier = Modifier.height(1.dp), color = Color.LightGray)
            }

            HorizontalDivider(modifier = Modifier.height(1.dp), color = Color.LightGray)

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                var liked by remember { mutableStateOf(false) }
                card.content.buttons?.forEachIndexed { index, button ->
                    val colorHex = if (index == 0) {
                        if (liked) "#354f90" else button.color
                    } else {
                        button.color
                    }
                    TextButton(
                        onClick = callback@{
                            when (index) {
                                0 -> liked = !liked
                                1 -> showCommentUi = true
                                2 -> {

                                }
                            }
                            emmitEvent(button.events.firstOrNull() ?: return@callback)
                        },
                        modifier = Modifier.weight(1F),
                        colors = ButtonDefaults.textButtonColors(contentColor = colorHex.composeColor())
                    ) {
                        button.icon?.let { icon ->
                            SnappierIconButton(
                                icon = (icon as? IconDTO)?.copy(color = colorHex) ?: icon
                            )
                            Spacer(modifier = Modifier.size(4.dp))
                        }
                        Text(
                            text = button.title,
                            fontSize = 12.sp,
                            color = colorHex.composeColor()
                        )
                    }

                    if (index != card.content.buttons?.lastIndex) {
                        VerticalDivider(modifier = Modifier.width(1.dp))
                    }
                }
            }

            val sheetState = rememberModalBottomSheetState()
            val scope = rememberCoroutineScope()

            if (showCommentUi) {
                ModalBottomSheet(
                    onDismissRequest = { showCommentUi = false },
                    sheetState = sheetState
                ) {
                    var comment by remember { mutableStateOf("") }
                    Text(
                        text = "Adicionar comentário",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        OutlinedTextField(
                            value = comment,
                            onValueChange = { comment = it },
                            modifier = Modifier
                                .heightIn(min = 70.dp)
                                .weight(1F)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        IconButton(onClick = {
                            comments += comment
                            scope.launch { sheetState.hide() }.invokeOnCompletion {
                                if (!sheetState.isVisible) {
                                    showCommentUi = false
                                }
                            }
                            comment = ""
                        }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.Send,
                                contentDescription = ""
                            )
                        }
                    }
                    Spacer(modifier = Modifier.size(24.dp))
                }
            }
        }
    }

    @Composable
    private fun Comments(comments: List<String>) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Comentários", fontWeight = FontWeight.Medium)
            comments.forEachIndexed { index, comment ->
                Row(
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, start = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(imageVector = Icons.Default.Person, contentDescription = "")
                    Text(text = comment, fontSize = 12.sp)
                }
                if (index < comments.lastIndex) {
                    HorizontalDivider(
                        modifier = Modifier
                            .height(1.dp)
                            .padding(start = 16.dp),
                        color = Color.LightGray
                    )
                }
            }
        }
    }

    private fun Video?.constraintsModifier2(): Modifier {
        return Modifier
            .background(Color.Transparent)
            .run {
                var result = this
                if (this@constraintsModifier2?.constraints != null) {
                    result = if (constraints!!.width <= 0) {
                        result.fillMaxWidth()
                    } else {
                        result.requiredWidth(constraints!!.width.dp)
                    }

                    constraints!!.height
                        .takeIf { it > 0 }
                        ?.let {
                            result = result.requiredHeight(it.dp)
                        }
                }

                result
            }
    }
}

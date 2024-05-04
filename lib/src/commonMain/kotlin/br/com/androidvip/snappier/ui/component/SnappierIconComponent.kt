package br.com.androidvip.snappier.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import br.com.androidvip.snappier.domain.component.SnappierComponentData
import br.com.androidvip.snappier.domain.component.SnappierObservableComponent
import br.com.androidvip.snappier.domain.component.base.Event
import br.com.androidvip.snappier.domain.component.base.EventTrigger
import br.com.androidvip.snappier.domain.component.data.IconData
import br.com.androidvip.snappier.ui.utils.composeColor

class SnappierIconComponent : SnappierObservableComponent("snappier_icon") {
    @Composable
    override fun render(data: SnappierComponentData, extras: Map<String, Any?>?) {
        data.contents.firstOrNull()?.let { content ->
            content.icons?.firstOrNull()?.let { icon ->
                SnappierIcon(
                    onClick = { emmitEvent(it) },
                    icon = icon
                )
            }
        }
    }
}

@Composable
internal fun SnappierIcon(icon: IconData, onClick: ((Event) -> Unit)? = null) {
    getIconVectorByName(icon.token)?.let { vector ->
        IconButton(
            onClick = {
                val event = icon.events.find { it.trigger == EventTrigger.OnClick }
                event?.let { onClick?.invoke(it) }
            }
        ) {
            Icon(
                imageVector = vector,
                contentDescription = icon.description,
                tint = icon.color.composeColor(),
                modifier = Modifier.size(icon.size.dp)
            )
        }
    }
}

// Temporary, support for multiplatform where no JVM `Class.forName` is available
internal fun getIconVectorByName(name: String): ImageVector? {
    return when (name.lowercase()) {
        "add" -> Icons.Default.Add
        "add_circle", "addcircle" -> Icons.Default.AddCircle
        "account_box", "accountbox" -> Icons.Default.AccountBox
        "arrow_drop_down", "arrowdropdown" -> Icons.Default.ArrowDropDown
        "build", "tools" -> Icons.Default.Build
        "call" -> Icons.Default.Call
        "check" -> Icons.Default.Check
        "close" -> Icons.Default.Close
        "create" -> Icons.Default.Create
        "clear" -> Icons.Default.Clear
        "check_circle", "checkcircle" -> Icons.Default.CheckCircle
        "delete" -> Icons.Default.Delete
        "done" -> Icons.Default.Done
        "edit" -> Icons.Default.Edit
        "email" -> Icons.Default.Email
        "face" -> Icons.Default.Face
        "favorite" -> Icons.Default.Favorite
        "favorite_border", "favoriteborder" -> Icons.Default.FavoriteBorder
        "home" -> Icons.Default.Home
        "info" -> Icons.Default.Info
        "location" -> Icons.Default.LocationOn
        "lock" -> Icons.Default.Lock
        "menu" -> Icons.Default.Menu
        "more" -> Icons.Default.MoreVert
        "person" -> Icons.Default.Person
        "phone" -> Icons.Default.Phone
        "place" -> Icons.Default.Place
        "notifications" -> Icons.Default.Notifications
        "play" -> Icons.Default.PlayArrow
        "refresh" -> Icons.Default.Refresh
        "search" -> Icons.Default.Search
        "settings" -> Icons.Default.Settings
        "share" -> Icons.Default.Share
        "cart", "shopping_cart", "shoppingcart" -> Icons.Default.ShoppingCart
        "start" -> Icons.Default.Star
        "thumbup", "thumb_up" -> Icons.Default.ThumbUp
        "warning" -> Icons.Default.Warning
        else -> null
    }
}

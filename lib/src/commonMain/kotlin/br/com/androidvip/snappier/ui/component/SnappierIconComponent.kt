package br.com.androidvip.snappier.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Feed
import androidx.compose.material.icons.automirrored.filled.Help
import androidx.compose.material.icons.automirrored.filled.Message
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
import androidx.compose.material.icons.filled.CreditCardOff
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Flight
import androidx.compose.material.icons.filled.FlightTakeoff
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoneyOffCsred
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.PriceChange
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material.icons.filled.RateReview
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.TaxiAlert
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.Wallet
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
                SnappierIconButton(
                    onClick = { emmitEvent(it) },
                    icon = icon
                )
            }
        }
    }
}

@Composable
fun SnappierIconButton(icon: IconData, onClick: ((Event) -> Unit)? = null) {
    getIconVectorByName(icon.token)?.let { vector ->
        if (onClick == null) {
            Icon(
                imageVector = vector,
                contentDescription = icon.description,
                tint = icon.color.composeColor(),
                modifier = Modifier.size(icon.size.dp)
            )
        } else {
            IconButton(
                onClick = {
                    val event = icon.events.find { it.trigger == EventTrigger.OnClick }
                    event?.let { onClick(it) }
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
}

// Temporary, support for multiplatform where no JVM `Class.forName` is available
internal fun getIconVectorByName(name: String): ImageVector? {
    return when (name.lowercase()) {
        "add" -> Icons.Default.Add
        "add_circle", "addcircle" -> Icons.Default.AddCircle
        "account_box", "accountbox" -> Icons.Default.AccountBox
        "arrow_drop_down", "arrowdropdown" -> Icons.Default.ArrowDropDown
        "back", "arrow_back" -> Icons.AutoMirrored.Default.ArrowBack
        "build", "tools" -> Icons.Default.Build
        "call" -> Icons.Default.Call
        "cart", "shopping_cart", "shoppingcart" -> Icons.Default.ShoppingCart
        "check" -> Icons.Default.Check
        "close" -> Icons.Default.Close
        "coupon" -> Icons.Default.PriceChange
        "create" -> Icons.Default.Create
        "credit_card_off" -> Icons.Default.CreditCardOff
        "clear" -> Icons.Default.Clear
        "check_circle", "checkcircle" -> Icons.Default.CheckCircle
        "delete" -> Icons.Default.Delete
        "discount" -> Icons.Default.ShoppingBag
        "done" -> Icons.Default.Done
        "edit" -> Icons.Default.Edit
        "email" -> Icons.Default.Email
        "face" -> Icons.Default.Face
        "favorite" -> Icons.Default.Favorite
        "favorite_border", "favoriteborder" -> Icons.Default.FavoriteBorder
        "feed" -> Icons.AutoMirrored.Default.Feed
        "friends", "group" -> Icons.Default.Group
        "help" -> Icons.AutoMirrored.Default.Help
        "home" -> Icons.Default.Home
        "info" -> Icons.Default.Info
        "location" -> Icons.Default.LocationOn
        "lock" -> Icons.Default.Lock
        "menu" -> Icons.Default.Menu
        "message" -> Icons.AutoMirrored.Default.Message
        "more" -> Icons.Default.MoreVert
        "person" -> Icons.Default.Person
        "phone" -> Icons.Default.Phone
        "place" -> Icons.Default.Place
        "notifications", "notification" -> Icons.Default.Notifications
        "flight" -> Icons.Default.Flight
        "payment_pending" -> Icons.Default.MoneyOffCsred
        "play" -> Icons.Default.PlayArrow
        "rate" -> Icons.Default.RateReview
        "refresh" -> Icons.Default.Refresh
        "order_sent" -> Icons.Default.FlightTakeoff
        "search" -> Icons.Default.Search
        "settings" -> Icons.Default.Settings
        "share" -> Icons.Default.Share
        "ship_pending" -> Icons.Default.LocalShipping
        "taxi_alert" -> Icons.Default.TaxiAlert
        "start" -> Icons.Default.Star
        "thumbup", "thumb_up", "thumbsup" -> Icons.Default.ThumbUp
        "question", "questionmark" -> Icons.Default.QuestionMark
        "wallet" -> Icons.Default.Wallet
        "warning" -> Icons.Default.Warning
        "world", "public" -> Icons.Default.Public
        else -> null
    }
}

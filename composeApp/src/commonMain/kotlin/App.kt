import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.androidvip.snappier.Snappier
import br.com.androidvip.snappier.domain.communication.EventObserver
import br.com.androidvip.snappier.domain.component.base.ActionType
import br.com.androidvip.snappier.domain.component.base.Element
import br.com.androidvip.snappier.domain.component.base.SnappierEvent
import data.di.dataModule
import domain.DataSource
import domain.repository.SnappierRepository
import org.koin.compose.KoinApplication
import org.koin.compose.koinInject
import presentation.ui.components.shop.CartComponent
import presentation.ui.components.shop.CategoriesComponent
import presentation.ui.components.shop.DetailsComponent
import presentation.ui.components.shop.FeaturedAllComponent
import presentation.ui.components.shop.FeaturedComponent
import presentation.ui.components.shop.ProfileHeaderComponent
import presentation.ui.components.shop.ProfileOrdersComponent
import presentation.ui.components.shop.ProfilePaymentsComponent
import presentation.ui.components.shop.ProfileServicesComponent
import presentation.ui.components.shop.RecommendedAllComponent
import presentation.ui.components.shop.RecommendedComponent
import presentation.ui.components.shop.SearchComponent
import presentation.ui.components.social.SocialFeedComponent
import presentation.ui.components.social.SocialTabComponent

@Composable
fun App() {
    KoinApplication(application = {
        modules(dataModule)
    }) {
        val repository = koinInject<SnappierRepository>()
        var element by remember { mutableStateOf<Element?>(null) }
        val navStack = ArrayDeque(listOf("home"))
        var route by remember { mutableStateOf(navStack.firstOrNull().orEmpty()) }

        val observer = EventObserver { event ->
            println("Received event action: ${event.action}")
            if (event.action.type == ActionType.LocalNavigation) {
                navStack.addLast(getRoute(event))
                route = navStack.lastOrNull().orEmpty()
            } else if (event.action.type == ActionType.NavigateUp) {
                if (navStack.size > 1) {
                    navStack.removeLastOrNull()
                }
                route = navStack.lastOrNull().orEmpty()
            }
            println("Routing to: $route")
        }

        val snappier by remember {
            mutableStateOf(
                Snappier {
                    onErrorComposable {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Error: $it")
                        }
                    }
                }.apply {
                    register(CategoriesComponent())
                    register(FeaturedComponent())
                    register(RecommendedComponent())
                    register(CartComponent(observer))
                    register(DetailsComponent(observer))
                    register(FeaturedAllComponent())
                    register(RecommendedAllComponent(observer))
                    register(SearchComponent(observer))
                    register(ProfileHeaderComponent())
                    register(ProfileOrdersComponent())
                    register(ProfilePaymentsComponent())
                    register(ProfileServicesComponent())
                    register(SocialFeedComponent())
                    register(SocialTabComponent())
                }
            )
        }

        DisposableEffect(element) {
            snappier.addObserver(observer)
            onDispose { snappier.removeObserver(observer) }
        }

        LaunchedEffect(route) {
            repository.getElementById(route, DataSource.LocalApi).collect {
                element = it
            }
        }

        SnappierScreen(snappier, element)
    }
}

@Composable
private fun SnappierScreen(
    snappier: Snappier,
    element: Element?
) {

    MaterialTheme {
        with(snappier) {
            if (element != null) {
                SnappierView(element)
            } else {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                    Text(
                        text = "Loading...",
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
            }
        }
    }
}

private fun getRoute(event: SnappierEvent): String {
    if (event.action.data.contains("app://product-details")) {
        val id = event.action.data.split("/").lastOrNull()
        return "product-details/product-$id"
    }

    return when (event.action.data) {
        "app://recommended" -> "recommended"
        "app://featured" -> "featured"
        "app://shopping-cart" -> "cart"
        "app://shop-account" -> "account"
        "app://shop-search" -> "search"
        else -> "home"
    }
}

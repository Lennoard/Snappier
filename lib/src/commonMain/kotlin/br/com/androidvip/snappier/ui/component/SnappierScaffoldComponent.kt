package br.com.androidvip.snappier.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.androidvip.snappier.domain.communication.EventDispatcher
import br.com.androidvip.snappier.domain.component.Component
import br.com.androidvip.snappier.domain.component.SnappierComponentData
import br.com.androidvip.snappier.domain.component.SnappierComponentRegisterer
import br.com.androidvip.snappier.domain.component.SnappierObservableComponent
import br.com.androidvip.snappier.domain.component.base.Event
import br.com.androidvip.snappier.domain.component.base.EventTrigger
import br.com.androidvip.snappier.domain.component.scaffold.BottomBarData
import br.com.androidvip.snappier.domain.component.scaffold.NavigationItem
import br.com.androidvip.snappier.domain.component.scaffold.ScaffoldData
import br.com.androidvip.snappier.domain.component.scaffold.TopBarData
import br.com.androidvip.snappier.ui.utils.composeColor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class SnappierScaffoldComponent : SnappierObservableComponent("snappier_scaffold") {

    @Composable
    override fun render(data: SnappierComponentData, extras: Map<String, Any?>?) {
        data.contents.firstOrNull()?.scaffold?.let { scaffold ->
            if (scaffold.isNavigationDrawerLayout) {
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()
                var selectedItem by remember { mutableStateOf<NavigationItem?>(null) }

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet {
                            scaffold.navigationItems?.forEach { item ->
                                NavigationDrawerItem(
                                    colors = NavigationDrawerItemDefaults.colors(
                                        selectedIconColor = item.color.composeColor(),
                                        selectedTextColor = item.color.composeColor()
                                    ),
                                    selected = selectedItem == item,
                                    onClick = {
                                        selectedItem = item
                                        scope.launch { drawerState.close() }
                                        item.action?.let {
                                            emmitEvent(Event(it, EventTrigger.OnClick))
                                        }
                                        communicateData(
                                            data = mapOf("selectedItemLabel" to item.label),
                                            targetComponentIds = listOf("snappier_button")
                                        )
                                    },
                                    label = { item.label?.let { Text(text = it) } },
                                    icon = {
                                        item.icon?.let { icon ->
                                            getIconVectorByName(icon.token)?.let { vector ->
                                                Icon(
                                                    imageVector = vector,
                                                    contentDescription = icon.description
                                                )
                                            }
                                        }
                                    }
                                )
                            }
                        }
                    }
                ) {
                    SnappierScaffold(scaffold, drawerState, scope, extras)
                }
            } else {
                SnappierScaffold(scaffold, null, null, extras)
            }
        }
    }

    @Composable
    private fun SnappierScaffold(
        scaffold: ScaffoldData,
        drawerState: DrawerState?,
        scope: CoroutineScope?,
        extras: Map<String, Any?>?
    ) {
        val registerer by remember { mutableStateOf(SnappierComponentRegisterer) }

        Scaffold(
            topBar = {
                TopBar(
                    scaffold.topBar,
                    scaffold.isNavigationDrawerLayout,
                    drawerState,
                    scope
                )
            },
            bottomBar = { BottomBar(scaffold.bottomBar, scaffold.navigationItems) },
            floatingActionButton = {
                scaffold.floatingComponent?.let { component ->
                    ScaffoldComponent(registerer, component, extras)
                }
            }
        ) { paddingValues ->
            scaffold.components?.let { components ->
                Box(
                    modifier = Modifier
                        .padding(paddingValues)
                        .consumeWindowInsets(paddingValues)
                ) {
                    LazyColumn {
                        items(count = components.count()) { index ->
                            ScaffoldComponent(registerer, components[index], extras)
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun ScaffoldComponent(
        registerer: SnappierComponentRegisterer,
        component: Component,
        extras: Map<String, Any?>?
    ) {
        val registeredComponent = registerer[component.id]
        if (registeredComponent is EventDispatcher) {
            observers.firstOrNull()?.let { observer ->
                DisposableEffect(true) {
                    registeredComponent.attachObserver(observer)
                    onDispose {
                        registeredComponent.detachObserver(observer)
                    }
                }
            }
        }

        registeredComponent?.render(component, extras)
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun TopBar(
        topBar: TopBarData?,
        isNavigationDrawerLayout: Boolean,
        drawerState: DrawerState?,
        scope: CoroutineScope?
    ) {
        topBar?.let { data ->
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = data.backgroundColor.composeColor()
                ),
                title = {
                    data.title?.let { SnappierText(null, it) }
                },
                navigationIcon = {
                    data.navigationIcon?.let { icon ->
                        getIconVectorByName(icon.token)?.let { vector ->
                            IconButton(
                                onClick = {
                                    if (isNavigationDrawerLayout) {
                                        scope?.launch {
                                            if (drawerState?.isClosed == true) {
                                                drawerState.open()
                                            } else {
                                                drawerState?.close()
                                            }
                                        }
                                    }

                                    icon.events.find { it.trigger == EventTrigger.OnClick }?.let {
                                        emmitEvent(it)
                                    }
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
                },
                actions = {
                    data.icons?.forEach { icon ->
                        SnappierIconButton(
                            onClick = {
                                icon.events.find { it.trigger == EventTrigger.OnClick }?.let {
                                    emmitEvent(it)
                                }
                            },
                            icon = icon
                        )
                    }
                }
            )
        }
    }

    @Composable
    private fun BottomBar(bottomBar: BottomBarData?, navigationItems: List<NavigationItem>?) {
        var selectedItem by remember { mutableStateOf<NavigationItem?>(null) }
        bottomBar?.let { data ->
            NavigationBar(
                containerColor = data.backgroundColor.composeColor()
            ) {
                navigationItems?.forEach { item ->
                    NavigationBarItem(
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = data.selectedIconColor.composeColor(),
                            selectedTextColor = data.selectedIconColor.composeColor(),
                            indicatorColor = Color.Transparent,
                            unselectedIconColor = data.iconColor.composeColor(),
                            unselectedTextColor = data.iconColor.composeColor()
                        ),
                        selected = selectedItem == item,
                        onClick = {
                            selectedItem = item
                            item.action?.let {
                                emmitEvent(Event(it, EventTrigger.OnClick))
                            }
                        },
                        label = if (item.label == null) {
                            null
                        } else {
                            { Text(text = item.label) }
                        },
                        icon = {
                            item.icon?.let { icon ->
                                getIconVectorByName(icon.token)?.let { vector ->
                                    Icon(
                                        imageVector = vector,
                                        contentDescription = icon.description
                                    )
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}

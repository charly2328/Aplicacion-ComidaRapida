package com.app.itsco.comidarapida.presentation.login.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Destination(
    val route: String,
    val arguments: List<NamedNavArgument>
){
    object Login: Destination("Login", emptyList())
    object Register: Destination("register", emptyList())
    object Home: Destination("home", listOf(
        navArgument("email"){ type = NavType.StringType},
        navArgument("password"){type = NavType.StringType }
        )
    )

}

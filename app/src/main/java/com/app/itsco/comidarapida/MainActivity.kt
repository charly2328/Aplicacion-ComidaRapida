package com.app.itsco.comidarapida

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.defaultDecayAnimationSpec
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.itsco.comidarapida.presentation.login.LoginScreen
import com.app.itsco.comidarapida.presentation.login.LoginViewModel
import com.app.itsco.comidarapida.presentation.login.home.HomeScreen
import com.app.itsco.comidarapida.presentation.login.navigation.Destination
import com.app.itsco.comidarapida.presentation.login.registration.RegisterViewModel
import com.app.itsco.comidarapida.presentation.login.registration.RegistrationScreen
import com.app.itsco.comidarapida.presentation.login.registration.ResgisterScreen
import com.app.itsco.comidarapida.ui.theme.ComidaRapidaTheme
import com.google.accompanist.navigation.animation.AnimatedComposeNavigator
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComidaRapidaTheme {
                val navController = rememberAnimatedNavController()

                BoxWithConstraints() {
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = Destination.Login.route
                        ){
                        addLogin(navController)

                        addRegister(navController)

                        addHome()
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addLogin(
    navController: NavHostController
){
    composable(
        route = Destination.Login.route,
        enterTransition = { _, _ ->
            slideInHorizontally(
                initialOffsetX = {1000},
                animationSpec = tween(500)
            )
        },
        exitTransition = { _, _ ->
            slideOutHorizontally(
                targetOffsetX = {-1000},
                animationSpec = tween(500)
            )
        },
        popEnterTransition = { _, _ ->
            slideInHorizontally(
                initialOffsetX = {-1000},
                animationSpec = tween(500)
            )
        },
        popExitTransition = { _, _ ->
            slideOutHorizontally(
                targetOffsetX = {1000},
                animationSpec = tween(500)
            )
        }
    ){
        val viewModel: LoginViewModel = hiltViewModel()
        if (viewModel.state.value.succesLogin){
            LaunchedEffect(key1 = Unit){
                navController.navigate(Destination.Home.route){
                    popUpTo(Destination.Login.route){
                        inclusive =  true
                    }
                }
            }
        }else{
            LoginScreen(
                state = viewModel.state.value,
                onLogin = viewModel::login,
                onNavigateToRegister = {
                    navController.navigate(Destination.Register.route)
                },
                onDismissDialog = viewModel::hideErrorDialog
            )
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addRegister(
    navController: NavHostController
){
    composable(
        route = Destination.Register.route,
        enterTransition = { _, _ ->
            slideInHorizontally(
                initialOffsetX = {1000},
                animationSpec = tween(500)
            )
        },
        exitTransition = { _, _ ->
            slideOutHorizontally(
                targetOffsetX = {-1000},
                animationSpec = tween(500)
            )
        },
        popEnterTransition = { _, _ ->
            slideInHorizontally(
                initialOffsetX = {-1000},
                animationSpec = tween(500)
            )
        },
        popExitTransition = { _, _ ->
            slideOutHorizontally(
                targetOffsetX = {1000},
                animationSpec = tween(500)
            )
        }
    ){
        val viewModel: RegisterViewModel = hiltViewModel()

        RegistrationScreen(
            state = viewModel.state.value,
            onRegister = viewModel::register,
            onBack = {
                navController.popBackStack()
            },
            onDismissDialog = viewModel::hideErrorDialog
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addHome(
){
    composable(
        route = Destination.Home.route,

    ){
        HomeScreen()
    }
}


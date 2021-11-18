package com.rujirakongsomran.jc_textfieldslearn

sealed class Screen(val route: String) {
    object Login : Screen(route = "login_screen")
    object Home : Screen(route = "home_screen")
}

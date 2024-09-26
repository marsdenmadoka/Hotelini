package com.madoka.hotelini.common.presentation.theme

import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val LightColors = lightColorScheme(
    primary = PrimaryColor,
    onPrimary = PrimaryTextColor,
    secondary = SecondaryColor,
    onSecondary = SecondaryTextColor,
    tertiary = PrimaryLightColor,
    onTertiary = PrimaryTextColor,
    background = BackgroundLightColor,
    onBackground = Color.Black,
    surface = SurfaceLight,
    onSurface = Color.Black,
    surfaceVariant = SurfaceLight,
    onSurfaceVariant = Color.Black,
    secondaryContainer = PrimaryColor,
    onSecondaryContainer = Color.White,
    error = ErrorColor,
    onError = OnErrorColor,
)

private val DarkColors = darkColorScheme(
    primary = PrimaryColor,
    onPrimary = PrimaryTextColor,
    secondary = SecondaryLightColor,
    onSecondary = SecondaryTextColor,
    tertiary = PrimaryLightColor,
    onTertiary = PrimaryTextColor,
    background = BackgroundDarkColor,
    onBackground = Color.White,
    surface = SurfaceDark,
    onSurface = Color.White,
    surfaceVariant = SurfaceDark,
    onSurfaceVariant = Color.White,
    secondaryContainer = PrimaryColor,
    onSecondaryContainer = Color.White,
    error = ErrorColor,
    onError = OnErrorColor,
)

@Composable
fun HoteliniTheme(
    theme: Int = Theme.DARK_THEME.themeValue,
    content: @Composable () -> Unit
) {
    val autoColors = if (isSystemInDarkTheme()) DarkColors else LightColors

    val dynamicColors = if (supportsDynamicTheming()) {
        val context = LocalContext.current
        if (isSystemInDarkTheme()) {
            dynamicDarkColorScheme(context)
        } else {
            dynamicLightColorScheme(context)
        }
    } else {
        autoColors
    }

    val colors = when (theme) {
        Theme.LIGHT_THEME.themeValue -> LightColors
        Theme.DARK_THEME.themeValue -> DarkColors
        Theme.MATERIAL_YOU.themeValue -> dynamicColors
        else -> autoColors
    }

    val systemUiController = rememberSystemUiController()


    SideEffect {
        systemUiController.setStatusBarColor(
            color = colors.background
        )
        systemUiController.setNavigationBarColor(
            color = colors.background
        )
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content,
    )
}

@ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
private fun supportsDynamicTheming() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

// To be used to set the preferred theme inside settings
enum class Theme(
    val themeValue: Int,
) {
    MATERIAL_YOU(
        themeValue = 12,
    ),
    FOLLOW_SYSTEM(
        themeValue = AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM,
    ),
    LIGHT_THEME(
        themeValue = AppCompatDelegate.MODE_NIGHT_NO,
    ),
    DARK_THEME(
        themeValue = AppCompatDelegate.MODE_NIGHT_YES,
    ),
}
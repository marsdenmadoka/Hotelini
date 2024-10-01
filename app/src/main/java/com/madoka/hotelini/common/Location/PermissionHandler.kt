package com.madoka.hotelini.common.Location


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.shouldShowRationale
import com.madoka.hotelini.common.presentation.components.CustomDialog
import com.madoka.hotelini.common.presentation.components.StandardToolbar
import com.madoka.hotelini.common.presentation.theme.HoteliniTheme
import com.madoka.hotelini.common.presentation.theme.poppinsFamily


@ExperimentalPermissionsApi
@Composable
fun HandleRequest(
    permissionState: PermissionState,
    deniedContent: @Composable (Boolean) -> Unit,
    content: @Composable () -> Unit
) {
    when (permissionState.status) {
        is PermissionStatus.Granted -> {
            content()
        }
        is PermissionStatus.Denied -> {
            deniedContent(permissionState.status.shouldShowRationale)
        }
    }
}

@Composable
fun Content(showButton: Boolean = true, onClick: () -> Unit) {
    if (showButton) {
        val enableLocation = remember { mutableStateOf(true) }
        if (enableLocation.value) {
            CustomDialog(
                title = "Turn On Location Service",
                desc = "To accurately find the Hotels near you "+
                  "Hotelini needs to access your location",
                enableLocation,
                onClick
            )
        }
    }
}


@ExperimentalPermissionsApi
@Composable
fun PermissionDeniedContent(
    rationaleMessage: String,
    shouldShowRationale: Boolean,
    onRequestPermission: () -> Unit,
) {

    if (shouldShowRationale) {
        AlertDialog(
            onDismissRequest = {},
            title = {
                Text(
                    text = "Location Permission Request",
                    textAlign = TextAlign.Center,
                    fontFamily = poppinsFamily,
                    fontSize = 18.sp,
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Text(
                    rationaleMessage,
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth(),
                    fontFamily = poppinsFamily,
                    fontSize = 13.sp,
                    color = Color.Black, textAlign = TextAlign.Justify
                )
            },
            confirmButton = {
                Button(
                    onClick = onRequestPermission,
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                        .background(
                            color = Green,
                            shape = RoundedCornerShape(16.dp)
                        ),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                ) {
                    Text(
                        "Give Permission", color = Color.White, fontFamily = poppinsFamily,
                        fontSize = 13.sp,
                    )
                }
            },
        )

    } else {
        Content(onClick = onRequestPermission)
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Preview
@Composable
 fun PermissionDeniedContentPreview() {
    HoteliniTheme {
        PermissionDeniedContent(
          onRequestPermission = { },
            rationaleMessage = "Give Permission",
            shouldShowRationale = true
        )
    }
}
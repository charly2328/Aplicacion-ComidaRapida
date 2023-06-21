package com.app.itsco.comidarapida.presentation.login

import android.graphics.drawable.Icon
import androidx.compose.compiler.plugins.kotlin.ComposeCallableIds.remember
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.app.itsco.comidarapida.R
import com.app.itsco.comidarapida.presentation.login.components.EventDialog
import com.app.itsco.comidarapida.presentation.login.components.RoundedButton
import com.app.itsco.comidarapida.presentation.login.components.TransparentTextField


@Composable
fun LoginScreen(
    state: LoginState,
    onLogin: (String , String) -> Unit,
    onNavigateToRegister: () -> Unit,
    onDismissDialog: () -> Unit
){

    val emailValue = rememberSaveable { mutableStateOf("") }
    val passwordValue = rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember{ mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.Bottom),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ){
            Image(painter = painterResource(
                id = R.drawable.restaurante),
                contentDescription = "imagen inicio",
                contentScale = ContentScale.Inside
            )
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ){
                ConstraintLayout {
                    val (surface, fab) = createRefs()

                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(400.dp)
                            .constrainAs(surface) {
                                bottom.linkTo(parent.bottom)
                            },
                        color = Color.White,
                        shape = RoundedCornerShape(
                            topStartPercent = 8,
                            topEndPercent = 8
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Text(
                                text = "Bienvenido de regreso",
                                fontWeight = FontWeight.Medium
                            )
                            Text(
                                text = "Inicia Sesion",
                                fontWeight = FontWeight.Medium
                            )
                            Column (
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ){
                                TransparentTextField(
                                    textFieldValue = emailValue,
                                    textLabel = "Correo",
                                    keyboardType = KeyboardType.Email,
                                    keyboardActions = KeyboardActions(
                                        onNext = {
                                            focusManager.moveFocus(FocusDirection.Down)
                                        }
                                    ),
                                    imeAction = ImeAction.Next
                                )

                                TransparentTextField(
                                    textFieldValue = passwordValue,
                                    textLabel = "Contraseña",
                                    keyboardType = KeyboardType.Password,
                                    keyboardActions = KeyboardActions(
                                        onDone = {
                                            focusManager.clearFocus()
                                            onLogin(emailValue.value, passwordValue.value)
                                        }
                                    ),
                                    imeAction = ImeAction.Done,
                                    trailingIcon = {
                                        IconButton(
                                            onClick = {
                                                passwordVisibility = !passwordVisibility
                                            }
                                        ) {
                                            androidx.compose.material3.Icon(
                                                imageVector = if (passwordVisibility)
                                                {
                                                    Icons.Default.Visibility
                                                } else{
                                                      Icons.Default.VisibilityOff
                                                      },
                                                contentDescription = "Ocultar contraseña"
                                            )
                                        }
                                    },
                                    visualTransformation = if (passwordVisibility){
                                        VisualTransformation.None
                                    } else {
                                        PasswordVisualTransformation()
                                    }
                                )
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = "Olcvido su contraseña",
                                    textAlign = TextAlign.End
                                )
                            }
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                RoundedButton(
                                    text = "Inicio",
                                    displayProgressBar = state.displayProgressBar,
                                    onClick = {
                                        onLogin(emailValue.value, passwordValue.value)
                                    }
                                )
                                ClickableText(
                                    text = buildAnnotatedString {
                                        append("No tienes cuenta?")
                                        withStyle(
                                            style = SpanStyle(
                                                color = MaterialTheme.colorScheme.primary,
                                                fontWeight = FontWeight.Bold
                                            )
                                        ){
                                            append("Registrarse")
                                        }
                                    }
                                )
                                {
                                    onNavigateToRegister()
                                }
                            }
                        }
                        //espacio reservado para los inputs y botontes
                    }
                    FloatingActionButton(
                        modifier = Modifier
                            .size(72.dp)
                            .constrainAs(fab) {
                                top.linkTo(surface.top, margin = (-36).dp)
                                end.linkTo(surface.end, margin = 36.dp)
                            },
                        contentColor = MaterialTheme.colorScheme.primary,
                        onClick = {
                            onNavigateToRegister()
                        }
                    ) {
                        androidx.compose.material3.Icon(
                            modifier = Modifier.size(72.dp),
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "icono flecha",
                            tint = Color.White
                        )
                    }
                }
            }

            if(state.errorMessage != null){
                EventDialog(
                    errorMessage = state.errorMessage,
                    onDismiss = onDismissDialog
                )
            }
        }
    }
}
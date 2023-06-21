package com.app.itsco.comidarapida.presentation.login.registration

import androidx.compose.compiler.plugins.kotlin.ComposeCallableIds.remember
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.app.itsco.comidarapida.presentation.login.components.EventDialog
import com.app.itsco.comidarapida.presentation.login.components.RoundedButton
import com.app.itsco.comidarapida.presentation.login.components.SocialMediaButton
import com.app.itsco.comidarapida.presentation.login.components.TransparentTextField
import com.app.itsco.comidarapida.ui.theme.FACEBOOKCOLOR
import com.app.itsco.comidarapida.ui.theme.GMAILCOLOR

@Composable
fun RegistrationScreen(
    state: ResgisterScreen,
    onRegister: (String, String, String , String, String) -> Unit,
    onBack: () -> Unit,
    onDismissDialog: () -> Unit
){

    val nameValue = remember{ mutableStateOf("") }
    val emailValue = remember{ mutableStateOf("") }
    val phoneValue = remember{ mutableStateOf("") }
    val passwordValue = remember{ mutableStateOf("") }
    val confirmPasswordValue = remember{ mutableStateOf("") }

    var passwordVisibility by remember{ mutableStateOf(false) }
    var confirnPasswordVisibility by remember{ mutableStateOf(false) }


    val focusManager = LocalFocusManager.current

    Box(
        modifier = Modifier.fillMaxWidth()
    ){

        }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            IconButton(
                onClick = {
                    onBack()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Volver",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
            Text(
                text = "Crea una cuenta",
                color = MaterialTheme.colorScheme.primary
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TransparentTextField(
                textFieldValue = nameValue,
                textLabel = "Nombre",
                keyboardType = KeyboardType.Text,
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                ),
                imeAction = ImeAction.Next
            )


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
                textFieldValue = phoneValue,
                textLabel = "Numero telefonico",
                maxChar = 10,
                keyboardType = KeyboardType.Phone,
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
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                ),
                imeAction = ImeAction.Next,
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

            TransparentTextField(
                textFieldValue = confirmPasswordValue,
                textLabel = "Confirme su contraseña",
                keyboardType = KeyboardType.Password,
                keyboardActions = KeyboardActions(
                    onDone = {
                        focusManager.clearFocus()

                        onRegister(
                            nameValue.value,
                            emailValue.value,
                            phoneValue.value,
                            passwordValue.value,
                            confirmPasswordValue.value
                        )
                    }
                ),
                imeAction = ImeAction.Done,
                trailingIcon = {
                    IconButton(
                        onClick = {
                            confirnPasswordVisibility = !confirnPasswordVisibility
                        }
                    ) {
                        androidx.compose.material3.Icon(
                            imageVector = if (confirnPasswordVisibility)
                            {
                                Icons.Default.Visibility
                            } else{
                                Icons.Default.VisibilityOff
                            },
                            contentDescription = "Ocultar contraseña"
                        )
                    }
                },
                visualTransformation = if (confirnPasswordVisibility){
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                }
            )
            Spacer(modifier = Modifier.height(16.dp))

            RoundedButton(
                text = "Registrarse",
                displayProgressBar = state.displayProgressBar,
                onClick = {
                    onRegister(
                        nameValue.value,
                        emailValue.value,
                        phoneValue.value,
                        passwordValue.value,
                        confirmPasswordValue.value
                    )
                }
            )
            ClickableText(
                text = buildAnnotatedString {
                    append("Ya tiene una cuenta? ")

                    withStyle(
                        style = SpanStyle(
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        )
                    ){
                        append(" Iniciar")
                    }
                },
                onClick = {
                    onBack()
                }
            )
            Spacer(
                modifier = Modifier.height(16.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){
                    Divider(
                        modifier = Modifier.width(24.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )

                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "O",
                        fontWeight = FontWeight.Black
                    )

                    Divider(
                        modifier = Modifier.width(24.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )
                }

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Iniciar con",
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(
                modifier = Modifier.fillMaxWidth(),
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SocialMediaButton(
                    text = "Iniciar con Facebook",
                    onClick = { },
                    socialMediaColor = FACEBOOKCOLOR
                )
                SocialMediaButton(
                    text = "Iniciar con Gmail",
                    onClick = { },
                    socialMediaColor = GMAILCOLOR
                )
            }
        }
        if (
            state.errorMessage != null
        ){
            EventDialog(errorMessage = state.errorMessage, onDismiss = onDismissDialog)
        }
    }
}
package com.app.itsco.comidarapida.presentation.login.registration

import androidx.annotation.StringRes

data class ResgisterScreen(
    val succesRegister: Boolean = false,
    val displayProgressBar: Boolean = false,
    @StringRes val errorMessage: Int? = null
)

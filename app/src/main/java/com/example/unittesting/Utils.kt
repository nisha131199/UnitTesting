package com.example.unittesting

import java.util.regex.Pattern

object Utils {

    private fun emailValidations(email: String): Boolean {
        return Pattern
            .matches(
                "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})\$",
                email
            )
    }

    private fun passwordValidations(password: String): Boolean {
        return Pattern
            .matches(
                "^(?=[^A-Z\\n]*[A-Z])(?=[^a-z\\n]*[a-z])(?=[^0-9\\n]*[0-9])(?=[^#?!@\$%^&*\\n-]*[#?!@\$%^&*-]).{8,}\$",
                password
            )
    }

    fun loginValidations(email: String, password: String): Int {
        if (emailValidations(email) &&
            passwordValidations(password))
            return 1
        else if (!emailValidations(email))
            return -1
        else if (!passwordValidations(password))
            return -2
        return 0
    }
}
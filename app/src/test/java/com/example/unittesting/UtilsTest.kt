package com.example.unittesting

import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertEquals
import org.junit.Test

internal class UtilsTest {

    @Test
    fun loginValidations() {
        assertThat(
            Utils.loginValidations(
                "e@mail.co.in",
                "Password@123"
            )
        )
            .isEqualTo(1)


        assertEquals(5, (2+3))
    }
}
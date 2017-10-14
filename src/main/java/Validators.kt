// Copyright © FunctionalKotlin.com 2017. All rights reserved.

fun validateName(name: String): UserError? = UserError.USERNAME_OUT_OF_BOUNDS
    .takeIf { name.isEmpty() || name.length > 15 }

fun validatePassword(password: String): UserError? = UserError.PASSWORD_TOO_SHORT
    .takeIf { password.length < 10 }
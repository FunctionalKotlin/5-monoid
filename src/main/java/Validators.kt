// Copyright © FunctionalKotlin.com 2017. All rights reserved.

infix operator fun <T, E> ((T) -> E?).plus(validator: (T) -> E?): (T) -> E? = {
    this(it) ?: validator(it)
}

fun validateName(user: User): UserError? = UserError.USERNAME_OUT_OF_BOUNDS
    .takeIf { user.name.isEmpty() || user.name.length > 15 }

fun validatePassword(user: User): UserError? = UserError.PASSWORD_TOO_SHORT
    .takeIf { user.password.length < 10 }
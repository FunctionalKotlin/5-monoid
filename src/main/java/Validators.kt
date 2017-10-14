// Copyright © FunctionalKotlin.com 2017. All rights reserved.

typealias Validator<T, E> = (T) -> Result<T, E>

infix operator fun <T, E> (Validator<T, E>).plus(validator: Validator<T, E>): Validator<T, E> = {
    val result = this(it)

    when(result) {
        is Success -> validator(it)
        is Failure -> result
    }
}

fun validateName(user: User): Result<User, UserError> = user
    .takeIf { !user.name.isEmpty() && user.name.length <= 15 }
    ?.let(::Success)
    ?: Failure(UserError.USERNAME_OUT_OF_BOUNDS)

fun validatePassword(user: User): Result<User, UserError> = user
    .takeIf { user.password.length > 10 }
    ?.let(::Success)
    ?: Failure(UserError.PASSWORD_TOO_SHORT)
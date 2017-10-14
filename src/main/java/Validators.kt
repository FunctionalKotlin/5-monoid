// Copyright © FunctionalKotlin.com 2017. All rights reserved.

typealias Validator<T, E> = (T) -> Result<T, E>

infix operator fun <T, E> (Validator<T, E>).plus(validator: Validator<T, E>): Validator<T, E> = {
    val result = this(it)

    when(result) {
        is Success -> validator(it)
        is Failure -> result
    }
}

fun <A> validate(with: (A) -> Boolean): (A) -> A? = { it.takeIf(with) }

infix fun <A, E> ((A) -> A?).orElseFail(with: E): Validator<A, E> = { a ->
    this(a)?.let(::Success) ?: Failure(with)
}

object Validators {
    val Name: Validator<User, UserError> =
        validate<User> { !it.name.isEmpty() && it.name.length <= 15 }
            .orElseFail(with = UserError.USERNAME_OUT_OF_BOUNDS)

    val Password: Validator<User, UserError> =
        validate<User> { it.password.length > 10 }
            .orElseFail(with = UserError.PASSWORD_TOO_SHORT)
}
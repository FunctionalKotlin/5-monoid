// Copyright © FunctionalKotlin.com 2017. All rights reserved.

data class User(val name: String, val password: String)

enum class UserError {
    PASSWORD_TOO_SHORT, USERNAME_OUT_OF_BOUNDS
}

fun createUser(name: String, password: String): Result<User, UserError> =
    User(name, password).let(::validateName + ::validatePassword)
// Copyright © FunctionalKotlin.com 2017. All rights reserved.

import Validators.Name
import Validators.Password

data class User(val name: String, val password: String)

enum class UserError {
    PASSWORD_TOO_SHORT, USERNAME_OUT_OF_BOUNDS
}

fun createUser(name: String, password: String): Result<User, UserError> =
    User(name, password).let(Name + Password)
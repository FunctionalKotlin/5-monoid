// Copyright © FunctionalKotlin.com 2017. All rights reserved.

fun validateName(name: String) {
    if (name.isEmpty() || name.length > 15) {
        throw UserNameOutOfBoundsException()
    }
}

fun validatePassword(password: String) {
    if (password.length < 10) {
        throw PasswordTooShortException()
    }
}
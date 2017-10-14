// Copyright © FunctionalKotlin.com 2017. All rights reserved.

fun validateName(name: String): Boolean = !name.isEmpty() && name.length <= 15

fun validatePassword(password: String): Boolean = password.length > 10
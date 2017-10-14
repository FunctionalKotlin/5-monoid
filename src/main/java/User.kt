// Copyright © FunctionalKotlin.com 2017. All rights reserved.

data class User(val name: String, val password: String)

class UserDatabase {
    fun create(user: User): User = user
}

class AddUserUseCase {
    private val db = UserDatabase()

    fun add(name: String, password: String): Option<User> = User(name, password)
        .takeIf { validateName(name) && validatePassword(password) }
        ?.let(db::create)
        ?.let(::Just)
        ?: None
}

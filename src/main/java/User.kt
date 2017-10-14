// Copyright © FunctionalKotlin.com 2017. All rights reserved.

data class User(val name: String, val password: String)

class UserDatabase {
    fun create(user: User): User = user
}

class AddUserUseCase {
    private val db = UserDatabase()

    fun add(name: String, password: String): Boolean {
        if (validateName(name) && validatePassword(password)) {
            db.create(User(name, password))

            return true
        }

        return false
    }
}

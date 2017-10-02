// Copyright © FunctionalKotlin.com 2017. All rights reserved.

data class User(val name: String, val password: String)

sealed class UserException: Exception()
class PasswordTooShortException: UserException()
class UserNameOutOfBoundsException: UserException()

class UserDatabase {
    fun create(user: User): User = user
}

class AddUserUseCase {
    private val db = UserDatabase()

    fun add(name: String, password: String): User {
        validateName(name)
        validatePassword(password)

        return db.create(User(name, password))
    }
}

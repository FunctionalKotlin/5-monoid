// Copyright © FunctionalKotlin.com 2017. All rights reserved.

data class User(val name: String, val password: String)

enum class UserError {
    PASSWORD_TOO_SHORT, USERNAME_OUT_OF_BOUNDS
}

class UserDatabase {
    fun create(user: User): User = user
}

class AddUserUseCase {
    private val db = UserDatabase()

    fun add(name: String, password: String): Result<User, UserError> {
        val user = User(name, password)

        val validator = ::validateName + ::validatePassword

        return validator(user).map(db::create)
    }
}

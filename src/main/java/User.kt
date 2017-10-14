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
        val nameFailure = validateName(name)

        if (nameFailure != null) {
            return Failure(nameFailure)
        }

        val passwordFailure = validatePassword(password)

        if (passwordFailure != null) {
            return Failure(passwordFailure)
        }

        return User(name, password)
            .let(db::create)
            .let(::Success)
    }
}

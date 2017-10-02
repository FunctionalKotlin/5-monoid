// Copyright © FunctionalKotlin.com 2017. All rights reserved.

fun main(args: Array<String>) {
    val useCase = AddUserUseCase()

    try {
        val user = useCase.add("alex", "functionalkotlin")

        println(user)
    } catch(exception: UserNameOutOfBoundsException) {
        println("User(name, password)")
    } catch(exception: PasswordTooShortException) {
        println("ERROR: Password too short")
    }
}
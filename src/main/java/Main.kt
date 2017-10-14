// Copyright © FunctionalKotlin.com 2017. All rights reserved.

fun main(args: Array<String>) {
    val useCase = AddUserUseCase()

    if (useCase.add("alex", "functionalkotlin")) {
        println("SUCCESS: User created")
    } else {
        println("ERROR: Something is wrong")
    }
}
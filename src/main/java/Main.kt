// Copyright © FunctionalKotlin.com 2017. All rights reserved.

fun main(args: Array<String>) {
    val useCase = AddUserUseCase()

    useCase.add("alex", "functionalkotlin")
        .map { it.name }
        .ifSuccess { println(it) }
}
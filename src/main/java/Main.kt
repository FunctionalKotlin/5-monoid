// Copyright © FunctionalKotlin.com 2017. All rights reserved.

fun main(args: Array<String>) {
    val useCase = AddUserUseCase()

    val user = useCase.add("alex", "functionalkotlin")

    user?.let(::println)
}
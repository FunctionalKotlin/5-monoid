sealed class Result<out A, out E>

data class Success<out A, out E>(val value: A) : Result<A, E>()

data class Failure<out A, out E>(val error: E) : Result<A, E>()

fun <A, E, B> Result<A, E>.map(transform: (A) -> B): Result<B, E> = when(this) {
    is Success -> Success(transform(value))
    is Failure -> Failure(error)
}

fun <A, E> Result<A, E>.ifSuccess(execute: (A) -> Unit) {
    if (this is Success) execute(this.value)
}
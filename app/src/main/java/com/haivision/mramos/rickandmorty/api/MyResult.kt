package com.haivision.mramos.rickandmorty.api

sealed class MyResult<out T : Any> {
    data class Success<out T : Any>(val data: T) : MyResult<T>()
    data class Failure(val error: Throwable) : MyResult<Nothing>()
    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Failure -> "Failure[error=$error]"
        }
    }
}

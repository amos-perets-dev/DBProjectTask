package com.example.dbprojecttask.data

sealed class Result {
    data class Success(val data : ImagesListData) : Result()
    data class Failure(val exception : Int) : Result()
}

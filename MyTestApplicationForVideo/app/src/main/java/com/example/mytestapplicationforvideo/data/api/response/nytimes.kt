package com.example.mytestapplicationforvideo.data.api.response

data class nytimes(
    val copyright: String,
    val has_more: Boolean,
    val num_results: Int,
    val results: List<Result>,
    val status: String
)
package com.harnet.codecommunity.model

data class User(
    val uid: String? = "",
    val name: String? = "",
    val country: String? = "",
    val email: String? = "",
    val profileImgUrl: String? = "",
    val techStack: ArrayList<String>? = arrayListOf()
)
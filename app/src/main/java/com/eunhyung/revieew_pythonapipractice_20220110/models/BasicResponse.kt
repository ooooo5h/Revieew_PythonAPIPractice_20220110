package com.eunhyung.revieew_pythonapipractice_20220110.models

class BasicResponse(
    val code : Int,
    val message : String,
    val data : DataResponse,
) {
}
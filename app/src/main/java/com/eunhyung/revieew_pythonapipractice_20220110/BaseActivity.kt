package com.eunhyung.revieew_pythonapipractice_20220110

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.eunhyung.review_apipractice_20220108.api.APIList
import com.eunhyung.review_apipractice_20220108.api.ServerAPI
import retrofit2.Retrofit

abstract class BaseActivity : AppCompatActivity() {

    lateinit var retrofit: Retrofit
    lateinit var apiList: APIList

    lateinit var mContext : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//       이 내부의 코드는 모든 화면들의 시작지점에서 공통적으로 실행되는 코드

//        this를 미리 mContext에 담아두자
        mContext = this

//        레트로핏 관련 설정들을 여기서 진행함(모든 화면들이 자동 실행)

        retrofit = ServerAPI.getRetrofit(mContext)
        apiList = retrofit.create(APIList::class.java)

    }
}
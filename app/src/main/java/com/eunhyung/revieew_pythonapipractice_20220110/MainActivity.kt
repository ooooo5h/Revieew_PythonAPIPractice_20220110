package com.eunhyung.revieew_pythonapipractice_20220110

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.eunhyung.revieew_pythonapipractice_20220110.models.BasicResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener {

            val inputId = edtEmail.text.toString()
            val inputPw = edtPassword.text.toString()

            apiList.getRequestLogin(inputId, inputPw).enqueue(object : Callback<BasicResponse>{
                override fun onResponse(
                    call: Call<BasicResponse>,
                    response: Response<BasicResponse>
                ) {

                    if (response.isSuccessful) {

                        val br = response.body()!!
                        val login_nickname = br.data.user.nickname

                        Toast.makeText(mContext, "${login_nickname}님 로그인 성공", Toast.LENGTH_SHORT).show()
                    }

                }

                override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

                }


            })

        }
    }
}
package br.com.okayamafilho.tcomposeimgurapi.model.api

import AuthInterceptor
import br.com.okayamafilho.tapiimgur.api.ImgurApi
import br.com.okayamafilho.tapiimgur.api.model.Resultado
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ImgurWebService {
    private var api: ImgurApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.imgur.com/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(AuthInterceptor())
                    .build()
            )
            .build()

        api = retrofit.create(ImgurApi::class.java)
    }

    suspend fun getMeals(): Response<Resultado> {
        return api.pesquisarImagemGalera("cats")
    }
}
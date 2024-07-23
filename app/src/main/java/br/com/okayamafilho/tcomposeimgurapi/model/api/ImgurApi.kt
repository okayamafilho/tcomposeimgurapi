package br.com.okayamafilho.tapiimgur.api

import br.com.okayamafilho.tapiimgur.api.model.Resultado
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ImgurApi {

    @GET("gallery/search/")//?q=cats
    suspend fun pesquisarImagemGalera(
        @Query("q") q : String
    ) : Response<Resultado>
}
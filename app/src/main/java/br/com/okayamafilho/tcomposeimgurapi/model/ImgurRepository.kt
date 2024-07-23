package br.com.okayamafilho.tcomposeimgurapi.model

import android.util.Log
import br.com.okayamafilho.tapiimgur.api.model.Resultado
import br.com.okayamafilho.tcomposeimgurapi.model.api.ImgurWebService
import br.com.okayamafilho.tcomposeimgurapi.model.response.ImgurResponse
import retrofit2.Response

class ImgurRepository(private val webService: ImgurWebService = ImgurWebService()) {

    var response: Response<Resultado>? = null

    suspend fun getMeals(): Response<Resultado> {
        response = webService.getMeals()
        return response as Response<Resultado>
    }

    companion object {
        @Volatile
        private var instance: ImgurRepository? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: ImgurRepository().also { instance = it }
        }
    }
}
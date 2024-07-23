package br.com.okayamafilho.tcomposemealsapp.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.okayamafilho.tapiimgur.api.model.Resultado
import br.com.okayamafilho.tcomposeimgurapi.model.ImgurRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class ImgurViewModel(private val repository: ImgurRepository = ImgurRepository.getInstance()) :
    ViewModel() {

    val resultadoState:  MutableState<List<String>> = mutableStateOf(emptyList())
    val listaUrlImagens = mutableListOf<String>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val resultado = getMeals().body()
            val lista = resultado!!.data
            lista.forEach { dados ->
                val imagem = dados.images[0]
                val tipo = imagem.type
                if (tipo == "image/jpeg") {
                    listaUrlImagens.add(imagem.link)
                }
            }
            resultadoState.value = listaUrlImagens
        }
    }

    private suspend fun getMeals(): Response<Resultado> {
        return repository.getMeals()
    }
}
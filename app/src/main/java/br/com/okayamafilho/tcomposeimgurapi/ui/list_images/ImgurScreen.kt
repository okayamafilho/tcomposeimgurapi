package br.com.okayamafilho.tcomposemealsapp.ui.meals

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage

@Composable
fun ImgurScreen() {
    val viewModel: ImgurViewModel = viewModel()
    val resultado = viewModel.resultadoState.value

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(resultado) { imagem ->
            MealCategory(imagem)
        }
    }
}

@Composable
fun MealCategory(imagem: String) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .aspectRatio(1f)
            .clip(
                RoundedCornerShape(5.dp)
            )
    ) {
        //Image
        AsyncImage(
            model = imagem,
            contentDescription = "",
            modifier = Modifier
                .size(100.dp)
                .padding(4.dp),
            contentScale = ContentScale.Crop,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ImgurScreenPreview() {
    ImgurScreen()
}

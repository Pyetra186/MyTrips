package br.senai.sp.jandira.mytrips.repository

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.model.Categorias

class CategoriasRepository {

    @Composable
    fun listarTodasCategorias(current: Context): List<Categorias>{

        val  Montain = Categorias()
        Montain.id
        Montain.nome = "Montain"
        Montain.img = painterResource(R.drawable.montanha)

        val Snow = Categorias()
        Snow.id
        Snow.nome = "Snow"
        Snow.img = painterResource(R.drawable.snow)

        val Beach = Categorias()
        Beach.id
        Beach.nome = "Beach"
        Beach.img = painterResource(R.drawable.praia)



        val categorias = listOf(
            Montain,
            Snow,
            Beach
        )

        return categorias
    }
}
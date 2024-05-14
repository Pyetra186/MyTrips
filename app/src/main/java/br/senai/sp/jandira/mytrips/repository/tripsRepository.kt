package br.senai.sp.jandira.mytrips.repository

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.model.Categorias
import br.senai.sp.jandira.mytrips.model.Viagem
import java.time.LocalDate

class tripsRepository {

    @Composable
    fun listarTodasAsViagens(current: Context): List<Viagem>{

        val viagemLondres = Viagem()
        viagemLondres.id
        viagemLondres.destino = "Londres"
        viagemLondres.descricao = "London is the capital and largest city of  the United Kingdom, with a population of just under 9 million."
        viagemLondres.data_chagada = LocalDate.of(2023, 7, 18)
        viagemLondres.data_partida = LocalDate.of(2023, 7,28)
        viagemLondres.imagem = painterResource(R.drawable.londres)

        val viagemPorto = Viagem()
        viagemPorto.id
        viagemPorto.destino = "Porto"
        viagemPorto.descricao = "Porto is the second city in Portugal, the capital of the Oporto District, and one of the Iberian Peninsula's."
        viagemPorto.data_chagada = LocalDate.of(2023, 7, 18)
        viagemPorto.data_partida = LocalDate.of(2023, 7,28)
        viagemPorto.imagem = painterResource(R.drawable.porto)

        val viagemNewYork = Viagem()
        viagemNewYork.id
        viagemNewYork.destino = "New York"
        viagemNewYork.descricao = "Porto is the second city in Portugal, the capital of the Oporto District, and one of the Iberian Peninsula's."
        viagemNewYork.data_chagada = LocalDate.of(2023, 7, 18)
        viagemNewYork.data_partida = LocalDate.of(2023, 7,28)
        viagemNewYork.imagem = painterResource(R.drawable.newyork)




        val  viagens = listOf(
            viagemLondres,
            viagemPorto,
            viagemNewYork
        )
        return viagens
    }


}
package br.senai.sp.jandira.mytrips.model

import androidx.compose.ui.graphics.painter.Painter
import java.time.LocalDate

data class Viagem(
    var id: Int = 0,
    var destino: String = "",
    var data_chagada: LocalDate = LocalDate.now(),
    var data_partida: LocalDate = LocalDate.now(),
    var descricao: String = "",
    var imagem: Painter? = null
)

data class Categories(
    var  id: Int = 0,
    var nome: String = " ",
    var img: Painter? = null
)

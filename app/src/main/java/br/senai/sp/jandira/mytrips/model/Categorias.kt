package br.senai.sp.jandira.mytrips.model

import androidx.compose.ui.graphics.painter.Painter

    data class Categorias(
        var  id: Int = 0,
        var nome: String = " ",
        var img: Painter? = null
    )

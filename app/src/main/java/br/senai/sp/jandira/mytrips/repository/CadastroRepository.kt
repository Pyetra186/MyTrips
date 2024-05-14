package br.senai.sp.jandira.mytrips.repository

import android.content.Context
import br.senai.sp.jandira.mytrips.dao.cadastroDb
import br.senai.sp.jandira.mytrips.model.cadastro

class CadastroRepository(context: Context) {

    private val db = cadastroDb.getBancoDados(context).cadastroDao()

    fun salvar(cadastro: cadastro): Long {
        return db.salvar(cadastro)
    }

    fun login(email: String, senha: String): cadastro {
        return db.login(email, senha)
    }


}
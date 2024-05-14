package br.senai.sp.jandira.mytrips.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.senai.sp.jandira.mytrips.model.cadastro


@Dao
interface cadastroDao {

    @Insert
    fun salvar(cadastro: cadastro): Long

    @Query("SELECT * FROM tbl_cadastro WHERE email = :email AND senha = :senha")
    fun login(
        email: String,
        senha: String
    ): cadastro


}

package br.senai.sp.jandira.mytrips.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.mytrips.model.cadastro


@Database (entities = [cadastro::class], version = 1)
abstract class cadastroDb : RoomDatabase(){
    abstract fun cadastroDao(): cadastroDao

    companion object{
        private lateinit var instancia: cadastroDb

        fun getBancoDados(context: Context): cadastroDb{
            instancia = Room
                .databaseBuilder(
                    context,
                    cadastroDb::class.java,
                    "db_cadastro"
                )

                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()

            return instancia
        }
    }
}




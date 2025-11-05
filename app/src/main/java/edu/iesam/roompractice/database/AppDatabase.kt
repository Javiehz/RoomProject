package edu.iesam.roompractice.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.iesam.roompractice.daos.StudentDao
import edu.iesam.roompractice.entities.Student

@Database(entities = [Student::class], version=1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun studentDao(): StudentDao

    //COMPANION OBJECT ES COMO EN JAVA UN PUBLIC STATIC ( UNA VARIABLE GLOBAL )
    companion object{
        @Volatile //PARA QUE SE HAGA LA LLAMADA AL COMPLETO Y NO SE QUEDE A MEDIAS.
        private var INSTANCE: AppDatabase? = null

        //CREAR BASE DE DATOS O USARLA
        fun getInstance(context: Context): AppDatabase{
            //COMPRUEBA SI LA INSTANCIA ES NULA (si no lo es entonces ya existe la instancia).
            //Y SI NO EXISTE LA CREA, CON SYNCHRONIZED SE HACE QUE SOLO PUEDA EJECUTARLA 1 A LA VEZ
            //ENTONCES SI LA EJECUTA UNO PARA EL OTRO QUE LA EJECUTE YA VA A ESTAR CREADA.
            return INSTANCE ?: synchronized(this)  {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "students_db" //NOMBRE DE LA BASE DE DATOS A CREAR/CREADA
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
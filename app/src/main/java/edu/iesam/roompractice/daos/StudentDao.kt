package edu.iesam.roompractice.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import edu.iesam.roompractice.entities.Student

@Dao
interface StudentDao {

    @Insert
    suspend fun insert(student: Student)

    @Query("SELECT * FROM student")
    suspend fun getAll(): List<Student>

    @Query("SELECT * FROM student WHERE id=:id")
    suspend fun getById(id: Int)

    @Update
    suspend fun update(student: Student)

    @Delete
    suspend fun delete(student: Student)


}
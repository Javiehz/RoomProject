package edu.iesam.roompractice.database

import edu.iesam.roompractice.daos.StudentDao
import edu.iesam.roompractice.entities.Student

class StudentRepository(dao: StudentDao) {
    val studentDao = dao

    suspend fun insert(student: Student){
        studentDao.insert(student)
    }

    suspend fun delete(student: Student){
        studentDao.delete(student)
    }

    suspend fun update(student: Student){
        studentDao.update(student)
    }

    suspend fun getAll():List<Student>{
        return studentDao.getAll()
    }

    suspend fun getById(id: Int):Student{
        return studentDao.getById(id)
    }
}
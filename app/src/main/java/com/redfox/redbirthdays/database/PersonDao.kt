package com.redfox.redbirthdays.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonDao {
    @Query("SELECT * FROM person")
    fun getAll(): List<Person>

    @Query("SELECT * FROM person WHERE uid IN (:personIds)")
    fun getAllByIds(personIds: IntArray): List<Person>

    @Query("SELECT * FROM person WHERE first_name LIKE :first AND " +
    "last_name LIKE :last LIMIT 1")
    fun getByName(first: String, last: String): Person

    @Insert
    fun insertAll(vararg persons: Person)

    @Delete
    fun delete(person: Person)
}
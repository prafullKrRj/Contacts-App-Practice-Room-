package com.example.contactsapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao    // DAO stands for Data Access Object

interface ContactDao {

    @Upsert     // Upsert is a combination of insert and update
    suspend fun upsertContact(contact: Contact)

    @Delete     // Delete is a function that deletes a contact
    suspend fun deleteContact(contact: Contact)


    @Query("SELECT * FROM contacts ORDER BY firstName ASC")
    fun getContactsOrderedByFirstName(): Flow<List<Contact>>


    @Query("SELECT * FROM contacts ORDER BY lastName ASC")
    fun getContactsOrderedByLastName(): Flow<List<Contact>>

    @Query("SELECT * FROM contacts ORDER BY phoneNumber ASC")
    fun getContactsOrderedByPhoneNumber(): Flow<List<Contact>>


}
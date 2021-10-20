package com.vmh.cleararchitects.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vmh.cleararchitects.data.models.Search

@Database(entities = [Search::class], version = 1, exportSchema = false)
abstract class Database: RoomDatabase() {
    abstract fun photoDao(): DAO
}

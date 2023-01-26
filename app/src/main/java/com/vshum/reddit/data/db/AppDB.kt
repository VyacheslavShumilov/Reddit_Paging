package com.vshum.reddit.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vshum.reddit.data.db.dao.ResponseDataDao
import com.vshum.reddit.data.entities.PostData

@Database(
    entities = [
        PostData::class
    ],
    version = DBConstants.VERSION,
    exportSchema = true
)
abstract class AppDB : RoomDatabase() {
    abstract fun responseDataDao(): ResponseDataDao
}
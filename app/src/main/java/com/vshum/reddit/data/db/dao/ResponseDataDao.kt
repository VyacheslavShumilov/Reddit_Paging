package com.vshum.reddit.data.db.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vshum.reddit.data.db.DBConstants
import com.vshum.reddit.entities.PostData

/** Работа с локальной базой */
@Dao
interface ResponseDataDao {
    /**
     * Сохранить посты.
     * @param posts список постов для сохранения.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(posts: List<PostData>): List<Long>

    /**
     * Получить список постов, которые были до определенной даты.
     * @return список из постов, отсортированный по дате.
     */
    @Query("select * " +
            "from ${DBConstants.TABLE_CACHE} ")
    fun getPostsBeforeDate(): PagingSource<Int, PostData>

    /** Удалить все записи из базы */
    @Query("delete " +
            "from ${DBConstants.TABLE_CACHE} ")
    fun deleteAll(): Int
}
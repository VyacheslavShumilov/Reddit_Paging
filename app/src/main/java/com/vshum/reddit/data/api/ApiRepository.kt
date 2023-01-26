package com.vshum.reddit.data.api

import com.vshum.reddit.entities.PostData

/** Интерфейс работы с API */
interface ApiRepository {

    /**
     * Загрузить список постов.
     * @param after уникальный id поста, после которого нужно получить новый список постов.
     * @param before уникальный id поста, до которого нужно получить новый список постов.
     * @return список постов [PostData] или null, если нет постов
     */
    suspend fun getPosts(after: String? = null, before: String? = null): List<PostData>
}
package id.nihongodictionary.app.core.database.user

import androidx.room.Database
import androidx.room.RoomDatabase
import id.nihongodictionary.app.core.database.user.dao.BookmarkDao
import id.nihongodictionary.app.core.database.user.dao.CollectionDao
import id.nihongodictionary.app.core.database.user.dao.SearchHistoryDao
import id.nihongodictionary.app.core.database.user.entity.BookmarkEntity
import id.nihongodictionary.app.core.database.user.entity.CollectionEntity
import id.nihongodictionary.app.core.database.user.entity.CollectionWordCrossRef
import id.nihongodictionary.app.core.database.user.entity.SearchHistoryEntity

@Database(
    entities = [
        BookmarkEntity::class,
        SearchHistoryEntity::class,
        CollectionEntity::class,
        CollectionWordCrossRef::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppUserDatabase : RoomDatabase() {
    abstract fun bookmarkDao(): BookmarkDao
    abstract fun searchHistoryDao(): SearchHistoryDao
    abstract fun collectionDao(): CollectionDao
}

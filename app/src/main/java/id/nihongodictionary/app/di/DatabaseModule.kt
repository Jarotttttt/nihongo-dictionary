package id.nihongodictionary.app.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.nihongodictionary.app.core.database.user.AppUserDatabase
import id.nihongodictionary.app.core.database.user.dao.BookmarkDao
import id.nihongodictionary.app.core.database.user.dao.CollectionDao
import id.nihongodictionary.app.core.database.user.dao.SearchHistoryDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppUserDatabase(
        @ApplicationContext context: Context
    ): AppUserDatabase {
        return Room.databaseBuilder(
            context,
            AppUserDatabase::class.java,
            "nihongo_user_data.db"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideBookmarkDao(database: AppUserDatabase): BookmarkDao {
        return database.bookmarkDao()
    }

    @Provides
    fun provideSearchHistoryDao(database: AppUserDatabase): SearchHistoryDao {
        return database.searchHistoryDao()
    }

    @Provides
    fun provideCollectionDao(database: AppUserDatabase): CollectionDao {
        return database.collectionDao()
    }
}

package id.nihongodictionary.app.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.nihongodictionary.app.data.repository.DictionaryRepositoryImpl
import id.nihongodictionary.app.data.repository.KanjiRepositoryImpl
import id.nihongodictionary.app.data.repository.UserDataRepositoryImpl
import id.nihongodictionary.app.domain.repository.DictionaryRepository
import id.nihongodictionary.app.domain.repository.KanjiRepository
import id.nihongodictionary.app.domain.repository.UserDataRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindDictionaryRepository(
        impl: DictionaryRepositoryImpl
    ): DictionaryRepository

    @Binds
    @Singleton
    abstract fun bindKanjiRepository(
        impl: KanjiRepositoryImpl
    ): KanjiRepository

    @Binds
    @Singleton
    abstract fun bindUserDataRepository(
        impl: UserDataRepositoryImpl
    ): UserDataRepository
}

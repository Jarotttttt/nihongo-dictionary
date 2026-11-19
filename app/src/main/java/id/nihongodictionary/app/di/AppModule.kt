package id.nihongodictionary.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.nihongodictionary.app.core.common.DispatcherProvider
import id.nihongodictionary.app.core.common.StandardDispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDispatcherProvider(): DispatcherProvider {
        return StandardDispatchers()
    }
}

package bk.personal.com.bored.di

import bk.personal.com.bored.network.IBoredService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideBoredService(retrofit: Retrofit): IBoredService{
        return retrofit.create(IBoredService::class.java)
    }

}
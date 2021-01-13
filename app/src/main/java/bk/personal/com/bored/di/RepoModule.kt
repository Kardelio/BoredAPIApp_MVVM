package bk.personal.com.bored.di

import bk.personal.com.bored.repository.BoredRepository
import bk.personal.com.bored.repository.IBoredRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
interface RepoModule {

    @Binds
    fun bindBoredRepo(repo: BoredRepository): IBoredRepo

}
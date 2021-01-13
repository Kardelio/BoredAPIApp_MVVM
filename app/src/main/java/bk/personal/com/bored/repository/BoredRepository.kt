package bk.personal.com.bored.repository

import bk.personal.com.bored.model.BoredItem
import bk.personal.com.bored.network.IBoredService
import javax.inject.Inject

interface IBoredRepo{
    suspend fun getRandomBoredItem(): BoredItem
}

class BoredRepository @Inject constructor(
    private val service: IBoredService
): IBoredRepo{
    override suspend fun getRandomBoredItem(): BoredItem {
        return service.getBoredActivity()
    }
}
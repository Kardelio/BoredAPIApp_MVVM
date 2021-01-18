package bk.personal.com.bored.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bk.personal.com.bored.model.BoredItem
import bk.personal.com.bored.repository.IBoredRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    val repo: IBoredRepo
) : ViewModel() {

    val currentItem = MutableLiveData<BoredItem>()

    val boredItems = MutableLiveData<List<BoredItem>>()

    fun getBoredItem() {
        viewModelScope.launch {
            val a = repo.getRandomBoredItem()
            currentItem.postValue(a)

            val b = repo.getMultipleBoredItems()
            boredItems.postValue(b)
        }
    }


    private val listOfActivities = mutableListOf<BoredItem>()
    private val _boredItemsFlow = MutableStateFlow(listOfActivities.toList())
    val boredItemsFlow = _boredItemsFlow.asStateFlow()

   fun getData(i: Int) = viewModelScope.launch {
       _boredItemsFlow.emitAll(repo.getXActivities(i).map {
           listOfActivities.add(it)
           listOfActivities.toList()
       })
   }
}
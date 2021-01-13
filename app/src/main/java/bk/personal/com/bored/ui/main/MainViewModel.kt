package bk.personal.com.bored.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bk.personal.com.bored.model.BoredItem
import bk.personal.com.bored.repository.IBoredRepo
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    val repo: IBoredRepo
) : ViewModel() {

    val currentItem = MutableLiveData<BoredItem>()

    fun getBoredItem(){
        viewModelScope.launch {
            val a = repo.getRandomBoredItem()
            currentItem.postValue(a)
        }
    }
}
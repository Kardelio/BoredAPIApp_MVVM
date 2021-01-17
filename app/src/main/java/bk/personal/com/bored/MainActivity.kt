package bk.personal.com.bored

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import bk.personal.com.bored.ui.main.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }

//        BarcodeDetector
//        CameraSource
    }
}


/*
//REPO
var t: Int = -1
fun getInts(amount: Int) = flow {
    for (i in 0..amount) {
        delay(500)
        emit(t++)
    }
}

//VM
private val list = mutableListOf<Int>()
private val _vmFlow: MutableStateFlow<List<Int>> = MutableStateFlow(list.toList())
val vmFlow = _vmFlow.asStateFlow()
fun getData(i : Int) = viewModelScope.launch {
    _vmFlow.emitAll(getInts(i).filter {
        (it > 0) && (it < 31)
    }.map {
        list.add(it)
        list.toList()
    })
}


//V
viewModel.getData(amount)
lifecycleScope.launchWhenStarted {
    viewModel.vmFlow.collect {
        Log.d("BEN", it.toString())
    }
}
*/

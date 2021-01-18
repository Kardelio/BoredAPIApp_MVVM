package bk.personal.com.bored.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import bk.personal.com.bored.R
import bk.personal.com.bored.ui.TinderAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    //    private lateinit var viewModel: MainViewModel
    private val viewModel: MainViewModel by viewModels()
    private lateinit var viewPager: ViewPager2
    private lateinit var tinderAdapter: TinderAdapter

//    private lateinit var adapter: Adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager = view.findViewById(R.id.pager)
        tinderAdapter = TinderAdapter()
//        viewPager.setPageTransformer(CustomPageTrans())
        viewPager.offscreenPageLimit = 10
        viewPager.adapter = tinderAdapter

//        view.findViewById<Button>(R.id.mybutt).setOnClickListener {
//            viewModel.getBoredItem()
//        }

        viewModel.getData(10)
        lifecycleScope.launchWhenStarted {
            viewModel.boredItemsFlow.collect {
                it.forEach { ac ->
                    Log.d("BK", ac.activity)
                }
                tinderAdapter.setAllData(it)
            }
        }
    }

   inner class CustomPageTrans: ViewPager2.PageTransformer{
       override fun transformPage(page: View, position: Float) {
            if(position >= 0){
                page.scaleX = 0.8f - (0.02f * position)
                page.scaleY = 0.8f
                page.translationX = - page.width * position
                page.translationY = - (20 * position)
            }
       }
   }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        // TODO: Use the ViewModel
//
//    }

}
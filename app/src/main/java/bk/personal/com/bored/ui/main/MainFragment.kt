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
import bk.personal.com.bored.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

//    private lateinit var viewModel: MainViewModel
    private val viewModel: MainViewModel by viewModels()
    private lateinit var tv: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv = view.findViewById(R.id.message)
        view.findViewById<Button>(R.id.mybutt).setOnClickListener {
            viewModel.getBoredItem()
        }

        viewModel.currentItem.observe(viewLifecycleOwner, Observer {
            Log.d("BK",it.activity)
            tv.text = it.activity
        })
        viewModel.boredItems.observe(viewLifecycleOwner, Observer {
            for(i in it){
                Log.d("BK","${i.activity}")
            }
        })
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        // TODO: Use the ViewModel
//
//    }

}
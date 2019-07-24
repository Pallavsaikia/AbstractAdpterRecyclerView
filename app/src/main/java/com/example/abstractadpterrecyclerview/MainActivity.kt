package com.example.abstractadpterrecyclerview
/*
    created by-
    Pallav Saikia
 */
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.abstractrecyclerviewlib.AbstractAdapterRecycleView
import com.example.abstractrecyclerviewlib.AbstractAdapterRecycleViewInterface
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recycler_view_adapter.view.*


class MainActivity : AppCompatActivity() , AbstractAdapterRecycleViewInterface {


    //interface to assign data to views
    override fun assignUI(view: View, data: Any) {
        val stringSet=data as DataExample
        view.txtSet.text=stringSet.text

        //to set clickListener
        view.setOnClickListener {
            Toast.makeText(this,stringSet.text,Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //getting recycle view ready
        val layoutManagerV = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = layoutManagerV
        recyclerView.setHasFixedSize(true)

        //data
        val dataStr= listOf(DataExample(1,"abc"),DataExample(2,"def"),DataExample(3,"ghi"))

        //adapter
        val adapter= AbstractAdapterRecycleView(
            this,
            dataStr.toMutableList(),
            R.layout.recycler_view_adapter,
            this
        )
        recyclerView.adapter=adapter
    }
}

data class DataExample(val id:Int,val text:String)



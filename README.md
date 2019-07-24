# AbstractAdpterRecyclerView


```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
 
 ```
  dependencies {
	        implementation 'com.github.Pallavsaikia:AbstractAdpterRecyclerView:v1.0.0'
	}
  ```
  
  
  Usage
  
  1. Extend the AbstractAdapterRecycleViewInterface interface in the class to use it
  
   ```
  class MainActivity : AppCompatActivity() , AbstractAdapterRecycleViewInterface { }
   ```
   
  2.Initialize recyclerview
  ```
  val layoutManagerV = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = layoutManagerV
        recyclerView.setHasFixedSize(true)
  ```
  3.Initialize adapter with AbstractAdapterRecycleView with your data and layout of your choice
  ```
  //data class
  data class DataExample(val id:Int,val text:String)
  
  
  
  val dataList = listOf<DataExample>() //list of any type of your choice 
  val adapter= AbstractAdapterRecycleView(
            this,//context
            dataList.toMutableList(),
            R.layout.recycler_view_adapter,//layout
            this//abstractAdapterRecycleViewInterface
        )
  ```
  
  4.Override the Interface In the class extending AbstractAdapterRecycleViewInterface
  ```
  //interface to assign data to views
    override fun assignUI(view: View, data: Any) {
        val stringSet=data as DataExample
        view.txtSet.text=stringSet.text

        //to set clickListener
        view.setOnClickListener {
            Toast.makeText(this,stringSet.text,Toast.LENGTH_SHORT).show()
        }
    }
  ```

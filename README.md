# AbstractAdpterRecyclerView


```groovy
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
 
 ```groovy
  dependencies {
	        implementation 'com.github.Pallavsaikia:AbstractAdpterRecyclerView:$tag'
	}
  ```
  [![](https://jitpack.io/v/Pallavsaikia/AbstractAdpterRecyclerView.svg)](https://jitpack.io/#Pallavsaikia/AbstractAdpterRecyclerView)


  
  Usage
  
  1. Extend the AbstractAdapterRecycleViewInterface interface in the class to use it
  
   ```kotlin
  class MainActivity : AppCompatActivity() , AbstractAdapterRecycleViewInterface { }
   ```
   
  2.Initialize recyclerview
  ```kotlin
  val layoutManagerV = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = layoutManagerV
        recyclerView.setHasFixedSize(true)
  ```
  3.Initialize adapter with AbstractAdapterRecycleView with your data and layout of your choice
  ```kotlin
  //data class
  data class DataExample(val id:Int,val text:String)
  
  
  
  val dataList = listOf<DataExample>() //list of any type of your choice 
  val adapter = AbstractAdapterRecycleView(
            dataStr.toMutableList(),
            R.layout.recycler_view_adapter,
            this
        )
  ```
  
  4.Override the Interface In the class extending AbstractAdapterRecycleViewInterface
  ```kotlin
  //interface to assign data to views
    override fun assignUI(view: View, data: Any) {
    
    //cast the data into your data type
        val stringSet=data as DataExample
        view.txtSet.text=stringSet.text
	
	//impletentation of recyclver view adapter onBindViewHolder()
	//assign make changes to layout here
	
	
        //to set clickListener
        view.setOnClickListener {
            Toast.makeText(this,stringSet.text,Toast.LENGTH_SHORT).show()
        }
    }
  ```
  
  
  
  You can also use it without using an interface by using a lambda
  ```kotlin
  val adapter = AbstractAdapterRecycleView(
            dataStr.toMutableList(),
            R.layout.recycler_view_adapter
        ) { view, data ->

            val stringSet = data as DataExample
            view.txtSet.text = stringSet.text

            view.setOnClickListener {
                Toast.makeText(this, stringSet.text, Toast.LENGTH_SHORT).show()
            }
        }
  ```
  
  ## License & Copyright
 
  Licensed under the [MIT License](LICENSE).

package com.example.footballapi.view.asyncBubbleSort

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.footballapi.R
import com.example.footballapi.presenter.AsyncTask.AsyncBubbleSortPresenter
import com.example.footballapi.presenter.AsyncTask.AsyncView
import kotlinx.android.synthetic.main.activity_async_bubble_sort.*

class AsyncBubbleSortActivity : AppCompatActivity(), AsyncView{
    override fun startProgBar(a: Boolean) {
        if (a == true){

            pb_async_bubble_sort.visibility = View.VISIBLE
            Thread.sleep(3000)
        }else if (a == false){
            pb_async_bubble_sort.visibility = View.GONE
        }
    }

    override fun showAsyncView(a: String) {
        var iid = a
        tv_async_result.text = iid
    }

    override fun getInfo(): Array<String> {

        var input = et_enter_numbers.text.split(",").toTypedArray()
        return input
    }

    override fun showLoading() {

    }

    var presenter = AsyncBubbleSortPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_bubble_sort)



        btn_run_sort.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {

                if (et_enter_numbers.text.isNullOrEmpty()){
                    tv_async_result.text = "please enter values"
                }
                else{

                    presenter.onViewAttached(this@AsyncBubbleSortActivity)
                }

            }

        })

    }

}

package com.example.footballapi.presenter.AsyncTask

import android.os.AsyncTask
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import com.example.footballapi.R
import com.example.footballapi.presenter.BasePresenter
import kotlinx.android.synthetic.main.activity_async_bubble_sort.view.*


class AsyncBubbleSortPresenter: BasePresenter<AsyncView>(){

    override fun onViewAttached(view: AsyncView) {
        super.onViewAttached(view)


        AsyncBubbleSort().execute()

    }

    inner class AsyncBubbleSort: AsyncTask<Array<String>, Int, String>(){
        override fun onPreExecute() {
            view!!.startProgBar(true)
            super.onPreExecute()
        }

        override fun doInBackground(vararg p0: Array<String>?): String {


            //view!!.startProgBar(true)
            //Thread.sleep(3000)

            Log.d("the value of execute", p0.toString())

            var arra: Array<String> = view!!.getInfo()

            val arrayList = ArrayList<Int>()

            for (i in arra){

                Log.d("R VALUE", i)
                arrayList.add(i.toInt())

            }

            Log.d("this is the outpt", arrayList.sorted().toString())
            var res = arrayList.sorted().toString()

            return res
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)

        }

        override fun onPostExecute(result: String) {
            super.onPostExecute(result)
            //view!!.startProgBar(false)
            view!!.showAsyncView(result)

        }

    }

}

interface AsyncView: BasePresenter.View{
    fun showLoading()
    fun showAsyncView(a: String)
    fun getInfo(): Array<String>
    fun startProgBar(a: Boolean)
}


package com.example.footballapi.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import com.squareup.picasso.Picasso
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

fun ViewGroup.inflatee(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View{

    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)

}

fun ImageView.imagine(url: String): Unit{
    return Picasso.get().load(url).into(this)
}


fun<T> Call<T>.enqueue(callback: CallBackKt<T>.() -> Unit) {
    val callBackKt = CallBackKt<T>()
    callback.invoke(callBackKt)
    this.enqueue(callBackKt)
}


class CallBackKt<T>: Callback<T> {
    var onResponse: ((Response<T>) -> Unit)? = null
    var onFailure: ((t: Throwable?) -> Unit)? = null
    override fun onFailure(call: Call<T>, t: Throwable) {
        onFailure?.invoke(t)
    }
    override fun onResponse(call: Call<T>, response: Response<T>) {
        onResponse?.invoke(response)
    }
}

//fun OkHttpClient.crunch(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient{
//    return OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
//    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//}

fun Retrofit.Builder.crunch(baseURL: String): Retrofit {
    val loggingInterceptor = HttpLoggingInterceptor()
    val okHttpClient = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    var reg = Retrofit.Builder()
        .baseUrl(baseURL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    return reg
}
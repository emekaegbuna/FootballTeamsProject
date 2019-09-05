package com.example.footballapi.presenter.footballTeams

import android.util.Log
import com.example.footballapi.common.Constants
import com.example.footballapi.common.enqueue
import com.example.footballapi.model.footballTeams.FootballTeamsModel
import com.example.footballapi.network.footballTeams.FootballTeamsInterface
import com.example.footballapi.network.footballTeams.FootballTeamsRetrofitInstance
import com.example.footballapi.presenter.BasePresenter
import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class FootballPresenter: BasePresenter<FootballView>() {

    override fun disposeView() {
        super.disposeView()
        compositeDisposable.dispose()
    }

    var compositeDisposable = CompositeDisposable()

    override fun onViewAttached(view: FootballView) {
        super.onViewAttached(view)

        var retro = FootballTeamsRetrofitInstance().footballRetrofitInstance.create(FootballTeamsInterface::class.java)
        var call = retro.getFootballModel(Constants.LEAGUE)

        Log.d("0000000001102020", "this is working")




        call
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap {
                ObservableSource<FootballTeamsModel> {

                }
            }.subscribe(object : Observer<FootballTeamsModel>{
                override fun onComplete() {
                    Log.d("ONCOMPLETE", " THIS IS DONE")
                }

                override fun onSubscribe(d: Disposable) {
                    var disposable = d

                    compositeDisposable.add(disposable)
                    Log.d("Disposable is: ", d.toString())
                }

                override fun onNext(t: FootballTeamsModel) {
                    Log.d("SUCCESSSSSSSS", t.teams[0].strCountry)
                    view.showFootballView(t)
                }

                override fun onError(e: Throwable) {
                    Log.d("ERROR FOUND AS;", e.message)
                }

            })


        /*.enqueue {
            onFailure = {
                it -> Log.d("THE ERROR IS >>>>>>>", it.toString())
            }

            onResponse = {
                it -> var resp: FootballTeamsModel? = it.body()

                Log.d("89878868686868", "this is working again......")

                view.showFootballView(resp!!)
            }
        }*/

/*        call.enqueue(object : Callback<FootballTeamsModel>{
            override fun onFailure(call: Call<FootballTeamsModel>, t: Throwable) {
                Log.d("THE ERROR IS >>>>>>>", t.message)
            }

            override fun onResponse(call: Call<FootballTeamsModel>, response: Response<FootballTeamsModel>) {
                var resp: FootballTeamsModel? = response.body()

                Log.d("89878868686868", "this is working again......")

                view.showFootballView(resp!!)
            }

        })*/

//        call.enqueue(object : Callback<FootballTeamsModel>{
//            override fun onFailure(call: Call<FootballTeamsModel>, t: Throwable) {
//                Log.d("FAILURE1>>>>>>", t.message)
//            }
//
//            override fun onResponse(call: Call<FootballTeamsModel>, response: Response<FootballTeamsModel>) {
//
//                var respo: FootballTeamsModel? = response.body()
//
//                Log.d("SUCCESS1>>>>>>", respo!!.teams[0].strTeam)
//
//                view.showFootballView(respo)
//
//
//            }
//
//        })



    }

}

interface FootballView: BasePresenter.View{

    fun showLoading()
    fun showFootballView(footballTeamsModel: FootballTeamsModel)
}
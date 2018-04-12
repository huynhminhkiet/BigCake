package com.bigcake

import com.bigcakemvp.BigCakePresenter
import com.bigcakemvp.Router


/**
 * Created by kiethuynh on 11/04/2018
 */
internal class MainPresenter : BigCakePresenter<MainViewCallbacks, Router>() {
    private val textInteractor = TextInteractor()

    fun onTextClick() {
        textInteractor.execute({result -> view.updateText(result)}, {})
    }
}
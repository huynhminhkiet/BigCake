package com.bigcake;

import com.bigcakemvp.interactor.SingleInteractor;
import org.jetbrains.annotations.NotNull;
import io.reactivex.Single;

/**
 * Created by kiethuynh on 11/04/2018
 */

public class TextInteractor extends SingleInteractor<String, Void> {

    @NotNull
    @Override
    protected Single<String> buildUseCase(Void aVoid) {
        return Single.just("Hello erttyty");
    }
}

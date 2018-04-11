package com.bigcake;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainViewCallbacks {

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter();

        findViewById(R.id.tvTest).setOnClickListener(view -> presenter.onTextClick());
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.takeView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.dropView(this);
    }

    @Override
    public void updateText(String text) {
        ((TextView) findViewById(R.id.tvTest)).setText(text);
    }
}

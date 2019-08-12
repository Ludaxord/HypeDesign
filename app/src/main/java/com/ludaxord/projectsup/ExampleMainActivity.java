package com.ludaxord.projectsup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.ludaxord.projectsup.library.widget.webkit.webview.SupWebView;

public class ExampleMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_activity_main);
        loadWebView();
    }

    public void loadWebView() {
        SupWebView supWebView = findViewById(R.id.web_view);
        supWebView.loadUrl("https://google.com/");
    }
}

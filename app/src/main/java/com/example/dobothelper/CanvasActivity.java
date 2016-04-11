package com.example.dobothelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class CanvasActivity extends AppCompatActivity {

    public static TextView xCoorView;
    public static TextView yCoorView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        xCoorView = (TextView) findViewById(R.id.mouseX);
        yCoorView = (TextView) findViewById(R.id.mouseY);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}

package com.example.karolina.mythirdaplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.app.Activity;

public class MainActivity extends Activity implements OnTouchListener, OnDragListener{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.imageView).setOnTouchListener(this);
        findViewById(R.id.imageView7).setOnTouchListener(this);

        addListenerOnButton();

    }



    private void addListenerOnButton()
    {

        final Context context = this;
        Button button = (Button) findViewById(R.id.prezentacja_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intent = new Intent(context, Main2Activity.class);
                startActivity(intent);

            }

        });


    }

    public boolean onTouch(View view, MotionEvent motionEvent)
    {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN)
        {
            DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(null, shadowBuilder, view, 1);
            view.setVisibility(View.VISIBLE);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean onDrag(View layoutview, DragEvent dragevent) {

        int action = dragevent.getAction();
        View view = (View) dragevent.getLocalState();

        switch (action) {
            case DragEvent.ACTION_DRAG_STARTED:
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                break;
        }
        return true;
    }


}

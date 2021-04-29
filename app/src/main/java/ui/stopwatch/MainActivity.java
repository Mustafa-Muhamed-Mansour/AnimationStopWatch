package ui.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{

    private ImageView image_view_big , image_view_ican;
    private Button button_start , button_stop;
    private Animation animation;
    private Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initialViews();
        clickedButtons();


    }

    private void initialViews()
    {
        chronometer = findViewById(R.id.timer);
        image_view_big = findViewById(R.id.img_big_circle);
        image_view_ican = findViewById(R.id.img_icanchor);
        animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.round);
        button_stop = findViewById(R.id.btn_stop_now);
        button_start = findViewById(R.id.btn_start_now);
    }

    private void clickedButtons()
    {
        button_start.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                image_view_ican.startAnimation(animation);
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
            }
        });

        button_stop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                image_view_ican.setVisibility(View.INVISIBLE);
                chronometer.stop();
            }
        });
    }
}
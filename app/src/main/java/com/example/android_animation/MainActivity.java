package com.example.android_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button button,button1;
    private TextView textView;
    private AnimationDrawable mAnimationDrawable;
    private  ValueAnimator valueAnimator,valueAnimator2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView2);
        button = findViewById(R.id.button);
        button1= findViewById(R.id.button2);
        textView = findViewById(R.id.tv);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // 给textview的颜色进行动画

                valueAnimator = ObjectAnimator.ofInt(textView,"backgroundColor",0xff00ff00);
                valueAnimator.setDuration(2000);
                valueAnimator.setEvaluator(new ArgbEvaluator());
                valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
                valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
                valueAnimator.start();


            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                valueAnimator2 = ObjectAnimator.ofInt(textView,"TextColor",0xff00ffff);
                valueAnimator2.setEvaluator(new ArgbEvaluator());
                valueAnimator2.setRepeatCount(ValueAnimator.INFINITE);
                valueAnimator2.setRepeatMode(ValueAnimator.REVERSE);

                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(valueAnimator2
                );

                animatorSet.setDuration(2000).start();

            }
        });



       // imageView.setImageDrawable(R.drawable.my_animation);
        imageView.setImageResource(R.drawable.my_animation);
        mAnimationDrawable = (AnimationDrawable) imageView.getDrawable();
        mAnimationDrawable.setOneShot(false);
        mAnimationDrawable.start();


        Animation animation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,-0.2f,Animation.RELATIVE_TO_PARENT,1
        ,Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,1);

        Animation animation1 = new RotateAnimation(-0.2f,Animation.RELATIVE_TO_PARENT,1
                ,0,Animation.RELATIVE_TO_SELF,1);

                animation.setDuration(2000);
        animation.setRepeatCount(-1);
     //   imageView.setAnimation(animation);
        imageView.setAnimation(animation1);

        Animation animation11 = AnimationUtils.loadAnimation(MainActivity.this,R.anim.view_anim);
        animation11.setRepeatCount(3);
        imageView.setAnimation(animation11);
        animation11.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Toast.makeText(MainActivity.this,"kaishi",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(MainActivity.this,"完成",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Toast.makeText(MainActivity.this,"repeat",Toast.LENGTH_LONG).show();
            }
        });

    }
}

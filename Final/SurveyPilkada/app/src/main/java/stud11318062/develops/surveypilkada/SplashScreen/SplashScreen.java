package stud11318062.develops.surveypilkada.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import stud11318062.develops.surveypilkada.Autentifikasi.LoginActivity;
import stud11318062.develops.surveypilkada.R;

public class SplashScreen extends AppCompatActivity {
    ImageView mlogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        mlogo = (ImageView) findViewById(R.id.logo);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.from_top);
        mlogo.startAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splashscreen = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(splashscreen);
                finish();
            }
        },3000);
    }
}
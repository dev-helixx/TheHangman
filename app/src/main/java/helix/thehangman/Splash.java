package helix.thehangman;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    /* Duration of wait */
    private int SPLASH_DISPLAY_LENGTH = 6000;
    private ImageView image_ring, image_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        image_ring = (ImageView) findViewById(R.id.logo_ring);
        image_text = (ImageView) findViewById(R.id.helix_text);

        Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        Animation fade = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_slow);

        image_text.startAnimation(fade);
        image_ring.startAnimation(rotate);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(Splash.this, MainActivity.class);
                startActivity(mainIntent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();


            }
        }, SPLASH_DISPLAY_LENGTH);

    }
}

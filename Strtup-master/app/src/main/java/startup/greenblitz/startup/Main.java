package startup.greenblitz.startup;

import android.app.ActionBar;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Main extends Activity {
    Animation animation;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getActionBar().setIcon(R.drawable.san_bar);


        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);


        setContentView(R.layout.activity_main);


        setFeatureDrawableResource(Window.FEATURE_CUSTOM_TITLE, R.drawable.san_bar);


        imageView = (ImageView) findViewById(R.id.connect);
         animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // DoAnimation();

            }
        });

    }
    private void DoAnimation(){
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(getApplicationContext(), startup.greenblitz.startup.TabActivity.class));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        imageView.startAnimation(animation);
    }


}

package startup.greenblitz.startup;

import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class TabActivity extends ActionBarActivity {
    Animation animation;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // getActionBar().setIcon(R.drawable.san_bar);
     //   requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        //getActionBar().newTab().setIcon(R.drawable.san_bar);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.san_bar));
        getSupportActionBar().setTitle("");
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(),this);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mViewPager.setCurrentItem(1);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        Activity activity;
        public SectionsPagerAdapter(FragmentManager fm,Activity activity) {

            super(fm);
            this.activity = activity;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                  return new MAIN(activity,animation);
                case 1:
                    return new WakeUp(mViewPager);

                case 2:
                    return new  Graphs();
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class MAIN extends Fragment {
        Animation animation;
        ImageView imageView;
        Activity ctx;
      MAIN(Activity ctx, Animation animation){
      this.ctx=ctx;
          this.animation = animation;

        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_main, container, false);
            imageView = (ImageView) rootView.findViewById(R.id.connect);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DoAnimation();

                }
            });
            return rootView;
        }
        private void DoAnimation(){

            imageView.startAnimation(animation);
        }

    }

    public static class GRAPH extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.grph, container, false);
            return rootView;
        }
    }

    public static class INFORMATION extends Fragment {


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tab, container, false);
            return rootView;
        }
    }
}

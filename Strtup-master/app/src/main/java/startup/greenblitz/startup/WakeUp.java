package startup.greenblitz.startup;

import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by ghost on 29/03/2015.
 */
public class WakeUp extends Fragment {

    ImageView ivWakeUp;
    ViewPager viewPager;

    public WakeUp(ViewPager viewPager) {

        this.viewPager = viewPager;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.wakeup, container, false);
        ivWakeUp = (ImageView) rootView.findViewById(R.id.bWakeUp);

        ivWakeUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(3);
            }
        });
        return rootView;
    }
}

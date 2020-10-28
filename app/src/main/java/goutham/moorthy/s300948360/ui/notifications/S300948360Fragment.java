package goutham.moorthy.s300948360.ui.notifications;
//Goutham Moorthy, 300948360, 002
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import goutham.moorthy.s300948360.R;

public class S300948360Fragment extends Fragment {

    private S300948360ViewModel s300948360ViewModel;
    private ImageView imageMoon;
    private Animation aninmationss;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        s300948360ViewModel =
                ViewModelProviders.of(this).get(S300948360ViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        Button start = root.findViewById(R.id.btnStart);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageMoon = root.findViewById(R.id.moon);
                // Load the appropriate animation
                aninmationss =  AnimationUtils.loadAnimation(getContext(), R.anim.set);
                // Start the animation
                imageMoon.startAnimation(aninmationss);
            }
        });

        Button stop = root.findViewById(R.id.btnStop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageMoon.clearAnimation();
            }
        });

        return root;
    }
}
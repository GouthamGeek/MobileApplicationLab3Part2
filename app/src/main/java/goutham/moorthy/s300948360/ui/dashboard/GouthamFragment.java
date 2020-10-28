package goutham.moorthy.s300948360.ui.dashboard;
//Goutham Moorthy, 300948360, 002
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import goutham.moorthy.s300948360.R;

public class GouthamFragment extends Fragment {

    private GouthamViewModel GouthamViewModel;


    int reasonableDuration;
    AnimationDrawable mframeAnimation;
    ImageView img;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GouthamViewModel =
                ViewModelProviders.of(this).get(GouthamViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        img = (ImageView) root.findViewById(R.id.ImageView_Cars);
        Button start = root.findViewById(R.id.ButtonStart);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner speedSpinner = root.findViewById(R.id.goutham_picture);
                TextView speedSpinnerText = (TextView) speedSpinner.getSelectedView();
                String text = speedSpinnerText.getText().toString();
                switch (text) {
                    case "0.3 Seconds" : reasonableDuration = 300;
                        break;
                    case "0.35 Seconds" : reasonableDuration = 350;
                        break;
                    case "0.4 Seconds" : reasonableDuration = 400;
                        break;
                    case "0.5 Seconds" : reasonableDuration = 500;
                        break;
                    default:break;
                }
                startAnimation();
            }
        });
        // implement stop button
        Button stop = root.findViewById(R.id.ButtonStop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAnimation();
            }
        });
        return root;
    }

    //

    private void startAnimation()
    {

        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.car1);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.car2);
        BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.car3);
        BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.car4);
        BitmapDrawable frame5 = (BitmapDrawable)getResources().getDrawable(R.drawable.car5);


        // Get the background, which has been compiled to an AnimationDrawable object.
        mframeAnimation = new AnimationDrawable();
        mframeAnimation.setOneShot(false);	// loop continuously
        mframeAnimation.addFrame(frame1, reasonableDuration);
        mframeAnimation.addFrame(frame2, reasonableDuration);
        mframeAnimation.addFrame(frame3, reasonableDuration);
        mframeAnimation.addFrame(frame4, reasonableDuration);
        mframeAnimation.addFrame(frame5, reasonableDuration);



        img.setBackground(mframeAnimation);

        mframeAnimation.setVisible(true,true);
        mframeAnimation.start();
    }
    private void stopAnimation()
    {
        mframeAnimation.stop();
        mframeAnimation.setVisible(false,false);
    }
}
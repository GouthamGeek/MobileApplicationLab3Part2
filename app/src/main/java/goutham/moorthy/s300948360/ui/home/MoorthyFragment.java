package goutham.moorthy.s300948360.ui.home;
//Goutham Moorthy, 300948360, 002
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import goutham.moorthy.s300948360.R;

public class MoorthyFragment extends Fragment {

    private MoorthyViewModel moorthyViewModel;
    private CanvasView canvasView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        moorthyViewModel =
                ViewModelProviders.of(this).get(MoorthyViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        canvasView = (CanvasView) root.findViewById(R.id.drawing_canvas);
        Button Goutham_pen_selection = root.findViewById(R.id.Goutham_pen_selection);
        Goutham_pen_selection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner colorSpinner = root.findViewById(R.id.Goutham_pen_color);
                TextView colorSpinnerText = (TextView) colorSpinner.getSelectedView();
                Spinner thickSpinner = root.findViewById(R.id.Goutham_pen_thickness);
                TextView thickSpinnerText = (TextView) thickSpinner.getSelectedView();
                String thick = thickSpinnerText.getText().toString();
                String color = colorSpinnerText.getText().toString();
                canvasView.getSelectedOptions(thick, color);
            }
        });

        Button clearButton = root.findViewById(R.id.Goutham_pen_clear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canvasView.clearPath();
            }
        });
        return root;
    }
}
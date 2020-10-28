package goutham.moorthy.s300948360.ui.home;
//Goutham Moorthy, 300948360, 002
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MoorthyViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MoorthyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
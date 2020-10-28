package goutham.moorthy.s300948360.ui.notifications;
//Goutham Moorthy, 300948360, 002

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class S300948360ViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public S300948360ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
package com.ic.bnvp;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    MutableLiveData<Integer> currentIndex = new MutableLiveData<>(0);
}

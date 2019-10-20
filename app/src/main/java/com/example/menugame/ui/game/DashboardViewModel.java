package com.example.menugame.ui.game;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.Random;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public void addProb()
    {
        Random rand = new Random();
        int op1 = rand.nextInt(21 - (-20)) + (-20);
        int op2 = rand.nextInt(21 - (-20)) + (-20);
        int sol = op1 + op2;
    }

    public void subProb()
    {
        Random rand = new Random();
        int op1 = rand.nextInt(21 - (-20)) + (-20);
        int op2 = rand.nextInt(21 - (-20)) + (-20);
        int sol = op1 - op2;

    }

    public void multProb()
    {
        Random rand = new Random();
        int op1 = rand.nextInt(16 - (-15)) + (-15);
        int op2 = rand.nextInt(16 - (-15)) + (-15);
        int sol = op1 * op2;
    }

    public void divProb()
    {

    }

    public void mathGame()
    {
        Random rand = new Random();
        int probType = rand.nextInt(4);
        if(probType == 0)
        {
            addProb();
        }
        else if(probType == 1)
        {
            subProb();
        }
        else if(probType == 2)
        {
            multProb();
        }
        else
        {
            divProb();
        }

    }

    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
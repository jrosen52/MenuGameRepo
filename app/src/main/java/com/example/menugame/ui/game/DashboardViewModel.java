package com.example.menugame.ui.game;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.menugame.R;

import java.util.Random;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    public String curProb;
    public int curSol;

    private Button calcButton;


    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        final TextView problem = (TextView) view.findViewById(R.id.prob);
        return view;
    }

    public void addProb()
    {
        Random rand = new Random();
        int op1 = rand.nextInt(21 - (-20)) + (-20);
        int op2 = rand.nextInt(21 - (-20)) + (-20);
        int sol = op1 + op2;
        curProb = op1 + " + " + op2;
        curSol = sol;
    }

    public void subProb()
    {
        Random rand = new Random();
        int op1 = rand.nextInt(21 - (-20)) + (-20);
        int op2 = rand.nextInt(21 - (-20)) + (-20);
        int sol = op1 - op2;
        curProb = op1 + " - " + op2;
        curSol = sol;

    }

    public void multProb()
    {
        Random rand = new Random();
        int op1 = rand.nextInt(16 - (-15)) + (-15);
        int op2 = rand.nextInt(16 - (-15)) + (-15);
        int sol = op1 * op2;
        curProb = op1 + " * " + op2;
        curSol = sol;
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

    public void onClick(View view)
    {
        switch (view.getId()) {
            case R.id.button:
                mathGame();
        }
    }

    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
        //calcButton = (Button) calcButton.findViewById(R.id.button);
        //calcButton.setOnClickListener((View.OnClickListener) this);
    }

    public LiveData<String> getText() {
        return mText;
    }

}
package com.example.menugame.ui.game;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.menugame.R;
import com.example.menugame.ui.leaderboard.NotificationsFragment;

import java.util.Random;

public class DashboardViewModel extends ViewModel implements View.OnClickListener {

    private MutableLiveData<String> mText;
    public String curProb;
    public int curSol;
    public int score;
    public String curPlayer;
    public int strikes = 3;
    View curView;

    boolean started;

    private Button answerButton;

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        curView = view;
        answerButton= (Button) view.findViewById(R.id.button);
        answerButton.setOnClickListener(this);
        started = false;
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

    public void mathGame()
    {
        while(strikes > 0)
        {
            Random rand = new Random();
            int probType = rand.nextInt(3);
            if (probType == 0) {
                addProb();
            } else if (probType == 1) {
                subProb();
            } else if (probType == 2) {
                multProb();
            }
        }
        int lowest = NotificationsFragment.getInstance().lowestValue();
        if(score > lowest)
        {
            NotificationsFragment.getInstance().updateBoard(curPlayer,score);
        }

    }

    public void onClick(View view)
    {
        final TextView problem = (TextView) view.findViewById(R.id.prob);
        final EditText solution = (EditText) view.findViewById(R.id.answer);
        String solString = solution.getText().toString();
        int solInt = Integer.parseInt(solString);

        switch (view.getId()) {
            case R.id.button:
                if(started == false)
                {
                    started = true;
                    mathGame();
                }
                else {
                    if(solInt == curSol)
                    {
                        score++;
                        mathGame();
                    }
                    else
                    {
                        strikes++;
                        mathGame();
                    }
                }
        }
    }


    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(" ");
        final TextView problem= curView.findViewById(R.id.prob);
        problem.setText(curProb);
    }

    public LiveData<String> getText() {
        return mText;
    }

}
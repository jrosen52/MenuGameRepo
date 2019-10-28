package com.example.menugame.ui.leaderboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import java.util.Vector;

import com.example.menugame.R;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;

    private int scores[] = {12,10,8,6,4,2};
    private String players[] = {"John","James","Jessica","Julian","Justin","Jackie"};

    View curView;

    private Button answerButton;

    private static NotificationsFragment instance = null;

    public int lowestValue()
    {
        return scores[6];
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        instance = this;
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_leaderboard, container, false);
        curView = root;
        final TextView textView = root.findViewById(R.id.text_leaderboard);

        final TextView person1= root.findViewById(R.id.person1);
        person1.setText(players[0]);
        final TextView person2= root.findViewById(R.id.person2);
        person2.setText(players[1]);
        final TextView person3= root.findViewById(R.id.person3);
        person3.setText(players[2]);
        final TextView person4= root.findViewById(R.id.person4);
        person4.setText(players[3]);
        final TextView person5= root.findViewById(R.id.person5);
        person5.setText(players[4]);
        final TextView person6= root.findViewById(R.id.person6);
        person6.setText(players[5]);

        final TextView score1= root.findViewById(R.id.score1);
        score1.setText(Integer.toString(scores[0]));
        final TextView score2= root.findViewById(R.id.score2);
        score2.setText(Integer.toString(scores[1]));
        final TextView score3= root.findViewById(R.id.score3);
        score3.setText(Integer.toString(scores[2]));
        final TextView score4= root.findViewById(R.id.score4);
        score4.setText(Integer.toString(scores[3]));
        final TextView score5= root.findViewById(R.id.score5);
        score5.setText(Integer.toString(scores[4]));
        final TextView score6= root.findViewById(R.id.score6);
        score6.setText(Integer.toString(scores[5]));

        notificationsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;
    }

    public static NotificationsFragment getInstance()
    {
        return instance;
    }

    public void updateBoard(String player, int score)
    {

        TextView lbPlayers[] = {curView.findViewById(R.id.person1),curView.findViewById(R.id.person2),curView.findViewById(R.id.person3),
                curView.findViewById(R.id.person4),curView.findViewById(R.id.person5),curView.findViewById(R.id.person6)};

        TextView lbScores[] = {curView.findViewById(R.id.score1),curView.findViewById(R.id.score2),curView.findViewById(R.id.score3),
                curView.findViewById(R.id.score4),curView.findViewById(R.id.score5),curView.findViewById(R.id.score6)};
        int num = 0;
        for(int i = 0; i < 6; i++)
        {
            if(score > scores[i])
            {
                num = i;
                break;
            }
        }
        TextView prevScore = lbScores[num];
        TextView prevName = lbPlayers[num];
        lbScores[num].setText(score);
        lbPlayers[num].setText(player);
        num++;
        while(num < 6)
        {
            prevScore = lbScores[num];
            prevName = lbPlayers[num];
            lbScores[num].setText((CharSequence) prevScore);
            lbPlayers[num].setText((CharSequence) prevName);
            num++;
        }
    }
}
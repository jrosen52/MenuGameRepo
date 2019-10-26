package com.example.menugame.ui.leaderboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    int scores[] = {2,4,6,8,10,12,14,16,18,20};
    String players[] = {"John","James","Jessica","Julian","Justin","Jackie","Joseph","Jeremiah","Jerome","Steve"};

    //Vector<TextView> lbNames = new Vector<TextView>();
    //Vector<TextView> lbScores = new Vector<TextView>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_leaderboard, container, false);
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
        final TextView person7= root.findViewById(R.id.person7);
        person7.setText(players[6]);
        final TextView person8= root.findViewById(R.id.person8);
        person8.setText(players[7]);
        final TextView person9= root.findViewById(R.id.person9);
        person9.setText(players[8]);
        final TextView person10= root.findViewById(R.id.person10);
        person10.setText(players[9]);

        final TextView score1= root.findViewById(R.id.score1);
        score1.setText(scores[0]);
        final TextView score2= root.findViewById(R.id.score2);
        score2.setText(scores[1]);
        final TextView score3= root.findViewById(R.id.score3);
        score3.setText(scores[2]);
        final TextView score4= root.findViewById(R.id.score4);
        score4.setText(scores[3]);
        final TextView score5= root.findViewById(R.id.score5);
        score5.setText(scores[4]);
        final TextView score6= root.findViewById(R.id.score6);
        score1.setText(scores[5]);
        final TextView score7= root.findViewById(R.id.score7);
        score1.setText(scores[6]);
        final TextView score8= root.findViewById(R.id.score8);
        score1.setText(scores[7]);
        final TextView score9= root.findViewById(R.id.score9);
        score1.setText(scores[8]);
        final TextView score10= root.findViewById(R.id.score10);
        score1.setText(scores[9]);

        notificationsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
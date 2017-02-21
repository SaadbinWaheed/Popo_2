package com.gmail.saadbnwhd.popo_2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TextView;

import com.gmail.saadbnwhd.popo_2.Adapters.team_List_Adap;

import java.util.ArrayList;

public class GoalScorerPlayers extends AppCompatActivity {
    String Team1,Team2,Goals1,Goals2;
    ArrayList<String> P1,P2;
    ArrayList<Integer> G1,G2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.newclr)));
        getSupportActionBar().setTitle("RESULTS");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.newclr1));
        }

        setContentView(R.layout.activity_goal_scorer_players);
        Bundle bundle=getIntent().getExtras();
        Team1 = bundle.getString("t1");
        Team2 = bundle.getString("t2");

        Goals1 = bundle.getString("g1");
        Goals2 = bundle.getString("g2");

        ListView  TEAM1 = (ListView) findViewById(R.id.players_t1);
        ListView  TEAM2 = (ListView) findViewById(R.id.players_t2);
        team_List_Adap players1=new team_List_Adap(GoalScorerPlayers.this,P1,G1);
        team_List_Adap players2=new team_List_Adap(GoalScorerPlayers.this, P2, G2);

       /* TEAM1.setAdapter(players1);
        TEAM2.setAdapter(players2);*/

      /*  P1.add(0, "Musab");
        P2.add(0, "Saad");
        G1.add(0,2);
        G2.add(0,1);
        P1.add(1, "Musab");
        P2.add(1, "Saad");
        G1.add(1,2);
        G2.add(1,1);*/
       /* players1.notifyDataSetChanged();
        players2.notifyDataSetChanged();*/

        TextView T1=(TextView) findViewById(R.id.team1);
        TextView T2=(TextView) findViewById(R.id.team2);
        TextView G1=(TextView) findViewById(R.id.goals1);
        TextView G2=(TextView) findViewById(R.id.goals2);
        T1.setText(Team1);
        T2.setText(Team2);
        G1.setText(Goals1);
        G2.setText(Goals2);

    }
    @Override
    public void finish() {
        super.finish();
        onLeaveThisActivity();
    }

    protected void onLeaveThisActivity() {
        overridePendingTransition(R.anim.slide_in_back, R.anim.slide_out_back);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        onStartNewActivity();
    }

    @Override
    public void startActivity(Intent intent, Bundle options) {
        super.startActivity(intent, options);
        onStartNewActivity();
    }

    protected void onStartNewActivity() {
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    @Override
    protected void onStart()
    {
        super.onStart();

    }
}

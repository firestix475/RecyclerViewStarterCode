package com.example.recyclerviewstudentversion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;
// Todo create a player class that will hold info about the player
public class MainActivity extends AppCompatActivity {
    // Todo initialize these variables
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    List<Player> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleView);
        getPlayers();
        MyRecyclerAdapter myAdapter = new MyRecyclerAdapter();
        recyclerView.setAdapter(myAdapter);
    }
    //Todo create method that will fill list of players

    public void getPlayers(){
        String[] name = new String[] {"Tristan Thompson", "James Harden","Kyrie Irving","Stephen Curry","Russell Westbrook",
                "Derrick Rose","Kevin Durant","Dwyane Wade","Kobe Bryant","LeBron James",
                "Magic Johnson","Miro Jurisic","Kareem Abdul-Jabbar","Shaquille O'Neal","Chris Paul"};
        int[] age = new int[]{28,30,27,31,30,
                31,31,37,41,34,
                60,18,72,47,34};
        int[] imageResource = new int[]{R.drawable.tristanthompson,R.drawable.jamesharden,R.drawable.kyrieirving,R.drawable.stephencurry,R.drawable.russellwestbrook,
                R.drawable.derrickrose,R.drawable.kevindurant,R.drawable.dwyanewade,R.drawable.kobebryant,R.drawable.lebronjames,
                R.drawable.magicjohnson,R.drawable.mirojurisic,R.drawable.kareemabduljabbar,R.drawable.shaquilleoneal,R.drawable.chrispaul};
        int[] worth = new int[]{8,120,70,130,150,
                85,170,120,500,480,
                600,1000,20,400,120};
        String[] url = new String[]{"https://www.biography.com/athlete/tristan-thompson","https://www.biography.com/athlete/james-harden","https://www.biography.com/athlete/kyrie-irving","https://www.biography.com/athlete/stephen-curry","https://www.biography.com/athlete/russell-westbrook",
                "https://www.biography.com/athlete/derrick-rose","https://www.biography.com/athlete/kevin-durant","https://www.biography.com/athlete/dwyane-wade","https://www.biography.com/athlete/kobe-bryant","https://www.biography.com/athlete/lebron-james",
                "https://www.biography.com/athlete/magic-johnson","https://www.biography.com/athlete/miro-jurisic","https://www.biography.com/athlete/kareem-abdul-jabbar","https://www.biography.com/athlete/shaquille-oneal","https://www.biography.com/athlete/chris-paul"};
        for(int x = 0; x < 15 ; x++){
            list.add(new Player(name[x], age[x], worth[x], "Basketball", imageResource[x], url[x]));
        }
    }

}

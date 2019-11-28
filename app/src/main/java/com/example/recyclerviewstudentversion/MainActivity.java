package com.example.recyclerviewstudentversion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// Todo create a player class that will hold info about the player
public class MainActivity extends AppCompatActivity  {
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
        recyclerView.setHasFixedSize(true);
        getPlayers();
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyRecyclerAdapter(list);
        recyclerView.setAdapter(mAdapter);
        ItemTouchHelper asdf = new ItemTouchHelper(new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
                int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
                int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
                return makeMovementFlags(dragFlags, swipeFlags);
            }

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int orgpos = viewHolder.getAdapterPosition();
                int targetpos = target.getAdapterPosition();
                if (orgpos < targetpos) {
                    for (int i = orgpos; i < targetpos; i++) {
                        Collections.swap(list,i,i+1);

                    }
                } else {
                    for (int i = orgpos; i > targetpos; i--) {
                        Collections.swap(list, i, i - 1);
                    }
                }
                mAdapter.notifyItemMoved(orgpos,targetpos);
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                list.remove(viewHolder.getAdapterPosition());
                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());

            }
        });
        asdf.attachToRecyclerView(recyclerView);

    }
    //Todo create method that will fill list of players

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menufi,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.two:
                layoutManager = new GridLayoutManager(this, 2);
                recyclerView.setLayoutManager(layoutManager);
                return true;
            case R.id.three:
                layoutManager = new GridLayoutManager(this, 3);
                recyclerView.setLayoutManager(layoutManager);
                return true;

            case R.id.lines:
                layoutManager = new LinearLayoutManager((this));
                recyclerView.setLayoutManager(layoutManager);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Todo create method that will fill list of players


    public void getPlayers(){
        list = new ArrayList<Player>();
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

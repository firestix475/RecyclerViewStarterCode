package com.example.recyclerviewstudentversion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {
View view;
List<Player> listofPlayers;

    public MyRecyclerAdapter(@NonNull List<Player> obj) {
       listofPlayers = obj;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.single_item_file,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.age.setText("Age: " + listofPlayers.get(position).getAge());
        holder.name.setText(listofPlayers.get(position).getName());
        holder.worth.setText("Worth: " + listofPlayers.get(position).getWorth() + " mil");
        holder.sport.setText("Sport: " + listofPlayers.get(position).getMainSport());
    }

    @Override
    public int getItemCount() {
        return listofPlayers.size();
    }


public static class MyViewHolder extends RecyclerView.ViewHolder    {
   
      public TextView name;
      public TextView age;
      public TextView sport;
      public TextView worth;
      public ImageView imageView;
    private MyViewHolder(@NonNull View view) {
        super(view);
	name = view.findViewById(R.id.name);
        age = view.findViewById(R.id.age);
	worth = view.findViewById(R.id.worth);
      	sport = view.findViewById(R.id.sport);
        imageView = view.findViewById(R.id.imageView);

    }
}

package com.example.recyclerviewstudentversion;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.single_item_file, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,final int position) {
        holder.age.setText("Age: " + listofPlayers.get(position).getAge());
        holder.name.setText("Name: "+listofPlayers.get(position).getName());
        holder.worth.setText("Worth: " + listofPlayers.get(position).getWorth() + " mil");
        holder.sport.setText("Sport: " + listofPlayers.get(position).getMainSport());
        holder.imageView.setImageResource(listofPlayers.get(position).getImageResource());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.getContext().startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(listofPlayers.get(position).getWebpage())));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listofPlayers.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView age;
        public TextView sport;
        public TextView worth;
        public ImageView imageView;
        public  List<Player> listofPlayers;

        private MyViewHolder(@NonNull View view) {
            super(view);
            name = view.findViewById(R.id.name);
            age = view.findViewById(R.id.age);
            worth = view.findViewById(R.id.worth);
            sport = view.findViewById(R.id.sport);
            imageView = view.findViewById(R.id.imageView);

        }

public static class MyViewHolder extends RecyclerView.ViewHolder    {

	public TextView name;
	public TextView age;
	public TextView sport;
	public TextView worth;
	public ImageView imageView;
	private MyViewHolder(@NonNull View view) {
		super(view);name = view.findViewById(R.id.name);
		age = view.findViewById(R.id.age);worth = view.findViewById(R.id.worth);
		sport = view.findViewById(R.id.sport);
		imageView = view.findViewById(R.id.imageView);
	}
}

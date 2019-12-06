package com.example.recyclerviewstudentversion;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> implements Filterable {
    View view;
    MyViewHolder holder;
    List<Player> listofPlayers;
    List<Player>  copyforFilter;


    public MyRecyclerAdapter(@NonNull List<Player> obj) {
        listofPlayers = obj;
        copyforFilter = new ArrayList<Player>(listofPlayers);

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.single_item_file, parent, false);
        holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.age.setText("Age: " + listofPlayers.get(position).getAge());
        holder.name.setText(listofPlayers.get(position).getName());
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
    Filter  filterEXP = new Filter() {
        @Override
        protected Filter.FilterResults performFiltering(CharSequence constraint) {
            List<Player> filterlist = new ArrayList<>();
            if(constraint==null||constraint.length()==0){
                filterlist.addAll(copyforFilter);
            }
            else {
                String simplifiedTarget = constraint.toString().toLowerCase().trim();
                for (Player p : listofPlayers) {
                    String n = p.getName().toLowerCase();
                    String w = p.getWorth()+"";
                    String a = p.getAge()+"";
                    if((n.contains(simplifiedTarget))||(w.contains(simplifiedTarget))||(a.contains(simplifiedTarget))){
                        filterlist.add(p);
                    }
                }
            }
            Filter.FilterResults fr = new Filter.FilterResults();
            fr.values = filterlist;
            return  fr;
        }

        @Override
        protected void publishResults(CharSequence constraint, Filter.FilterResults results) {
            listofPlayers.clear();
            listofPlayers.addAll((List)results.values);
        /*    String input = constraint.toString().toLowerCase().trim();
            int position = 0;
            for (Player p : listofPlayers) {
                String n = p.getName().toLowerCase().trim();
                String w = p.getWorth()+"";
                String a = p.getAge()+"";

                if(n.contains(constraint)){
                    String text = n;
                    SpannableString ss = new SpannableString(text);
                    try{
                        int startindex = n.indexOf(input);
                        int lastindex = startindex + input.length();
                        BackgroundColorSpan bgYello = new BackgroundColorSpan(Color.YELLOW);
                        ss.setSpan(bgYello,startindex,lastindex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                    }
                    catch (IndexOutOfBoundsException ex){
                        Log.e(TAG, "publishResults: index out of bound ", ex);
                    }
                }
                position++;
            }
            */

            notifyDataSetChanged();
        }
    };

    @Override
    public Filter getFilter() {
        return filterEXP;
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
        public List<Player> listofPlayers;
        private MyViewHolder(@NonNull View view) {
            super(view);
            name = view.findViewById(R.id.name);
            age = view.findViewById(R.id.age);
            worth = view.findViewById(R.id.worth);
            sport = view.findViewById(R.id.sport);
            imageView = view.findViewById(R.id.imageView);
        }
    }




}

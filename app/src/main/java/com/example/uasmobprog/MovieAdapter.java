package com.example.uasmobprog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private Context movieContext;
    private List<MovieModel> movieData;

    public MovieAdapter(Context movieContext, List<MovieModel> movieData) {
        this.movieContext = movieContext;
        this.movieData = movieData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View movieview;
        LayoutInflater inflater = LayoutInflater.from(movieContext);
        movieview = inflater.inflate(R.layout.movie_list, parent,false);

        return new MyViewHolder(movieview);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.id.setText(movieData.get(position).getMovieid());
        holder.name.setText(movieData.get(position).getMoviename());

        Glide.with(movieContext).load(movieData.get(position).getMovieurl()).into(holder.url);
    }

    @Override
    public int getItemCount() {
        return movieData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView id;
        TextView name;
        ImageView url;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.textView);
            name = itemView.findViewById(R.id.textView2);
            url = itemView.findViewById(R.id.imageView);
        }
    }
}

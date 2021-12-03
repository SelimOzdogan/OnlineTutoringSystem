package com.example.onlinetutoringsystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinetutoringsystem.Model.Instructor;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<Instructor> instructors;
    private RecyclerViewClickListener listener;

    private int[] images = {R.drawable.android_image_1, R.drawable.android_image_2,
            R.drawable.android_image_3, R.drawable.android_image_4, R.drawable.android_image_5,
            R.drawable.android_image_6, R.drawable.android_image_7, R.drawable.android_image_8};

    public RecyclerAdapter(List<Instructor> instructors, RecyclerViewClickListener listener) {
        this.instructors = instructors;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Instructor instructor = instructors.get(position);
        holder.name.setText(instructor.getInstructorName());
        holder.title.setText(instructor.getInstructorMajor());
        holder.imageView.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        if (instructors != null) {
            return instructors.size();
        } else {
            return 0;
        }
    }


    public interface RecyclerViewClickListener {
        void onclick(View v, int position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name, title, profileName, profileMajor;
        ImageView imageView, imageProfile;
        public ViewHolder(@NonNull View view) {
            super(view);
            name = view.findViewById(R.id.textViewName);
            title = view.findViewById(R.id.textViewTitle);
            imageView = view.findViewById(R.id.imageView);
            profileName = view.findViewById(R.id.textViewProfileName);
            profileMajor = view.findViewById(R.id.textViewProfileMajor);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onclick(view, getAdapterPosition());
        }
    }
}

package com.example.otslistview;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class UserRecycler extends RecyclerView.Adapter<UserRecycler.ViewHolder> {
    String[] names = {"Mary","Peter","Harry","Eli","Sam"};
    String[] profession = {"Lyricist","Music Ethusiast/ Flute Player","Guitarist (Rock Band)","Violinist","Singer/Songwriter"};
    int[] profile = {R.drawable.instructor1,R.drawable.instructor2,R.drawable.instructor3
            ,R.drawable.instructor4,R.drawable.instructor5};

    @NonNull
    @Override
    public UserRecycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.setIsRecyclable(false);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserRecycler.ViewHolder holder, int position) {
        holder.textView1.setText(names[position]);
        holder.textView2.setText(profession[position]);
        holder.image.setImageResource(profile[position]);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1, textView2;
        ImageView image;
        private final Context context;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageViewLogo);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);

            context = itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final Intent intent;
                    final Bundle bundle = new Bundle();
                    switch(getAdapterPosition()){
                        case 0:
                            intent = new Intent(context, MainActivity.class);
                            Toast.makeText(context,"You're here",Toast.LENGTH_SHORT).show();
                        /*case 1:
                            intent = new Intent(context, MainActivity.class);
                            bundle = bundle.putSerializable("bundle",get);
                            Toast.makeText(context,"You're here",Toast.LENGTH_SHORT).show();
                        case 2:
                            intent = new Intent(context, MainActivity.class);
                            Toast.makeText(context,"You're here",Toast.LENGTH_SHORT).show();
                        case 3:
                            intent = new Intent(context, MainActivity.class);
                            Toast.makeText(context,"You're here",Toast.LENGTH_SHORT).show();
                        case 4:
                            intent = new Intent(context, MainActivity.class);
                            Toast.makeText(context,"You're here",Toast.LENGTH_SHORT).show();
*/
                    }
                }
            });
        }
    }
}

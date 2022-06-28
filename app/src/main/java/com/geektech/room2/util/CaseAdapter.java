package com.geektech.room2.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.room2.entity.Case;
import com.geektech.room2.R;

import java.util.List;

public class CaseAdapter extends RecyclerView.Adapter<CaseAdapter.ViewHolder> {

    private final List<Case> list;
    private final LayoutInflater inflater;



    public CaseAdapter(Context context, List<Case> list) {
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }



    @NonNull
    @Override
    public CaseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_case, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Case item = list.get(position);
        holder.textView.setText(item.text);
        holder.textView2.setText(item.description);
        holder.textView3.setText(item.date);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
         TextView textView, textView2, textView3;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView3 = itemView.findViewById(R.id.textView3);
            textView2 = itemView.findViewById(R.id.textView2);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}

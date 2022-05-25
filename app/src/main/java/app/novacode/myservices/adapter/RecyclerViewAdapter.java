/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.novacode.myservices.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final List<String> mTittle;
    private final List<String> mSpecifications;
    private final List<Float> mPrice;


    private final LayoutInflater mInflater;


    // data is passed into the constructor
    public RecyclerViewAdapter(Context context, List<String> tittle, List<String> spec, List<Float> price) {
        this.mInflater = LayoutInflater.from(context);
        this.mTittle = tittle;
        this.mSpecifications = spec;
        this.mPrice = price;

    }

    // inflates the row layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.service_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the view and textview in each row
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String title = mTittle.get(position);
        String specifications = mSpecifications.get(position);
        Float fPrice = mPrice.get(position);

        holder.myView.setText(title);
        holder.myTextView.setText(specifications);
        holder.myPrice.setText( "$ "+ fPrice);

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mTittle.size();
    }

    // stores and recycles views as they are scrolled off screen
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myView;
        TextView myTextView;
        TextView myPrice;


        ViewHolder(View itemView) {
            super(itemView);
            myView = itemView.findViewById(R.id.tittleService);
            myTextView = itemView.findViewById(R.id.infoService);
            myPrice = itemView.findViewById(R.id.priceService);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
        }
    }


}
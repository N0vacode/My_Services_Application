/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.widgets;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import app.novacode.myservices.R;
import app.novacode.myservices.entity.Services;


public class ServicesAdapter extends BaseAdapter {
    private Context context;

    public ServicesAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Services.ITEMS.length;
    }

    @Override
    public Services getItem(int position) {
        return Services.ITEMS[position];
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_item, viewGroup, false);
        }

        ImageView imagenCoche = (ImageView) view.findViewById(R.id.image_service);
        TextView nombreCoche = (TextView) view.findViewById(R.id.name_service);

        final Services item = getItem(position);
        imagenCoche.setImageResource(item.getIdDrawable());
        nombreCoche.setText(item.getNombre());

        return view;
    }

}
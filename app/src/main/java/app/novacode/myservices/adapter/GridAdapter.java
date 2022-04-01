/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import app.novacode.myservices.R;

public class GridAdapter extends BaseAdapter {
    Context context;
    String[] serviceName;
    int[] image;
    int[] rate;

    LayoutInflater layoutInflater;

    public GridAdapter(Context context, String[] serviceName, int[] image, int[] rate) {
        this.context = context;
        this.serviceName = serviceName;
        this.image = image;
        this.rate = rate;
    }

    @Override
    public int getCount() {
        return serviceName.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(layoutInflater == null)
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(view == null){
            view = layoutInflater.inflate(R.layout.grid_item,null);
        }

        ImageView rates = view.findViewById(R.id.rates);
        ImageView viewService = view.findViewById(R.id.image_service);
        TextView nameService = view.findViewById(R.id.name_service);

        viewService.setImageResource(image[i]);
        nameService.setText(serviceName[i]);
        rates.setImageResource(rate[i]);

        return view;
    }
}

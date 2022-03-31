/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {
    Context context;
    String[] flowerName;
    int[] image;

    LayoutInflater layoutInflater;

    public GridAdapter(Context context, String[] flowerName, int[] image) {
        this.context = context;
        this.flowerName = flowerName;
        this.image = image;
    }

    @Override
    public int getCount() {
        return flowerName.length;
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

        ImageView imageView = view.findViewById(R.id.image_service);
        TextView textView = view.findViewById(R.id.name_service);

        imageView.setImageResource(image[i]);
        textView.setText(flowerName[i]);

        return view;
    }
}

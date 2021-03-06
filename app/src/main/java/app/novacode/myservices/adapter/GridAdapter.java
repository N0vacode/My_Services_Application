/*
 * Copyright (c) $2019 NativeCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import app.novacode.myservices.ConstantValues;
import app.novacode.myservices.R;
import app.novacode.myservices.repository.BusinessRepository;
import app.novacode.myservices.services.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GridAdapter extends BaseAdapter {


    Context context;
    ArrayList<String> serviceName;
    ArrayList<String> image;
    ArrayList<Double> rate;

    LayoutInflater layoutInflater;

    public GridAdapter(Context context, ArrayList<String> serviceName, ArrayList<String> image, ArrayList<Double> rate) {
        this.context = context;
        this.serviceName = serviceName;
        this.image = image;
        this.rate = rate;
    }

    @Override
    public int getCount() {
        return serviceName.size();
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

        Glide.with(context)
                .load(image.get(i))
                .into(viewService);

//        viewService.setImageURI(Uri.parse());
        nameService.setText(serviceName.get(i));
        rates.setImageResource(ConstantValues.rateBusiness(rate.get(i)));


        return view;
    }



    // Rating definet by each business
    // i think switch method is better



}

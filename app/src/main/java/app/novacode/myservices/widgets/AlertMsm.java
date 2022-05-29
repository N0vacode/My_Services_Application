package app.novacode.myservices.widgets;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Map;
import java.util.Objects;

import app.novacode.myservices.R;
import app.novacode.myservices.entity.Rating;
import app.novacode.myservices.services.ApiService;
import kotlin.Function;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlertMsm  extends DialogFragment {

    private String tittle;
    private String msm;
    private String linkImage;
    private int icon;
    private DialogType dialogType;
    private String mailRated;
    private String businessId;
    View view;
    public AlertMsm(int contentLayoutId, String tittle, String msm, String linkImage, int icon) {
        super(contentLayoutId);
        this.tittle = tittle;
        this.msm = msm;
        this.linkImage = linkImage;
        this.icon = icon;
    }


    // For images Content
    public AlertMsm(String tittle, String msm, String linkImage) {
        this.tittle = tittle;
        this.msm = msm;
        this.linkImage = linkImage;
    }

    // For SImple Alert or Information
    public AlertMsm(String tittle, String msm, String mailRated, String businessId) {
        this.tittle = tittle;
        this.msm = msm;
        this.mailRated = mailRated;
        this.businessId = businessId;
    }

    // For icon dialog
    public AlertMsm(String tittle, String msm, int icon) {
        this.tittle = tittle;
        this.msm = msm;
        this.icon = icon;
    }

    // Empty Alert msm
    public AlertMsm(){}

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());



        switch (dialogType){

            case RATE:



                LayoutInflater layoutInflater = (LayoutInflater) requireContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = layoutInflater.inflate(R.layout.rate_service, null);

                RatingBar ratingBar = view.findViewById(R.id.ratingBar);

                builder.setTitle(tittle);
                builder.setMessage(msm);
                builder.setView(view);


                // New Instance and precharger values on constructor
                Rating newRating = new Rating( businessId, mailRated);



                ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                        newRating.setRate(rating);




                    }
                });

                builder.setPositiveButton("Rate", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {



                        Toast.makeText(getContext(), "Rated: " + newRating.getRate(), Toast.LENGTH_SHORT).show();

                        Call<Map<String, Object>> userRepositoryCall = ApiService.getUserService().sendRate(newRating);

                        userRepositoryCall.enqueue(new Callback<Map<String, Object>>() {


                            @Override
                            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {

                                try{



                                    if(response.isSuccessful()){

                                        Toast.makeText(getContext(), "Done", Toast.LENGTH_SHORT).show();

                                    }


                                }catch (Exception e){

                                    System.out.println("Error: " + e.getMessage());


                                }



                            }

                            @Override
                            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                                t.printStackTrace();
                                System.out.println(t + " On Failure Dashboard 276");
                            }

                        });






                    }
                });


                return builder.create();


            case SAVE_LOGIN:

                Toast.makeText(getContext(), "Save Login", Toast.LENGTH_SHORT).show();
                builder.setTitle(tittle);
                builder.setMessage(msm);


                builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                return builder.create();


            default:
                return  builder.create();


        }


    }





    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getMsm() {
        return msm;
    }

    public void setMsm(String msm) {
        this.msm = msm;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }


    public DialogType getDialogType() {
        return dialogType;
    }

    public void setDialogType(DialogType dialogType) {
        this.dialogType = dialogType;
    }

    public String getMailRated() {
        return mailRated;
    }

    public void setMailRated(String mailRated) {
        this.mailRated = mailRated;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }
}

package app.novacode.myservices.widgets;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import app.novacode.myservices.R;
import kotlin.Function;

public class AlertMsm  extends DialogFragment {

    private String tittle;
    private String msm;
    private String linkImage;
    private int icon;
    private DialogType dialogType;

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
    public AlertMsm(String tittle, String msm) {
        this.tittle = tittle;
        this.msm = msm;
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

                builder.setTitle(tittle);
                builder.setMessage(msm);

                buttonDialog(builder, "Rate", 1);
                buttonDialog(builder, "Cancel", 0);

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


    protected void buttonDialog(AlertDialog.Builder builder, String textButton, int buttonType){

        if(buttonType == 1) {


            builder.setPositiveButton(textButton, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Toast.makeText(getContext(), "Rated Pressed", Toast.LENGTH_SHORT).show();


                }
            });


        } else {
            builder.setNegativeButton(textButton, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Toast.makeText(getContext(), "Rated Cancel", Toast.LENGTH_SHORT).show();


                }
            });
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
}

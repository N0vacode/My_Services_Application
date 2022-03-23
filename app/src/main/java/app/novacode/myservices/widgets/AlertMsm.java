package app.novacode.myservices.widgets;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;


import androidx.fragment.app.DialogFragment;

public class AlertMsm  extends DialogFragment {


    private String tittle;
    private String msm;
    private String linkImage;




    // TODO CONSTRUIR ALERT DIALOG
    void getDialogAlert(Context context){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


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
}

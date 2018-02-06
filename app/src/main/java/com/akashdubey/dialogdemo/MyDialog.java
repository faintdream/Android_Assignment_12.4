package com.akashdubey.dialogdemo;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyDialog extends AppCompatDialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final DialogListener dialogListener=(DialogListener)getContext();
        final TextView objName,objPhone,objDob;
        final AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.dialog,null);
        objName=(TextView)view.findViewById(R.id.nameET);
        objPhone=(TextView)view.findViewById(R.id.phoneET);
        objDob=(TextView)view.findViewById(R.id.dobET);
        builder.setView(view)
                .setTitle("Enter the Details")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dismiss();
                    }
                })
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String tmpName,tmpPhone, tmpDob;
                        tmpName=objName.getText().toString();
                        tmpDob=objDob.getText().toString();
                        tmpPhone=objPhone.getText().toString();
                        dialogListener.PassInformation(tmpName,tmpPhone,tmpDob);
                    }
                });


        builder.create();
        return  builder.show();
    }

    public interface DialogListener{
        void PassInformation(String name, String phone, String dob);
    }
}

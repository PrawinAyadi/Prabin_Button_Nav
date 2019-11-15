package com.example.prabin_button_nav.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.prabin_button_nav.R;

import java.util.ArrayList;
import java.util.List;

import model.ESoftwarica;

public class DashboardFragment extends Fragment implements View.OnClickListener {

    private EditText etname, etage, etaddress;
    private RadioGroup radioGroup;
    private RadioButton rdmale, rdfemale, rdothers;
    private Button btnsave;


    String gender,name, address;
    int age;
    static List<ESoftwarica> eSoftwaricaList = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        etname=root.findViewById(R.id.etname);
        etage=root.findViewById(R.id.etage);
        etaddress=root.findViewById(R.id.etaddress);
        radioGroup=root.findViewById(R.id.radioGroup2);
        rdmale=root.findViewById(R.id.rdmale);
        rdfemale=root.findViewById(R.id.rdfemale);
        rdothers=root.findViewById(R.id.rdothers);
        btnsave=root.findViewById(R.id.btnsave);


        btnsave.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnsave:
                name = etname.getText().toString().trim();
                address = etaddress.getText().toString().trim();
                age = Integer.parseInt(etage.getText().toString().trim());


                if (rdmale.isChecked()) {
                    gender = "Male";
                }
                if (rdfemale.isChecked()) {
                    gender = "Female";
                }
                if (rdothers.isChecked()) {
                    gender = "Others";
                }

                ESoftwarica eSoftwarica = new ESoftwarica(name, address, age,gender);
                eSoftwaricaList = eSoftwarica.getStudentList();
                eSoftwaricaList.add(eSoftwarica);
                eSoftwarica.setStudentList(eSoftwaricaList);

                etname.setText("");
                etage.setText("");
                etaddress.setText("");
                rdmale.clearFocus();
                rdfemale.clearFocus();
                rdothers.clearFocus();
                break;
        }
    }
}
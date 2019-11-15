package fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.prabin_button_nav.Dashboard;
import com.example.prabin_button_nav.R;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {
    private EditText etusername,etpassword;
    private Button btnlogin;
    String usrname,password;
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_login, container, false);

        etusername=view.findViewById(R.id.etusername);
        etpassword=view.findViewById(R.id.etpassword);
        btnlogin=view.findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {
        usrname=etusername.getText().toString();
        password=etpassword.getText().toString();


        if(usrname.equals("Prabin") && password.equals("Ayadi")){
            Intent intent = new Intent(getActivity(), Dashboard.class);

            intent.putExtra(EXTRA_MESSAGE, usrname);

            startActivity(intent);
        }
        else {
            Toast.makeText(getActivity(), "Username or Password doesn't match", Toast.LENGTH_SHORT).show();
        }



    }
}

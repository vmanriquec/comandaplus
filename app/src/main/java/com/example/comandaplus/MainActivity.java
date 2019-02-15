package com.example.comandaplus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.login_progress)
    ProgressBar loginProgress;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.email_sign_in_button3)
    Button emailSignInButton3;
    @BindView(R.id.email_login_form)
    LinearLayout emailLoginForm;
    @BindView(R.id.login_form)
    ScrollView loginForm;
private static final String PATH_START="start";
public  static final String PATH_MESSAGE="message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    private void ir() {


        boolean FragmentTransaction=false;
        Fragment fragment=null;

            fragment = new Listaproductos();
            FragmentTransaction=true;


//            Intent i = new Intent(this, Listaproductos.class);

      startActivity(i);

    }

    @OnClick(R.id.email_sign_in_button3)
    public void onClick() {
        ir();
    }
}

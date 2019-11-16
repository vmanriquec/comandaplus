    package com.example.comandaplus;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.comandaplus.Realm.CrudUsuarios;
import com.example.comandaplus.Realm.UsuariosRealm;
import com.example.comandaplus.modelo.Usuarios;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;

    public class MainActivity extends AppCompatActivity {
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
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private ProfileTracker mProfileTracker;
    String sessionusuario,sessionnombre,sessionapepat,sessionapemat,oooo;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()



                .build();
        Realm.setDefaultConfiguration(configuration);


        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        loginButton = (LoginButton) findViewById(R.id.login_button);

        loginButton.setReadPermissions(Arrays.asList(
                "public_profile", "email"));

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                if (Profile.getCurrentProfile() == null) {
                    mProfileTracker = new ProfileTracker() {
                        @Override
                        protected void onCurrentProfileChanged(Profile profile, Profile profile2) {
                            mProfileTracker.stopTracking();
                            sessionusuario = profile2.getId();
                            sessionnombre = profile2.getName();
                            sessionapepat = profile2.getFirstName();
                            sessionapemat = profile2.getLastName();
                           UsuariosRealm u= CrudUsuarios.buscarusuariiporidFacebook(sessionusuario);
                          if (u!=null){
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                                            ir();
                              Toast.makeText(getApplicationContext(),"sigue disfrutando de la apalicacion",Toast.LENGTH_LONG).show();

                          }else{
                              UsuariosRealm i=new UsuariosRealm();
                              i.setIdfacebook(sessionusuario);
                              i.setNombreusuario(sessionnombre);
                              i.setImagen(sessionusuario);
                              i.setEstadousuario("iniciosession");
                              i.setClaveusuario("noporahora");
                              i.setAlmacenusuario("1");
                              CrudUsuarios.addUsuariosRealm(i );

                              Toast.makeText(getApplicationContext(),"Bienvenido usuario nuevo",Toast.LENGTH_LONG).show();
                              ir();

                          }




                        }

                    };

                }


            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException e) {
                Log.d("TAG", "error facebook ");
            }
        });

   }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }



    private void ir() {




           Intent i = new Intent(this, Navegacion.class);

      startActivity(i);

    }

    @OnClick(R.id.email_sign_in_button3)
    public void onClick() {
        ir();
    }
}

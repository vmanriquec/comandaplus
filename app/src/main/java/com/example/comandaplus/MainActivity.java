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
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;




  
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmConfiguration;








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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Realm.init(this);
        RealmConfiguration  configuration = new RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
  
.build();
        Realm.setDefaultConfiguration(configuration);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        loginButton = (LoginButton)findViewById(R.id.login_button);



        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                Log.d("TAG", "token facebook: " +loginResult.getAccessToken().getUserId()
                                + "\n" +
                                "Auth Token: "
                                + loginResult.getAccessToken().getToken());
                        orejas        
                                
                         comelon  
                         
                         
                         
                         
                         
                         
                         
                         
                         java android facebook android-studio facebook-graph-api
                         I am Trying to get gender and birthday of current login user from Facebook, but I always getting (id, email, name) I have search everything related to this but I didn't get exactly that for I am looking. below code, I have Trying that's not working.
                         
                         facebookLoginButton  = (LoginButton)view .findViewById(R.id.fragment_login_facebook);
                                 facebookLoginButton.setFragment(this);
                         callbackManager = CallbackManager.Factory.create();
                         
                         facebookLoginButton.setReadPermissions(Arrays.asList("public_profile", "email", "user_birthday", "user_friends"));
                                 callbackManager = CallbackManager.Factory.create();
                         
                             facebookLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                                 private ProfileTracker mProfileTracker;
                                 @Override
                                 public void onSuccess(LoginResult loginResult) {
                         
                         
                                     String accessTocken = loginResult.getAccessToken().getToken().toString();
                         
                                     Log.v("TAG", "Access Token " + loginResult.getAccessToken().getToken());
                                     GraphRequest request = GraphRequest.newMeRequest(
                                             loginResult.getAccessToken(),
                                             new GraphRequest.GraphJSONObjectCallback() {
                                                 @Override
                                                 public void onCompleted(JSONObject object, GraphResponse response) {
                         
                                                     try {
                                                         String email = object.getString("birthday");
                                                         String name = object.getString("gender");
                                                         Toast.makeText(getActivity().getApplicationContext(),email + " " + name ,Toast.LENGTH_SHORT).show();
                                                     } catch (JSONException e) {
                                                         e.printStackTrace();
                                                     }
                                                 }
                                             });
                         
                                     Bundle parameters = new Bundle();
                                     parameters.putString("fields", "id,name,email,gender,birthday");
                                     request.setParameters(parameters);
                                     request.executeAsync();
                         
                         
                         
                                     if (com.facebook.Profile.getCurrentProfile() == null){
                                         mProfileTracker = new ProfileTracker() {
                                             @Override
                                             protected void onCurrentProfileChanged(com.facebook.Profile oldProfile, com.facebook.Profile currentProfile) {
                                                 mProfileTracker.stopTracking();
                                             }
                                         };
                                         mProfileTracker.startTracking();
                                     } else {
                                         com.facebook.Profile profile = com.facebook.Profile.getCurrentProfile();
                                     }
                         
                                     try {
                                         URL image_value = new URL("http://graph.facebook.com/" + loginResult.getAccessToken().getUserId() + "/picture?type=large");
                                         Log.v(Constants.TAG, image_value + "");
                                     } catch (Exception e) {
                                     }
                                 }
                         
                                 @Override
                                 public void onCancel() {
                                     Log.e("TAG", "wrong");
                                 }
                         
                                 @Override
                                 public void onError(FacebookException error) {
                                     Log.e("TAG", "wrong");
                                 }
                             });
                         
                         
                         
                         
                         
                         
                         
                         
                         
                                
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

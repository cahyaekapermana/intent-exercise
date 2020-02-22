package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class RegisterActivity extends AppCompatActivity {

    public static final String FULLNAME_KEY = "fullname";
    public static final String EMAIL_KEY = "email";
    public static final String PASSWORD_KEY = "password";
    public static final String CONF_KEY = "conf";
    public static final String HOMEPAGE_KEY = "homepage";
    public static final String ABOUT_KEY = "about";

    private EditText fullnameInput;
    private EditText emailInput;
    private EditText passwordInput;
    private EditText confInput;
    private EditText homepageInput;
    private EditText aboutInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullnameInput = findViewById(R.id.text_fullname);
        emailInput = findViewById(R.id.text_email);
        passwordInput = findViewById(R.id.text_password);
        confInput = findViewById(R.id.text_confirm_password);
        homepageInput = findViewById(R.id.text_homepage);
        aboutInput = findViewById(R.id.text_about);

    }

    public void handleOk(View view) {

        if( passwordInput.getText().toString().isEmpty()){
            passwordInput.setError( "required!" );
        }
        if( confInput.getText().toString().isEmpty()){
            confInput.setError( "required!" );
        }
        if( fullnameInput.getText().toString().isEmpty()){
            fullnameInput.setError( "required!" );
        }
        if( emailInput.getText().toString().isEmpty()){
            emailInput.setError( "required!" );
        }
        if( homepageInput.getText().toString().isEmpty()){
            homepageInput.setError( "required!" );
        }
        if( aboutInput.getText().toString().isEmpty()){
            aboutInput.setError( "required!" );
        }

//        Kondisi cek password jika tidak sesuai diberi equals

        if ( ! passwordInput.getText().toString().equals( confInput.getText().toString() ) ){

            confInput.setError( "Password pertama anda = " + passwordInput.getText().toString() + " sementara password konfirm anda = " + confInput.getText().toString() + "sesuaikan inputan anda. makasih." );

        }

        else{

            String fullname = fullnameInput.getText().toString();
            String email = emailInput.getText().toString();
            String password = passwordInput.getText().toString();
            String conf = confInput.getText().toString();
            String homepage = homepageInput.getText().toString();
            String about = aboutInput.getText().toString();

            Intent intent = new Intent(this, ProfileActivity.class);

            intent.putExtra(FULLNAME_KEY, fullname);
            intent.putExtra(EMAIL_KEY, email);
            intent.putExtra(PASSWORD_KEY, password);
            intent.putExtra(CONF_KEY, conf);
            intent.putExtra(HOMEPAGE_KEY, homepage);
            intent.putExtra(ABOUT_KEY, about);

            startActivity(intent);

        }

    }

}
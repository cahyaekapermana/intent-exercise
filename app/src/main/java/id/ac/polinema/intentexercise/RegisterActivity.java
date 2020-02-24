package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;


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

        //Deklarasi attribut di sandingkan dengan id di text main
        fullnameInput = findViewById(R.id.text_fullname);
        emailInput = findViewById(R.id.text_email);
        passwordInput = findViewById(R.id.text_password);
        confInput = findViewById(R.id.text_confirm_password);
        homepageInput = findViewById(R.id.text_homepage);
        aboutInput = findViewById(R.id.text_about);

    }

    public void handleOk(View view ) {

        String fullname = fullnameInput.getText().toString();
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        String conf = confInput.getText().toString();
        String homepage = homepageInput.getText().toString();
        String about = aboutInput.getText().toString();

        Intent intent = new Intent(this, ProfileActivity.class);

        if( fullname.isEmpty()){
            fullnameInput.setError( "required!" );
        }

        if( email.isEmpty()){
            emailInput.setError( "required!" );
        }

        if( password.isEmpty()){
            passwordInput.setError( "required!" );
        }

        if( !conf.equals(password)){
            confInput.setError( "password yang anda masukan" + password +"sementara isi confirm pssword anda" + conf );
        }

        if( homepage.isEmpty()){
            homepageInput.setError( "required!" );
        }

        if( about.isEmpty()){
            aboutInput.setError( "required!" );
        }

        // Kondisi cek password jika tidak sesuai diberi equals (by cahya eka ganteng)

        else {

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
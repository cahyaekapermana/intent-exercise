package id.ac.polinema.intentexercise;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;


public class RegisterActivity extends AppCompatActivity {

    public static final String FULLNAME_KEY = "fullname";
    public static final String EMAIL_KEY = "email";
    public static final String PASSWORD_KEY = "password";
    public static final String CONF_KEY = "conf";
    public static final String HOMEPAGE_KEY = "homepage";
    public static final String ABOUT_KEY = "about";
    //Load Image Attribut
    private static final String TAG = RegisterActivity.class.getCanonicalName();
    private static final int GALLERY_REQUEST_CODE = 1;


    private ImageView imageProfile;
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
        imageProfile = findViewById(R.id.image_profile);

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

        else if( email.isEmpty()){
            emailInput.setError( "required!" );
        }

        else if( password.isEmpty()){
            passwordInput.setError( "required!" );
        }
        // Kondisi cek password jika tidak sesuai diberi equals (by cahya eka ganteng)
        else if( !conf.equals(password)){
            confInput.setError( "password yang anda masukan " + password +" sementara isi confirm pssword anda " + conf );
        }

        else if( homepage.isEmpty()){
            homepageInput.setError( "required!" );
        }

        else if( about.isEmpty()){
            aboutInput.setError( "required!" );
        }

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_CANCELED) {
            return;
        }

        if (requestCode == GALLERY_REQUEST_CODE) {
            if (data != null) {
                try {
                    Uri imageUri = data.getData();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                    imageProfile.setImageBitmap(bitmap);
                } catch (IOException e) {
                    Toast.makeText(this, "Can't load image", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }


    public void handleImageProfile(View view) {

        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, GALLERY_REQUEST_CODE);

    }
}
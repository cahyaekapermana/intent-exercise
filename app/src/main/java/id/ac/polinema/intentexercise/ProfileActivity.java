package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private TextView fullnameText;
    private TextView emailText;
    private TextView homepageText;
    private TextView aboutText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

//        Bind dari view activity main
        fullnameText = findViewById(R.id.label_fullname);
        emailText = findViewById(R.id.label_email);
        homepageText = findViewById(R.id.label_homepage);
        aboutText = findViewById(R.id.label_about);

        Bundle extras = getIntent().getExtras();

        String fullnameValue = extras.getString("fullname");
        String emailValue = extras.getString("email");
        String homepageValue = extras.getString("homepage");
        String aboutValue = extras.getString("about");

        //  Get Text dari Bind
        if (extras != null) {

            // TODO: display value here
            fullnameText.setText(fullnameValue);
            emailText.setText(emailValue);
            homepageText.setText(homepageValue);
            aboutText.setText(aboutValue);

        }

    }

}
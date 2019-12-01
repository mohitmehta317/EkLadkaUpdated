package com.mohitmehta317.ekladka;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ContactActivity extends Activity {

    TextView Social,Email,Name,Social_id,Email_id,Main_Heading;
    Button Finish,Back;

    GlobalDataClass objGlobal ;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        objGlobal = new GlobalDataClass();
        Finish = findViewById(R.id.nextbutton);
        Social = findViewById(R.id.social);
        Main_Heading = findViewById(R.id.heading);
        Social_id = findViewById(R.id.social_id);
        Name = findViewById(R.id.name);
        Email = findViewById(R.id.email);
        Email_id = findViewById(R.id.email_id);
        GlobalDataClass.context = this;
        Name.setTypeface(objGlobal.setfont());
        Name.setText(getResources().getText(R.string.name));
        Email_id.setTypeface(objGlobal.setfont());
        Email_id.setText("mohitmehta317@gmail.com");
        Email.setText(getResources().getString(R.string.email));
        Back = findViewById(R.id.backbutton);
        Social.setText(getResources().getString(R.string.social));
        Main_Heading.setText(getResources().getString(R.string.heading));
        Main_Heading.setTypeface(objGlobal.setfont());
        Social_id.setText("@mohitmehta317");
        Email.setTypeface(objGlobal.setfont());
        Back.setTypeface(objGlobal.setfont());
        Back.setText(getResources().getText(R.string.back));
        Social_id.setTypeface(objGlobal.setfont());
        Social.setTypeface(objGlobal.setfont());
        Finish.setTypeface(objGlobal.setfont());
        Finish.setText(getResources().getString(R.string.finish));
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selecttypeintent();
            }
        });
        Main_Heading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selecttypeintent();
            }
        });
        Finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selecttypeintent();
            }
        });


    }
    private void selecttypeintent() {
        Intent i = new Intent(ContactActivity.this,SelectType.class);
        startActivity(i);
        ContactActivity.this.finish();

        overridePendingTransition(R.anim.slide_right, R.anim.slide_left);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(ContactActivity.this,SelectType.class);
        startActivity(i);
        ContactActivity.this.finish();

        overridePendingTransition(R.anim.slide_right, R.anim.slide_left);
    }
}

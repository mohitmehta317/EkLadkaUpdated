package com.mohitmehta317.ekladka;


import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.Locale;

public class SelectLanguage extends Activity {
    Button EngButton,HinButton,NextButton;
    TextView MainHeading;
    GlobalDataClass objGlobal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_language);
        GlobalDataClass.context=this;
        objGlobal = new GlobalDataClass();
        NextButton = findViewById(R.id.nextbutton);
        EngButton=findViewById(R.id.button);
        HinButton=findViewById(R.id.button2);

        NextButton.setTypeface(objGlobal.setfont());
        EngButton.setTypeface(objGlobal.setfont());
        HinButton.setTypeface(objGlobal.setfont());
        MainHeading = findViewById(R.id.mainHeading);
        MainHeading.setTypeface(objGlobal.setfont());
        MainHeading.setText(getResources().getString(R.string.heading));

        ButtonClickListeners();
        if(GlobalDataClass.English){
            EngButton.performClick();

        }else {
            HinButton.performClick();
        }

    }
    public void ButtonClickListeners(){
        EngButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonclick(EngButton,HinButton);
                setlanguage("en");
                GlobalDataClass.English=true;
                NextButton.setText("Next");
                MainHeading.setText("Ek Ladka");


            }
        });
        HinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonclick(HinButton,EngButton);
                setlanguage("hi");
                GlobalDataClass.English=false;

                NextButton.setText("आगे बढ़ें");
                MainHeading.setText("एक लड़का");
            }
        });
        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalDataClass.check=0;
                Intent i = new Intent(SelectLanguage.this,SelectType.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_left, R.anim.slide_right);

                SelectLanguage.this.finish();

            }
        });
    }

    private void setlanguage(String str) {
        Locale locale = new Locale(str);
        Locale.setDefault(locale);
        Configuration config = getBaseContext().getResources().getConfiguration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
    }

    public void buttonclick(Button clicked,Button unclicked){
        clicked.setBackground(getResources().getDrawable(R.drawable.button_clicked));
        clicked.setTextColor(Color.parseColor("#000000"));
        unclicked.setBackground(getResources().getDrawable(R.drawable.button_unclicked));
        unclicked.setTextColor(Color.parseColor("#ffffff"));
    }
}

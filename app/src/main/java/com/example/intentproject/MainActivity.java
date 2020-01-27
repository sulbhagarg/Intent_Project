package com.example.intentproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvContact;
    Button btnCreateContact;
    ImageView ivMood, ivNumber, ivWeb, ivLocation;
    String name="", number="", web="", location="", mood="";
    final int REGISTRATION_ACTIVITY = 1;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REGISTRATION_ACTIVITY)
        {
            if(resultCode == RESULT_OK)
            {
                ivMood.setVisibility(View.VISIBLE);
                ivNumber.setVisibility(View.VISIBLE);
                ivWeb.setVisibility(View.VISIBLE);
                ivLocation.setVisibility(View.VISIBLE);

                assert data != null;
                name = data.getStringExtra("name");
                number = data.getStringExtra("number");
                web = data.getStringExtra("web");
                location = data.getStringExtra("location");
                mood = data.getStringExtra("mood");

                assert mood != null;
                if(mood.equals("happy"))
                {
                    ivMood.setImageResource(R.drawable.happy);
                }
                else if(mood.equals("neutral"))
                {
                    ivMood.setImageResource(R.drawable.neutral);
                }
                else
                {
                    ivMood.setImageResource(R.drawable.sad);
                }
            }
            else
            {
                Toast.makeText(this, "No data pass through!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvContact = findViewById(R.id.tvContact);
        btnCreateContact = findViewById(R.id.btnCreateContact);
        ivMood = findViewById(R.id.ivMood);
        ivNumber = findViewById(R.id.ivNumber);
        ivWeb = findViewById(R.id.ivWeb);
        ivLocation = findViewById(R.id.ivLocation);

        ivMood.setVisibility(View.GONE);
        ivNumber.setVisibility(View.GONE);
        ivWeb.setVisibility(View.GONE);
        ivLocation.setVisibility(View.GONE);

        btnCreateContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        com.example.intentproject.RegistartionActivity.class);
                startActivityForResult(intent, REGISTRATION_ACTIVITY);
            }
        });

        ivMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ivNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
                startActivity(intent);
            }
        });

        ivWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+web));
                startActivity(intent);
            }
        });

        ivLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?="+location));
                startActivity(intent);
            }
        });
    }
}

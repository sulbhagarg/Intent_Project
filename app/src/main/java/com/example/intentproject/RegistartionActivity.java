package com.example.intentproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class RegistartionActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etName, etNumber, etWebsite, etLocation;
    ImageView ivHappy, ivNeutral, ivSad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registartion);

        etName = findViewById(R.id.etName);
        etNumber = findViewById(R.id.etNumber);
        etWebsite = findViewById(R.id.etWebsite);
        etLocation = findViewById(R.id.etLocation);
        ivHappy = findViewById(R.id.ivHappy);
        ivNeutral = findViewById(R.id.ivNeutral);
        ivSad = findViewById(R.id.ivSad);

        ivHappy.setOnClickListener(this);
        ivNeutral.setOnClickListener(this);
        ivSad.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(etName.getText().toString().isEmpty() || etNumber.getText().toString().isEmpty() ||
                etWebsite.getText().toString().isEmpty() || etLocation.getText().toString().isEmpty())
        {
            Toast.makeText(RegistartionActivity.this, "Please enter all the fields!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent intent = new Intent();

            intent.putExtra("name", etName.getText().toString().trim());
            intent.putExtra("number", etNumber.getText().toString().trim());
            intent.putExtra("website", etWebsite.getText().toString().trim());
            intent.putExtra("location", etLocation.getText().toString().trim());

            if(view.getId() == R.id.ivHappy)
            {
                intent.putExtra("mood", "happy");
            }
            else if(view.getId() == R.id.ivNeutral)
            {
                intent.putExtra("mood", "neutral");
            }
            else
            {
                intent.putExtra("mood", "sad");
            }
            setResult(RESULT_OK, intent);
            RegistartionActivity.this.finish();
        }

    }
}

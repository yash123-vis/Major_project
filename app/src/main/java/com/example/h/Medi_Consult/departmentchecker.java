package com.example.h.Medi_Consult;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.h.R;

public class departmentchecker extends AppCompatActivity {

    EditText nametext;
    EditText agetext;
    ImageView enter;
    RadioButton male;
    RadioButton female;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.department_checker);

        nametext = findViewById(R.id.nametext);
        agetext = findViewById(R.id.agetext);
        enter = findViewById(R.id.imageView7);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        rg=findViewById(R.id.rg1);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nametext.getText().toString();
                String age = agetext.getText().toString();

                if (name.matches("")) {
                    Toast.makeText(departmentchecker.this, "Name cannot be empty.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (age.matches("")) {
                    Toast.makeText(departmentchecker.this, "Age cannot be empty.", Toast.LENGTH_SHORT).show();
                    return;
                }

                String gender= new String();
                int id=rg.getCheckedRadioButtonId();
                switch(id)
                {
                    case R.id.male:
                        gender = "Mr.";
                        break;
                    case R.id.female:
                        gender = "Ms.";
                        break;
                }
                Intent symp = new Intent(departmentchecker.this,DepartmentActivity.class);
                symp.putExtra("name",name);
                symp.putExtra("gender",gender);
                startActivity(symp);

            }
        });
    }
}
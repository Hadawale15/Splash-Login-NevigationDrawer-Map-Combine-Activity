package com.example.nevigationdraweractivity2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    EditText username_obj,pass_obj;
    Button login_obj,Sign_obj;

    public static final String Fix_Username="admin";
    public static final String Fix_Password="password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        login_obj=findViewById(R.id.login_id);
        username_obj=findViewById(R.id.username);
        pass_obj=findViewById(R.id.password);


        login_obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username_str=username_obj.getText().toString();
                String Password_str=pass_obj.getText().toString();

                if(Username_str.equals(Fix_Username)&&Password_str.equals(Fix_Password)){

                    Intent intent=new Intent(Login.this,MainActivity.class);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(Login.this, "Please enter valid information", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
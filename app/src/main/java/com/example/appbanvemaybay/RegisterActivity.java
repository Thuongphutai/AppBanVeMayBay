package com.example.appbanvemaybay;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.ktx.Firebase;

public class RegisterActivity extends AppCompatActivity {

    EditText edtEmail,edtPassword1,edtPassword2,edtPhone,edtSex,edtBirthDay;
    Button btnRegister;
    TextView tvYesAccount;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth=FirebaseAuth.getInstance();
        btnRegister=findViewById(R.id.btnRegister);
        edtEmail=findViewById(R.id.edtEmail);
        edtPassword1=findViewById(R.id.edtPassword1);
        edtPassword2=findViewById(R.id.edtPassword2);
        edtPhone=findViewById(R.id.edtSDT);
        edtSex=findViewById(R.id.edtGioiTinh);
        edtBirthDay=findViewById(R.id.edtNgaySinh);
        tvYesAccount=findViewById(R.id.tvYesAccount);
        tvYesAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,password1,password2;
                email=String.valueOf(edtEmail.getText());
                password1=String.valueOf(edtPassword1.getText());
                password2=String.valueOf(edtPassword2.getText());
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(RegisterActivity.this, "Nhập Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password1)||TextUtils.isEmpty(password2)){
                    Toast.makeText(RegisterActivity.this, "Nhập Mật Khẩu", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email, password1)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(RegisterActivity.this, "Đăng ký tài khoản thành công",
                                            Toast.LENGTH_LONG).show();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(RegisterActivity.this, "Đăng ký tài khoản thất bại",
                                            Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });
    }
}
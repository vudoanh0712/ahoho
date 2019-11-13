package com.example.ahoho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.ahoho.data.DBManager;
import com.example.ahoho.model.Student;

public class MainActivity extends AppCompatActivity {
    private EditText edtName;
    private        EditText editAdress;
    private        EditText edtPhoneNumber;
    private        EditText edtEmail;
    private        Button  btnSave;
    private        ListView lvStudent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DBManager dbManager=new DBManager(this);
        edtName =findViewById(R.id.edt_name);
        editAdress=findViewById(R.id.edt_address);
        edtEmail=findViewById(R.id.edt_email);
        edtPhoneNumber=findViewById(R.id.edt_number);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
                Student student = createStudent();
                if (student != null) {
                }
                    dbManager.addStudent(student);

            }
        });



    }
    private Student createStudent(){
        String name =edtName.getText().toString();
        String address=editAdress.getText().toString();
        String phoneNumber =edtPhoneNumber.getText()+"";
        String email =edtEmail.getText().toString();

        Student student=new Student(name,address,phoneNumber,email);


        return student;

    }
}

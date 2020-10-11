package com.example.activity.activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivitySecond extends AppCompatActivity {
    private EditText etContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        etContent = findViewById(R.id.et_content);

        Intent intent = getIntent();
//        String content = intent.getStringExtra("content");
//        int age = intent.getIntExtra("age",0);
//        etContent.setText("接收到的数据：" + content + "," + age );

        Bundle bundle = intent.getExtras();
        if(bundle !=null) {
            String content = bundle.getString("content");
            int age = bundle.getInt("age",0);
            Book book  = (Book) bundle.getSerializable("book");

            etContent.setText("接收到的数据：" + content + "," + age + "," + book.toString());
        }
        findViewById(R.id.btn_return).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("data",etContent.getText().toString());
                setResult(RESULT_OK,intent);
                ActivitySecond.this.finish();
            }
        });
    }
}
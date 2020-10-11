package com.example.activity.activityintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_simple).setOnClickListener(this);
        findViewById(R.id.btn_object).setOnClickListener(this);
        findViewById(R.id.btn_data_back).setOnClickListener(this);

        textView = findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_simple:
                Intent intent = new Intent(MainActivity.this,ActivitySecond.class);
                intent.putExtra("content",textView.getText().toString());
                intent.putExtra("age",20);
                startActivity(intent);
                break;
            case R.id.btn_object:
                 intent = new Intent(MainActivity.this,ActivitySecond.class);
                 Bundle bundle = new Bundle();
                 bundle.putString("content",textView.getText().toString());
                 bundle.putInt("age",20);
                 bundle.putSerializable("book",new Book(1,"123","python",18));
                 intent.putExtras(bundle);
                 startActivity(intent);
                break;
            case R.id.btn_data_back:
                intent = new Intent(MainActivity.this,ActivitySecond.class);
                startActivityForResult(intent,100);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode !=100 || data ==null) {
            Toast.makeText(this,"数据回传有问题",Toast.LENGTH_SHORT).show();
            return;
        }
        String content = data.getStringExtra("data");
        textView.setText("回传的值：" + content);
    }
}
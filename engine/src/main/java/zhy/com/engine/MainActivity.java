package zhy.com.engine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * 这个Activity名字迟早要改
 */
@Route(path = "/engine/Main")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainm);


        Intent intent = getIntent();
        int s = intent.getIntExtra("sdsd", 2);
        String n = intent.getStringExtra("sds");
        Toast.makeText(MainActivity.this, s + "/" + n, Toast.LENGTH_SHORT).show();
    }
}

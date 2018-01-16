package zhy.com.ourstory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.gyf.barlibrary.ImmersionBar;

import zhy.com.engine.util.LifeCycleUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){

        textView = findViewById(R.id.tv_tv);
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_tv:
                Bundle bundle = new Bundle();
                bundle.putInt("sdsd", 22);
                bundle.putString("sds", "张海洋");
                ARouter.getInstance().build("/engine/Main").with(bundle).navigation();
                break;
                default:
                    break;
        }
    }

}

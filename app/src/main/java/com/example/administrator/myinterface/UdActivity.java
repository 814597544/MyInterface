package com.example.administrator.myinterface;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2015/4/20.
 */
public class UdActivity extends Activity {
    Button ud;
    Inteface inteface;
    MainActivity mainActivity;
    MyApplication myApplication;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);

        myApplication= (MyApplication) getApplication();
        mainActivity=(MainActivity)myApplication.getContext();
        inteface=(Inteface)mainActivity;
        ud= (Button) findViewById(R.id.ud);
        ud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inteface.updateName("科比");
                finish();
            }
        });
    }
}

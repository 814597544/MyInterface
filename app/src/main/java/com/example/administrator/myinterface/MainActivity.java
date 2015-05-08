package com.example.administrator.myinterface;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends Activity implements Inteface{

    TextView name;
    Button next;
    MyApplication myApplication;
    ImageButton ib1,ib2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myApplication= (MyApplication) getApplication();
        ib1= (ImageButton) findViewById(R.id.ib1);
        ib2= (ImageButton) findViewById(R.id.ib2);
        name= (TextView) findViewById(R.id.name);
        next= (Button) findViewById(R.id.next);
        myApplication.setContext(this);
        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

               /* Intent intent=new Intent(MainActivity.this,UdActivity.class);
                startActivity(intent);*/

                /*----从一个应用启动另一个应用---------*/

                //获取手机中每个应用的详细信息
                PackageManager packageManager = MainActivity.this.getPackageManager();
                List<PackageInfo> packageInfoList = packageManager.getInstalledPackages(0);

                Intent intent=new Intent();
                boolean isPresence = false;//是否安装需要打开的软件
                for (int i = 0; i < packageInfoList.size(); i++) {
                    PackageInfo pak = (PackageInfo) packageInfoList.get(i);


                    //打印手机中每个应用的名字和包名
                    Log.e("apkName+packge", pak.applicationInfo.loadLabel(packageManager).toString()+"-----"+pak.applicationInfo.packageName);

                    if (pak.applicationInfo.packageName.equals("com.example.administrator.mygirl")) {
                        isPresence = true;
                        break ;
                    }
                }
                if(isPresence){
                    //打开的应用
                    intent =packageManager.getLaunchIntentForPackage("app.emcc_selfcontrol_android");

                }else{
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
                }
                startActivity(intent);
            }
        });


        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ib1.setVisibility(View.GONE);
                ib2.setVisibility(View.VISIBLE);
            }
        });
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ib2.setVisibility(View.GONE);
                ib1.setVisibility(View.VISIBLE);
            }
        });



    }



    @Override
    public void updateName(String s) {
        Log.e("s",s);
        name.setText(s);
    }
}

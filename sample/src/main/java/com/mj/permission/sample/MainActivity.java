package com.mj.permission.sample;

import android.Manifest;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mj.permission.DynamicPermissionEmitter;
import com.mj.permission.DynamicPermissionEntity;

import java.util.Map;

public class MainActivity extends FragmentActivity {

    private DynamicPermissionEmitter permissionEmitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        permissionEmitter = new DynamicPermissionEmitter(this);
        findViewById(R.id.tv_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                permissionEmitter.emitterPermission(new DynamicPermissionEmitter.ApplyPermissionsCallback() {
                    @Override
                    public void applyPermissionResult(Map<String, DynamicPermissionEntity> permissionEntityMap) {
                        DynamicPermissionEntity dynamicPermissionEntity = permissionEntityMap.get(Manifest.permission.WRITE_EXTERNAL_STORAGE);
                        if (dynamicPermissionEntity.isGranted()) {
                            Toast.makeText(MainActivity.this, "允许，可以搞事情了", Toast.LENGTH_LONG).show();
                        } else if (dynamicPermissionEntity.shouldShowRequestPermissionRational()) {
                            Toast.makeText(MainActivity.this, "勾选不在提示，且拒绝", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this, "残忍拒绝", Toast.LENGTH_LONG).show();
                        }
                    }
                }, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            }
        });
    }
}

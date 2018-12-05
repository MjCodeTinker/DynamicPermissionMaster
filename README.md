# DynamicPermissionMaster
动态权限框架

> 使用
```
创建一个实例

private DynamicPermissionEmitter permissionEmitter = new DynamicPermissionEmitter(this);

this指: FragmentActivity 或 v4包下的 Fragment

String [] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};

permissionEmitter.emitterPermission(new DynamicPermissionEmitter.ApplyPermissionsCallback() {
                    @Override
                    public void applyPermissionResult(Map<String, DynamicPermissionEntity> permissionEntityMap) {
                        DynamicPermissionEntity dynamicPermissionEntity = permissionEntityMap.get(Manifest.permission.WRITE_EXTERNAL_STORAGE);
                        if (dynamicPermissionEntity.isGranted()) {
                            // 权限允许
                            Toast.makeText(MainActivity.this, "允许，可以搞事情了", Toast.LENGTH_LONG).show();
                        } else if (dynamicPermissionEntity.shouldShowRequestPermissionRational()) {
                            // 勾选了不在提示并且拒绝
                            Toast.makeText(MainActivity.this, "勾选不在提示，且拒绝", Toast.LENGTH_LONG).show();
                        } else {
                            // 拒绝
                            Toast.makeText(MainActivity.this, "残忍拒绝", Toast.LENGTH_LONG).show();
                        }
                    }
                }, permissions);

```

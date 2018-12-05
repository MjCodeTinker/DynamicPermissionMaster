package com.mj.permission;

/**
 * Author      : MJ
 * Date        : 2018/12/4/15:30
 * Email       : miaojian_666@126.com
 * Description : 权限的实体类
 */

public final class DynamicPermissionEntity {


    //拒绝了此权限
    public static final int PERMISSION_DENIED = 1;
    //授予了权限
    public static final int PERMISSION_GRANTED = 2;
    //拒绝了此权限并且勾选了不在提示
    public static final int PERMISSION_DENIED_AND_SELECTED_NO_PROMPT = 3;
    //不能处理的权限 例如android 6.0 以下手机，请用try catch 捕获无权限的异常
    public static final int PERMISSION_UN_HANDLE = 4;

    // 权限名称
    private String permissionName;
    // 权限状态,默认为被拒绝的权限
    private int permissionState = PERMISSION_DENIED;

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public int getPermissionState() {
        return permissionState;
    }

    public void setPermissionState(int permissionState) {
        this.permissionState = permissionState;
    }

    /**
     * 6.0 以下也默认为已经有权限
     *
     * @return 是否授予了某项权限
     */
    public boolean isGranted() {
        return permissionState == PERMISSION_GRANTED || permissionState == PERMISSION_UN_HANDLE;
    }

    /**
     * 用户已经勾选了不在提示
     *
     * @return 是否应该给用户一个友好的提示
     */
    public boolean shouldShowRequestPermissionRational() {
        return permissionState == PERMISSION_DENIED_AND_SELECTED_NO_PROMPT;
    }

    @Override
    public String toString() {
        return "DynamicPermissionEntity{" +
                "permissionName='" + permissionName + '\'' +
                ", permissionState=" + permissionState +
                '}';
    }
}

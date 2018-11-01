package com.apeng.permissions;

/**
 *  @dec  动态申请的权限没有在清单文件中注册会抛出的异常
 *  @author apeng
 *  @date  2018/11/1 16:40
 */
final class ManifestRegisterException extends RuntimeException {

    ManifestRegisterException(String permission) {
        super(permission == null ?
                "No permissions are registered in the manifest file" :
                (permission + ": Permissions are not registered in the manifest file"));
    }
}
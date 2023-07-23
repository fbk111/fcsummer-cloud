package com.facility.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Title: FileStorageRuntimeExpection
 * @Author Fcsummer
 * @Package com.facility.exception
 * @Date 2023/7/22 10:42
 * @description: 文件储存平台运行异常类
 */
public class FileStorageRuntimeException extends RuntimeException {
    public FileStorageRuntimeException() {
    }

    public FileStorageRuntimeException(String message) {
        super(message);
    }

    public FileStorageRuntimeException(String message,Throwable cause) {
        super(message,cause);
    }

    public FileStorageRuntimeException(Throwable cause) {
        super(cause);
    }

    public FileStorageRuntimeException(String message,Throwable cause,boolean enableSuppression,boolean writableStackTrace) {
        super(message,cause,enableSuppression,writableStackTrace);
    }
}

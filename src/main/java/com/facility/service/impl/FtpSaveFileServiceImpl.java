package com.facility.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.facility.domain.DelEnum;
import com.facility.domain.FileInfo;
import com.facility.exception.FileStorageRuntimeException;
import com.facility.service.FtpSaveFileService;
import com.facility.stram.MultipartFileWrapper;
import com.facility.stram.UploadPretreatment;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service

public class FtpSaveFileServiceImpl implements FtpSaveFileService {
    @Override
    public void uploadFile(MultipartFile multipartFile) {

    }

    @Override
    public void uploadFiles(MultipartFile[] multipartFile) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(multipartFile.length, multipartFile.length, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(), new ThreadPoolExecutor.AbortPolicy());
        for (MultipartFile file : multipartFile) {
            threadPoolExecutor.execute(()->{
                this.uploadFile(file);
            });
        }
    }

    private FileInfo of(MultipartFile multipartFile){
        FileInfo fileInfo = new FileInfo();
    }

    private FileInfo upload(UploadPretreatment pre){
        MultipartFileWrapper fileWrapper = pre.getFileWrapper();
        if(fileWrapper==null) throw new FileStorageRuntimeException();
        FileInfo fileInfo = new FileInfo();
        fileInfo.setCreateTime(DateUtil.date());
        fileInfo.setFileSize(fileWrapper.getSize());
        fileInfo.setFileId(IdUtil.randomUUID());
//        fileInfo.setFileName(fileWrapper.getName());
        fileInfo.setDelFlag(DelEnum.NOT_DELETE.getDelFlag());
        if(StrUtil.isNotBlank(fileWrapper.getName())) fileInfo.setFileName(fileWrapper.getName());
//        else fileInfo.setFileName();
       return null;
    }
}

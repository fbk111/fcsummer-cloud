package com.facility.service;


import org.springframework.web.multipart.MultipartFile;

public interface FtpSaveFileService {


    void uploadFile(MultipartFile multipartFile);

    void uploadFiles(MultipartFile[] multipartFile);

}

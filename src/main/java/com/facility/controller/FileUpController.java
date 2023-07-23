package com.facility.controller;

import com.facility.domain.FileInfo;
import com.facility.result.ResultInfo;
import com.facility.service.FtpSaveFileService;
import com.facility.utils.ArraysUtils;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/upload")
@AllArgsConstructor
public class FileUpController {

    private FtpSaveFileService ftpSaveFileService;
    @PostMapping("uploadFile")
    public ResultInfo uploadFiles(@RequestPart("files") MultipartFile[] multipartFile){
        log.info("demo{}",multipartFile);
        if(ArraysUtils.isArrayNullOrZero(multipartFile)) {
            throw new RuntimeException("空文件");
        }
        if(multipartFile.length>1) ftpSaveFileService.uploadFiles(multipartFile);
        else ftpSaveFileService.uploadFile(multipartFile[0]);
        return new ResultInfo();
    }

}

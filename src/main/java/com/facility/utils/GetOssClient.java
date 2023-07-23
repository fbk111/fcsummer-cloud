package com.facility.utils;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import org.springframework.beans.factory.annotation.Value;

public class GetOssClient {

    @Value("${aliyun.oss.endpoint}")
    private static  String endpoint;

    @Value("${aliyun.oss.bucket}")
    private static String bucket;
    @Value("${aliyun.oss.accessKeyId}")
    private static String accessKeyId;
    @Value("${aliyun.oss.accessKeySecret}")
    private static String accessKeySecret;

    public static OSSClient getOssClient(){
        return new OSSClient(endpoint,new DefaultCredentialProvider(accessKeyId,accessKeySecret),new ClientConfiguration());
    }
}

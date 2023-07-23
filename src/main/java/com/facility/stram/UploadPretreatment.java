package com.facility.stram;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 进行文件预处理
 */
@Data
@Accessors(chain = true)
public class UploadPretreatment {

private String plateForm;

private MultipartFileWrapper fileWrapper;



}

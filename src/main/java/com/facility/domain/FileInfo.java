package com.facility.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FileInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 文件id */
    private String fileId;

    /** 用户id */
    private String userId;

    /** 文件MD5 */
    private String fileMd5;

    /** 父级id */
    private String filePid;

    /** 文件大小 */
    private Long fileSize;

    /** 文件名称 */
    private String fileName;

    /** $column.columnComment */
    private String fileCover;

    /** 文件名称 */
    private String filePath;

    private Date createTime;

    /** 更新时间 */
    private Date lastUpdateTime;

    /** $column.columnComment */
    private Integer folderType;

    /** $column.columnComment */
    private Integer fileCategory;

    /** $column.columnComment */
    private Integer fileType;

    /** $column.columnComment */
    private Integer status;

    /** $column.columnComment */
    private Date recoveryTime;

    /** $column.columnComment */
    private Integer delFlag;

}

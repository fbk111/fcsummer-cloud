package com.facility;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.ftp.Ftp;
import cn.hutool.extra.ftp.FtpMode;
import org.apache.commons.net.ftp.FTP;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.nio.charset.Charset;

@SpringBootTest
class ForFacilityApplicationTests {

	private Ftp ftp;

	@Test
	void contextLoads() throws IOException {
		ftp=new Ftp("106.55.247.127",21,"fbkftp1","kun20021127");
		ftp.setMode(FtpMode.Passive);
		//进入远程目录
		ftp.cd("/fbkftp1");
//上传本地文件
		ftp.upload("/fbkftp1", FileUtil.file("e:/test.jpg"));
//下载远程文件
		ftp.download("/fbkftp1", "a.java", FileUtil.file("d:/a.java"));

//关闭连接
		ftp.close();
	}

}

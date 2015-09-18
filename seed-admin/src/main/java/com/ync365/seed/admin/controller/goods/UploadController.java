package com.ync365.seed.admin.controller.goods;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ync365.seed.bussiness.modules.goods.biz.PicInfoBiz;
import com.ync365.seed.bussiness.modules.goods.entity.PicInfo;


/**
 * 商品品牌
 * 
 * @author Awizard
 *
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
	
	@Autowired
	PicInfoBiz picInfoBiz;
	@RequestMapping("/uploadPic")
	public void uploadPic(HttpServletRequest request , PrintWriter out,HttpServletResponse response,String id,String type) throws IOException{
		System.out.println("上传文件开始.........");
		//不设ContentType返回值会多一个<pre></pre>
		response.setContentType("text/html;charset=UTF-8");  
		//强制转换request
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) request;
		//获得文件
		Iterator<String> iter = mr.getFileNames();
		if(iter.hasNext()){
			
			String fileInputName = iter.next();
			MultipartFile mf = mr.getFile(fileInputName);
			
			//获得文件的字节数组
			byte[] byteArr = mf.getBytes();
			
			String fileName = "";
			if(StringUtils.isNoneBlank(id)){
				fileName = id.toLowerCase();
			}else{
				//生成UUID
				UUID uuid=UUID.randomUUID();
				fileName=uuid.toString().toLowerCase();
			}
		
			String files01=fileName.substring(0,2);
			String files02=fileName.substring(2,4);
			String files03=fileName.substring(4,6);
			//获得原始文件名
			String oriFileName = mf.getOriginalFilename().toLowerCase();
			String suffix = oriFileName.substring(oriFileName.lastIndexOf("."));
			//获得上传文件的绝对路径
			String filePath=  request.getContextPath();
			//四层文件夹目录
			String files="/upload/"+files01+"/"+files02+"/"+files03+"/";
			String realPath= filePath+files+oriFileName;
			String relativePath =files+oriFileName;
			System.out.println(request.getSession().getServletContext().getRealPath(relativePath));
			File file=new File(request.getSession().getServletContext().getRealPath(relativePath));
			
			if(!file.exists()){
				file.mkdirs();
			}
			
			mf.transferTo(file);
			System.out.println("上传成功.......");
			
			//ajax返回多个值的时候要使用JSON
			JSONObject jo = new JSONObject();
			jo.accumulate("uuid",fileName );
			jo.accumulate("realPath", realPath);
			jo.accumulate("relativePath", relativePath);
			//{"realPath"："http://.....", "relativePath":"/upload/..."}
			String result = jo.toString();
			out.write(result);
			
			//写数据库
			PicInfo picInfo = new PicInfo();
			picInfo.setPicName(realPath);
			picInfo.setPicType(type);
			picInfo.setUuid(fileName);
			picInfoBiz.insert(picInfo);
			
		}
	}
}

package com.fleaMarket.carouselManager.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.fleaMarket.carouselManager.service.CarouselManagerService;
import com.fleaMarket.domain.carousel;
import com.fleaMarket.domain.goodsInfo;
import com.fleaMarket.domain.picture;
import com.fleaMarket.domain.user;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 轮播图管理的Action层
 */
public class CarouselManagerAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;

	private CarouselManagerService carouselManagerService;

	public CarouselManagerService getCarouselManagerService() {
		return carouselManagerService;
	}

	public void setCarouselManagerService(CarouselManagerService carouselManagerService) {
		this.carouselManagerService = carouselManagerService;
	}

	/**
	 * 删除轮播图的数组
	 */
	private String idList;

	private goodsInfo goodsInfo;

	private String pictrueMap;
	/**
	 * 用户上传图片
	 * 
	 * @return
	 */
	private File file;
	private String fileFileName; // 文件名
	private String fileContentType; // 文件类型
	private picture picture; // 单个图片
	/**
	 * 管理员上传轮播图
	 * 
	 * @return
	 */
	private carousel carousel;

	private user user;//当前用户
	
	public String getIdList() {
		return idList;
	}

	public void setIdList(String idList) {
		this.idList = idList;
	}

	public goodsInfo getGoodsInfo() {
		return goodsInfo;
	}

	public void setGoodsInfo(goodsInfo goodsInfo) {
		this.goodsInfo = goodsInfo;
	}

	public String getPictrueMap() {
		return pictrueMap;
	}

	public void setPictrueMap(String pictrueMap) {
		this.pictrueMap = pictrueMap;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public picture getPicture() {
		return picture;
	}

	public void setPicture(picture picture) {
		this.picture = picture;
	}

	public carousel getCarousel() {
		return carousel;
	}

	public void setCarousel(carousel carousel) {
		this.carousel = carousel;
	}

	
	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	/**
	 * 实现request和response
	 */
	private HttpServletResponse response;

	private HttpServletRequest request;

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * 实现结束
	 */
	public String fdfd() {
		System.out.println();
		return "fdf";
	}

	/**
	 * 添加轮播图
	 * 
	 * @throws IOException
	 */
	public void addCarousel() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		response.setContentType("text/html;charset=utf-8");
		String add = carouselManagerService.addCarousel();
		response.getWriter().write(gson.toJson(add));
	}

	/**
	 * 删除轮播图
	 * 
	 * @throws IOException
	 */
	public void deleteCarousel() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		response.setContentType("text/html;charset=utf-8");
		String delete = carouselManagerService.deleteCarousel(idList);
		response.getWriter().write(gson.toJson(delete));
	}

	/**
	 * 图片转为二进制流输出
	 * 
	 * @return
	 * @throws IOException
	 */
	public String IoReadImage() throws IOException {
//		System.out.println("====ppp");
		fileFileName = new String(fileFileName.getBytes("ISO8859-1"), "UTF-8");// 解决图片中文路径乱码
		String linkurl = "D:\\Aupload\\test1\\" + fileFileName;
		FileInputStream in = new FileInputStream(linkurl);
		ServletOutputStream out = null;
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("image/png");
		try {
			out = response.getOutputStream();
			// 读取文件流
			int len = 0;
			byte[] buffer = new byte[1024 * 10];
			while ((len = in.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
			in.close();
		}
		return null;
	}

	// 上传文件，及保存文件信息到数据库
	public void uploadAndSavePic() {
		String code = ""; // 0上传成功 1上传失败
		String result = ""; // 返回结果
		String res = ""; // 将belongId传给前台
		String picId = "";
		try {
			String folderpath = "D:/Aupload/test1";
			if (file != null) {
				if (file.length() <= 50 * 1024 * 1024) {
					String scrol_id = java.util.UUID.randomUUID().toString(); // 采用时间+UUID的方式
					String path = ServletActionContext.getServletContext().getRealPath("/WEB-INF/upload");
					// System.out.println("111:"+path);
					// System.out.println("222:"+scrol_id);
					File uploadFile = new File(path);
					if (!uploadFile.exists() && !uploadFile.isDirectory()) {
						// System.out.println("文件夹路径不存在，创建路径:" + folderpath);
						uploadFile.mkdirs();
					} else {
						// System.out.println("文件夹路径存在:" + uploadFile);
					}
					String filename = path + File.separator + fileFileName;
					fileFileName = scrol_id + fileFileName;
					FileInputStream in = new FileInputStream(file);
					FileOutputStream out = new FileOutputStream(filename);
					byte[] b = new byte[1024];
					int len = 0;
					while ((len = in.read(b)) > 0) {
						out.write(b, 0, len);
					}
					out.close();
					// System.out.println("filename==" + filename);
					File folder = new File(folderpath);
					if (!folder.exists() && !folder.isDirectory()) {
						// System.out.println("文件夹路径不存在，创建路径:" + folderpath);
						folder.mkdirs();
					} else {
						// System.out.println("文件夹路径存在:" + folderpath);
					}
					FileUtils.copyFile(file, new File(folderpath, fileFileName));
					code = "0";
					result = "uploadsuccess";
				}
			} else {
				result = "uploaderror";
				code = "1";
				// System.out.println("上传文件发生错误");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String belongId = "";
		picture.setPicture_name(fileFileName);
		System.out.println(picture);
		carouselManagerService.addPictrues(picture);
		picId = picture.getPicture_id();
		System.out.println("给我输出这个对象" + picture);
		System.out.println("输出下：" + picId);
		res = "{\"code\":\" " + code + " \",\"msg\":\"" + result + "\",\"belongId\":\" " + belongId
				+ " \",\"picId\":\" " + picId + "\"}";
		// 返回前端信息
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().write(gson.toJson(res));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("CcdmwcC:" + picture);

	}

	// 添加和完善信息
	public void addAndComplete() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		response.setContentType("text/html;charset=utf-8");
		// 同时添加作品信息和补充图集信息
		String result = carouselManagerService.addAndComplete(goodsInfo, pictrueMap);
		try {
			// System.out.println("----------------------------------------------:"+result);
			response.getWriter().write(gson.toJson(result));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 上传和保存轮播图
	public void uploadAndSaveCarousel() {
		String code = ""; // 0上传成功 1上传失败
		String result = ""; // 返回结果
		String res = ""; // 将所有的传给前台
		try {
			String folderpath = "D:/Aupload/test1";
			if (file != null) {
				if (file.length() <= 50 * 1024 * 1024) {
					String scrol_id = java.util.UUID.randomUUID().toString(); // 采用时间+UUID的方式
					String path = ServletActionContext.getServletContext().getRealPath("/WEB-INF/upload");
					// System.out.println("333:"+path);
					// System.out.println("444:"+scrol_id);
					File uploadFile = new File(path);
					if (!uploadFile.exists() && !uploadFile.isDirectory()) {
						// System.out.println("文件夹路径不存在，创建路径:" + folderpath);
						uploadFile.mkdirs();
					} else {
						// System.out.println("文件夹路径存在:" + uploadFile);
					}
					String filename = path + File.separator + fileFileName;
					fileFileName = scrol_id + fileFileName;
					FileInputStream in = new FileInputStream(file);
					FileOutputStream out = new FileOutputStream(filename);
					byte[] b = new byte[1024];
					int len = 0;
					while ((len = in.read(b)) > 0) {
						out.write(b, 0, len);
					}
					out.close();
					// System.out.println("filename==" + filename);
					File folder = new File(folderpath);
					if (!folder.exists() && !folder.isDirectory()) {
						// System.out.println("文件夹路径不存在，创建路径:" + folderpath);
						folder.mkdirs();
					} else {
						// System.out.println("文件夹路径存在:" + folderpath);
					}
					FileUtils.copyFile(file, new File(folderpath, fileFileName));
					code = "0";
					result = "uploadsuccess";
				}
			} else {
				result = "uploaderror";
				code = "1";
				// System.out.println("上传文件发生错误");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("给我输出这个对象" + picture);
		System.out.println("输出下：" + idList);

		carousel.setCarousel_picture(fileFileName);
		System.out.println(picture);
		carouselManagerService.addCarousel(carousel);
		res = "{\"code\":\" " + code + " \",\"msg\":\"" + result + "\"}";
		// 返回前端信息
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().write(gson.toJson(res));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("CcdmwcC:" + carousel);

	}

	// 查询所有轮播图
	public void findCarousels() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		response.setContentType("text/html;charset=utf-8");
		List<carousel> listCarousel = carouselManagerService.findCarousels();
		response.getWriter().write(gson.toJson(listCarousel));
	}

	// 用户上传头像
	public void uploadPic()  {
		System.out.println("????<><><"+ user);
		String code = ""; // 0上传成功 1上传失败
		String res = "";
		String result = "";
		System.out.println("---------------------------------");
		try {
			String folderpath = "D:/Aupload/test1";
			if (file != null) {
				if (file.length() <= 50 * 1024 * 1024) {
					String scrol_id = java.util.UUID.randomUUID().toString(); // 采用时间+UUID的方式
					String path = ServletActionContext.getServletContext().getRealPath("/WEB-INF/upload");
					File uploadFile = new File(path);
					if (!uploadFile.exists() && !uploadFile.isDirectory()) {
						// System.out.println("文件夹路径不存在，创建路径:" + folderpath);
						uploadFile.mkdirs();
					} else {
						// System.out.println("文件夹路径存在:" + uploadFile);
					}
					String filename = path + File.separator + fileFileName;
					fileFileName = scrol_id + fileFileName;
					FileInputStream in = new FileInputStream(file);
					FileOutputStream out = new FileOutputStream(filename);
					byte[] b = new byte[1024];
					int len = 0;
					while ((len = in.read(b)) > 0) {
						out.write(b, 0, len);
					}
					out.close();
					 System.out.println("filename==" + filename);
					File folder = new File(folderpath);
					if (!folder.exists() && !folder.isDirectory()) {
						 System.out.println("文件夹路径不存在，创建路径:" + folderpath);
						folder.mkdirs();
					} else {
						 System.out.println("文件夹路径存在:" + folderpath);
					}
					FileUtils.copyFile(file, new File(folderpath, fileFileName));
					code = "0";
					result = "uploadsuccess";
				}
			} else {
				result = "uploaderror";
				code = "1";
				// System.out.println("上传文件发生错误");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		user.setHeadportrait(fileFileName);
		carouselManagerService.addHeadportrait(user,fileFileName);
		res = "{\"code\":\" " + code + " \",\"msg\":\"" + result + "\",\"fileFileName\":\"" + fileFileName + " \"}";
		// 返回前端信息
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		response.setContentType("text/html;charset=utf-8");
//		System.out.println("SSSS"+res);
		try {
			response.getWriter().write(gson.toJson(res));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

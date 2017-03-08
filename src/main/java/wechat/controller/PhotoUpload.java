package wechat.controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import wechat.common.Constant;
import wechat.common.ReturnResult;
import wechat.service.IGoodsImgService;
import wechat.service.ISwzlLostGoodsService;
import wechat.service.imp.GoodsImgServiceImpl;
import wechat.util.MyStringUtil;


@Controller
@RequestMapping("/img")
public class PhotoUpload {
	public static final String AVATRO_STR = "avator";
	public static final String PHOTO = "photo";
	public static final int AVATOR_SIZE =1048576;
	public static final int AVATOR_HEIGHT_AND_WEIGHT=100;
	public static final Logger L = Logger.getLogger(PhotoUpload.class);

	@Autowired
	private IGoodsImgService GoodsImgService;
	// 文件上传
	@RequestMapping("/uploadFile")
	public static @ResponseBody ReturnResult uploadFile(@RequestParam MultipartFile file, HttpServletRequest request) {
		ReturnResult rr = new ReturnResult();
		try {
			//从配置文件中获取图片存放的地址
			InputStream in = PhotoUpload.class.getResourceAsStream("/img.properties");
			 Properties p  = new Properties();
			 p.load(in);
			 String savePath = (String) p.get("IMG_URL")+PhotoUpload.PHOTO+"/"+PhotoUpload.getNowDate();
			 
			 String fileName = file.getOriginalFilename();
			 /*新建个文件 如果不存在就创建新的*/
			 File tempFile = new File(savePath, new Date().getTime() + String.valueOf(fileName));
				if (!tempFile.getParentFile().exists()) {
					tempFile.getParentFile().mkdirs();
				}
				if (!tempFile.exists()) {
					tempFile.createNewFile();
				}
				
			 //如果图片大于1m 则就压缩存储
			  int x =(int) (file.getSize()/AVATOR_SIZE);
			if(x >1) {
				L.info("上传的图片大小为:"+file.getSize()+"，超过2M，将进行压缩");
				smallImage(file,tempFile);
			}else {
				file.transferTo(tempFile);
			}
			rr.setState(Constant.success);
			rr.setMsg("上传成功");
			rr.getData().put("url", getImgUrl(tempFile.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
			rr.setMsg("上传失败");
			rr.setState(Constant.fail);
		}
		return rr;
	}
	/**
	 * 将用户头像存放的地址经过字符串的处理后存进数据用的
	 * @Title: getImgUrl 
	 * @param imgAllUrl
	 * @return  
	 * @author huangsx
	 * @date 2016年4月14日 下午3:08:06
	 */
	private static  String getImgUrl(String imgAllUrl){
		imgAllUrl = imgAllUrl.replaceAll("\\\\","/");
		String newUrl  = imgAllUrl.substring(imgAllUrl.indexOf(PhotoUpload.PHOTO)+PhotoUpload.PHOTO.length());
		//System.out.println(newUrl);
		return newUrl ;
	}
	
	/**
	 * 获取用户的头像 
	 * @Title: getAvator 
	 * @param url
	 * @param req
	 * @param resp
	 * @throws IOException  
	 * @author huangsx
	 * @date 2016年4月14日 下午12:14:42
	 */
	 @RequestMapping("/getImg")
	    public void getImager(String url, HttpServletRequest req, HttpServletResponse resp)
	            throws IOException {
		 InputStream in = getClass().getResourceAsStream("/img.properties");
		 Properties p  = new Properties();
		 p.load(in);
		 String ssss= (String) p.get("IMG_URL");
		 //看是以什么后缀结尾的图片，最后有个参数是要文件类型传到方法
		 String suffix = "";
		
		 url =ssss+PHOTO+url ;
		 //System.out.println("*******************"+url);
		 Image  image;
		 try {
			 image = ImageIO.read(new File(url));
			 suffix = url.substring(url.lastIndexOf(".")+1,url.length());
		} catch (IIOException e) {
			//如果没有上传的头像，使用服务器默认的头像
			/*String defaultAvator=req.getSession().getServletContext().getRealPath("WEB-INF/html/image/icon/gdzlh.jpg");			
			image = ImageIO.read(new File(defaultAvator));
			 suffix = defaultAvator.substring(defaultAvator.lastIndexOf(".")+1,defaultAvator.length());*/
			return ;
		}
	        // 禁止图像缓存。
	       // resp.setHeader("Pragma", "no-cache");
	       // resp.setHeader("Cache-Control", "no-cache");
	        resp.setDateHeader("Expires", 0);	 
	        resp.setContentType("image/jpeg");
	        // 将图像输出到Servlet输出流中。
	        ServletOutputStream sos = resp.getOutputStream();
	        ImageIO.write((RenderedImage) image, suffix, sos);
	        sos.close();
	    }
	  /** 
	     * 压缩图片尺寸 
	     *  
	     * @param src 
	     * @param max 
	     * @return 
	     * @throws IOException 
	     */  
	    private static String chageImage(MultipartFile srcFile, int max,File file) throws IOException {  
	  
            
	        BufferedImage im = ImageIO.read(srcFile.getInputStream());  
	        /* 原始图像的宽度和高度 */  
	        int width = im.getWidth();  
	        int height = im.getHeight();  
	        /* 调整后的图片的宽度和高度 */
	        
	        if (width > max) {  
	            double bl = max * 1.0 / width * 1.0;  
	            width = (int) (width * bl);  	         
	        }  
	        
	        if (height > max) {  
	            double bl = max * 1.0 / height * 1.0;  
	            height = (int) (height * bl);  
	        }  
	        /* 新生成结果图片 */  
	        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
	        result.getGraphics().drawImage(im.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
	        
//	        result.getGraphics().drawImage(im, 0, 0, 0, 0, null);
	        //文件后缀	
	        String fileName =file.getPath();
	        String suffix = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
	         
	        
	        ImageIO.write(result, suffix, file); 
	        return file.getPath();
	        
	        
	    }  
	    
	    
	    @RequestMapping("/updateImg")
		public @ResponseBody ReturnResult  updateUserImg(@RequestParam MultipartFile file, HttpServletRequest request){
			ReturnResult rr = this.uploadFile(file, request);
			if(Constant.success == rr.getState()){
				String imgUrl = (String) rr.getData().get("url");
				String imgId = GoodsImgService.insert(imgUrl);
				if(MyStringUtil.isEmpty(imgId)){
					rr.setMsg("插入数据库失败");
					rr.setState(Constant.fail);
				}
				rr.getData().put("imgId", imgId);
			}
			return rr;
		}
	    
	    
	    private static String smallImage(MultipartFile srcFile, File file) throws IOException {  
	  
	    	int x =(int) (srcFile.getSize()/AVATOR_SIZE);
	    	
	        BufferedImage im = ImageIO.read(srcFile.getInputStream());  
	        /* 原始图像的宽度和高度 */  
	        int width = im.getWidth();  
	        int height = im.getHeight();  
	        /* 调整后的图片的宽度和高度 */
	        
	        width = width / x ;
	        height = height  / x;
	          
	        /* 新生成结果图片 */  
	        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
	        //result.getGraphics().drawImage(im.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
	        
	        result.getGraphics().drawImage(im, 0, 0, width, height, null);
	        //文件后缀	
	        String fileName =file.getPath();
	        String suffix = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
	         
	        
	        ImageIO.write(result, suffix, file); 
	        return file.getPath();
	        
	        
	    }  
	  
	    private static String getNowDate(){
	    	Calendar cal = Calendar.getInstance();
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	    	return sdf.format(new Date());
	    }
}

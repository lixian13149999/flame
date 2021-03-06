package com.bcdbook.flame.common.config;

import java.util.Map;

import com.bcdbook.flame.common.context.ContextParameter;
import com.bcdbook.flame.common.util.PropertiesLoader;
import com.google.common.collect.Maps;


public class Global {
	/**
	 * 当前对象实例
	 */
	private static Global global = new Global();
	
	/**
	 * 保存全局属性值
	 */
	private static Map<String, String> map = Maps.newHashMap();
	
	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader loader = new PropertiesLoader("summer.properties");


	/**
	 * 正常状态
	 */
	public static final Integer DEL_FLAG_NORMAL = 1;
	/**
	 * 已删除状态
	 */
	public static final Integer DEL_FLAG_DELETE = 2;
	
	/**
	 * 显示/隐藏
	 */
	public static final Integer SHOW = 1;
	public static final Integer HIDE = 2;

	/**
	 * 是/否
	 */
	public static final Integer YES = 1;
	public static final Integer NO = 2;
	
	
	/**
	 * 对/错
	 */
	public static final Boolean TRUE = true;
	public static final Boolean FALSE = false;
	
	public static final String ONLINE_USER = "onlineUser";
	public static final String USER_MENUS = "userMenu";
	
	/**
	 * 上传文件基础虚拟路径
	 */
	public static final String USERFILES_BASE_URL = "/userfiles/";
	
	/**
	 * 获取当前对象实例
	 */
	public static Global getInstance() {
		return global;
	}
	
	/**
	 * 获取配置
	 * @see ${fns:getConfig('adminPath')}
	 */
	public static String getConfig(String key) {
		String value = map.get(key);
		if (value == null){
			value = loader.getProperty(key);
			map.put(key, value != null ? value : org.apache.commons.lang3.StringUtils.EMPTY);
		}
		return value;
	}
	
	/**
	 * 获取分页的默认页码
	 */
	public static int getStartPage(){
		String startPageStr = getConfig("page.startPage");
		return startPageStr!=null&&!startPageStr.equals("")?Integer.parseInt(startPageStr):1;
	}

	/**
	 * 获取分页的默认每页大小
	 */
	public static int getPageSize(){
		String pageSizeStr = getConfig("page.pageSize");
		return pageSizeStr!=null&&!pageSizeStr.equals("")?Integer.parseInt(pageSizeStr):1;
	}
	
	/**
	 * 获取管理端根路径
	 */
//	public static String getAdminPath() {
//		return getConfig("adminPath");
//	}
	
	/**
	 * 获取前端根路径
	 */
//	public static String getFrontPath() {
//		return getConfig("frontPath");
//	}
	
	/**
	 * 获取URL后缀
	 */
//	public static String getUrlSuffix() {
//		return getConfig("urlSuffix");
//	}
	
	/**
	 * 是否是演示模式，演示模式下不能修改用户、角色、密码、菜单、授权
	 */
//	public static Boolean isDemoMode() {
//		String dm = getConfig("demoMode");
//		return "true".equals(dm) || "1".equals(dm);
//	}
	
	/**
	 * 在修改系统用户和角色时是否同步到Activiti
	 */
//	public static Boolean isSynActivitiIndetity() {
//		String dm = getConfig("activiti.isSynActivitiIndetity");
//		return "true".equals(dm) || "1".equals(dm);
//	}
    
	/**
	 * 页面获取常量
	 * @see ${fns:getConst('YES')}
	 */
	public static Object getConst(String field) {
		try {
			return Global.class.getField(field).get(null);
		} catch (Exception e) {
			// 异常代表无配置，这里什么也不做
		}
		return null;
	}
	
	/**
	    * @Discription 获取项目路径的方法
	    * @author lason       
	    * @created 2016年9月16日 下午3:30:02     
	    * @return
	 */
	public static String getProjPash(){
		return ContextParameter.getContextPath();
	}

	/**
	 * 获取上传文件的根目录
	 * @return
	 */
//	public static String getUserfilesBaseDir() {
//		String dir = getConfig("userfiles.basedir");
//		if (StringUtils.isBlank(dir)){
//			try {
//				dir = ServletContextFactory.getServletContext().getRealPath("/");
//			} catch (Exception e) {
//				return "";
//			}
//		}
//		if(!dir.endsWith("/")) {
//			dir += "/";
//		}
////		System.out.println("userfiles.basedir: " + dir);
//		return dir;
//	}
	
    /**
     * 获取工程路径
     * @return
     */
//    public static String getProjectPath(){
//    	// 如果配置了工程路径，则直接返回，否则自动获取。
//		String projectPath = Global.getConfig("projectPath");
//		if (StringUtils.isNotBlank(projectPath)){
//			return projectPath;
//		}
//		try {
//			File file = new DefaultResourceLoader().getResource("").getFile();
//			if (file != null){
//				while(true){
//					File f = new File(file.getPath() + File.separator + "src" + File.separator + "main");
//					if (f == null || f.exists()){
//						break;
//					}
//					if (file.getParentFile() != null){
//						file = file.getParentFile();
//					}else{
//						break;
//					}
//				}
//				projectPath = file.toString();
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return projectPath;
//    }
}

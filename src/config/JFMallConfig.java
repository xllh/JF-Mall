package config;

import route.ActionRoutes;
import route.AdminRoutes;
import route.FrontRoutes;
import bean.*;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.render.ViewType;

public class JFMallConfig extends JFinalConfig{
	
	public void configPlugin(Plugins me) {
		//缓存相关
		me.add(new EhCachePlugin());
		//数据库访问相关
		C3p0Plugin c3p0 = new C3p0Plugin("jdbc:mysql://127.0.0.1/adouteam", "root", "root");
		if(!c3p0.start()){
			System.out.println("数据库启动失败！");
		}
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0);
		me.add(arp);
		arp.addMapping("adou_user", User.class);
		arp.addMapping("adou_blog", "id", Blog.class);
		arp.addMapping("adou_catalog", Catalog.class);
		arp.addMapping("adou_blog_catalog", BlogCatalog.class);
	}
	
	public void configInterceptor(Interceptors me) {
//		me.add(new AdminInterceptor());
	}
	
	public void configHandler(Handlers me) {}

	@Override
	public void configConstant(Constants constants) {
		constants.setDevMode(true);
		constants.setViewType(ViewType.JSP);
	}
	
	@Override
	public void configRoute(Routes routes) {
		routes.add(new FrontRoutes());
		routes.add(new AdminRoutes());
		routes.add(new ActionRoutes());
	}
	
	public void afterJFinalStart()
    {
		System.out.println("我现在光荣的打开JFinal，跟你打招呼~");
    }

    public void beforeJFinalStop()
    {
    	System.out.println("我现在光荣的关闭JFinal，跟你说再见~");
    }
}
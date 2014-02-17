package config;

import route.ActionRoutes;
import route.AdminRoutes;
import route.FrontRoutes;
import bean.Blog;
import bean.User;
import bean.New;

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
		C3p0Plugin c3p0 = new C3p0Plugin("jdbc:mysql://192.168.1.11/oschina", "root", "oschina");
		me.add(c3p0);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0);
		me.add(arp);
		arp.addMapping("osc_users", User.class);
		arp.addMapping("osc_news", New.class);
		arp.addMapping("osc_blogs", "id", Blog.class);
	}
	public void configInterceptor(Interceptors me) {}
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
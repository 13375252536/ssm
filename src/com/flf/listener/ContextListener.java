package com.flf.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @ClassName: ContextListener
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/10/8 16:51
 * @Version: 1.0
 */
public class ContextListener implements ServletContextListener {
    private java.util.Timer timer = null;
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        timer.cancel();
    }
}

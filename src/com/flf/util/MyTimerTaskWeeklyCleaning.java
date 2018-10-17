package com.flf.util;

import com.flf.controller.IndexController;

import java.util.TimerTask;

/**
 * @ClassName: MyTimerTask
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/10/8 16:37
 * @Version: 1.0
 */
public class MyTimerTaskWeeklyCleaning extends TimerTask {
    @Override
    public void run() {
        IndexController indexController = new IndexController();
        indexController.weeklyCleaning();
    }
}

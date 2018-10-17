package com.flf.util;

import com.flf.controller.IndexController;

import java.util.TimerTask;

/**
 * @ClassName: MyTimerTaskQuarterCleaning
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/10/8 17:22
 * @Version: 1.0
 */
public class MyTimerTaskQuarterCleaning  extends TimerTask {
    @Override
    public void run() {
        IndexController indexController = new IndexController();
        indexController.quarterCleaning();
    }
}

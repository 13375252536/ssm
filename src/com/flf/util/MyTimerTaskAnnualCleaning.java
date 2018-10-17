package com.flf.util;

import com.flf.controller.IndexController;

import java.util.TimerTask;

/**
 * @ClassName: MyTimerTaskAnnualCleaning
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/10/8 17:24
 * @Version: 1.0
 */
public class MyTimerTaskAnnualCleaning extends TimerTask {
    @Override
    public void run() {
        IndexController indexController = new IndexController();
        indexController.annualCleaning();
    }
}

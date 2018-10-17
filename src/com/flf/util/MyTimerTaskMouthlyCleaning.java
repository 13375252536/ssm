package com.flf.util;

import com.flf.controller.IndexController;

import java.util.TimerTask;

/**
 * @ClassName: MyTimerTaskMouthlyCleaning
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/10/8 17:17
 * @Version: 1.0
 */
public class MyTimerTaskMouthlyCleaning extends TimerTask {
    @Override
    public void run() {
        IndexController indexController = new IndexController();
        indexController.monthlyCleaning();
    }
}

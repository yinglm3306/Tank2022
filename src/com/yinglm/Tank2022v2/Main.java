package com.yinglm.Tank2022v2;

public class Main {
    public static void main(String[] args) {
        TankFrame tf= TankFrame.INSTANCE;

        new Thread(()->new Audio("audio/war1.wav").loop()).start();

        tf.setVisible(true);

        for(;;){
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            tf.repaint(); //repaint-paint 方法的调用
        }
    }
}

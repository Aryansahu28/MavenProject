package Bank.Management.System;

import java.util.Random;

public class test {
    public static void main(String[] args){

        Random ran = new Random();
        System.out.println(Math.abs((ran.nextLong()%9000000L)+417864132000L));
    }
}

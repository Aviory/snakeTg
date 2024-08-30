package org.example;

import java.awt.*;
import java.util.ArrayList;

public class Snake {
    static String[][] dataSnake = new String[10][10];
    static boolean isAlive;

    static Way currentWay = Way.RIGHT;
    static ArrayList<PointSnake> points = new ArrayList<>();

    private static void init(){
        points.add(new PointSnake(4,5));
        points.add(new PointSnake(5,5));
        points.add(new PointSnake(6,5));
       update();
    }
    private static void update(){

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                dataSnake[i][j]=" . ";
            }
        }
        for (int i = 0; i < points.size(); i++) {
            dataSnake[points.get(i).getY()][points.get(i).getX()] = "X";
        }

    }

    public static String parseSnake(){
        if(!isAlive){
            init();
            isAlive = true;
        }


        String response = "";
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                response+=dataSnake[i][j];
            }
            response+="\n";
        }
        return response;
    }

    public static void changeSide(String text) {
        switch (text){
            case "left":
                currentWay = Way.LEFT;
                break;
            case "top":
                currentWay = Way.LEFT;
        }
    }

    public static void move(){
        switch (currentWay){
            case RIGHT -> {
                for (int i = 0; i < points.size(); i++) {
                    points.get(i).setX(points.get(i).getX()+1);
                }
                break;
            }

            case LEFT -> {

            }
            case TOP -> {

            }
            case BOT -> {

            }
        }
        update();
    }



}

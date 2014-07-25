package com.IsoftStone.effective.ch03;

/**
 * 08
 * equals 传递性，如果一个对象等于第二个对象
 * 并且第二个对象又等于第三个对象，则第一个对象一定等于第三个对象
 * Created by Administrator on 2014/7/25.
 */
public class Point {
    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Point)){
            return false;
        }
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }
}

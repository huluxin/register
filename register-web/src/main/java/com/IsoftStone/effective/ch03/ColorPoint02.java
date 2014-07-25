package com.IsoftStone.effective.ch03;

/**
 * 违反了传递性
 * 使用getClass 测试代替instanceof 测试
 * 可以扩展可实例化的类和增加新的值组件,同时保留equals约定
 * Created by Administrator on 2014/7/25.
 */
public class ColorPoint02 {
    private Color color;
    private Point point;

    public ColorPoint02(int x, int y, Color color) {
        point = new Point(x, y);
        this.color = color;
    }

    /**
     * Returns the point-view of this color point.
     */
    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint02))
            return false;
        ColorPoint02 cp = (ColorPoint02) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }


    public static void main(String[] args) {
//        Point p = new Point(1, 2);
//        ColorPoint cp = new ColorPoint(1, 2, Color.RED);

        ColorPoint02 p1 = new ColorPoint02(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint02 p3 = new ColorPoint02(1, 2, Color.BLUE);

        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p3));
        System.out.println(p1.equals(p3));
    }
}

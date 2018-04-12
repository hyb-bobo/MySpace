package Decoration;

import org.junit.*;

import java.util.Arrays;

/**
 * Author: hyb
 * Date: Created in 2018/4/12 10:32
 */
public class AAAA {

    // 方法四：是对每个单独的数组进行由小到大排序
    @org.junit.Test
    public void dAM4() { // 对单个的一维数组进行排序
        int[][] a = {
                { 12, 26, 89, 78, 45, 65, 36 },
                { 2, 6, 90, 34, 16, 27, 5 },
                { 13, 3, 4, 29, 33, 37, 17 },
                { 1, 9, 19, 49, 57, 22, 11 },
                { 7, 82, 35, 21, 24, 59, 60 } };
        for (int k = 0; k < a.length; k++) { // 直接调用数组arrays里的sort()这个方法对里边的一维数组进行排序
            Arrays.sort(a[k]);
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "   ");
            }
            System.out.println();
        }

    }
}

package basic;

import org.testng.annotations.Test;

import java.util.Scanner;

public class ProcessContralStatement {

    /**
     * 逻辑运算符&&和&、||和|的区别：
     *       * a:最终结果一样。
     *       * b:&&具有短路效果。左边是false，右边不执行。
     *       * &是无论左边是false还是true,右边都会执行
     *       同理 ||和|
     */
    @Test
    public void logicalOperator() {

    }

    // 获取两个数中的最大值
    @Test
    public void ternaryOperator01() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int max = (x > y) ? x : y;
    }

    // 键盘录入三个数据，获取这三个数据中的最大值
    @Test
    public void ternaryOperator02() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int temp = (x > y) ? x : y;
        int max = (temp > z) ? temp : z;
    }

    //键盘录入一个成绩，判断并输出成绩的等级
    @Test
    public void ifStatement() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        if (x >= 90 && x <= 100) {
            System.out.println("优");
        }else if (x >= 80 && x <= 89 ) {
            System.out.println("良");
        }else {
            System.out.println("成绩录入错误");
        }
    }

    // 键盘录入月份，输出对应的季节
    @Test
    public void switchStatement() {
        Scanner sc = new Scanner(System.in);    //创建键盘录入对象
        System.out.println("请输入月份");
        int month = sc.nextInt();         //将键盘录入的结果存储在month
        switch (month) {
            case 3:
            case 4:
            case 5:
                System.out.println(month + "月是春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println(month + "月是夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println(month + "月是秋季");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println(month + "月是冬季");
                break;
            default:
                System.out.println("对不起没有对应的季节");
                break;
        }
    }

}

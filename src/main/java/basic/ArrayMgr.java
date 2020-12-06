package basic;

import org.testng.annotations.Test;

import java.util.Arrays;

public class ArrayMgr {

    @Test
    public void arrayInit01(){
        String[] arr = new String[2];
        arr[0] = "hahahaha";
        System.out.println(arr[0]);
    }

    // 静态初始化
    @Test
    public void arrayInit02(){
        String[] arr = {"hahahaha"};
        System.out.println(arr[0]);
    }

    @Test
    public void arraySort(){
        int[] arr = {11, 2, 5, 13, 9};
        Arrays.sort(arr);
        for (int anArr : arr) {
            System.out.println(anArr);
        }
    }

}

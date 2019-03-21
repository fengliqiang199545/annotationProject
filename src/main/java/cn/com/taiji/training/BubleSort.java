package cn.com.taiji.training;

/**
 * @author fengliqiang
 * @date 2019/03/21/9:21 AM
 **/
public class BubleSort {
    public static void main(String[] args) {
        int[] ints = {3,54,34,25,8};
        System.out.println("===Before===");
        for (int anInt : ints) {
            System.out.println(anInt);
        }
        for (int i = 0; i <ints.length-1 ; i++) {
            for (int j = 0; j < ints.length-1; j++) {
                if (ints[j] > ints[j+1]){
                    int temp = ints[j];
                    ints[j] = ints[j+1];
                    ints[j+1] = temp;
                }
                
            }

        }

        System.out.println();
        System.out.println("=== After===");
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}

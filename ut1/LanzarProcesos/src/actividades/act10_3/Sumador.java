package actividades.act10_3;

import java.util.Arrays;

public class Sumador {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int[] array = new int[b-1];
        for (int i = 0; i < b-1; i++) {
            array[i] = i+a;
        }
        array[array.length - 1] = b;
        int result = 0;
        for (int i : array) {
            result += i;
        }
        System.out.println(result+"\n");
    }
}

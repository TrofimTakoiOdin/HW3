// Здесь решены задания 2 и 3:

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TasksTwoThree {
    public static void main(String[] args) {

        int[] arr = getRandomArray(6, 0, 100);
        int[] res = evenDel(arr);
        System.out.println("Рандомный массив: " + Arrays.toString(arr));
        System.out.println("Наш массив без четных чисел: " + Arrays.toString(res));

        List<Integer> ints = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Min: " + Collections.min(ints));
        System.out.println("Max: " + Collections.max(ints));
        System.out.println("Mean: " + IntStream.of(arr).sum() / arr.length);


    }
    private static Random random = new Random();
    static int[] getRandomArray(int size, int min, int max){

        int[] arr = new int[size];//
        int index = 0;
        while (index < size) {
            arr[index] = random.nextInt(min, max);
            index = index + 1;
        }
        return arr;
    }

    public static int[] evenDel(int[] array) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                list.add(array[i]);
            }
        }
//        System.out.println((list));
//        System.out.println(list.size());
        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        //System.out.println("Наш массив без четных чисел: " + Arrays.toString(result));
        return result;

    }
}


import java.util.Arrays;
public class MergeSort {
    public static void main(String[] args) {
        int[] array = {5, 10, 7, 3, 9, 1, 4, 2, 6, 8};
        int[] result = mergeSort(array);
        System.out.println("Изначальный массив: " + Arrays.toString(array));
        System.out.println("Отсортированный массив: " + Arrays.toString(result));
    }
    public static int[] mergeSort(int [] SortArr) {
        int lenArr = SortArr.length;
        int[] buffer1 = Arrays.copyOf(SortArr, lenArr);
        int[] buffer2 = new int[lenArr];
        int startIndex = 0;
        int endIndex = lenArr - 1;
        int[] result = mergeSortInner(buffer1, buffer2, startIndex, endIndex);
        return result;
    }
    public static int[] mergeSortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        //уже отсортирован
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);

        //слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }

}
import java.util.Arrays;


public class MainClass {
    /**
     * Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
     * Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
     * идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
     * иначе в методе необходимо выбросить RuntimeException.
     * Написать набор тестов для этого метода (по 3-4 варианта входных данных).
     * Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
     */
    public int[] leftSanitizedArray(int[] initArr) {
        final int initArrLength = initArr.length;
        if (initArrLength == 0) throw new RuntimeException("Array should contain elements");

        int index = -1;

        for (int i = 0; i < initArrLength; i++) {
            if (initArr[i] == 4) {
                index = i;
            }
        }

        if (index == -1) throw new RuntimeException("Array should contain elements");
        if (index + 1 == initArrLength) {
            return new int[]{};
        }

        return Arrays.copyOfRange(initArr, index + 1, initArrLength);
    }

    /**
     * Написать метод, который проверяет состав массива из чисел 1 и 4.
     * Если в нем нет хоть одной четверки или единицы, то метод вернет false;
     * Написать набор тестов для этого метода (по 3-4 варианта входных данных).
     * [ 1 1 1 4 4 1 4 4 ] -> true
     * [ 1 1 1 1 1 1 ] -> false
     * [ 4 4 4 4 ] -> false
     * [ 1 4 4 1 1 4 3 ] -> false
     */
    public boolean is1and4InArray(int[] arr) {
        boolean contain_1 = Arrays.stream(arr).filter(el -> el == 1).findAny().isPresent();
        boolean contain_4 = Arrays.stream(arr).filter(el -> el == 4).findAny().isPresent();
        boolean not_contain_1_4 = Arrays.stream(arr)
                .filter(el -> el != 1)
                .filter(el -> el != 4)
                .findAny()
                .isPresent();
        return contain_1 && contain_4 && !(not_contain_1_4);
    }

}

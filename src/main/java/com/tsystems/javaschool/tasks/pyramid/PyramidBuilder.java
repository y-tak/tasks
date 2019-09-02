package com.tsystems.javaschool.tasks.pyramid;


import java.util.*;

public class PyramidBuilder {

    /**
     * Builds a pyramid with sorted values (with minumum value at the top line and maximum at the bottom,
     * from left to right). All vacant positions in the array are zeros.
     *
     * @param inputNumbers to be used in the pyramid
     * @return 2d array with pyramid inside
     * @throws {@link CannotBuildPyramidException} if the pyramid cannot be build with given input
     */
    public int[][] buildPyramid(List<Integer> inputNumbers)  throws CannotBuildPyramidException
    {
        // TODO : Implement your solution here

        try {

            int size = 0;
            int k = 0;
            size = inputNumbers.size();
            int size2 = (int) Math.ceil(size / 2);

            int[][] par = new int[size][size];
            ///---------------сортируем------------------
            Collections.sort(inputNumbers);

            ///--преобразовать в ряды-------------------------
            int[] ret = new int[inputNumbers.size()];
            Iterator<Integer> iterator = inputNumbers.iterator();
            for (int i = 0; i < ret.length; i++) {
                ret[i] = iterator.next().intValue();
            }
            // System.out.println("ret"+ Arrays.toString(ret));
            //------подсчет сколько рядов-------
            int[] an = new int[size + 1];
            an[0] = 0;
            int kk = 0;
            for (int j = 1; j < size + 1; j++) {
                an[j] = an[j - 1] + j;
                if (an[j] == ret.length) {
                    kk = j;///количество строк
                    k = (int) j * 2 - 1;//количество столбцов
                    break;
                }
            }
            if (an[kk] != ret.length) System.out.println("kk и ret.length = " + kk + " и " + ret.length);

            System.out.println("кол строк = " + kk + " кол столбцов = " + k);
            ///----------------------------------------
            System.out.println(" __________________________________");
            int por = 0;
            int kol = 0;
            int jj = 0;
            for (int i = 1; i < kk + 1; i++)//по строчкам
            {
                int del = k / (i + 1);//ищем середину
                if (i == kk) del = 0;
                kol = 0;
                jj = 0;
                for (int j = 1; j < k + 1; j++) {
                    par[i][j] = 0;
                    if (j == del + 1 & kol != i) {
                        par[i][j] = ret[por];
                        kol++;
                        por++;
                        jj = j + 2;
                    } else if (j > del & kol < i & jj == j) {
                        par[i][j] = ret[por];
                        kol++;
                        por++;
                        jj = j + 2;
                    }

                    System.out.print("  " + par[i][j] + "   ");
                }
                System.out.println("");

            }
            return par;
        }
        catch (Exception e)
        {
            System.out.println("ОШИБКА !!! = " + e.getMessage());
        }

        return new int[0][];
    }

    public static void main(String[] args) throws CannotBuildPyramidException{

        PyramidBuilder pyramidBuilder = new PyramidBuilder();


        pyramidBuilder.buildPyramid(Arrays.asList(11, 1, 12, 3, 2, 13, 9, 4, 5, 14, 10, 8, 7, 15, 6));

        pyramidBuilder.buildPyramid(Arrays.asList(1, 3, 2, 9, 4, 5));
        pyramidBuilder.buildPyramid(Arrays.asList(1, 3, 2, 9, 4, 5, 10, 8, 7, 6));
        pyramidBuilder.buildPyramid(Arrays.asList(11, 1, 21, 12, 3, 16, 2, 13, 9, 4, 17, 5, 14, 10, 18, 8, 7, 19, 15, 6, 20));
        pyramidBuilder.buildPyramid(Arrays.asList(1, 3, 2, 0, 4, 5));

        pyramidBuilder.buildPyramid(Arrays.asList(1, 3, 2, 9, 4, null));




    }

}





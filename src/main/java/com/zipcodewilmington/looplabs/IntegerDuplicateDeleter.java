package com.zipcodewilmington.looplabs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {

    public IntegerDuplicateDeleter(Integer[] intArray) {
         super(intArray);
    }

    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        int count = 0;
        Integer[] listArr = Arrays.copyOf(super.array, super.array.length);

        for (int i = 0; i < listArr.length; i++) {
            count = getNumberOfOccurrences(listArr, listArr[i]);
            if(count >= maxNumberOfDuplications){
                listArr = (Integer[]) removeValue(listArr, listArr[i]);
                i--;
            }
        }
        Integer[] removed = Arrays.copyOf(listArr, listArr.length);
        return  removed;
    }


    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        int count = 0;
        Integer[] listArr = Arrays.copyOf(super.array, super.array.length);

        for (int i = 0; i < listArr.length; i++) {
            count = getNumberOfOccurrences(listArr, listArr[i]);
            if(count == exactNumberOfDuplications){
                listArr = (Integer[]) removeValue(listArr, listArr[i]);
                i--;
            }
        }
        Integer[] removed = Arrays.copyOf(listArr, listArr.length);
        return  removed;
    }


    public Integer getNumberOfOccurrences(Integer[] list, int objectToRemove) {
        int count = 0;
        for (Object o : list) {
            if (o.equals(objectToRemove)) {
                count ++;
            }
        }
        return count;
    }


    public Object[] removeValue(Integer[] list, int objectToRemove) {
        Object[] resultArray = new Object[list.length - getNumberOfOccurrences(list, objectToRemove)];

        int count = 0;
        for (int i = 0; i < list.length; i++) {
            if (objectToRemove!= (list[i])) {
                resultArray[count] = list[i];
                count++;
            }
        }
        Integer[] integerArray = Arrays.copyOf(resultArray, resultArray.length, Integer[].class);// copies the array and resizes
        return integerArray;
    }
}

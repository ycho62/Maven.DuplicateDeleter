package com.zipcodewilmington.looplabs;

import java.util.Arrays;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {
    public StringDuplicateDeleter(String[] intArray) {
        super(intArray);
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        int count = 0;
        String[] listArr1 = Arrays.copyOf(super.array, super.array.length);

        for (int i = 0; i < listArr1.length; i++) {
            count = getNumberOfOccurrences(listArr1, listArr1[i]);
            if(count >= maxNumberOfDuplications){
                listArr1 = (String[]) removeValue(listArr1, listArr1[i]);
                i--;
            }
        }
        String[] removed = Arrays.copyOf(listArr1, listArr1.length);
        return  removed;
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        int count = 0;
        String[] listArr1 = Arrays.copyOf(super.array, super.array.length);

        for (int i = 0; i < listArr1.length; i++) {
            count = getNumberOfOccurrences(listArr1, listArr1[i]);
            if(count == exactNumberOfDuplications){
                listArr1 = (String[]) removeValue(listArr1, listArr1[i]);
                i--;
            }
        }
        String[] removed = Arrays.copyOf(listArr1, listArr1.length);
        return  removed;
    }

    public Integer getNumberOfOccurrences(String[] list, String objectToRemove) {
        int count = 0;
        for (Object o : list) {
            if (o.equals(objectToRemove)) {
                count ++;
            }
        }
        return count;
    }


    public String[] removeValue(String[] listArr1, String objectToRemove) {
        String[] resultArray = new String[listArr1.length - getNumberOfOccurrences(listArr1, objectToRemove)];

        int count = 0;
        for (int i = 0; i < listArr1.length; i++) {
            if (!objectToRemove.equals(listArr1[i])) {
                resultArray[count] = listArr1[i];
                count++;
            }
        }
        String[] integerArray = Arrays.copyOf(resultArray, resultArray.length, String[].class);// copies the array and resizes
        return integerArray;
    }
}

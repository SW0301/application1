package com.example.application1.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;

@Service
public class NumbersServiceImpl implements NumbersService{

    @Override
    public int getMax(ArrayList<Integer> numbersList) {
        int max = 0;
        max = Collections.max(numbersList);
        return max;
    }

    @Override
    public int getMin(ArrayList<Integer> numbersList) {
        return Collections.min(numbersList);
    }

    @Override
    public int median(ArrayList<Integer> numbersList) {
        Collections.sort(numbersList);
        if (numbersList.size() % 2 == 0){
            return ( numbersList.get(numbersList.size()/2)+(numbersList.get(numbersList.size()/2-1)) /2);
        }
        return numbersList.get(numbersList.size()/2);
    }

    @Override
    public BigDecimal averageValue(ArrayList<Integer> numbersList) {
        BigDecimal sum = BigDecimal.valueOf(0);
        for (int i=0; i<numbersList.size(); i++){
            sum = sum.add(BigDecimal.valueOf(numbersList.get(i)));
        }
        return sum.divide(BigDecimal.valueOf(numbersList.size()), 5, RoundingMode.HALF_UP);
    }

    @Override
    public int[][] longestSequenceIncrease(ArrayList<Integer> numbersList) {
        int p = 1;
        int result = 1;
        ArrayList<Integer> lastNumber = new ArrayList<>();

        for(int i = 0; i<numbersList.size()-1;i++){                    //находим длину самой длинной последовательности
            if(numbersList.get(i)<numbersList.get(i+1)){
                p++;
                if(result<p) {
                    result=p;
                }

            }
            else p=1;
        }

        for(int i=0; i<numbersList.size()-1; i++){                      //находим последние элементы последовательностей
            if(numbersList.get(i)<numbersList.get(i+1)){
                p++;
                if(result==p) lastNumber.add(i+1);
            }
            else p=1;
        }

        int[][] sequence = new int[lastNumber.size()][result];

        for(int i = 0; i<lastNumber.size(); i++){
            for(int j=0; j<result; j++)
                sequence[i][j]=numbersList.get(lastNumber.get(i)-result+1+j);
        }

        return sequence;
    }

    @Override
    public int[][] longestSequenceReduction(ArrayList<Integer> numbersList) {
        int p = 1;
        int result = 1;
        ArrayList<Integer> lastNumber = new ArrayList<>();

        for(int i = 0; i<numbersList.size()-1;i++){                    //находим длину самой длинной последовательности
            if(numbersList.get(i)>numbersList.get(i+1)){
                p++;
                if(result<p) {
                    result=p;
                }

            }
            else p=1;
        }

        for(int i=0; i<numbersList.size()-1; i++){                      //находим последние элементы последовательностей
            if(numbersList.get(i)>numbersList.get(i+1)){
                p++;
                if(result==p) lastNumber.add(i+1);
            }
            else p=1;
        }

        int[][] sequence = new int[lastNumber.size()][result];

        for(int i = 0; i<lastNumber.size(); i++){
            for(int j=0; j<result; j++)
                sequence[i][j]=numbersList.get(lastNumber.get(i)-result+1+j);
        }

        return sequence;
    }
}

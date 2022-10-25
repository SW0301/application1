package com.example.application1.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

@Service
public interface NumbersService {
    int getMax(ArrayList<Integer> numbersList);
    int getMin(ArrayList<Integer> numbersList);
    int median(ArrayList<Integer> numbersList);
    BigDecimal averageValue(ArrayList<Integer> numbersList);
    int[][] longestSequenceIncrease (ArrayList<Integer> numbersList);
    int[][] longestSequenceReduction (ArrayList<Integer> numbersList);
}

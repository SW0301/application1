package com.example.application1.controller;

import com.example.application1.ReadingFromFile;
import com.example.application1.model.*;
import com.example.application1.service.NumbersServiceImpl;
import io.swagger.annotations.Api;

import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/numbers")
@Api(value="Контроллер. Получает информацию о файле, выводит результат операций над массивом")
public class NumbersController {


    ReadingFromFile readingFromFile = new ReadingFromFile();

    @Autowired
    private NumbersServiceImpl numbersService;

    ArrayList<Integer> numbersList = new ArrayList<>();



    @Operation( summary = "Получает информацию о файле и открывает его", tags = "Открытие файла")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Файл открыт"
                    )
    })
    @PutMapping
    public void setFilePath(@RequestBody Entity file_path){
        numbersList = readingFromFile.reading(file_path.getFile_path().trim());
    }

    @Operation(summary = "Получает название операции из тела запроса", tags = "Операции над массивом")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Операция выполнена"
            )
    })
    @GetMapping
    @ResponseBody
    public Object operationBody(@RequestBody Entity operation){
        switch(operation.getOperation()) {
            case "get_max_value": {MaxValue maxValue = new MaxValue();
                maxValue.setMax_value(String.valueOf(numbersService.getMax(numbersList)));
                return maxValue;}
            case "get_min_value": {
                MinValue minValue = new MinValue();
                minValue.setMin_value(String.valueOf(numbersService.getMin(numbersList)));
                return minValue;
            }
            case "get_median": {
                Median median = new Median();
                median.setMedian(String.valueOf(numbersService.median(numbersList)));
                return median;
            }
            case "get_average_value": {
                AverageValue averageValue = new AverageValue();
                averageValue.setAverageValue(String.valueOf(numbersService.averageValue(numbersList)));
                return averageValue;
            }
            case "get_longest_sequence_increase": {
                LongestSequenceIncrease longestSequenceIncrease = new LongestSequenceIncrease();
                longestSequenceIncrease.setLongestSequenceIncrease(Arrays.deepToString(numbersService.longestSequenceIncrease(numbersList)));
                return longestSequenceIncrease;
            }
            case "get_longest_sequence_reduction": {
                LongestSequenceReduction longestSequenceReduction = new LongestSequenceReduction();
                longestSequenceReduction.setLongestSequenceReduction(Arrays.deepToString(numbersService.longestSequenceReduction(numbersList)));
                return longestSequenceReduction;
            }
            default: return "Wrong operation";
        }
    }

    @Operation(summary = "Получает название операции из URL", tags = "Операции над массивом")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Операция выполнена"
            )
    })
    @GetMapping("/{operation}")
    @ResponseBody
    public Object operationPath(@PathVariable String operation){
        switch(operation) {
            case "get_max_value": {MaxValue maxValue = new MaxValue();
                maxValue.setMax_value(String.valueOf(numbersService.getMax(numbersList)));
                return maxValue;}
            case "get_min_value": {
                MinValue minValue = new MinValue();
                minValue.setMin_value(String.valueOf(numbersService.getMin(numbersList)));
                return minValue;
            }
            case "get_median": {
                Median median = new Median();
                median.setMedian(String.valueOf(numbersService.median(numbersList)));
                return median;
            }
            case "get_average_value": {
                AverageValue averageValue = new AverageValue();
                averageValue.setAverageValue(String.valueOf(numbersService.averageValue(numbersList)));
                return averageValue;
            }
            case "get_longest_sequence_increase": {
                LongestSequenceIncrease longestSequenceIncrease = new LongestSequenceIncrease();
                longestSequenceIncrease.setLongestSequenceIncrease(Arrays.deepToString(numbersService.longestSequenceIncrease(numbersList)));
                return longestSequenceIncrease;
            }
            case "get_longest_sequence_reduction": {
                LongestSequenceReduction longestSequenceReduction = new LongestSequenceReduction();
                longestSequenceReduction.setLongestSequenceReduction(Arrays.deepToString(numbersService.longestSequenceReduction(numbersList)));
                return longestSequenceReduction;
            }
            default: return "Wrong operation";
        }
    }
}

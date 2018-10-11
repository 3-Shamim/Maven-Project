package Main;

import Average.Average;
import TimeSeries.TimeSeries;
import simple_linear_regression.SimpleLinearRegression;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private DecimalFormat decimalFormat = new DecimalFormat("#.##");
    private Average average = new Average();

    public Main() {

        /*List<Double> y = Arrays.asList(4.79, 8.33, 7.81, 4.69, 10.78, 5.31, 11.37, 8.46, 9.33, 10.04, 5.71, 6.00, 11.06, 3.68, 9.91, 8.67, 8.57, 8.66, 8.74, 8.82, 8.91,
                4.79, 8.33, 7.81, 4.69, 10.78, 5.31, 11.37, 8.46, 9.33, 10.04, 5.71, 6.00, 11.06, 3.68, 9.91, 8.67, 8.57, 8.66, 8.74, 8.82, 8.91,
                4.79, 8.33, 7.81, 4.69, 10.78, 5.31, 11.37, 8.46, 9.33, 10.04, 5.71, 6.00, 11.06, 3.68, 9.91, 8.67, 8.57, 8.66, 8.74, 8.82, 8.91,
                4.79, 8.33, 7.81, 4.69, 10.78, 5.31, 11.37, 8.46, 9.33, 10.04, 5.71, 6.00, 11.06, 3.68, 9.91, 8.67, 8.57, 8.66, 8.74, 8.82, 8.91);*/

        /*List<Double> y = Arrays.asList(4.79, 8.33, 7.81, 4.69, 10.78, 5.31, 11.37, 8.46, 9.33, 10.04, 5.71, 6.00, 11.06, 3.68, 9.91, 8.67, 8.57, 8.66, 8.74, 8.82, 8.91,
                4.79, 8.33, 7.81, 4.69, 10.78, 5.31, 11.37, 8.46, 9.33, 10.04, 5.71, 6.00, 11.06, 3.68, 9.91, 8.67, 8.57, 8.66, 8.74, 8.82, 8.91,
                4.79, 8.33, 7.81, 4.69, 10.78, 5.31, 11.37, 8.46, 9.33, 10.04, 5.71, 6.00, 11.06, 3.68, 9.91, 8.67, 8.57, 8.66, 8.74, 8.82, 8.91);*/

        List<Double> y = Arrays.asList(4.79, 8.33, 7.81, 4.69, 10.78, 5.31, 11.37, 8.46, 9.33, 10.04, 5.71, 6.00, 11.06, 3.68, 9.91, 8.67, 8.57, 8.66, 8.74, 8.82, 8.91,
                4.79, 8.33, 7.81, 4.69, 10.78, 5.31, 11.37, 8.46, 9.33, 10.04, 5.71, 6.00, 11.06, 3.68, 9.91, 8.67, 8.57, 8.66, 8.74, 8.82, 8.91);

//        List<Double> y = Arrays.asList(4.79, 8.33, 7.81, 4.69, 10.78, 5.31, 11.37, 8.46, 9.33, 10.04, 5.71, 6.00, 11.06, 3.68, 9.91, 8.67, 8.57, 8.66, 8.74, 8.82, 8.91);

        List<Double> y1 = Arrays.asList(4.8, 4.1, 6.0, 6.5, 5.8, 5.2, 6.8, 7.4, 6.0, 5.6, 7.5, 7.8, 6.3, 5.9, 8.0, 8.4);

        List<Double> y2 = Arrays.asList(4.79, 8.33, 7.81, 4.69, 10.78, 5.31, 11.37, 8.46, 9.33, 10.04, 5.71, 6.00, 11.06, 3.68, 9.91, 8.67, 8.57, 8.66, 8.74, 8.82, 8.91,
                4.79, 8.33, 7.81, 4.69, 10.78, 5.31, 11.37, 8.46, 9.33, 10.04, 5.71, 6.00, 11.06, 3.68, 9.91, 8.67, 8.57,
                8.66, 8.74, 8.82, 8.91, 6.00, 11.06, 3.68, 9.91, 8.67, 8.57);

        int period = 7;
        int period1 = 4;
        int period2 = 12;

        TimeSeries timeSeries = new TimeSeries(y, period);
        TimeSeries timeSeries1 = new TimeSeries(y1, period1);
        TimeSeries timeSeries2 = new TimeSeries(y2, period2);

        System.out.println("Weekly Data : ");
        System.out.println(y.size());
        System.out.println(timeSeries.getForecastValues().size());
        System.out.println(timeSeries.getForecastValues());

        System.out.println("-------------------------------------------------------------------------");

        System.out.println("Quarterly Data : ");
        System.out.println(y1.size());
        System.out.println(timeSeries1.getForecastValues().size());
        System.out.println(timeSeries1.getForecastValues());

//        System.out.println("-------------------------------------------------------------------------");
//
//        System.out.println("Yearly Data : ");
//        System.out.println(y2.size());
//        System.out.println(timeSeries2.getForecastValues().size());
//        System.out.println(timeSeries2.getForecastValues());


    }

    public static void main(String[] args) {
        new Main();
    }

   /* public Main() {

        List<Double> y = Arrays.asList(4.79, 8.33, 7.81, 4.69, 10.78, 5.31, 11.37, 8.46, 9.33, 10.04, 5.71, 6.00, 11.06, 3.68, 9.91, 8.67, 8.57, 8.66, 8.74, 8.82, 8.91);
        List<Double> y1 = Arrays.asList(4.8, 4.1, 6.0, 6.5, 5.8, 5.2, 6.8, 7.4, 6.0, 5.6, 7.5, 7.8, 6.3, 5.9, 8.0, 8.4);

        int dataSize = y.size();
        int dataSize1 = y1.size();

        int period = 7;
        int period1 = 4;

        TimeSeries timeSeries = new TimeSeries(y1, period1);

        *//* *//**//*---------------- Simple Average -----------------------*//**//*

        System.out.println("Simple Average : ");

        System.out.println("Average of Y = " + average.getAverage(y));

        System.out.println("Average of Y1 = " + average.getAverage(y));

        *//**//*------------ MA --------------*//**//*

        System.out.println("Moving Average : ");

        List<Double> ma = average.getMovingAverage(y, period);

        List<Double> ma1 = average.getMovingAverage(y1, period1);

        System.out.println(timeSeries.movingAverage());

//        System.out.println(ma);
        System.out.println(ma1);

        *//**//*-------------- CMA -------------------*//**//*

        System.out.println("Centered Moving Average : ");

        List<Double> cma = average.getMovingAverage(ma, 2);

        List<Double> cma1 = average.getMovingAverage(ma1, 2);

        System.out.println(timeSeries.centeredMovingAverage());

//        System.out.println(cma);
        System.out.println(cma1);

        *//**//*---------------------- S, I -----------------------*//**//*

        System.out.println("Seasonal And Irregularity : ");

        List<Double> si = timeSeries.getSeasonalAndIrregularity(y, cma, period);

        List<Double> si1 = timeSeries.getSeasonalAndIrregularity(y1, cma1, period1);

        System.out.println(timeSeries.getSeasonalAndIrregularity());
//        System.out.println(si);
        System.out.println(si1);

        *//**//*--------------- All Seasonal Component -------------*//**//*

        System.out.println("All Seasonal Component : ");

        List<Double> allSeasonalComponent = timeSeries.getAllSeasonalComponent(si, period);
//        System.out.println(allSeasonalComponent);

        List<Double> allSeasonalComponent1 = timeSeries.getAllSeasonalComponent(si1, period1);
        System.out.println(timeSeries.getAllSeasonalComponent());
        System.out.println(allSeasonalComponent1);

        *//**//*-------------------- Seasonal Value  ------------------------*//**//*
        System.out.println("Seasonal Value : ");
        List<Double> seasonalData = timeSeries.getSeasonalData(period, dataSize, allSeasonalComponent);
//        System.out.println(seasonalData);

        List<Double> seasonalData1 = timeSeries.getSeasonalData(period1, dataSize1, allSeasonalComponent1);
        System.out.println(timeSeries.getSeasonalData());
        System.out.println(seasonalData1);

        *//**//*---------------------- Deseasonalize -------------------*//**//*
        System.out.println("Deseasonalize : ");

        List<Double> deseasonalizeValue = timeSeries.getDeseasonalizeValue(y, seasonalData);
//        System.out.println(deseasonalizeValue);

        List<Double> deseasonalizeValue1 = timeSeries.getDeseasonalizeValue(y1, seasonalData1);
        System.out.println(timeSeries.getDeseasonalizeValue());
        System.out.println(deseasonalizeValue1);




        *//**//*---------------------------------- Linear Regression Part -----------------------*//**//*
        System.out.println("---------------------- Linear Regression Part ------------------------");

        List<Double> xValue = new ArrayList<>();
        for (int i = 1; i <= deseasonalizeValue1.size(); i++) {
            xValue.add(Double.valueOf(i));
        }

        SimpleLinearRegression simpleLinearRegression = new SimpleLinearRegression(xValue,deseasonalizeValue1);

        System.out.println(simpleLinearRegression.getY_Intercept());
        System.out.println(simpleLinearRegression.getSlope());*//*

        System.out.println(timeSeries.get_T_Values());
        System.out.println(timeSeries.getForecastValues());

    }*/

}

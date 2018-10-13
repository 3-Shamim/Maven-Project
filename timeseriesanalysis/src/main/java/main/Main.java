package main;

import file_reader.File_Reader;
import prediction.Prediction;
import time_series.TimeSeries_One;

import java.util.Arrays;
import java.util.List;

public class Main {

    private Prediction prediction = new Prediction();
    private File_Reader file_reader = new File_Reader();

    public Main() {

        int period2 = 30;
        int period1 = 7;
        int period = 4;


        List<Double> data = file_reader.getData();

        int mod2 = data.size() % period2;
        int mod1 = data.size() % period1;

        List<Double> y2 = data.subList(mod2, data.size());
        List<Double> y1 = data.subList(mod1, data.size());

        /*List<Double> y = Arrays.asList(4.8, 4.1, 6.0, 6.5, 5.8, 5.2, 6.8, 7.4, 6.0, 5.6, 7.5, 7.8, 6.3, 5.9, 8.0, 8.4);

        System.out.println("Real Data: ");
        System.out.println(y.size());
        System.out.println(y);

        List<Double> forecastValue = prediction.getForecastValue(y, period);
        System.out.println("Predicted Data: ");
        System.out.println(forecastValue.size());
        System.out.println(forecastValue);*/

        System.out.println("------------------------------------------------------------");

        System.out.println("Real Data: ");
        System.out.println(y1.size());
        System.out.println(y1);

        List<Double> forecastValue1 = prediction.getForecastValue(y1, period1);
        System.out.println("Predicted Data: ");
        System.out.println(forecastValue1.size());
        System.out.println(forecastValue1.subList(forecastValue1.size() - 14, forecastValue1.size()));

        System.out.println("------------------------------------------------------------");

        System.out.println("Real Data: ");
        System.out.println(y2.size());
        System.out.println(y2);

        List<Double> forecastValue2 = prediction.getForecastValue(y2, period2);
        System.out.println("Predicted Data: ");
        System.out.println(forecastValue2.size());
        System.out.println(forecastValue2.subList(forecastValue2.size() - 14, forecastValue2.size()));

        System.out.println("Future Real Data: \n" + data.subList(data.size() - 14, data.size()));



    }


    public static void main(String[] args) {
        new Main();
    }

    public void getForecastValues() {

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

//        List<Double> y1 = Arrays.asList(4.8, 4.1, 6.0, 6.5, 5.8, 5.2, 6.8, 7.4, 6.0, 5.6, 7.5, 7.8, 6.3, 5.9, 8.0, 8.4);
        List<Double> y1 = Arrays.asList(4.8, 4.1, 6.0, 6.5, 5.8, 5.2, 6.8, 7.4, 6.0, 5.6, 7.5, 7.8, 6.3, 5.9, 8.0, 8.4, 4.8,
                4.1, 6.0, 6.5, 5.8, 5.2, 6.8, 7.4, 6.0, 5.6, 7.5, 7.8, 6.3, 5.9, 8.0, 8.4);

        List<Double> y2 = Arrays.asList(4.79, 8.33, 7.81, 4.69, 10.78, 5.31, 11.37, 8.46, 9.33, 10.04, 5.71, 6.00, 11.06, 3.68, 9.91, 8.67, 8.57, 8.66, 8.74, 8.82, 8.91,
                4.79, 8.33, 7.81, 4.69, 10.78, 5.31, 11.37, 8.46, 9.33, 10.04, 5.71, 6.00, 11.06, 3.68, 9.91, 8.67, 8.57,
                8.66, 8.74, 8.82, 8.91, 6.00, 11.06, 3.68, 9.91, 8.67, 8.57);

        int period = 7;
        int period1 = 4;
        int period2 = 12;

        TimeSeries_One timeSeries_one = new TimeSeries_One(y, period);


        System.out.println("Weekly Data : ");
        List<Double> forecastValues = timeSeries_one.getForecastValues();
        System.out.println(y.size());
        System.out.println(forecastValues.size());
        System.out.println(forecastValues);


    }

}

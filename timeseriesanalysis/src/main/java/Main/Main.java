package Main;

import Average.Average;
import TimeSeries.TimeSeries;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class Main {

    private DecimalFormat decimalFormat = new DecimalFormat("#.##");
    private Average average =  new Average();
    private TimeSeries timeSeries = new TimeSeries();

    public Main() {

        List<Double> Y = Arrays.asList(4.79, 8.33, 7.81, 4.69, 10.78, 5.31, 11.37, 8.46, 9.33, 10.04, 5.71, 6.00, 11.06, 3.68, 9.91, 8.67, 8.57, 8.66, 8.74, 8.82, 8.91);
        List<Double> Y1 = Arrays.asList(4.8, 4.1, 6.0, 6.5, 5.8, 5.2, 6.8, 7.4, 6.0, 5.6, 7.5, 7.8, 6.3, 5.9, 8.0, 8.4);

        int period = 7;
        int period1 = 4;

        /*---------------- Simple Average -----------------------*/

        System.out.println("Simple Average : ");

        System.out.println("Average of Y = "  + average.getAverage(Y));

        System.out.println("Average of Y1 = "  + average.getAverage(Y1));

        /*------------ MA --------------*/

        System.out.println("Moving Average : ");

        List<Double> ma = average.getMovingAverage(Y, period);

        List<Double> ma1 = average.getMovingAverage(Y1, period1);

//        System.out.println(ma);
        System.out.println(ma1);

        /*-------------- CMA -------------------*/

        System.out.println("Centered Moving Average : ");

        List<Double> cma = average.getMovingAverage(ma, 2);

        List<Double> cma1 = average.getMovingAverage(ma1, 2);

//        System.out.println(cma);
        System.out.println(cma1);

        /*---------------------- S, I -----------------------*/

        System.out.println("Seasonal And Irregularity : ");

        List<Double> si = timeSeries.getSeasonalAndIrregularity(Y, cma, period);

        List<Double> si1 = timeSeries.getSeasonalAndIrregularity(Y1, cma1, period1);
//        System.out.println(si);
        System.out.println(si1);

        /*--------------- All Seasonal Component -------------*/

        System.out.println("All Seasonal Component : ");

//        System.out.println(timeSeries.getAllSeasonalComponent(si, period));

        System.out.println(timeSeries.getAllSeasonalComponent(si1, period1));

    }

    public static void main(String[] args) {
        new Main();
    }

}

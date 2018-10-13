package prediction;

import average.Average;
import time_series.TimeSeries;
import simple_linear_regression.SimpleLinearRegression;

import java.util.ArrayList;
import java.util.List;

public class Prediction {

    private Average average = new Average();
    private TimeSeries timeSeries = new TimeSeries();

    public List<Double> getForecastValue(List<Double> y, int period) {

        int dataSize = y.size();

        /*------------ MA --------------*/

        List<Double> ma = average.getMovingAverage(y, period);

        /*-------------- CMA -------------------*/

        List<Double> cma = average.getMovingAverage(ma, 2);

        /*---------------------- S, I -----------------------*/

        List<Double> si = timeSeries.getSeasonalAndIrregularity(y, cma, period);


        /*--------------- All Seasonal Component -------------*/

        List<Double> allSeasonalComponent = timeSeries.getAllSeasonalComponent(si, period);


        /*-------------------- Seasonal Value  ------------------------*/
        List<Double> seasonalData = timeSeries.getSeasonalData(period, dataSize, allSeasonalComponent);


        /*---------------------- Deseasonalize -------------------*/

        List<Double> deseasonalizeValue = timeSeries.getDeseasonalizeValue(y, seasonalData);

        /*---------------------------------- Linear Regression Part -----------------------*/

        List<Double> xValue = new ArrayList<>();
        for (int i = 1; i <= deseasonalizeValue.size(); i++) {
            xValue.add(Double.valueOf(i));
        }

        SimpleLinearRegression simpleLinearRegression = new SimpleLinearRegression(xValue,deseasonalizeValue);

        double slope = simpleLinearRegression.getSlope();
        double y_intercept = simpleLinearRegression.getY_Intercept();


        /*------------------------ Prediction Part -------------------------*/

        List<Double> t_values = timeSeries.get_T_Values(xValue, period, y_intercept, slope);

        List<Double> forecastValues = timeSeries.getForecastValues(t_values, seasonalData);

        return forecastValues;
    }

}

package TimeSeries;

import Average.Average;
import simple_linear_regression.SimpleLinearRegression;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeSeries {

    private Average average = new Average();

    private List<Double> yValues;
    private int period;
    private DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public TimeSeries(List<Double> yValues, int period) {
        this.yValues = yValues;
        this.period = period;

        decimalFormat.setRoundingMode(RoundingMode.CEILING);
    }

    private List<Double> movingAverage() {
        return average.getMovingAverage(yValues, period);
    }

    private List<Double> centeredMovingAverage() {
        return average.getMovingAverage(movingAverage(), 2);
    }

    /*public List<Double> getSeasonalAndIrregularity(List<Double> yValues, List<Double> cmaValues, int period) {


        List<Double> S_I = new ArrayList<>();

        for (int i = 0; i < cmaValues.size(); i++) {
            Double value = yValues.get(i + (period / 2)) / cmaValues.get(i);
            S_I.add(Double.valueOf(decimalFormat.format(value)));
        }


        return S_I;
    }*/

    private List<Double> getSeasonalAndIrregularity() {

        List<Double> S_I = new ArrayList<>();

        for (int i = 0; i < centeredMovingAverage().size(); i++) {
            Double value = yValues.get(i + (period / 2)) / centeredMovingAverage().get(i);
            S_I.add(Double.valueOf(decimalFormat.format(value)));
        }

        return S_I;
    }

    private List<Double> getAllSeasonalComponent() {

        Map<Integer, List<Double>> allSeasonalComponent = new HashMap<>();
        List<Double> allSeasonalComponentAverage = new ArrayList<>();


        int counter = (period / 2) + 1;

        List<Double> values;

        for (Double d : getSeasonalAndIrregularity()) {

            if (allSeasonalComponent.get(counter) != null) {
                values = allSeasonalComponent.get(counter);
            } else {
                values = new ArrayList<>();
            }
            values.add(d);
            allSeasonalComponent.put(counter, values);

            if (counter == period) {
                counter = 0;
            }

            counter++;
        }

        allSeasonalComponent.forEach((key, value) -> {
            double averageValue = value.parallelStream().mapToDouble(v -> v).sum() / value.size();
            allSeasonalComponentAverage.add(Double.valueOf(decimalFormat.format(averageValue)));
        });

        return allSeasonalComponentAverage;
    }

    /*public List<Double> getAllSeasonalComponent(List<Double> siValues, int period) {

        Map<Integer, List<Double>> allSeasonalComponent = new HashMap<>();
        List<Double> allSeasonalComponentAverage = new ArrayList<>();


        int counter = (period / 2) + 1;

        List<Double> values;

        for (Double d : siValues) {

            if (allSeasonalComponent.get(counter) != null) {
                values = allSeasonalComponent.get(counter);
            } else {
                values = new ArrayList<>();
            }
            values.add(d);
            allSeasonalComponent.put(counter, values);

            if (counter == period) {
                counter = 0;
            }

            counter++;
        }

        allSeasonalComponent.forEach((key, value) -> {
            double averageValue = value.stream().mapToDouble(v -> v).sum() / value.size();
            allSeasonalComponentAverage.add(Double.valueOf(decimalFormat.format(averageValue)));
        });

        return allSeasonalComponentAverage;
    }*/

    private List<Double> getSeasonalData() {
        List<Double> seasonalData = new ArrayList<>();

        int dataSize = yValues.size();
        for (int i = 0; i <= (dataSize / period); i++) {
            seasonalData.addAll(getAllSeasonalComponent());
        }

        return seasonalData;
    }

    /*public List<Double> getSeasonalData(int period, int dataSize, List<Double> sessionalComponent) {
        List<Double> seasonalData = new ArrayList<>();

        for (int i = 0; i <= (dataSize / period); i++) {
            seasonalData.addAll(sessionalComponent);
        }

        return seasonalData;
    }*/

    private List<Double> getDeseasonalizeValue() {
        List<Double> deseasonalizeValue = new ArrayList<>();

        for (int i = 0; i < yValues.size(); i++) {
            deseasonalizeValue.add(Double.valueOf(decimalFormat.format(yValues.get(i) / getSeasonalData().get(i))));
        }

        return deseasonalizeValue;
    }

    /*public List<Double> getDeseasonalizeValue(List<Double> yValues, List<Double> sValues) {
        List<Double> deseasonalizeValue = new ArrayList<>();

        for (int i = 0; i < yValues.size(); i++) {
            deseasonalizeValue.add(Double.valueOf(decimalFormat.format(yValues.get(i) / sValues.get(i))));
        }

        return deseasonalizeValue;
    } */

    private List<Double> get_T_Values() {

        List<Double> result = new ArrayList<>();

        List<Double> xValue = new ArrayList<>();
        for (int i = 1; i <= yValues.size(); i++) {
            xValue.add(Double.valueOf(i));
        }

        SimpleLinearRegression simpleLinearRegression = new SimpleLinearRegression(xValue, getDeseasonalizeValue());

        double slope = simpleLinearRegression.getSlope();
        double y_intercept = simpleLinearRegression.getY_Intercept();

        for (int i = 0; i < xValue.size() + period; i++) {
            result.add(Double.valueOf(decimalFormat.format(y_intercept + (slope * (i+1)))));
        }

        return result;
    }

    public List<Double> getForecastValues() {

        List<Double> result = new ArrayList<>();

        for (int i = 0; i < get_T_Values().size(); i++) {
            result.add(Double.valueOf(decimalFormat.format(get_T_Values().get(i) * getSeasonalData().get(i))));
        }

        return result;
    }




}

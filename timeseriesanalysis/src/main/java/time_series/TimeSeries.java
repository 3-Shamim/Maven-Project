package time_series;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeSeries {

    private DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public TimeSeries() {

        decimalFormat.setRoundingMode(RoundingMode.CEILING);
    }

    public List<Double> getSeasonalAndIrregularity(List<Double> yValues, List<Double> cmaValues, int period) {


        List<Double> S_I = new ArrayList<>();

        for (int i = 0; i < cmaValues.size(); i++) {
            Double value = yValues.get(i + (period / 2)) / cmaValues.get(i);
            S_I.add(Double.valueOf(decimalFormat.format(value)));
        }


        return S_I;
    }

    public List<Double> getAllSeasonalComponent(List<Double> siValues, int period) {

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
    }


    public List<Double> getSeasonalData(int period, int dataSize, List<Double> sessionalComponent) {
        List<Double> seasonalData = new ArrayList<>();

        for (int i = 0; i <= (dataSize / period); i++) {
            seasonalData.addAll(sessionalComponent);
        }

        return seasonalData;
    }


    public List<Double> getDeseasonalizeValue(List<Double> yValues, List<Double> sValues) {
        List<Double> deseasonalizeValue = new ArrayList<>();

        for (int i = 0; i < yValues.size(); i++) {
            deseasonalizeValue.add(Double.valueOf(decimalFormat.format(yValues.get(i) / sValues.get(i))));
        }

        return deseasonalizeValue;
    }

    public List<Double> get_T_Values(List<Double> xValue, int period, double y_intercept, double slope) {

        List<Double> result = new ArrayList<>();

        for (int i = 0; i < xValue.size() + period; i++) {
            result.add(Double.valueOf(decimalFormat.format(y_intercept + (slope * (i+1)))));
        }

        return result;
    }

    public List<Double> getForecastValues(List<Double> t_Values, List<Double> s_Values) {

        List<Double> result = new ArrayList<>();

        for (int i = 0; i < t_Values.size(); i++) {
            result.add(Double.valueOf(decimalFormat.format(t_Values.get(i) * s_Values.get(i))));
        }

        return result;
    }



}

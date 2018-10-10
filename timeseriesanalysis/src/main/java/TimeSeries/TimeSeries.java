package TimeSeries;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeSeries {

    private DecimalFormat decimalFormat;

    public TimeSeries() {
        decimalFormat = new DecimalFormat("#.##");
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

    public Map<Integer, Double> getAllSeasonalComponent(List<Double> siValues, int period) {

        Map<Integer, List<Double>> allSeasonalComponent = new HashMap<>();
        Map<Integer, Double> allSeasonalComponentAverage = new HashMap<>();


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
            allSeasonalComponentAverage.put(key, Double.valueOf(decimalFormat.format(averageValue)));
        });

        return allSeasonalComponentAverage;
    }

}

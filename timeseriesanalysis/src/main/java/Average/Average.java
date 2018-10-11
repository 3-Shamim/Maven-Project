package Average;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Average {

    private DecimalFormat decimalFormat;

    public Average() {
        decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setRoundingMode(RoundingMode.CEILING);
    }

    public double getAverage(List<Double> values) {

        return Double.parseDouble(decimalFormat.format(values.stream().mapToDouble(value -> value).sum() / values.size()));
    }


    public List<Double> getMovingAverage(List<Double> yValues, int period) {
        List<Double> movingAverage = new ArrayList<>();
        double sum = 0.0;

        for (int i = 0; i < yValues.size() - (period - 1); i++) {

            for (int j = i; j < period + i; j++)
                sum += yValues.get(j);

            movingAverage.add(Double.valueOf(decimalFormat.format(sum / period)));
            sum = 0.0;
        }

        return movingAverage;
    }

}

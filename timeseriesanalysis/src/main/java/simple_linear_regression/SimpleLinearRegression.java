package simple_linear_regression;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class SimpleLinearRegression {

    private DecimalFormat decimalFormat = new DecimalFormat("#.##");

    private List<Double> xValue;
    private List<Double> yValue;
    private int n;


    public SimpleLinearRegression(List<Double> xValue, List<Double> yValue) {
        this.xValue = xValue;
        this.yValue = yValue;
        decimalFormat.setRoundingMode(RoundingMode.CEILING);
        n = xValue.size() - 1;
    }

    public double getY_Intercept() {
        double slope = get_r_Value() * (get_Sy_value() / get_Sx_value());
        return Double.parseDouble(decimalFormat.format(getMeanOfY() - (slope * getMeanOfX())));
    }

    public double getSlope() {
        return Double.parseDouble(decimalFormat.format(get_r_Value() * (get_Sy_value() / get_Sx_value())));
    }

    private double getMeanOfX() {
        return Double.parseDouble(decimalFormat.format(xValue.stream().mapToDouble(x -> x).sum()/xValue.size()));
    }

    private double getMeanOfY() {
        return Double.parseDouble(decimalFormat.format(yValue.stream().mapToDouble(y -> y).sum()/yValue.size()));
    }

    private List<Double> xMinus_xMean() {
        List<Double> xMinus_xMean = new ArrayList<>();

        xValue.forEach(x -> {
            xMinus_xMean.add(Double.valueOf(decimalFormat.format(x - getMeanOfX())));
        });

        return xMinus_xMean;
    }

    private List<Double> yMinus_yMean() {
        List<Double> yMinus_yMean = new ArrayList<>();

        yValue.forEach(y -> {
            yMinus_yMean.add(Double.valueOf(decimalFormat.format(y - getMeanOfY())));
        });

        return yMinus_yMean;
    }

    private List<Double> xMinus_xMean_Multiple_yMinus_yMean() {
        List<Double> result = new ArrayList<>();

        for (int i = 0; i < xMinus_xMean().size(); i++) {
            double value = xMinus_xMean().get(i) * yMinus_yMean().get(i);
            result.add(Double.valueOf(decimalFormat.format(value)));
        }

        return result;
    }

    private double sumOf_xMinus_xMean_Multiple_yMinus_yMean() {
        return Double.parseDouble(decimalFormat.format(xMinus_xMean_Multiple_yMinus_yMean().stream().mapToDouble(v -> v).sum()));
    }

    private List<Double> square_xMinus_xMean() {
        List<Double> result = new ArrayList<>();

        xMinus_xMean().forEach(x -> {
            result.add(Double.valueOf(decimalFormat.format(Math.pow(x, 2))));
        });

        return result;
    }

    private List<Double> square_yMinus_yMean() {
        List<Double> result = new ArrayList<>();

        yMinus_yMean().forEach(y -> {
            result.add(Double.valueOf(decimalFormat.format(Math.pow(y, 2))));
        });

        return result;
    }

    private double sumOf_square_xMinus_xMean() {
        return Double.parseDouble(decimalFormat.format(square_xMinus_xMean().stream().mapToDouble(x -> x).sum()));
    }

    private double sumOf_square_yMinus_yMean() {
        return Double.parseDouble(decimalFormat.format(square_yMinus_yMean().stream().mapToDouble(y -> y).sum()));
    }

    private double get_r_Value() {
           return sumOf_xMinus_xMean_Multiple_yMinus_yMean() / Math.sqrt(sumOf_square_xMinus_xMean() * sumOf_square_yMinus_yMean());
    }

    private double get_Sy_value() {
        return Math.sqrt((sumOf_square_yMinus_yMean() / n));
    }

    private double get_Sx_value() {
        return Math.sqrt(sumOf_square_xMinus_xMean() / n);
    }

}

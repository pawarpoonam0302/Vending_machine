package demo.machine;

public class Coin {

    private double value;

    public Coin(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Coin: " + value;
    }
}

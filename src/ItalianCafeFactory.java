public class ItalianCafeFactory implements CafeFactory {
    @Override
    public Coffee[] getCoffees() {
        return new Coffee[] { new ItalianCoffee("Espresso"), new ItalianCoffee("Cappuccino"), new ItalianCoffee("Latte") };
    }

    @Override
    public Snack[] getSnacks() {
        return new Snack[] { new ItalianSnack("Cannoli"), new ItalianSnack("Tiramisu"), new ItalianSnack("Biscotti") };
    }
}
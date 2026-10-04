
public class FrenchCafeFactory implements CafeFactory {
    @Override
    public Coffee[] getCoffees() {
        return new Coffee[] { new FrenchCoffee("Café au Lait"), new FrenchCoffee("Cappuccino"), new FrenchCoffee("Macchiato") };
    }

    @Override
    public Snack[] getSnacks() {
        return new Snack[] { new FrenchSnack("Croissant"), new FrenchSnack("Éclair"), new FrenchSnack("Madeleine") };
    }
}

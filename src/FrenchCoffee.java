public class FrenchCoffee implements Coffee {
    private String name;
    public FrenchCoffee(String name) { this.name = name; }
    @Override
    public String getName() { return name; }
}
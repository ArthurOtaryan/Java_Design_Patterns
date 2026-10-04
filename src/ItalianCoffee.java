public class ItalianCoffee implements Coffee {
    private String name;
    public ItalianCoffee(String name) { this.name = name; }
    @Override
    public String getName() { return name; }
}
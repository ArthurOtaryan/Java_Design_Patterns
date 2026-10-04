public class FrenchSnack implements Snack {
    private String name;
    public FrenchSnack(String name) { this.name = name; }
    @Override
    public String getName() { return name; }
}
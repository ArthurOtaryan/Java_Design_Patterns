public class ItalianSnack implements Snack {
    private String name;
    public ItalianSnack(String name) { this.name = name; }
    @Override
    public String getName() { return name; }
}
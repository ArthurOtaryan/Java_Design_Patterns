import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CoffeeShopDemo {
    private JFrame frame;
    private JPanel panel;
    private CafeFactory currentFactory;
    private Coffee selectedCoffee;
    private Snack selectedSnack;

    public CoffeeShopDemo() {
        frame = new JFrame("Interactive Coffee Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.add(panel);

        showCafeSelection();

        frame.setVisible(true);
    }

    private void showCafeSelection() {
        panel.removeAll();
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 20, 20));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JLabel title = new JLabel("Choose a Cafe:", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        panel.add(title, BorderLayout.NORTH);

        JButton italianBtn = new JButton("🇮🇹 Italian Cafe");
        JButton frenchBtn = new JButton("🇫🇷 French Cafe");

        italianBtn.addActionListener(e -> {
            currentFactory = new ItalianCafeFactory();
            showCoffeeSelection();
        });
        frenchBtn.addActionListener(e -> {
            currentFactory = new FrenchCafeFactory();
            showCoffeeSelection();
        });

        buttonsPanel.add(italianBtn);
        buttonsPanel.add(frenchBtn);
        panel.add(buttonsPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    private void showCoffeeSelection() {
        panel.removeAll();
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(currentFactory.getCoffees().length, 1, 10, 10));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JLabel title = new JLabel("Choose your Coffee:", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(title, BorderLayout.NORTH);

        for (Coffee coffee : currentFactory.getCoffees()) {
            JButton btn = new JButton(coffee.getName());
            btn.addActionListener(e -> {
                selectedCoffee = coffee;
                showSnackSelection();
            });
            buttonsPanel.add(btn);
        }

        panel.add(buttonsPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    private void showSnackSelection() {
        panel.removeAll();
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(currentFactory.getSnacks().length, 1, 10, 10));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JLabel title = new JLabel("Choose your Snack:", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(title, BorderLayout.NORTH);

        for (Snack snack : currentFactory.getSnacks()) {
            JButton btn = new JButton(snack.getName());
            btn.addActionListener(e -> {
                selectedSnack = snack;
                showFinalOrder();
            });
            buttonsPanel.add(btn);
        }

        panel.add(buttonsPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    private void showFinalOrder() {
        panel.removeAll();
        JPanel orderPanel = new JPanel();
        orderPanel.setLayout(new GridLayout(4, 1, 10, 10));
        orderPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JLabel title = new JLabel("Your Order:", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        orderPanel.add(title);

        JLabel cafeLabel = new JLabel("Cafe: " + (currentFactory instanceof ItalianCafeFactory ? "Italian" : "French"), SwingConstants.CENTER);
        JLabel coffeeLabel = new JLabel("Coffee: " + selectedCoffee.getName(), SwingConstants.CENTER);
        JLabel snackLabel = new JLabel("Snack: " + selectedSnack.getName(), SwingConstants.CENTER);

        orderPanel.add(cafeLabel);
        orderPanel.add(coffeeLabel);
        orderPanel.add(snackLabel);

        JButton restartBtn = new JButton("← Start Over");
        restartBtn.addActionListener(e -> showCafeSelection());
        orderPanel.add(restartBtn);

        panel.add(orderPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CoffeeShopDemo::new);
    }
}

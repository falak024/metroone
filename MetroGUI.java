import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class MetroGUI extends JFrame {

    private MetroGraph metro;
    private JComboBox<String> sourceBox;
    private JComboBox<String> destinationBox;
    private JTextArea resultArea;

    public MetroGUI(MetroGraph metro) {

        this.metro = metro;

        setTitle("Delhi Metro Route Finder");
        setSize(750, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(245, 247, 250));

        // HEADER
        JPanel header = new JPanel();
        header.setBackground(new Color(0, 51, 102));
        header.setBorder(new EmptyBorder(15, 10, 15, 10));

        JLabel title = new JLabel("🚇 Delhi Metro Route Finder");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));

        header.add(title);
        add(header, BorderLayout.NORTH);

        // Stations
        String[] stations = metro.getGraph().keySet().toArray(new String[0]);

        sourceBox = new JComboBox<>(stations);
        destinationBox = new JComboBox<>(stations);

        styleComboBox(sourceBox);
        styleComboBox(destinationBox);

        // Buttons
        JButton findButton = new JButton("🔍 Find Route");
        JButton swapButton = new JButton("🔄 Swap");
        JButton clearButton = new JButton("🗑 Clear");

        styleButton(findButton);
        styleButton(swapButton);
        styleButton(clearButton);

        // Control Panel
        JPanel controlPanel = new JPanel(new GridLayout(4, 2, 15, 15));
        controlPanel.setBackground(Color.WHITE);
        controlPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        controlPanel.add(new JLabel("Source Station"));
        controlPanel.add(sourceBox);

        controlPanel.add(new JLabel("Destination Station"));
        controlPanel.add(destinationBox);

        controlPanel.add(findButton);
        controlPanel.add(swapButton);

        controlPanel.add(clearButton);
        controlPanel.add(new JLabel());

        add(controlPanel, BorderLayout.SOUTH);

        // Result Area
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        resultArea.setBackground(new Color(252, 252, 252));
        resultArea.setMargin(new Insets(20, 20, 20, 20));
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                "Route Details"
        ));

        add(scrollPane, BorderLayout.CENTER);

        // FIND ROUTE
        findButton.addActionListener(e -> {

            String source = (String) sourceBox.getSelectedItem();
            String destination = (String) destinationBox.getSelectedItem();

            if (source.equals(destination)) {
                resultArea.setText(
                        "⚠ Please select different source and destination stations."
                );
                return;
            }

            PathResult result = metro.findShortestPath(source, destination);

            if (result.getDistance() == Integer.MAX_VALUE) {
                resultArea.setText("❌ No route found.");
                return;
            }

            int distance = result.getDistance();
            int fare = calculateFare(distance);
            int time = (int) Math.ceil(distance * 1.6);

            StringBuilder output = new StringBuilder();

            output.append("🚇 DELHI METRO ROUTE\n");

            output.append("📍 From: ").append(source).append("\n");
            output.append("📍 To: ").append(destination).append("\n\n");

            output.append("🛤 Route Summary:\n\n");

            List<String> path = result.getPath();

            output.append("📍 Source: ")
                    .append(path.get(0))
                    .append("\n\n");

            String previousLine = "";
            boolean interchangeFound = false;

            for (int i = 0; i < path.size() - 1; i++) {

                String from = path.get(i);
                String to = path.get(i + 1);

                String currentLine = metro.getLine(from, to);

                if (!previousLine.isEmpty()
                        && !previousLine.equals(currentLine)) {

                    output.append("🔁 Change to ")
                            .append(currentLine)
                            .append(" Line at ")
                            .append(from)
                            .append("\n");

                    interchangeFound = true;
                }

                previousLine = currentLine;
            }

            if (!interchangeFound) {
                output.append("✅ No Interchange Required\n");
            }

            output.append("\n📍 Destination: ")
                    .append(path.get(path.size() - 1))
                    .append("\n");

            output.append("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

            output.append("\n📏 Distance : ")
                    .append(distance)
                    .append(" km");

            output.append("\n💰 Fare : ₹")
                    .append(fare);

            output.append("\n⏱ Estimated Time : ")
                    .append(time)
                    .append(" minutes");


            output.append("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

            resultArea.setText(output.toString());
        });

        // SWAP
        swapButton.addActionListener(e -> {

            Object temp = sourceBox.getSelectedItem();

            sourceBox.setSelectedItem(destinationBox.getSelectedItem());

            destinationBox.setSelectedItem(temp);
        });

        // CLEAR
        clearButton.addActionListener(e -> {

            sourceBox.setSelectedIndex(0);
            destinationBox.setSelectedIndex(0);

            resultArea.setText("");
        });

        setVisible(true);
    }

    private void styleComboBox(JComboBox<String> comboBox) {

        comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        comboBox.setBackground(Color.WHITE);
    }

    private void styleButton(JButton button) {

        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setBackground(new Color(0, 102, 204));
        button.setForeground(Color.WHITE);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(0, 80, 170));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(0, 102, 204));
            }
        });
    }

    private int calculateFare(int distance) {

        if (distance <= 5)
            return 11;
        else if (distance <= 12)
            return 21;
        else if (distance <= 21)
            return 32;
        else if (distance <= 32)
            return 43;
        else if (distance <= 43)
            return 54;
        else
            return 64;
    }
}
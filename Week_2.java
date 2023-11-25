import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Week_2 extends JFrame {
    private static final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final Map<String, String> linkStorage = new HashMap<>();

    private JTextField lUF;
    private JTextField sUF;

    public Week_2() {
        super("Link Shortener");

        lUF = new JTextField();
        JButton shortenButton = new JButton("Shorten URL");
        shortenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String longUrl = lUF.getText();
                String shortUrl = shortenUrl(longUrl);
                sUF.setText(shortUrl);
            }
        });

        sUF = new JTextField();
        JButton retrieveButton = new JButton("Retrieve Long URL");
        retrieveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String shortUrl = sUF.getText();
                displayLongUrl(shortUrl);
            }
        });

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Enter the long URL:"));
        add(lUF);
        add(shortenButton);
        add(new JLabel("Shortened URL:"));
        add(sUF);
        add(retrieveButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    private String shortenUrl(String longUrl) {
        long uniqueId = generateUniqueId(longUrl);
        String shortLink = convertToBase62(uniqueId);
        linkStorage.put(shortLink, longUrl);
        return shortLink;
    }

    public static String getLongUrl(String shortUrl) {
        return linkStorage.get(shortUrl);
    }

    private void displayLongUrl(String shortUrl) {
        String retrievedLongUrl = getLongUrl(shortUrl);
        if (retrievedLongUrl != null) {
            JOptionPane.showMessageDialog(this, "Original (Long) URL: " + retrievedLongUrl);
        } else {
            JOptionPane.showMessageDialog(this, "No matching long URL found for the given short URL.");
        }
    }

    private long generateUniqueId(String longUrl) {
        UUID uuid = UUID.nameUUIDFromBytes(longUrl.getBytes());
        return uuid.getMostSignificantBits();
    }

    private String convertToBase62(long value) {
        StringBuilder shortLink = new StringBuilder();
        while (value > 0) {
            shortLink.insert(0, BASE62.charAt((int) (value % 62)));
            value /= 62;
        }
        return shortLink.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Week_2().setVisible(true);
            }
        });
    }
}
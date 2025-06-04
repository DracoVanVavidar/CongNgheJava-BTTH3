import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShoeGallery extends JFrame {
    private JLabel mainImage;

    public ShoeGallery() {
        setTitle("Giày Sneaker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLayout(new BorderLayout());

        // Hiển thị ảnh chính
        mainImage = new JLabel();
        mainImage.setHorizontalAlignment(JLabel.CENTER);
        mainImage.setIcon(new ImageIcon("img1.png"));
        add(mainImage, BorderLayout.CENTER);

        // Panel ảnh thu nhỏ
        JPanel thumbnailsPanel = new JPanel();
        thumbnailsPanel.setLayout(new BoxLayout(thumbnailsPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(thumbnailsPanel);
        scrollPane.setPreferredSize(new Dimension(200, getHeight()));

        String[] imageFiles = {
            "img1.png", "img2.png", "img3.png",
            "img4.png", "img5.png", "img6.png"
        };

        for (String fileName : imageFiles) {
            ImageIcon icon = new ImageIcon(fileName);
            Image scaledImage = icon.getImage().getScaledInstance(180, 120, Image.SCALE_SMOOTH);
            JLabel thumb = new JLabel(new ImageIcon(scaledImage));
            thumb.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            thumb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            thumb.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    mainImage.setIcon(new ImageIcon(fileName));
                }
            });
            thumbnailsPanel.add(thumb);
        }

        add(scrollPane, BorderLayout.EAST);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ShoeGallery::new);
    }
}
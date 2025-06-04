import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ProductGallery extends JFrame {
    private JPanel LeftPanel;
    private JLabel ImageLabel, NameLabel, PriceLabel, BrandLabel, DescriptionLabel;

    class Product {
        String Ten, Gia, ThuongHieu, MoTa, Anh;

        Product(String ten, String gia, String thuongHieu, String moTa, String anh) {
            this.Ten = ten;
            this.Gia = gia;
            this.ThuongHieu = thuongHieu;
            this.MoTa = moTa;
            this.Anh = anh;
        }
    }

    private ArrayList<Product> DanhSachSanPham = new ArrayList<>();

    public ProductGallery() {
        setTitle("Product Gallery");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel MainPanel = new JPanel(new GridLayout(1, 2));
        LeftPanel = new JPanel();
        LeftPanel.setLayout(new BoxLayout(LeftPanel, BoxLayout.Y_AXIS));
        LeftPanel.setBorder(BorderFactory.createTitledBorder("Product Details"));

        ImageLabel = new JLabel();
        NameLabel = new JLabel();
        PriceLabel = new JLabel();
        BrandLabel = new JLabel();
        DescriptionLabel = new JLabel();

        ImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ImageLabel.setPreferredSize(new Dimension(250, 250));

        LeftPanel.add(ImageLabel);
        LeftPanel.add(Box.createVerticalStrut(10));
        LeftPanel.add(NameLabel);
        LeftPanel.add(PriceLabel);
        LeftPanel.add(BrandLabel);
        LeftPanel.add(DescriptionLabel);

        JPanel RightPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        RightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        ThemSanPham("4DFWD PULSE SHOES", "160.00$", "Adidas",
                "This product is excluded from all promotional discunts and offers", "img1.png");
        ThemSanPham("FORUM MID SHOES", "100.00$", "Adidas",
                "This product is excluded from all promotional discunts and offers", "img2.png");
        ThemSanPham("SUPERNOVA SHOES", "150.00$", "Adidas", "NMD City Stock 2", "img3.png");
        ThemSanPham("Adidas", "160.00$", "Adidas", "NMD City Stock 2", "img4.png");
        ThemSanPham("Adidas", "120.00$", "Adidas", "NMD City Stock 2", "img5.png");
        ThemSanPham("4DFWD PULSE SHOES", "160.00$", "Adidas",
                "This product is excluded from all promotional discunts and offers", "img6.png");

        for (Product sp : DanhSachSanPham) {
            RightPanel.add(TaoSanPhamPanel(sp));
        }

        MainPanel.add(LeftPanel);
        MainPanel.add(RightPanel);

        add(MainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void ThemSanPham(String ten, String gia, String thuongHieu, String moTa, String anh) {
        DanhSachSanPham.add(new Product(ten, gia, thuongHieu, moTa, anh));
    }

    private JPanel TaoSanPhamPanel(Product sp) {
        JPanel P = new JPanel();
        P.setLayout(new BorderLayout());
        P.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        JLabel TenLabel = new JLabel(sp.Ten, SwingConstants.CENTER);
        JLabel MoTaLabel = new JLabel(sp.MoTa, SwingConstants.CENTER);
        JLabel AnhLabel = new JLabel();
        JLabel ThuongHieuLabel = new JLabel(sp.ThuongHieu);
        JLabel GiaLabel = new JLabel(sp.Gia, SwingConstants.RIGHT);

        try {
            ImageIcon icon = new ImageIcon(sp.Anh);
            Image scaled = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            AnhLabel.setIcon(new ImageIcon(scaled));
        } catch (Exception e) {
            AnhLabel.setText("[Không tải được ảnh]");
        }

        JPanel Tren = new JPanel(new GridLayout(2, 1));
        Tren.add(TenLabel);
        Tren.add(MoTaLabel);

        JPanel Duoi = new JPanel(new BorderLayout());
        Duoi.add(ThuongHieuLabel, BorderLayout.WEST);
        Duoi.add(GiaLabel, BorderLayout.EAST);

        P.add(Tren, BorderLayout.NORTH);
        P.add(AnhLabel, BorderLayout.CENTER);
        P.add(Duoi, BorderLayout.SOUTH);

        P.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                CapNhatThongTin(sp);
            }
        });

        return P;
    }

    private void CapNhatThongTin(Product sp) {
        try {
            ImageIcon icon = new ImageIcon(sp.Anh);
            Image scaled = icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
            ImageLabel.setIcon(new ImageIcon(scaled));
        } catch (Exception e) {
            ImageLabel.setText("[Không tải được ảnh]");
        }

        NameLabel.setText(sp.Ten);
        PriceLabel.setText(sp.Gia);
        BrandLabel.setText(sp.ThuongHieu);
        DescriptionLabel.setText(sp.MoTa);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductGallery());
    }
}

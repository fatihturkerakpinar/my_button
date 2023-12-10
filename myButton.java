import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// JButtondaki birkaç tipi kullandık
public class myButton extends JButton {
    private String graphQL;
    private boolean Active;
    private Color activeColor;
    private Color passiveColor;
    private ImageIcon activeIcon;
    private ImageIcon passiveIcon;
    //bir constraction tanımladım
    public myButton(String text, String graphQL, Color activeColor, Color passiveColor,
                        ImageIcon activeIcon, ImageIcon passiveIcon) {
        super(text);
        this.graphQL = graphQL;
        this.activeColor = activeColor;
        this.passiveColor = passiveColor;
        this.activeIcon = activeIcon;
        this.passiveIcon = passiveIcon;
        this.Active = false;

    // addActionListenerden override ediyorum
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleState();
                Mutation();
            }
        });

        updateAppearance();
    }

    private void toggleState() {
        Active = !Active;
        updateAppearance();
    }
    //buton aktifse ve aktif değilse gibi durumlar için if else ile koşul kodladım
    private void updateAppearance() {
        if (Active) {
            setBackground(activeColor);
            setIcon(activeIcon);
        } else {
            setBackground(passiveColor);
            setIcon(passiveIcon);
        }
    }

    private void Mutation() {
        // Burada belirtilen GraphQL şemasında bir mutation çalıştırılabilir.
        // graphQLve Active özellikleri kullanılabilir.
        System.out.println("myAdress: " + graphQL);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 4));
    // 4x4 bir tablo oluşturduk
        // Örnek icon'ları ve renkleri tanımlayınız.
        ImageIcon activeIcon = new ImageIcon("path/to/active_icon.png");
        ImageIcon passiveIcon = new ImageIcon("path/to/passive_icon.png");
        Color activeColor = Color.GREEN;
        Color passiveColor = Color.RED;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String graphQL = "adress_" + i + "_" + j;
                myButton button = new myButton("Button " + (i * 4 + j + 1),
                        graphQL, activeColor, passiveColor, activeIcon, passiveIcon);
                frame.add(button);
            }
        }

        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}

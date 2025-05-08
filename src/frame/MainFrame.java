package frame;


import cart.Cart;
import product.ProductList;
import user.User;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainFrame extends JFrame {

    Cart cart = new Cart();

    public MainFrame() {

        System.out.println("main frame");

        setTitle("상점");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);        //화면 중앙에 띄우기
        setResizable(false);                //화면 사이즈 조절 x

//      mainPanel.setLayout(null);          //래이아웃 없이 좌표로 위치 잡음

//        //x버튼 클릭 시 시스템 종료
//        WindowListener windowListener = new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                super.windowClosing(e);
//                System.exit(0);
//            }
//        };
//        addWindowListener(windowListener);


        JPanel northPanel = new NorthPanel(this);
//        add(northPanel, BorderLayout.NORTH);



        JPanel storePanel = new StorePanel();
        add(storePanel);

//        JPanel cartPanel = new CartPanel(cart);
//        setContentPane(new CartPanel(cart));


        setVisible(true);
    }

}

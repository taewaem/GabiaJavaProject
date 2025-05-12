package frame;

import cart.Cart;
import cart.CartItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CartPanel extends JPanel {

    private JTable cartTable;
    private DefaultTableModel tableModel;
    private JLabel totalLabel;
    private JButton deleteButton;
    private JButton purchaseButton;

    private Cart cart;

    public CartPanel(Cart cart) {
        this.cart = cart;
        setLayout(new BorderLayout());

        // 테이블 모델
        tableModel = new DefaultTableModel(new Object[]{"이름", "수량", "가격"}, 0);
        cartTable = new JTable(tableModel);

        // 총 금액 표시 (먼저 생성!)
        totalLabel = new JLabel(); // 초기화
        totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        totalLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 버튼들
        deleteButton = new JButton("삭제");
        purchaseButton = new JButton("구매하기");

        // 버튼 패널
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(deleteButton);
        buttonPanel.add(purchaseButton);

        // 테이블, 총합 표시, 버튼 부착
        add(new JScrollPane(cartTable), BorderLayout.CENTER);
        add(totalLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        // 🔥 이제야 안전하게 호출 가능
        refreshCartTable();

        // 버튼 이벤트
        deleteButton.addActionListener(e -> {
            int selectedRow = cartTable.getSelectedRow();
            if (selectedRow != -1) {
                String name = (String) tableModel.getValueAt(selectedRow, 0);
                refreshCartTable();
            }
        });

        purchaseButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "구매 완료! 감사합니다.");
            cart.clear();
            refreshCartTable();
        });
    }


    private void refreshCartTable() {
        tableModel.setRowCount(0); // 기존 행 제거
        for (CartItem item : cart.getItems()) {
            tableModel.addRow(new Object[]{
                    item.getProduct().getName(),
                    item.getQuantity(),
                    item.getProduct().getPrice() * item.getQuantity()
            });
        }
        totalLabel.setText("총 금액: ₩" + cart.getTotalPrice());
    }

}

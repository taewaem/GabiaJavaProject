package frame;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel {

    public CenterPanel(){

        //이미지 불러오기
        ImageIcon inputImg = new ImageIcon("./image/경로");
        Image resizeInputImg = inputImg.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon resizedInputImg = new ImageIcon(resizeInputImg);
        JButton imgButton = new JButton(resizedInputImg);           //이미지 추가

        setLayout(new BorderLayout(10, 10));


        JLabel inputTitle = new JLabel("찾는 영양제가 있으신가요?", SwingConstants.CENTER);
        inputTitle.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        JTextField inputText = new JTextField("");

        // 중앙 라벨
        JLabel improveLabel = new JLabel("개선하고 싶은 부분은?", SwingConstants.CENTER);
        improveLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        add(improveLabel, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new BorderLayout(5,5));
        inputPanel.add(inputTitle, BorderLayout.NORTH);
        inputPanel.add(inputText, BorderLayout.CENTER);
        inputPanel.add(improveLabel, BorderLayout.SOUTH);
        add(inputPanel, BorderLayout.NORTH);


        // 아래 버튼들
        JPanel improvePanel = new JPanel(new GridLayout(3, 7, 10, 10));
        String[] improveItems = {
                "장건강", "눈건강", "장 건강", "장 건강", "면역 기능",
                "스트레스 수면", "체지방", "면역 기능", "면역 기능", "면역 기능"
        };
        for (String item : improveItems) {
            improvePanel.add(new JButton(item));
        }

        add(improvePanel, BorderLayout.CENTER);

        setVisible(true);
    }
}

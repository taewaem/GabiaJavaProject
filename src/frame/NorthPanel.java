package frame;

import user.UserJoinForm;
import user.UserLoginForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NorthPanel extends JPanel implements ActionListener {

    private JLabel titleLabel;
    private JButton loginButton;
    private JButton joinButton;
    private JButton myInfoButton;

    private FrameUtil frameUtil;

    public NorthPanel(JFrame mainFrame) {

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        titleLabel = new JLabel("상점", SwingConstants.CENTER);
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        titleLabel.setForeground(new Color(33, 33, 33));
        add(titleLabel, BorderLayout.CENTER);

        //로그인/ 회원가입 버튼 오른쪽 정렬
        //FlowLayout 왼쪽부터 자동정렬
        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        loginButton = new JButton("로그인");
        joinButton = new JButton("회원가입");

        userPanel.add(loginButton);
        userPanel.add(joinButton);
        add(userPanel, BorderLayout.SOUTH);

        //이벤트 등록
        joinButton.addActionListener(e -> {
            JPanel joinPanel = new UserJoinForm();
            FrameUtil.switchPanel(mainFrame.getContentPane(), joinPanel);
        });

        loginButton.addActionListener(e -> {
            // 로그인 버튼 클릭 시 LoginForm 패널로 교체
            JPanel loginPanel = new UserLoginForm();
            FrameUtil.switchPanel(mainFrame.getContentPane(), loginPanel);
        });


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {

        }
    }
}

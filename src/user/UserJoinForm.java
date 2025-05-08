package user;

import frame.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserJoinForm extends JPanel implements ActionListener {

    private JTextField loginIdField;
    private JPasswordField passwordField;
    private JTextField nicknameField;

    private JButton signupButton;
    private JButton cancelButton;

    private UserMap userMap;

    public UserJoinForm() {

        System.out.println("user join form");

        userMap = new UserMap();

        setLayout(new BorderLayout());

        JPanel signupPanel = new JPanel(new GridLayout(3,2,10,10));

        signupPanel.add(new JLabel("아이디: "));
        loginIdField = new JTextField(10);
        signupPanel.add(loginIdField);

        signupPanel.add(new JLabel("패스워드: "));
        passwordField = new JPasswordField(15);
        signupPanel.add(passwordField);

        signupPanel.add(new JLabel("닉네임: "));
        nicknameField = new JTextField(10);
        signupPanel.add(nicknameField);

        add(signupPanel, BorderLayout.CENTER);


        //버튼 패널
        JPanel buttonPanel = new JPanel();
        signupButton = new JButton("회원가입");
        cancelButton = new JButton("취소");

        signupButton.addActionListener(this);
        cancelButton.addActionListener(this);

        buttonPanel.add(signupButton);
        buttonPanel.add(cancelButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == signupButton) {
            String loginId = loginIdField.getText();
            String password = new String(passwordField.getPassword());
            String nickname = nicknameField.getText();

            if (loginId.isEmpty() || password.isEmpty() || nickname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "항목을 입력해주세요");
                System.out.println(this);
            } else if (userMap.containsUser(loginId)) {
                JOptionPane.showMessageDialog(this, "이미 존재하는 아이디입니다.");
                System.out.println(this);
            } else {
                userMap.addUser(loginId, password, nickname);
                JOptionPane.showMessageDialog(this, "회원가입 완료!");
                System.out.println(userMap.toString());

                System.out.println("아이디: " + loginId);
                System.out.println("비밀번호: " + password);
                System.out.println("닉네임: " + nickname);
                System.out.println("회원가입 성공");
            }

            //회원가입 후 메인화면 이동
            new MainFrame();

        } else if (e.getSource() == cancelButton) {
            //입력값 초기화
            loginIdField.setText("");
            passwordField.setText("");
            nicknameField.setText("");

            System.out.println("cancel join");
            new MainFrame();
        }

    }

}

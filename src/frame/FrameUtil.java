package frame;

import javax.swing.*;
import java.awt.*;

public class FrameUtil {


    /**
     * 기존 컨테이너에서 모든 컴포넌트를 제거하고 새로운 패널로 교체합니다.
     *
     * @param container 전환 대상 (예: JFrame.getContentPane() 또는 JPanel)
     * @param nextPanel 교체할 패널
     */
    public static void switchPanel(Container container, JPanel nextPanel) {
        container.removeAll();
        container.add(nextPanel);
        container.revalidate();
        container.repaint();
    }
}

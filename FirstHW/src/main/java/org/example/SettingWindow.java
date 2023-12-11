package org.example;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingWindow extends JFrame {
    private static final int WIDTH = 230;
    private static final int HEIGHT = 350;

    JButton btnStart;

    JRadioButton humanVH;
    JRadioButton humanVAI;
    JSlider sliderFieldSize;
    JSlider sliderWinLength;
    JLabel labelFieldSize;
    JLabel labelWinLength;
    GameWindow gameWindow;


    SettingWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        btnStart = new JButton("Start new game");

        setLocationRelativeTo(gameWindow);
        setSize(WIDTH, HEIGHT);

        btnStart.addActionListener(e -> {
            setVisible(false);
            int mode = humanVAI.isSelected() ? 1 : 0;
            gameWindow.startNewGame(mode, sliderFieldSize.getValue(),
                    sliderFieldSize.getValue(),
                    sliderWinLength.getValue());
        });

        add(createSettingPanel());

        add(btnStart, BorderLayout.SOUTH);
    }

    private Component createModePanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        humanVH = new JRadioButton("human versus human");
        humanVAI = new JRadioButton("human versus AI");
        JLabel jLabel = new JLabel("Select game mode");
        ButtonGroup modeGroup = new ButtonGroup();
        modeGroup.add(humanVH);
        modeGroup.add(humanVAI);
        panel.add(jLabel);
        panel.add(humanVH);
        panel.add(humanVAI);
        humanVAI.setSelected(true);
        return panel;
    }

    private Component createSizePanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        sliderFieldSize = new JSlider(3, 10, 3);
        labelFieldSize = new JLabel();
        JLabel jLabel = new JLabel("Select field size");
        panel.add(jLabel);
        panel.add(labelFieldSize);
        panel.add(sliderFieldSize);
        sliderFieldSize.addChangeListener(e -> {
            labelFieldSize.setText("Selected field size: " + sliderFieldSize.getValue());
        });
        return panel;
    }

    private Component createWinLengthPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        sliderWinLength = new JSlider(3, 10, 3);
        labelWinLength = new JLabel();
        JLabel jLabel = new JLabel("Select win length");
        panel.add(jLabel);
        panel.add(sliderWinLength);
        panel.add(labelWinLength);
        sliderWinLength.addChangeListener(e -> {
            labelWinLength.setText("Selected field size: " + sliderWinLength.getValue());
        });
        return panel;
    }

    private Component createSettingPanel() {
        JPanel settingPanel = new JPanel(new GridLayout(3, 1));
        settingPanel.add(createModePanel());
        settingPanel.add(createSizePanel());
        settingPanel.add(createWinLengthPanel());
        return settingPanel;
    }
}

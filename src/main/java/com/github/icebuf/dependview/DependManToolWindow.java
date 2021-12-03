package com.github.icebuf.dependview;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.VerticalFlowLayout;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class DependManToolWindow implements ToolWindowFactory {

    @Override
    public boolean isApplicable(@NotNull Project project) {
        return ToolWindowFactory.super.isApplicable(project);
    }

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        JPanel rootPanel = new JPanel(new VerticalFlowLayout());


        JPanel controlsPanel = new JPanel(new BorderLayout());
        controlsPanel.add(generateActionButton(23, "Enter"), BorderLayout.CENTER);
        controlsPanel.add(generateActionButton(19, "^"), BorderLayout.NORTH);
        controlsPanel.add(generateActionButton(20, "v"), BorderLayout.SOUTH);
        controlsPanel.add(generateActionButton(21, "<"), BorderLayout.WEST);
        controlsPanel.add(generateActionButton(22, ">"), BorderLayout.EAST);

//        this.connectTo = new JTextField("192.168.0.80");
//        connectedInfoText = new JLabel("Not Connected");
//        JButton connectButton = new JButton("Connect");
//        connectButton.addActionListener(e -> adbConnect());
//        JButton refreshButton = new JButton("Refresh");
//        refreshButton.addActionListener(e -> connectdCheck());
//
//        JPanel extraRow1 = new JPanel(new BorderLayout());
//        extraRow1.add(generateActionButton(4, "Back"), BorderLayout.EAST);
//        extraRow1.add(generateActionButton(3, "Home"), BorderLayout.WEST);
//
//        //Fill the content Panel
//        rootPanel.add(connectedInfoText);

        //Add the content to the toolwindow
        toolWindow.getComponent().add(rootPanel);
    }

    private JButton generateActionButton(final int androidKeyEventID, String displayText) {
        JButton button = new JButton(displayText);
//        button.addActionListener(e -> Utils.runCommand("adb shell input keyevent " + androidKeyEventID));
        return button;
    }
}

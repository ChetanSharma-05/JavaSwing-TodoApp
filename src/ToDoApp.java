import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ToDoApp extends JFrame {
    private JTextField taskField;
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;

    public ToDoApp() {
        setTitle(" To-Do List App");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center window

        // Layout
        setLayout(new BorderLayout());

        // Top panel for input
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        taskField = new JTextField();
        JButton addButton = new JButton("Add Task");
        inputPanel.add(taskField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        // Task List
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Bottom panel for delete button
        JPanel buttonPanel = new JPanel();
        JButton deleteButton = new JButton("Delete Task");
        buttonPanel.add(deleteButton);

        // Add panels to frame
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Action: Add Task
        addButton.addActionListener(e -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                taskField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Enter a task first!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Action: Delete Task
        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(this, "Select a task to delete!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ToDoApp().setVisible(true);
        });
    }
}

package imageviewer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    private Map<String, Command> commands = new HashMap<>();
    private Map<String, String> labels = new HashMap<>();

    public MainFrame() {
        setTitle("Image Viewer");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        initLabels();
        getContentPane().add(toolBar(), BorderLayout.SOUTH);
        setVisible(true);
    }

    public void add(SwingImageDisplay imageDisplay) {
        this.getContentPane().add(imageDisplay);
    }

    public void add(String id, Command command) {
        commands.put(id, command);
        System.out.println(id);
    }

    private JPanel toolBar() {
        JPanel toolbar = new JPanel();
        toolbar.setLayout(new FlowLayout(FlowLayout.CENTER));
        toolbar.add(button("P"));
        toolbar.add(button("N"));
        return toolbar;
    }

    private JButton button(String id) {
        JButton button = new JButton(labels.get(id));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                commands.get(id).execute();
            }
        });
        return button;
    }

    private void initLabels() {
        labels.put("P", "<");
        labels.put("N", ">");
    }
    
}

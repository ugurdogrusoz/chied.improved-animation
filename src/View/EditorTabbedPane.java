package View;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class EditorTabbedPane extends JTabbedPane
{
	public EditorTabbedPane()
	{
		super();
		this.addTab("General", new JPanel());
		this.addTab("Layout", new JPanel());
		this.addTab("Animation", new JPanel());
	}
}
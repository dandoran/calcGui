import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LabelChanger implements ActionListener {
	
	private Label label;
	private String newtext;
	
	public LabelChanger (Label l, String string)
	{
		label = l;
		newtext = string;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		label.setText(newtext);
		
	}

}

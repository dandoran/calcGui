import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class opPressed implements ActionListener {
	
	private Label label;
	private String newtext;
	
	public opPressed (Label l, String string)
	{
		label = l;
		newtext = string;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if(newtext.equals("clear"))
			label.setText("0");
		
		else if(label.getText().equals("0")||label.getText().contains("error"))
			label.setText("error please enter a number");
		else if(newtext.equals("+-"))
			label.setText(Double.toString(Double.valueOf(label.getText())*-1));
		else
			label.setText(label.getText() + newtext);
		
		
	}

}

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class digitPressed implements ActionListener {
	
	private Label label;
	private String newtext;
	
	public digitPressed (Label l, String string)
	{
		label = l;
		newtext = string;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if(label.getText().equals("0")||label.getText().contains("error"))
			label.setText(newtext);
		else if(label.getText().equals("0")&&newtext.equals(" ( "))
			label.setText("( ");
		else
			label.setText(label.getText() + newtext);
		
		
	}

}

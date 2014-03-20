import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;



public class equalPressed implements ActionListener {
	
	private Label label;
	private double result;
	
	public equalPressed (Label l)
	{
		label = l;
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		
		   try
		   { 
			   result = CalcGraphic.processLine(CalcGraphic.processString(label.getText()));
				
				label.setText(Double.toString(result));
		   }
		  catch(NumberFormatException nfe)
		   {
			  
		      label.setText("error bad number in equation");   
		   }
		   catch(EmptyStackException ese)
		   {
		      label.setText("error too many operations");
		   }
		   
		
	}

}

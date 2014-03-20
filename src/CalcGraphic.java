import java.awt.*;
import java.util.Stack;


import javax.swing.BoxLayout;


@SuppressWarnings("serial")
public class CalcGraphic extends Frame
{

	public static void main(String[] args)
	{
		
/*Create new window*/
		
		CalcGraphic bw = new CalcGraphic();
		
/*Set default window size*/
		
		bw.setSize(600, 500);
	
		bw.setVisible(true);

	}
	
	public CalcGraphic()
	{

/*Create label and set alignment*/
		
		super("Dan's Calculator");
		Label l = new Label("0");
		l.setFont(new Font("Serif",Font.BOLD,40));
		l.setAlignment(Label.RIGHT);
		
		Label banner = new Label("Enter your equation below:");
		
/*Create all buttons for the window*/
		
		Button num1 = new Button("1");
		Button num2 = new Button("2");
		Button num3 = new Button("3");
		Button num4 = new Button("4");
		Button num5 = new Button("5");
		Button num6 = new Button("6");
		Button num7 = new Button("7");
		Button num8 = new Button("8");
		Button num9 = new Button("9");
		Button num0 = new Button("0");
		Button period = new Button(". ");
		
		Button opPlus = new Button("+");
		Button opMinus = new Button("-");
		Button opMult = new Button("*");
		Button opDiv = new Button("/");
		Button equal = new Button("=");
		Button plusMinus = new Button("+-");
		
		Button leftParen = new Button("(  ");
		Button rightParen = new Button(")  ");
		
		Button clearBtn = new Button("clr");
		
/*Set the layout for the buttons*/
		
		BoxLayout vertical = new BoxLayout(this,BoxLayout.Y_AXIS);
		this.setLayout(vertical);
		
		Container buttons = new Container();
		BoxLayout horizontal = new BoxLayout(buttons,BoxLayout.X_AXIS);
		buttons.setLayout(horizontal);
		
		Container row1 = new Container();
		BoxLayout hor1 = new BoxLayout(row1,BoxLayout.X_AXIS);
		row1.setLayout(hor1);
		
		Container row2 = new Container();
		BoxLayout hor2 = new BoxLayout(row2,BoxLayout.X_AXIS);
		row2.setLayout(hor2);
		
		Container row3 = new Container();
		BoxLayout hor3 = new BoxLayout(row3,BoxLayout.X_AXIS);
		row3.setLayout(hor3);

		Container row4 = new Container();
		BoxLayout hor4 = new BoxLayout(row4,BoxLayout.X_AXIS);
		row4.setLayout(hor4);
		
		Container row5 = new Container();
		BoxLayout hor5 = new BoxLayout(row5,BoxLayout.X_AXIS);
		row5.setLayout(hor5);
		
/*Add all buttons to their containers*/
		
		row1.add(num7);
		row1.add(num8);
		row1.add(num9);
		row1.add(opPlus);
	
		row2.add(num4);
		row2.add(num5);
		row2.add(num6);
		row2.add(opMinus);
		
		row3.add(num1);
		row3.add(num2);
		row3.add(num3);
		row3.add(opMult);
		
		row4.add(num0);
		row4.add(period);
		row4.add(clearBtn );
		row4.add(opDiv);
		
		row5.add(leftParen);
		row5.add(rightParen);
		row5.add(plusMinus);
		row5.add(equal);
		
/*Add all containers and labels to the window*/
		
		this.add(banner);
		this.add(l);
		
		this.add(row1);
		this.add(row2);
		this.add(row3);
		this.add(row4);
		this.add(row5);

/*Add action listeners for all buttons*/
		
		num1.addActionListener(new digitPressed(l,"1"));
		num2.addActionListener(new digitPressed(l,"2"));
		num3.addActionListener(new digitPressed(l,"3"));
		num4.addActionListener(new digitPressed(l,"4"));
		num5.addActionListener(new digitPressed(l,"5"));
		num6.addActionListener(new digitPressed(l,"6"));
		num7.addActionListener(new digitPressed(l,"7"));
		num8.addActionListener(new digitPressed(l,"8"));
		num9.addActionListener(new digitPressed(l,"9"));
		num0.addActionListener(new digitPressed(l,"0"));
		period.addActionListener(new digitPressed(l,"."));
		
		opPlus.addActionListener(new opPressed(l," + "));
		opMinus.addActionListener(new opPressed(l," - "));
		opMult.addActionListener(new opPressed(l," * "));
		opDiv.addActionListener(new opPressed(l," / "));
		plusMinus.addActionListener(new opPressed(l,"+-"));
		clearBtn.addActionListener(new opPressed(l,"clear"));
		
		leftParen.addActionListener(new digitPressed(l," ( "));
		rightParen.addActionListener(new digitPressed(l," ) "));
		equal.addActionListener(new equalPressed(l));
		
/*Add Window listener for program exit*/
		
		this.addWindowListener(new Closer());
		this.setBackground(Color.GRAY);	
	}
	


// <-------------------------- Calculations ---------------------->
	
public static Stack <String> processString(String content)
	{
		String[] item = content.split("  *");
		Stack <String> output = new Stack<String>();
		Stack <String> operator = new Stack <String>();
		Stack <String> temp = new Stack <String>();
		
		
//For loop to process entire string 	
	
		for(int i = 0; i < item.length;i++)
		{
			
			if(output.isEmpty()&&!item[i].equals("("))
				output.push(item[i]);
			else if(item[i].equals("("))
				operator.push(item[i]);
			else
			{
				if(item[i].equals("+")&&!operator.isEmpty())
				{
					if(operator.peek().equals("+"))
						operator.push(item[i]);
					else if(operator.peek().equals("-"))
						operator.push(item[i]);
					else if(operator.peek().equals("*"))
					{
						output.push(output.pop());
						operator.push(item[i]);
					}
					else if(operator.peek().equals("/"))
					{
						output.push(output.pop());
						operator.push(item[i]);
					}
					else 
						operator.push(item[i]);
				}
				else if(item[i].equals("-")&&!operator.isEmpty())
				{
					if(operator.peek().equals("+"))
						operator.push(item[i]);
					else if(operator.peek().equals("-"))
						operator.push(item[i]);
					else if(operator.peek().equals("*"))
					{
						output.push(operator.pop());
						operator.push(item[i]);
					}
					else if(operator.peek().equals("/"))
					{
						output.push(operator.pop());
						operator.push(item[i]);
					}
					else
						operator.push(item[i]);
				}
				else if(item[i].equals("*")&&!operator.isEmpty())
				{
					if(operator.peek().equals("+"))
						operator.push(item[i]);
					else if(operator.peek().equals("-"))
						operator.push(item[i]);
					else if(operator.peek().equals("*"))
					{
						operator.push(item[i]);
					}
					else if(operator.peek().equals("/"))
					{
						output.push(operator.pop());
						operator.push(item[i]);
					}
					else
						operator.push(item[i]);
				}
				else if(item[i].equals("/")&&!operator.isEmpty())
				{
					if(operator.peek().equals("+"))
						operator.push(item[i]);
					else if(operator.peek().equals("-"))
						operator.push(item[i]);
					else if(operator.peek().equals("*"))
					{
						output.push(operator.pop());
						operator.push(item[i]);
				    }
					else if(operator.peek().equals("/"))
					{
						operator.push(item[i]);
					}
					else
						operator.push(item[i]);
				}
				else if(item[i].equals("(")&&!operator.isEmpty())
					operator.push(item[i]);
				else if(item[i].equals(")"))
				{	
					while(!operator.peek().equals("("))
						output.push(operator.pop());
					operator.pop();

				}
			
				else if(item[i].equals("+")||item[i].equals("-")||item[i].equals("*")||item[i].equals("/")||item[i].equals("("))
					operator.push(item[i]);
				
				else if(item[i].contains(" "))
				{}
				else
					output.push(item[i]);
			
			 }
		}
	
/*Pop off operator stack and onto output stack*/
		
		while(!operator.isEmpty())
			output.push(operator.pop());
	
/*Reverse order the stack*/
		
		while(!output.isEmpty())
			temp.push(output.pop());
		
		return temp;
		
	}
	
	
	
	public static double processLine(Stack <String> content)
	{	
		Stack <Double> stack = new Stack<Double>();
		
		double num1=0,num2=0,result=0;

/*Loop until stack is empty*/
		
		while(!content.isEmpty())
		{
			if(content.peek().equals("+"))
			{
				content.pop();
				num1 = stack.pop();
				num2 = stack.pop();
				result = num2 + num1;
				stack.push(result);
		
			}
			
			else if(content.peek().equals("-"))
			{
				content.pop();
				num1 = stack.pop();
				num2 = stack.pop();
				result = num2 - num1;
				stack.push(result);	
			}
			
			else if(content.peek().equals("*"))
			{
				content.pop();
				num1 = stack.pop();
				num2 = stack.pop();
				result = num2 * num1;
				stack.push(result);
			}
			
			else if(content.peek().equals("/"))
			{
				content.pop();
				num1 = stack.pop();
				num2 = stack.pop();
				result = num2 / num1;
				stack.push(result);
			}
			else if(content.peek().equals(""))
			{
				content.pop();
			}
			else
				stack.push(Double.parseDouble(content.pop()));
			}
		
		
		return stack.pop();
	}


}
	
	





import java.awt.BorderLayout;
import java.awt.Color;
import java.util.*;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.*;
class Student1
{
	String name;
	int age,marks;
	Student1(String name,int age,int marks)
	{
		this.name=name;
		this.age=age;
		this.marks=marks;
	}
}
class NameComparator implements Comparator<Student1>
{
	public int compare(Student1 s1,Student1 s2)
	{
		return s1.name.compareTo(s2.name);
	}
}
class AgeComparator implements Comparator<Student1>
{
	public int compare(Student1 s1,Student1 s2)
	{
		return s1.age-s2.age;
	}
}
class MarksComparator implements Comparator<Student1>
{
	public int compare(Student1 s1,Student1 s2)
	{
		return s1.marks-s2.marks;
	}
}
public class SortRecord extends JFrame implements ActionListener{

	JFrame f;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JButton btnNewButton,btnSort;
	JComboBox comboBox;
	JTextArea txtrSortingBasedOn;
	JScrollPane scroll;
	ArrayList<Student1> ar=new ArrayList<Student1>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortRecord frame = new SortRecord();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SortRecord() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 354, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(27, 25, 98, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAge.setBounds(27, 81, 98, 32);
		contentPane.add(lblAge);
		
		JLabel lblMarks = new JLabel("Marks:");
		lblMarks.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMarks.setBounds(27, 134, 98, 32);
		contentPane.add(lblMarks);
		
		textField = new JTextField();
		textField.setBounds(105, 29, 167, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(105, 85, 167, 28);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(105, 138, 167, 28);
		contentPane.add(textField_2);
		
		btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(114, 191, 89, 32);
		contentPane.add(btnNewButton);
		
		btnSort = new JButton("Sort");
		btnSort.addActionListener(this);
		btnSort.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSort.setBounds(183, 275, 89, 32);
		contentPane.add(btnSort);
		
		String options[]= {"Select","Name","Age","Marks"};
		comboBox = new JComboBox(options);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setBounds(51, 276, 74, 32);
		contentPane.add(comboBox);
		
		JLabel lblSortBy = new JLabel("Sort by:");
		lblSortBy.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblSortBy.setBounds(27, 234, 98, 32);
		contentPane.add(lblSortBy);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(179, 356, 5, 22);
		contentPane.add(textArea);
		
		txtrSortingBasedOn = new JTextArea("Sorted Data:");
		txtrSortingBasedOn.setFont(new Font("Monospaced", Font.PLAIN, 15));
		Border border = BorderFactory.createLineBorder(Color.BLACK);
	    txtrSortingBasedOn.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
	    scroll = new JScrollPane(txtrSortingBasedOn);
	    scroll.setBounds(27, 329, 279, 91);
		contentPane.add(scroll);
		scroll.setVisible(false);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnNewButton)
		{
			scroll.setVisible(false);
			if(textField.getText().length()!=0 && textField_1.getText().length()!=0 && textField_2.getText().length()!=0)
			{
				Student1 st=new Student1(textField.getText(),Integer.parseInt(textField_1.getText()),Integer.parseInt(textField_2.getText()));
				ar.add(st);
				JOptionPane.showMessageDialog(f,"Record added successfully");
				textField.setText("");textField_1.setText("");textField_2.setText("");
			}
			else
				JOptionPane.showMessageDialog(f,"Please enter a value","Alert",JOptionPane.WARNING_MESSAGE);
		}
		if(e.getSource()==btnSort)
		{
			txtrSortingBasedOn.setText("Name Age Marks");
			int index=comboBox.getSelectedIndex();
			if(index==0)
				JOptionPane.showMessageDialog(f,"Please select a value","Alert",JOptionPane.WARNING_MESSAGE);
			else
			{
				if(index==1)
				{
					Collections.sort(ar,new NameComparator());
					Iterator itr=ar.iterator();  
					while(itr.hasNext())
					{  
					Student1 st=(Student1)itr.next();  
					txtrSortingBasedOn.setText(txtrSortingBasedOn.getText()+"\n"+st.name+" "+st.age+" "+st.marks);  
					}  
				}
				else if(index==2)
				{
					Collections.sort(ar,new AgeComparator());
					Iterator itr=ar.iterator();  
					while(itr.hasNext())
					{  
					Student1 st=(Student1)itr.next();  
					txtrSortingBasedOn.setText(txtrSortingBasedOn.getText()+"\n"+st.name+" "+st.age+" "+st.marks);  
					}  
				}
				else
				{
					Collections.sort(ar,new MarksComparator());
					Iterator itr=ar.iterator();  
					while(itr.hasNext())
					{  
					Student1 st=(Student1)itr.next();  
					txtrSortingBasedOn.setText(txtrSortingBasedOn.getText()+"\n"+st.name+" "+st.age+" "+st.marks);  
					}  
				}
					scroll.setVisible(true);
			}
		}
	}
}

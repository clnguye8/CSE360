import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;


public class ActivityFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel activityPane;
	private JTextField activityTextField;
	private JTextField durationTextField;
	private JTextField predTextField;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActivityFrame frame = new ActivityFrame();
					frame.setVisible(true);
					frame.setLocation(600, 100); //determines where it opens up on the page
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Class Instance Data
	private LinkedList<ActivityNode> activityLinkedList = new LinkedList<ActivityNode>();
	ResultsFrame addGui = new ResultsFrame();
	
	public ActivityFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 400, 600);
		activityPane = new JPanel();
		activityPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(activityPane);
		activityPane.setLayout(new GridLayout(5, 1, 0, 0));
		
		
		//Title Label & Activity Panel ---------------------------------------------
		JLabel titleLabel = new JLabel("Start adding your activities here!");
		titleLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		activityPane.add(titleLabel);
		
		JPanel activityPanel = new JPanel();
		activityPane.add(activityPanel);
		
		//Activity Label, Button and Submission ---------------------------------------------
		JLabel activityLabel = new JLabel("Activity");
		activityLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		activityPanel.add(activityLabel);
		
		activityTextField = new JTextField();
		activityTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		activityPanel.add(activityTextField);
		activityTextField.setColumns(10);
	
		
		//Duration Label, Button & Submission ---------------------------------------------
		JPanel durationPanel = new JPanel();
		activityPane.add(durationPanel);
		
		JLabel durationLabel = new JLabel("Duration");
		durationLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		durationPanel.add(durationLabel);
		
		durationTextField = new JTextField();
		durationTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		durationTextField.setColumns(10);
		durationPanel.add(durationTextField);
		
		
		//Predecessor Label, Button & Submission ---------------------------------------------
		JPanel predPanel = new JPanel();
		activityPane.add(predPanel);
		
		JLabel predLabel = new JLabel("Predecessor");
		predLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		predPanel.add(predLabel);
		
		predTextField = new JTextField();
		predTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		predTextField.setColumns(10);
		predPanel.add(predTextField);
				
		
		//Results Button ---------------------------------------------
		JPanel resultsPanel = new JPanel();
		activityPane.add(resultsPanel);
		
		JButton resultsButton = new JButton("Calculate Results");
		resultsButton.setFont(new Font("Arial", Font.PLAIN, 12));
		resultsPanel.add(resultsButton);
		
		resultsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				ResultsFrame addGui = new ResultsFrame();
				addGui.setVisible(true);
			}
		});
		
		//Add Button --------------------------------------------------
		JButton addButton = new JButton("Add");
		addButton.setFont(new Font("Arial", Font.PLAIN, 12));
		resultsPanel.add(addButton);
		
		//Error Checking
		addButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				addActivity();
				String durationValue = durationTextField.getText();				
				try {
					Integer.parseInt(durationValue);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Please Insert a Valid Number");
					durationTextField.setText(durationValue.substring(0,durationValue.length()-durationValue.length()));
				}
			}
		});
	}

	private void addActivity() {
		String durationValue = durationTextField.getText();	
		activityLinkedList.add(new ActivityNode(activityTextField.getText(), Integer.parseInt(durationValue), predTextField.getText()));
		//Need to access the ResultsFrame text field
		
		for(ActivityNode act: activityLinkedList) {
			addGui.resultsField.append(act + "\n");
		}
	}
}

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class AboutFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutFrame frame = new AboutFrame();
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
	public AboutFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 400, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel aboutPortion = new JPanel();
		contentPane.add(aboutPortion);
		aboutPortion.setLayout(new BorderLayout(0, 0));
		
		JLabel lblAboutProjectManagement = new JLabel("About Project Management Tool (PMT)");
		lblAboutProjectManagement.setHorizontalAlignment(SwingConstants.CENTER);
		aboutPortion.add(lblAboutProjectManagement, BorderLayout.NORTH);
		
		JLabel lblTheprojectManagement = new JLabel("<html>"+"The “Project Management Tool (PMT): User’s Guide” will help"+"<br>"+
		"the user understand how to utilize the tool to manage their"+"<br>"+
		"activities within a network. This guide provides an overview"+"<br>"+
		"of the program that explains the main user flows and basic"+ "<br>"+ 
		"input/outputs. There is also information about how to set-up"+"<br>"+ 
		"the tool including the installation under the sections"+"<br>"+ 
		"‘Installation’ and ‘Getting Started’. The section titled,"+"<br>"+ 
		"‘User Interface’, details the key features of the PMT"+"<br>"+ 
		"including the ‘Add Activity’, ‘Calculate Results’, and" +"<br>"+ 
		"Quit/Restart buttons. The guide also exemplifies successful" +"<br>"+ 
		"executions and error-checking messages under the section" + "<br>"+ 
		"‘Example Runs’. Lastly, the guide explains how to restart" + "<br>"+ 
		"and quit the program under the sections ‘Restarting’ and" + "<br>"+ 
		"‘Ending the Program’."+"</html>");
		lblTheprojectManagement.setHorizontalAlignment(SwingConstants.CENTER);
		aboutPortion.add(lblTheprojectManagement, BorderLayout.CENTER);
		
		JPanel aboutUsPortion = new JPanel();
		contentPane.add(aboutUsPortion);
		aboutUsPortion.setLayout(new BorderLayout(0, 0));
		
		JLabel lblAboutTeamEight = new JLabel("About Team Eight");
		lblAboutTeamEight.setHorizontalAlignment(SwingConstants.CENTER);
		aboutUsPortion.add(lblAboutTeamEight, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("New label");
		aboutUsPortion.add(lblNewLabel, BorderLayout.CENTER);
	}

}

package TrafficCrashAnalysisChicago;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * TrafficAnalysisUI.java - User Interface for Traffic Data Analysis.
 * @author nsrao
 */

public class TrafficAnalysisUI extends JFrame implements ActionListener
{    
	private static Node binaryTreeLLroot = null;
	private static Node binaryTreeArrayroot = null;
	private static String password = "";
	private static BinaryTreeLLExperiments binaryTreeLL= new BinaryTreeLLExperiments();
	private static BinaryTreeArrayExperiments binaryTreeArray= new BinaryTreeArrayExperiments();
	private static BinarySearchAVLExperiments binarySearchTree =new BinarySearchAVLExperiments();
	private static BinarySearchAVLTreeLL bst = new BinarySearchAVLTreeLL();
	
	    public static void main (String []args){
	    	
	    	binaryTreeLLroot = binaryTreeLL.InsertIntoBinaryTreeLL();
	    	binaryTreeArrayroot = binaryTreeArray.InsertIntoBinaryTreeArray();
	    	binarySearchTree.InsertIntoTree();
	    	//SQLExperiments.InsertIntoDB();
	        new TrafficAnalysisUI("Menu"); 
	    }

	    
	    private TrafficAnalysisUI(String title) {
	        super(title); 
	        JTextField jtfRegLabel = new JTextField("Traffic Data Analysis", 25);
	    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,27));
	    	jtfRegLabel.setEditable(false);
	    	jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
	    	
	    	
	        setMenu(); //create menu
	        setSize(600, 500);// size
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close running program if window are closed
	        setLocationRelativeTo(null); // set window position at center
	        setResizable(false);
	        jtfRegLabel.setForeground(Color.black);
	        add(jtfRegLabel);
	        
	        show();
	        
	    }


	    JMenuItem Registration, Apie, Exit, Back;

   
	    private void setMenu() {
	    	this.setBackground(Color.BLACK);;
	        JMenuBar barObj = new JMenuBar(); // create menuBar obj
	        JMenu messagesObj = new JMenu("Menu"); //create menu bar menu object

	        
	        barObj.setBackground(Color.YELLOW); // set menu bar bg color

	        Registration = new JMenuItem("Registration"); 
	        Registration.setToolTipText("Push to register"); // write text when u hang mouse over
	        Registration.addActionListener(this);   
	        Registration.setBackground(Color.WHITE); // set menu bar menu options bg color
	        Registration.setPreferredSize(new Dimension(100,35));
	        messagesObj.add(Registration); // add Registration into messages
	        

	        Apie = new JMenuItem("Experiment");
	        Apie.setToolTipText("Push for information");
	        Apie.addActionListener(this);
	        Apie.setBackground(Color.WHITE);
	        Apie.setPreferredSize(new Dimension(100,35));
	        messagesObj.add(Apie);  

	        Exit = new JMenuItem("Exit");
	        Exit.setToolTipText("Here you will exit");
	        Exit.addActionListener(this);
	        Exit.setBackground(Color.WHITE);
	        Exit.setPreferredSize(new Dimension(100,35));
	        messagesObj.add(Exit);
	        
	        barObj.add(messagesObj);
	        setJMenuBar(barObj);
	    } //create menu end

	// implemented method
	    @Override
	    public void actionPerformed(ActionEvent e) {

	        if (e.getSource() == Registration){
	            //registReply is what u have choosen
	                AccidentRegistration ();
	        }else if (e.getSource() == Apie)
	        	ExperimentPage();                    
	        else if (e.getSource() == Exit){
	            int exitReply = JOptionPane.showConfirmDialog(this, "Exit?", 
	                    "Išeiti", JOptionPane.YES_NO_OPTION);// exitReply is what u have choosen
	                if(exitReply == JOptionPane.YES_OPTION){// if its has been chose/ program will shutdown
	                    System.exit(0);
	                }           
	        } // if end
	    }// actionPerformed

	    private void ExperimentPage()
	    {
	    	Container container = getContentPane();
	    	//final ImageIcon icon = new ImageIcon("C:\\Users\\HP\\Downloads\\bg.jpeg");	    	
	    	this.setBackground(Color.black);
	    	JTextField jtfRegLabel = new JTextField("***Experiments***", 50);
	    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
	        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
	        jtfRegLabel.setEditable(false);
	        
	        Frame frame = new Frame("Choice");
	        container.setBackground(Color.BLACK);
	        
	        JButton Exp1RegObj = new JButton("Search the accidents history of Vehicle");
	        Exp1RegObj.setBackground(Color.WHITE);
	        Exp1RegObj.setPreferredSize(new Dimension(300,30));
	        Exp1RegObj.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        JButton Exp2RegObj = new JButton("Search the victim record by Person ID");
	        Exp2RegObj.setBackground(Color.WHITE);
	        Exp2RegObj.setPreferredSize(new Dimension(300,30));
	        Exp2RegObj.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        JButton Exp3RegObj = new JButton("Search the victim details by RD No");
	        Exp3RegObj.setBackground(Color.WHITE);
	        Exp3RegObj.setPreferredSize(new Dimension(300,30));
	        Exp3RegObj.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        JButton Exp4RegObj = new JButton("Accident information occured on a date");
	        Exp4RegObj.setBackground(Color.WHITE);
	        Exp4RegObj.setPreferredSize(new Dimension(350,30));
	        Exp4RegObj.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        JButton Exp5RegObj = new JButton("City wise accident count information");
	        Exp5RegObj.setBackground(Color.WHITE);
	        Exp5RegObj.setPreferredSize(new Dimension(300,30));
	        Exp5RegObj.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        Exp1RegObj.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	Exp1Page();
	            }
	         });
	        
	        Exp2RegObj.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	Exp2Page();
	            }
	         });
	        
	        Exp3RegObj.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	Exp3Page();
	            }
	         });
	        
	        Exp4RegObj.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	Exp4Page();
	            }
	         });
	        
	        Exp5RegObj.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	Exp5Page();
	               
	            }
	         });
	        Exp2RegObj.setBackground(Color.WHITE);
	        
	        container.removeAll();
	        this.validate();
	        this.repaint();
	        container.add(jtfRegLabel);
	        container.add(Exp1RegObj); 
	        container.add(Exp2RegObj);
	        container.add(Exp3RegObj); 
	        container.add(Exp4RegObj); 
	        container.add(Exp5RegObj); 
	        container.setLayout(new FlowLayout());
	        setSize(700, 700); // set size of window
	        setVisible(true);// set it visible

	    }
	    private void AccidentRegistration(){

	        Container container = getContentPane();
	        JTextField jtfRegLabel = new JTextField("***REGISTRATION***", 50);
	        jtfRegLabel.setForeground(Color.red);
	        jtfRegLabel.setBackground(Color.black);
	        jtfRegLabel.setFont(new Font("Arial", Font.PLAIN, 15));
	        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
	        jtfRegLabel.setEditable(false);


	        
	        JTextField jtfNameLabel = new JTextField("Person ID", 25);
	        jtfNameLabel.setEditable(false);
	        JTextField jtfText1 = new JTextField(25);
	        

	        JTextField jtfTypeLabel = new JTextField("Person Type", 25);
	        jtfTypeLabel.setEditable(false);
	        
	        Frame frame = new Frame("Choice");
	        Label label = new Label("What is your Choice:");
	        Choice choice = new Choice();
	        choice.setPreferredSize(new Dimension(250,10));
	        frame.add(choice);
	        choice.add("DRIVER        ");
	        choice.add("PASSENGER        ");
	        choice.add("NON-CONTACT VEHICLE       ");
	        


	        Choice choice1 = new Choice();
	        choice1.setPreferredSize(new Dimension(250,10));
	        frame.add(choice1);
	        choice1.add("Male       ");
	        choice1.add("Female     ");

	        JTextField jtfGenderLabel = new JTextField("Person Gender ", 25);
	        jtfGenderLabel.setEditable(false);
	        
	        JTextField jtfRDNoLabel = new JTextField("RD ND", 25);
	        jtfRDNoLabel.setEditable(false);
	        JTextField jtfText2 = new JTextField(25);
	        
	        JTextField jtfVehicleIdLabel = new JTextField("Vehicle ID", 25);
	        jtfVehicleIdLabel.setEditable(false);
	        JTextField jtfText3 = new JTextField(25);
	        
	        JTextField jtfCrashDateLabel = new JTextField("Crash Date", 25);
	        jtfCrashDateLabel.setEditable(false);
	        JTextField jtfText4 = new JTextField(25);

	        JTextField jtfAgeLabel = new JTextField("Age", 25);
	        jtfAgeLabel.setEditable(false);
	        JTextField jtfText5 = new JTextField(25);
	        
	        JTextField jtfCityLabel = new JTextField("city", 25);
	        jtfCityLabel.setEditable(false);
	        JTextField jtfText6 = new JTextField(25);
	        
	        JTextField jtfZipCodeLabel = new JTextField("zip code", 25);
	        jtfZipCodeLabel.setEditable(false);
	        JTextField jtfText7 = new JTextField(25);

	        String person_id = jtfText1.getText();
	        String person_type = choice.getSelectedItem().toString();
	        String rd_no = jtfText2.getText();
	        String vehicle_id = jtfText3.getText();
	        String crash_date = jtfText4.getText();
	        String gender = choice1.getSelectedItem().toString();
	        String age = jtfText5.getText();
	        String city = jtfText6.getText();
	        String zip_code = jtfText7.getText();
	        
	// submit registration 
	        JButton submitRegObj = new JButton("Submit");
	        submitRegObj.setPreferredSize(new Dimension(205,30));
	        submitRegObj.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	int registReply = JOptionPane.showConfirmDialog(getContentPane(), "Are you sure?", 
	                        "Išeiti", JOptionPane.YES_NO_OPTION);
	    	            if(registReply == JOptionPane.YES_OPTION){ 
	    	            	binaryTreeArray.btArray.add(new TrafficAccident(jtfText1.getText(),person_type,jtfText2.getText(),jtfText3.getText(),
	    	            			jtfText4.getText(),gender,jtfText5.getText(),jtfText6.getText(),jtfText7.getText()));
	    	            	//binaryTreeArray.btArray.insert(binaryTreeArrayroot, 0);
	    	            	binaryTreeArray.btArray.root = binaryTreeArray.btArray.insert(binaryTreeArray.btArray.root, 0);
	    	            	
	    	            	binaryTreeLL.head = BinaryTreeLL.push(binaryTreeLL.head, new TrafficAccident(jtfText1.getText(),person_type,jtfText2.getText(),jtfText3.getText(),
	    	            			jtfText4.getText(),gender,jtfText5.getText(),jtfText6.getText(),jtfText7.getText()));
	    	            	binaryTreeLLroot = binaryTreeLL.btLL.convertListToBinaryTree(binaryTreeLL.head);
	    	            	
	    	            	bst.insertByCity(BinarySearchAVLExperiments.rootCity, new TrafficAccident(jtfText1.getText(),person_type,jtfText2.getText(),jtfText3.getText(),
	    	            			jtfText4.getText(),gender,jtfText5.getText(),jtfText6.getText(),jtfText7.getText()));
	    	               	bst.insertByDate(BinarySearchAVLExperiments.rootDate, new TrafficAccident(jtfText1.getText(),person_type,jtfText2.getText(),jtfText3.getText(),
	    	            			jtfText4.getText(),gender,jtfText5.getText(),jtfText6.getText(),jtfText7.getText()));
	    	            	bst.insertByPersonId(BinarySearchAVLExperiments.rootPId, new TrafficAccident(jtfText1.getText(),person_type,jtfText2.getText(),jtfText3.getText(),
	    	            			jtfText4.getText(),gender,jtfText5.getText(),jtfText6.getText(),jtfText7.getText()));
	    	            	bst.insertByRDNo(BinarySearchAVLExperiments.rootRdNo, new TrafficAccident(jtfText1.getText(),person_type,jtfText2.getText(),jtfText3.getText(),
	    	            			jtfText4.getText(),gender,jtfText5.getText(),jtfText6.getText(),jtfText7.getText()));
	    	            	bst.insertByVehicleId(BinarySearchAVLExperiments.rootVehicleID, new TrafficAccident(jtfText1.getText(),person_type,jtfText2.getText(),jtfText3.getText(),
	    	            			jtfText4.getText(),gender,jtfText5.getText(),jtfText6.getText(),jtfText7.getText()));
	    	            	
	    	            	SQLExperiments.InsertOneIntoDB(new TrafficAccident(jtfText1.getText(),person_type,jtfText2.getText(),jtfText3.getText(),
	    	            			jtfText4.getText(),gender,jtfText5.getText(),jtfText6.getText(),jtfText7.getText()));
	    	            	
	    	            	
	    	            	JOptionPane.showMessageDialog(frame, "Inserted Successfully to Data structures!");
	    	           }
	            }
	         });

	        container.revalidate();
	        container.removeAll();
	        container.add(jtfRegLabel);
	        container.add(jtfNameLabel);
	        container.add(jtfText1);
	        container.add(jtfTypeLabel);
	        container.add(choice);
	        
	        container.add(jtfRDNoLabel);
	        container.add(jtfText2);
	        container.add(jtfVehicleIdLabel);
	        container.add(jtfText3);
	        container.add(jtfCrashDateLabel);
	        container.add(jtfText4);
	        container.add(jtfGenderLabel);
	        container.add(choice1);
	        container.add(jtfAgeLabel);
	        container.add(jtfText5);
	        container.add(jtfCityLabel);
	        container.add(jtfText6);
	        container.add(jtfZipCodeLabel);
	        container.add(jtfText7);
	        container.add(submitRegObj);    

	        container.setLayout(new FlowLayout());
	        setSize(700, 700); // set size of window
	        setVisible(true);// set it visible


	    }
	    
	    private void Exp1Page()
	    {
	    	Container container = getContentPane();
	    	JTextField jtfRegLabel = new JTextField("***Experiment 1***", 50);
	    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
	        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
	        jtfRegLabel.setEditable(false);
	        
	        Frame frame = new Frame("Choice");
	        
	        JButton btree = new JButton("Binary tree data structure");
	        btree.setBackground(Color.white);
	        btree.setPreferredSize(new Dimension(300,30));
	        btree.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        
	        JButton bst = new JButton("AVL tree data structure");
	        bst.setBackground(Color.white);
	        bst.setPreferredSize(new Dimension(300,30));
	        bst.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        JButton SQLRegObj = new JButton("Using SQL");
	        SQLRegObj.setBackground(Color.white);
	        SQLRegObj.setPreferredSize(new Dimension(300,30));
	        SQLRegObj.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        JButton Back = new JButton("Back");
	        Back.setBackground(Color.white);
	        Back.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        btree.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	SearchByVehicleIdBTree();
	            	
	               
	            }
	         });
	        
	        bst.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	SearchByVehicleIdBST();
	            	
	               
	            }
	         });
	        
	        Back.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		ExperimentPage();
	        	}
	        });
	        
	        SQLRegObj.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		SearchByVehicleIdSQL();
	        	}
	        });
	        
	        container.removeAll();
	        this.validate();
	        this.repaint();
	        container.add(jtfRegLabel);
	        container.add(btree); 
	        container.add(bst);
	        container.add(SQLRegObj);
	        container.add(Back);
	        container.setLayout(new FlowLayout());
	        
	        setSize(700, 700); // set size of window
	        setVisible(true);// set it visible
	    }

	    private DefaultTableModel frameSecond(ArrayList<TrafficAccident> ta) {
	        
	        //setting the properties of second JFrame
	    		
	           JFrame frame2 = new JFrame("Database Results");
	           frame2.setLayout(new FlowLayout());
	           frame2.setSize(500, 500);
	    
	           //Setting the properties of JTable and DefaultTableModel
	           DefaultTableModel defaultTableModel = new DefaultTableModel();
	           JTable table = new JTable(defaultTableModel);
	           
	           table.setPreferredScrollableViewportSize(new Dimension(700, 700));
	           table.setFillsViewportHeight(true);
	           frame2.add(new JScrollPane(table));
	           defaultTableModel.addColumn("Person_ID");
	           defaultTableModel.addColumn("Person_type");
	           defaultTableModel.addColumn("RD_NO");
	           defaultTableModel.addColumn("Vehicle_id");
	           defaultTableModel.addColumn("Crash_date");
	           defaultTableModel.addColumn("gender");
	           defaultTableModel.addColumn("age");
	           defaultTableModel.addColumn("city");
	           defaultTableModel.addColumn("zip_code");
	           
	           for(int i=0;i<ta.size();i++)
	           {
	        	   
	        	   defaultTableModel.addRow(new Object[] {ta.get(i).getPersonID(),ta.get(i).getPersonType(),
	        			   ta.get(i).getRD_NO(),ta.get(i).getVehicleId(),ta.get(i).getCrashDate(),
	        			   ta.get(i).getGender(),ta.get(i).getAge(),ta.get(i).getCity(),ta.get(i).getZipCode()});
	           }
	           
	           return defaultTableModel;
	           
	    }
	    
	    
	    private DefaultTableModel frameSecond3(ArrayList ta) {
	        
	        //setting the properties of second JFrame
	           JFrame frame2 = new JFrame("Database Results");
	           frame2.setLayout(new FlowLayout());
	           frame2.setSize(400, 300);
	    
	           //Setting the properties of JTable and DefaultTableModel
	           DefaultTableModel defaultTableModel = new DefaultTableModel();
	           JTable table = new JTable(defaultTableModel);
	           table.setPreferredScrollableViewportSize(new Dimension(300, 100));
	           table.setFillsViewportHeight(true);
	           frame2.add(new JScrollPane(table));
	           defaultTableModel.addColumn("RDNos");
	           
	           for(int i=0;i<ta.size();i++)
	           {
	        	   
	        	   defaultTableModel.addRow(new Object[] {ta.get(i)});
	           }
	           
	           return defaultTableModel;
	           
	    }
	    
	    private DefaultTableModel frameSecondSQL(ResultSet ta) {
	        
        	//setting the properties of second JFrame
    		
           JFrame frame2 = new JFrame("Database Results");
           frame2.setLayout(new FlowLayout());
           frame2.setSize(500, 500);
    
           //Setting the properties of JTable and DefaultTableModel
           DefaultTableModel defaultTableModel = new DefaultTableModel();
           JTable table = new JTable(defaultTableModel);
           
           table.setPreferredScrollableViewportSize(new Dimension(700, 700));
           table.setFillsViewportHeight(true);
           frame2.add(new JScrollPane(table));
           defaultTableModel.addColumn("Person_ID");
           defaultTableModel.addColumn("Person_type");
           defaultTableModel.addColumn("RD_NO");
           defaultTableModel.addColumn("Vehicle_id");
           defaultTableModel.addColumn("Crash_date");
           defaultTableModel.addColumn("gender");
           defaultTableModel.addColumn("age");
           defaultTableModel.addColumn("city");
           defaultTableModel.addColumn("zip_code");
           ResultSetMetaData rsmd;
			try {
				rsmd = ta.getMetaData();
				int columnsNumber = rsmd.getColumnCount();
				while (ta.next())
	            {
					
	                Object [] rowData = new Object[columnsNumber];
	                for (int i = 0; i < rowData.length; ++i)
	                {
	                	
	                    rowData[i] = ta.getString(i+1);
	                }
	                defaultTableModel.addRow(rowData);
	            } 
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           return defaultTableModel;
           
    }

    private DefaultTableModel frameSecond2SQL(ResultSet ta) {
        
        	//setting the properties of second JFrame	    	   
           JFrame frame2 = new JFrame("Database Results");
           frame2.setLayout(new FlowLayout());
           frame2.setSize(400, 300);
    
           //Setting the properties of JTable and DefaultTableModel
           DefaultTableModel defaultTableModel = new DefaultTableModel();
           JTable table = new JTable(defaultTableModel);
           table.setPreferredScrollableViewportSize(new Dimension(300, 100));
           table.setFillsViewportHeight(true);
           frame2.add(new JScrollPane(table));
           defaultTableModel.addColumn("city");
           defaultTableModel.addColumn("Count of accident");
           
           ResultSetMetaData rsmd;
			try {
				rsmd = ta.getMetaData();
				int columnsNumber = rsmd.getColumnCount();
				while (ta.next())
	            {
	                Object [] rowData = new Object[columnsNumber];
	                for (int i = 0; i < rowData.length; ++i)
	                {
	                    rowData[i] = ta.getObject(i+1);
	                }
	                defaultTableModel.addRow(rowData);
	            }    
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
           return defaultTableModel;
           
    }
    
    private DefaultTableModel frameSecond3SQL(ResultSet ta) {
        
        //setting the properties of second JFrame
           JFrame frame2 = new JFrame("Database Results");
           frame2.setLayout(new FlowLayout());
           frame2.setSize(400, 300);
    
           //Setting the properties of JTable and DefaultTableModel
           DefaultTableModel defaultTableModel = new DefaultTableModel();
           JTable table = new JTable(defaultTableModel);
           table.setPreferredScrollableViewportSize(new Dimension(300, 100));
           table.setFillsViewportHeight(true);
           frame2.add(new JScrollPane(table));
           defaultTableModel.addColumn("RDNos");

           ResultSetMetaData rsmd;
		try {
			rsmd = ta.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			while (ta.next())
            {
                Object [] rowData = new Object[columnsNumber];
                for (int i = 0; i < rowData.length; ++i)
                {
                    rowData[i] = ta.getObject(i+1);
                }
                defaultTableModel.addRow(rowData);
            }    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	               
           return defaultTableModel;
           
    }
	    
	    private void SearchByVehicleIdBTree()
	    {
	    	Container container = getContentPane();
	    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
	    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
	        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
	        jtfRegLabel.setEditable(false);

	        JTextField jtfNameLabel = new JTextField("Enter Vehicle ID", 15);
	        jtfNameLabel.setEditable(false);
	        jtfNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
	        JTextField jtfText1 = new JTextField(20);
	        
	        JPanel panel = new JPanel(new BorderLayout());
	        
	        Frame frame = new Frame("Choice");
	        
	        JButton SearchRegObj = new JButton("Search Record");
	        SearchRegObj.setBackground(Color.white);
	        SearchRegObj.setPreferredSize(new Dimension(200,30));
	        SearchRegObj.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        SearchRegObj.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	               String op = "";
	               String str = jtfText1.getText(); 
	               long startTime = System.nanoTime();
	               ArrayList<TrafficAccident> ta = binaryTreeLL.SearchAccidentHistoryVehicleID(binaryTreeLLroot, str);
	               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
	       		   long timeElapsed = endTime - startTime; 
	       		   if(ta.size()>0)
	       		   {
	       			   JTable table = new JTable(frameSecond(ta));
		       		   
		       		   JScrollPane jsp = new JScrollPane(table);
		       		   jsp.setPreferredSize(new Dimension(680,100));
		       		   container.add(jsp);
		       		   setVisible(true);
	       		   }
	       		   else {
	       			JOptionPane.showMessageDialog(frame, "Record Not Found!");
	       		   }
	       		   binaryTreeLL.AccidentList.clear();
	       		   long startTime2 = System.nanoTime();
	       		   ArrayList<TrafficAccident> btArr = binaryTreeArray.SearchAccidentHistoryVehicleID(binaryTreeArrayroot,str);
	               long endTime2 = System.nanoTime(); // get the difference between the two nano time valuess
	       		   long timeElapsed2 = endTime2 - startTime2; 
	       		   binaryTreeArray.AccidentList.clear();
	       		JOptionPane.showMessageDialog(frame, "Binary Tree using LinkedList:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n"
	       				+"Binary tree using Array:\nYour Execution time is:  "+timeElapsed2/1000000+" milliseconds\n("+timeElapsed2+" nanoseconds)\n");
	       				
	            }
	            
	         });
	        
	        JButton Back = new JButton("Back");
	        Back.setBackground(Color.white);
	        Back.setFont(new Font("Arial", Font.PLAIN, 15));
	        Back.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Exp1Page();
	        	}
	        });
	        
	        container.removeAll();
	        this.validate();
	        this.repaint();
	        container.add(jtfRegLabel);
	        container.add(jtfNameLabel);
	        container.add(jtfText1);
	        
	        
	        container.add(SearchRegObj);
	        container.add(Back);

	        container.setLayout(new FlowLayout());
	        setSize(700, 700); // set size of window
	        setVisible(true);// set it visible

	    }
	    
	    private void SearchByVehicleIdSQL()
	    {
	    	Container container = getContentPane();
	    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
	    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
	        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
	        jtfRegLabel.setEditable(false);


	        
	        JTextField jtfNameLabel = new JTextField("Enter Vehicle ID", 15);
	        jtfNameLabel.setEditable(false);
	        jtfNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
	        JTextField jtfText1 = new JTextField(20);
	        
	        JPanel panel = new JPanel(new BorderLayout());
	        
	        Frame frame = new Frame("Choice");
	        
	        JButton SearchRegObj = new JButton("Search Record");
	        SearchRegObj.setBackground(Color.white);
	        SearchRegObj.setPreferredSize(new Dimension(200,30));
	        SearchRegObj.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        SearchRegObj.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               String op = "";
	               String str = jtfText1.getText(); 
	               String jdbcURL = "jdbc:mysql://localhost:3306/trafficAccident";
	               String username = "root";
	               Connection connection = null;
	               try {
	            	   connection = DriverManager.getConnection(jdbcURL, username, password);
	       			   connection.setAutoCommit(false);
	               }
	               catch(Exception ex) {
	            	   //do nothing
	               }
	               long startTime = System.nanoTime();
	               ResultSet  ta = SQLExperiments.searchAccidentHistoryVehicleIdSQL(connection,str);
	               if(ta!=null)
	       		   {
	            	   
	       			   JTable table = new JTable(frameSecondSQL(ta));
		       		   
		       		   JScrollPane jsp = new JScrollPane(table);
		       		jsp.setPreferredSize(new Dimension(680,100));
		       		   container.add(jsp);
		       		   setVisible(true);
	       		   }
	       		   else {
	       			JOptionPane.showMessageDialog(frame, "Record Not Found!");
	       		   }
	               
	              
	               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
	       		   long timeElapsed = endTime - startTime; System.out.println("Execution time in nanoseconds: " + timeElapsed);
	       		JOptionPane.showMessageDialog(frame, "Yor Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)");
	       	 try {
					connection.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
	            }
	         });
	        
	        JButton Back = new JButton("Back");
	        Back.setBackground(Color.white);
	        Back.setFont(new Font("Arial", Font.PLAIN, 15));
	        Back.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Exp1Page();
	        	}
	        });
	        
	        container.removeAll();
	        this.validate();
	        this.repaint();
	        container.add(jtfRegLabel);
	        container.add(jtfNameLabel);
	        container.add(jtfText1);
	        
	        
	        container.add(SearchRegObj);
	        container.add(Back);

	        container.setLayout(new FlowLayout());
	        setSize(700, 700); // set size of window
	        setVisible(true);// set it visible

	    }
	    
	    private void SearchByVehicleIdBST()
	    {
	    	Container container = getContentPane();
	    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
	    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
	        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
	        jtfRegLabel.setEditable(false);

	        
	        JTextField jtfNameLabel = new JTextField("Enter Vehicle ID", 15);
	        jtfNameLabel.setEditable(false);
	        jtfNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
	        JTextField jtfText1 = new JTextField(20);
	        
	        JPanel panel = new JPanel(new BorderLayout());
	        
	        Frame frame = new Frame("Choice");
	        
	        JButton SearchRegObj = new JButton("Search Record");
	        SearchRegObj.setBackground(Color.white);
	        SearchRegObj.setPreferredSize(new Dimension(200,30));
	        SearchRegObj.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        SearchRegObj.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               String op = "";
	               String str = jtfText1.getText(); 
	               long startTime = System.nanoTime();
	               ArrayList<TrafficAccident> bst = binarySearchTree.SearchAccidentHistoryVehicleID(BinarySearchAVLExperiments.rootVehicleID, str);
	               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
	       		   long timeElapsed = endTime - startTime; 
	       		   if(bst.size()>0)
	       		   {
	       			   JTable table = new JTable(frameSecond(bst));
		       		   
		       		   JScrollPane jsp = new JScrollPane(table);
		       		jsp.setPreferredSize(new Dimension(680,100));
		       		   container.add(jsp);
		       		   setVisible(true);
	       		   }
	       		   else {
	       			JOptionPane.showMessageDialog(frame, "Record Not Found!");
	       		   }
	       		binarySearchTree.AccidentList.clear();
	       		JOptionPane.showMessageDialog(frame, "AVL tree:\nYor Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n");
	            }
	         });
	        
	        JButton Back = new JButton("Back");
	        Back.setBackground(Color.white);
	        Back.setFont(new Font("Arial", Font.PLAIN, 15));
	        Back.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Exp1Page();
	        	}
	        });
	        
	        container.removeAll();
	        this.validate();
	        this.repaint();
	        container.add(jtfRegLabel);
	        container.add(jtfNameLabel);
	        container.add(jtfText1);
	        
	        container.add(SearchRegObj);
	        container.add(Back);

	        container.setLayout(new FlowLayout());
	        setSize(700, 700); // set size of window
	        setVisible(true);// set it visible

	    }
	    
	    private void Exp2Page()
	    {
	    	Container container = getContentPane();
	    	JTextField jtfRegLabel = new JTextField("***Experiment 2***", 50);
	    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
	        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
	        jtfRegLabel.setEditable(false);
	        
	        Frame frame = new Frame("Choice");
	        
	        JButton btree = new JButton("Binary tree data structure");
	        btree.setBackground(Color.white);
	        btree.setPreferredSize(new Dimension(300,30));
	        btree.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        
	        JButton bst = new JButton("AVL tree data structure");
	        bst.setBackground(Color.white);
	        bst.setPreferredSize(new Dimension(300,30));
	        bst.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        JButton SQLRegObj = new JButton("Using SQL");
	        SQLRegObj.setBackground(Color.white);
	        SQLRegObj.setPreferredSize(new Dimension(300,30));
	        SQLRegObj.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        
	        btree.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	SearchByPersonIdBTree();
	            	
	               
	            }
	         });
	        
	        bst.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	SearchByPersonIdBST();
	            	
	               
	            }
	         });
	        
	        SQLRegObj.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		SearchByPersonIdSQL();
	        	}
	        });
	        
	        JButton Back = new JButton("Back");
	        Back.setBackground(Color.white);
	        Back.setFont(new Font("Arial", Font.PLAIN, 15));
	        Back.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		ExperimentPage();
	        	}
	        });
	        
	        container.removeAll();
	        this.validate();
	        this.repaint();
	        container.add(jtfRegLabel);
	        container.add(btree); 
	        container.add(bst);
	        container.add(SQLRegObj);
	        container.add(Back);
	        container.setLayout(new FlowLayout());
	        setSize(700, 700); // set size of window
	        setVisible(true);// set it visible
	    }

	    private void SearchByPersonIdBTree()
	    {
	    	Container container = getContentPane();
	    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
	    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
	        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
	        jtfRegLabel.setEditable(false);

	        
	        JTextField jtfNameLabel = new JTextField("Enter Person ID", 15);
	        jtfNameLabel.setEditable(false);
	        jtfNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
	        JTextField jtfText1 = new JTextField(20);
	        
	        JPanel panel = new JPanel(new BorderLayout());
	        
	        Frame frame = new Frame("Choice");
	        
	        JButton SearchRegObj = new JButton("Search Record");
	        SearchRegObj.setBackground(Color.white);
	        SearchRegObj.setPreferredSize(new Dimension(200,30));
	        SearchRegObj.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        SearchRegObj.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               String op = "";
	               String str = jtfText1.getText(); 
	               long startTime = System.nanoTime();
	               ArrayList<TrafficAccident> ta= binaryTreeLL.SearchVictimsByPersonId(binaryTreeLLroot,str);
	               if(ta.size()>0)
	       		   {
	       			   JTable table = new JTable(frameSecond(ta));
		       		   
		       		   JScrollPane jsp = new JScrollPane(table);
		       		jsp.setPreferredSize(new Dimension(680,100));
		       		   container.add(jsp);
		       		   setVisible(true);
	       		   }
	       		   else {
	       			JOptionPane.showMessageDialog(frame, "Record Not Found!");
	       		   }
	               binaryTreeLL.personInfoList.clear();
	               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
	       		   long timeElapsed = endTime - startTime; 
	       		   
	       		   long startTime1 = System.nanoTime();
	       		   ta = binaryTreeArray.SearchVictimsByPersonId(binaryTreeLLroot, str);
	       		   long endTime1 = System.nanoTime(); // get the difference between the two nano time valuess
	       		   long timeElapsed1 = endTime1 - startTime1;
	       		   binaryTreeArray.personInfoList.clear();
	    		   
	       		JOptionPane.showMessageDialog(frame, "Binary tree using LinkedList:\nYor Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n"
	       				+ "binary tree using Array:\nYor Execution time is:  "+timeElapsed1/1000000+" milliseconds\n("+timeElapsed1+" nanoseconds)");
	            }
	            ;
	         });
	        
	        JButton Back = new JButton("Back");
	        Back.setBackground(Color.white);
	        Back.setFont(new Font("Arial", Font.PLAIN, 15));
	        Back.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Exp2Page();
	        	}
	        });
	        
	        container.removeAll();
	        this.validate();
	        this.repaint();
	        container.add(jtfRegLabel);
	        container.add(jtfNameLabel);
	        container.add(jtfText1);
	        
	        container.add(SearchRegObj);
	        container.add(Back);
	        container.setLayout(new FlowLayout());
	        setSize(700, 700); // set size of window
	        setVisible(true);// set it visible
	    }


	    private void SearchByPersonIdSQL()
	    {
	    	Container container = getContentPane();
	    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
	    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
	        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
	        jtfRegLabel.setEditable(false);


	        
	        JTextField jtfNameLabel = new JTextField("Enter Person ID", 15);
	        jtfNameLabel.setEditable(false);
	        jtfNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
	        JTextField jtfText1 = new JTextField(20);
	        
	        JPanel panel = new JPanel(new BorderLayout());
	        
	        Frame frame = new Frame("Choice");
	        
	        JButton SearchRegObj = new JButton("Search Record");
	        SearchRegObj.setBackground(Color.white);
	        SearchRegObj.setPreferredSize(new Dimension(200,30));
	        SearchRegObj.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        SearchRegObj.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               String op = "";
	               String str = jtfText1.getText(); 
	               String jdbcURL = "jdbc:mysql://localhost:3306/trafficAccident";
	               String username = "root";
	               Connection connection = null;
	               try {
	            	   connection = DriverManager.getConnection(jdbcURL, username, password);
	       			   connection.setAutoCommit(false);
	               }
	               catch(Exception ex) {
	            	   //do nothing
	               }
	               long startTime = System.nanoTime();
	               ResultSet ta = SQLExperiments.searchByPersonIdSQL(connection,str);
	               if(ta!=null)
	       		   {
	       			   JTable table = new JTable(frameSecondSQL(ta));
		       		   
		       		   JScrollPane jsp = new JScrollPane(table);
		       		jsp.setPreferredSize(new Dimension(680,100));
		       		   container.add(jsp);
		       		   setVisible(true);
	       		   }
	       		   else {
	       			JOptionPane.showMessageDialog(frame, "Record Not Found!");
	       		   }
	               
	              
	               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
	       		   long timeElapsed = endTime - startTime; System.out.println("Execution time in nanoseconds: " + timeElapsed);
	       		JOptionPane.showMessageDialog(frame, "Yor Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)");
	       	 try {
					connection.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
	            }
	         });
	        
	        JButton Back = new JButton("Back");
	        Back.setBackground(Color.white);
	        Back.setFont(new Font("Arial", Font.PLAIN, 15));
	        Back.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Exp2Page();
	        	}
	        });
	        
	        container.removeAll();
	        this.validate();
	        this.repaint();
	        container.add(jtfRegLabel);
	        container.add(jtfNameLabel);
	        container.add(jtfText1);
	        
	        container.add(SearchRegObj);
	        container.add(Back);
	        container.setLayout(new FlowLayout());
	        setSize(700, 700); // set size of window
	        setVisible(true);// set it visible

	    }
	    
	    private void SearchByPersonIdBST()
	    {
	    	Container container = getContentPane();
	    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
	    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
	        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
	        jtfRegLabel.setEditable(false);

	        
	        JTextField jtfNameLabel = new JTextField("Enter Person ID", 15);
	        jtfNameLabel.setEditable(false);
	        jtfNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
	        JTextField jtfText1 = new JTextField(20);
	        
	        JPanel panel = new JPanel(new BorderLayout());
	        
	        Frame frame = new Frame("Choice");
	        
	        JButton SearchRegObj = new JButton("Search Record");
	        SearchRegObj.setBackground(Color.white);
	        SearchRegObj.setPreferredSize(new Dimension(200,30));
	        SearchRegObj.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        SearchRegObj.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               String op = "";
	               String str = jtfText1.getText(); 
	               long startTime = System.nanoTime();
	               ArrayList<TrafficAccident> ta = binarySearchTree.SearchVictimsByPersonId(BinarySearchAVLExperiments.rootPId, str);
	               if(ta.size()>0)
	       		   {
	       			   JTable table = new JTable(frameSecond(ta));
		       		   
		       		   JScrollPane jsp = new JScrollPane(table);
		       		   jsp.setPreferredSize(new Dimension(680,100));
		       		   container.add(jsp);
		       		   setVisible(true);
	       		   }
	       		   else {
	       			JOptionPane.showMessageDialog(frame, "Record Not Found!");
	       		   }
	              
	               long endTime = System.nanoTime(); // get the difference between the two nano time values
	       		   long timeElapsed = endTime - startTime; 
	       		   binarySearchTree.personInfoList.clear();
	    		   
	       		JOptionPane.showMessageDialog(frame, "AVL tree:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n");
	            }
	         });
	        
	        JButton Back = new JButton("Back");
	        Back.setBackground(Color.white);
	        Back.setFont(new Font("Arial", Font.PLAIN, 15));
	        Back.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Exp2Page();
	        	}
	        });
	        
	        container.removeAll();
	        this.validate();
	        this.repaint();
	        container.add(jtfRegLabel);
	        container.add(jtfNameLabel);
	        container.add(jtfText1);
	        
	        container.add(SearchRegObj);
	        container.add(Back);
	        container.setLayout(new FlowLayout());
	        setSize(700, 700); // set size of window
	        setVisible(true);// set it visible

	    }
	    
	    private void Exp3Page()
	    {
	    	Container container = getContentPane();
	    	JTextField jtfRegLabel = new JTextField("***Experiment 3***", 50);
	    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
	        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
	        jtfRegLabel.setEditable(false);
	        
	        Frame frame = new Frame("Choice");
	        
	        JButton btree = new JButton("Binary tree data structure");
	        btree.setBackground(Color.white);
	        btree.setPreferredSize(new Dimension(300,30));
	        btree.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        
	        JButton bst = new JButton("AVL tree data structure");
	        bst.setBackground(Color.white);
	        bst.setPreferredSize(new Dimension(300,30));
	        bst.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        JButton sql = new JButton("Using SQL");
	        sql.setBackground(Color.white);
	        sql.setPreferredSize(new Dimension(300,30));
	        sql.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        
	        btree.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	SearchByRDNoBTree();
	            	
	               
	            }
	         });
	        
	        bst.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	SearchByRDNoBST();
	            	
	               
	            }
	         });
	        
	        sql.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	SearchByRDNoSQL();
	            	
	               
	            }
	         });
	        
	        
	        JButton Back = new JButton("Back");
	        Back.setBackground(Color.white);
	        Back.setFont(new Font("Arial", Font.PLAIN, 15));
	        Back.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		ExperimentPage();
	        	}
	        });
	        
	        container.removeAll();
	        this.validate();
	        this.repaint();
	        container.add(jtfRegLabel);
	        container.add(btree); 
	        container.add(bst);
	        container.add(sql);
	        container.add(Back);
	        container.setLayout(new FlowLayout());
	        setSize(700,700); // set size of window
	        setVisible(true);// set it visible
	    }

	    private void SearchByRDNoSQL()
	    {
	    	Container container = getContentPane();
	    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
	    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
	        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
	        jtfRegLabel.setEditable(false);


	        
	        JTextField jtfNameLabel = new JTextField("Enter RD No", 15);
	        jtfNameLabel.setEditable(false);
	        jtfNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
	        JTextField jtfText1 = new JTextField(20);
	        
	        JPanel panel = new JPanel(new BorderLayout());
	        
	        Frame frame = new Frame("Choice");
	        
	        JButton SearchRegObj = new JButton("Search Record");
	        SearchRegObj.setBackground(Color.white);
	        SearchRegObj.setPreferredSize(new Dimension(200,30));
	        SearchRegObj.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        SearchRegObj.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               String op = "";
	               String str = jtfText1.getText(); 
	               String jdbcURL = "jdbc:mysql://localhost:3306/trafficAccident";
	               String username = "root";
	               Connection connection = null;
	               try {
	            	   connection = DriverManager.getConnection(jdbcURL, username, password);
	       			   connection.setAutoCommit(false);
	               }
	               catch(Exception ex) {
	            	   //do nothing
	               }
	               long startTime = System.nanoTime();
	               ResultSet ta = SQLExperiments.SearchVictimsByRdNoSQL(connection,str);
	               if(ta!=null)
	       		   {
	       			   JTable table = new JTable(frameSecondSQL(ta));
		       		   
		       		   JScrollPane jsp = new JScrollPane(table);
		       		jsp.setPreferredSize(new Dimension(680,100));
		       		   container.add(jsp);
		       		   setVisible(true);
	       		   }
	       		   else {
	       			JOptionPane.showMessageDialog(frame, "Record Not Found!");
	       		   }
	              
	               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
	       		   long timeElapsed = endTime - startTime; System.out.println("Execution time in nanoseconds: " + timeElapsed);
	       		JOptionPane.showMessageDialog(frame, "Yor Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)");
	       	 try {
					connection.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
	            }
	         });
	        
	        JButton Back = new JButton("Back");
	        Back.setBackground(Color.white);
	        Back.setFont(new Font("Arial", Font.PLAIN, 15));
	        Back.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Exp3Page();
	        	}
	        });
	        
	        container.removeAll();
	        this.validate();
	        this.repaint();
	        container.add(jtfRegLabel);
	        container.add(jtfNameLabel);
	        container.add(jtfText1);
	        
	        container.add(SearchRegObj);
	        container.add(Back);
	        container.setLayout(new FlowLayout());
	        setSize(700, 700); // set size of window
	        setVisible(true);// set it visible
	    }
	    
	    private void SearchByRDNoBTree()
	    {
	    	Container container = getContentPane();
	    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
	    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
	        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
	        jtfRegLabel.setEditable(false);

	        
	        JTextField jtfNameLabel = new JTextField("Enter RD No", 15);
	        jtfNameLabel.setEditable(false);
	        jtfNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
	        JTextField jtfText1 = new JTextField(20);
	        
	        JPanel panel = new JPanel(new BorderLayout());
	        
	        Frame frame = new Frame("Choice");
	        
	        JButton SearchRegObj = new JButton("Search Record");
	        SearchRegObj.setBackground(Color.white);
	        SearchRegObj.setPreferredSize(new Dimension(200,30));
	        SearchRegObj.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        SearchRegObj.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               String op = "";
	               String str = jtfText1.getText(); 
	               long startTime = System.nanoTime();
	               ArrayList<TrafficAccident> ta= binaryTreeLL.SearchVictimsByRdNo(binaryTreeLLroot,str);
	               if(ta.size()>0)
	       		   {
	       			   JTable table = new JTable(frameSecond(ta));
		       		   
		       		   JScrollPane jsp = new JScrollPane(table);
		       		jsp.setPreferredSize(new Dimension(680,100));
		       		   container.add(jsp);
		       		   setVisible(true);
	       		   }
	       		   else {
	       			JOptionPane.showMessageDialog(frame, "Record Not Found!");
	       		   }
	               binaryTreeLL.VictimList.clear();
	               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
	       		   long timeElapsed = endTime - startTime; 
	       		   
	       		   long startTime1 = System.nanoTime();
	       		   ta= binaryTreeArray.SearchVictimsByRdNo(binaryTreeArrayroot, str);
	       		   long endTime1 = System.nanoTime(); // get the difference between the two nano time valuess
	       		   long timeElapsed1 = endTime1 - startTime1; 
	       		   binaryTreeArray.VictimList.clear();
	    		   
	       		JOptionPane.showMessageDialog(frame, "Binary tree using LinkedList:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n"
	       				+ "Binary tree using Array:\nYour Execution time is:  "+timeElapsed1/1000000+" milliseconds\n("+timeElapsed1+" nanoseconds)");
	            }
	         });
	        
	        JButton Back = new JButton("Back");
	        Back.setBackground(Color.white);
	        Back.setFont(new Font("Arial", Font.PLAIN, 15));
	        Back.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Exp3Page();
	        	}
	        });
	        
	        container.removeAll();
	        this.validate();
	        this.repaint();
	        container.add(jtfRegLabel);
	        container.add(jtfNameLabel);
	        container.add(jtfText1);
	        
	        container.add(SearchRegObj);
	        container.add(Back);
	        container.setLayout(new FlowLayout());
	        setSize(700, 700); // set size of window
	        setVisible(true);// set it visible

	    }
	    
	    private void SearchByRDNoBST()
	    {
	    	Container container = getContentPane();
	    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
	    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
	        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
	        jtfRegLabel.setEditable(false);

	        
	        JTextField jtfNameLabel = new JTextField("Enter RD No", 15);
	        jtfNameLabel.setEditable(false);
	        jtfNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
	        JTextField jtfText1 = new JTextField(20);
	        
	        JPanel panel = new JPanel(new BorderLayout());
	        
	        Frame frame = new Frame("Choice");
	        
	        JButton SearchRegObj = new JButton("Search Record");
	        SearchRegObj.setBackground(Color.white);
	        SearchRegObj.setPreferredSize(new Dimension(200,30));
	        SearchRegObj.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        SearchRegObj.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               String op = "";
	               String str = jtfText1.getText(); 
	               long startTime = System.nanoTime();
	               ArrayList<TrafficAccident>  ta = binarySearchTree.SearchVictimsByRdNo(BinarySearchAVLExperiments.rootRdNo, str);
	               if(ta.size()>0)
	       		   {
	       			   JTable table = new JTable(frameSecond(ta));
		       		   
		       		   JScrollPane jsp = new JScrollPane(table);
		       		jsp.setPreferredSize(new Dimension(680,100));
		       		   container.add(jsp);
		       		   setVisible(true);
	       		   }
	       		   else {
	       			JOptionPane.showMessageDialog(frame, "Record Not Found!");
	       		   }
	              
	               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
	       		   long timeElapsed = endTime - startTime; 
	       		   binarySearchTree.VictimList.clear();
	       		   
	    		   
	       		JOptionPane.showMessageDialog(frame, "AVL tree:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n");
	            }
	         });
	        
	        JButton Back = new JButton("Back");
	        Back.setBackground(Color.white);
	        Back.setFont(new Font("Arial", Font.PLAIN, 15));
	        Back.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Exp3Page();
	        	}
	        });
	        
	        container.removeAll();
	        this.validate();
	        this.repaint();
	        container.add(jtfRegLabel);
	        container.add(jtfNameLabel);
	        container.add(jtfText1);
	        
	        container.add(SearchRegObj);
	        container.add(Back);
	        container.setLayout(new FlowLayout());
	        setSize(700, 700); // set size of window
	        setVisible(true);// set it visible

	    }
	    
	    private void Exp4Page()
	    {
	    	Container container = getContentPane();
	    	JTextField jtfRegLabel = new JTextField("***Experiment 4***", 50);
	    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
	        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
	        jtfRegLabel.setEditable(false);
	        
	        Frame frame = new Frame("Choice");
	        
	        JButton btree = new JButton("Binary tree data structure");
	        btree.setBackground(Color.white);
	        btree.setPreferredSize(new Dimension(300,30));
	        btree.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        
	        JButton bst = new JButton("AVL tree data structure");
	        bst.setBackground(Color.white);
	        bst.setPreferredSize(new Dimension(300,30));
	        bst.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        JButton sql = new JButton("Using SQL");
	        sql.setBackground(Color.white);
	        sql.setPreferredSize(new Dimension(300,30));
	        sql.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        btree.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	SearchCountofCasesByDateBTree();
	            	
	               
	            }
	         });
	        
	        bst.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	SearchCountofCasesByDateBST();
	            	
	               
	            }
	         });
	             
	        sql.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	SearchCountofCasesByDateSQL();
	            	
	               
	            }
	         });
	        
	        JButton Back = new JButton("Back");
	        Back.setBackground(Color.white);
	        Back.setFont(new Font("Arial", Font.PLAIN, 15));
	        Back.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		ExperimentPage();
	        	}
	        });
	        
	        container.removeAll();
	        this.validate();
	        this.repaint();
	        container.add(jtfRegLabel);
	        container.add(btree); 
	        container.add(bst);
	        container.add(sql);
	        container.add(Back);

	        container.setLayout(new FlowLayout());
	        setSize(700, 700); // set size of window
	        setVisible(true);// set it visible
	    }
	    
	    private void SearchCountofCasesByDateSQL()
	    {
	    	Container container = getContentPane();
	    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
	    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
	        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
	        jtfRegLabel.setEditable(false);


	        
	        JTextField jtfNameLabel = new JTextField("Enter Date of Accident", 15);
	        jtfNameLabel.setEditable(false);
	        jtfNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
	        JTextField jtfText1 = new JTextField(20);
	        
	        JPanel panel = new JPanel(new BorderLayout());
	        
	        Frame frame = new Frame("Choice");
	        
	        JButton SearchRegObj = new JButton("Search Record");
	        SearchRegObj.setBackground(Color.white);
	        SearchRegObj.setPreferredSize(new Dimension(200,30));
	        SearchRegObj.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        SearchRegObj.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               String op = "";
	               String str = jtfText1.getText(); 
	               String jdbcURL = "jdbc:mysql://localhost:3306/trafficAccident";
	               String username = "root";
	               Connection connection = null;
	               try {
	            	   connection = DriverManager.getConnection(jdbcURL, username, password);
	       			   connection.setAutoCommit(false);
	               }
	               catch(Exception ex) {
	            	   //do nothing
	               }
	               long startTime = System.nanoTime();
	               ResultSet ta = SQLExperiments.SearchCountofCasesByDateSQL(connection,str);
	               if(ta!=null)
	       		   {
	       			   JTable table = new JTable(frameSecond3SQL(ta));
		       		   
		       		   JScrollPane jsp = new JScrollPane(table);
		       		jsp.setPreferredSize(new Dimension(680,100));
		       		   container.add(jsp);
		       		   setVisible(true);
	       		   }
	       		   else {
	       			JOptionPane.showMessageDialog(frame, "Record Not Found!");
	       		   }
	              
	               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
	       		   long timeElapsed = endTime - startTime; System.out.println("Execution time in nanoseconds: " + timeElapsed);
	       		JOptionPane.showMessageDialog(frame, "Yor Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)");
	       	 try {
					connection.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
	            }
	         });
	        
	        JButton Back = new JButton("Back");
	        Back.setBackground(Color.white);
	        Back.setFont(new Font("Arial", Font.PLAIN, 15));
	        Back.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Exp4Page();
	        	}
	        });
	        container.removeAll();
	        this.validate();
	        this.repaint();
	        container.add(jtfRegLabel);
	        container.add(jtfNameLabel);
	        container.add(jtfText1);
	        
	        container.add(SearchRegObj);
	        container.add(Back);
	        container.setLayout(new FlowLayout());
	        setSize(700, 700); // set size of window
	        setVisible(true);// set it visible


	    }
	    
	    private void SearchCountofCasesByDateBTree()
	    {
	    	Container container = getContentPane();
	    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
	    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
	        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
	        jtfRegLabel.setEditable(false);

	        
	        JTextField jtfNameLabel = new JTextField("Enter Date of Accident", 15);
	        jtfNameLabel.setEditable(false);
	        jtfNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
	        JTextField jtfText1 = new JTextField(20);
	        
	        JPanel panel = new JPanel(new BorderLayout());
	        
	        Frame frame = new Frame("Choice");
	        
	        JButton SearchRegObj = new JButton("Search Record");
	        SearchRegObj.setBackground(Color.white);
	        SearchRegObj.setPreferredSize(new Dimension(200,30));
	        SearchRegObj.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        SearchRegObj.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               String op = "";
	               String str = jtfText1.getText(); 
	               long startTime = System.nanoTime();
	               ArrayList<String> ta = binaryTreeLL.SearchCountofCasesByDate(binaryTreeLLroot, str);
	               if(ta.size()>0)
	       		   {
	       			   JTable table = new JTable(frameSecond3(ta));
		       		   
		       		   JScrollPane jsp = new JScrollPane(table);
		       		   jsp.setPreferredSize(new Dimension(680,100));
		       		   container.add(jsp);
		       		   JLabel jlb =new JLabel("Count of Accidents is:"+ta.size());
		       		   jlb.setForeground(Color.WHITE);
		       		   container.add(jlb);
		       		   setVisible(true);
	       		   }
	       		   else {
	       			JOptionPane.showMessageDialog(frame, "Record Not Found!");
	       		   }
	              
	               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
	       		   long timeElapsed = endTime - startTime; 
	       		   
	       		   long startTime1 = System.nanoTime();
	       		   ta = binaryTreeArray.SearchCountofCasesByDate(binaryTreeArrayroot, str);
	       		   long endTime1 = System.nanoTime(); // get the difference between the two nano time valuess
	       		   long timeElapsed1 = endTime1 - startTime1; 
	    		   
	       		   
	       		  binaryTreeLL.RDNoListByDate.clear();
	       		  binaryTreeArray.RDNoListByDate.clear();
	       		JOptionPane.showMessageDialog(frame, "Binary tree using LinkedList:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n"
	       				+ "Binary tree using Array:\nYour Execution time is:  "+timeElapsed1/1000000+" milliseconds\n("+timeElapsed1+" nanoseconds)");
	            }
	         });
	        
	        JButton Back = new JButton("Back");
	        Back.setBackground(Color.white);
	        Back.setFont(new Font("Arial", Font.PLAIN, 15));
	        Back.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Exp4Page();
	        	}
	        });
	        container.removeAll();
	        this.validate();
	        this.repaint();
	        container.add(jtfRegLabel);
	        container.add(jtfNameLabel);
	        container.add(jtfText1);
	        
	        container.add(SearchRegObj);
	        container.add(Back);
	        container.setLayout(new FlowLayout());
	        setSize(700, 700); // set size of window
	        setVisible(true);// set it visible

	    }

	    private void SearchCountofCasesByDateBST()
	    {
	    	Container container = getContentPane();
	    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
	    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
	        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
	        jtfRegLabel.setEditable(false);

	        
	        JTextField jtfNameLabel = new JTextField("Enter Date of Accident", 15);
	        jtfNameLabel.setEditable(false);
	        jtfNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
	        JTextField jtfText1 = new JTextField(20);
	        
	        JPanel panel = new JPanel(new BorderLayout());
	        
	        Frame frame = new Frame("Choice");
	        
	        JButton SearchRegObj = new JButton("Search Record");
	        SearchRegObj.setBackground(Color.white);
	        SearchRegObj.setPreferredSize(new Dimension(200,30));
	        SearchRegObj.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        SearchRegObj.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               String op = "";
	               String str = jtfText1.getText(); 
	               long startTime = System.nanoTime();
	               ArrayList<String> ta = binarySearchTree.SearchCountofCasesByDate(BinarySearchAVLExperiments.rootDate, str);
	               if(ta.size()>0)
	       		   {
	       			   JTable table = new JTable(frameSecond3(ta));
		       		   
		       		   JScrollPane jsp = new JScrollPane(table);
		       		jsp.setPreferredSize(new Dimension(680,100));
		       		   container.add(jsp);
		       		   JLabel jlb =new JLabel("Count of Accidents is:"+ta.size());
		       		   container.add(jlb);
		       		   jlb.setForeground(Color.WHITE);
		       		   setVisible(true);
	       		   }
	       		   else {
	       			JOptionPane.showMessageDialog(frame, "Record Not Found!");
	       		   }
	              
	               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
	       		   long timeElapsed = endTime - startTime; 
	       		   binarySearchTree.RDNoListByDate.clear();
	         		JOptionPane.showMessageDialog(frame, "AVL tree:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n");
	            }
	         });
	        
	        JButton Back = new JButton("Back");
	        Back.setBackground(Color.white);
	        Back.setFont(new Font("Arial", Font.PLAIN, 15));
	        Back.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Exp4Page();
	        	}
	        });
	        container.removeAll();
	        this.validate();
	        this.repaint();
	        container.add(jtfRegLabel);
	        container.add(jtfNameLabel);
	        container.add(jtfText1);
	        
	        container.add(SearchRegObj);
	        container.add(Back);
	        container.setLayout(new FlowLayout());
	        setSize(700, 700); // set size of window
	        setVisible(true);// set it visible

	    }
	    
	    private void Exp5Page()
	    {
	    	Container container = getContentPane();
	    	JTextField jtfRegLabel = new JTextField("***Experiment 5***", 50);
	    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
	        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
	        jtfRegLabel.setEditable(false);
	        
	        Frame frame = new Frame("Choice");
	        
	        JButton btree = new JButton("Binary tree data structure");
	        btree.setBackground(Color.white);
	        btree.setPreferredSize(new Dimension(300,30));
	        btree.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        
	        JButton bst = new JButton("AVL tree data structure");
	        bst.setBackground(Color.white);
	        bst.setPreferredSize(new Dimension(300,30));
	        bst.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        JButton SQLRegObj = new JButton("Using SQL");
	        SQLRegObj.setBackground(Color.white);
	        SQLRegObj.setPreferredSize(new Dimension(300,30));
	        SQLRegObj.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        btree.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	SearchCityWiseAccidentsDetailsBTree();
	            	
	               
	            }
	         });
	        
	        bst.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	SearchCityWiseAccidentDetailsBST();
	            	
	               
	            }
	         });
	            
	        SQLRegObj.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	SearchCityWiseAccidentDetailsSQL();
	            	
	               
	            }
	         });
	        
        
	        JButton Back = new JButton("Back");
	        Back.setBackground(Color.white);
	        Back.setFont(new Font("Arial", Font.PLAIN, 15));
	        Back.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		ExperimentPage();
	        	}
	        });
	        
	        container.removeAll();
	        this.validate();
	        this.repaint();
	        container.add(jtfRegLabel);
	        container.add(btree); 
	        container.add(bst);
	        container.add(SQLRegObj);
	        container.add(Back);

	        container.setLayout(new FlowLayout());
	        setSize(700, 700); // set size of window
	        setVisible(true);// set it visible
	    }

	    private void SearchCityWiseAccidentDetailsSQL()
	    {
	    	Container container = getContentPane();
	    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
	    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
	        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
	        jtfRegLabel.setEditable(false);


	        
	        JTextField jtfNameLabel = new JTextField("Enter Date of Accident", 15);
	        jtfNameLabel.setEditable(false);
	        jtfNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
	        JTextField jtfText1 = new JTextField(20);
	        
	        JPanel panel = new JPanel(new BorderLayout());
	        
	        Frame frame = new Frame("Choice");
	        
	        JButton SearchRegObj = new JButton("Search Record");
	        SearchRegObj.setBackground(Color.white);
	        SearchRegObj.setPreferredSize(new Dimension(200,30));
	        SearchRegObj.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        SearchRegObj.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               String op = "";
	               String str = jtfText1.getText(); 
	               String jdbcURL = "jdbc:mysql://localhost:3306/trafficAccident";
	               String username = "root";
	               Connection connection = null;
	               try {
	            	   connection = DriverManager.getConnection(jdbcURL, username, password);
	       			   connection.setAutoCommit(false);
	               }
	               catch(Exception ex) {
	            	   //do nothing
	               }
	               long startTime = System.nanoTime();
	               ResultSet ta = SQLExperiments.SearchCountofCasesByCities(connection,str);
	               if(ta!=null)
	       		   {
	       			   JTable table = new JTable(frameSecond3SQL(ta));
		       		   
		       		   JScrollPane jsp = new JScrollPane(table);
		       		jsp.setPreferredSize(new Dimension(680,100));
		       		   container.add(jsp);
		       		   setVisible(true);
	       		   }
	       		   else {
	       			JOptionPane.showMessageDialog(frame, "Record Not Found!");
	       		   }
	              
	               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
	       		   long timeElapsed = endTime - startTime; System.out.println("Execution time in nanoseconds: " + timeElapsed);
	       		JOptionPane.showMessageDialog(frame, "Yor Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)");
	       	 try {
					connection.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
	            }
	         });
	        
	        JButton Back = new JButton("Back");
	        Back.setBackground(Color.white);
	        Back.setFont(new Font("Arial", Font.PLAIN, 15));
	        Back.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Exp5Page();
	        	}
	        });
	        container.removeAll();
	        this.validate();
	        this.repaint();
	        container.add(jtfRegLabel);
	        container.add(jtfNameLabel);
	        container.add(jtfText1);
	        
	        container.add(SearchRegObj);
	        container.add(Back);
	        container.setLayout(new FlowLayout());
	        setSize(700, 700); // set size of window
	        setVisible(true);// set it visible


	    }
	    
	    private void SearchCityWiseAccidentsDetailsBTree()
	    {
	    	Container container = getContentPane();
	    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
	    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
	        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
	        jtfRegLabel.setEditable(false);

	        
	        JTextField jtfNameLabel = new JTextField("Enter Name of city", 15);
	        jtfNameLabel.setEditable(false);
	        jtfNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
	        JTextField jtfText1 = new JTextField(20);
	        
	        JPanel panel = new JPanel(new BorderLayout());
	        
	        Frame frame = new Frame("Choice");
	        
	        JButton SearchRegObj = new JButton("Search Record");
	        SearchRegObj.setBackground(Color.white);
	        SearchRegObj.setPreferredSize(new Dimension(200,30));
	        SearchRegObj.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        SearchRegObj.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               String op = "";
	               String str = jtfText1.getText(); 
	               long startTime = System.nanoTime();
	               ArrayList ta = binaryTreeLL.SearchCountofCasesByCities(binaryTreeLLroot, str);
	               if(ta.size()>0)
	       		   {
	       			   JTable table = new JTable(frameSecond3(ta));
		       		   
		       		   JScrollPane jsp = new JScrollPane(table);
		       		   jsp.setPreferredSize(new Dimension(680,100));
		       		   JLabel jlb =new JLabel("Count of Accidents is:"+ta.size());
		       		   jlb.setForeground(Color.WHITE);
		       		   container.add(jsp);
		       		   container.add(jlb);
		       		   setVisible(true);
	       		   }
	       		   else {
	       			JOptionPane.showMessageDialog(frame, "Record Not Found!");
	       		   }
	              
	               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
	       		   long timeElapsed = endTime - startTime; 
	       		   
	       		   long startTime1 = System.nanoTime();
	       		   ta = binaryTreeLL.SearchCountofCasesByCities(binaryTreeArrayroot, str);
	       		   long endTime1 = System.nanoTime(); // get the difference between the two nano time valuess
	       		   long timeElapsed1 = endTime1 - startTime1; 
	    		   
	       		  binaryTreeLL.RDNoListByCity.clear();
	       		  binaryTreeArray.RDNoListByCity.clear();
	       		   
	       		JOptionPane.showMessageDialog(frame, "Binary tree using LinkedList:\nYor Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n"
	       				+ "Binary tree using Array:\nYor Execution time is:  "+timeElapsed1/1000000+" milliseconds\n("+timeElapsed1+" nanoseconds)");
	            }
	         });
	        
	        JButton Back = new JButton("Back");
	        Back.setBackground(Color.white);
	        Back.setFont(new Font("Arial", Font.PLAIN, 15));
	        Back.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Exp5Page();
	        	}
	        });
	        container.removeAll();
	        this.validate();
	        this.repaint();
	        container.add(jtfRegLabel);
	        container.add(jtfNameLabel);
	        container.add(jtfText1);
	        
	        container.add(SearchRegObj);
	        container.add(Back);
	        container.setLayout(new FlowLayout());
	        setSize(700, 700); // set size of window
	        setVisible(true);// set it visible

	    }
	    
	    private void SearchCityWiseAccidentDetailsBST()
	    {
	    	Container container = getContentPane();
	    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
	    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
	        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
	        jtfRegLabel.setEditable(false);

	        
	        JTextField jtfNameLabel = new JTextField("Enter name of city", 15);
	        jtfNameLabel.setEditable(false);
	        jtfNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
	        JTextField jtfText1 = new JTextField(20);
	        
	        JPanel panel = new JPanel(new BorderLayout());
	        
	        Frame frame = new Frame("Choice");
	        
	        JButton SearchRegObj = new JButton("Search Record");
	        SearchRegObj.setBackground(Color.white);
	        SearchRegObj.setPreferredSize(new Dimension(200,30));
	        SearchRegObj.setFont(new Font("Arial", Font.PLAIN, 15));
	        
	        SearchRegObj.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               String op = "";
	               String str = jtfText1.getText(); 
	               long startTime = System.nanoTime();
	               ArrayList ta = binarySearchTree.SearchCountofCasesByCities(BinarySearchAVLExperiments.rootCity, str);
	               if(ta.size()>0)
	       		   {
	       			   JTable table = new JTable(frameSecond3(ta));
		       		   
		       		   JScrollPane jsp = new JScrollPane(table);
		       		   jsp.setPreferredSize(new Dimension(680,100));
		       		   JLabel jlb =new JLabel("Count of Accidents is:"+ta.size());
		       		   jlb.setForeground(Color.WHITE);
		       		   container.add(jsp);
		       		   container.add(jlb);
		       		   setVisible(true);
	       		   }
	       		   else {
	       			JOptionPane.showMessageDialog(frame, "Record Not Found!");
	       		   }
	               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
	       		   long timeElapsed = endTime - startTime; 
	       		binarySearchTree.RDNoListByCity.clear();
	       		JOptionPane.showMessageDialog(frame, "AVL tree:\nYor Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n");
	            }
	         });
	        
	        JButton Back = new JButton("Back");
	        Back.setBackground(Color.white);
	        Back.setFont(new Font("Arial", Font.PLAIN, 15));
	        Back.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Exp5Page();
	        	}
	        });
	        container.removeAll();
	        this.validate();
	        this.repaint();
	        container.add(jtfRegLabel);
	        container.add(jtfNameLabel);
	        container.add(jtfText1);
	        
	        container.add(SearchRegObj);
	        container.add(Back);
	        container.setLayout(new FlowLayout());
	        setSize(700, 700); // set size of window
	        setVisible(true);// set it visible
	    }
}

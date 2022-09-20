package TrafficCrashAnalysisMaps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.table.DefaultTableModel;

/**
 * TrafficAnalysisUI.java - User Interface for Traffic Data Analysis.
 * @author nsrao
 */

public class TrafficAnalysisUI extends JFrame implements ActionListener
{    	
	
	private static HashMap<String, TrafficAccident> hashMap = new HashMap<>();
	private static TreeMapExperiments texp = new TreeMapExperiments();	
	public static void main (String []args) throws InterruptedException{
		hashMap.insertIntoHashMap();
		texp.insertIntoTreeMap();
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

        if (e.getSource() == Apie){
        	ExperimentPage();  
        }
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
        
        JButton Exp1RegObj = new JButton("Search Accident History VehicleID");
        Exp1RegObj.setBackground(Color.WHITE);
        Exp1RegObj.setPreferredSize(new Dimension(400,30));
        Exp1RegObj.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JButton Exp2RegObj = new JButton("Search Victims by PersonId");
        Exp2RegObj.setBackground(Color.WHITE);
        Exp2RegObj.setPreferredSize(new Dimension(400,30));
        Exp2RegObj.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JButton Exp3RegObj = new JButton("Search Victims by Rd No");
        Exp3RegObj.setBackground(Color.WHITE);
        Exp3RegObj.setPreferredSize(new Dimension(400,30));
        Exp3RegObj.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JButton Exp4RegObj = new JButton("Count of Accidents by City");
        Exp4RegObj.setBackground(Color.WHITE);
        Exp4RegObj.setPreferredSize(new Dimension(400,30));
        Exp4RegObj.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JButton Exp5RegObj = new JButton("Analysis of Accidents By month");
        Exp5RegObj.setBackground(Color.WHITE);
        Exp5RegObj.setPreferredSize(new Dimension(400,30));
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
    
    private DefaultTableModel frameCity(Node<String,TrafficAccident> ta) {
        
        //setting the properties of second JFrame
    		
           JFrame frame2 = new JFrame("Results");
           frame2.setLayout(new FlowLayout());
           frame2.setSize(500, 500);
    
           //Setting the properties of JTable and DefaultTableModel
           DefaultTableModel defaultTableModel = new DefaultTableModel();
           JTable table = new JTable(defaultTableModel);
           
           table.setPreferredScrollableViewportSize(new Dimension(700, 700));
           table.setFillsViewportHeight(true);
           frame2.add(new JScrollPane(table));
           defaultTableModel.addColumn("City");
           defaultTableModel.addColumn("count");
           
           defaultTableModel.addRow(new Object[] {ta.getKey(), ta.entries.size()});
           
           return defaultTableModel;
           
    }
    
    private DefaultTableModel frameMonth(ArrayList<Node<String,TrafficAccident>> ta) {
        
        //setting the properties of second JFrame
    		
           JFrame frame2 = new JFrame("Results");
           frame2.setLayout(new FlowLayout());
           frame2.setSize(500, 500);
    
           //Setting the properties of JTable and DefaultTableModel
           DefaultTableModel defaultTableModel = new DefaultTableModel();
           JTable table = new JTable(defaultTableModel);
           
           table.setPreferredScrollableViewportSize(new Dimension(700, 700));
           table.setFillsViewportHeight(true);
           frame2.add(new JScrollPane(table));
           defaultTableModel.addColumn("mm-YY");
           defaultTableModel.addColumn("count");
           
           for(int i=0;i<ta.size();i++)
           {
        	   if(ta.get(i)!=null)
        		   defaultTableModel.addRow(new Object[] {ta.get(i).getKey(), ta.get(i).entries.size()});
           }
           
           return defaultTableModel;
           
    }

    public DefaultTableModel frameSecond(ArrayList<TrafficAccident> ta) {
        
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
    
private DefaultTableModel frameCityTM(ArrayList<TrafficAccident> ta,String str) {
        
        //setting the properties of second JFrame
    		
           JFrame frame2 = new JFrame("Results");
           frame2.setLayout(new FlowLayout());
           frame2.setSize(500, 500);
    
           //Setting the properties of JTable and DefaultTableModel
           DefaultTableModel defaultTableModel = new DefaultTableModel();
           JTable table = new JTable(defaultTableModel);
           
           table.setPreferredScrollableViewportSize(new Dimension(700, 700));
           table.setFillsViewportHeight(true); 
           frame2.add(new JScrollPane(table));
           defaultTableModel.addColumn("City");
           defaultTableModel.addColumn("count");
           
          defaultTableModel.addRow(new Object[] {str,ta.size()});
           
           return defaultTableModel;
           
    }
    
    private DefaultTableModel frameMonthTM(TreeMap<String,Integer> ta) {
        
        //setting the properties of second JFrame
    		
           JFrame frame2 = new JFrame("Results");
           frame2.setLayout(new FlowLayout());
           frame2.setSize(500, 500);
    
           //Setting the properties of JTable and DefaultTableModel
           DefaultTableModel defaultTableModel = new DefaultTableModel();
           JTable table = new JTable(defaultTableModel);
           
           table.setPreferredScrollableViewportSize(new Dimension(700, 700));
           table.setFillsViewportHeight(true);
           frame2.add(new JScrollPane(table));
           defaultTableModel.addColumn("mm-YY");
           defaultTableModel.addColumn("count");
           
           ta.entrySet().forEach(k-> defaultTableModel.addRow(new Object[] {k.getKey(),k.getValue()}));
           
           return defaultTableModel;
           
    }
    
    private void Exp1Page()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Experiment 1***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);
        
        Frame frame = new Frame("Choice");
        
        JButton btn1 = new JButton("Using HashMap");
        btn1.setBackground(Color.white);
        btn1.setPreferredSize(new Dimension(400,30));
        btn1.setFont(new Font("Arial", Font.PLAIN, 15));
        
        
        JButton btn2 = new JButton("Using TreeMap");
        btn2.setBackground(Color.white);
        btn2.setPreferredSize(new Dimension(400,30));
        btn2.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JButton Back = new JButton("Back");
        Back.setBackground(Color.white);
        Back.setFont(new Font("Arial", Font.PLAIN, 15));
        
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	searchVictimsByVehicleIdHashMap();
            	
               
            }
         });
        
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	searchVictimsByVehicleIdTreeMap();
            	
               
            }
         });
        
        Back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ExperimentPage();
        	}
        });
        
        
        container.removeAll();
        this.validate();
        this.repaint();
        container.add(jtfRegLabel);
        container.add(btn1); 
        container.add(btn2);
        container.add(Back);
        container.setLayout(new FlowLayout());
        
        setSize(700, 700); // set size of window
        setVisible(true);// set it visible
    }
   
    private void searchVictimsByVehicleIdHashMap()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);

        JTextField jtfNameLabel = new JTextField("Enter vehicle id", 15);
        jtfNameLabel.setEditable(false);
        jtfNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JTextField jtfText1 = new JTextField(20);
        
        JPanel panel = new JPanel(new BorderLayout());
        
        Frame frame = new Frame("Choice");
        
        JButton SearchRegObj = new JButton("Go");
        SearchRegObj.setBackground(Color.white);
        SearchRegObj.setPreferredSize(new Dimension(200,30));
        SearchRegObj.setFont(new Font("Arial", Font.PLAIN, 15));
        
        SearchRegObj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	HashMapExperiments hexp = new HashMapExperiments();
            
               String op = "";
               String str = jtfText1.getText(); 
               long startTime = System.nanoTime();
               ArrayList<TrafficAccident> ta = hexp.SearchAccidentHistoryVehicleID(hashMap, str);
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
       		   
       		JOptionPane.showMessageDialog(frame, "HashMap:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n");
       		ta.clear();		
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
    
    private void searchVictimsByVehicleIdTreeMap()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);

        JTextField jtfNameLabel = new JTextField("Enter vehicle id", 15);
        jtfNameLabel.setEditable(false);
        jtfNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JTextField jtfText1 = new JTextField(20);
        
        JPanel panel = new JPanel(new BorderLayout());
        
        Frame frame = new Frame("Choice");
        
        JButton SearchRegObj = new JButton("Go");
        SearchRegObj.setBackground(Color.white);
        SearchRegObj.setPreferredSize(new Dimension(200,30));
        SearchRegObj.setFont(new Font("Arial", Font.PLAIN, 15));
        
        SearchRegObj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
               ArrayList<TrafficAccident> ta = new ArrayList<TrafficAccident>();
               String op = "";
               String str = jtfText1.getText(); 
               long startTime = System.nanoTime();
               ta = texp.SearchAccidentHistoryVehicleID(str);
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
       		   
       		  JOptionPane.showMessageDialog(frame, "Tree Map:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n");
       		  
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
        
        JButton btn1 = new JButton("Using HashMap");
        btn1.setBackground(Color.white);
        btn1.setPreferredSize(new Dimension(400,30));
        btn1.setFont(new Font("Arial", Font.PLAIN, 15));
        
        
        JButton btn2 = new JButton("Using TreeMap");
        btn2.setBackground(Color.white);
        btn2.setPreferredSize(new Dimension(400,30));
        btn2.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JButton Back = new JButton("Back");
        Back.setBackground(Color.white);
        Back.setFont(new Font("Arial", Font.PLAIN, 15));
        
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	searchVictimsByPersonIDHashMap();
            	
               
            }
         });
        
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	searchVictimsByPersonIDTreeMap();
            	
               
            }
         });
        
        Back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ExperimentPage();
        	}
        });
        
        
        container.removeAll();
        this.validate();
        this.repaint();
        container.add(jtfRegLabel);
        container.add(btn1); 
        container.add(btn2);
        container.add(Back);
        container.setLayout(new FlowLayout());
        
        setSize(700, 700); // set size of window
        setVisible(true);// set it visible
    }
    
    

   
    
    private void searchVictimsByPersonIDHashMap()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);

        JTextField jtfNameLabel = new JTextField("Enter Person id", 15);
        jtfNameLabel.setEditable(false);
        jtfNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JTextField jtfText1 = new JTextField(20);
        
        JPanel panel = new JPanel(new BorderLayout());
        
        Frame frame = new Frame("Choice");
        
        JButton SearchRegObj = new JButton("Go");
        SearchRegObj.setBackground(Color.white);
        SearchRegObj.setPreferredSize(new Dimension(200,30));
        SearchRegObj.setFont(new Font("Arial", Font.PLAIN, 15));
        
        SearchRegObj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
               HashMapExperiments hexp = new HashMapExperiments();
               String op = "";
               String str = jtfText1.getText(); 
               long startTime = System.nanoTime();
               ArrayList<TrafficAccident> ta = hexp.searchByPersonId(hashMap, str);
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
       		   
	        	JOptionPane.showMessageDialog(frame, "HashMap:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n");
	        	ta.clear();	
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
    
    private void searchVictimsByPersonIDTreeMap()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);

        JTextField jtfNameLabel = new JTextField("Enter person id", 15);
        jtfNameLabel.setEditable(false);
        jtfNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JTextField jtfText1 = new JTextField(20);
        
        JPanel panel = new JPanel(new BorderLayout());
        
        Frame frame = new Frame("Choice");
        
        JButton SearchRegObj = new JButton("Go");
        SearchRegObj.setBackground(Color.white);
        SearchRegObj.setPreferredSize(new Dimension(200,30));
        SearchRegObj.setFont(new Font("Arial", Font.PLAIN, 15));
        
        SearchRegObj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               ArrayList<TrafficAccident> ta = new ArrayList<TrafficAccident>();
               String op = "";
               String str = jtfText1.getText(); 
               long startTime = System.nanoTime();
               ta = texp.SearchVictimsByPersonId(str);
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
       		   
       		JOptionPane.showMessageDialog(frame, "Tree Map:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n");
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
        
        JButton btn1 = new JButton("Using HashMap");
        btn1.setBackground(Color.white);
        btn1.setPreferredSize(new Dimension(400,30));
        btn1.setFont(new Font("Arial", Font.PLAIN, 15));
        
        
        JButton btn2 = new JButton("Using TreeMap");
        btn2.setBackground(Color.white);
        btn2.setPreferredSize(new Dimension(400,30));
        btn2.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JButton Back = new JButton("Back");
        Back.setBackground(Color.white);
        Back.setFont(new Font("Arial", Font.PLAIN, 15));
        
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	SearchByRdNoHashMap();
            	
               
            }
         });
        
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	SearchByRdNoTreeMap();
            	
               
            }
         });
        
        Back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ExperimentPage();
        	}
        });
        
        
        container.removeAll();
        this.validate();
        this.repaint();
        container.add(jtfRegLabel);
        container.add(btn1); 
        container.add(btn2);
        container.add(Back);
        container.setLayout(new FlowLayout());
        
        setSize(700, 700); // set size of window
        setVisible(true);// set it visible
    }
    
    

   
    
    private void SearchByRdNoHashMap()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);

        JTextField jtfNameLabel = new JTextField("Enter rd no", 15);
        jtfNameLabel.setEditable(false);
        jtfNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JTextField jtfText1 = new JTextField(20);
        
        JPanel panel = new JPanel(new BorderLayout());
        
        Frame frame = new Frame("Choice");
        
        JButton SearchRegObj = new JButton("Go");
        SearchRegObj.setBackground(Color.white);
        SearchRegObj.setPreferredSize(new Dimension(200,30));
        SearchRegObj.setFont(new Font("Arial", Font.PLAIN, 15));
        
        SearchRegObj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	HashMapExperiments hexp = new HashMapExperiments();
               String op = "";
               String str = jtfText1.getText(); 
               long startTime = System.nanoTime();
               ArrayList<TrafficAccident> ta = hexp.searchByRdNo(hashMap, str);
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
       		   
	        	JOptionPane.showMessageDialog(frame, "HashMap:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n");
	        	ta.clear();
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
    
    private void SearchByRdNoTreeMap()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);

        JTextField jtfNameLabel = new JTextField("Enter rd no", 15);
        jtfNameLabel.setEditable(false);
        jtfNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JTextField jtfText1 = new JTextField(20);
        
        JPanel panel = new JPanel(new BorderLayout());
        
        Frame frame = new Frame("Choice");
        
        JButton SearchRegObj = new JButton("Go");
        SearchRegObj.setBackground(Color.white);
        SearchRegObj.setPreferredSize(new Dimension(200,30));
        SearchRegObj.setFont(new Font("Arial", Font.PLAIN, 15));
        
        SearchRegObj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ArrayList<TrafficAccident> ta = new ArrayList<TrafficAccident>();
               String op = "";
               String str = jtfText1.getText(); 
               long startTime = System.nanoTime();
               ta = texp.SearchVictimsByRdNo(str);
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
	    		   
	    		JOptionPane.showMessageDialog(frame, "TreeMap:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n");
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
        
        JButton btn1 = new JButton("Using HashMap");
        btn1.setBackground(Color.white);
        btn1.setPreferredSize(new Dimension(400,30));
        btn1.setFont(new Font("Arial", Font.PLAIN, 15));
        
        
        JButton btn2 = new JButton("Using TreeMap");
        btn2.setBackground(Color.white);
        btn2.setPreferredSize(new Dimension(400,30));
        btn2.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JButton Back = new JButton("Back");
        Back.setBackground(Color.white);
        Back.setFont(new Font("Arial", Font.PLAIN, 15));
        
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	CountByCityHashMap();
            	
               
            }
         });
        
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	CountByCityTreeMap();
            	
               
            }
         });
        
        Back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ExperimentPage();
        	}
        });
        
        
        container.removeAll();
        this.validate();
        this.repaint();
        container.add(jtfRegLabel);
        container.add(btn1); 
        container.add(btn2);
        container.add(Back);
        container.setLayout(new FlowLayout());
        
        setSize(700, 700); // set size of window
        setVisible(true);// set it visible
    }
    
    

   
    
    private void CountByCityHashMap()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);

        JTextField jtfNameLabel = new JTextField("Enter city", 15);
        jtfNameLabel.setEditable(false);
        jtfNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JTextField jtfText1 = new JTextField(20);
        
        JPanel panel = new JPanel(new BorderLayout());
        
        Frame frame = new Frame("Choice");
        
        JButton SearchRegObj = new JButton("Go");
        SearchRegObj.setBackground(Color.white);
        SearchRegObj.setPreferredSize(new Dimension(200,30));
        SearchRegObj.setFont(new Font("Arial", Font.PLAIN, 15));
        
        SearchRegObj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	HashMapExperiments hexp = new HashMapExperiments();
               String op = "";
               String str = jtfText1.getText(); 
               long startTime = System.nanoTime();
               Node<String,TrafficAccident> ta = hexp.CountByCity(hashMap, str);
               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
       		   long timeElapsed = endTime - startTime; 
       		   JTable table = new JTable(frameCity(ta));
	       		   
	       	   JScrollPane jsp = new JScrollPane(table);
	       	   jsp.setPreferredSize(new Dimension(680,100));
	 		   container.add(jsp);
      		   setVisible(true);

	        	JOptionPane.showMessageDialog(frame, "HashMap:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n");	        				
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
    
    private void CountByCityTreeMap()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);

        JTextField jtfNameLabel = new JTextField("Enter city", 15);
        jtfNameLabel.setEditable(false);
        jtfNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JTextField jtfText1 = new JTextField(20);
        
        JPanel panel = new JPanel(new BorderLayout());
        
        Frame frame = new Frame("Choice");
        
        JButton SearchRegObj = new JButton("Go");
        SearchRegObj.setBackground(Color.white);
        SearchRegObj.setPreferredSize(new Dimension(200,30));
        SearchRegObj.setFont(new Font("Arial", Font.PLAIN, 15));
        
        SearchRegObj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ArrayList<TrafficAccident> ta = new ArrayList<TrafficAccident>();
               String op = "";
               String str = jtfText1.getText(); 
               long startTime = System.nanoTime();
               ta = texp.SearchAccidentCountPerCity(str);
               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
       		   long timeElapsed = endTime - startTime; 
       		   if(ta.size()>0)
       		   {
       			   JTable table = new JTable(frameCityTM(ta,str));
	       		   
	       		   JScrollPane jsp = new JScrollPane(table);
	       		   jsp.setPreferredSize(new Dimension(680,100));
	       		   container.add(jsp);
	       		   setVisible(true);
       		   }
       		   else {
       			JOptionPane.showMessageDialog(frame, "Record Not Found!");
       		   }
	    		   
	    		JOptionPane.showMessageDialog(frame, "TreeMap:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n");
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
        
        JButton btn1 = new JButton("Using HashMap");
        btn1.setBackground(Color.white);
        btn1.setPreferredSize(new Dimension(400,30));
        btn1.setFont(new Font("Arial", Font.PLAIN, 15));
        
        
        JButton btn2 = new JButton("Using TreeMap");
        btn2.setBackground(Color.white);
        btn2.setPreferredSize(new Dimension(400,30));
        btn2.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JButton Back = new JButton("Back");
        Back.setBackground(Color.white);
        Back.setFont(new Font("Arial", Font.PLAIN, 15));
        
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	CountByDateHashMap();
            	
               
            }
         });
        
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	CountByDateTreeMap();
            	
               
            }
         });
        
        Back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ExperimentPage();
        	}
        });
        
        
        container.removeAll();
        this.validate();
        this.repaint();
        container.add(jtfRegLabel);
        container.add(btn1); 
        container.add(btn2);
        container.add(Back);
        container.setLayout(new FlowLayout());
        
        setSize(700, 700); // set size of window
        setVisible(true);// set it visible
    }
    
    

   
    
    private void CountByDateHashMap()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);

        JTextField jtfNameLabel = new JTextField("Enter Month(Jan->01)", 15);
        jtfNameLabel.setEditable(false);
        jtfNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JTextField jtfText1 = new JTextField(20);
        
        JPanel panel = new JPanel(new BorderLayout());
        
        Frame frame = new Frame("Choice");
        
        JButton SearchRegObj = new JButton("Go");
        SearchRegObj.setBackground(Color.white);
        SearchRegObj.setPreferredSize(new Dimension(200,30));
        SearchRegObj.setFont(new Font("Arial", Font.PLAIN, 15));
        
        SearchRegObj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	HashMapExperiments hexp = new HashMapExperiments();
               String op = "";
               String str = jtfText1.getText(); 
               long startTime = System.nanoTime();
               ArrayList<Node<String,TrafficAccident>> ta = hexp.CountByDate(hashMap, str);
               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
       		   long timeElapsed = endTime - startTime; 
       		   if(ta.size()>0)
       		   {
       			   JTable table = new JTable(frameMonth(ta));
	       		   
	       		   JScrollPane jsp = new JScrollPane(table);
	       		   jsp.setPreferredSize(new Dimension(680,100));
	       		   container.add(jsp);
	       		   setVisible(true);
       		   }
       		   else {
       			JOptionPane.showMessageDialog(frame, "Record Not Found!");
       		   }
       		   
	        	JOptionPane.showMessageDialog(frame, "Hash Map:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n");	        				
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
    
    private void CountByDateTreeMap()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);

        JTextField jtfNameLabel = new JTextField("Enter month", 15);
        jtfNameLabel.setEditable(false);
        jtfNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JTextField jtfText1 = new JTextField(20);
        
        JPanel panel = new JPanel(new BorderLayout());
        
        Frame frame = new Frame("Choice");
        
        JButton SearchRegObj = new JButton("Go");
        SearchRegObj.setBackground(Color.white);
        SearchRegObj.setPreferredSize(new Dimension(200,30));
        SearchRegObj.setFont(new Font("Arial", Font.PLAIN, 15));
        
        SearchRegObj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
               String op = "";
               String str = jtfText1.getText(); 
               long startTime = System.nanoTime();
               TreeMap<String,Integer> ta = texp.SearchMonthWiseAccidentCount(str);
               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
       		   long timeElapsed = endTime - startTime; 
       		   if(ta.size()>0)
       		   {
       			   JTable table = new JTable(frameMonthTM(ta));
	       		   
	       		   JScrollPane jsp = new JScrollPane(table);
	       		   jsp.setPreferredSize(new Dimension(680,100));
	       		   container.add(jsp);
	       		   setVisible(true);
       		   }
       		   else {
       			JOptionPane.showMessageDialog(frame, "Record Not Found!");
       		   }
	    		   
	    		JOptionPane.showMessageDialog(frame, "Tree Map:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n");
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


package AirportDataAnalysisGraphs;

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

public class AirportDataAnlaysis extends JFrame implements ActionListener
{    	
	static GraphAdjacentMatrixExperiments g = new GraphAdjacentMatrixExperiments();
	static GraphAdjListsExperiments gExp = new GraphAdjListsExperiments();
	
	public static void main (String []args) throws InterruptedException{
		g.insertIntoGraph();
		gExp.insertIntoGraphs();
        new AirportDataAnlaysis("Menu"); 
        
    }

    
    private AirportDataAnlaysis(String title) {
        super(title); 
        JTextField jtfRegLabel = new JTextField("Airport Data Analysis", 25);
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
        
        JButton Exp1RegObj = new JButton("Checking if two airports are connected?");
        Exp1RegObj.setBackground(Color.WHITE);
        Exp1RegObj.setPreferredSize(new Dimension(650,30));
        Exp1RegObj.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JButton Exp2RegObj = new JButton("Getting Total No of Airports that are connected from this airport");
        Exp2RegObj.setBackground(Color.WHITE);
        Exp2RegObj.setPreferredSize(new Dimension(650,30));
        Exp2RegObj.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JButton Exp3RegObj = new JButton("Getting Total No of Airports that are connected To this airport");
        Exp3RegObj.setBackground(Color.WHITE);
        Exp3RegObj.setPreferredSize(new Dimension(650,30));
        Exp3RegObj.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JButton Exp4RegObj = new JButton("Getting Total No of flights that flew from source airport to all other airport");
        Exp4RegObj.setBackground(Color.WHITE);
        Exp4RegObj.setPreferredSize(new Dimension(650,30));
        Exp4RegObj.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JButton Exp5RegObj = new JButton("Getting Total No of flights that flew to this destination airport from other airport");
        Exp5RegObj.setBackground(Color.WHITE);
        Exp5RegObj.setPreferredSize(new Dimension(650,30));
        Exp5RegObj.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JButton Exp6RegObj = new JButton("Getting Total No of Passengers that flew to this destination airport from all other airport");
        Exp6RegObj.setBackground(Color.WHITE);
        Exp6RegObj.setPreferredSize(new Dimension(650,30));
        Exp6RegObj.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JButton Exp7RegObj = new JButton("Getting Total No of passengers that flew from source airport to all other airport");
        Exp7RegObj.setBackground(Color.WHITE);
        Exp7RegObj.setPreferredSize(new Dimension(650,30));
        Exp7RegObj.setFont(new Font("Arial", Font.PLAIN, 15));
        
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
        
        Exp6RegObj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Exp6Page();
            }
         });
        
        Exp7RegObj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Exp7Page();
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
        container.add(Exp6RegObj);
        container.add(Exp7RegObj);
        container.setLayout(new FlowLayout());
        setSize(700, 700); // set size of window
        setVisible(true);// set it visible
    }
    
    public DefaultTableModel frameSecond(ArrayList<String> ta) {
        
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
           defaultTableModel.addColumn("Airports");
           
           for(int i=0;i<ta.size();i++)
           {
        	   
        	   defaultTableModel.addRow(new Object[] {ta.get(i)});
           }
           
           return defaultTableModel;
           
    }
    
    public DefaultTableModel frameSecond1(ArrayList<String> ta) {
        
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
           defaultTableModel.addColumn("Airports");
           ta.stream().distinct().forEach(x -> defaultTableModel.addRow(new Object[] {x}));
          /* for(int i=0;i<ta.size();i++)
           {
        	   
        	   defaultTableModel.addRow(new Object[] {ta.get(i)});
           }*/
           
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
        
        JButton btn1 = new JButton("Using Adjacency Matrix");
        btn1.setBackground(Color.white);
        btn1.setPreferredSize(new Dimension(400,30));
        btn1.setFont(new Font("Arial", Font.PLAIN, 15));
        
        
        JButton btn2 = new JButton("Using Adjacency List");
        btn2.setBackground(Color.white);
        btn2.setPreferredSize(new Dimension(400,30));
        btn2.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JButton Back = new JButton("Back");
        Back.setBackground(Color.white);
        Back.setFont(new Font("Arial", Font.PLAIN, 15));
        
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	CheckIfTwoAirportAreConnectedAM();
            	
               
            }
         });
        
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	CheckIfTwoAirPortsAreConnectedAL();
            	
               
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
   
    private void CheckIfTwoAirportAreConnectedAM()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);

        JTextField jtfNameLabel = new JTextField("Enter Airport one", 15);
        jtfNameLabel.setEditable(false);
        jtfNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JTextField jtfText1 = new JTextField(40);
        
        JTextField jtfNameLabel2 = new JTextField("Enter Airport two", 15);
        jtfNameLabel2.setEditable(false);
        jtfNameLabel2.setFont(new Font("Arial", Font.PLAIN, 15));
        JTextField jtfText2 = new JTextField(40);
        
        JPanel panel = new JPanel(new BorderLayout());
        
        Frame frame = new Frame("Choice");
        
        JButton SearchRegObj = new JButton("Go");
        SearchRegObj.setBackground(Color.white);
        SearchRegObj.setPreferredSize(new Dimension(200,30));
        SearchRegObj.setFont(new Font("Arial", Font.PLAIN, 15));
        
        SearchRegObj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
               String op = "";
               String ap1 = jtfText1.getText();
               String ap2 = jtfText2.getText();
               long startTime = System.nanoTime();
               boolean ta = g.isConnected(ap1, ap2);
               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
       		   long timeElapsed = endTime - startTime; 
       		JOptionPane.showMessageDialog(frame, "Connected:"+ta);
       		JOptionPane.showMessageDialog(frame, "Adjacency Matrix:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n");
       			
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
        container.add(jtfNameLabel2);
        container.add(jtfText2);
        
        
        container.add(SearchRegObj);
        container.add(Back);

        container.setLayout(new FlowLayout());
        setSize(700, 700); // set size of window
        setVisible(true);// set it visible

    }
    
    private void CheckIfTwoAirPortsAreConnectedAL()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);

        JTextField jtfNameLabel = new JTextField("Enter Airport one", 15);
        jtfNameLabel.setEditable(false);
        jtfNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JTextField jtfText1 = new JTextField(40);
        
        JTextField jtfNameLabel2 = new JTextField("Enter Airport two", 15);
        jtfNameLabel2.setEditable(false);
        jtfNameLabel2.setFont(new Font("Arial", Font.PLAIN, 15));
        JTextField jtfText2 = new JTextField(40);
        
        JPanel panel = new JPanel(new BorderLayout());
        
        Frame frame = new Frame("Choice");
        
        JButton SearchRegObj = new JButton("Go");
        SearchRegObj.setBackground(Color.white);
        SearchRegObj.setPreferredSize(new Dimension(200,30));
        SearchRegObj.setFont(new Font("Arial", Font.PLAIN, 15));
        
        SearchRegObj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
               String ap1 = jtfText1.getText();
               String ap2 = jtfText2.getText();
               long startTime = System.nanoTime();
               boolean ta = gExp.isConnected(ap1, ap2);
               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
       		   long timeElapsed = endTime - startTime; 
       		JOptionPane.showMessageDialog(frame, "Connected:"+ta);
       		JOptionPane.showMessageDialog(frame, "Adjacency List:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n");
       			
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
        container.add(jtfNameLabel2);
        container.add(jtfText2);
        
        
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
        
        JButton btn1 = new JButton("Using Adjacency Matrix");
        btn1.setBackground(Color.white);
        btn1.setPreferredSize(new Dimension(400,30));
        btn1.setFont(new Font("Arial", Font.PLAIN, 15));
        
        
        JButton btn2 = new JButton("Using Adjacency List");
        btn2.setBackground(Color.white);
        btn2.setPreferredSize(new Dimension(400,30));
        btn2.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JButton Back = new JButton("Back");
        Back.setBackground(Color.white);
        Back.setFont(new Font("Arial", Font.PLAIN, 15));
        
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	getNoOfAirportsConnectedFromAM();
            	
               
            }
         });
        
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	getNoOfAirportsConnectedFromAL();
            	
               
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
    
    

   
    
    private void getNoOfAirportsConnectedFromAM()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);

        JTextField jtfNameLabel = new JTextField("Enter airport Code", 15);
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
               String str = jtfText1.getText(); 
               long startTime = System.nanoTime();
               ArrayList<String> ta = g.getNoOfAirportsConnectedFrom(str);
               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
       		   long timeElapsed = endTime - startTime; 
       		   if(ta.size()>0)
       		   {
       			   JTable table = new JTable(frameSecond(ta));
	       		   
	       		   JScrollPane jsp = new JScrollPane(table);
	       		   jsp.setPreferredSize(new Dimension(680,100));
	       		   container.add(jsp);
	       		   setVisible(true);
	       		JOptionPane.showMessageDialog(frame, "There are total "+ta.size()+" airports connected from "+str);
       		   }
       		   else {
       			JOptionPane.showMessageDialog(frame, "Record Not Found!");
       		   }
       		   
	        	JOptionPane.showMessageDialog(frame, "Adjacency Matrix:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n");
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
    
    private void getNoOfAirportsConnectedFromAL()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);

        JTextField jtfNameLabel = new JTextField("Enter airport code", 15);
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
               ArrayList<String> ta = gExp.getNoOfAirportsConnectedFrom(str);
               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
       		   long timeElapsed = endTime - startTime; 
       		   if(ta.size()>0)
       		   {
       			   JTable table = new JTable(frameSecond1(ta));
	       		   
	       		   JScrollPane jsp = new JScrollPane(table);
	       		   jsp.setPreferredSize(new Dimension(680,100));
	       		   container.add(jsp);
	       		   setVisible(true);
	       		JOptionPane.showMessageDialog(frame, "There are total "+ta.stream().distinct().count()+" airports connected from "+str);
       		   }
       		   else {
       			JOptionPane.showMessageDialog(frame, "Record Not Found!");
       		   }
       		   
       		JOptionPane.showMessageDialog(frame, "Adjacency List:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n");
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
        
        JButton btn1 = new JButton("Using Adjacency Matrix");
        btn1.setBackground(Color.white);
        btn1.setPreferredSize(new Dimension(400,30));
        btn1.setFont(new Font("Arial", Font.PLAIN, 15));
        
        
        JButton btn2 = new JButton("Using Adjacency List");
        btn2.setBackground(Color.white);
        btn2.setPreferredSize(new Dimension(400,30));
        btn2.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JButton Back = new JButton("Back");
        Back.setBackground(Color.white);
        Back.setFont(new Font("Arial", Font.PLAIN, 15));
        
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	getNoOfAirportsConnectedToAM();
            	
               
            }
         });
        
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	getNoOfAirportsConnectedToAL();
            	
               
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
    
    

   
    
    private void getNoOfAirportsConnectedToAM()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);

        JTextField jtfNameLabel = new JTextField("Enter airport code", 15);
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

               String str = jtfText1.getText(); 
               long startTime = System.nanoTime();
               ArrayList<String> ta = g.getNoOfAirportsConnectedTo(str);
               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
       		   long timeElapsed = endTime - startTime; 
       		   if(ta.size()>0)
       		   {
       			   JTable table = new JTable(frameSecond(ta));
	       		   
	       		   JScrollPane jsp = new JScrollPane(table);
	       		   jsp.setPreferredSize(new Dimension(680,100));
	       		   container.add(jsp);
	       		   setVisible(true);
	       		JOptionPane.showMessageDialog(frame, "There are total "+ta.size()+" airports connected to "+str);
       		   }
       		   else {
       			JOptionPane.showMessageDialog(frame, "Record Not Found!");
       		   }
       		   
	        	JOptionPane.showMessageDialog(frame, "Adjacency Matrix:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n");
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
    
    private void getNoOfAirportsConnectedToAL()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);

        JTextField jtfNameLabel = new JTextField("Enter airport code", 15);
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

               String str = jtfText1.getText(); 
               long startTime = System.nanoTime();
               ArrayList<String> ta = gExp.getNoOfAirportsConnectedTo(str);
               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
       		   long timeElapsed = endTime - startTime; 
       		   if(ta.size()>0)
       		   {
       			   JTable table = new JTable(frameSecond1(ta));
	       		   
	       		   JScrollPane jsp = new JScrollPane(table);
	       		   jsp.setPreferredSize(new Dimension(680,100));
	       		   container.add(jsp);
	       		   setVisible(true);
	       		   JOptionPane.showMessageDialog(frame, "There are total "+ta.stream().distinct().count()+" airports connected to "+str);
       		   }
       		   else {
       			JOptionPane.showMessageDialog(frame, "Record Not Found!");
       		   }
	    		   
	    		JOptionPane.showMessageDialog(frame, "Adjacency List:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n");
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
        
        JButton btn1 = new JButton("Using Adjacency Matrix");
        btn1.setBackground(Color.white);
        btn1.setPreferredSize(new Dimension(400,30));
        btn1.setFont(new Font("Arial", Font.PLAIN, 15));
        
        
        JButton btn2 = new JButton("Using Adjacency List");
        btn2.setBackground(Color.white);
        btn2.setPreferredSize(new Dimension(400,30));
        btn2.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JButton Back = new JButton("Back");
        Back.setBackground(Color.white);
        Back.setFont(new Font("Arial", Font.PLAIN, 15));
        
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	getTotaNoOfFlightsFlyingFromAM();
            	
               
            }
         });
        
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	getTotaNoOfFlightsFlyingFromAL();
            	
               
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
    
    

   
    
    private void getTotaNoOfFlightsFlyingFromAM()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);

        JTextField jtfNameLabel = new JTextField("Enter airport code", 15);
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
            	
               String str = jtfText1.getText(); 
               long startTime = System.nanoTime();
               int ta = g.getTotaNoOfFlightsFlyingFrom(str);
               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
       		   long timeElapsed = endTime - startTime; 
       		   JOptionPane.showMessageDialog(frame, "Total Flights flying from "+str+" are:"+ta);
	        	JOptionPane.showMessageDialog(frame, "Adjacency Matrix:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n");	        				
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
    
    private void getTotaNoOfFlightsFlyingFromAL()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);

        JTextField jtfNameLabel = new JTextField("Enter airport code", 15);
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

               String str = jtfText1.getText(); 
               long startTime = System.nanoTime();
               int ta = gExp.getTotaNoOfFlightsFlyingFrom(str);
               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
       		   long timeElapsed = endTime - startTime; 
       		   JOptionPane.showMessageDialog(frame, "Total Flights flying from "+str+" are:"+ta);		   
	    		JOptionPane.showMessageDialog(frame, "Adjacency List:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n");
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
        
        JButton btn1 = new JButton("Using Adjacency Matrix");
        btn1.setBackground(Color.white);
        btn1.setPreferredSize(new Dimension(400,30));
        btn1.setFont(new Font("Arial", Font.PLAIN, 15));
        
        
        JButton btn2 = new JButton("Using Adjacency List");
        btn2.setBackground(Color.white);
        btn2.setPreferredSize(new Dimension(400,30));
        btn2.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JButton Back = new JButton("Back");
        Back.setBackground(Color.white);
        Back.setFont(new Font("Arial", Font.PLAIN, 15));
        
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	getTotaNoOfFlightsFlyingToAM();
            	
               
            }
         });
        
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	getTotaNoOfFlightsFlyingToAL();
            	
               
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
    
    

   
    
    private void getTotaNoOfFlightsFlyingToAM()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);

        JTextField jtfNameLabel = new JTextField("Enter airport code", 15);
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

               String str = jtfText1.getText(); 
               long startTime = System.nanoTime();
               int ta = g.getTotaNoOfFlightsFlyingTo(str);
               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
       		   long timeElapsed = endTime - startTime; 
       		   
       		   JOptionPane.showMessageDialog(frame,"Total flights to "+str+" is:"+ta);
	        	JOptionPane.showMessageDialog(frame, "Adjacency Matrix:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n");	        				
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
    
    private void getTotaNoOfFlightsFlyingToAL()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);

        JTextField jtfNameLabel = new JTextField("Enter airport code", 15);
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
               int ta = gExp.getTotaNoOfFlightsFlyingTo(str);
               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
       		   long timeElapsed = endTime - startTime; 
       		   
       		   JOptionPane.showMessageDialog(frame,"Total flights to "+str+" is:"+ta);
	    		JOptionPane.showMessageDialog(frame, "Adjacency List:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n");
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
    
    private void Exp6Page()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Experiment 5***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);
        
        Frame frame = new Frame("Choice");
        
        JButton btn1 = new JButton("Using Adjacency Matrix");
        btn1.setBackground(Color.white);
        btn1.setPreferredSize(new Dimension(400,30));
        btn1.setFont(new Font("Arial", Font.PLAIN, 15));
        
        
        JButton btn2 = new JButton("Using Adjacency List");
        btn2.setBackground(Color.white);
        btn2.setPreferredSize(new Dimension(400,30));
        btn2.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JButton Back = new JButton("Back");
        Back.setBackground(Color.white);
        Back.setFont(new Font("Arial", Font.PLAIN, 15));
        
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	getTotaNoOfPassengersFlyingToAM();
            	
               
            }
         });
        
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	getTotaNoOfPassengersFlyingToAL();
            	
               
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
    
    

   
    
    private void getTotaNoOfPassengersFlyingToAM()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);

        JTextField jtfNameLabel = new JTextField("Enter airport code", 15);
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

               String str = jtfText1.getText(); 
               long startTime = System.nanoTime();
               int ta = g.getTotaNoOfPassengersFlyingTo(str);
               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
       		   long timeElapsed = endTime - startTime; 
       		   
       		   JOptionPane.showMessageDialog(frame,"Total passengers to "+str+" is:"+ta);
	        	JOptionPane.showMessageDialog(frame, "Adjacency Matrix:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n");	        				
	             }
            
         });
        
        JButton Back = new JButton("Back");
        Back.setBackground(Color.white);
        Back.setFont(new Font("Arial", Font.PLAIN, 15));
        Back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Exp6Page();
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
    
    private void getTotaNoOfPassengersFlyingToAL()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);

        JTextField jtfNameLabel = new JTextField("Enter airport code", 15);
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
               int ta = gExp.getTotaNoOfPassengersFlyingTo(str);
               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
       		   long timeElapsed = endTime - startTime; 
       		   
       		   JOptionPane.showMessageDialog(frame,"Total flights to "+str+" is:"+ta);
	    		JOptionPane.showMessageDialog(frame, "Adjacency List:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n");
            }
         });
        
        JButton Back = new JButton("Back");
        Back.setBackground(Color.white);
        Back.setFont(new Font("Arial", Font.PLAIN, 15));
        Back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Exp6Page();
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
    
    private void Exp7Page()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Experiment 5***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);
        
        Frame frame = new Frame("Choice");
        
        JButton btn1 = new JButton("Using Adjacency Matrix");
        btn1.setBackground(Color.white);
        btn1.setPreferredSize(new Dimension(400,30));
        btn1.setFont(new Font("Arial", Font.PLAIN, 15));
        
        
        JButton btn2 = new JButton("Using Adjacency List");
        btn2.setBackground(Color.white);
        btn2.setPreferredSize(new Dimension(400,30));
        btn2.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JButton Back = new JButton("Back");
        Back.setBackground(Color.white);
        Back.setFont(new Font("Arial", Font.PLAIN, 15));
        
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	getTotaNoOfPassengersFlyingFromAM();
            	
               
            }
         });
        
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	getTotaNoOfPassengersFlyingFromAL();
            	
               
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
    
    

   
    
    private void getTotaNoOfPassengersFlyingFromAM()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);

        JTextField jtfNameLabel = new JTextField("Enter airport code", 15);
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

               String str = jtfText1.getText(); 
               long startTime = System.nanoTime();
               int ta = g.getTotaNoOfPassengersFlyingFrom(str);
               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
       		   long timeElapsed = endTime - startTime; 
       		   
       		   JOptionPane.showMessageDialog(frame,"Total passengers from "+str+" is:"+ta);
	        	JOptionPane.showMessageDialog(frame, "Adjacency Matrix:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n");	        				
	             }
            
         });
        
        JButton Back = new JButton("Back");
        Back.setBackground(Color.white);
        Back.setFont(new Font("Arial", Font.PLAIN, 15));
        Back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Exp7Page();
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
    
    private void getTotaNoOfPassengersFlyingFromAL()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);

        JTextField jtfNameLabel = new JTextField("Enter airport code", 15);
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
               int ta = gExp.getTotaNoOfPassengersFlyingFrom(str);
               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
       		   long timeElapsed = endTime - startTime; 
       		   
       		   JOptionPane.showMessageDialog(frame,"Total passengers from "+str+" is:"+ta);
	    		JOptionPane.showMessageDialog(frame, "Adjacency List:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n");
            }
         });
        
        JButton Back = new JButton("Back");
        Back.setBackground(Color.white);
        Back.setFont(new Font("Arial", Font.PLAIN, 15));
        Back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Exp7Page();
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


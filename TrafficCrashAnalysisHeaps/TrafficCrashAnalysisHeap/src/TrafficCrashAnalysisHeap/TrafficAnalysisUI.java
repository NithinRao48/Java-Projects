package TrafficCrashAnalysisHeap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * TrafficAnalysisUI.java - User Interface for Traffic Data Analysis.
 * @author nsrao
 */

public class TrafficAnalysisUI extends JFrame implements ActionListener
{    	
	static MinHeapLLExperiments min_heapLL_city = new MinHeapLLExperiments();
	static MaxHeapLLExperiments max_heapLL_city = new MaxHeapLLExperiments();	
	static MinHeapArrayExperiments min_heapArray_city = new MinHeapArrayExperiments();
	static MaxHeapArrayExperiments max_heapArray_city = new MaxHeapArrayExperiments();
	static MinHeapPQExperiments min_heapPQ_city = new MinHeapPQExperiments();
	static MaxHeapPQExperiments max_heapPQ_city = new MaxHeapPQExperiments();
	
	public static void main (String []args) throws InterruptedException{
		
		
		
		
		Thread thread1 = new Thread() {
		    public void run() {
		    	max_heapLL_city.insertByCity();
		    }
		};

		Thread thread2 = new Thread() {
		    public void run() {
		    	min_heapLL_city.insertByCity();
		    }
		};
		
		Thread thread3 = new Thread() {
		    public void run() {
		    	max_heapArray_city.insertByCity();
		    }
		};

		Thread thread4 = new Thread() {
		    public void run() {
		    	min_heapArray_city.insertByCity();
		    }
		};
		
		Thread thread5 = new Thread() {
		    public void run() {
		    	max_heapPQ_city.insertByCity();
		    }
		};

		Thread thread6 = new Thread() {
		    public void run() {
		    	min_heapPQ_city.insertByCity();
		    }
		};
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
		

		// Wait for them both to finish
		thread1.join();
		thread2.join();
		
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
        
        JButton Exp1RegObj = new JButton("City wise accident analysis");
        Exp1RegObj.setBackground(Color.WHITE);
        Exp1RegObj.setPreferredSize(new Dimension(400,30));
        Exp1RegObj.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JButton Exp2RegObj = new JButton("Day wise accident analysis");
        Exp2RegObj.setBackground(Color.WHITE);
        Exp2RegObj.setPreferredSize(new Dimension(400,30));
        Exp2RegObj.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JButton Exp3RegObj = new JButton("Age group wise accident analysis");
        Exp3RegObj.setBackground(Color.WHITE);
        Exp3RegObj.setPreferredSize(new Dimension(400,30));
        Exp3RegObj.setFont(new Font("Arial", Font.PLAIN, 15));
        
        
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
        Exp2RegObj.setBackground(Color.WHITE);
        
        container.removeAll();
        this.validate();
        this.repaint();
        container.add(jtfRegLabel);
        container.add(Exp1RegObj); 
        container.add(Exp2RegObj);
        container.add(Exp3RegObj);
        container.setLayout(new FlowLayout());
        setSize(700, 700); // set size of window
        setVisible(true);// set it visible

    }
    
 private DefaultTableModel frameCity(ArrayList<Node> ta) {
        
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
           
           for(int i=0;i<ta.size();i++)
           {
        	   
        	   defaultTableModel.addRow(new Object[] {ta.get(i).data.getCity(), ta.get(i).acc_count});
           }
           
           return defaultTableModel;
           
    }
    
    private DefaultTableModel frameDays(ArrayList<Node> ta) {
        
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
           defaultTableModel.addColumn("Day");
           defaultTableModel.addColumn("count");
           
           for(int i=0;i<ta.size();i++)
           {
        	   
        	   defaultTableModel.addRow(new Object[] {ta.get(i).day, ta.get(i).acc_count});
           }
           
           return defaultTableModel;
           
    }

	private DefaultTableModel frameAgeGroup(ArrayList<Node> ta) {
	    
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
	       defaultTableModel.addColumn("Age group");
	       defaultTableModel.addColumn("count");
	       
	       for(int i=0;i<ta.size();i++)
	       {
	    	   
	    	   defaultTableModel.addRow(new Object[] {ta.get(i).ageGroup, ta.get(i).acc_count});
	       }
	       
	       return defaultTableModel;
	       
	}
    
    private void Exp2Page()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Experiment 1***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);
        
        Frame frame = new Frame("Choice");
        
        JButton btn1 = new JButton("Days with most accidents");
        btn1.setBackground(Color.white);
        btn1.setPreferredSize(new Dimension(400,30));
        btn1.setFont(new Font("Arial", Font.PLAIN, 15));
        
        
        JButton btn2 = new JButton("Days with least accidents");
        btn2.setBackground(Color.white);
        btn2.setPreferredSize(new Dimension(400,30));
        btn2.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JButton Back = new JButton("Back");
        Back.setBackground(Color.white);
        Back.setFont(new Font("Arial", Font.PLAIN, 15));
        
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	MaxHeapDays();
            	
               
            }
         });
        
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	MinHeapDay();
            	
               
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
    
    

   
    
    private void MaxHeapDays()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);

        JTextField jtfNameLabel = new JTextField("Enter number", 15);
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
            	MaxHeapArrayExperiments max_heapArray = new MaxHeapArrayExperiments();
            	MaxHeapPQExperiments max_heapPQ = new MaxHeapPQExperiments();
            	MaxHeapLLExperiments max_heapLL = new MaxHeapLLExperiments();
            	Thread thread1 = new Thread() {
        		    public void run() {
        		    	max_heapLL.InsertByDay();
        				//max_heapLL_age.insertByAgeGroup();
        				//max_heapLL_day.InsertByDay();
        		    }
        		};
        		Thread thread2 = new Thread() {
        		    public void run() {
        		    	max_heapArray.InsertByDay();
        				//max_heapLL_age.insertByAgeGroup();
        				//max_heapLL_day.InsertByDay();
        		    }
        		};
        		Thread thread3 = new Thread() {
        		    public void run() {
        		    	try {
							max_heapPQ.insertByDay();
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
        				//max_heapLL_age.insertByAgeGroup();
        				//max_heapLL_day.InsertByDay();
        		    }
        		};
        		
        		thread1.start();
        		thread2.start();
        		thread3.start();
        		
        		try {
        			thread1.join();
        			thread2.join();
					thread3.join();
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
               String op = "";
               String str = jtfText1.getText(); 
               long startTime = System.nanoTime();
               ArrayList<Node> ta = max_heapArray.topAccidentByDay(Integer.parseInt(str));
               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
       		   long timeElapsed = endTime - startTime; 
       		   if(ta.size()>0)
       		   {
       			   JTable table = new JTable(frameDays(ta));
	       		   
	       		   JScrollPane jsp = new JScrollPane(table);
	       		   jsp.setPreferredSize(new Dimension(680,100));
	       		   container.add(jsp);
	       		   setVisible(true);
       		   }
       		   else {
       			JOptionPane.showMessageDialog(frame, "Record Not Found!");
       		   }
       		   
       		   long startTime2 = System.nanoTime();
               ArrayList<Node> taLL = max_heapLL.topAccidentByDay(Integer.parseInt(str));
               long endTime2 = System.nanoTime(); // get the difference between the two nano time valuess
       		   long timeElapsed2 = endTime2 - startTime2; 
       		   
       		long startTime3=0,endTime3 = 0;
 		   try {
 			   startTime3 = System.nanoTime();
				ArrayList<Node> taPQ = max_heapPQ.topAccidentByDay(Integer.parseInt(str));
				endTime3 = System.nanoTime(); // get the difference between the two nano time valuess
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
 		   
		   long timeElapsed3 = endTime3 - startTime3; 
       		JOptionPane.showMessageDialog(frame, "MaxHeap using Array:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n"
       				+"MaxHeap using LinkedList:\nYour Execution time is:  "+timeElapsed2/1000000+" milliseconds\n("+timeElapsed2+" nanoseconds)\n"
       				+"MaxHeap using Priority Queue:\nYour Execution time is:  "+timeElapsed3/1000000+" milliseconds\n("+timeElapsed3+" nanoseconds)\n");
       				
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
    
    private void MinHeapDay()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);

        JTextField jtfNameLabel = new JTextField("Enter number", 15);
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
            	
            	MinHeapPQExperiments min_heapPQ = new MinHeapPQExperiments();
            	MinHeapArrayExperiments min_heapArray = new MinHeapArrayExperiments();
            	MinHeapLLExperiments min_heapLL = new MinHeapLLExperiments();
            	Thread thread1 = new Thread() {
        		    public void run() {
        		    	min_heapLL.InsertByDay();
        		    }
        		};
        		Thread thread2 = new Thread() {
        		    public void run() {
        		    	min_heapArray.InsertByDay();
        		    }
        		};
        		Thread thread3 = new Thread() {
        		    public void run() {
        		    	try {
							min_heapPQ.insertByDay();
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
        		    }
        		};
        		
        		thread1.start();
        		thread2.start();
        		thread3.start();
        		
        		try {
        			thread1.join();
        			thread2.join();
					thread3.join();
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
               String op = "";
               String str = jtfText1.getText(); 
               long startTime = System.nanoTime();
               ArrayList<Node> ta = min_heapArray.leastAccidentByDay(Integer.parseInt(str));
               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
       		   long timeElapsed = endTime - startTime; 
       		   if(ta.size()>0)
       		   {
       			   JTable table = new JTable(frameDays(ta));
	       		   
	       		   JScrollPane jsp = new JScrollPane(table);
	       		   jsp.setPreferredSize(new Dimension(680,100));
	       		   container.add(jsp);
	       		   setVisible(true);
       		   }
       		   else {
       			JOptionPane.showMessageDialog(frame, "Record Not Found!");
       		   }
       		   
       		   long startTime2 = System.nanoTime();
               ArrayList<Node> taLL = min_heapLL.leastAccidentByDay(Integer.parseInt(str));
               long endTime2 = System.nanoTime(); // get the difference between the two nano time valuess
       		   long timeElapsed2 = endTime2 - startTime2; 
       		
       		   
        		long startTime3=0,endTime3 = 0;
        		   try {
        			startTime3 = System.nanoTime();
 				ArrayList<Node> taPQ = min_heapPQ.leastAccidentByDay(Integer.parseInt(str));
 				endTime3 = System.nanoTime(); // get the difference between the two nano time valuess
 			} catch (NumberFormatException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			} catch (ParseException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
        		   
     		   long timeElapsed3 = endTime3 - startTime3; 
        		   
        		   
        		JOptionPane.showMessageDialog(frame, "MinHeap using Array:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n"
        				+"MinHeap using LinkedList:\nYour Execution time is:  "+timeElapsed2/1000000+" milliseconds\n("+timeElapsed2+" nanoseconds)\n"
        				+"MinHeap using Priority Queue:\nYour Execution time is:  "+timeElapsed3/1000000+" milliseconds\n("+timeElapsed3+" nanoseconds)\n");
        				
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
    
    private void Exp1Page()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Experiment 1***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);
        
        Frame frame = new Frame("Choice");
        
        JButton btn1 = new JButton("N Cities with most accidents");
        btn1.setBackground(Color.white);
        btn1.setPreferredSize(new Dimension(400,30));
        btn1.setFont(new Font("Arial", Font.PLAIN, 15));
        
        
        JButton btn2 = new JButton("N cities with least accidents");
        btn2.setBackground(Color.white);
        btn2.setPreferredSize(new Dimension(400,30));
        btn2.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JButton Back = new JButton("Back");
        Back.setBackground(Color.white);
        Back.setFont(new Font("Arial", Font.PLAIN, 15));
        
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	MaxHeapCity();
            	
               
            }
         });
        
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	MinHeapCity();
            	
               
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
    
    

   
    
    private void MaxHeapCity()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);

        JTextField jtfNameLabel = new JTextField("Enter Number", 15);
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
               ArrayList<Node> ta = max_heapArray_city.topAccidentByCity(Integer.parseInt(str));
               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
       		   long timeElapsed = endTime - startTime; 
       		   if(ta.size()>0)
       		   {
       			   JTable table = new JTable(frameCity(ta));
	       		   
	       		   JScrollPane jsp = new JScrollPane(table);
	       		   jsp.setPreferredSize(new Dimension(680,100));
	       		   container.add(jsp);
	       		   setVisible(true);
       		   }
       		   else {
       			JOptionPane.showMessageDialog(frame, "Record Not Found!");
       		   }
       		   
       		   long startTime2 = System.nanoTime();
               ArrayList<Node> taLL = max_heapLL_city.topAccidentByCity(Integer.parseInt(str));
               long endTime2 = System.nanoTime(); // get the difference between the two nano time valuess
       		   long timeElapsed2 = endTime2 - startTime2; 
       		
	       		long startTime3=0,endTime3 = 0;
	  		   try {
	  			   startTime3 = System.nanoTime();
	 				ArrayList<Node> taPQ = max_heapPQ_city.topAccidentByCity(Integer.parseInt(str));
	 				endTime3 = System.nanoTime(); // get the difference between the two nano time valuess
	 			} catch (NumberFormatException | ParseException e1) {
	 				// TODO Auto-generated catch block
	 				e1.printStackTrace();
	 			}
	  		   
	 		   long timeElapsed3 = endTime3 - startTime3; 
	        		JOptionPane.showMessageDialog(frame, "MaxHeap using Array:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n"
	        				+"MaxHeap using LinkedList:\nYour Execution time is:  "+timeElapsed2/1000000+" milliseconds\n("+timeElapsed2+" nanoseconds)\n"
	        				+"MaxHeap using Priority Queue:\nYour Execution time is:  "+timeElapsed3/1000000+" milliseconds\n("+timeElapsed3+" nanoseconds)\n");
	        				
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
    
    private void MinHeapCity()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);

        JTextField jtfNameLabel = new JTextField("Enter Number", 15);
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
            	MinHeapPQExperiments min_heapPQ = new MinHeapPQExperiments();
            	MinHeapArrayExperiments min_heapArray = new MinHeapArrayExperiments();
            	//MinHeapLLExperiments min_heapLL = new MinHeapLLExperiments();
               String op = "";
               String str = jtfText1.getText(); 
               long startTime = System.nanoTime();
               ArrayList<Node> ta = null;
			try {
				ta = min_heapPQ_city.leastAccidentByCity(Integer.parseInt(str));
			} catch (NumberFormatException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
       		   long timeElapsed = endTime - startTime; 
       		   if(ta.size()>0)
       		   {
       			   JTable table = new JTable(frameCity(ta));
	       		   
	       		   JScrollPane jsp = new JScrollPane(table);
	       		   jsp.setPreferredSize(new Dimension(680,100));
	       		   container.add(jsp);
	       		   setVisible(true);
       		   }
       		   else {
       			JOptionPane.showMessageDialog(frame, "Record Not Found!");
       		   }
       		   
       		   long startTime2 = System.nanoTime();
               ArrayList<Node> taLL = min_heapLL_city.leastAccidentByCity(Integer.parseInt(str));
               long endTime2 = System.nanoTime(); // get the difference between the two nano time valuess
       		   long timeElapsed2 = endTime2 - startTime2;
       		   
       		   
       		long startTime3=0,endTime3 = 0;
       		   try {
       			startTime3 = System.nanoTime();
       			ArrayList<Node> taArr = min_heapArray_city.leastAccidentByCity(Integer.parseInt(str));
				endTime3 = System.nanoTime(); // get the difference between the two nano time valuess
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
       		   
    		   long timeElapsed3 = endTime3 - startTime3; 
       		   
       		   
       		JOptionPane.showMessageDialog(frame, "MinHeap using Array:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n"
       				+"MinHeap using LinkedList:\nYour Execution time is:  "+timeElapsed2/1000000+" milliseconds\n("+timeElapsed2+" nanoseconds)\n"
       				+"MinHeap using Priority Queue:\nYour Execution time is:  "+timeElapsed3/1000000+" milliseconds\n("+timeElapsed3+" nanoseconds)\n");
       				
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
    
    private void Exp3Page()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Experiment 1***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);
        
        Frame frame = new Frame("Choice");
        
        JButton btn1 = new JButton("Age group with most accidents");
        btn1.setBackground(Color.white);
        btn1.setPreferredSize(new Dimension(400,30));
        btn1.setFont(new Font("Arial", Font.PLAIN, 15));
        
        
        JButton btn2 = new JButton("Age group with least accidents");
        btn2.setBackground(Color.white);
        btn2.setPreferredSize(new Dimension(400,30));
        btn2.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JButton Back = new JButton("Back");
        Back.setBackground(Color.white);
        Back.setFont(new Font("Arial", Font.PLAIN, 15));
        
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	MaxHeapAgeGroup();
            	
               
            }
         });
        
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	MinHeapAgeGroup();
            	
               
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
    
    

   
    
    private void MaxHeapAgeGroup()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);

        JTextField jtfNameLabel = new JTextField("Enter number", 15);
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
            	MaxHeapArrayExperiments max_heapArray = new MaxHeapArrayExperiments();
            	MaxHeapLLExperiments max_heapLL = new MaxHeapLLExperiments();
            	MaxHeapPQExperiments max_heapPQ = new MaxHeapPQExperiments();
            	Thread thread1 = new Thread() {
        		    public void run() {
        		    	max_heapLL.insertByAgeGroup();
        		    }
        		};
        		Thread thread2 = new Thread() {
        		    public void run() {
        		    	max_heapArray.insertByAgeGroup();
        		    }
        		};
        		Thread thread3 = new Thread() {
        		    public void run() {
        		    	max_heapPQ.insertByAgeGroup();
        		    }
        		};
        		
        		thread1.start();
        		thread2.start();
        		thread3.start();
        		
        		try {
        			thread1.join();
        			thread2.join();
					thread3.join();
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
               String op = "";
               String str = jtfText1.getText(); 
               long startTime = System.nanoTime();
               ArrayList<Node> ta = max_heapArray.topAccidentByAgeGroup(Integer.parseInt(str));
               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
       		   long timeElapsed = endTime - startTime; 
       		   if(ta.size()>0)
       		   {
       			   JTable table = new JTable(frameAgeGroup(ta));
	       		   
	       		   JScrollPane jsp = new JScrollPane(table);
	       		   jsp.setPreferredSize(new Dimension(680,100));
	       		   container.add(jsp);
	       		   setVisible(true);
       		   }
       		   else {
       			JOptionPane.showMessageDialog(frame, "Record Not Found!");
       		   }
       		   
       		   long startTime2 = System.nanoTime();
               ArrayList<Node> taLL = max_heapLL.topAccidentByAgeGroup(Integer.parseInt(str));
               long endTime2 = System.nanoTime(); // get the difference between the two nano time valuess
       		   long timeElapsed2 = endTime2 - startTime2; 


	       		long startTime3=0,endTime3 = 0;
	  		   try {
	  			   startTime3 = System.nanoTime();
	 				ArrayList<Node> taPQ = max_heapPQ.topAccidentByAgeGroup(Integer.parseInt(str));
	 				endTime3 = System.nanoTime(); // get the difference between the two nano time valuess
	 			} catch (NumberFormatException e1) {
	 				// TODO Auto-generated catch block
	 				e1.printStackTrace();
	 			}
	  		   
	 		   long timeElapsed3 = endTime3 - startTime3; 
	        		JOptionPane.showMessageDialog(frame, "MaxHeap using Array:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n"
	        				+"MaxHeap using LinkedList:\nYour Execution time is:  "+timeElapsed2/1000000+" milliseconds\n("+timeElapsed2+" nanoseconds)\n"
	        				+"MaxHeap using Priority Queue:\nYour Execution time is:  "+timeElapsed3/1000000+" milliseconds\n("+timeElapsed3+" nanoseconds)\n");
	        				
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
    
    private void MinHeapAgeGroup()
    {
    	Container container = getContentPane();
    	JTextField jtfRegLabel = new JTextField("***Search***", 50);
    	jtfRegLabel.setFont(new Font("Arial",Font.PLAIN,15));
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);

        JTextField jtfNameLabel = new JTextField("Enter number", 15);
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
            	MinHeapArrayExperiments min_heapArray = new MinHeapArrayExperiments();
            	MinHeapPQExperiments min_heapPQ = new MinHeapPQExperiments();
            	MinHeapLLExperiments min_heapLL = new MinHeapLLExperiments();
             	Thread thread1 = new Thread() {
        		    public void run() {
        		    	min_heapLL.insertByAgeGroup();
        		    }
        		};
        		Thread thread2 = new Thread() {
        		    public void run() {
        		    	min_heapArray.insertByAgeGroup();
        		    }
        		};
        		Thread thread3 = new Thread() {
        		    public void run() {
        		    	min_heapPQ.insertByAgeGroup();
        		    }
        		};
        		
        		thread1.start();
        		thread2.start();
        		thread3.start();
        		
        		try {
        			thread1.join();
        			thread2.join();
					thread3.join();
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
               String op = "";
               String str = jtfText1.getText(); 
               long startTime = System.nanoTime();
               ArrayList<Node> ta = min_heapArray.leastAccidentByAgeGroup(Integer.parseInt(str));
               long endTime = System.nanoTime(); // get the difference between the two nano time valuess
       		   long timeElapsed = endTime - startTime; 
       		   if(ta.size()>0)
       		   {
       			   JTable table = new JTable(frameAgeGroup(ta));
	       		   
	       		   JScrollPane jsp = new JScrollPane(table);
	       		   jsp.setPreferredSize(new Dimension(680,100));
	       		   container.add(jsp);
	       		   setVisible(true);
       		   }
       		   else {
       			JOptionPane.showMessageDialog(frame, "Record Not Found!");
       		   }
       		   
       		   long startTime2 = System.nanoTime();
               ArrayList<Node> taLL = min_heapLL.leastAccidentByAgeGroup(Integer.parseInt(str));
               long endTime2 = System.nanoTime(); // get the difference between the two nano time valuess
       		   long timeElapsed2 = endTime2 - startTime2; 

	       		long startTime3=0,endTime3 = 0;
	    		   try {
	    			startTime3 = System.nanoTime();
					ArrayList<Node> taPQ = min_heapPQ.leastAccidentByAgeGroup(Integer.parseInt(str));
					endTime3 = System.nanoTime(); // get the difference between the two nano time valuess
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		   
	 		   long timeElapsed3 = endTime3 - startTime3; 
	    		   
	    		   
	    		JOptionPane.showMessageDialog(frame, "MinHeap using Array:\nYour Execution time is:  "+timeElapsed/1000000+" milliseconds\n("+timeElapsed+" nanoseconds)\n"
	    				+"MinHeap using LinkedList:\nYour Execution time is:  "+timeElapsed2/1000000+" milliseconds\n("+timeElapsed2+" nanoseconds)\n"
	    				+"MinHeap using Priority Queue:\nYour Execution time is:  "+timeElapsed3/1000000+" milliseconds\n("+timeElapsed3+" nanoseconds)\n");
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
}

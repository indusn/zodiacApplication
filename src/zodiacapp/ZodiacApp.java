package zodiacapp;

import java.awt.*;        
import java.awt.event.*;  
import java.util.stream.IntStream;

public class ZodiacApp extends Frame implements ActionListener, WindowListener,ItemListener {
    public Frame mainFrame;
    public TextField zodiacDisplay;
    public TextField dayDisplay;
    public Choice month;
    public Choice date;
    public Choice year;
    public String MyDate="";
    public static String[] zodiacSigns = new String[]{
        "Capricorn","Aquarius","Pisces","Aries","Taurus","Gemini","Cancer","Leo",
        "Virgo","Libra","Scorpio","Sagittarius","none"
    };
    
    public ZodiacApp () {    //constructor
        setLayout(new FlowLayout());
        setTitle("Horoscope application"); 
        setSize(600, 150);   
        Label userPrompt = new Label("Enter Date of birth:");
        month= new Choice(); 
        IntStream.rangeClosed(1, 12)
                 .forEach(n -> month.add(Integer.toString(n)));
        month.addItemListener(this);
        date= new Choice();
        date.add("    ");
        year= new Choice();  
        IntStream.rangeClosed(1900, 2016)
                 .forEach(n -> year.add(Integer.toString(n)));
        Button btnSubmit = new Button("Get Day");                       
        Label dayToBeDisplayed = new Label("The day of the week for the given date of birth:");
        Label mmLabel = new Label("mm");
        Label ddLabel = new Label("dd");
        Label yyLabel = new Label("yyyy");
        Label zodiacToDisplay = new Label("The Zodiac Sign for the given date of birth:");
        dayDisplay = new TextField(12);
        date.addItemListener(this);
        year.addItemListener(this);
        btnSubmit.addActionListener(this);
        Button btnHoroscope = new Button("Get Horoscope");
        btnHoroscope.addActionListener(this);
        zodiacDisplay = new TextField(12);
        
        add(userPrompt);
        add(mmLabel);
        add(month);
        add(ddLabel);
        add(date);
        add(yyLabel);
        add(year);
        add(btnSubmit);
        add(btnHoroscope);
        add(dayToBeDisplayed);
        add(dayDisplay);
        add(zodiacToDisplay);
        add(zodiacDisplay);
        addWindowListener(this);
        setVisible(true);         
    }
    public static void main(String[] args) {
        ZodiacApp app = new ZodiacApp();
    }
   
   @Override
    public void windowClosing(WindowEvent evt) {
      System.exit(0);
    }
    @Override public void windowOpened(WindowEvent evt) { }
    @Override public void windowClosed(WindowEvent evt) { }
    @Override public void windowIconified(WindowEvent evt) { }
    @Override public void windowDeiconified(WindowEvent evt) { }
    @Override public void windowActivated(WindowEvent evt) { }
    @Override public void windowDeactivated(WindowEvent evt) { }
    @Override 
    public void itemStateChanged(ItemEvent e){ 
        
       if((((((month.getSelectedItem().equals("3") || month.getSelectedItem().equals("1")) || month.getSelectedItem().equals("5")) || month.getSelectedItem().equals("7")) || month.getSelectedItem().equals("8")) || month.getSelectedItem().equals("10")) || month.getSelectedItem().equals("12")) {
            IntStream.rangeClosed(1, 31)
                 .forEach(n -> date.add(Integer.toString(n)));
        }
        else if(((month.getSelectedItem().equals("4") || month.getSelectedItem().equals("6")) || month.getSelectedItem().equals("9")) || month.getSelectedItem().equals("10")){
            IntStream.rangeClosed(1, 30)
                 .forEach(n -> date.add(Integer.toString(n)));
        }
        else{
            IntStream.rangeClosed(1, 29)
                 .forEach(n -> date.add(Integer.toString(n)));
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        
        if(evt.getActionCommand().equals("Get Day")){
            MyDate=dayCalculation.findDayOfTheWeek(month.getSelectedItem(),date.getSelectedItem(),year.getSelectedItem());
            dayDisplay.setText(MyDate);
        } 
        else if(evt.getActionCommand().equals("Get Horoscope")&& !"Invalid Date".equals(MyDate)){
            String userZodiac=zodiacCalculation.getHoroscope(Integer.parseInt(month.getSelectedItem()),Integer.parseInt(date.getSelectedItem()));
            zodiacDisplay.setText(userZodiac);
        }
        else if(evt.getActionCommand().equals("Get Horoscope")&& "Invalid Date".equals(MyDate)){
            zodiacDisplay.setText("Invalid Date");
        }
    }    
}
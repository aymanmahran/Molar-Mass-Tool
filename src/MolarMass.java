import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.RenderingHints;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class MolarMass {

	static JFrame searchWindow;
	static JTextField element;
	static JLabel symbol;
	public static JLabel molarMass;
	static JPanel symbolInfo;
	static JPanel massInfo;
	static int posX;
	static int posY;
	
	public static final String[] names = {"Hydrogen","Helium","Lithium","Beryllium","Boron","Carbon","Nitrogen","Oxygen","Fluorine","Neon","Sodium","Magnesium","Aluminum","Silicon","Phosphorus","Sulfur","Chlorine","Argon","Potassium","Calcium","Scandium","Titanium","Vanadium","Chromium","Manganese","Iron","Cobalt","Nickel","Copper","Zinc","Gallium","Germanium","Arsenic","Selenium","Bromine","Krypton","Rubidium","Strontium","Yttrium","Zirconium","Niobium","Molybdenum","Technetium","Ruthenium","Rhodium","Palladium","Silver","Cadmium","Indium","Tin","Antimony","Tellurium","Iodine","Xenon","Cesium","Barium","Lanthanum","Cerium","Praseodymium","Neodymium","Promethium","Samarium","Europium","Gadolinium","Terbium","Dysprosium","Holmium","Erbium","Thulium","Ytterbium","Lutetium","Hafnium","Tantalum","Wolfram","Rhenium","Osmium","Iridium","Platinum","Gold","Mercury","Thallium","Lead","Bismuth","Polonium","Astatine","Radon","Francium","Radium","Actinium","Thorium","Protactinium","Uranium","Neptunium","Plutonium","Americium","Curium","Berkelium","Californium","Einsteinium","Fermium","Mendelevium","Nobelium","Lawrencium","Rutherfordium","Dubnium","Seaborgium","Bohrium","Hassium","Meitnerium","Darmstadtium ","Roentgenium ","Copernicium ","Nihonium","Flerovium","Moscovium","Livermorium","Tennessine","Oganesson"};
	public static final String[] syms = {"H","He","Li","Be","B","C","N","O","F","Ne","Na","Mg","Al","Si","P","S","Cl","Ar","K","Ca","Sc","Ti","V","Cr","Mn","Fe","Co","Ni","Cu","Zn","Ga","Ge","As","Se","Br","Kr","Rb","Sr","Y","Zr","Nb","Mo","Tc","Ru","Rh","Pd","Ag","Cd","In","Sn","Sb","Te","I","Xe","Cs","Ba","La","Ce","Pr","Nd","Pm","Sm","Eu","Gd","Tb","Dy","Ho","Er","Tm","Yb","Lu","Hf","Ta","W","Re","Os","Ir","Pt","Au","Hg","Tl","Pb","Bi","Po","At","Rn","Fr","Ra","Ac","Th","Pa","U","Np","Pu","Am","Cm","Bk","Cf","Es","Fm","Md","No","Lr","Rf","Db","Sg","Bh","Hs","Mt","Ds ","Rg ","Cn ","Nh","Fl","Mc","Lv","Ts","Og"};
	public static final String[] nums = {"1.007","4.002","6.941","9.012","10.811","12.011","14.007","15.999","18.998","20.18","22.99","24.305","26.982","28.086","30.974","32.065","35.453","39.948","39.098","40.078","44.956","47.867","50.942","51.996","54.938","55.845","58.933","58.693","63.546","65.38","69.723","72.64","74.922","78.96","79.904","83.798","85.468","87.62","88.906","91.224","92.906","95.96","98","101.07","102.906","106.42","107.868","112.411","114.818","118.71","121.76","127.6","126.904","131.293","132.905","137.327","138.905","140.116","140.908","144.242","145","150.36","151.964","157.25","158.925","162.5","164.93","167.259","168.934","173.054","174.967","178.49","180.948","183.84","186.207","190.23","192.217","195.084","196.967","200.59","204.383","207.2","208.98","210","210","222","223","226","227","232.038","231.036","238.029","237","244","243","247","247","251","252","257","258","259","262","261","262","266","264","267","268","271","272","285","284","289","288","292","295","294"};

	private static List<String> words = new ArrayList<>();
	
	public static void main(String[] args) {
		
		
//		String row;
//		String out1 = "{";
//		String out2 = "{";
//		String out3 = "{";
//		BufferedReader csvReader;
//		try {
//			csvReader = new BufferedReader(new FileReader("/home/ayman/Downloads/c2dd862cd38f21b0ad36b8f96b4bf1ee-1d92663004489a5b6926e944c1b3d9ec5c40900e/Periodic Table of Elements.csv"));
//			while ((row = csvReader.readLine()) != null) {
//			    String[] data = row.split(",");
//			    out1 = out1 + "\"" + data[1] + "\","; 
//			    out2 = out2 + "\"" + data[2] + "\","; 
//			    out3 = out3 + "\"" + data[3] + "\","; 
//			}
//			csvReader.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println(out1);
//		System.out.println(out2);
//		System.out.println(out3);
//		System.exit(0);
		
		for(int i=0; i<names.length; i++) {
			words.add(names[i] + " (" + syms[i] + ")");
		}
		
		searchWindow = new JFrame();
		searchWindow.setSize(170, 80);
		searchWindow.setUndecorated(true);
		searchWindow.setResizable(false);
		searchWindow.setAlwaysOnTop(true);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		searchWindow.setLocation(screenSize.getSize().width - 220, 50);
		
		element = new HintTextField("Element");
		symbol = new JLabel("-");
		molarMass = new JLabel("-");
		
		element.setBounds(10, 10, 150, 25);
		
		symbolInfo = new JPanel();
		massInfo = new JPanel();
		
		massInfo.setBounds(10, 45, 150, 25);
		massInfo.setLayout(new FlowLayout(FlowLayout.LEFT));
		massInfo.add(new JLabel("M: "));
		massInfo.add(molarMass);

		Action enterAction = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selected = element.getText();
				molarMass.setText("-");
				for(int i=0; i<names.length; i++) {
					if(selected.startsWith(names[i])) {
						molarMass.setText(nums[i]);
						break;
					}
				}
			}
		};
		
		element.addActionListener(enterAction);
		
		SuggestionDropDownDecorator.decorate(element,
	              new TextComponentSuggestionClient(MolarMass::getSuggestions));
		
		searchWindow.add(element);
		searchWindow.add(symbolInfo);
		searchWindow.add(massInfo);
		
		searchWindow.setLayout(null);
	      
		searchWindow.setVisible(true);
		
		searchWindow.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				posX = e.getX();
				posY = e.getY();
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 3) {
					System.exit(0);
				}
			}
		});
		
		searchWindow.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = searchWindow.getX() + e.getX() - posX;
				int y = searchWindow.getY() + e.getY() - posY;
				searchWindow.setBounds(x, y, searchWindow.getWidth(), searchWindow.getHeight());
			}
		});
			
	}
	
	

    private static List<String> getSuggestions(String input) {
      //the suggestion provider can control text search related stuff, e.g case insensitive match, the search  limit etc.
        if (input.isEmpty()) {
            return null;
        }
        return words.stream()
                    .filter(s -> s.toLowerCase().contains(input.toLowerCase()))
                    .limit(10)
                    .collect(Collectors.toList());
    }

}

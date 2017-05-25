package View;

import javax.swing.*;
import javax.swing.border.*;


import Res.Geo_Gridline;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class Geo_UI extends JFrame{

	//layout declarations
	private GridLayout frameLayout = new GridLayout(0, 1);
	private GridBagLayout buttonLayout = new GridBagLayout();
	//private FlowLayout buttonLayout = new FlowLayout();
	private GridBagLayout labelPanelLayout = new GridBagLayout();
	
	//top Panel and child button declaration
	private JPanel topPanel;
	private JLabel introLabel;
	//hey this is a random comment
	private JButton connectChildren, reset;
	
	//Canvas panel
	public Geo_Canvas canvas;
	
	//Options panel stuff
	private JPanel bottomPanel;
	
		//top panel contains label, two radioButtons and a textField
		private JPanel labelPanel;
		private JLabel optionsLabel;
		private JRadioButton all, byID;
		private ButtonGroup radioGroup;
		public JTextField idNumber;
	
	
		//arrow buttons and their panel
		public JPanel group;
		public JButton up, down, right, left;
		
		//customization panel and its components
		private JLabel paintColorLabel, lineColorLabel;
		//some sort of color selector thing should go here
		private JSlider pointWeight, lineWeight;
		private JCheckBox showGridLines;
		public boolean gridLinesVisible = true;

	public Geo_UI(Geo_Canvas canvas){
		super("Geometric Shape Drawing Application");
		
		//set canvas
		this.canvas = canvas;	
		GridBagConstraints constraints = new GridBagConstraints();
		
		//define the Top panel and its components
		topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		topPanel.setBackground(Color.GRAY);
		
		introLabel = new JLabel("here's a title");
		introLabel.setForeground(Color.WHITE);
		
		
		topPanel.add(introLabel);
		
		//define bottomPanel and its components
		bottomPanel = new JPanel();
		bottomPanel.setLayout(frameLayout);
		bottomPanel.setBackground(Color.gray);
		
		
		
		
		
		//label, radioButtons and textfield and respective panel
		labelPanel = new JPanel();
		labelPanel.setLayout(buttonLayout);
		optionsLabel = new JLabel("Select: ");
		
		//initialize radioButtons
		all = new JRadioButton("All");
		byID = new JRadioButton("By ID: ");
		all.setSelected(true);
		radioGroup = new ButtonGroup();
		radioGroup.add(all);
		radioGroup.add(byID);
		
		idNumber = new JTextField("ID #");
		constraints.anchor = constraints.NORTHWEST;
		constraints.gridy = 0;
		labelPanel.add(optionsLabel, constraints);
		constraints.gridy = 1;
		labelPanel.add(all, constraints);
		constraints.gridy = 2;
		labelPanel.add(byID, constraints);
		constraints.gridx = 2;
		labelPanel.add(idNumber, constraints);
		
		
		//arrow buttons and respective panel
		group = new JPanel();
		group.setLayout(buttonLayout);
		group.setBackground(Color.LIGHT_GRAY);
		group.setBorder(new SoftBevelBorder(1));
		
		constraints.gridx = 2;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		constraints.insets = new Insets(1,1,1,1);
		constraints.anchor = constraints.SOUTH;
		
		up = new JButton("Up");
		down = new JButton("down");
		right = new JButton("right");
		left = new JButton("left");
		
		group.add(up, constraints);
		constraints.gridy = 2;
		constraints.anchor = constraints.NORTH;
		group.add(down, constraints);
		constraints.gridx = 3;
		constraints.gridy = 1;
		constraints.anchor = constraints.EAST;
		group.add(right, constraints);
		constraints.gridy = 1;
		constraints.gridx = 1;
		constraints.anchor = constraints.WEST;
		group.add(left, constraints);
		
		//adding sub-panels to parent panel
		bottomPanel.add(labelPanel);
		bottomPanel.add(group);
		
		
		
		/*
		bottomPanel.add(up);
		bottomPanel.add(down);
		bottomPanel.add(right);
		bottomPanel.add(left);*/
		//bottomPanel.setMaximumSize(bottomSize);
		
		this.add(topPanel, BorderLayout.BEFORE_FIRST_LINE);
		this.add(canvas, BorderLayout.CENTER);
		this.add(bottomPanel, BorderLayout.EAST);
		
		
		
	}
	
	public void prepareCanvas(ArrayList<Geo_Gridline> lines){
		//canvas.prepareGrid(lines);
	}
	
	public void addCanvasListener(MouseListener canvasListener){
		
		canvas.addMouseListener(canvasListener);
		
	}
}

package com.bnet.fileprocessor.gui;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.filechooser.*;

import com.bnet.fileprocessor.logic.Main;

public class MainGUI extends JFrame implements ActionListener {
	static JTextArea l;
	private File inFile;
	private File outFile;
	private Main mainLogic;
	
	public MainGUI() {
		mainLogic = null;
		inFile = null;
		outFile = null;
	}
	
	public static void main(String args[]) {
		JFrame f = new JFrame("CASXSoftware - File Processor");
		
		f.setSize(300,300);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button1 = new JButton("Save");
		JButton button2 = new JButton("Open");
		JButton button3 = new JButton("Compute");
		
		MainGUI f1 = new MainGUI();
		
		button1.addActionListener(f1);
		button2.addActionListener(f1);
		button3.addActionListener(f1);
		
		JPanel p = new JPanel();
		
		p.add(button1);
		p.add(button2);
		
		JPanel bottom = new JPanel();
		
		bottom.add(button3);
		
		l = new JTextArea("no file selected");
		l.setEditable(false);
		l.setLineWrap(true);
		l.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(l);
		
		f.add(BorderLayout.NORTH, p);
		f.add(BorderLayout.CENTER, scrollPane);
		f.add(BorderLayout.SOUTH, bottom);
		
		f.getContentPane();
		
		f.show();
	}
	
	public void actionPerformed(ActionEvent evt) {
		String com = evt.getActionCommand();
		
		if (com.contentEquals("Save")) {
			JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			
			j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			
			int r = j.showSaveDialog(null);
			if (r == JFileChooser.APPROVE_OPTION) {
				outFile = j.getSelectedFile();
				l.append("\n\nSAVE DIRECTORY UPDATED: " + outFile.getAbsolutePath());
			} else {
				l.append("\n\nthe user cancelled the operation");
			}
		} else if (com.contentEquals("Open")) {
			JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			
			j.setAcceptAllFileFilterUsed(false);
			j.setDialogTitle("Select a .csv file");
			
			FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .csv files", "csv");
			j.addChoosableFileFilter(restrict);
			
			int r = j.showOpenDialog(null);
			if (r == JFileChooser.APPROVE_OPTION) {
				inFile = j.getSelectedFile();
				l.append("\n\nFILE SELECTED: " + inFile.getAbsolutePath());
			} else {
				l.append("\n\nthe user cancelled the operation");
			}
		} else {
			if (mainLogic == null) {
				mainLogic = new Main(inFile, outFile);
				mainLogic.run();
			} else {
				mainLogic.run();
			}
		}
	}
}
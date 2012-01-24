/*
 * MainJFrame.java
 *
 * Copyright (C) 2011,  Sanmoy Ray
 * 
 * This file is part of google-document-translator.
 *
 * Google Document Translator is not a product from Google. Neither it is endorsed nor it is supported by Google.
 * This is an open source and free software. you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License,
 * or(at your option) any later version.
 * 
 * Google Document Translator is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Google Document Translator.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.google.gdt.ui;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Point;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ToolTipManager;
import javax.swing.TransferHandler;

import com.google.gdt.main.GdtJob;
import com.google.gdt.main.PreferenceModel;

/**
 * 
 * @author Sanmoy
 *
 */
public class MainJFrame extends javax.swing.JFrame {

	public static MainJFrame mainFrame;
	
	private static Logger logger = Logger.getLogger("MainJFrame.class");
	
	/**
	 * returns the singleton instance
	 */
	public static synchronized MainJFrame getInstance() {
		if(mainFrame == null)
		{
			mainFrame = new MainJFrame();
		}	
		return mainFrame;
		
	}
	
    /** Creates new form MainJFrame */
    private MainJFrame() {
    	preferenceModel = PreferenceModel.getInstance();
        initComponents();
    }

    @Override
    public void setResizable(boolean resizable) {
        super.setResizable(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new GdtScrollPane();
        browseButton = new javax.swing.JButton();
        translateButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        recentFileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        preferenceMenuItem = new javax.swing.JMenuItem();
        helpMenuItem = new javax.swing.JMenuItem();
        troubleMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();
        jpanel = new JPanel();
        fromLabel = new JLabel();
        toLabel = new JLabel();
        fromComboBox = new FromComboBox();
        toComboBox = new ToComboBox();
        
//        transferHandler = new GdtTransferHandler();
//        this.setTransferHandler(transferHandler);
        new DropTarget(this, new GdtDropTargetListener());

//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        jpanel.setPreferredSize(new Dimension(630, 200));
        jpanel.setMinimumSize(new Dimension(630, 200));
        jpanel.setLayout(new FlowLayout());
        
        
        jScrollPane1.setBounds(10, 60, 650, 300);
        jScrollPane1.setViewportView(jpanel);
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        jScrollPane1.setToolTipText("drop files here to translate");
		ToolTipManager.sharedInstance().registerComponent(jScrollPane1);
		getContentPane().add(jScrollPane1);
        
        fromLabel.setBounds(10, 20, 35, 25);
        fromLabel.setText("From:");
        getContentPane().add(fromLabel);
        
        fromComboBox.setBounds(50, 20, 120, 25);
        getContentPane().add(fromComboBox);
        
        toLabel.setBounds(180, 20, 25, 25);
        toLabel.setText("To:");
        getContentPane().add(toLabel);
        
        toComboBox.setBounds(205, 20, 120, 25);
        getContentPane().add(toComboBox);
        
        browseButton.setText("Browse");
        browseButton.setBounds(350, 20, 90, 25);
        browseButton.setMnemonic('b');
        getContentPane().add(browseButton);
        browseButton.addActionListener(new ActionListener()
        {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				browseButtonActionPerformed(e);
			}
        });

        translateButton.setText("Translate");
        translateButton.setEnabled(false);
        getContentPane().add(translateButton);
        translateButton.setBounds(460, 20, 90, 25);
        translateButton.addActionListener(new ActionListener()
        {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				translateButtonActionPerformed(e);
			}
        });

        cancelButton.setText("Cancel");
        cancelButton.setEnabled(false);
        getContentPane().add(cancelButton);
        cancelButton.setBounds(570, 20, 90, 25);
        cancelButton.addActionListener(new ActionListener() 
        {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				for(GdtJob gdtJob: gdtJobs)
				{
					gdtJob.getHandler().setInterrupt(true);
				}
			}
		});

        fileMenu.setText("File");
        fileMenu.setMnemonic('F');
        
        openMenuItem.setText("Open");
        openMenuItem.setMnemonic('o');
        fileMenu.add(openMenuItem);
        openMenuItem.addActionListener(new ActionListener()
        {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				browseButtonActionPerformed(e);
			}
        });

        recentFileMenu.setText("Recent");
        recentFileMenu.setMnemonic('R');
        fileMenu.add(recentFileMenu);
        for(String filename:preferenceModel.getRecentFiles())
        {
        	if(new File(filename).exists())
        	{
	        	JMenuItem recent = new RecentFileMenuItem(filename);
	        	recentFileMenu.add(recent);
        	}
        }

        exitMenuItem.setText("Exit");
        exitMenuItem.setMnemonic('x');
        fileMenu.add(exitMenuItem);
        exitMenuItem.addActionListener(new ActionListener()
        {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				exitAction(e);
			}
        });

        jMenuBar.add(fileMenu);

        helpMenu.setText("Help");
        helpMenu.setMnemonic('h');

        preferenceMenuItem.setText("Preference");
        preferenceMenuItem.setMnemonic('p');
        helpMenu.add(preferenceMenuItem);
        preferenceMenuItem.addActionListener(new ActionListener()
        {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				preferenceButtonActionPerformed(e);
			}
		});
        
        troubleMenuItem.setText("Troubleshoot");
        troubleMenuItem.setMnemonic('t');
        troubleMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				java.net.URI uri;
				try {
					uri = new java.net.URI("http://code.google.com/p/google-document-translator/wiki/Troubleshoot");
					Desktop.getDesktop().browse(uri);
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
				} catch (IOException e2) {
					logger.log(Level.SEVERE, "cannot open browser", e2);
				}
			}
		});
        helpMenu.add(troubleMenuItem);
        
        helpMenuItem.setText("GDT-Help");
        helpMenuItem.setMnemonic('h');
        helpMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				java.net.URI uri;
				try {
					uri = new java.net.URI("http://code.google.com/p/google-document-translator/wiki/UserGuide");
					Desktop.getDesktop().browse(uri);
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
				} catch (IOException e2) {
					logger.log(Level.SEVERE, "cannot open browser", e2);
				}
			}
		});
        helpMenu.add(helpMenuItem);

        aboutMenuItem.setText("About");
        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Component parent = MainJFrame.this;
				AboutBox aboutBox = new AboutBox();
				aboutBox.setBounds(parent.getX()+60, parent.getY()+60, 500, 300);
				aboutBox.setVisible(true);
			}
		});
        helpMenu.add(aboutMenuItem);

        jMenuBar.add(helpMenu);

        setJMenuBar(jMenuBar);
        
        ImageIcon icon = new ImageIcon("resource/img/icon.png");
        Image image = icon.getImage();
//        image.
        setIconImage(image);
        addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowClosing(WindowEvent e) {
        		exitAction(e);
        	}
		});
        pack();
    }


    protected void exitAction(AWTEvent e) {
		// TODO Auto-generated method stub
    	if(!cancelButton.isEnabled())
		{
			preferenceModel.save();
			System.exit(0);
		}
		else
		{
			int returnCode = JOptionPane.showConfirmDialog(getContentPane(),
					"Translation is going on, do you really want to quit ?",
					"Warning", JOptionPane.YES_NO_OPTION);
			if(returnCode==JOptionPane.YES_OPTION)
			{
				preferenceModel.save();
				System.exit(0);
			}
		}
	}

	protected void browseButtonActionPerformed(ActionEvent e) 
    {
    	GdtFileChooser gdtChooser = new GdtFileChooser(new File(preferenceModel.getLastLocation()));
		int ret = gdtChooser.showDialog(getContentPane(), "open");
		File[] selectedFiles = gdtChooser.getSelectedFiles();
		if(ret==gdtChooser.APPROVE_OPTION)
		{
			createGdtJobs(selectedFiles);
		}
		preferenceModel.setLastLocation(gdtChooser.getCurrentDirectory().getAbsolutePath());
	}

	/*
	 * This method will be a common method for filechooser and DnD action, 
	 */
	protected void createGdtJobs(File[] selectedFiles) {
		// TODO Auto-generated method stub
		for(File file : selectedFiles)
		{
			if(!files.contains(file))
			{
				files.add(file);
				translateButton.setEnabled(true);
				ProgressLevel progressLevel = new ProgressLevel(file.getAbsolutePath());
				jpanel.add(progressLevel);
				gdtJobs.add(new GdtJob(file,progressLevel));
				preferenceModel.setRecentFiles(file.getAbsolutePath());
			}
			else
			{
//				log(file is already added)
			}
		}
		if(files.size() * ProgressLevel.HEIGHT >jpanel.getPreferredSize().getHeight()) 
			// if we need to increase the width to accommodate more progress panel
		{
			jpanel.setPreferredSize(new Dimension((int)jpanel.getPreferredSize().getWidth(),
				files.size() * (ProgressLevel.HEIGHT + 6)));
		}
		jpanel.updateUI();
	}
	
	public void removeGdtJobs(File file) {
		for(Iterator<GdtJob> jobiterator=gdtJobs.iterator();jobiterator.hasNext();)
		{
			GdtJob gjob = jobiterator.next();
			if(gjob.getFile().equals(file))
			{
				jobiterator.remove();
				files.remove(file);
			}
		}
		jpanel.setPreferredSize(new Dimension((int)jpanel.getPreferredSize().getWidth(),
				files.size() * (ProgressLevel.HEIGHT + 6)));
		jpanel.updateUI();
	}

	private void translateButtonActionPerformed(ActionEvent e) 
    {
    	if((0==files.size()))
		{
			JOptionPane.showMessageDialog(getContentPane(), "please select a file first", "Input Error", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			new Thread()
			{
				@Override
				public void run() 
				{
					for(GdtJob gdtJob: gdtJobs)
					{
						if(!gdtJob.isAlreadyTriggered)
						{
							gdtJob.start();
							translateButton.setEnabled(false);
							enableInput(false);
						}
					}
					for(GdtJob gdtJob: gdtJobs)
					{
						try 
						{
							gdtJob.join();
						} 
						catch (InterruptedException e) 
						{
							logger.log(Level.SEVERE, "Job join interrupted", e);
						}
					}
					enableInput(true);
				}
			}.start();
					
		}
	}

	protected void enableInput(boolean b) {
		// TODO Auto-generated method stub
		browseButton.setEnabled(b);
		openMenuItem.setEnabled(b);
		cancelButton.setEnabled(!b);
		preferenceMenuItem.setEnabled(b);
		toLabel.setEnabled(b);
		fromLabel.setEnabled(b);
		toComboBox.setEnabled(b);
		fromComboBox.setEnabled(b);
	}

	private void preferenceButtonActionPerformed(ActionEvent e) 
    {
    	PreferenceUI preferenceUI = new PreferenceUI();
		preferenceUI.setResizable(false);
		preferenceUI.setSize(405, 340);
		Container parent = MainJFrame.this;
		preferenceUI.setBounds(parent.getX()+130, parent.getY()+50, 405, 340);
//		preferenceUI.setLocationRelativeTo(parent);
		preferenceUI.setModalityType(ModalityType.APPLICATION_MODAL);
		preferenceUI.setVisible(true);
	}

	public String getFieldString(List<File> files2) 
    {
    	String jtextFieldString ="";
    	for(File file:files2)
    	{
    		jtextFieldString = jtextFieldString+" \""+file.getName()+"\"";
    	}
    	
		return jtextFieldString;
	}

	public JPanel getJpanel() {
		return jpanel;
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
    //GUI variables
    private javax.swing.JButton browseButton;
    private javax.swing.JButton translateButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu recentFileMenu;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem preferenceMenuItem;
    private javax.swing.JMenuItem helpMenuItem;
    private javax.swing.JMenuItem troubleMenuItem;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel fromLabel;
    private javax.swing.JLabel toLabel;
    private FromComboBox fromComboBox;
    private ToComboBox toComboBox;
    private JPanel jpanel ;
    
	//non GUI variables
    private List<File> files = new ArrayList<File>();
	private List<GdtJob> gdtJobs = new ArrayList<GdtJob>();
    private PreferenceModel preferenceModel;
    private TransferHandler transferHandler;
    // End of variables declaration//GEN-END:variables

}

class GdtScrollPane extends JScrollPane
{
	@Override
	public Point getToolTipLocation(MouseEvent event) {
		double xpos = event.getPoint().getX();
		double ypos = event.getPoint().getY();
		return new Point((int)xpos+10, (int)ypos);
	}
}
/*
 * PreferenceUI.java
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

import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Logger;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.KeyStroke;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.ToolTipManager;

import com.google.gdt.main.PreferenceModel;
import com.google.gdt.util.TranslatorType;

/**
 *
 * @author Sanmoy
 */
public class PreferenceUI extends javax.swing.JDialog {

	private static Logger logger = Logger.getLogger("PreferenceUI.class");
	
    /** Creates new form PreferenceUI */
    public PreferenceUI()
    {
    	preferenceModel = PreferenceModel.getInstance();
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() 
    {
    	ImageIcon icon = new ImageIcon("resource/img/preference.png");
        Image image = icon.getImage();
        setIconImage(image);
        
        jPanel1 = new javax.swing.JPanel();
        proxyCheckBox = new javax.swing.JCheckBox();
        urlLabel = new javax.swing.JLabel();
        urlField = new javax.swing.JTextField();
        portLabel = new javax.swing.JLabel();
        apikeylabel = new javax.swing.JLabel();
        portSpinner = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        httpRadioButton = new javax.swing.JRadioButton();
        ajaxRadioButton = new javax.swing.JRadioButton();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        apiKeyField = new JPasswordField();
        
        buttonGroup = new ButtonGroup();
        toolTipManager = ToolTipManager.sharedInstance();
        
        DisposeActionListener diListener = new DisposeActionListener(this);
        int intialPortValue = 0;
        if(null!=preferenceModel.getProxyPort())
        	intialPortValue = preferenceModel.getProxyPort();
        spinnerModel = new SpinnerNumberModel(intialPortValue,0,9999,1);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Proxy Setting"));
        jPanel1.setLayout(null);

        proxyCheckBox.setText("Enable Proxy");
        jPanel1.add(proxyCheckBox);
        if(preferenceModel.isProxyEnable())
        {
        	proxyCheckBox.setSelected(true);
        }
        else
        {
        	urlField.setEnabled(false);
			portSpinner.setEnabled(false);
			urlLabel.setEnabled(false);
			portLabel.setEnabled(false);
        }
        
        proxyCheckBox.setBounds(6, 20, 120, 23);
        proxyCheckBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(proxyCheckBox.isSelected())
				{
					urlField.setEnabled(true);
					portSpinner.setEnabled(true);
					urlLabel.setEnabled(true);
					portLabel.setEnabled(true);
				}
				else
				{
					urlField.setEnabled(false);
					portSpinner.setEnabled(false);
					urlLabel.setEnabled(false);
					portLabel.setEnabled(false);
				}
				okButton.setEnabled(true);
			}
		});

        urlLabel.setText("URL");
        jPanel1.add(urlLabel);
        urlLabel.setBounds(16, 53, 30, 14);

        urlField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        urlField.setText(preferenceModel.getProxyURL());
        urlField.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		if(!okButton.isEnabled())
				{
					okButton.setEnabled(true);
				}
        	}
		});
        jPanel1.add(urlField);
        urlField.setBounds(53, 50, 160, 20);

        portLabel.setText("Port");
        jPanel1.add(portLabel);
        portLabel.setBounds(225, 53, 28, 14);
        jPanel1.add(portSpinner);
        portSpinner.setModel(spinnerModel);
        portSpinner.setEditor(new JSpinner.NumberEditor(portSpinner, "#"));
        JFormattedTextField portTextField = ((DefaultEditor)portSpinner.getEditor()).getTextField();
        portTextField.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		if(Character.isLetter(e.getKeyChar()))
        		{
        			e.consume();
        		}
        		else
        		{
        			okButton.setEnabled(true);
        		}
        	}
		});
        
        portSpinner.setBounds(263, 50, 81, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 20, 360, 110);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Translator Setting"));
        jPanel2.setLayout(null);
        
        buttonGroup.add(httpRadioButton);
        buttonGroup.add(ajaxRadioButton);

        httpRadioButton.setText("HTTP Translator");
        if(preferenceModel.getTranslatorType()==TranslatorType.HTTP)
        {
        	httpRadioButton.setSelected(true);
        	apiKeyField.setEnabled(false);
        }
        toolTipManager.registerComponent(httpRadioButton);
        httpRadioButton.setToolTipText("Slow, less reliable but free. Use for academic purpose only ");
        httpRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				okButton.setEnabled(true);
				apiKeyField.setEnabled(false);
				apikeylabel.setEnabled(false);
			}
		});
        jPanel2.add(httpRadioButton);
        httpRadioButton.setBounds(12, 20, 120, 23);

        ajaxRadioButton.setText("AJAX Translator");
        toolTipManager.registerComponent(ajaxRadioButton);
        if(preferenceModel.getTranslatorType()==TranslatorType.AJAX)
        {
        	ajaxRadioButton.setSelected(true);
        	apiKeyField.setEnabled(true);
        	apikeylabel.setEnabled(true);
        }
        ajaxRadioButton.setToolTipText("Fast, reliable but a paid service");
        ajaxRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				okButton.setEnabled(true);
				apiKeyField.setEnabled(true);
				apikeylabel.setEnabled(true);
			}
		});
        jPanel2.add(ajaxRadioButton);
        ajaxRadioButton.setBounds(12, 46, 120, 23);
        
        apikeylabel.setText("API Key");
        apikeylabel.setBounds(18, 76, 50, 14);
        jPanel2.add(apikeylabel);
        
        apiKeyField.setBounds(70, 76, 280, 20);
        apiKeyField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        apiKeyField.setText(preferenceModel.getApiKey());
        apiKeyField.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		if(!okButton.isEnabled())
				{
					okButton.setEnabled(true);
				}
        	}
		});
        jPanel2.add(apiKeyField);
        
        getContentPane().add(jPanel2);
        jPanel2.setBounds(20, 140, 360, 110);

        okButton.setText("OK");
        okButton.setMnemonic('o');
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        okButton.setEnabled(false);
        getContentPane().add(okButton);
        okButton.setBounds(180, 270, 87, 23);

        cancelButton.setText("Cancel");
        cancelButton.setMnemonic('c');
        cancelButton.addActionListener(diListener);
        getContentPane().add(cancelButton);
        cancelButton.setBounds(290, 270, 87, 23);
        setTitle("Preference");
		this.getRootPane().registerKeyboardAction(diListener,
				KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
				JComponent.WHEN_IN_FOCUSED_WINDOW);
        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void okButtonActionPerformed(java.awt.event.ActionEvent evt)
	{
		String proxyUrl = urlField.getText();
		String proxyPort = portSpinner.getValue().toString();
		String apiKey = new String(apiKeyField.getPassword());
		
		preferenceModel.setProxyURL(proxyUrl);
		preferenceModel.setProxyPort(new Integer(proxyPort));
		preferenceModel.setApiKey(apiKey);
		if(proxyCheckBox.isSelected())
		{
			System.setProperty("http.proxyHost", proxyUrl);
			System.setProperty("http.proxyPort", proxyPort);
			preferenceModel.setProxyEnable(true);
		}
		else
		{
			System.setProperty("http.proxyHost", "");
			System.setProperty("http.proxyPort", "");
			preferenceModel.setProxyEnable(false);
		}
		
		if(ajaxRadioButton.isSelected())
		{
			preferenceModel.setTranslatorType(TranslatorType.AJAX);
		}
		if(httpRadioButton.isSelected())
		{
			preferenceModel.setTranslatorType(TranslatorType.HTTP);
		}
		preferenceModel.save();
		dispose();
	}
	
	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) 
	{
		okButton.setEnabled(true);
	}

    private javax.swing.JButton okButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JCheckBox proxyCheckBox;
    private javax.swing.JLabel urlLabel;
    private javax.swing.JLabel portLabel;
    private javax.swing.JLabel apikeylabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton httpRadioButton;
    private javax.swing.JRadioButton ajaxRadioButton;
    private javax.swing.JSpinner portSpinner;
    private javax.swing.JTextField urlField;
    private ButtonGroup buttonGroup;
    private JPasswordField apiKeyField;
    // End of variables declaration//GEN-END:variables
    
    //non GUI variables
    PreferenceModel preferenceModel;
    SpinnerModel spinnerModel ; 
    ToolTipManager toolTipManager;
}

class DisposeActionListener implements ActionListener {
	
	Window window;
	
	public DisposeActionListener(Window window) {
		this.window = window;
	}
	public void actionPerformed(java.awt.event.ActionEvent evt) {
		window.dispose();
	}
}
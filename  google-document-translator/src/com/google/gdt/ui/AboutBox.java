/*
 * AboutBox.java
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

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 * 
 * @author Sanmoy
 *
 */
public class AboutBox extends javax.swing.JDialog {

	private static Logger logger = Logger.getLogger("AboutBox.class");
	
    public AboutBox() {
        initComponents();
        getRootPane().setDefaultButton(closeButton);
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        closeButton = new javax.swing.JButton();
        javax.swing.JLabel appTitleLabel = new javax.swing.JLabel();
        javax.swing.JLabel versionLabel = new javax.swing.JLabel();
        javax.swing.JLabel appVersionLabel = new javax.swing.JLabel();
        javax.swing.JLabel vendorLabel = new javax.swing.JLabel();
        javax.swing.JLabel appVendorLabel = new javax.swing.JLabel();
        javax.swing.JLabel homepageLabel = new javax.swing.JLabel();
        javax.swing.JLabel appHomepageLabel = new javax.swing.JLabel();
        javax.swing.JLabel appDescLabel = new javax.swing.JLabel();
        javax.swing.JLabel imageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About"); // NOI18N
        setModalityType(ModalityType.APPLICATION_MODAL);
        setName("aboutBox"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(null);

        closeButton.setName("closeButton"); // NOI18N
        closeButton.setText("Close");
        getContentPane().add(closeButton);
        closeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AboutBox.this.dispose();
			}
		});
        closeButton.setMnemonic('c');
        closeButton.setBounds(372, 230, 80, 23);

        appTitleLabel.setFont(appTitleLabel.getFont().deriveFont(appTitleLabel.getFont().getStyle() | java.awt.Font.BOLD, appTitleLabel.getFont().getSize()+6));
        appTitleLabel.setText("Google Document Translator"); // NOI18N
        appTitleLabel.setName("appTitleLabel"); // NOI18N
        getContentPane().add(appTitleLabel);
        appTitleLabel.setBounds(165, 11, 270, 25);

        versionLabel.setFont(versionLabel.getFont().deriveFont(versionLabel.getFont().getStyle() | java.awt.Font.BOLD));
        versionLabel.setText("Version"); // NOI18N
        versionLabel.setName("versionLabel"); // NOI18N
        getContentPane().add(versionLabel);
        versionLabel.setBounds(165, 135, 92, 14);

        appVersionLabel.setText("V1R5"); // NOI18N
        appVersionLabel.setName("appVersionLabel"); // NOI18N
        getContentPane().add(appVersionLabel);
        appVersionLabel.setBounds(263, 135, 36, 14);

        vendorLabel.setFont(vendorLabel.getFont().deriveFont(vendorLabel.getFont().getStyle() | java.awt.Font.BOLD));
        vendorLabel.setText("vendor"); // NOI18N
        vendorLabel.setName("vendorLabel"); // NOI18N
        getContentPane().add(vendorLabel);
        vendorLabel.setBounds(165, 155, 43, 14);

        appVendorLabel.setText("Sanmoy Ray"); // NOI18N
        appVendorLabel.setName("appVendorLabel"); // NOI18N
        getContentPane().add(appVendorLabel);
        appVendorLabel.setBounds(263, 155, 120, 14);

        homepageLabel.setFont(homepageLabel.getFont().deriveFont(homepageLabel.getFont().getStyle() | java.awt.Font.BOLD));
        homepageLabel.setText("homepage"); // NOI18N
        homepageLabel.setName("homepageLabel"); // NOI18N
        getContentPane().add(homepageLabel);
        homepageLabel.setBounds(165, 175, 64, 14);
        
//        appHomepageLabel.setFont
        appHomepageLabel.setText("<html><p>http://code.google.com/p/</p>" +
        		"<p>google-document-translator/</p></html>"); // NOI18N
        appHomepageLabel.setName("appHomepageLabel"); // NOI18N
        getContentPane().add(appHomepageLabel);
        appHomepageLabel.setBounds(263, 175, 172, 34);

		appDescLabel
				.setText("<html>Google Document Translator is not a product from Google. " +
						"Neither it is endorsed nor it is supported by Google. This is an " +
						"open source product, distributed WITHOUT ANY WARRANTY</html>"); // NOI18N
        appDescLabel.setName("appDescLabel"); // NOI18N
        getContentPane().add(appDescLabel);
        appDescLabel.setBounds(165, 36, 300, 80);

        ImageIcon icon = new ImageIcon("resource/img/About.png");
        imageLabel.setIcon(icon); // NOI18N
        imageLabel.setName("imageLabel"); // NOI18N
        getContentPane().add(imageLabel);
        imageLabel.setBounds(0, 0, 130, 177);
        
        DisposeActionListener diListener = new DisposeActionListener(this);
        this.getRootPane().registerKeyboardAction(diListener,
				KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
				JComponent.WHEN_IN_FOCUSED_WINDOW);
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    // End of variables declaration//GEN-END:variables
    
}
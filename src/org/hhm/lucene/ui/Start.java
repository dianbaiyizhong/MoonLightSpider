package org.hhm.lucene.ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Start extends JFrame {
	private JTextField textField;

	public Start() {
		getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(10, 10, 311, 21);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(331, 9, 93, 23);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(0, 284, 434, 40);
		getContentPane().add(btnNewButton_1);
	}

	public static void main(String[] args) {

		Start start = new Start();
		start.setVisible(true);

	}
}

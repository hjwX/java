package com.yuu.test;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SwingHelloWorld {
	public static void createAndShowGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("hello_world_swing!");
		frame.setSize(500, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jPanel = new JPanel();
		JButton button = new JButton("button");
		button.setBounds(0, 0, 100, 20);
		frame.add(jPanel);
		JLabel label = new JLabel("hello world!");
		label.setBounds(0, 20, 100, 20);
		jPanel.add(label);
		jPanel.add(button);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
//				JFrame frame = new SimpleImageShow("D:\\python\\python_repository\\original_images\\20191013\\77192617.png");
				JFrame frame = new ImageViewerFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class ImageViewerFrame extends JFrame {
	private static final long serialVersionUID = -8513902440436284045L;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 400;
	private JLabel label;
	private JFileChooser chooser;

	public ImageViewerFrame() {
		super("ImageViewer");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		label = new JLabel();
		add(label);
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		FileFilter filter = new FileNameExtensionFilter("", "jpg", "png");
		chooser.setFileFilter(filter);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		JMenuItem openItem = new JMenuItem("Open");
		menu.add(openItem);
		JMenuItem exitItem = new JMenuItem("Close");
		menu.add(exitItem);

		openItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = chooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					String name = chooser.getSelectedFile().getPath();
					ImageIcon image = new ImageIcon(name);
					setSize(image.getIconWidth(), image.getIconHeight());
					label.setIcon(image);
				}
			}
		});

		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}
}

class SimpleImageShow extends JFrame{
	private static final long serialVersionUID = 2630089572667953599L;
	
	public SimpleImageShow(String image_path) {
		super("image");
		ImageIcon image = new ImageIcon(image_path);
		setSize(image.getIconWidth(), image.getIconHeight());
		JLabel label = new JLabel();
		add(label);
		label.setIcon(image);
	}
}
































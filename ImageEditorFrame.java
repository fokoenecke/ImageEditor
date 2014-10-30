import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class ImageEditorFrame extends JFrame{
	public ImageEditorFrame(){
		createMenuBar();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
		setTitle("Hardcore Titel");
panel = new ImageEditorPanel();
add(panel);		
	}
	

	private void setDummyImage(){
BufferedImage bufferedImage =
new BufferedImage(400, 300, BufferedImage.TYPE_INT_RGB);
Graphics g = bufferedImage.getGraphics();
g.setColor(Color.YELLOW);
g.fillOval(10, 10, 380, 280);
panel.setImage(bufferedImage);
}

	private void createMenuBar(){ 
	 	JMenuBar menuBar = new JMenuBar();
	 	setJMenuBar(menuBar);
	 	JMenu menuFile = new JMenu("File");
	 	menuBar.add(menuFile);
	 	JMenuItem menuItemOpen = new JMenuItem("Open");
	 	menuFile.add(menuItemOpen);
	 	menuItemOpen.addActionListener(
	 	
		 new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
			 	onOpen();
			 	}
			 }
		 );
	}

	private void onOpen(){
		try{
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.showOpenDialog(this);
			File file = fileChooser.getSelectedFile();
			BufferedImage image = ImageIO.read(file);
			panel.setImage(image);
		}
		catch(IOException e){
			JOptionPane.showMessageDialog(this, 
			"Die Datei konnte nicht geöffnet werden");
		}
	}

}

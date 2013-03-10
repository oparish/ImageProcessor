import java.awt.image.*;
import javax.swing.ImageIcon;
import javax.imageio.*;
import java.io.*;
import java.awt.Color;


public class Main {
	private BufferedImage backimg;
	private BufferedImage frontimg;
	private String fileroot = "Fences";
	private String prefix = "G";
	private String background = "green";
	private String format = "png";
	private int number =15;
	
	Main()
	{	
        try
        {	
        	backimg = ImageIO.read(new File(background+"."+format));
        	for (int k=0;k<number;k++)
        	{
            	frontimg = ImageIO.read(new File(fileroot+Integer.toString(k+1)+"."+format));
        		for (int i=0;i<40;i++)
        		{
        			for (int j=0;j<40;j++)
        			{
        				if (frontimg.getRGB(i,j)==-1)
        				{
        					frontimg.setRGB(i, j, backimg.getRGB(i,j));
        				}
        			}
        		}
                ImageIO.write(frontimg, format, new File(prefix+fileroot+Integer.toString(k+1)+"."+format));
        	}
        }
        catch (IOException ex)
        {
        }
	}
	
	public static void main(String args[])
	{
		new Main();
	}
}

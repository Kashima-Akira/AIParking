/**
 * Created by ♕ Prince on 2018/8/8.
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class ImageTest
{
    @Test
    public  void testImage() throws IOException
    {
        //图片地址
        String path="E:\\1.jpg";
        File dir=new File(path);

        int[] rgb=new int[3];

        BufferedImage bImage=null;
        bImage=ImageIO.read(dir);

        int width=bImage.getWidth();
        int height=bImage.getHeight();
        int minx=bImage.getMinTileX();
        int miny=bImage.getMinTileY();
        System.out.println("Handling"+dir.getName());
        //换色
        int rgbColor=0x330000;
        for(int i=minx;i<width;i++)
        {
            for(int j=miny;j<height;j++)
            {
                int pen=bImage.getRGB(i,j);
                rgb[0]=(pen & 0xff0000)>>16;
                rgb[1]=(pen & 0xff00)>>8;
                rgb[2]=(pen & 0xff);

                if(rgb[0]<230&&rgb[0]>100&&rgb[1]<270&&rgb[1]>100&&rgb[2]<350&&rgb[2]>00)
                {
                       bImage.setRGB(i, j,rgbColor);

                }

            }
        }
        System.out.println("\t处理完毕"+dir.getName());

        FileOutputStream ops;

        try {
            ops=new FileOutputStream(new File("E:\\2.jpg"));
            ImageIO.write(bImage, "jpg", ops);
            //ops.flush();
            ops.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}


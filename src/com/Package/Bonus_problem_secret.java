package com.Package;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bonus_problem_secret {

    public void run() throws IOException {

        BufferedImage img = ImageIO.read(new File("C:\\Users\\meirk\\ProjectEuler\\src\\com\\Package\\bonus_secret_image.png"));
        int width = img.getWidth();
        int height = img.getHeight();
        //System.out.println("Width: " + width + ", Height: " + height);

        int[][][] M = new int[width][height][3];
        int[][][] temp = new int[width][height][3];
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                int rgb = img.getRGB(x, y);
                //int alpha = (rgb >> 24) & 0xff;
                int red = (rgb >> 16) & 0xff;
                int green = (rgb >> 8) & 0xff;
                int blue = rgb & 0xff;
                M[x][y][0] = red;
                M[x][y][1] = green;
                M[x][y][2] = blue;
            }
        }
        for(int c = 0; c < 1; c++){
            for(int x = 0; x < width; x++){
                for(int y = 0; y < height; y++){
                    if (x == 0){
                        temp[x][y][0] += M[width-1][y][0];
                        temp[x][y][1] += M[width-1][y][1];
                        temp[x][y][2] += M[width-1][y][2];
                    }else{
                        temp[x][y][0] += M[x-1][y][0];
                        temp[x][y][1] += M[x-1][y][1];
                        temp[x][y][2] += M[x-1][y][2];
                    }
                    if (x==width-1){
                        temp[x][y][0] += M[0][y][0];
                        temp[x][y][1] += M[0][y][1];
                        temp[x][y][2] += M[0][y][2];

                    }else{
                        temp[x][y][0] += M[x+1][y][0];
                        temp[x][y][1] += M[x+1][y][1];
                        temp[x][y][2] += M[x+1][y][2];
                    }

                    if (y == 0){
                        temp[x][y][0] += M[x][height-1][0];
                        temp[x][y][1] += M[x][height-1][1];
                        temp[x][y][2] += M[x][height-1][2];

                    }else{
                        temp[x][y][0] += M[x][y-1][0];
                        temp[x][y][1] += M[x][y-1][1];
                        temp[x][y][2] += M[x][y-1][2];

                    }
                    if (y==height-1){
                        temp[x][y][0] += M[x][0][0];
                        temp[x][y][1] += M[x][0][1];
                        temp[x][y][2] += M[x][0][2];
                    }else{
                        temp[x][y][0] += M[x][y+1][0];
                        temp[x][y][1] += M[x][y+1][1];
                        temp[x][y][2] += M[x][y+1][2];
                    }
                }
            }

            for(int x = 0; x < width; x++){
                for(int y = 0; y < height; y++){
                    M[x][y][0] = temp[x][y][0] % 7;
                    M[x][y][1] = temp[x][y][1] % 7;
                    M[x][y][2] = temp[x][y][2] % 7;

                    int newRGB = (255 << 24) | (M[x][y][0] << 16) | (M[x][y][1] << 8) | M[x][y][2];
                    img.setRGB(x, y, newRGB);

                }
                //ImageIO.write(img, "png", new File("C:\\Users\\meirk\\ProjectEuler\\src\\com\\Package\\secret_output_image.png"));

            }
            System.out.println("lap " + c);
        }
        ImageIO.write(img, "png", new File("C:\\Users\\meirk\\ProjectEuler\\src\\com\\Package\\secret_output_image.png"));
    }
}

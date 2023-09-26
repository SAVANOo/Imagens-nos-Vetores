package desenhoframe;

import java.awt.*;
import javax.swing.*;

public class DesenhoFrame extends JFrame implements Runnable{
    Thread t;
    int a = 0, x = 10; boolean exe = true;
    Image [] imagem = new Image[10];
    ImageIcon [] img = new ImageIcon[10];

    public DesenhoFrame() {
        for(int i=0; i<=9; i++){
            img[i] = new ImageIcon("C:\\Users\\User\\Desktop\\Geral\\Estudos Sávio\\Ciencia da Computação\\POO\\Imagens\\Imagens nos vetores\\src\\imagens\\"+i+".png");
            imagem[i] = img[i].getImage();
        }

        t = new Thread(this);

        setSize(1280, 720);
        setVisible(true);

        showNotify();
    }

    public void showNotify(){ // inicia Thread
        exe = true;
        t.start();
    }

    public void hideNotify(){ // finaliza Thread
        exe = false;
        t = null;
    }



    public void paint(Graphics g){

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.drawImage(imagem[a], x+=30, 100, this);


    }

    public static void main(String[] args) {
        DesenhoFrame df = new DesenhoFrame();
        df.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void run() {
        while(exe){
            a++;
            try{
                Thread.sleep(100);
            } catch (Exception ex) {}
            repaint();
            if (a>=9) {
                a = 0;
            }
            if (x > 1000) {
                x = 0;
            }

        }
    }
}
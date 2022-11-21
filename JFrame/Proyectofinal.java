import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Proyectofinal extends JFrame{
        //Tipo de layout de contenedor
        FlowLayout flow = new FlowLayout(FlowLayout.CENTER);

        JMenuBar menuBar;

        //Menu de archivo 
        JMenu menuArch;
        JMenuItem archAbrir ,archOriginal ,archGuardarComo ,archGuardar ,archSalir;

        // Menu de pre-procesamiento
        JMenu menuPrepro, preproPotencia;
        JMenuItem preproNeg, preproGris, potenciaAbrillantar, potenciaOscurecer, preproBin;

        // Menu de Bordes
        JMenu menuBordes;
        JMenuItem bordesLaplace, bordesLaplace2, bordesSobel, bordesPrewitt, bordesRoberts;

        //Imagen
        JLabel lab;
        String NombreImagen, NombreImagenOriginal;

        //Menu filtros
        JMenu menuFiltros, menuPasoAltas, menuPasoBajas, menuTemperatura;
        JMenuItem pasoBajasAverage, pasoBajaslp3, pasoBajasGauss, pasoAltashp1, pasoAltashp2, pasoAltashp3, filtrosIsraels, tempReducir, tempAumentar; 

        JFileChooser chooser;


        public Proyectofinal() {
            //dar titulo al frame
            super("Proyecto imágenes");
            
            try{
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }catch(Exception err){
                System.out.println("Error");
            }

            chooser = new JFileChooser();
    
            //Establecer layout
            setLayout(flow);
    
            //inicializar componentes
            menuBar= new JMenuBar();

            menuArch= new JMenu("Archivo");
            archAbrir= new JMenuItem("Abrir");
            archOriginal= new JMenuItem("Original");
            archGuardarComo= new JMenuItem("Guardar Como");
            archGuardar= new JMenuItem("Guardar");
            archSalir= new JMenuItem("Salir");


            menuPrepro= new JMenu("Preprocesamiento");
            preproPotencia= new JMenu("Potencia");
            preproNeg= new JMenuItem("Negativo");
            preproGris= new JMenuItem("Grises");
            potenciaAbrillantar= new JMenuItem("Abrillantar");
            potenciaOscurecer= new JMenuItem("Oscurecer");
            preproBin= new JMenuItem("Binarización");

            menuBordes= new JMenu("Detección de bordes");
            bordesLaplace= new JMenuItem("Laplace");
            bordesLaplace2= new JMenuItem("Laplace 2");
            bordesSobel= new JMenuItem("Sobel");
            bordesPrewitt= new JMenuItem("Prewitt");
            bordesRoberts= new JMenuItem("Roberts");

            menuFiltros= new JMenu("Filtros");
            menuPasoAltas= new JMenu("Paso Altas");
            menuPasoBajas= new JMenu("Paso Bajas");
            menuTemperatura= new JMenu("Temperatura");
            pasoBajasAverage=new JMenuItem("Promedio");
            pasoBajaslp3= new JMenuItem("LP 3");
            pasoBajasGauss= new JMenuItem("Gauss");
            pasoAltashp1= new JMenuItem("HP 1");
            pasoAltashp2= new JMenuItem("HP 2");
            pasoAltashp3= new JMenuItem("HP 3");
            filtrosIsraels= new JMenuItem("Israel's");
            tempAumentar= new JMenuItem("Aumentar");
            tempReducir= new JMenuItem("Reducir");
            

            lab= new JLabel();

            //Establecer sus propiedades
    
            //Añadir los componentes
            setJMenuBar(menuBar);

            menuBar.add(menuArch);
            menuBar.add(menuPrepro);
            menuBar.add(menuBordes);
            menuBar.add(menuFiltros);


            menuArch.add(archAbrir);
            menuArch.add(archOriginal);
            menuArch.add(archGuardarComo);
            menuArch.add(archGuardar);
            menuArch.add(archSalir);

            menuPrepro.add(preproNeg);
            menuPrepro.add(preproGris);
            menuPrepro.add(preproPotencia);
            preproPotencia.add(potenciaAbrillantar);
            preproPotencia.add(potenciaOscurecer);
            menuPrepro.add(preproBin);

            menuBordes.add(bordesLaplace);
            menuBordes.add(bordesLaplace2);
            menuBordes.add(bordesSobel);
            menuBordes.add(bordesPrewitt);
            menuBordes.add(bordesRoberts);

            menuFiltros.add(menuPasoAltas);
            menuFiltros.add(menuPasoBajas);
            menuFiltros.add(menuTemperatura);
            menuFiltros.add(filtrosIsraels);
            menuPasoBajas.add(pasoBajasAverage);
            menuPasoBajas.add(pasoBajaslp3);
            menuPasoBajas.add(pasoBajasGauss);
            menuPasoAltas.add(pasoAltashp1);
            menuPasoAltas.add(pasoAltashp2);
            menuPasoAltas.add(pasoAltashp3);
            menuTemperatura.add(tempAumentar);
            menuTemperatura.add(tempReducir);

            add(lab);
    
            // Añadir event handler
            EventHandler eh = new EventHandler( );
            archAbrir.addActionListener(eh);
            archSalir.addActionListener(eh);
            archGuardar.addActionListener(eh);
            archGuardarComo.addActionListener(eh);
            archOriginal.addActionListener(eh);

            preproNeg.addActionListener(eh);
            preproBin.addActionListener(eh);
            preproGris.addActionListener(eh);  
            
            potenciaAbrillantar.addActionListener(eh);
            potenciaOscurecer.addActionListener(eh);

            bordesLaplace.addActionListener(eh);
            bordesLaplace2.addActionListener(eh);
            bordesSobel.addActionListener(eh);
            bordesPrewitt.addActionListener(eh);
            bordesRoberts.addActionListener(eh);

            pasoAltashp1.addActionListener(eh);
            pasoAltashp2.addActionListener(eh);
            pasoAltashp3.addActionListener(eh);
            pasoBajasAverage.addActionListener(eh);
            pasoBajaslp3.addActionListener(eh);
            filtrosIsraels.addActionListener(eh);
            tempAumentar.addActionListener(eh);
            tempReducir.addActionListener(eh);
            pasoBajasGauss.addActionListener(eh);

            //Hacer visible el contenedor y establecer el tamaño
            setVisible(true);
            setSize(1000, 500);
            
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent event) {
                    Salir();
                }
            });
        }
    
        //------------------Event handler------------------
        private class EventHandler implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==archAbrir){
                    NombreImagen= Abrir();
                    lab.setIcon(new ImageIcon(NombreImagen));
                }
                else if(e.getSource()==archSalir){
                    Salir();
                }
                else if(e.getSource()==archGuardar){
                    Guardar();
                }
                else if(e.getSource()==archGuardarComo){
                    GuardarComo();
                }
                else if(e.getSource()==archOriginal){
                    Original();
                }
                else if(e.getSource()==preproNeg){
                    Invertir(NombreImagen);
                }
                else if(e.getSource()==preproBin){
                    Binarizacion(NombreImagen);
                }
                else if(e.getSource()==preproGris){
                    Grises(NombreImagen);
                }
                else if(e.getSource()==potenciaAbrillantar){
                    Abrillantar(NombreImagen);
                }
                else if(e.getSource()==potenciaOscurecer){
                    Oscurecer(NombreImagen);
                }
                else if(e.getSource()==bordesLaplace){
                    int Kernel[][] = {
                        { 0, -1, 0 },
                        { -1, 4, -1 },
                        { 0, -1, 0 }
                    };
                    BordesLaplace(NombreImagen, Kernel);
                }
                else if(e.getSource()==bordesLaplace2){
                    int Kernel[][] = {
                        { -1, -1, -1 },
                        { -1, 8, -1 },
                        { -1, -1, -1 }
                    };
                    BordesLaplace(NombreImagen, Kernel);
                }
                else if(e.getSource()==bordesSobel){
                    int K1[][] = {
                        { -1, 0, 1 },
                        { -2, 0, 2 },
                        { -1, 0, 1 }
                    };
                    int K2[][] = {
                        { 1, 2, 1 },
                        { 0, 0, 0 },
                        { -1, -2, -1 }
                    };
                    BordesPrewittSobel(NombreImagen, K1, K2);
                }
                else if(e.getSource()==bordesPrewitt){
                    int K1[][] = {
                        { 1, 0, -1 },
                        { 1, 0, -1 },
                        { 1, 0, -1 }
                    };
                    int K2[][] = {
                        { -1, -1, -1 },
                        { 0, 0, 0 },
                        { 1, 1, 1 }
                    };
                    BordesPrewittSobel(NombreImagen, K1, K2);
                }
                else if(e.getSource()==bordesRoberts){
                    BordesRoberts(NombreImagen);
                }
                else if(e.getSource()==pasoBajasAverage){
                    int Kernel[][]={
                        {1,1,1},
                        {1,1,1},
                        {1,1,1}
                    };
                    PasoALtasBajas(NombreImagen, Kernel, 9);
                }
                else if(e.getSource()==pasoBajaslp3){
                    int Kernel[][]={
                        {1,1,1},
                        {1,12,1},
                        {1,1,1}
                    };
                    PasoALtasBajas(NombreImagen, Kernel, 20);
                }
                else if(e.getSource()==pasoBajasGauss){
                    int Kernel[][]={
                        {1, 2, 1},
                        {2, 4, 2},
                        {1, 2, 1}
                    };
                    PasoALtasBajas(NombreImagen, Kernel, 16);
                }
                else if(e.getSource()==pasoAltashp1){
                    int Kernel[][]={
                        {0,-1,0},
                        {-1,10,-1},
                        {0,-1,0}
                    };
                    PasoALtasBajas(NombreImagen, Kernel, 1);
                }
                else if(e.getSource()==pasoAltashp2){
                    int Kernel[][]={
                        {0,-1,0},
                        {-1,8,-1},
                        {0,-1,0}
                    };
                    PasoALtasBajas(NombreImagen, Kernel, 1);
                }
                else if(e.getSource()==pasoAltashp3){
                    int Kernel[][]={
                        {0,-1,0},
                        {-1,5,-1},
                        {0,-1,0}
                    };
                    PasoALtasBajas(NombreImagen, Kernel, 1);
                }
                else if(e.getSource()==tempReducir){
                    CambiarTemp(NombreImagen, 0.9, 1.1);
                }
                else if(e.getSource()==tempAumentar){
                    CambiarTemp(NombreImagen, 1.1, 0.9);
                }
                else if(e.getSource()==filtrosIsraels){
                    Israels(NombreImagen);
                }
            }
        }

        //------------------Prepro------------------

        public void Invertir(String imageName){

            BufferedImage inputFile = null;
            try {
                inputFile = ImageIO.read(new File(imageName));
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (int x = 0; x < inputFile.getWidth(); x++) {
                for (int y = 0; y < inputFile.getHeight(); y++) {
                    int rgba = inputFile.getRGB(x, y);
                    Color col = new Color(rgba, true);
                    col = new Color(255 - col.getRed(),
                                    255 - col.getGreen(),
                                    255 - col.getBlue());
                    inputFile.setRGB(x, y, col.getRGB());
                }
            }
            lab.setIcon(new ImageIcon(inputFile));

            try {
                File outputFile= new File(imageName);
                ImageIO.write(inputFile, "jpg", outputFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void Binarizacion(String imageName){
            BufferedImage inputFile = null;
            try {
                inputFile = ImageIO.read(new File(imageName));
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (int x = 0; x < inputFile.getWidth(); x++) {
                for (int y = 0; y < inputFile.getHeight(); y++) {
                    int rgba = inputFile.getRGB(x, y);
                    Color col = new Color(rgba, true);

                    if((col.getRed()+col.getBlue()+col.getGreen())/3>128)
                        col = new Color(255,255,255);
                    else
                        col = new Color(0,0,0);
                    inputFile.setRGB(x, y, col.getRGB());
                }
            }
            lab.setIcon(new ImageIcon(inputFile));

            try {
                File outputFile= new File(imageName);
                ImageIO.write(inputFile, "jpg", outputFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void Grises(String imageName){
            BufferedImage inputFile = null;
            try {
                inputFile = ImageIO.read(new File(imageName));
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (int x = 0; x < inputFile.getWidth(); x++) {
                for (int y = 0; y < inputFile.getHeight(); y++) {
                    int rgba = inputFile.getRGB(x, y);
                    Color col = new Color(rgba, true);

                    int num= (col.getRed()+col.getBlue()+col.getGreen())/3;
                    col= new Color(num, num, num);
                    inputFile.setRGB(x, y, col.getRGB());
                }
            }
            lab.setIcon(new ImageIcon(inputFile));

            try {
                File outputFile= new File(imageName);
                ImageIO.write(inputFile, "jpg", outputFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void Potencia(String imageName, double pot){
            BufferedImage inputFile = null;
            try {
                inputFile = ImageIO.read(new File(imageName));
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (int x = 0; x < inputFile.getWidth(); x++) {
                for (int y = 0; y < inputFile.getHeight(); y++) {
                    int rgba = inputFile.getRGB(x, y);
                    Color col = new Color(rgba, true);
                    double red, green, blue;

                    red=255.0*(Math.pow(col.getRed()/255.0, pot));
                    green=255.0*(Math.pow(col.getGreen()/255.0, pot));
                    blue=255.0*(Math.pow(col.getBlue()/255.0, pot));

                    col= new Color((int)red, (int)green, (int)blue);
                    inputFile.setRGB(x, y, col.getRGB());
                }
            }
            lab.setIcon(new ImageIcon(inputFile));

            try {
                File outputFile= new File(imageName);
                ImageIO.write(inputFile, "jpg", outputFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void Abrillantar(String imageName){
            Potencia(imageName, 0.7);
        }

        public void Oscurecer(String imageName){
            Potencia(imageName, 1.3);
        }

        //------------------Deteccion de bordes-----------------

        public void BordesLaplace(String imageName, int Kernel[][]) {
            BufferedImage inputFile = null;
            try {
                inputFile = ImageIO.read(new File(imageName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            int x = inputFile.getWidth();
            int y = inputFile.getHeight();
            BufferedImage ImgLaplaz = new BufferedImage(x, y, BufferedImage.TYPE_BYTE_GRAY);

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    int x1 = i - 1 < 0 ? x - 1 : i - 1;
                    int x3 = i + 1 >= x ? 0 : i + 1;
                    int y1 = j - 1 < 0 ? y - 1 : j - 1;
                    int y3 = j + 1 >= y ? 0 : j + 1;
                    
                    int r1 = new Color(inputFile.getRGB(x1, y1)).getRed() * Kernel[0][0];
                    int r2 = new Color(inputFile.getRGB(i, y1)).getRed() * Kernel[0][1];
                    int r3 = new Color(inputFile.getRGB(x3, y1)).getRed() * Kernel[0][2];
                    int r4 = new Color(inputFile.getRGB(x1, j)).getRed() * Kernel[1][0];
                    int r5 = new Color(inputFile.getRGB(i, j)).getRed() * Kernel[1][1];
                    int r6 = new Color(inputFile.getRGB(x3, j)).getRed() * Kernel[1][2];
                    int r7 = new Color(inputFile.getRGB(x1, y3)).getRed() * Kernel[2][0];
                    int r8 = new Color(inputFile.getRGB(i, y3)).getRed() * Kernel[2][1];
                    int r9 = new Color(inputFile.getRGB(x3, y3)).getRed() * Kernel[2][2];

                    int g1 = new Color(inputFile.getRGB(x1, y1)).getGreen() * Kernel[0][0];
                    int g2 = new Color(inputFile.getRGB(i, y1)).getGreen() * Kernel[0][1];
                    int g3 = new Color(inputFile.getRGB(x3, y1)).getGreen() * Kernel[0][2];
                    int g4 = new Color(inputFile.getRGB(x1, j)).getGreen() * Kernel[1][0];
                    int g5 = new Color(inputFile.getRGB(i, j)).getGreen() * Kernel[1][1];
                    int g6 = new Color(inputFile.getRGB(x3, j)).getGreen() * Kernel[1][2];
                    int g7 = new Color(inputFile.getRGB(x1, y3)).getGreen() * Kernel[2][0];
                    int g8 = new Color(inputFile.getRGB(i, y3)).getGreen() * Kernel[2][1];
                    int g9 = new Color(inputFile.getRGB(x3, y3)).getGreen() * Kernel[2][2];

                    int b1 = new Color(inputFile.getRGB(x1, y1)).getBlue() * Kernel[0][0];
                    int b2 = new Color(inputFile.getRGB(i, y1)).getBlue() * Kernel[0][1];
                    int b3 = new Color(inputFile.getRGB(x3, y1)).getBlue() * Kernel[0][2];
                    int b4 = new Color(inputFile.getRGB(x1, j)).getBlue() * Kernel[1][0];
                    int b5 = new Color(inputFile.getRGB(i, j)).getBlue() * Kernel[1][1];
                    int b6 = new Color(inputFile.getRGB(x3, j)).getBlue() * Kernel[1][2];
                    int b7 = new Color(inputFile.getRGB(x1, y3)).getBlue() * Kernel[2][0];
                    int b8 = new Color(inputFile.getRGB(i, y3)).getBlue() * Kernel[2][1];
                    int b9 = new Color(inputFile.getRGB(x3, y3)).getBlue() * Kernel[2][2];

                    int RRES = r1 + r2 + r3 + r4 + r5 + r6 + r7 + r8 + r9;
                    RRES= RRES>255?255:RRES<0?0:RRES;
                    int GRES = g1 + g2 + g3 + g4 + g5 + g6 + g7 + g8 + g9;
                    GRES= GRES>255?255:GRES<0?0:GRES;
                    int BRES = b1 + b2 + b3 + b4 + b5 + b6 + b7 + b8 + b9;
                    BRES= BRES>255?255:BRES<0?0:BRES;

                    Color RGBRES= new Color(RRES, GRES, BRES);

                    ImgLaplaz.setRGB(i, j, RGBRES.getRGB());
                }
            }

            lab.setIcon(new ImageIcon(ImgLaplaz));

            try {
                File outputFile= new File(imageName);
                ImageIO.write(ImgLaplaz, "jpg", outputFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void BordesPrewittSobel(String imageName, int K1[][], int K2[][]){
            BufferedImage inputFile = null;
            try {
                inputFile = ImageIO.read(new File(imageName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            int x = inputFile.getWidth();
            int y = inputFile.getHeight();
            BufferedImage ImgLaplaz = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);

            //To red
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    int col= inputFile.getRGB(i, j);
                    Color rgb= new Color(col);

                    int red= rgb.getRed();
                    int blue= rgb.getBlue();
                    int green= rgb.getGreen();

                    red=(red+blue+green)/3;
                    
                    rgb= new Color(red, green, blue);
                    ImgLaplaz.setRGB(i, j, rgb.getRGB());
                }
            }

            //Convoluciones
            // g = convolve(r,k1);
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    int x1 = i - 1 < 0 ? x - 1 : i - 1;
                    int x3 = i + 1 >= x ? 0 : i + 1;
                    int y1 = j - 1 < 0 ? y - 1 : j - 1;
                    int y3 = j + 1 >= y ? 0 : j + 1;

                    int g1 = new Color(ImgLaplaz.getRGB(x1, y1)).getRed() * K1[0][0];
                    int g2 = new Color(ImgLaplaz.getRGB(i, y1)).getRed() * K1[0][1];
                    int g3 = new Color(ImgLaplaz.getRGB(x3, y1)).getRed() * K1[0][2];
                    int g4 = new Color(ImgLaplaz.getRGB(x1, j)).getRed() * K1[1][0];
                    int g5 = new Color(ImgLaplaz.getRGB(i, j)).getRed() * K1[1][1];
                    int g6 = new Color(ImgLaplaz.getRGB(x3, j)).getRed() * K1[1][2];
                    int g7 = new Color(ImgLaplaz.getRGB(x1, y3)).getRed() * K1[2][0];
                    int g8 = new Color(ImgLaplaz.getRGB(i, y3)).getRed() * K1[2][1];
                    int g9 = new Color(ImgLaplaz.getRGB(x3, y3)).getRed() * K1[2][2];

                    int GRES = g1+g2+g3+g4+g5+g6+g7+g8+g9;
                    GRES= GRES>255?255:GRES<0?0:GRES;

                    int col= ImgLaplaz.getRGB(i, j);
                    Color rgb= new Color(col);
                    rgb= new Color(rgb.getRed(), GRES, rgb.getBlue());
                    ImgLaplaz.setRGB(i, j, rgb.getRGB());
                }
            }

            // b = convolve(r,k2);
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    int x1 = i - 1 < 0 ? x - 1 : i - 1;
                    int x3 = i + 1 >= x ? 0 : i + 1;
                    int y1 = j - 1 < 0 ? y - 1 : j - 1;
                    int y3 = j + 1 >= y ? 0 : j + 1;

                    int b1 = new Color(ImgLaplaz.getRGB(x1, y1)).getRed() * K2[0][0];
                    int b2 = new Color(ImgLaplaz.getRGB(i, y1)).getRed() * K2[0][1];
                    int b3 = new Color(ImgLaplaz.getRGB(x3, y1)).getRed() * K2[0][2];
                    int b4 = new Color(ImgLaplaz.getRGB(x1, j)).getRed() * K2[1][0];
                    int b5 = new Color(ImgLaplaz.getRGB(i, j)).getRed() * K2[1][1];
                    int b6 = new Color(ImgLaplaz.getRGB(x3, j)).getRed() * K2[1][2];
                    int b7 = new Color(ImgLaplaz.getRGB(x1, y3)).getRed() * K2[2][0];
                    int b8 = new Color(ImgLaplaz.getRGB(i, y3)).getRed() * K2[2][1];
                    int b9 = new Color(ImgLaplaz.getRGB(x3, y3)).getRed() * K2[2][2];

                    int BRES = b1+b2+b3+b4+b5+b6+b7+b8+b9;
                    BRES= BRES>255?255:BRES<0?0:BRES;

                    int col= ImgLaplaz.getRGB(i, j);
                    Color rgb= new Color(col);
                    rgb= new Color(rgb.getRed(), rgb.getGreen(), BRES);
                    ImgLaplaz.setRGB(i, j, rgb.getRGB());
                }
            }

            //Matriz final
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    int col= ImgLaplaz.getRGB(i, j);
                    Color rgb= new Color(col);

                    int red= rgb.getRed();
                    int blue= rgb.getBlue();
                    int green= rgb.getGreen();

                    double t=Math.sqrt(green*green+blue*blue);
                    t=t>255?255:t<0?0:t;
                    red=green=blue=(int)t;

                    rgb= new Color(red, green, blue);
                    ImgLaplaz.setRGB(i, j, rgb.getRGB());
                }
            }

            lab.setIcon(new ImageIcon(ImgLaplaz));

            try {
                File outputFile= new File(imageName);
                ImageIO.write(ImgLaplaz, "jpg", outputFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public void BordesRoberts(String imageName){
            BufferedImage inputFile = null;
            try {
                inputFile = ImageIO.read(new File(imageName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            int x = inputFile.getWidth();
            int y = inputFile.getHeight();
            BufferedImage ImgLaplaz = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);

            int p[] = new int[4];
            float delta_u = 0;
            float delta_v = 0;
            int t;

            //To red
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    int col= inputFile.getRGB(i, j);
                    Color rgb= new Color(col);

                    int red= rgb.getRed();
                    int blue= rgb.getBlue();
                    int green= rgb.getGreen();

                    red=(red+blue+green)/3;
                    
                    rgb= new Color(red, green, blue);
                    ImgLaplaz.setRGB(i, j, rgb.getRGB());
                }
            }

            for (int i=0; i < x-1; i++)
                for (int j=0; j < y-1; j++) {
                    p[0]=new Color(ImgLaplaz.getRGB(i, j)).getRed();
                    p[1]=new Color(ImgLaplaz.getRGB(i+1, j)).getRed();
                    p[2]=new Color(ImgLaplaz.getRGB(i, j+1)).getRed();
                    p[3]=new Color(ImgLaplaz.getRGB(i+1, j+1)).getRed();

                    delta_u = p[0] - p[3];
                    delta_v = p[1] - p[2];
                    t = (int) Math.sqrt(delta_u*delta_u + delta_v*delta_v);

                    t=t>255? 255: t<0?0: t;

                    Color col= new Color(t,t,t);

                    ImgLaplaz.setRGB(i, j, col.getRGB());
            }
           
            lab.setIcon(new ImageIcon(ImgLaplaz));

            try {
                File outputFile= new File(imageName);
                ImageIO.write(ImgLaplaz, "jpg", outputFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //------------------Filtros------------------
        
        public void PasoALtasBajas(String imageName, int Kernel[][], int divisor){
            BufferedImage inputFile = null;
            try {
                inputFile = ImageIO.read(new File(imageName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            int x = inputFile.getWidth();
            int y = inputFile.getHeight();
            BufferedImage ImgLaplaz = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    int x1 = i - 1 < 0 ? x - 1 : i - 1;
                    int x3 = i + 1 >= x ? 0 : i + 1;
                    int y1 = j - 1 < 0 ? y - 1 : j - 1;
                    int y3 = j + 1 >= y ? 0 : j + 1;
                    
                    int r1 = new Color(inputFile.getRGB(x1, y1)).getRed() * Kernel[0][0];
                    int r2 = new Color(inputFile.getRGB(i, y1)).getRed() * Kernel[0][1];
                    int r3 = new Color(inputFile.getRGB(x3, y1)).getRed() * Kernel[0][2];
                    int r4 = new Color(inputFile.getRGB(x1, j)).getRed() * Kernel[1][0];
                    int r5 = new Color(inputFile.getRGB(i, j)).getRed() * Kernel[1][1];
                    int r6 = new Color(inputFile.getRGB(x3, j)).getRed() * Kernel[1][2];
                    int r7 = new Color(inputFile.getRGB(x1, y3)).getRed() * Kernel[2][0];
                    int r8 = new Color(inputFile.getRGB(i, y3)).getRed() * Kernel[2][1];
                    int r9 = new Color(inputFile.getRGB(x3, y3)).getRed() * Kernel[2][2];

                    int g1 = new Color(inputFile.getRGB(x1, y1)).getGreen() * Kernel[0][0];
                    int g2 = new Color(inputFile.getRGB(i, y1)).getGreen() * Kernel[0][1];
                    int g3 = new Color(inputFile.getRGB(x3, y1)).getGreen() * Kernel[0][2];
                    int g4 = new Color(inputFile.getRGB(x1, j)).getGreen() * Kernel[1][0];
                    int g5 = new Color(inputFile.getRGB(i, j)).getGreen() * Kernel[1][1];
                    int g6 = new Color(inputFile.getRGB(x3, j)).getGreen() * Kernel[1][2];
                    int g7 = new Color(inputFile.getRGB(x1, y3)).getGreen() * Kernel[2][0];
                    int g8 = new Color(inputFile.getRGB(i, y3)).getGreen() * Kernel[2][1];
                    int g9 = new Color(inputFile.getRGB(x3, y3)).getGreen() * Kernel[2][2];

                    int b1 = new Color(inputFile.getRGB(x1, y1)).getBlue() * Kernel[0][0];
                    int b2 = new Color(inputFile.getRGB(i, y1)).getBlue() * Kernel[0][1];
                    int b3 = new Color(inputFile.getRGB(x3, y1)).getBlue() * Kernel[0][2];
                    int b4 = new Color(inputFile.getRGB(x1, j)).getBlue() * Kernel[1][0];
                    int b5 = new Color(inputFile.getRGB(i, j)).getBlue() * Kernel[1][1];
                    int b6 = new Color(inputFile.getRGB(x3, j)).getBlue() * Kernel[1][2];
                    int b7 = new Color(inputFile.getRGB(x1, y3)).getBlue() * Kernel[2][0];
                    int b8 = new Color(inputFile.getRGB(i, y3)).getBlue() * Kernel[2][1];
                    int b9 = new Color(inputFile.getRGB(x3, y3)).getBlue() * Kernel[2][2];

                    int RRES = (r1 + r2 + r3 + r4 + r5 + r6 + r7 + r8 + r9)/divisor;
                    RRES= RRES>255?255:RRES<0?0:RRES;
                    int GRES = (g1 + g2 + g3 + g4 + g5 + g6 + g7 + g8 + g9)/divisor;
                    GRES= GRES>255?255:GRES<0?0:GRES;
                    int BRES = (b1 + b2 + b3 + b4 + b5 + b6 + b7 + b8 + b9)/divisor;
                    BRES= BRES>255?255:BRES<0?0:BRES;

                    Color RGBRES= new Color(RRES, GRES, BRES);

                    ImgLaplaz.setRGB(i, j, RGBRES.getRGB());
                }
            }

            lab.setIcon(new ImageIcon(ImgLaplaz));

            try {
                File outputFile= new File(imageName);
                ImageIO.write(ImgLaplaz, "jpg", outputFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void CambiarTemp(String imageName, double redM, double blueM){
            BufferedImage inputFile = null;
            try {
                inputFile = ImageIO.read(new File(imageName));
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (int x = 0; x < inputFile.getWidth(); x++) {
                for (int y = 0; y < inputFile.getHeight(); y++) {
                    int rgba = inputFile.getRGB(x, y);
                    Color col = new Color(rgba);

                    int red, green, blue;

                    red=(int)Math.round((double)col.getRed()*redM);
                    red= red>255? 255: red;

                    green= col.getGreen();

                    blue=(int)Math.round((double)col.getBlue()*blueM);
                    blue= blue>255? 255: blue;

                    col= new Color(red, green, blue);
                    inputFile.setRGB(x, y, col.getRGB());
                }
            }
            lab.setIcon(new ImageIcon(inputFile));

            try {
                File outputFile= new File(imageName);
                ImageIO.write(inputFile, "jpg", outputFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void Israels(String imageName){
            BufferedImage inputFile = null;
            try {
                inputFile = ImageIO.read(new File(imageName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            int x = inputFile.getWidth();
            int y = inputFile.getHeight();
            // BufferedImage ImgLaplaz = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);

            int r,g,b,derx,izqx,supy,infy;
            for(int i=0;i<x;i++){
                for(int j=0;j<y;j++){
                    derx = i+1;
                    izqx = i-1;
                    supy = j-1;
                    infy = j+1;
                    if(derx==x)derx=0;
                    if(izqx<0)izqx=x-1;
                    if(supy<0)supy=y-1;
                    if(infy==y)infy=0;

                    Color c00 = new Color(inputFile.getRGB(izqx, supy));
                    Color c01 = new Color(inputFile.getRGB(i, supy));
                    Color c02 = new Color(inputFile.getRGB(derx, supy));
                    Color c10 = new Color(inputFile.getRGB(izqx, j));
                    Color c11 = new Color(inputFile.getRGB(i, j));
                    Color c12 = new Color(inputFile.getRGB(derx, j));
                    Color c20 = new Color(inputFile.getRGB(izqx, infy));
                    Color c21 = new Color(inputFile.getRGB(i, infy));
                    Color c22 = new Color(inputFile.getRGB(derx, infy));
                   
                    r = 1*(c00.getRed())+1*(c01.getRed())+1*(c02.getRed())
                    +1*(c10.getRed())-8*(c11.getRed())+1*(c12.getRed())
                    +1*(c20.getRed())+1*(c21.getRed())+1*(c22.getRed());
                   
                    b = 1*(c00.getBlue())+1*(c01.getBlue())+1*(c02.getBlue())
                    +1*(c10.getBlue())-8*(c11.getBlue())+1*(c12.getBlue())
                    +1*(c20.getBlue())+1*(c21.getBlue())+1*(c22.getBlue());

                    g = 1*(c00.getGreen())+1*(c01.getGreen())+1*(c02.getGreen())
                    +1*(c10.getGreen())-8*(c11.getGreen())+1*(c12.getGreen())
                    +1*(c20.getGreen())+1*(c21.getGreen())+1*(c22.getGreen());

                    r = Math.min(255, Math.max(0, r));
                    g = Math.min(255, Math.max(0, g));
                    b = Math.min(255, Math.max(0, b));

                    Color c = new Color(r,g,b);
                    inputFile.setRGB(i, j, c.getRGB());
                }
                
                lab.setIcon(new ImageIcon(inputFile));

                try {
                    File outputFile= new File(imageName);
                    ImageIO.write(inputFile, "jpg", outputFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //------------------Archivo------------------

        public String Abrir(){
            int status = chooser.showOpenDialog(null);

            if (status == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                if (file == null) {
                    return "";
                }
                String fileName = chooser.getSelectedFile().getAbsolutePath();

                NombreImagenOriginal= fileName;

                BufferedImage inputFile = null;
                try {
                   inputFile = ImageIO.read(new File(fileName));
                } catch (IOException e) {
                   e.printStackTrace();
                }

                String nombreimg= fileName.substring(fileName.lastIndexOf("\\")+1);
                fileName= fileName.replace(nombreimg, "temp-"+nombreimg);

                try {
                    File outputFile= new File(fileName);
                    ImageIO.write(inputFile, "jpg", outputFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return fileName;
            }
            return "";
        }

        public void Salir(){
            if(NombreImagen!=null){
                File imagen= new File(NombreImagen);
                imagen.delete();
            }
            setVisible(false);
            dispose();
        }

        public void Original(){
            BufferedImage inputFile = null;
            try {
                inputFile = ImageIO.read(new File(NombreImagenOriginal));
             } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                File outputFile= new File(NombreImagen);
                ImageIO.write(inputFile, "jpg", outputFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

            lab.setIcon(new ImageIcon(NombreImagen));
        }

        public void Guardar(){
            BufferedImage inputFile = null;
            try {
               inputFile = ImageIO.read(new File(NombreImagen));
            } catch (IOException e) {
               e.printStackTrace();
            }

            try {
                File outputFile= new File(NombreImagenOriginal);
                ImageIO.write(inputFile, "jpg", outputFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void GuardarComo(){
            int status= chooser.showOpenDialog(rootPane);
            if (status == JFileChooser.APPROVE_OPTION) {
                System.out.println(chooser.getSelectedFile());

                BufferedImage inputFile = null;
                try {
                   inputFile = ImageIO.read(new File(NombreImagen));
                } catch (IOException e) {
                   e.printStackTrace();
                }

                try {
                    File outputFile= new File(chooser.getSelectedFile()+".jpg");
                    ImageIO.write(inputFile, "jpg", outputFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                NombreImagenOriginal=chooser.getSelectedFile()+".jpg";

                BufferedImage original = null;
                try {
                   original = ImageIO.read(new File(NombreImagenOriginal));
                } catch (IOException e) {
                   e.printStackTrace();
                }

                String nombreimg= NombreImagenOriginal.substring(NombreImagenOriginal.lastIndexOf("\\")+1);
                NombreImagen= NombreImagenOriginal.replace(nombreimg, "temp-"+nombreimg);

                try {
                    File outputFile= new File(nombreimg);
                    ImageIO.write(original, "jpg", outputFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    
        public static void main(String[] args) {
            //Crear instancia del frame
            JFrame frame = new Proyectofinal();
        }
}

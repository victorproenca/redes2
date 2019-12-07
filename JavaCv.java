/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacv;

import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core.IplImage;

/**
 *
 * @author Victor
 */
public class JavaCv {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
    OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber("http://192.168.43.102:8080/video?dummy=param.mjpg"); 
        frameGrabber.setFormat("mjpeg");//
        frameGrabber.start(); // abrindo o driver da cam
        IplImage imagem = frameGrabber.grab(); // pega imagem da câmera e manda para a variavel imagem
        CanvasFrame canvasFrame = new CanvasFrame("Camera"); //cria a janela onde vai passar a webcam
        canvasFrame.setCanvasSize(imagem.width(), imagem.height()); //seta a altura e a largura da janela
        
        while (canvasFrame.isVisible() && (imagem = frameGrabber.grab()) != null) { //enquanto a janela não for fechada ou imagens da câmera continuarem sendo capturadas
            canvasFrame.showImage(imagem); // mostra a imagem capturada na janela criada pelo CanvasFrame
        }
        frameGrabber.stop(); // ao fechar a cam
        canvasFrame.dispose(); // ao fechar janela
        System.exit(0);
    }
    
}

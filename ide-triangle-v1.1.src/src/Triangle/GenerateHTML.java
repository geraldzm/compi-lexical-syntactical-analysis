/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle;


import GUI.Main;
import Triangle.SyntacticAnalyzer.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.*;

/**
 *
 * @author Leonardo
 */
public class GenerateHTML {


        public static String nameFile;
        
        public GenerateHTML(String html) {
            String caracter = "\\";
            String[] name = nameFile.split("");
            Integer ind = 0;
            Integer bar = 0;
            while(ind < nameFile.length()){
                if( name[ind].equals("\\")){
                    bar = ind+1;
                }
                ind++;
            }
            //System.out.println(nameFile.substring(bar,nameFile.length()-4));
            nameFile = nameFile.substring(bar,nameFile.length()-4);            
            try {
                String ruta = nameFile+".html";
                String contenido = html;
                File file = new File(ruta);
                // Si el archivo no existe es creado
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(contenido);
                bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }       
        }
        
    public static void SetDirectory(String directory) {
        GenerateHTML.nameFile = directory;
    }
}
package Controler;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;

/**
 *
 * @author xing
 */
public class exporterHtml {

    public static void main(String[] args) {
        try {

            String matin1 = "";
            String matin2 = "";
            String matin3 = "";
            String matin4 = "";
            String matin5 = "";
            String apremid1 = "";
            String apremid2 = "";
            String apremid3 = "";
            String apremid4 = "";
            String apremid5 = "";

//chemin de template
            String filePath = "C:\\Users\\IT\\Desktop\\exporter.html";
            System.out.print(filePath);
            String templateContent = "";
            FileInputStream fileinputstream = new FileInputStream(filePath);// lire exporter.html
            int lenght = fileinputstream.available();
            byte bytes[] = new byte[lenght];
            fileinputstream.read(bytes);
            fileinputstream.close();
            templateContent = new String(bytes);
            System.out.print(templateContent);
            // replacer les td
            templateContent = templateContent.replaceAll("###matin1###", matin1);
            templateContent = templateContent.replaceAll("###matin2###", matin2);
            templateContent = templateContent.replaceAll("###matin3###", matin3);
            templateContent = templateContent.replaceAll("###matin4###", matin4);
            templateContent = templateContent.replaceAll("###matin5###", matin5);
            templateContent = templateContent.replaceAll("###apremid1###", apremid1);
            templateContent = templateContent.replaceAll("###apremid2###", apremid2);
            templateContent = templateContent.replaceAll("###apremid3###", apremid3);
            templateContent = templateContent.replaceAll("###apremid4###", apremid4);
            templateContent = templateContent.replaceAll("###apremid5###", apremid5);
            System.out.print(templateContent);
           //nomer le fichier exporté avec l'heure de système. 
            Calendar calendar = Calendar.getInstance();
            String fileame = String.valueOf(calendar.getTimeInMillis())+ ".html";
            fileame = "C:\\Users\\IT\\Desktop\\" + fileame;// le chemin de fichier exporté
            FileOutputStream fileoutputstream = new FileOutputStream(fileame);// serialization de données
            System.out.print("le chemin de fichier exporté:");
            System.out.print(fileame);
            byte tag_bytes[] = templateContent.getBytes();
            fileoutputstream.write(tag_bytes);
            fileoutputstream.close();
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }
}

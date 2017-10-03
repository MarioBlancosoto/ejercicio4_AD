
package primitivewriteutf;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Metodos {
    
       static FileInputStream fis;
       static FileOutputStream fos;
       static DataOutputStream dat;
       static DataInputStream dit;
       static BufferedInputStream bis;
       static BufferedOutputStream bos;
       static String bytes[];
     public static void metodos (){
         
        try {
            fos = new FileOutputStream("/home/local/DANIELCASTELAO/mblancosoto/NetBeansProjects/PrimitiveWriteUTF/text3.txt");
            fis = new FileInputStream("/home/local/DANIELCASTELAO/mblancosoto/NetBeansProjects/PrimitiveWriteUTF/text3.txt");
            
         
            
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
       
           
       
    }
     
     public static void dataBuffer(){
         BufferedInputStream bis = new BufferedInputStream(fis);
         BufferedOutputStream bos = new BufferedOutputStream(fos);
         
     }
     
     public static void Datain(){
       int numeroCadeas=0;
        String cadea = JOptionPane.showInputDialog("Introduce a cadea a grabar ");
         
        dit = new DataInputStream(fis); 
        dat = new DataOutputStream(fos);
           try {
               System.out.println("writeUTF escribiu: " +cadea );
              for(int i=0;i<2;i++){
               dat.writeUTF(cadea);
               
               
               System.out.println("writeUTF escribiu: " + dat.size()+" Bytes ");
               System.out.println("Bytes totais Escritos "+ dat.size()+" Bytes ");
               
              }
                  numeroCadeas = dit.available();
                  while(dit.available()!=0){
                   
                   System.out.println("Esta e unha Cadea "+dit.readUTF());
                   
                   if(dit.available()>0){
                   System.out.println("Bytes totais Lidos "+(numeroCadeas-dit.available())+" Bytes "); 
                       System.out.println("Esta e a segunda cadea ");
                   System.out.println("Número de Bytes por ler "+dit.available());
                   }
               } 
               
           } catch (IOException ex) {
               System.out.println("Erro "+ex.getMessage());
           }
        
           try { 
               dit.close();
               dat.close();
           } catch (IOException ex) {
               Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
           }
     
     }
}

package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Test {

    public static int[] numOfVerseInEverySurah=new int[]{7,286,200,176,120,165,206,75,129,109,123,111,43,52,99,128,
                  111,110,98,135,112,78,118,64,77,227,93,88,69,60,34,30,73,54,45,83,182,88,75,85,
                  54,53,89,59,37,35,38,29,18,45,60,49,62,55,78,96,29,22,24,13,14,11,11,18,12,12,
                  30,52,52,44,28,28,20,56,40,31,50,40,46,42,29,19,36,25,22,17,19,26,30,20,15,21
                      ,11,8,8,19,5,8,8,11,11,8,3,9,5,4,7,3,6,3,5,4,5,6};  
    
    public static String[] verseWithoutSpace,verse;
    public static String charsOfCurrentVerse="";
    
    
    public static void main(String[] args) {

        Test obj = new Test();
        
    }
    
    public Test(){
         Scanner in = new Scanner(System.in);
        try {
        
            Scanner sc = new Scanner(new File("/home/safyia/Test5/src/test5/QuranWithoutVowels.txt"));
            List<String> lines = new ArrayList<String>();
            while (sc.hasNextLine()) {
                lines.add(sc.nextLine());
            }

            verse = lines.toArray(new String[0]);
            
            try {
                              
                verseWithoutSpace=new String[verse.length];
             
             for(int i=0;i<verse.length;i++){
               
                charsOfCurrentVerse="";
                        for(int x=0;x<=(verse[i].length())-1;x++){
                            if(verse[i].charAt(x) == ' '){
                              ///  
                            }
                            else{
                              charsOfCurrentVerse+= Character.toString(verse[i].charAt(x));
                            }
                        }
                        verseWithoutSpace[i]=charsOfCurrentVerse;
                    }
            
             
             
                System.out.println("Enter number of character ");
                int number=in.nextInt();

                
                int z=getVerseForCharacterNo(number);
                System.out.println("result "+z);
                System.out.println("Aya = "+getVerseInChapter(z));
                System.out.println("number of surah "+getSurahNo(z));
             
             
            } catch (Exception ex) {
            }

          
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
     public static int getVerseForCharacterNo(int numberOfCharacter){
        
               int result=0,num=0,z=0;
               
                for(int i=0;i<=verseWithoutSpace.length;i++){
                  
                    if(num >= numberOfCharacter){
                            result=i;
                            break;
                        }
                        else{
                        z=0;
                    for(int x=0;x<=(verseWithoutSpace[i].length())-1;x++){     
                         z=z+1;
                    }
                  
                      num=num+z;
                }
                }
                
               
             return result;
    }
    
    public static int  getVerseInChapter(int result){
         int number=0,result_number=0,aya=0,c=0;
             for(int i=0;i<=numOfVerseInEverySurah.length;i++){
                 number+=numOfVerseInEverySurah[i];
                 if(i==0){
                     
                 }else{
                c+=numOfVerseInEverySurah[(i-1)];
                 }
                 
                  if(result<=number){  
            
                      result_number=i;
                     aya=result-c;
                   
                    break;
                 }
             }  
               
   return aya;
    }
    
   public  int getSurahNo(int result){
       int id=0;
       int number=0,result_number=0,aya=0,c=0;
             for(int i=0;i<=numOfVerseInEverySurah.length;i++){
                 number+=numOfVerseInEverySurah[i];
                 if(i==0){
                   //  
                 }else{
                c+=numOfVerseInEverySurah[(i-1)];
                 }
                 
                  if(result<=number){  
                      result_number=i; 
                    break;
                 }
             }  
     id=result_number+1;
             
       return id;
       
    } 
  
}

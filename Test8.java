
package test8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test8 {

    public static int[] arr_num=new int[]{7,286,200,176,120,165,206,75,129,109,123,111,43,52,99,128,
                  111,110,98,135,112,78,118,64,77,227,93,88,69,60,34,30,73,54,45,83,182,88,75,85,
                  54,53,89,59,37,35,38,29,18,45,60,49,62,55,78,96,29,22,24,13,14,11,11,18,12,12,
                  30,52,52,44,28,28,20,56,40,31,50,40,46,42,29,19,36,25,22,17,19,26,30,20,15,21
                      ,11,8,8,19,5,8,8,11,11,8,3,9,5,4,7,3,6,3,5,4,5,6};  
    
    public static String[] arr2,arr;
    public static String aa="";
    
    public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
        try {
        
            Scanner sc = new Scanner(new File("/home/safyia/Test5/src/test5/QuranWithoutVowels.txt"));
            List<String> lines = new ArrayList<String>();
            while (sc.hasNextLine()) {
                lines.add(sc.nextLine());
            }

            arr = lines.toArray(new String[0]);
            
            try {
                              
                arr2=new String[arr.length];
             
             for(int i=0;i<arr.length;i++){
               
                aa="";
                        for(int x=0;x<=(arr[i].length())-1;x++){
                            if(arr[i].charAt(x) == ' '){
                              ///  
                            }
                            else{
                              aa+= Character.toString(arr[i].charAt(x));
                            }
                        }
                        arr2[i]=aa;
                    }
            
          
                System.out.println("Enter number of character ");
                int number=in.nextInt();
   // getResult(number);
                System.out.println("AYA = "+getResult(number));
              //  System.out.println("Id = "+getaya(number));
            
             
            } catch (Exception ex) {
            }

          
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int getResult(int number){
        
               int result=0,num=0,z=0;
               
                for(int i=0;i<=arr2.length;i++){
                  
                    if(num >= number){
                            result=i;
                            break;
                        }
                        else{
                        z=0;
                    for(int x=0;x<=(arr2[i].length())-1;x++){     
                         z=z+1;
                    }
                  
                      num=num+z;
                }
                }
              
              // System.out.println("result of aya = "+result);
              int AYA = getaya(result);
               
             return AYA;
    }
    
    public static int  getaya(int result){
         int number=0,result_number=0,aya=0,c=0;
             for(int i=0;i<arr_num.length;i++){
                 number+=arr_num[i];
                 if(i==0){
                     
                 }else{
                c+=arr_num[(i-1)];
                 }
                 
                  if(result<=number){  
            
                      result_number=i;
                     aya=result-c;
                   
                    break;
                 }
             }  
  
                System.out.println("aya "+aya + " number of surah = "+(result_number+1));   
               
   return aya;
    }
    
    public  int getIdSurah(int number2){
        int result= getResult(number2);
        int id=0;
         int number=0,result_number=0,aya=0,c=0;
             for(int i=0;i<arr_num.length;i++){
                 number+=arr_num[i];
                 if(i==0){
                     
                 }else{
                c+=arr_num[(i-1)];
                 }
                 
                  if(result<=number){  
              
                      result_number=i;
                     aya=result-c;
                   
                    break;
                 }
             }  
  
             id=result_number;
             System.out.println("id -- "+id);
               // System.out.println("aya "+aya + " number of surah = "+(result_number+1));   
               
        
        return id;
       
    } 
   
    
}

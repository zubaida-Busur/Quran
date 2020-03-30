import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Test {

    public static int[] numOfVerseInEverySurah=new int[]{7,286,200,176,120,165,206,75,129,109,123,111,43,52,99,128,111,110,98,135,112,78,118,64,77,227,93,88,69,60,34,30,73,54,45,83,182,88,75,85, 54,53,89,59,37,35,38,29,18,45,60,49,62,55,78,96,29,22,24,13,14,11,11,18,12,12,30,52,52,44,28,28,20,56,40,31,50,40,46,42,29,19,36,25,22,17,19,26,30,20,15,21,11,8,8,19,5,8,8,11,11,8,3,9,5,4,7,3,6,3,5,4,5,6};
    public static String[] allVersesWithoutSpacing, allVersesWithSpaces;
    public static String charsOfCurrentVerse="";

    public Test(){
         Scanner in = new Scanner(System.in);
    try {
        
            Scanner sc = new Scanner(new File("C:\\Users\\Abdifatah M Ibrahim\\Documents\\quranText.txt"));
            List<String> lines = new ArrayList<String>();
            while (sc.hasNextLine()) {
                lines.add(sc.nextLine());
            }

            allVersesWithSpaces = lines.toArray(new String[0]);
            
        try {

             allVersesWithoutSpacing = new String[allVersesWithSpaces.length];
             
             for(int i = 0; i < allVersesWithSpaces.length; i++)
             {
                charsOfCurrentVerse = "";
                        for(int x = 0; x <= (allVersesWithSpaces[i].length())-1; x++){
                            if(allVersesWithSpaces[i].charAt(x) == ' ')
                            {
                              //
                            }
                            else{
                              charsOfCurrentVerse += Character.toString(allVersesWithSpaces[i].charAt(x));
                            }
                        }
                        allVersesWithoutSpacing[i]=charsOfCurrentVerse;
                    }

                System.out.println("Enter number of character ");
                int number=in.nextInt();

                
                int z = getVerseForCharacterNo(number);
                System.out.println("result "+z);
                System.out.println("Aya = "+getVerseInChapter(z));
                System.out.println("name of surah "+getSurahName(z));

            } catch (Exception ex) {
            }

          
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
     public static int getVerseForCharacterNo(int indexOfCharacter){
        
               int characterPosition = 0, totalCharactersBeforeVerse = 0, characterLenghtofCurrentVerse = 0;
               
                for(int i = 0; i <= allVersesWithoutSpacing.length; i++)
                {
                    if(totalCharactersBeforeVerse >= indexOfCharacter){
                            characterPosition = i;
                            break;
                        }
                        else
                            {
                                characterLenghtofCurrentVerse = 0;
                                for(int x = 0; x <= (allVersesWithoutSpacing[i].length())-1; x++)
                                {
                                characterLenghtofCurrentVerse = characterLenghtofCurrentVerse + 1;
                                }
                            totalCharactersBeforeVerse = totalCharactersBeforeVerse + characterLenghtofCurrentVerse;
                            }
                }
             return characterPosition;
    }
    
    public static int  getVerseInChapter(int verseIndexInQuran)
    {
         int versesUptoSurah = 0, verseNo = 0, versesJustBefore = 0;

         for(int i = 0 ; i <= numOfVerseInEverySurah.length; i++)
         {
                 versesUptoSurah += numOfVerseInEverySurah[i];

                 if(i == 0)
                 {
                     //
                 }
                 else
                     {
                         versesJustBefore += numOfVerseInEverySurah[(i-1)];
                     }

                 //if the verses versesUptoSurah grow bigger than your verseNo ... then you've reached the target
              if(verseIndexInQuran <= versesUptoSurah)
              {
                 verseNo = verseIndexInQuran - versesJustBefore;
                break;
             }
         }
               
        return verseNo;
    }
    
   public String getSurahName(int result)
   {
         int id = 0;
         String name_surah="";
         int number = 0, result_number = 0, aya = 0, c = 0;

         for(int i = 0; i <= numOfVerseInEverySurah.length; i++)
         {
                 number += numOfVerseInEverySurah[i];
                 if(i == 0){
                   //  
                 }
                 else
                     {
                         c += numOfVerseInEverySurah[(i-1)];
                     }
                 
              if(result<=number)
             {
                result_number = i;
                break;
             }
         }

         id = result_number + 1;
         if(id==1){
             name_surah="الفاتحة";
         }
         if(id==2){
             name_surah="البقرة";
         }
         if(id==3){
             name_surah="آل عمران";
         }
         if(id==4){
             name_surah="النساء";
         }
         
         if(id==5){
             name_surah="المائد";
         }
         if(id==6){
             name_surah="الأنعام";
         }
         if(id==7){
             name_surah="الأعراف";
         }
         
         if(id==8){
             name_surah="الأنفال ";
         }
         if(id==9){
             name_surah="التوبة";
         }
         if(id==10){
             name_surah="يونس";
         }
         if(id==11){
             name_surah="هود";
         }
         if(id==12){
             name_surah="يوسف";
         }
         if(id==13){
             name_surah="الرعد ";
         }
         if(id==14){
             name_surah="إبراهيم";
         }
         if(id==15){
             name_surah="الحجر";
         }
         if(id==16){
             name_surah="النحل ";
         }
         if(id==17){
             name_surah="الإسراء";
         }
         if(id==18){
             name_surah="الكهف";
         }
         if(id==19){
             name_surah="مريم";
         }
         if(id==20){
             name_surah="طه";
         }
         if(id==21){
             name_surah="الأنبياء";
         }
         if(id==22){
             name_surah="الحج";
         }
         if(id==23){
             name_surah="المؤمنون";
         }
         if(id==24){
             name_surah="النور";
         }
         if(id==25){
             name_surah="الفرقان";
         }
         if(id==26){
             name_surah="الشعراء";
         }
         if(id==27){
             name_surah="النمل";
         }
         if(id==28){
             name_surah="القصص";
         }
         if(id==29){
             name_surah="العنكبوت";
         }
         if(id==30){
             name_surah="الروم ";
         }
         if(id==31){
             name_surah="لقمان";
         }
         if(id==32){
             name_surah="السجدة";
         }
         if(id==33){
             name_surah="الأحزاب";
         }
         if(id==34){
             name_surah="سبأ";
         }
         if(id==35){
             name_surah="فاطر";
         }
         if(id==36){
             name_surah="يس";
         }
         if(id==37){
             name_surah="الصافات";
         }
         if(id==38){
             name_surah="ص";
         }
         if(id==39){
             name_surah="الزمر";
         }
         if(id==40){
             name_surah="غافر ";
         }
         if(id==41){
             name_surah="فصلت";
         }
         if(id==42){
             name_surah="الشورى";
         }
         if(id==43){
             name_surah="الزخرف";
         }
         if(id==44){
             name_surah="الدخان";
         }
         if(id==45){
             name_surah="الجاثية";
         }
         if(id==46){
             name_surah="الأحقاف";
         }
         if(id==47){
             name_surah="محمد";
         }
         if(id==48){
             name_surah="الفتح";
         }
         if(id==49){
             name_surah="الحجرات";
         }
         if(id==50){
             name_surah="ق";
         }
         if(id==51){
             name_surah="الذاريات";
         }
         if(id==52){
             name_surah="الطور";
         }
         if(id==53){
             name_surah="النجم";
         }
         if(id==54){
             name_surah="القمر";
         }
         if(id==55){
             name_surah="الرحمن";
         }
         if(id==56){
             name_surah="الواقعة";
         }
         if(id==57){
             name_surah="الحديد";
         }
         if(id==58){
             name_surah="المجادلة";
         }
         if(id==59){
             name_surah="الحشر";
         }
         if(id==60){
             name_surah="الممتحنة";
         }
         if(id==61){
             name_surah="الصف";
         }
         if(id==62){
             name_surah="الجمعة";
         }
         if(id==63){
             name_surah="المنافقون";
         }
         if(id==64){
             name_surah="التغابن";
         }
         if(id==65){
             name_surah="الطلاق";
         }
         if(id==66){
             name_surah="التحريم";
         }
         if(id==67){
             name_surah="الملك";
         }
         if(id==68){
             name_surah="القلم";
         }
         if(id==69){
             name_surah="القلم";
         }
         if(id==70){
             name_surah="المعارج";
         }
         if(id==71){
             name_surah="نوح ";
         }
         if(id==72){
             name_surah="الجن";
         }
         if(id==73){
             name_surah="المزمل";
         }
         if(id==74){
             name_surah="المدثر";
         }
         if(id==75){
             name_surah="القيامة";
         }
         if(id==76){
             name_surah="الإنسان";
         }
         if(id==77){
             name_surah="المرسلات";
         }
         if(id==78){
             name_surah="النبأ";
         }
         if(id==79){
             name_surah="النازعات";
         }if(id==80){
             name_surah="عبس";
         }
         if(id==81){
             name_surah="التكوير";
         }
         if(id==82){
             name_surah="الإنفطار";
         }
         if(id==83){
             name_surah="المطففين";
         }if(id==84){
             name_surah="الإنشقاق";
         }
         if(id==85){
             name_surah="البروج";
         }
         if(id==86){
             name_surah="الطارق";
         }
         if(id==87){
             name_surah="الأعلى";
         }
         if(id==88){
             name_surah="الغاشية";
         }
         if(id==89){
             name_surah="الفجر";
         }
         if(id==90){
             name_surah="البلد";
         }if(id==91){
          name_surah="الشمس";   
         }
         if(id==92){
          name_surah="الليل";   
         }
         if(id==93){
          name_surah="الضحى";   
         }if(id==94){
          name_surah="الشرح";   
         }
         if(id==95){
          name_surah="التين";   
         }
         if(id==96){
          name_surah="العلق";   
         }
         if(id==97){
          name_surah="القدر";   
         }
         if(id==98){
          name_surah="البينة";   
         }
         if(id==99){
          name_surah="الزلزلة";   
         }
         if(id==100){
          name_surah="العاديات";   
         }
         if(id==101){
          name_surah="القارعة";   
         }
         if(id==102){
          name_surah="التكاثر";   
         }
         if(id==103){
          name_surah="العصر";   
         }
         if(id==104){
          name_surah="الهمزة";   
         }
         if(id==105){
          name_surah="الفيل";   
         }
         if(id==106){
          name_surah="قريش";   
         }
         if(id==107){
          name_surah="الماعون";   
         }
         if(id==108){
          name_surah="الكوثر ";   
         }
         if(id==109){
          name_surah="الكافرون";   
         }
         if(id==110){
          name_surah="النصر";   
         }
         if(id==111){
          name_surah="المسد";   
         }
         if(id==112){
          name_surah="الإخلاص";   
         }
         if(id==113){
          name_surah="الفلق";   
         }if(id==114){
          name_surah="الناس";   
         }
         
     
         return name_surah;
   }
    
}

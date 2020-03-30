import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class QuranData {

    public static int[] numOfVerseInEverySurah=new int[]{7,286,200,176,120,165,206,75,129,109,123,111,43,52,99,128,111,110,98,135,112,78,118,64,77,227,93,88,69,60,34,30,73,54,45,83,182,88,75,85, 54,53,89,59,37,35,38,29,18,45,60,49,62,55,78,96,29,22,24,13,14,11,11,18,12,12,30,52,52,44,28,28,20,56,40,31,50,40,46,42,29,19,36,25,22,17,19,26,30,20,15,21,11,8,8,19,5,8,8,11,11,8,3,9,5,4,7,3,6,3,5,4,5,6};
    public static String[] allVersesWithoutSpacing, allVersesWithSpaces;
    public static String charsOfCurrentVerse="";

    public QuranData(){
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

            } catch (Exception ex) {
            }

          
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
         public int getVerseForCharacterNo(int indexOfCharacter)
         {

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

        public int  getVerseInChapter(int verseIndexInQuran)
        {
             int versesBefore = 0, verseNo = 0, versesJustBefore = 0;

             for(int i = 0 ; i <= numOfVerseInEverySurah.length; i++)
             {
                     versesBefore += numOfVerseInEverySurah[i];

                     if(i == 0)
                     {

                     }
                     else
                         {
                             versesJustBefore += numOfVerseInEverySurah[(i-1)];
                         }

                     //if the verses versesUptoSurah grow bigger than your verseNo ... then you've reached the target
                  if(verseIndexInQuran <= versesBefore)
                  {
                     verseNo = verseIndexInQuran - versesJustBefore ;
                    break;
                 }
             }

            return verseNo;
        }
    
       public String getSurahName(int verseIndexInQuran)
       {
           if (verseIndexInQuran == 0) return "No Surah";

             int indexedChapterID = 0;

             String chapterName="";

             int versesBefore = 0, chapterNumber = 0, versesJustBefore = 0;

             for(int i = 0; i <= numOfVerseInEverySurah.length; i++) //spans 114 chapters
             {
                     versesBefore += numOfVerseInEverySurah[i];
                     if(i == 0)
                     {
                       //do nothing
                     }
                     else
                         {
                             versesJustBefore += numOfVerseInEverySurah[(i-1)];
                         }

                  if(verseIndexInQuran <= versesBefore)
                 {
                    chapterNumber = i;
                    break;
                 }
             }

             indexedChapterID = chapterNumber + 1 ;


             if(indexedChapterID == 1)
             {
                 chapterName="الفاتحة";
             }
             if (indexedChapterID == 2)
             {
                 chapterName="البقرة";
             }
             if (indexedChapterID == 3)
             {
                 chapterName="آل عمران";
             }
             if (indexedChapterID == 4)
             {
                 chapterName="النساء";
             }
             if (indexedChapterID == 5)
             {
                 chapterName="المائد";
             }
             if (indexedChapterID == 6)
             {
                 chapterName="الأنعام";
             }
             if (indexedChapterID == 7)
             {
                 chapterName="الأعراف";
             }
             if (indexedChapterID == 8)
             {
                 chapterName="الأنفال ";
             }
             if (indexedChapterID == 9)
             {
                 chapterName="التوبة";
             }
             if (indexedChapterID == 10)
             {
                 chapterName="يونس";
             }
             if (indexedChapterID == 11)
             {
                 chapterName="هود";
             }
             if (indexedChapterID == 12)
             {
                 chapterName="يوسف";
             }
             if (indexedChapterID == 13)
             {
                 chapterName="الرعد ";
             }
             if (indexedChapterID == 14)
             {
                 chapterName="إبراهيم";
             }
             if (indexedChapterID == 15)
             {
                 chapterName="الحجر";
             }
             if (indexedChapterID == 16)
             {
                 chapterName="النحل ";
             }
             if (indexedChapterID == 17)
             {
                 chapterName="الإسراء";
             }
             if (indexedChapterID == 18)
             {
                 chapterName="الكهف";
             }
             if (indexedChapterID == 19)
             {
                 chapterName="مريم";
             }
             if (indexedChapterID == 20)
             {
                 chapterName="طه";
             }
             if (indexedChapterID == 21)
             {
                 chapterName="الأنبياء";
             }
             if (indexedChapterID == 22)
             {
                 chapterName="الحج";
             }
             if (indexedChapterID == 23)
             {
                 chapterName="المؤمنون";
             }
             if (indexedChapterID == 24)
             {
                 chapterName="النور";
             }
             if (indexedChapterID == 25)
             {
                 chapterName="الفرقان";
             }
             if (indexedChapterID == 26)
             {
                 chapterName="الشعراء";
             }
             if (indexedChapterID == 27)
             {
                 chapterName="النمل";
             }
             if (indexedChapterID == 28)
             {
                 chapterName="القصص";
             }
             if (indexedChapterID == 29)
             {
                 chapterName="العنكبوت";
             }
             if (indexedChapterID == 30)
             {
                 chapterName="الروم ";
             }
             if (indexedChapterID == 31)
             {
                 chapterName="لقمان";
             }
             if (indexedChapterID == 32)
             {
                 chapterName="السجدة";
             }
             if (indexedChapterID == 33)
             {
                 chapterName="الأحزاب";
             }
             if (indexedChapterID == 34)
             {
                 chapterName="سبأ";
             }
             if (indexedChapterID == 35)
             {
                 chapterName="فاطر";
             }
             if (indexedChapterID == 36)
             {
                 chapterName="يس";
             }
             if (indexedChapterID == 37)
             {
                 chapterName="الصافات";
             }
             if (indexedChapterID == 38)
             {
                 chapterName="ص";
             }
             if (indexedChapterID == 39)
             {
                 chapterName="الزمر";
             }
             if (indexedChapterID == 40)
             {
                 chapterName="غافر ";
             }
             if (indexedChapterID == 41)
             {
                 chapterName="فصلت";
             }
             if (indexedChapterID == 42)
             {
                 chapterName="الشورى";
             }
             if (indexedChapterID == 43)
             {
                 chapterName="الزخرف";
             }
             if (indexedChapterID == 44)
             {
                 chapterName="الدخان";
             }
             if (indexedChapterID == 45)
             {
                 chapterName="الجاثية";
             }
             if (indexedChapterID == 46)
             {
                 chapterName="الأحقاف";
             }
             if (indexedChapterID == 47)
             {
                 chapterName="محمد";
             }
             if (indexedChapterID == 48)
             {
                 chapterName="الفتح";
             }
             if (indexedChapterID == 49)
             {
                 chapterName="الحجرات";
             }
             if (indexedChapterID == 50)
             {
                 chapterName="ق";
             }
             if (indexedChapterID == 51)
             {
                 chapterName="الذاريات";
             }
             if (indexedChapterID == 52)
             {
                 chapterName="الطور";
             }
             if (indexedChapterID == 53)
             {
                 chapterName="النجم";
             }
             if (indexedChapterID == 54)
             {
                 chapterName="القمر";
             }
             if (indexedChapterID == 55)
             {
                 chapterName="الرحمن";
             }
             if (indexedChapterID == 56)
             {
                 chapterName="الواقعة";
             }
             if (indexedChapterID == 57)
             {
                 chapterName="الحديد";
             }
             if (indexedChapterID == 58)
             {
                 chapterName="المجادلة";
             }
             if (indexedChapterID == 59)
             {
                 chapterName="الحشر";
             }
             if (indexedChapterID == 60)
             {
                 chapterName="الممتحنة";
             }
             if (indexedChapterID == 61)
             {
                 chapterName="الصف";
             }
             if (indexedChapterID == 62)
             {
                 chapterName="الجمعة";
             }
             if (indexedChapterID == 63)
             {
                 chapterName="المنافقون";
             }
             if (indexedChapterID == 64)
             {
                 chapterName="التغابن";
             }
             if (indexedChapterID == 65)
             {
                 chapterName="الطلاق";
             }
             if (indexedChapterID == 66)
             {
                 chapterName="التحريم";
             }
             if (indexedChapterID == 67)
             {
                 chapterName="الملك";
             }
             if (indexedChapterID == 68)
             {
                 chapterName="القلم";
             }
             if (indexedChapterID == 69)
             {
                 chapterName="القلم";
             }
             if (indexedChapterID == 70)
             {
                 chapterName="المعارج";
             }
             if (indexedChapterID == 71)
             {
                 chapterName="نوح ";
             }
             if (indexedChapterID == 72)
             {
                 chapterName="الجن";
             }
             if (indexedChapterID == 73)
             {
                 chapterName="المزمل";
             }
             if (indexedChapterID == 74)
             {
                 chapterName="المدثر";
             }
             if (indexedChapterID == 75)
             {
                 chapterName="القيامة";
             }
             if (indexedChapterID == 76)
             {
                 chapterName="الإنسان";
             }
             if (indexedChapterID == 77)
             {
                 chapterName="المرسلات";
             }
             if (indexedChapterID == 78)
             {
                 chapterName="النبأ";
             }
             if (indexedChapterID == 79)
             {
                 chapterName="النازعات";
             }
             if (indexedChapterID == 80)
             {
                 chapterName="عبس";
             }
             if (indexedChapterID == 81)
             {
                 chapterName="التكوير";
             }
             if (indexedChapterID == 82)
             {
                 chapterName="الإنفطار";
             }
             if (indexedChapterID == 83)
             {
                 chapterName="المطففين";
             }if (indexedChapterID == 84)
             {
                 chapterName="الإنشقاق";
             }
             if (indexedChapterID == 85)
             {
                 chapterName="البروج";
             }
             if (indexedChapterID == 86)
             {
                 chapterName="الطارق";
             }
             if (indexedChapterID == 87)
             {
                 chapterName="الأعلى";
             }
             if (indexedChapterID == 88)
             {
                 chapterName="الغاشية";
             }
             if (indexedChapterID == 89)
             {
                 chapterName="الفجر";
             }
             if (indexedChapterID == 90)
             {
                 chapterName="البلد";
             }
             if (indexedChapterID == 91)
             {
              chapterName="الشمس";
             }
             if (indexedChapterID == 92)
             {
              chapterName="الليل";
             }
             if (indexedChapterID == 93)
             {
              chapterName="الضحى";
             }
             if (indexedChapterID == 94)
             {
              chapterName="الشرح";
             }
             if (indexedChapterID == 95){
              chapterName="التين";
             }
             if (indexedChapterID == 96)
             {
              chapterName="العلق";
             }
             if (indexedChapterID == 97)
             {
              chapterName="القدر";
             }
             if (indexedChapterID == 98)
             {
              chapterName="البينة";
             }
             if (indexedChapterID == 99)
             {
              chapterName="الزلزلة";
             }
             if (indexedChapterID == 100)
             {
              chapterName="العاديات";
             }
             if (indexedChapterID == 101)
             {
              chapterName="القارعة";
             }
             if (indexedChapterID == 102)
             {
              chapterName="التكاثر";
             }
             if (indexedChapterID == 103)
             {
              chapterName="العصر";
             }
             if (indexedChapterID == 104)
             {
              chapterName="الهمزة";
             }
             if (indexedChapterID == 105)
             {
              chapterName="الفيل";
             }
             if (indexedChapterID == 106)
             {
              chapterName="قريش";
             }
             if (indexedChapterID == 107)
             {
              chapterName="الماعون";
             }
             if (indexedChapterID == 108)
             {
              chapterName="الكوثر ";
             }
             if (indexedChapterID == 109)
             {
              chapterName="الكافرون";
             }
             if (indexedChapterID == 110)
             {
              chapterName="النصر";
             }
             if (indexedChapterID == 111)
             {
              chapterName="المسد";
             }
             if (indexedChapterID == 112)
             {
              chapterName="الإخلاص";
             }
             if (indexedChapterID == 113)
             {
              chapterName="الفلق";
             }
             if (indexedChapterID == 114)
             {
              chapterName="الناس";
             }
             return chapterName;
       }
    
}

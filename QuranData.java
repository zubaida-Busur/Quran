import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class QuranData {

    private static int[] numOfVerseInEverySurah = new int[]{7,286,200,176,120,165,206,75,129,109,123,111,43,52,99,128,111,110,98,135,112,78,118,64,77,227,93,88,69,60,34,30,73,54,45,83,182,88,75,85, 54,53,89,59,37,35,38,29,18,45,60,49,62,55,78,96,29,22,24,13,14,11,11,18,12,12,30,52,52,44,28,28,20,56,40,31,50,40,46,42,29,19,36,25,22,17,19,26,30,20,15,21,11,8,8,19,5,8,8,11,11,8,3,9,5,4,7,3,6,3,5,4,5,6};
    public static String[] allVersesWithoutSpacing, allVersesWithSpaces;
    private int [] reversedSumOfVerseHeaders;
    public static String charsOfCurrentVerse = "";
    private enum  Surahs{ الفاتحة, البقرة,عمران , النساء, المائد, الأنعام, الأعراف, الأنفال , التوبة, يونس, هود, يوسف, الرعد , إبراهيم, الحجر, النحل , الإسراء, الكهف, مريم, طه, الأنبياء, الحج, المؤمنون, النور, الفرقان,الشعراء,النمل,القصص,العنكبوت,الروم ,لقمان,السجدة,الأحزاب,سبأ,فاطر,يس,الصافات,ص,الزمر,غافر ,فصلت,الشورى,الزخرف,الدخان,الجاثية,الأحقاف,محمد,الفتح,الحجرات,ق,الذاريات,الطور,النجم,القمر,الرحمن,الواقعة,الحديد,المجادلة,الحشر,الممتحنة,الصف,الجمعة,المنافقون,التغابن,الطلاق,التحريم,الملك,القلم,الحاقة,المعارج,نوح ,الجن,المزمل,المدثر,القيامة,الإنسان,المرسلات,النبأ,النازعات,عبس,التكوير,الإنفطار,المطففين,الإنشقاق,البروج,الطارق,الأعلى,الغاشية,الفجر,البلد,الشمس,الليل,الضحى,الشرح,التين,العلق,القدر,البينة,الزلزلة,العاديات,القارعة,التكاثر,العصر,الهمزة,الفيل,قريش,الماعون,الكوثر ,الكافرون,النصر,المسد,الإخلاص,الفلق,الناس}

            public QuranData()
            {
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

                    reversedSumOfVerseHeaders = new int[114];

                    int sum_indexs = 0;
                    for(int x = 0; x < numOfVerseInEverySurah.length; x++)
                    {
                        sum_indexs += QuranData.numOfVerseInEverySurah[x];
                        reversedSumOfVerseHeaders[113 - x] = sum_indexs;
                    }


                } catch (Exception ex)
                    {
                        //
                    }
                    } catch (FileNotFoundException e)
                    {
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

                 int versesBefore = 0, chapterNumber = 0;

                 for(int i = 0; i <= numOfVerseInEverySurah.length; i++) //spans 114 chapters
                 {
                     versesBefore += numOfVerseInEverySurah[i];

                      if(verseIndexInQuran <= versesBefore)
                     {
                        chapterNumber = i;
                        break;
                     }
                 }

                 return (chapterNumber == 2) ? "آل عمران" : String.valueOf(Surahs.values()[chapterNumber]);
           }

           public int[] getDivisionHeaderByVerse(double divisionType , int beginningVerse , int endVerse)
           {
               int onCharacter = getCharacterIndexForVerse(beginningVerse);
               int currentIndexOfVerse = beginningVerse;
               double div =  (600.0 /  divisionType);
               int step =   ( (int) (330709/div));
               int verseHolder = 0;
               ArrayList<Integer> myList = new ArrayList<Integer>();
               myList.add(0, beginningVerse);


               while ((getCharacterIndexForVerse(currentIndexOfVerse) < getCharacterIndexForVerse(endVerse)))
               {
                        onCharacter += step;
                        verseHolder = getVerseForCharacterNo(onCharacter);

                        if ((getVerseLenght(verseHolder) / 2) <= ( onCharacter - getCharacterIndexForVerse(verseHolder)))
                        {
                            onCharacter = getCharacterIndexForVerse(verseHolder);
                            myList.add(verseHolder);
                            currentIndexOfVerse = verseHolder;

                        }
                        else
                        {
                            onCharacter = getCharacterIndexForVerse(verseHolder + 1);
                            myList.add((verseHolder + 1));
                            currentIndexOfVerse = verseHolder + 1;
                        }
               }
               int divisions[] = new int[myList.size()];
               for (int i = 0; i < myList.size() ; i++)
               {
                  divisions[i] =  myList.get(i);
               }

               return divisions;
           }

           //returns a 0-indexed array This function should be private after testing
           public int[] getCharacterIndexOfVerseHeaders()
           {
               int sum_index = 0;

               int[] arr_start = new int[6236];

               for(int i = 0 ; i < allVersesWithoutSpacing.length; i++)
               {
                   arr_start[i] = sum_index;
                   sum_index += allVersesWithoutSpacing[i].length();
               }
               return arr_start;
           }

            //returns a 0-indexed array af the Lenght of the verses: should be private too!
           public int[] getCharacterLenghtOfAllVerses()
           {
               int  lenght = 0;
               int [] arrayOfVerseLenghts = new int[6236];
               int myArr[] = getCharacterIndexOfVerseHeaders();

               for (int i = 0; i < myArr.length ; i++)
               {
                   lenght = 0;
                   if (i == myArr.length -1) break;
                   lenght = myArr[i + 1] - myArr[ i ];
                   arrayOfVerseLenghts[i] = lenght;
               }
               //set last Verse Manually
               arrayOfVerseLenghts[6235] = 13;

               return arrayOfVerseLenghts;
           }

           public int getCharacterIndexForVerse(int verseNo)
           {
               verseNo -= 1;
               int[] characterIndexForVerseHeaders = getCharacterIndexOfVerseHeaders();
               return characterIndexForVerseHeaders[verseNo] + 1;
           }

           public int getVerseLenght(int verseNo)
           {
               verseNo -= 1;
               int [] verseLenghts = getCharacterLenghtOfAllVerses();
               return verseLenghts[verseNo];
           }

            public int mapReversedVerseIndexToNormal(int reverseVerseIndex)
            {
                int normalIndex = 0;

                //where is verse reversedIndexVerse in array allVersesWithoutSpacing?
                return normalIndex;

            }

            public int mapNormalVerseIndexToReversed (int normalVerseIndex)
            {
                int reversedIndex = 0;

                //where is verse normalVerseIndex in array allVersesWithoutSpacingReversed?
                return reversedIndex;
            }

           public String[] allVersesWithoutSpacingReversed()
           {
               int w = 0, m = 0;
               ArrayList<String> reversedAllVersesWithoutSpacing = new ArrayList();

               for(int q = 0; q < 114; q++)
               {

                   if(q >= 1)
                   {
                       w = reversedSumOfVerseHeaders[(q-1)] - reversedSumOfVerseHeaders[q];
                       m = reversedSumOfVerseHeaders[q];

                       for(int x = 0; x < w; x++)
                       {
                           reversedAllVersesWithoutSpacing.add(allVersesWithoutSpacing[m]);
                           m++;
                       }
                   }

                   if(q == 113)
                   {
                       m = 0;
                       for(int x = 0; x < 7; x++)
                       {
                           reversedAllVersesWithoutSpacing.add(allVersesWithoutSpacing[m]);
                           m++;
                       }
                   }

               }

               String[] allversesWithoutSpacingReversed = (String[]) reversedAllVersesWithoutSpacing.toArray();

               return allversesWithoutSpacingReversed;
           }


}

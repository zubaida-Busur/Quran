public class Test8 {

    public static void main(String[] args) {

        QuranData myQuran = new QuranData();

        int finding = 2746;
        System.out.printf("Character %S: Verse Index in quran :" + myQuran.getVerseForCharacterNo(finding) + "\nVerse No: "
                + myQuran.getVerseInChapter(myQuran.getVerseForCharacterNo(finding)) + " of Surah: "
                      + myQuran.getSurahName(myQuran.getVerseForCharacterNo(finding)), finding);

        System.out.println();


        //trial for func
        int arr[] = myQuran.getCharacterIndexOfVerseHeaders();
        int lenghts[] = myQuran.getCharacterLenghtOfAllVerses();

        int x , y , sum= 0;
        for (int i = 0; i < arr.length; i++)
        {
             x = arr[i] + 1;
             y = lenghts[i];
             sum += y;
            System.out.printf("Verse %S : " + x + " Lenght : " + y + " \n", i + 1);
        }
        System.out.println("Total Characters : " + sum);

        System.out.println("Verse 6236: " + myQuran.getVerseLenght(6236) + " : "+ myQuran.getCharacterIndexForVerse(6236));


        //trial for func
        int divisions[] = myQuran.getDivisionHeaderByVerse( 0.5,653,700);

        for (int r: divisions)
        {
            System.out.println( myQuran.getSurahName(r) + " : " +   myQuran.getVerseInChapter(r));
        }

  }

}

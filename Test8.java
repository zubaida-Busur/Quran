public class Test8 {

    public static void main(String[] args) {

        QuranData myQuran = new QuranData();

//        int finding = 2746;
//        System.out.printf("Character %S: Verse Index in quran :" + myQuran.getVerseForCharacterNo(finding) + "\nVerse No: "
//                + myQuran.getVerseInChapter(myQuran.getVerseForCharacterNo(finding)) + " of Surah: "
//                      + myQuran.getSurahName(myQuran.getVerseForCharacterNo(finding)), finding);
//
//        System.out.println();


        //trial for func
        int divisions[] = myQuran.getDivisionHeaderByVerse( 1.00,8,6201);

        int pages = 0;
        for (int r: divisions)
        {
            pages++;
            System.out.println( myQuran.getSurahName(r) + " : " +   myQuran.getVerseInChapter(r));
        }
        System.out.println("Pages : " + pages);

  }

}

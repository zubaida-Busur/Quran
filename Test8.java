public class Test8 {

    public static void main(String[] args) {

        QuranData myQuran = new QuranData();

        int finding = 330709;
        System.out.printf("Character %S: Verse Index in quran :" + myQuran.getVerseForCharacterNo(finding) + "\nVerse No: "
                + myQuran.getVerseInChapter(myQuran.getVerseForCharacterNo(finding)) + " of Surah: "
                + myQuran.getSurahName(myQuran.getVerseForCharacterNo(finding)), finding);



    }

}

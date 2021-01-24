public class Robot implements Brukergrensesnitt {

    @Override
    public void giStatus(String status){}


    //Velger et tilfeldig svar.
    @Override
    public int beOmKommando(String Spoersmaal, String[] alternativer) {
        return (int)(Math.random() * alternativer.length);
    }
    
}
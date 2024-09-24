public abstract class ConceptOfAbstraction {
      int wheel;
      static int seat=4;
      private int bealt;
    public abstract void drive();

    public ConceptOfAbstraction(int w)
    {
        this.wheel =w;
    }

    public void speedup(){
        System.out.println("car have geared up");
    }

    public void setBealt(int bealt){
        this.bealt=bealt;
    }
    public int getBealt()
    {
        return bealt;
    }
}

class NonAbstract extends ConceptOfAbstraction{
    public NonAbstract(int w) {
        super(w);
    }

    public static void main(String[] args) {

        NonAbstract nb = new NonAbstract(4);
      //  System.out.println(bealt);
        nb.speedup();
        System.out.println(ConceptOfAbstraction.seat);
        nb.drive();
        nb.setBealt(2);
        System.out.println("Bealt number : "+nb.getBealt());

    }


    @Override
    public void drive() {
        System.out.println("I am Driving ");
    }
}

package compruebatuaprendizaje;

public class Act1 extends Thread{
    public void run(){
        System.out.println(getName());
    }

    public static void main(String[] args) {
        Act1 h1 = null;
        for (int i = 0; i < 5; i++) {
            h1 = new Act1();
            h1.start();
        }
    }
}

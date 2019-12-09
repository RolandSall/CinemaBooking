public class testclass {
    public static void main(String[] args) {

        int seatnb = 200;
        int col = 0;
        int row = 0;
        int count=0;


        for (int i = 0; i < seatnb; i++) {


            row = i/20;
            col = i%20;
            count++;

            System.out.println(row + " " + col);
        }

        System.out.println(count);


    }
}

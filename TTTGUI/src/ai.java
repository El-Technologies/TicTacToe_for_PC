import java.util.Timer;
import java.util.TimerTask;

public class ai extends data{

    public static void AI(){

        Timer timer =  new Timer();
        timer.schedule(new TimerTask() { //a timer that delays the computer's input by .5 seconds
            @Override
            public void run() { // algorithms are run to decide the most appropriate input by the computer
                if (AIPlayO() != -1) N = AIPlayO();  //if the computer sees two Os, it completes it to win
                else if (AIPlayX() != -1) N = AIPlayX(); //if the computer sees two Xs, it stops you from winning
                else if ((AIPlayO() == -1) & (AIPlayX() == -1)) N = process.rand();
                //if neither of the above is noticed, the computer goes ahead to input a random input

                if (process.checkBox()) { //if the input is already occupied...
                    do { //it continues to input a random input until it plays a valid move
                        N = process.rand();
                        if (!process.checkBox()){
                            break;
                        }
                    } while (process.checkBox());

                }

                process.display(); //if the input is valid however, it plays it instead

            }
        }, 500); // delays by .5 seconds before playing its turn

    }

    public static int AIPlayO () {
        /*this method calls on the AICheckTwoOs to check if there are two Os on the board
        * if there is, it completes it and wins*/
        int a = AICheckTwoOs();
        switch (a){
            case 23, 47, 59 -> {
                return 1;
            }
            case 13, 58 -> {
                return 2;
            }
            case 12, 57, 69 -> {
                return 3;
            }
            case 17, 56 -> {
                return 4;
            }
            case 19, 28, 37, 46 -> {
                return 5;
            }
            case 39, 45 -> {
                return 6;
            }
            case 14, 35, 89 -> {
                return 7;
            }
            case 25, 79 -> {
                return 8;
            }
            case 15, 36, 78 -> {
                return 9;
            }
            default -> {
                return -1;
            }
        }
    }

    public static int AIPlayX () {
        /*this method calls on the AICheckTwoXs to check if there are two Xs on the board
         * if there is, it blocks you and stops you from winning*/
        int b = AICheckTwoXs();
        switch (b){
            case 23, 47, 59 -> {
                return 1;
            }
            case 13, 58 -> {
                return 2;
            }
            case 12, 57, 69 -> {
                return 3;
            }
            case 17, 56 -> {
                return 4;
            }
            case 19, 28, 37, 46 -> {
                return 5;
            }
            case 39, 45 -> {
                return 6;
            }
            case 14, 35, 89 -> {
                return 7;
            }
            case 25, 79 -> {
                return 8;
            }
            case 15, 36, 78 -> {
                return 9;
            }
            default -> {
                return -1;
            }
        }
    }

    public static int AICheckTwoOs() {
        /*this method checks if there are two Os on the board
         * if there is, it returns a number that represents the two spaces they occupy,
         * but it does this only if the third space is empty
         * if it isn't, it returns 0*/

        //cases with 1s
        if (One.getText() == "O" & Two.getText() == "O"){
            if (!three){
                return 12;
            }
        }
        if (One.getText() == "O" & Three.getText() == "O"){
            if (!two){
                return 13;
            }
        }
        if (One.getText() == "O" & Four.getText() == "O"){
            if (!seven){
                return 14;
            }
        }
        if (One.getText() == "O" & Five.getText() == "O"){
            if (!nine){
                return 15;
            }
        }
        if (One.getText() == "O" & Seven.getText() == "O"){
            if (!four){
                return 17;
            }
        }
        if (One.getText() == "O" & Nine.getText() == "O"){
            if (!five){
                return 19;
            }
        }

        //cases with 2s
        if (Two.getText() == "O" & Three.getText() == "O"){
            if (!one){
                return 23;
            }
        }
        if (Two.getText() == "O" & Five.getText() == "O"){
            if (!eight){
                return 25;
            }
        }
        if (Two.getText() == "O" & Eight.getText() == "O"){
            if (!five){
                return 28;
            }
        }

        //cases with 3s
        if (Three.getText() == "O" & Five.getText() == "O"){
            if (!seven){
                return 35;
            }
        }
        if (Three.getText() == "O" & Six.getText() == "O"){
            if (!nine){
                return 36;
            }
        }
        if (Three.getText() == "O" & Seven.getText() == "O"){
            if (!five){
                return 37;
            }
        }
        if (Three.getText() == "O" & Nine.getText() == "O"){
            if (!six){
                return 39;
            }
        }

        //cases with 4s
        if (Four.getText() == "O" & Five.getText() == "O"){
            if (!six){
                return 45;
            }
        }
        if (Four.getText() == "O" & Six.getText() == "O"){
            if (!five){
                return 46;
            }
        }
        if (Four.getText() == "O" & Seven.getText() == "O"){
            if (!one){
                return 47;
            }
        }

        //cases with 5s
        if (Five.getText() == "O" & Six.getText() == "O"){
            if (!four){
                return 56;
            }
        }
        if (Five.getText() == "O" & Seven.getText() == "O"){
            if (!three){
                return 57;
            }
        }
        if (Five.getText() == "O" & Eight.getText() == "O"){
            if (!two){
                return 58;
            }
        }
        if (Five.getText() == "O" & Nine.getText() == "O"){
            if (!one){
                return 59;
            }
        }

        //cases with 6s
        if (Six.getText() == "O" & Nine.getText() == "O"){
            if (!three){
                return 69;
            }
        }

        //cases with 7s
        if (Seven.getText() == "O" & Eight.getText() == "O"){
            if (!nine){
                return 78;
            }
        }
        if (Seven.getText() == "O" & Nine.getText() == "O"){
            if (!eight){
                return 79;
            }
        }

        //cases with 8s
        if (Eight.getText() == "O" & Nine.getText() == "O"){
            if (!seven){
                return 89;
            }
        }

        return 0;
    }

    public static int AICheckTwoXs() {
        /* just like the method above, this method checks if there are two Xs on the board
         * if there is, it returns a number that represents the two spaces they occupy,
         * but it does this only if the third space is empty
         * if it isn't, it returns 0*/
        //cases with 1s
        if (One.getText() == "X" & Two.getText() == "X"){
            if (!three){
                return 12;
            }
        }
        if (One.getText() == "X" & Three.getText() == "X"){
            if (!two){
                return 13;
            }
        }
        if (One.getText() == "X" & Four.getText() == "X"){
            if (!seven){
                return 14;
            }
        }
        if (One.getText() == "X" & Five.getText() == "X"){
            if (!nine){
                return 15;
            }
        }
        if (One.getText() == "X" & Seven.getText() == "X"){
            if (!four){
                return 17;
            }
        }
        if (One.getText() == "X" & Nine.getText() == "X"){
            if (!five){
                return 19;
            }
        }

        //cases with 2s
        if (Two.getText() == "X" & Three.getText() == "X"){
            if (!one){
                return 23;
            }
        }
        if (Two.getText() == "X" & Five.getText() == "X"){
            if (!eight){
                return 25;
            }
        }
        if (Two.getText() == "X" & Eight.getText() == "X"){
            if (!five){
                return 28;
            }
        }

        //cases with 3s
        if (Three.getText() == "X" & Five.getText() == "X"){
            if (!seven){
                return 35;
            }
        }
        if (Three.getText() == "X" & Six.getText() == "X"){
            if (!nine){
                return 36;
            }
        }
        if (Three.getText() == "X" & Seven.getText() == "X"){
            if (!five){
                return 37;
            }
        }
        if (Three.getText() == "X" & Nine.getText() == "X"){
            if (!six){
                return 39;
            }
        }

        //cases with 4s
        if (Four.getText() == "X" & Five.getText() == "X"){
            if (!six){
                return 45;
            }
        }
        if (Four.getText() == "X" & Six.getText() == "X"){
            if (!five){
                return 46;
            }
        }
        if (Four.getText() == "X" & Seven.getText() == "X"){
            if (!one){
                return 47;
            }
        }

        //cases with 5s
        if (Five.getText() == "X" & Six.getText() == "X"){
            if (!four){
                return 56;
            }
        }
        if (Five.getText() == "X" & Seven.getText() == "X"){
            if (!three){
                return 57;
            }
        }
        if (Five.getText() == "X" & Eight.getText() == "X"){
            if (!two){
                return 58;
            }
        }
        if (Five.getText() == "X" & Nine.getText() == "X"){
            if (!one){
                return 59;
            }
        }

        //cases with 6s
        if (Six.getText() == "X" & Nine.getText() == "X"){
            if (!three){
                return 69;
            }
        }

        //cases with 7s
        if (Seven.getText() == "X" & Eight.getText() == "X"){
            if (!nine){
                return 78;
            }
        }
        if (Seven.getText() == "X" & Nine.getText() == "X"){
            if (!eight){
                return 79;
            }
        }

        //cases with 8s
        if (Eight.getText() == "X" & Nine.getText() == "X"){
            if (!seven){
                return 89;
            }
        }
        return 0;
    }
}

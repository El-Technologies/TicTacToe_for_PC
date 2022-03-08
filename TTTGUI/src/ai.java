import java.util.Timer;
import java.util.TimerTask;

public class ai extends data{

    public static void AI(){

        Timer timer =  new Timer();
        timer.schedule(new TimerTask() { //a timer that delays the computer's input by .5 seconds
            @Override
            public void run() { // algorithms are run to decide the most appropriate input by the computer
                switch (level){
                    case 1 -> {
                        N = process.rand();

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
                    case 2 -> {
                        if (AIPlayO() != -1) N = AIPlayO();  //if the computer sees two Os, it completes it to win
                        else if (AIPlayX() != -1) N = AIPlayX(); //if the computer sees two Xs, it stops you from winning
                        else if ((AIPlayO() == -1) & (AIPlayX() == -1)) N = process.rand();
                        //if neither of the above is noticed, the computer goes ahead to input a random input

                        if (process.checkBox()) {
                            do {
                                N = process.rand();
                                if (!process.checkBox()){
                                    break;
                                }
                            } while (process.checkBox());

                        }

                        process.display();
                    }
                    case 3 -> {
                        if (AIPlayO() != -1) N = AIPlayO();  //if the computer sees two Os, it completes it to win
                        else if (AIPlayX() != -1) N = AIPlayX(); //if the computer sees two Xs, it stops you from winning
                        else {
                            if (rando){
                                do{
                                    randomStrategy = process.rand();
                                    if ((randomStrategy==1) | (randomStrategy==2) | (randomStrategy==3) |
                                            (randomStrategy==4) | (randomStrategy==5)){
                                        rando = false;
                                        break;
                                    }
                                } while (rando);
                            }

                            N = strategy();
                        }

                        if (N == 0) N = process.rand();

                        if (process.checkBox()) {
                            do {
                                N = process.rand();
                                if (!process.checkBox()){
                                    break;
                                }
                            } while (process.checkBox());

                        }

                        process.display();

                    }
                }


            }
        }, 500); // delays by .5 seconds before playing its turn

    }

    public static int strategy() {
        if (Five.getText() == "X" & !one & !three & !seven & !nine){
            do{
                randomX = process.rand();
                if ((randomX==1) | (randomX==3) | (randomX==7) |
                        (randomX==9)){
                    randx = false;
                    break;
                }
            } while (randx);
            return randomX;
        }
        switch (randomStrategy){
            case 1 -> {
                s = strategyOne();
                if (s != 0) return s;
            }
            case 2 -> {
                s = strategyTwo();
                if (s != 0) return s;
            }
            case 3 -> {
                s = strategyThree();
                if (s != 0) return s;
            }
            case 4 -> {
                s = strategyFour();
                if (s != 0) return s;
            }
            case 5 -> {
                s = strategyFive();
                if (s != 0) return s;
            }
        }

        return 0;
    }

    public static int strategyOne () {
        if (!one) return 1;
        if (One.getText() == "O"){

            if (Five.getText() == "X"){
                return 9;
            }


            if (Nine.getText() == "O"){
                if (!four & !seven & !eight){
                    return 7;
                }
                if (!two & !three & !six){
                    return 3;
                }
            }

            if (Two.getText() == "X" & !four & !six &!eight){
                if (!seven)
                return 7;
            }
            if (Four.getText() == "X" & !two & !six &!eight){
                if (!three)
                return 3;
            }
            if (Six.getText() == "X" & !four & !two &!eight){
                if (!nine)
                return 9;
            }
            if (Eight.getText() == "X" & !four & !six &!two){
                if (!seven)
                return 7;
            }

            if (Three.getText() == "X" & !seven & nine){
                if (!seven)
                return 7;
            }
            if (Seven.getText() == "X" & !three & nine){
                if (!three)
                return 3;
            }
            if (Nine.getText() == "X" & !seven & three){
                if (!five)
                return 5; //it may end in a draw in this case
            }

            if (Three.getText() == "O" & !five & !seven & !nine){
                return 5;
            }
            if (Seven.getText() == "O" & !five & !three & !nine){
                return 5;
            }

            if (Three.getText() == "O" & !five & !six & !nine){
                return 9;
            }
            if (Three.getText() == "O" & !five & !four & !seven){
                return 9;
            }
            if (Seven.getText() == "O" & !five & !eight & !nine){
                return 9;
            }
            if (Seven.getText() == "O" & !five & !two & !three){
                return 3;
            }

        }
        return 0;
    }

    public static int strategyTwo () {
        if (!three) return 3;
        if (Three.getText() == "O"){

            if (Five.getText() == "X"){
                return 7;
            }

            if (Seven.getText() == "O"){
                if (!one & !two & !four){
                    return 1;
                }
                if (!six & !eight & !nine){
                    return 9;
                }
            }

            if (Two.getText() == "X" & !four & !six & !eight){
                if (!nine)
                return 9;
            }
            if (Four.getText() == "X" & !two & !six & !eight){
                if (!one)
                return 1;
            }
            if (Six.getText() == "X" & !four & !two & !eight){
                if (!one)
                return 1;
            }
            if (Eight.getText() == "X" & !four & !six & !two){
                if (!nine)
                return 9;
            }

            if (One.getText() == "X" & !seven & !nine){
                if (!nine)
                return 9;
            }
            if (Seven.getText() == "X" & !one & !nine){
                if (!five)
                return 5; //it'll end in a draw in this case
            }
            if (Nine.getText() == "X" & !seven & !one){
                if (!one)
                return 1;
            }

            if (One.getText() == "O" & !five & !seven & !nine){
                return 5;
            }
            if (Nine.getText() == "O" & !five & !one & !seven){
                return 5;
            }

            if (Nine.getText() == "O" & !five & !eight & !seven){
                return 7;
            }
            if (Nine.getText() == "O" & !five & !two & !one){
                return 1;
            }

        }
        return 0;
    }

    public static int strategyThree () {
        if (!seven) return 7;
        if (Seven.getText() == "O"){

            if (Five.getText() == "X"){
                return 3;
            }

            if (Three.getText() == "O"){
                if (!one & !two & !four){
                    return 1;
                }
                if (!six & !eight & !nine){
                    return 9;
                }
            }

            if (Two.getText() == "X" & !four & !six & !eight){
                if (!one)
                return 1;
            }
            if (Four.getText() == "X" & !two & !six & !eight){
                if (!nine)
                return 9;
            }
            if (Six.getText() == "X" & !four & !two & !eight){
                if (!nine)
                return 9;
            }
            if (Eight.getText() == "X" & !four & !six & !two){
                if (!one)
                return 1;
            }

            if (One.getText() == "X" & !three & !nine){
                if (!nine)
                return 9;
            }
            if (Three.getText() == "X" & !one & !nine){
                if (!five)
                return 5; //it'll end in a draw in this case
            }
            if (Nine.getText() == "X" & !three & !one){
                if (!one)
                return 1;
            }

            if (One.getText() == "O" & !five & !three & !nine){
                return 5;
            }
            if (Nine.getText() == "O" & !five & !three & !one){
                return 5;
            }

            if (Nine.getText() == "O" & !five & !eight & !seven){
                return 7;
            }
            if (Nine.getText() == "O" & !five & !two & !one){
                return 1;
            }

        }
        return 0;
    }

    public static int strategyFour () {
        if (!nine) return 9;
        if (Nine.getText() == "O"){

            if (Five.getText() == "X"){
                return 1;
            }

            if (One.getText() == "O"){
                if (!two & !three & !six){
                    return 3;
                }
                if (!four & !seven & !eight){
                    return 7;
                }
            }

            if (Two.getText() == "X" & !four & !six & !eight){
                if (!three)
                return 3;
            }
            if (Four.getText() == "X" & !two & !six & !eight){
                if (!seven)
                return 7;
            }
            if (Six.getText() == "X" & !four & !two & !eight){
                if (!seven)
                return 7;
            }
            if (Eight.getText() == "X" & !four & !six & !two){
                if (!three)
                return 3;
            }

            if (Three.getText() == "O" & !five & !one & !seven){
                return 5;
            }
            if (Seven.getText() == "O" & !five & !three & !one){
                return 5;
            }

            if (Three.getText() == "O" & !five & !two & !one){
                return 1;
            }
            if (Three.getText() == "O" & !five & !seven & !eight){
                return 7;
            }
            if (Seven.getText() == "O" & !five & !one & !four){
                return 1;
            }
            if (Seven.getText() == "O" & !five & !three & !six){
                return 3;
            }

        }
        return 0;
    }

    public static int strategyFive () {
        if (!five) return 5;
        return 0;
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

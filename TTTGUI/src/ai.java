import java.util.Objects;
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

        if ((Objects.equals(One.getText(), "X") & !two & !three & !four & !five & !six & !seven & !eight & Objects.equals(Nine.getText(), "O")) |
                (Objects.equals(Three.getText(), "X") & !two & !one & !four & !five & !six & Objects.equals(Seven.getText(), "O") & !eight & !nine) |
                (Objects.equals(Seven.getText(), "X") & !two & Objects.equals(Three.getText(), "O") & !four & !five & !six & !one & !eight & !nine) |
                (Objects.equals(Nine.getText(), "X") & !two & !three & !four & !five & !six & !seven & !eight & Objects.equals(One.getText(), "O"))){
            return 5;
        }

        if (Objects.equals(Five.getText(), "X") & !one & !three & !seven & !nine){
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

        if (((Objects.equals(One.getText(), "X")) &
                (Objects.equals(Nine.getText(), "X")) &
                (Objects.equals(Five.getText(), "O")) & !two & !three & !four & !six & !seven & !eight)|

                ((Objects.equals(Three.getText(), "X")) &
                        (Objects.equals(Seven.getText(), "X")) &
                        (Objects.equals(Five.getText(), "O")) & !one & !two & !four & !six & !eight & !nine)){
            do{
                randoX = process.rand();
                if ((randoX==2) | (randoX==4) | (randoX==6) |
                        (randoX==8)){
                    ranx = false;
                    break;
                }
            } while (ranx);
            return randoX;
        }

        if ((Objects.equals(One.getText(), "X")) &
                (Objects.equals(Five.getText(), "X")) &
                (Objects.equals(Nine.getText(), "O")) & !two & !three & !four & !six & !seven & !eight){
            return 7;
        }

        if ((Objects.equals(One.getText(), "O")) &
                (Objects.equals(Five.getText(), "X")) &
                (Objects.equals(Nine.getText(), "X")) & !two & !three & !four & !six & !seven & !eight){
            return 3;
        }

        if ((Objects.equals(Three.getText(), "X")) &
                (Objects.equals(Five.getText(), "X")) &
                (Objects.equals(Seven.getText(), "O")) & !one & !two & !four & !six & !eight & !nine){
            return 9;
        }

        if ((Objects.equals(Three.getText(), "O")) &
                (Objects.equals(Five.getText(), "X")) &
                (Objects.equals(Seven.getText(), "X")) & !one & !two & !four & !six & !eight & !nine){
            return 1;
        }

        if ((Objects.equals(Five.getText(), "O")) &
                (Objects.equals(Nine.getText(), "X")) & !one & !two & !three & !four & !six & !seven & !eight){
            return 1;
        }
        if ((Objects.equals(Five.getText(), "O")) &
                (Objects.equals(Seven.getText(), "X")) & !one & !two & !three & !four & !six & !seven & !eight){
            return 3;
        }
        if ((Objects.equals(Five.getText(), "O")) &
                (Objects.equals(One.getText(), "X")) & !one & !two & !three & !four & !six & !seven & !eight){
            return 9;
        }
        if ((Objects.equals(Five.getText(), "O")) &
                (Objects.equals(Three.getText(), "X")) & !one & !two & !three & !four & !six & !seven & !eight){
            return 7;
        }

        if ((Objects.equals(One.getText(), "O")) &
                (Objects.equals(Five.getText(), "O")) &
                (Objects.equals(Nine.getText(), "X")) & !three & !seven){
            if (!two) return 3;
            if (!four) return 7;
        }
        if ((Objects.equals(Three.getText(), "O")) &
                (Objects.equals(Five.getText(), "O")) &
                (Objects.equals(Seven.getText(), "X")) & !one & !nine){
            if (!two) return 1;
            if (!six) return 9;
        }
        if ((Objects.equals(One.getText(), "X")) &
                (Objects.equals(Five.getText(), "O")) &
                (Objects.equals(Nine.getText(), "O")) & !three & !seven){
            if (!six) return 3;
            if (!eight) return 7;
        }
        if ((Objects.equals(Three.getText(), "X")) &
                (Objects.equals(Five.getText(), "O")) &
                (Objects.equals(Seven.getText(), "O")) & !one & !nine){
            if (!four) return 1;
            if (!eight) return 9;
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
        if (Objects.equals(One.getText(), "O")){

            if (Objects.equals(Five.getText(), "X")){
                return 9;
            }


            if (Objects.equals(Nine.getText(), "O")){
                if (!four & !seven & !eight){
                    return 7;
                }
                if (!two & !three & !six){
                    return 3;
                }
            }

            if (Objects.equals(Two.getText(), "X") & !four & !six &!eight){
                if (!seven)
                return 7;
            }
            if (Objects.equals(Four.getText(), "X") & !two & !six &!eight){
                if (!three)
                return 3;
            }
            if (Objects.equals(Six.getText(), "X") & !four & !two &!eight){
                if (!nine)
                return 9;
            }
            if (Objects.equals(Eight.getText(), "X") & !four & !six &!two){
                if (!seven)
                return 7;
            }

            if (Objects.equals(Three.getText(), "X") & !seven & nine){
                return 7;
            }
            if (Objects.equals(Seven.getText(), "X") & !three & nine){
                return 3;
            }
            if (Objects.equals(Nine.getText(), "X") & !seven & three){
                if (!five)
                return 5; //it may end in a draw in this case
            }

            if (Objects.equals(Three.getText(), "O") & !five & !seven & !nine){
                return 5;
            }
            if (Objects.equals(Seven.getText(), "O") & !five & !three & !nine){
                return 5;
            }

            if (Objects.equals(Three.getText(), "O") & !five & !six & !nine){
                return 9;
            }
            if (Objects.equals(Three.getText(), "O") & !five & !four & !seven){
                return 9;
            }
            if (Objects.equals(Seven.getText(), "O") & !five & !eight & !nine){
                return 9;
            }
            if (Objects.equals(Seven.getText(), "O") & !five & !two & !three){
                return 3;
            }

        }
        return 0;
    }

    public static int strategyTwo () {
        if (!three) return 3;
        if (Objects.equals(Three.getText(), "O")){

            if (Objects.equals(Five.getText(), "X")){
                return 7;
            }

            if (Objects.equals(Seven.getText(), "O")){
                if (!one & !two & !four){
                    return 1;
                }
                if (!six & !eight & !nine){
                    return 9;
                }
            }

            if (Objects.equals(Two.getText(), "X") & !four & !six & !eight){
                if (!nine)
                return 9;
            }
            if (Objects.equals(Four.getText(), "X") & !two & !six & !eight){
                if (!one)
                return 1;
            }
            if (Objects.equals(Six.getText(), "X") & !four & !two & !eight){
                if (!one)
                return 1;
            }
            if (Objects.equals(Eight.getText(), "X") & !four & !six & !two){
                if (!nine)
                return 9;
            }

            if (Objects.equals(One.getText(), "X") & !seven & !nine){
                return 9;
            }
            if (Objects.equals(Seven.getText(), "X") & !one & !nine){
                if (!five)
                return 5; //it'll end in a draw in this case
            }
            if (Objects.equals(Nine.getText(), "X") & !seven & !one){
                return 1;
            }

            if (Objects.equals(One.getText(), "O") & !five & !seven & !nine){
                return 5;
            }
            if (Objects.equals(Nine.getText(), "O") & !five & !one & !seven){
                return 5;
            }

            if (Objects.equals(Nine.getText(), "O") & !five & !eight & !seven){
                return 7;
            }
            if (Objects.equals(Nine.getText(), "O") & !five & !two & !one){
                return 1;
            }

        }
        return 0;
    }

    public static int strategyThree () {
        if (!seven) return 7;
        if (Objects.equals(Seven.getText(), "O")){

            if (Objects.equals(Five.getText(), "X")){
                return 3;
            }

            if (Objects.equals(Three.getText(), "O")){
                if (!one & !two & !four){
                    return 1;
                }
                if (!six & !eight & !nine){
                    return 9;
                }
            }

            if (Objects.equals(Two.getText(), "X") & !four & !six & !eight){
                if (!one)
                return 1;
            }
            if (Objects.equals(Four.getText(), "X") & !two & !six & !eight){
                if (!nine)
                return 9;
            }
            if (Objects.equals(Six.getText(), "X") & !four & !two & !eight){
                if (!nine)
                return 9;
            }
            if (Objects.equals(Eight.getText(), "X") & !four & !six & !two){
                if (!one)
                return 1;
            }

            if (Objects.equals(One.getText(), "X") & !three & !nine){
                return 9;
            }
            if (Objects.equals(Three.getText(), "X") & !one & !nine){
                if (!five)
                return 5; //it'll end in a draw in this case
            }
            if (Objects.equals(Nine.getText(), "X") & !three & !one){
                return 1;
            }

            if (Objects.equals(One.getText(), "O") & !five & !three & !nine){
                return 5;
            }
            if (Objects.equals(Nine.getText(), "O") & !five & !three & !one){
                return 5;
            }

            if (Objects.equals(Nine.getText(), "O") & !five & !eight & !seven){
                return 7;
            }
            if (Objects.equals(Nine.getText(), "O") & !five & !two & !one){
                return 1;
            }

        }
        return 0;
    }

    public static int strategyFour () {
        if (!nine) return 9;
        if (Objects.equals(Nine.getText(), "O")){

            if (Objects.equals(Five.getText(), "X")){
                return 1;
            }

            if (Objects.equals(One.getText(), "O")){
                if (!two & !three & !six){
                    return 3;
                }
                if (!four & !seven & !eight){
                    return 7;
                }
            }

            if (Objects.equals(Two.getText(), "X") & !four & !six & !eight){
                if (!three)
                return 3;
            }
            if (Objects.equals(Four.getText(), "X") & !two & !six & !eight){
                if (!seven)
                return 7;
            }
            if (Objects.equals(Six.getText(), "X") & !four & !two & !eight){
                if (!seven)
                return 7;
            }
            if (Objects.equals(Eight.getText(), "X") & !four & !six & !two){
                if (!three)
                return 3;
            }

            if (Objects.equals(Three.getText(), "O") & !five & !one & !seven){
                return 5;
            }
            if (Objects.equals(Seven.getText(), "O") & !five & !three & !one){
                return 5;
            }

            if (Objects.equals(Three.getText(), "O") & !five & !two & !one){
                return 1;
            }
            if (Objects.equals(Three.getText(), "O") & !five & !seven & !eight){
                return 7;
            }
            if (Objects.equals(Seven.getText(), "O") & !five & !one & !four){
                return 1;
            }
            if (Objects.equals(Seven.getText(), "O") & !five & !three & !six){
                return 3;
            }

        }
        return 0;
    }

    public static int strategyFive () {
        if ((Objects.equals(One.getText(), "X") & !two & !three & !four & !five & !six & !seven & !eight & !nine) |
                (Objects.equals(Three.getText(), "X") & !two & !one & !four & !five & !six & !seven & !eight & !nine) |
                (Objects.equals(Seven.getText(), "X") & !two & !three & !four & !five & !six & !one & !eight & !nine) |
                (Objects.equals(Nine.getText(), "X") & !two & !three & !four & !five & !six & !seven & !eight & !one)){
            return 5;
        }

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
        if (Objects.equals(One.getText(), "O") & Objects.equals(Two.getText(), "O")){
            if (!three){
                return 12;
            }
        }
        if (Objects.equals(One.getText(), "O") & Objects.equals(Three.getText(), "O")){
            if (!two){
                return 13;
            }
        }
        if (Objects.equals(One.getText(), "O") & Objects.equals(Four.getText(), "O")){
            if (!seven){
                return 14;
            }
        }
        if (Objects.equals(One.getText(), "O") & Objects.equals(Five.getText(), "O")){
            if (!nine){
                return 15;
            }
        }
        if (Objects.equals(One.getText(), "O") & Objects.equals(Seven.getText(), "O")){
            if (!four){
                return 17;
            }
        }
        if (Objects.equals(One.getText(), "O") & Objects.equals(Nine.getText(), "O")){
            if (!five){
                return 19;
            }
        }

        //cases with 2s
        if (Objects.equals(Two.getText(), "O") & Objects.equals(Three.getText(), "O")){
            if (!one){
                return 23;
            }
        }
        if (Objects.equals(Two.getText(), "O") & Objects.equals(Five.getText(), "O")){
            if (!eight){
                return 25;
            }
        }
        if (Objects.equals(Two.getText(), "O") & Objects.equals(Eight.getText(), "O")){
            if (!five){
                return 28;
            }
        }

        //cases with 3s
        if (Objects.equals(Three.getText(), "O") & Objects.equals(Five.getText(), "O")){
            if (!seven){
                return 35;
            }
        }
        if (Objects.equals(Three.getText(), "O") & Objects.equals(Six.getText(), "O")){
            if (!nine){
                return 36;
            }
        }
        if (Objects.equals(Three.getText(), "O") & Objects.equals(Seven.getText(), "O")){
            if (!five){
                return 37;
            }
        }
        if (Objects.equals(Three.getText(), "O") & Objects.equals(Nine.getText(), "O")){
            if (!six){
                return 39;
            }
        }

        //cases with 4s
        if (Objects.equals(Four.getText(), "O") & Objects.equals(Five.getText(), "O")){
            if (!six){
                return 45;
            }
        }
        if (Objects.equals(Four.getText(), "O") & Objects.equals(Six.getText(), "O")){
            if (!five){
                return 46;
            }
        }
        if (Objects.equals(Four.getText(), "O") & Objects.equals(Seven.getText(), "O")){
            if (!one){
                return 47;
            }
        }

        //cases with 5s
        if (Objects.equals(Five.getText(), "O") & Objects.equals(Six.getText(), "O")){
            if (!four){
                return 56;
            }
        }
        if (Objects.equals(Five.getText(), "O") & Objects.equals(Seven.getText(), "O")){
            if (!three){
                return 57;
            }
        }
        if (Objects.equals(Five.getText(), "O") & Objects.equals(Eight.getText(), "O")){
            if (!two){
                return 58;
            }
        }
        if (Objects.equals(Five.getText(), "O") & Objects.equals(Nine.getText(), "O")){
            if (!one){
                return 59;
            }
        }

        //cases with 6s
        if (Objects.equals(Six.getText(), "O") & Objects.equals(Nine.getText(), "O")){
            if (!three){
                return 69;
            }
        }

        //cases with 7s
        if (Objects.equals(Seven.getText(), "O") & Objects.equals(Eight.getText(), "O")){
            if (!nine){
                return 78;
            }
        }
        if (Objects.equals(Seven.getText(), "O") & Objects.equals(Nine.getText(), "O")){
            if (!eight){
                return 79;
            }
        }

        //cases with 8s
        if (Objects.equals(Eight.getText(), "O") & Objects.equals(Nine.getText(), "O")){
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
        if (Objects.equals(One.getText(), "X") & Objects.equals(Two.getText(), "X")){
            if (!three){
                return 12;
            }
        }
        if (Objects.equals(One.getText(), "X") & Objects.equals(Three.getText(), "X")){
            if (!two){
                return 13;
            }
        }
        if (Objects.equals(One.getText(), "X") & Objects.equals(Four.getText(), "X")){
            if (!seven){
                return 14;
            }
        }
        if (Objects.equals(One.getText(), "X") & Objects.equals(Five.getText(), "X")){
            if (!nine){
                return 15;
            }
        }
        if (Objects.equals(One.getText(), "X") & Objects.equals(Seven.getText(), "X")){
            if (!four){
                return 17;
            }
        }
        if (Objects.equals(One.getText(), "X") & Objects.equals(Nine.getText(), "X")){
            if (!five){
                return 19;
            }
        }

        //cases with 2s
        if (Objects.equals(Two.getText(), "X") & Objects.equals(Three.getText(), "X")){
            if (!one){
                return 23;
            }
        }
        if (Objects.equals(Two.getText(), "X") & Objects.equals(Five.getText(), "X")){
            if (!eight){
                return 25;
            }
        }
        if (Objects.equals(Two.getText(), "X") & Objects.equals(Eight.getText(), "X")){
            if (!five){
                return 28;
            }
        }

        //cases with 3s
        if (Objects.equals(Three.getText(), "X") & Objects.equals(Five.getText(), "X")){
            if (!seven){
                return 35;
            }
        }
        if (Objects.equals(Three.getText(), "X") & Objects.equals(Six.getText(), "X")){
            if (!nine){
                return 36;
            }
        }
        if (Objects.equals(Three.getText(), "X") & Objects.equals(Seven.getText(), "X")){
            if (!five){
                return 37;
            }
        }
        if (Objects.equals(Three.getText(), "X") & Objects.equals(Nine.getText(), "X")){
            if (!six){
                return 39;
            }
        }

        //cases with 4s
        if (Objects.equals(Four.getText(), "X") & Objects.equals(Five.getText(), "X")){
            if (!six){
                return 45;
            }
        }
        if (Objects.equals(Four.getText(), "X") & Objects.equals(Six.getText(), "X")){
            if (!five){
                return 46;
            }
        }
        if (Objects.equals(Four.getText(), "X") & Objects.equals(Seven.getText(), "X")){
            if (!one){
                return 47;
            }
        }

        //cases with 5s
        if (Objects.equals(Five.getText(), "X") & Objects.equals(Six.getText(), "X")){
            if (!four){
                return 56;
            }
        }
        if (Objects.equals(Five.getText(), "X") & Objects.equals(Seven.getText(), "X")){
            if (!three){
                return 57;
            }
        }
        if (Objects.equals(Five.getText(), "X") & Objects.equals(Eight.getText(), "X")){
            if (!two){
                return 58;
            }
        }
        if (Objects.equals(Five.getText(), "X") & Objects.equals(Nine.getText(), "X")){
            if (!one){
                return 59;
            }
        }

        //cases with 6s
        if (Objects.equals(Six.getText(), "X") & Objects.equals(Nine.getText(), "X")){
            if (!three){
                return 69;
            }
        }

        //cases with 7s
        if (Objects.equals(Seven.getText(), "X") & Objects.equals(Eight.getText(), "X")){
            if (!nine){
                return 78;
            }
        }
        if (Objects.equals(Seven.getText(), "X") & Objects.equals(Nine.getText(), "X")){
            if (!eight){
                return 79;
            }
        }

        //cases with 8s
        if (Objects.equals(Eight.getText(), "X") & Objects.equals(Nine.getText(), "X")){
            if (!seven){
                return 89;
            }
        }
        return 0;
    }
}
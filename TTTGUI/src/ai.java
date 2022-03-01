import java.util.Timer;
import java.util.TimerTask;

public class ai extends data{

    public static void AI(){

        Timer timer =  new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (AIPlayO() != -1) N = AIPlayO();
                else if (AIPlayX() != -1) N = AIPlayX();
                else if ((AIPlayO() == -1) & (AIPlayX() == -1)) N = process.rand();

                System.out.println("Computer plays: " + N);

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
        }, 500);

    }

    public static int AIPlayO () {
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

    public static int AICheckTwoXs() {
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
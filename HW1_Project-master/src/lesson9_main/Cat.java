package lesson9_main;

public class Cat implements Competitor {

    int MAX_RUN;
    int MAX_JUMP;
    boolean isFailed;

    public Cat(int MAX_RUN, int MAX_JUMP) {
        this.MAX_RUN = MAX_RUN;
        this.MAX_JUMP = MAX_JUMP;
        isFailed = false;
    }

    public int getMAX_RUN() {
        return MAX_RUN;
    }

    public int getMAX_JUMP() {
        return MAX_JUMP;
    }

    @Override
    public boolean isFailed() {
        return isFailed;
    }

    @Override
    public String toString() {
        return ("Cat " + " " + this.MAX_RUN + " " + this.MAX_JUMP);
    }

    @Override
    public boolean run(Let let) {
        if (isFailed) {
            return false;
        }
        if (let.getMaxValue() > MAX_RUN) {
            System.out.println("Cat(" + MAX_RUN + ";" + MAX_JUMP + ") is failed...-> " + let.toString());
            isFailed = true;
            return false;
        }
        System.out.println("Cat is running!");
        return true;
    }

    @Override
    public boolean jump(Let let) {
        if (isFailed) {
            return false;
        }
        if (let.getMaxValue() > MAX_JUMP) {
            System.out.println("Cat(" + MAX_RUN + ";" + MAX_JUMP + ") is failed...-> " + let.toString());
            isFailed = true;
            return false;
        }
        System.out.println("Cat is jumping!");
        return true;
    }
}

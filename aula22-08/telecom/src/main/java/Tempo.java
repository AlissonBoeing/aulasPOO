public class Tempo {

    private int h = 00;
    private int m = 00;
    private int s = 00;


    public Tempo() {
        h = 00;
        m = 00;
        s = 00;
    }

    public Tempo(int hp) {
        if (hp > 24 || hp < 1) {
            h = 00;
            m = 00;
            s = 00;
        } else {
            h = hp;
            m = 00;
            s = 00;
        }
    }

    public Tempo(int hp, int mp) {
        if (hp > 24 || hp < 1 || mp <0 || mp > 59) {
            h = 00;
            m = 00;
            s = 00;
        } else {
            h = hp;
            m = mp;
            s = 00;
        }
    }

    public Tempo(int hp, int mp, int sp) {
        if (hp > 24 || hp < 1 || mp <0 || mp > 59 || s<0 || s>59) {
            h = 00;
            m = 00;
            s = 00;
        } else {
            h = hp;
            m = mp;
            s = sp;
        }
    }

    public String toString() {
        if (h == 0) {

        }
        return h + ":" + m + ":" + s;

    }

    public long retLong() {

        long a = s + (m*60) + (h*360);
        return a;
    }

    public boolean altHora(int hp) {
        if (hp > 24 || hp < 1) {
            return false;
        } else {
            h = hp;
            return true;
        }
    }

    public boolean altMin(int mp) {
        if (mp < 0 || mp > 59) {
            return false;
        } else {
            m = mp;
            return true;
        }
    }

    public boolean altSeg(int sp) {
        if (sp < 0 || sp > 59) {
            return false;
        } else {
            s = sp;
            return true;
        }
    }


}


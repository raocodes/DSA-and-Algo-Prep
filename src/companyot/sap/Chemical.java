package companyot.sap;

public class Chemical {
    public static int maxEnergy(int[] ener) {
        if (ener.length < 2) {
            return 0;
        }

        if (ener.length == 2) {
            return ener[0] + ener[1];
        }

        int maxneg = Integer.MAX_VALUE;
        int sndmaxneg = Integer.MAX_VALUE;
        int maxpos = Integer.MIN_VALUE;
        int sndmaxpos = Integer.MIN_VALUE;

        for (int i = 0; i < ener.length; i++) {
            if (ener[i] > maxpos) {
                sndmaxpos = maxpos;
                maxpos = ener[i];
            } else if (ener[i] > sndmaxpos) {
                sndmaxpos = ener[i];
            }

            if (ener[i] < 0 && ener[i] < maxneg) {
                sndmaxneg = maxneg;
                maxneg = ener[i];
            } else if (ener[i] < 0 && ener[i] < sndmaxneg) {
                sndmaxneg = ener[i];
            }
        }

        int result;
        if (sndmaxpos * maxpos < sndmaxneg * maxneg) {
            result = sndmaxneg + maxneg;
        } else {
            result = sndmaxpos + maxpos;
        }

        return result;
    }
}

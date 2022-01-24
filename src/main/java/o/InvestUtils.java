package o;

public class InvestUtils {

    public static boolean isTimeOut = false;

    public static boolean getIsTimeOut() {
        synchronized (InvestUtils.class) {
            return isTimeOut;
        }
    }

    public static void setIsTimeOut(boolean isTimeOut) {
        synchronized (InvestUtils.class) {
            InvestUtils.isTimeOut = isTimeOut;
        }
    }
}

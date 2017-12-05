import java.util.*;

public class Disk {
    private int crossSingleTime = -1;               //跨越单个磁道所用时间    ms
    private int startTime = -1;                     //启动时间              ms
    private int RPM = -1;                           //转速                 转/分钟
    private int sectionPerTrack = -1;               //每磁道扇区数
    private int bytePerSection  = -1;               //每扇区字节数
    private int bytePerTime = -1;                   //每次读取/写入字节数

    private int moveDirection = -1;              //磁头移动方向
    private int currentTrack = -1;                  //当前磁道号
    private Vector<Integer> requestQueue = null; //请求访问队列

    public Disk(){

    }
    public Vector<Integer> getRequestQueue(){
        return requestQueue;
    }

    public int getBytePerTime() {
        return bytePerTime;
    }

    public int getCrossSingleTime() {
        return crossSingleTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getRPM() {
        return RPM;
    }

    public int getSectionPerTrack() {
        return sectionPerTrack;
    }

    public int getBytePerSection() {
        return bytePerSection;
    }

    public int getMoveDirection() {
        return moveDirection;
    }

    public int getCurrentTrack() {
        return currentTrack;
    }
}

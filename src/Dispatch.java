import java.util.*;

public abstract class Dispatch {
    private Vector<Integer> requestQueue = null;    //请求访问队列
    private Vector<Integer> serveQueue = null;      //服务访问队列

    private Disk myDisk;                            //所操作的磁盘

    private int armMovement = -1;                   //磁臂移动量
    private int seekTime = -1;                      //寻道时间
    private int aveDelay = -1;                      //平均旋转延时
    private int transTime = -1;                     //传输时间
    private int totalProcessTime = -1;              //所有访问处理时间

    /** 构造函数 **/
    public Dispatch(Disk disk){
        this.myDisk = disk;
        this.requestQueue = disk.getRequestQueue();
    }

    /** 磁臂移动量 **/
    public void setArmMovement(int armMv){
        this.armMovement = armMv;
    }

    public int getArmMovement(){
        return armMovement;
    }

    /** 寻道时间 **/
    public void setSeekTime(int seekTm){
        this.seekTime = seekTm;
    }

    public int getSeekTime(){
        return seekTime;
    }

    /** 平均旋转延时 **/
    public void setAveDelay(int aveDy){
        this.aveDelay = aveDy;
    }

    public int getAveDelay() {
        return aveDelay;
    }

    /** 传输时间 **/
    public void setTransTime(int transTm){
        this.transTime = transTm;
    }

    public int getTransTime() {
        return transTime;
    }

    /** 所有访问处理时间 **/
    public void setTotalProcessTime(int totalPtm){
        this.totalProcessTime = totalPtm;
    }

    public int getTotalProcessTime() {
        return totalProcessTime;
    }

    /** 服务访问队列**/
    public abstract Vector<Integer> getServeQueue();

    public void setRequestQueue(Vector<Integer> queue){
        this.requestQueue = queue;
    }

    /** 返回各项数据计算结果**/
    public abstract Vector<Integer> getCalculateResult();

}

import java.util.*;

import static java.lang.Math.abs;

public abstract class Dispatch {
    private Vector<Integer> requestQueue = new Vector<Integer>();    //请求访问队列
    private Vector<Integer> serveQueue = new Vector<Integer>();      //服务访问队列

    public Disk myDisk;                            //所操作的磁盘

    private int armMovement = -1;                   //磁臂移动总量
    private Vector<Integer> armPerMove = new Vector<Integer>();     //磁臂移动量序列
    private int seekTime = -1;                      //寻道时间
    private int aveDelay = -1;                      //平均旋转延时
    private int transTime = -1;                     //传输时间
    private int totalProcessTime = -1;              //所有访问处理时间

    /** 构造函数 **/
    public Dispatch(Disk disk){
        this.myDisk = disk;
        this.requestQueue = disk.getRequestQueue();
    }
    /**  磁臂移动量序列 **/
    public void setArmPerMove(Vector<Integer> armPerMove) {
        this.armPerMove = armPerMove;
    }



    /** 获取请求服务队列 **/
    public Vector<Integer> getRequestQueue(){
        return requestQueue;
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
    public Vector<Integer> getServeQueue(){
        return serveQueue;
    }

    public void setServeQueue(Vector<Integer> serveQue) {
        this.serveQueue = serveQue;
    }


    /** 返回各项数据计算结果**/
    public void CalculateTime(){
        /** 计算寻道时间 **/
        int seekTime = myDisk.getStartTime() + getArmMovement()*myDisk.getCrossSingleTime();
        setSeekTime(seekTime);

        /** 计算平均旋转延时 **/
        int aveDelay = 1/(2*myDisk.getRPM());
        setAveDelay(aveDelay);

        /** 计算传输时间 **/
        int transTime = myDisk.getBytePerTime()/(myDisk.getRPM()*myDisk.getBytePerSection());
        setTransTime(transTime);

        /** 计算所有访问处理时间 **/
        int totalTime = seekTime + aveDelay + transTime;
        setTotalProcessTime(totalTime);
    }
    /** 计算磁臂移动量序列 和 磁臂移动总量 **/
    public void CalculateResult() {
        Vector<Integer> tempQue = getServeQueue();

        Vector<Integer> armPmv = null;
        int SIZE = tempQue.size();
        int SUM = 0;
        int initCost = abs(tempQue.get(0) - myDisk.getCurrentTrack());
        armPmv.add(initCost);
        SUM+=initCost;
        for (int i = 1; i < SIZE; ++i) {
            for (int j = 0; j < SIZE-1; ++j) {
                int cost = abs(tempQue.get(i) - tempQue.get(j));
                armPmv.add(cost);
                SUM+=cost;
            }
        }
        setArmMovement(SUM);
        setArmPerMove(armPmv);
    }

    public abstract void figureServeQueue();


}

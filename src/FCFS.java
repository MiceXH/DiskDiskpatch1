import java.util.Vector;
import static java.lang.Math.abs;

public class FCFS extends Dispatch {
    public FCFS(Disk disk1) {
        super(disk1);
    }

    /**
     * 计算磁臂移动量序列 和 磁臂移动总量
     **/
    @Override
    public void figureServeQueue() {
        Vector<Integer> que = getRequestQueue();
        setServeQueue(que);
    }







}

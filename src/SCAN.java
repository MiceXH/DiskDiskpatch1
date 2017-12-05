import java.util.Collections;
import java.util.Vector;

public class SCAN extends Dispatch{
    /**
     * 构造函数
     *
     * @param disk
     **/
    public SCAN(Disk disk) {
        super(disk);
    }

    @Override
    public void figureServeQueue() {
        Vector<Integer> requestQue = getRequestQueue();
        Vector<Integer> serveQue = new Vector<Integer>();
        int currentTrack = myDisk.getCurrentTrack();

        Collections.sort(requestQue);



    }
}

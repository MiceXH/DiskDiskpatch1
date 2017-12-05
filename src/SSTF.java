import java.util.Vector;
import static java.lang.Math.abs;

public class SSTF extends Dispatch{
    /**
     * 构造函数
     *
     * @param disk
     **/
    public SSTF(Disk disk) {
        super(disk);
    }

    /**
     * 服务访问队列
     **/
    @Override
    public void figureServeQueue(){
        Vector<Integer> requestQue = getRequestQueue();
        Vector<Integer> serveQue = new Vector<Integer>();
        int currentTrack = myDisk.getCurrentTrack();

        int i = 0;
        int Size = requestQue.size();
        while( i<Size ){
            int cost = abs(requestQue.get(0) - currentTrack);
            int track = requestQue.get(0);
            int index = -1;
            for (int j = 1; j < requestQue.size(); ++j) {
                int c = abs(currentTrack - requestQue.get(j));
                if (c < cost) {
                    cost = c;
                    track = requestQue.get(j);
                    index = j;
                }
            }
            currentTrack = track;
            serveQue.add(track);
            requestQue.remove(index);
            i++;
        }



    }


}

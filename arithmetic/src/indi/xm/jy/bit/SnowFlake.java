package indi.xm.jy.bit;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.bit
 * @ClassName: SnowFlake
 * @Author: albert.fang
 * @Description: 雪花算法
 * @Date: 2022/2/24 22:22
 */
public class SnowFlake {



    public static final int ROOM_LEN = 5;

    public static final int COMPUTER_LEN = 5;

    public static final int SEQ_LEN = 12;


    public static final int SEQ_MAX_VALUE = (1 << SEQ_LEN) - 1;

    public static final int COMPUTER_MAX_VALUE = (1 << COMPUTER_LEN) - 1;

    public static final int ROOM_MAX_VALUE = (1 << ROOM_LEN) - 1;


    public static final int MILLIS_LEFT_LEN = SEQ_LEN + COMPUTER_LEN + ROOM_LEN;

    public static final int ROOM_LEFT_LEN = SEQ_LEN + COMPUTER_LEN;

    public static final int COMPUTER_LEFT_LEN = SEQ_LEN;

    private long millis = 0L;

    private int seq = 0;

    private long roomId;

    private long computerId;

    private long lastMillis = 0;


    public SnowFlake(long roomId,long computerId){
        if (roomId > ROOM_MAX_VALUE || roomId < 0){
            throw new IllegalArgumentException("机房号不合法");
        }
        if (computerId > COMPUTER_MAX_VALUE || computerId < 0){
            throw new IllegalArgumentException("机器号不合法");
        }
        this.roomId = roomId;
        this.computerId = computerId;
    }

    private long getNextMillis(){
        long millis = System.currentTimeMillis();
        while (millis <= lastMillis){
            millis = System.currentTimeMillis();
        }
        return millis;
    }

    public long getNextSeqId(){
        long curMillis = System.currentTimeMillis();
        if (curMillis > lastMillis){
            seq = 0;
            millis = curMillis;
        }else {
            seq = seq + 1;
            // 同一毫秒已经生成了4096个序列了
            // 强制让其等待下一个毫秒再生成序列
            if ((seq & SEQ_MAX_VALUE) == 0){
                millis = getNextMillis();
                seq = 0;
            }
        }
        lastMillis = millis;
        return seq | (computerId << COMPUTER_LEFT_LEN)
                | (roomId << ROOM_LEFT_LEN)
                | (millis << MILLIS_LEFT_LEN);
    }

    public static void main(String[] args) {
        SnowFlake snowFlake = new SnowFlake(4, 3);
        for (int i = 0; i < 16; i++) {
            System.out.println(snowFlake.getNextSeqId());
        }
    }

}

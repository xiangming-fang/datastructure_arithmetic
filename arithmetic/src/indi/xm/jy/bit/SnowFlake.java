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


    // 用5位表示机房号
    public static final int ROOM_LEN = 5;

    // 用5位表示电脑号
    public static final int COMPUTER_LEN = 5;

    // 用12位表示序列号
    public static final int SEQ_LEN = 12;

    // 序列最大表示值
    public static final int SEQ_MAX_VALUE = (1 << SEQ_LEN) - 1;

    // 电脑号最大表示值
    public static final int COMPUTER_MAX_VALUE = (1 << COMPUTER_LEN) - 1;

    // 机房最大表示值
    public static final int ROOM_MAX_VALUE = (1 << ROOM_LEN) - 1;

    // 毫秒级别41位表示需要往左移动几位
    public static final int MILLIS_LEFT_LEN = SEQ_LEN + COMPUTER_LEN + ROOM_LEN;

    // 机房号需要往左移动几位
    public static final int ROOM_LEFT_LEN = SEQ_LEN + COMPUTER_LEN;

    // 电脑号需要往左移动几位
    public static final int COMPUTER_LEFT_LEN = SEQ_LEN;

    // 当前的毫秒
    private long millis = 0L;

    // 每一毫秒都从序列0开始
    private int seq = 0;

    // 房间号
    private long roomId;

    // 电脑号
    private long computerId;

    // 上一秒的时间表示
    private long lastMillis = 0;


    // 雪花算法的构造函数
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

    // 得到下一毫秒
    private long getNextMillis(){
        long millis = System.currentTimeMillis();
        // 注意这里要强制性获取到下一毫秒
        while (millis <= lastMillis){
            millis = System.currentTimeMillis();
        }
        return millis;
    }

    // 对外调用的方案，核心实现
    public long getNextSeqId(){
        // 获取当前毫秒级时间戳
        long curMillis = System.currentTimeMillis();
        // 如果当前进来的时间戳大于之前保留的时间戳，那么在逻辑区里重置序列号为0
        if (curMillis > lastMillis){
            seq = 0;
            millis = curMillis;
        }
        // 如果当前进来的时间戳等于之前保留的时间戳，那么在逻辑区里是对序列号的操作
        else {
            // 序列号 + 1
            seq = seq + 1;
            // 同一毫秒已经生成了4096个序列了
            // 强制让其等待下一个毫秒再生成序列
            if ((seq & SEQ_MAX_VALUE) == 0){
                millis = getNextMillis();
                // 下一个毫秒级别的时间戳了，那么序列号重置为0，重新开始
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

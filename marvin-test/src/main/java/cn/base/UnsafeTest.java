package cn.base;

/**
 * @Author : bingo
 * @category : compareAndSet
 * @Date : 2018/5/14 14:53
 **/

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicLong;

public class UnsafeTest {
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final long valueOffset;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset(AtomicLong.class.getDeclaredField("value"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    public final boolean compareAndSet(long expect, long update) {
        return unsafe.compareAndSwapLong(this, valueOffset, expect, update);
    }

}

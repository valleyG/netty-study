package com.mysit.study.nettyimpclass;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

public class ByteBufClass {
    public static void main(String[] args) {
        Charset utf8 = Charset.forName("UTF-8");

        ByteBuf byteBuf = Unpooled.copiedBuffer("Netty in Action rocks！", utf8);
        ByteBuf sliceBuf = byteBuf.slice(0, 15);
        System.out.println(sliceBuf.toString(utf8));

        byteBuf.setByte(0,(byte)'~');
        System.out.println(sliceBuf.toString(utf8));

    }
}

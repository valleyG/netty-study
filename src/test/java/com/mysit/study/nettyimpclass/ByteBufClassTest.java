package com.mysit.study.nettyimpclass;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import org.junit.Test;

import java.nio.charset.Charset;

public class ByteBufClassTest {

    @Test
    public void test(){
        Charset utf8 = CharsetUtil.UTF_8;
        ByteBuf byteBuf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);
        ByteBuf copy = byteBuf.copy(0, 15);
        System.out.println(copy.toString(utf8));
        byteBuf.setByte(0,'A');
        System.out.println(byteBuf.toString(utf8));
        assert byteBuf.getByte(0) != copy.getByte(0);
    }

}
package com.rj.bd.HuToolTest;

import cn.hutool.core.io.LineHandler;
import cn.hutool.core.lang.Console;

/**
 * 命令行打印的行处理器
 * 
 * @author looly
 * @since 4.5.2
 */
public class ConsoleLineHandler implements LineHandler {
    @Override
    public void handle(String line) {
        Console.log(line);
    }
}
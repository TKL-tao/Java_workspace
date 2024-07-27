package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OpenAIClient {
    public static void main(String[] args) {
        // Python脚本路径
        String pythonScriptPath = "my-maven-project\\src\\main\\python\\gpt4o.py";
        
        // 参数
        String param1 = "Hello";
        String param2 = "World";
        
        // 构建命令
        ProcessBuilder processBuilder = new ProcessBuilder("python", pythonScriptPath, param1, param2);
        
        try {
            // 启动进程
            Process process = processBuilder.start();
            
            // 获取进程的输出
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            // 等待进程结束并获取退出码
            int exitCode = process.waitFor();
            System.out.println("Exited with code: " + exitCode);
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.sustc.data.model;

import com.sustc.data.service.CargoFileService;
import com.sustc.data.service.impl.CargoFileServiceimpl;
import com.sustc.data.utils.CargoFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.PrivateKey;
import java.util.Date;

//@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-context-druid.xml","classpath:spring-context-mybatis.xml"})
public class Server {
//    @Autowired
//    private CargoFileService cargoFileService = new CargoFileServiceimpl();

    public static void main(String[] args) {
        testThread thread = new testThread();
        thread.start();
    }

    static class testThread extends Thread{
        private static ApplicationContext ctx = null;
        private static CargoFileService cargoFileService;
        static {
            ctx = new ClassPathXmlApplicationContext("classpath:spring-context.xml","classpath:spring-context-druid.xml","classpath:spring-context-mybatis.xml");
            cargoFileService = (CargoFileService) ctx.getBean("cargoFileService");
        }
        @Override
        public void run() {
            try {
                ServerSocket serverSocket  = new ServerSocket(9991);
                System.out.println("服务器上线");
                System.out.println(InetAddress.getLocalHost().getHostAddress());
                Util util = new Util();
                while(true){
                    Socket socket = serverSocket.accept();
                    InputStream input = socket.getInputStream();
                    int len;
                    byte[] bytes = new byte[1024];
                    StringBuilder sb = new StringBuilder();
                    while ((len = input.read(bytes)) != -1) {
                        sb.append(new String(bytes,0,len));
                    }
//                    System.out.println("收到的信息为：" + sb);
                    System.out.println(XmlToBeanUtil.xmlToBean(new String(sb)).get(0).getEpc());
                    //每当接收到个report的xml就生成一个report的对象
                    ECReport newECReport = XmlToBeanUtil.xmlToBean1(new String(sb));

                    for(Member member:newECReport.getMemberList()){
                        if(cargoFileService.search(member.getEpc()) == null)
                            cargoFileService.insert(new CargoFile(new Date(),new Date(),member.getEpc(),member.getRawHex(),member.getRawDecimal()));
                    }
                    input.close();
                    socket.close();
                    System.out.println("end");
                }
            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
            }
        }
    }
}


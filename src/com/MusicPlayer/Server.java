package com.MusicPlayer;
/*
 * 建立服务器端
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Server {
	ServerSocket ss;//服务器端的对象
	Set<Socket> allSocket;//创建一个存用户对象的Set集合
//无参构造方法
	public Server() {
		int i=0;
	  try {
		ss=new ServerSocket();//实例化服务器对象
		ss.bind(new InetSocketAddress("192.168.43.17",8888));//绑定指定IP和指定端口号
		allSocket=new HashSet<Socket>();//实例化存集合的对象
		while(true) {
	    System.out.println("服务器已经启动");
		Socket s=ss.accept();//服务器端监听是否有用户端的连接请求(没有的请求就一直保持监听状态即阻塞状态)
		allSocket.add(s);//将创建的用户对象存到Set集合中
		i++;
		System.out.println(i+"个客户端连接成功");
		new ServerThread(s).start();//一个用户启动一个线程负责
		}
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
//使用内部类的方法创建接受用户写入的线程
class ServerThread extends Thread{
	private Socket s;
	private BufferedReader br;
	public ServerThread(Socket s) {
		super();
		this.setS(s);
	try {
		br=new BufferedReader(new InputStreamReader(s.getInputStream()));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	public Socket getS() {
		return s;
	}
	public void setS(Socket s) {
		this.s = s;
	}
	@Override
	public void run() {
    //实现读取发送消息的功能
	try {
		while(true) {
		String str=br.readLine();
		if(str.indexOf("%EXIT%")==0) {
			allSocket.remove(s);
			s.close();
			break;
		}
//		System.out.println(str);//测试服务器是否接受到用户发送的信息
		sendMessageClient(str);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	//服务器接受的信息发送出去
	public void sendMessageClient(String mess) {
		Date date=new Date();
		//使用增强型for将Set集合中的Socket对象遍历出来
		for(Socket s:allSocket) {
			try {
				PrintWriter pw = new PrintWriter(s.getOutputStream());
				pw.println(mess+"\t["+date+"]");//内容和日期拼接在一起
				pw.flush();//将信息及时发送出去
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}

}


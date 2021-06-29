package com.MusicPlayer;
/*
 * 建立用户端
 */
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client {
JFrame jf;//对话窗体
JTextArea jt;//显示聊天内容的文本域
JTextField jtf;//输入信息的文本框
JLabel jl;//姓名标签
JButton jb;//发送按钮
JScrollPane js;//滚动条
JPanel jp1;//容器1
String name;//用户名
Socket s;//创建用户对象
PrintWriter pw;//输出流
BufferedReader br;
public Client() {
	jf=new JFrame("听友树洞1.0");
	do {
//		String IP=JOptionPane.showInputDialog(jf,"请输入服务器的地址:");//窗体之上添加一个输入IP
//		int Port=Integer.parseInt(JOptionPane.showInputDialog(jf,"请输入端口号:"));//在窗体之上添加一个输入端口号(String to Int)
		try {
		s=new Socket("192.168.43.17",8888);//创建一个用户将此用户连接请求与指定IP和端口号
		pw=new PrintWriter(s.getOutputStream());//输出流
		br=new BufferedReader(new InputStreamReader(s.getInputStream()));//写入流
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}while(s==null);
	jt=new JTextArea(20,30);//设置文本与大小
	jtf=new JTextField(28);//设置文本框大小
	jb=new JButton("发送");//初始化按钮
	js=new JScrollPane(jt);//组合形成滚动面板
	jp1=new JPanel();//初始化容器
	
	jt.setFont(new Font("宋体",Font.PLAIN,20));//设置文本域字体属性
//	jt.setEditable(false);//设置文本域不可更改
	name=JOptionPane.showInputDialog(jf, "请输入用户昵称:");//在窗体之上建立一个输入框(用户名)
	jl=new JLabel(name+":");//将用户名显示到标签上
	
	jf.add(js,BorderLayout.CENTER);//将组合形成的滚动面板放置到窗体的中间位置
	jf.add(jp1,BorderLayout.SOUTH);	//将容器1放置到窗体的南位置
	jp1.add(jl);//标签放到容器1
	jp1.add(jtf);//文本框
	jp1.add(jb);//发送按钮
	//给发送按键添加事件监听器
	jb.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(jtf.getText().equals("")) {//判断发送的消息是否为空
				JOptionPane.showMessageDialog(jf, "不能发送空消息！");//窗体之上显示一个提示信息
			 return;
			}
			pw.println(name+":"+jtf.getText());//将用户名与发送的内容拼接
			pw.flush();//将消息及时发送出去
			jtf.setText("");//清空发送文本框
		}
	});
	//给窗体添加事件监听器
	jf.addWindowListener(new WindowAdapter() {

		@Override
		public void windowClosing(WindowEvent e) {
			int op=JOptionPane.showConfirmDialog(jf, "确认退出听友树洞？");
			if(op==JOptionPane.YES_OPTION) {
				pw.println("%EXIT%"+name);
				pw.flush();
				try {
					s.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				MusicInterface.open1=false;
				jf.setDefaultCloseOperation(2);
			}
		}
		
	});
	show();
	new ReadThread().start();//启动线程(用专门负责读取服务器消息的线程来完成)
}



//窗体相关设置
public void show(){
	jf.pack();//自动适应窗体大小
	jf.setLocation(400, 150);//窗体在桌面显示的位置
	jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//关闭窗体无任何反应
	jf.setResizable(false);//设置不能调整窗口大小
	jf.setVisible(true);//设置窗体桌面可见
}
class  ReadThread extends Thread{

	@Override
	public void run() {
	try {
		while(true) {//不断读取消息
		String str=br.readLine();//一行一行读取服务器发送过来的内容
		jt.append(str+"\n");//将内容显示在文本域上
		}
	} catch(java.net.SocketException e) {
		System.out.println("听友树洞关闭");
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}
}

package com.MusicPlayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//音乐播放器界面
public class MusicInterface {
	boolean open=false;//判断是否正在播放的条件
	static boolean open1=false;//判断树洞是否已经启动
	JFrame jf;//定义窗体
	JPanel jp1;//容器1(上)
	JPanel jp2;//容器2(右)
	JPanel jp3;//容器3(下)
	JButton jb1;//添加按钮
	JButton jb2;//修改按钮
	JButton jb3;//删除按钮
	JButton jb4;//搜索按钮
	JButton jb5;//一键导入本地音乐按钮
	JButton jb6;//上一首按钮
	JButton jb7;//播放按钮
	JButton jb8;//听友树洞按钮
	JButton jb9;//下一首按钮
	JTextArea jt1;//显示全部音乐信息的文本区
	JLabel la1;//图片区域
	JLabel la;//标签(音乐列表)
	JTextField jtf1;//添文本框
	JTextField jtf2;//添加文本框
	JTextField jtf4;//删除文本框
	JScrollPane jsp;//滚动条
	//构造方法
	public MusicInterface() {
	jf=new JFrame("音乐播放器1.0");//初始化窗体
	jp1=new JPanel();//初始化容器1
	jp2=new JPanel();//初始化容器2
	jp3=new JPanel();//初始化容器3
	jtf1=new JTextField("请输入歌名/歌手名",20);//搜索文本框
	jtf2=new JTextField("请输入音乐路径",20);//添加文本框
	jtf4=new JTextField("请输入歌名",20);//删除文本框
	jb1=new JButton("添加");//添加按钮
	jb2=new JButton("修改");//修改按钮
	jb3=new JButton("删除");//删除按钮
	jb4=new JButton("搜索");//搜索按钮
	jb5=new JButton("一键导入本地音乐");//一键导入本地音乐按钮
	jb6=new JButton("暂停");//上一首按钮
	jb7=new JButton("播放");//播放按钮
	jb8=new JButton("听友树洞");//听友树洞按钮
	jb9=new JButton("下一首");//下一首按钮
	jt1=new JTextArea(10,20);//显示全部音乐信息的文本区
	la1=new JLabel(new ImageIcon("音乐.gif"));//图片区域
	la=new JLabel("                 音乐列表        ");//标签(音乐列表)
	jsp=new JScrollPane(jt1);//组合成滚动面板
	}
	//设计窗体布局的普通方法Layout(3,2)布局方式
	public void design() {
		jp1.setBackground(Color.RED);
		jf.add(jp1,BorderLayout.NORTH);//将容器1放置到窗体的中间位置
		jf.add(jp2,BorderLayout.CENTER);//将容器2放置到窗体的南位置
		jf.add(jp3,BorderLayout.SOUTH);//将容器3放置到窗体的南位置
		jp2.setLayout(new BorderLayout());
//修改各个组件的字体设置
		jt1.setFont(new Font("黑体",Font.PLAIN,18));//修改显示全部音乐信息字体
		jb1.setFont(new Font("黑体",Font.PLAIN,20));//修改添加按键字体
		jb2.setFont(new Font("黑体",Font.PLAIN,20));//修改修改按键字体
		jb3.setFont(new Font("黑体",Font.PLAIN,20));//修改删除按键字体
		jtf1.setFont(new Font("黑体",Font.PLAIN,20));//搜索文本框按键字体
		jtf2.setFont(new Font("黑体",Font.PLAIN,15));//添加文本框按键字体
		jtf4.setFont(new Font("黑体",Font.PLAIN,15));//删除文本框按键字体
		jb4.setFont(new Font("黑体",Font.PLAIN,20));//修改搜索按键字体
		jb5.setFont(new Font("黑体",Font.PLAIN,20));//修改一键导入本地音乐按键字体
		jb6.setFont(new Font("黑体",Font.PLAIN,20));//修改上一首按键字体
		jb7.setFont(new Font("黑体",Font.PLAIN,30));//修改播放按键字体
		jb9.setFont(new Font("黑体",Font.PLAIN,20));//下一首按钮按键字体
		la.setFont(new Font("",Font.PLAIN,20));//修改标签按键字体
//设置容器1=======================================================================================
		jp1.add(jtf2);//添加文本框
		jp1.add(jb1);//添加按钮
//给添加按钮添加监听器
		jb1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String Variable=jtf2.getText();
					JOptionPane.showMessageDialog(jf, Function.Add(Variable), "提示",JOptionPane.PLAIN_MESSAGE);
					jt1.setText("");
					jt1.append(Function.Check1());
			}});
		jp1.add(jtf4);//删除文本框
		jp1.add(jb3);//删除按钮
//给删除按钮添加监听器	
		jb3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			      String Name=jtf4.getText();
				JOptionPane.showMessageDialog(jf,Function.Delete(Name), "提示",JOptionPane.PLAIN_MESSAGE);//删除按钮
				jt1.setText("");//先清空显示区
				jt1.append(Function.Check1());//显示全部音乐
			}
			
		});
		jp1.add(jb2);//修改按钮
//给修改按钮添加监听器
		jb2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangeInterface c=new ChangeInterface();
				c.design1();
			}});
		jp1.add(jtf1);//搜索文本框
		jp1.add(jb4);//搜索按钮
//给搜索按钮添加监听器
		jb4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String Variable=jtf1.getText();
				jt1.setText("");
				jt1.setText(Function.Check(Variable));
			    jtf1.setText("");//清空文本输入框
			}
			
		});
		//设置颜色
//		jp3.setBackground(Color.WHITE);//容器2的填充颜色
//		jp2.setBackground(Color.WHITE);//容器2的填充颜色
		jb1.setBackground(Color.RED);
		jb1.setForeground(Color.WHITE);
		jb2.setBackground(Color.RED);
		jb2.setForeground(Color.WHITE);
		jb3.setBackground(Color.RED);
		jb3.setForeground(Color.WHITE);
		jb5.setForeground(Color.WHITE);
		jb4.setBackground(Color.RED);
		jb4.setForeground(Color.WHITE);
		jtf1.setForeground(Color.WHITE);
		jtf1.setBackground(Color.LIGHT_GRAY);
		jtf2.setForeground(Color.WHITE);
		jtf2.setBackground(Color.LIGHT_GRAY);
		jtf4.setForeground(Color.WHITE);
		jtf4.setBackground(Color.LIGHT_GRAY);
//设置容器2=====================================================================================
		la.setForeground(Color.RED);//设置标签的前景色
		jp2.add(la,BorderLayout.NORTH);//将标签添加到容器2
		jt1.setBackground(Color.WHITE);//设置文本区背景色
		jt1.setEditable(false);//设置显示全部音乐信息的文本区不可更改
		jp2.add(jsp,BorderLayout.CENTER);//显示全部音乐信息的文本区
		jb8.add(la1);
		jb8.setBackground(Color.WHITE);
		jp2.add(jb8,BorderLayout.EAST);//图片区域
		//听友树洞按钮事件监听器
				jb8.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						if(!open1) {
						new Client();
						open1=true;
						}else {
							System.out.println("已经打开听友树洞了");
						}
					}});
//设置容器3======================================================================================
		jb5.setBackground(Color.RED);
		jb5.setForeground(Color.WHITE);
		jp3.add(jb5);//一键导入本地音乐按钮放置到容器3中
		jb6.setBackground(Color.RED);
		jb6.setForeground(Color.WHITE);
//给一键导入本地音乐按钮添加监听器
		jb5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(Function.localMusic().equals("true")) {
					jt1.setText("");
				jt1.setText("全部音乐信息\n"+Function.Check1());//一键导入按钮
				}else {
					jt1.setText("");
//					jt1.setText("无需重复导入"+"\n\n"+"全部音乐信息"+Function.Check1());//一键导入按钮
					jt1.append("无需重复导入"+"\n\n"+"全部音乐信息"+Function.Check1());//上面方法一样的实现效果
				}
			}
		});
		jp3.add(jb6);//暂停按钮
//暂停按钮添加事件监听器
		jb6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			Play.closePlay();
			open=false;
			}});
		jb7.setBackground(Color.RED);
		jb7.setForeground(Color.WHITE);
		jp3.add(jb7);//播放按钮
//给播放按键装监听器
		jb7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!open)
				{
				new Play().start();
				open=true;
				}else {
					JOptionPane.showMessageDialog(jf, "正在播放中","提示",JOptionPane.PLAIN_MESSAGE);
					                           //窗体之上，提示信息，标题，提示类型图标
				}
			}});
		jb9.setBackground(Color.RED);
		jb9.setForeground(Color.WHITE);
		jp3.add(jb9);//下一首按键
		jb9.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(jf, "正在开发中.......");
			}});
//设置窗体相关信息			
		jf.setSize(1200, 700);//设置窗体大小
//		jf.pack();//窗体大小适宜的设置
		jf.setLocation(400,150);//设置窗体在屏幕上显示的位置
		jf.setDefaultCloseOperation(3);//设置关闭界面即结束程序
		jf.setResizable(false);//设置不能调整窗口大小
		jf.setVisible(true);//设置界面在桌面可见
	}
}

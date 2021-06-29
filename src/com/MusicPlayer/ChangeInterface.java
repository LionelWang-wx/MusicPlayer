package com.MusicPlayer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChangeInterface extends MusicInterface {
	static JFrame jframe;//窗体
	static JButton jbtton;//按钮
	static JPanel jpanel1;//容器1(北)
	static JPanel jpanel2;//容器2(中)
	static JLabel jlabel;//标签
	static JTextField jfield1;//文本框1音乐名
	static JTextField jfield2;//文本框2歌手名
	static JTextField jfield3;//文本框3专辑名
	static JTextArea jarea;

public ChangeInterface() {
	jframe=new JFrame("修改音乐信息界面");
	jbtton=new JButton("确认修改");
	jfield1=new JTextField("请输入音乐名",20);
	jfield2=new JTextField("请输入要更新的歌手名",20);
	jfield3=new JTextField("请输入要更新的专辑名",20);
	jpanel1=new JPanel();//容器1
	jpanel2=new JPanel();//容器2
	jlabel=new JLabel("修改音乐相关信息");//标签
	jarea=new JTextArea(5,30);//文本域
}

public void design1(){
	jpanel1.setLayout(new FlowLayout());//容器1的布局方式
	jpanel2.setLayout(new FlowLayout());//容器2的布局方式
	jframe.add(jpanel1,BorderLayout.NORTH);//容器1在窗体上的位置
	jpanel1.add(jlabel);//标签添加到容器1
	
	jframe.add(jpanel2,BorderLayout.CENTER);//容器2在窗体上的位置
	jpanel2.add(jfield1);//文本框1添加到容器2
	jpanel2.add(jfield2);//文本框2添加到容器2
	jpanel2.add(jfield3);//文本框3添加到容器2
	jpanel2.add(jbtton);//确认修改按钮添加到容器2
	jpanel2.add(jarea);//文本域添加到容器2
	jbtton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String Variable1=jfield1.getText();
			String Variable2=jfield2.getText();
			String Variable3=jfield3.getText();
			jarea.setText(Function.changeMusic(Variable1,Variable2,Variable3));
			jfield1.setText("");
			jfield2.setText("");
			jfield3.setText("");
		}
	});
	
	jfield1.setFont(new Font("黑体",Font.PLAIN,25));//设置字体和大小
	jfield2.setFont(new Font("黑体",Font.PLAIN,25));//设置字体和大小
	jfield3.setFont(new Font("黑体",Font.PLAIN,25));//设置字体和大小
	jbtton.setFont(new Font("黑体",Font.PLAIN,25));//设置字体和大小
	jlabel.setFont(new Font("黑体",Font.PLAIN,35));//设置字体和大小
	jarea.setFont(new Font("黑体",Font.PLAIN,20));//设置字体和大小
	//设置窗体相关信息			
	jframe.setSize(400, 400);//设置窗体大小
	jframe.setLocation(400,150);//设置窗体在屏幕上显示的位置
//	jframe.setDefaultCloseOperation(3);//设置关闭界面即结束程序
	jframe.setResizable(false);//设置不能调整窗口大小
	jframe.setVisible(true);//设置界面在桌面可见
}
}

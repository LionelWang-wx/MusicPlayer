package com.MusicPlayer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;


import javazoom.jl.player.Player;
//播放音乐按键的实现
public class Play extends Thread  {
	static Player p;
	@Override
	public void run() {
		Play.play();
	}

	public static void play(){
    try {
    	BufferedInputStream buffer = new BufferedInputStream(new FileInputStream("D:\\java\\音乐播放器\\Music\\程佳佳 - 山楂树之恋.mp3"));
    	 p=new Player(buffer);
		 p.play();
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	//暂停播放的方法(这里实际是直接关闭的)
	public static void closePlay(){
		p.close();
	}
}

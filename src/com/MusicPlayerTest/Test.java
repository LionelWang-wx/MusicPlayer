package com.MusicPlayerTest;

import com.MusicPlayer.MusicInterface;
import com.MusicPlayer.Server;

public class Test {
public static void main(String[] args) {
	

//		 TODO Auto-generated method stub	 
//	ChangeInterface c=new ChangeInterface();
//	c.design1();
				 
//		 System.out.println(Function.changeMusic("两只老","",""));	 	 
//	Function.localMusic();//一键导入按钮
//	Function.changeMusic();//修改按钮
//	Function.Add();//添加按钮
//	Function.Delete();//删除按钮
//		new MusicInterface().design();
//System.out.println(DatabaseOperation.check("冬至"));
//	System.out.println(Function.Check("sauhidc"));//搜索按钮
	
//Music music=new Music();
//System.out.println(music.Read("dfhkjfdfhjk"));
	 MusicInterface mf=new MusicInterface();
	 mf.design();
	 new Server();//服务器
}

}

package com.MusicPlayer;

/*
 * 实现按钮的功能
 */
public class Function {

	// 一键导入本地音乐按键功能的实现
	public static String localMusic() {
		String text=null;
		// 一键导入直接将预存路径写入方法中(一键导入本地音乐按钮)
		String[] path = new String[] { "D:\\java\\音乐播放器\\Music\\七八点 - 冬至.mp3",
				"D:\\java\\音乐播放器\\Music\\宝宝巴士 - 两只老虎.mp3",
				"D:\\java\\音乐播放器\\Music\\柏松 - 世间美好与你环环相扣.mp3",
				"D:\\java\\音乐播放器\\Music\\Uu - 那女孩对我说 (完整版).mp3",
				"D:\\java\\音乐播放器\\Music\\程佳佳 - 山楂树之恋.mp3",
				"D:\\java\\\\音乐播放器\\Music\\隔壁老樊 - 晨曲 (大写中国).mp3",
				"D:\\java\\\\音乐播放器\\Music\\隔壁老樊 - 多想在平庸的生活拥抱你.mp3",
				"D:\\java\\\\音乐播放器\\Music\\隔壁老樊 - 姬和不如.mp3",
				"D:\\java\\\\音乐播放器\\Music\\隔壁老樊 - 姬和不如demo.mp3",
				"D:\\java\\\\音乐播放器\\Music\\隔壁老樊 - 敬长安.mp3",
				"D:\\java\\\\音乐播放器\\Music\\音阙诗听,赵方婧 - 芒种.mp3",
				"D:\\java\\\\音乐播放器\\Music\\浪客秦昊 - 冬.mp3",
				"D:\\java\\\\音乐播放器\\Music\\解忧邵帅 - 写给黄淮.mp3",
				"D:\\java\\音乐播放器\\Music\\隔壁老樊 - 这一生关于你的风景.mp3",
				"D:\\java\\音乐播放器\\Music\\隔壁老樊 - 我的姑娘 她在远方.mp3",
				"D:\\java\\音乐播放器\\Music\\隔壁老樊 - 我曾.mp3",
				"D:\\java\\音乐播放器\\Music\\隔壁老樊 - 四块五.mp3",
				"D:\\java\\音乐播放器\\Music\\隔壁老樊 - 你是姑娘不是我的新娘.mp3"};
		try {
			for (int i = 0; i < path.length; i++) {
				Music music = new Music().Read(path[i]);// 调用自动导出歌曲的方法将歌曲对应信息导入到对象中
				text=DatabaseOperation.add(music.getName(), music.getSinger(), music.getAlbum())+"";// 调用操作数据库方法将对象中的歌曲信息添加到数据库(路径错误导致的空异常还未处理)
			}
		} catch (java.lang.NullPointerException e) {
			text="路径输入不对，导致对象里面无数据，导入数据库的值为空，无法导入数据库！报错";
			// 此异常不需要显示因为在此异常是另一异常导致，那个异常已经捕获处理，并输出显示异常原因
			// 要注意的是此异常可能也会因为其他异常而产生此异常(测试阶段不会显示了，要注意此处！！！)
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}

	// 添加按钮按钮功能的实现
	// 需要将路径导入写入一个方法中 留出一个添加路径的输入接口(添加按键)
public static String Add(String Variable){
	String text=null;
	boolean f2=false;//判断是否添加成功
	boolean f3=false;
	Music music=null;
		try {
		  music = new Music().Read(Variable);//调用自动导出歌曲的方法将歌曲对应信息导入到对象中
		  
				f2=DatabaseOperation.add(music.getName(),music.getSinger(),music.getAlbum());
				
			}catch(java.lang.NullPointerException e2){
				System.out.println("路径输入不对，导致对象里面无数据，导入数据库的值为空，无法导入数据库！报错");
				f3=true;
		//此异常不需要显示因为在此异常是另一异常导致，那个异常已经捕获处理，并输出显示异常原因
		//要注意的是此异常可能也会因为其他异常而产生此异常(测试阶段不会显示了，要注意此处！！！)			
			}
		if(f3) {
			text="添加失败,路径不对";
		}
		else if(f2) {
			text="添加成功";
		}
		else
		{
			text="添加失败,重复";
		}
	return text;
}

// 修改音乐信息按钮(修改之前先查找)
public static String changeMusic(String Variable1,String Variable2, String Variable3){
	String text1=null;
	 boolean f3=false;//判断是否修改成功的参数
	f3=DatabaseOperation.change(Variable1,Variable2,Variable3);
if(!f3) {
		text1="不存在该音乐名！！！";
}else{
	text1="修改成功";
}
	return text1;
}


//删除音乐信息按钮
public static String Delete(String name){
	String text=null;
	 boolean f3=false;//判断是否修改成功的参数
	f3=DatabaseOperation.delete(name);
if(!f3) {
	text="不存在该音乐名！！！";
}else {
	text="删除成功";
}
return text;
}


//搜索按钮
public static String Check(String Variable){
	String text =null;
	if(DatabaseOperation.check(Variable)==null)
	{
		text="输入有误！请重新输入";
		}else {
for(int i=0;i<DatabaseOperation.check(Variable).size();i++) {
	text=text+"\n"+DatabaseOperation.check(Variable).get(i).toString();
	
}
		}
return text;
}

//查询全部音乐信息的方法
public static String Check1(){
	String text ="";
	if(DatabaseOperation.check1()==null)
	{
		text="查询失败!";
		}else {
for(int i=0;i<DatabaseOperation.check1().size();i++) {
	text=text+"\n"+DatabaseOperation.check1().get(i).toString();
}
		}
return text;
}



}

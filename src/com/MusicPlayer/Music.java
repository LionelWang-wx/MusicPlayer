package com.MusicPlayer;

import java.io.File;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.id3.ID3v23Frame;

public class Music {
	String name;//歌曲
	String singer;//歌手
	String album;//专辑名
	//无参构造方法
	public Music() {
		super();
		// TODO Auto-generated constructor stub
	}
	//有参构造方法
	public Music(String name, String singer, String album) {
		super();
		this.name = name;
		this.singer = singer;
		this.album = album;
	}
	
//获取和设置属性的方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	//重写toString方法
	@Override
	public String toString() {
		return "音乐信息 [歌名:" + name + ", 歌手名:" + singer + ", 专辑名:" + album + "]";
	}
	//定义一个返回音乐对象类的方法
	public Music Read(String f) {
		Music music=null;
		MP3File mp3File;
		try {
			mp3File = (MP3File) AudioFileIO.read(new File(f));
			//获取歌曲名
			ID3v23Frame songnameFrame = (ID3v23Frame) mp3File.getID3v2Tag().frameMap.get("TIT2");
		    String name = songnameFrame.getContent();
		    //获取歌手名
		    ID3v23Frame artistFrame = (ID3v23Frame) mp3File.getID3v2Tag().frameMap.get("TPE1");
		    String singer = artistFrame.getContent();
		    //获取专辑名
		    ID3v23Frame albumFrame = (ID3v23Frame) mp3File.getID3v2Tag().frameMap.get("TALB");
		    String album = albumFrame.getContent();
		    music = new Music(name, singer, album);//将获取出来的歌曲名,歌手名,专辑名存储到对象中
		}
		catch(java.io.FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println("未找到该路径下的指定音乐,请重新输入");//提示用户重新输入    >后面修改到调用处处理<
		}
		catch (org.jaudiotagger.audio.exceptions.CannotReadException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return music;//返回获取的音乐对象
	}
}

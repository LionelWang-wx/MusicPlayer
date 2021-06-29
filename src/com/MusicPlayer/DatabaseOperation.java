package com.MusicPlayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/*
 * 对数据库的操作
 */
public class DatabaseOperation{ 
	
	
	//数据库添加方法
public static boolean add(String name,String singer,String album){ 
			Connection con=null;
			PreparedStatement stm=null;
			String sql="insert into music (name,singer,album)values(?,?,?)";//操作数据库语句
		    boolean f=false;
		    try {
		    	con=DatabaseConnection.getConnection();
				stm=con.prepareStatement(sql);
				//设置要传递到sql语句中的参数
				stm.setString(1, name);
				stm.setString(2, singer);
				stm.setString(3, album);
				int count=stm.executeUpdate();
				if(count>0)
					f=true;
			}catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {
				// TODO Auto-generated catch block
				System.out.println("已经导入该歌曲,无需重复导入！");
//				System.out.print("");//对上面异常捕获处理后不显示
			}
		    catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					con.close();
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		    return f;
	}
	
	//数据库修改方法
public static boolean change(String name,String singer,String album) {
		Connection con=null;
		PreparedStatement stm=null;
		String sql="update music set singer=?,album=? where name=?";
		boolean ff=false;
		try {
			con=DatabaseConnection.getConnection();
			stm=con.prepareStatement(sql);
			//设置要传递到sql语句中的参数
			stm.setString(1, singer);
			stm.setString(2, album);
			stm.setString(3,name);
			int count=stm.executeUpdate();
			if(count>0) 
				ff=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return ff;
	}
//数据库删除方法
public static boolean delete(String name) {
	boolean fff=false;
	Connection con = null;
	PreparedStatement stm=null;
	String sql="delete from music where name=?";
	try {
		con=DatabaseConnection.getConnection();
		stm=con.prepareStatement(sql);
		//传递参数
		stm.setString(1, name);
		int count=stm.executeUpdate();
		if(count>0)
			fff=true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			con.close();
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	return fff;
}

//数据库查询方法
//通过音乐名或歌手名查询对应音乐信息
//Variable变量
public static ArrayList<Music> check(String Variable) {
	ArrayList<Music> list=new ArrayList<Music>();
	Connection con=null;
	PreparedStatement stm=null;
	String sql="select * from music where name='"+Variable+"'or singer='"+Variable+"'";
	ResultSet re1=null;
	
	try {
		con=DatabaseConnection.getConnection();
		stm=con.prepareStatement(sql);//获取查询到的结果集
		re1=stm.executeQuery();
		//将结果集变成对象并存放到集合中
		boolean ls=false;//判断是否进入while
		while(re1.next()){
			
			String Name=re1.getString("name");
			String Singer=re1.getString("singer");
			String Album=re1.getString("album");
			Music music=new Music(Name,Singer,Album);
			list.add(music);
			ls=true;
		}
		if(!ls) {
			list=null;	
		}
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			con.close();
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
}		
}
	return list;
}


//数据库查询方法
//查询全部音乐信息
public static ArrayList<Music> check1() {
	ArrayList<Music> list=new ArrayList<Music>();
	Connection con=null;
	PreparedStatement stm=null;
	String sql="select * from music";
	ResultSet re1=null;
	try {
		con=DatabaseConnection.getConnection();
		stm=con.prepareStatement(sql);//获取查询到的结果集
		re1=stm.executeQuery();
		//将结果集变成对象并存放到集合中
		boolean ls=false;//判断是否进入while
		while(re1.next()){
			
			String Name=re1.getString("name");
			String Singer=re1.getString("singer");
			String Album=re1.getString("album");
			Music music=new Music(Name,Singer,Album);
			list.add(music);
			ls=true;
		}
		if(!ls) {
			list=null;	
		}
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			con.close();
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
}		
}
	return list;
}
}


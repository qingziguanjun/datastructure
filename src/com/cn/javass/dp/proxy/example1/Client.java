package com.cn.javass.dp.proxy.example1;
import com.cn.javass.dp.mediator.example3.User;

import java.util.*;
public class Client {
	public static void main(String[] args) throws Exception{
		UserManager userManager = new UserManager();
		Collection<UserModel> col = userManager.getUserByDepId("0101");
		System.out.println(col);


		Action action = new Action();
		Optional<User> userOptional = Optional.ofNullable(null);
		String a = userOptional.map(User::getUserName).orElse("action2");
	}

	static class Action{
		public  String action2(){
			return "";
		}
		public  String action1(){
			return "";
		}
	}
}
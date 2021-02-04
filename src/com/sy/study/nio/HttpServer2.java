package com.sy.study.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer2 {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(100);
		try {
			ServerSocket ss=new ServerSocket(8803);

			while(true){
				Socket socket=ss.accept();
				executorService.execute(()->service(socket));
			}
		} catch (IOException  e) {
			e.printStackTrace();
		}
	}

	private static void service(Socket socket)  {
		try {
			Thread.sleep(20);
			BufferedReader bd = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			/**
			 * ����HTTP����
			 */
			String requestHeader;
			int contentLength = 0;
			while ((requestHeader = bd.readLine()) != null && !requestHeader.isEmpty()) {
				System.out.println(requestHeader);
				/**
				 * ���GET����
				 */
				if (requestHeader.startsWith("GET")) {
					int begin = requestHeader.indexOf("/?") + 2;
					int end = requestHeader.indexOf("HTTP/");
					String condition = requestHeader.substring(begin, end);
					System.out.println("GET�����ǣ�" + condition);
				}
				/**
				 * ���POST����
				 * 1.��ȡ�������ݳ���
				 */
				if (requestHeader.startsWith("Content-Length")) {
					int begin = requestHeader.indexOf("Content-Lengh:") + "Content-Length:".length();
					String postParamterLength = requestHeader.substring(begin).trim();
					contentLength = Integer.parseInt(postParamterLength);
					System.out.println("POST���������ǣ�" + Integer.parseInt(postParamterLength));
				}
			}
			StringBuffer sb = new StringBuffer();
			if (contentLength > 0) {
				for (int i = 0; i < contentLength; i++) {
					sb.append((char) bd.read());
				}
				System.out.println("POST�����ǣ�" + sb.toString());
			}
			//���ͻ�ִ
			PrintWriter pw = new PrintWriter(socket.getOutputStream());

			pw.println("HTTP/1.1 200 OK");
			pw.println("Content-type:text/html");
			pw.println();
			pw.println("<h1>���ʳɹ���</h1>");

			pw.flush();
			socket.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
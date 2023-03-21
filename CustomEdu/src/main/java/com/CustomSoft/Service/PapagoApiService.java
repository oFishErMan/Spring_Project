package com.CustomSoft.Service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.CustomSoft.db.PapagoDto;

@Service
public class PapagoApiService {
	public PapagoDto papago(String korean) {
		String clientId = "CyMPslcQCy5RgtktDZdL";
		String clientSecret = "nNimQHJw8R";
		String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
		PapagoDto dto = new PapagoDto();
		
		try {
			korean = URLEncoder.encode(korean, "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException("인코딩 실패", e);
		}

		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("X-Naver-Client-Id", clientId);
		requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		String chinese= getChinese(apiURL, requestHeaders, korean);
		String english= getEnglish(apiURL, requestHeaders, korean);
		
		System.out.println(chinese);
		dto.setChinese(chinese);
		dto.setEnglish(english);
		return dto;
	}

	private static String getEnglish(String apiUrl, Map<String, String> requestHeaders, String korean) {
		HttpURLConnection con = connect(apiUrl);
		String postParams = "source=ko&target=en&text=" + korean;
		try {
			con.setRequestMethod("POST");
			for(Map.Entry<String, String> header : requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}
			
			con.setDoOutput(true);
			try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
				wr.write(postParams.getBytes());
				wr.flush();
			}
			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				return readBody(con.getInputStream());
			} else {
				return readBody(con.getErrorStream());
			}
			
		} catch (IOException e) {
			throw new RuntimeException("API 요청과 응답 실패", e);
		} finally {
			con.disconnect();
		}
	}
	private String getChinese(String apiUrl, Map<String, String> requestHeaders, String korean) {
		HttpURLConnection con = connect(apiUrl);
		String postParams = "source=ko&target=zh-CN&text=" + korean;
		try {
			con.setRequestMethod("POST");
			for(Map.Entry<String, String> header : requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}
			
			con.setDoOutput(true);
			try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
				wr.write(postParams.getBytes());
				wr.flush();
			}
			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				return readBody(con.getInputStream());
			} else {
				return readBody(con.getErrorStream());
			}
			
		} catch (IOException e) {
			throw new RuntimeException("API 요청과 응답 실패", e);
		} finally {
			con.disconnect();
		}
	}

	private static HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
		} catch (IOException e) {
			throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
		}
	}

	private static String readBody(InputStream body) {
		InputStreamReader streamReader = new InputStreamReader(body);

		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();

			String line;
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}

			return responseBody.toString();
		} catch (IOException e) {
			throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
		}
	}
}

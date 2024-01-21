package com.mc.innuce;

//네이버 검색 API 예제 - 블로그 검색
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class NaverSearch {

	public String getNewsJson(String word) {
		String clientId = "Hm3VFA0ujGVH5iNMk8XU"; // 애플리케이션 클라이언트 아이디
		String clientSecret = "XVaGXy8eEK"; // 애플리케이션 클라이언트 시크릿

		String text = null;
		try {
			text = URLEncoder.encode(word, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("검색어 인코딩 실패", e);
		}

		String apiURL = "https://openapi.naver.com/v1/search/news.json?query=" + text; // JSON 결과
//     String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // XML 결과

		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("X-Naver-Client-Id", clientId);
		requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		String responseBody = get(apiURL, requestHeaders);
		System.out.println("NaverSearch(getNewsJson): " + responseBody);

		return responseBody;
	}

	public String get(String apiUrl, Map<String, String> requestHeaders) {
		HttpURLConnection con = connect(apiUrl);
		InputStream inputStream = null;
		try {
			con.setRequestMethod("GET");
//         con에 id,pw 추가
			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				inputStream = con.getInputStream();
			} else { // 오류 발생
				inputStream = con.getErrorStream();
			}
//			System.out.println("NaverSearch(get): " + readBody(inputStream));
			return readBody(inputStream);
		} catch (IOException e) {
			System.out.println("NaverSearch(get): " + e);
			throw new RuntimeException("API 요청과 응답 실패", e);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					System.out.println("NaverSearch(get): " + e);
				}
			}
			con.disconnect();
		}

	}

	public HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			System.out.println("NaverSearch(connect): " + e);
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
		} catch (IOException e) {
			System.out.println("NaverSearch(connect): " + e);
			throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
		}
	}

	public String readBody(InputStream body) {
		InputStreamReader streamReader = new InputStreamReader(body);

		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();

			String line;
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}

			System.out.println("NaverSearch(readBody): " + responseBody.toString());
			return responseBody.toString();
		} catch (IOException e) {
			System.out.println("NaverSearch(readBody): " + e);
			throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
		}
	}
}
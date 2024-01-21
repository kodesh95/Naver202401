package com.mc.innuce;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

//
public class JSONTest {

	public static Gson gson = new GsonBuilder().disableHtmlEscaping() // HTML 특수문자 이스케이핑 비활성화
			.setPrettyPrinting() // 보기 쉬운 형식으로 JSON 출력
			.serializeNulls() // null값을 가진 필드도 직렬화
			.create();
	public String response = "이재명 더불어민주당 대표가 17일 당무 복귀 후 첫회의에서 윤석열 정부를 겨냥해 \"민주당은 이 정권의 2년간 행태나 성과가 결코 국민들 기대에 부합하지 못했다고 생각한다\"면서 \"민주당은 책임을 묻는 데 있어서 최선을 다할 것\"이라고 말했다."
			+ "이 대표는 이날 국회에서 열린 최고위원회의에서 \"이번 선거는 정권에 대한 중간 평가이자, 권력에 대한 심판 선거\"라면서 이같이 말했다. 15일 만에 당무복귀 일성으로 총선에서 윤석열 정권을 심판해달라고 호소한 것이다."
			+ "이 대표는 \"법으로도 죽여보고, 펜으로도 죽여보고, 그래도 안 되니, 칼로 죽이려고 하지만 결코 죽지 않는다\"면서 \"우리 국민들께서 저를 살려주신 것처럼 우리 국민들께서 이 나라 주인으로 책임지고 제대로 이끌어가 주실 것을 확신한다\"고 말했다."
			+ "이 대표는 \"이번 총선이 가지는 의미는 지금까지 윤석열 정권이 주어진 권한을 제대로 행사했는가, 정당하게 행사했는가. 그로 인해 세상을 좀 더 낫게 바꿨는가, 후퇴시켰는가를 평가하는 것\"이라며 \"상응하는 책임을 물어야 한다고 생각한다\"고 강조했다."
			+ "이 대표는 \"많은 논란들이 있지만 최선의 노력을 다해서 통합하고, 국민 눈높이에 맞는 공정한 혁신적인 공천을 통해서 우리 국민들에게 새로운 희망을 보여드릴 것\"이라고 밝혔다."
			+ "이 대표가 '정권심판 선거'와 '공정 공천'을 강조한 것은 이 대표가 부재한 동안 지지율이 상승한 국민의힘을 견제하기 위한 것으로 풀이된다. 현 정부를 비판하면서 윤 대통령과 일대일 구도를 강조, 제3지대가 아닌 민주당에게 표를 몰아줄 것을 호소한 것이다."
			+ "앞서 이 대표는 지난 2일 흉기에 피습돼 부산대병원과 서울대병원에서 치료를 받은 후 자택에서 회복을 해왔다. 이 대표는 그간 수술과 입원, 자택에서 치료를 받은 시기와 관련해 \"상대를 제거하지 않으면 불안하고 내가 모든 것을 가지겠다는 생각에 정치가 전쟁이 되고 있는 것 같다\"면서 \"우리 국민들의 삶도 전쟁터 비슷하게 변해가고 있다. 누구도 관심 가지지 않는 것 같고 혼자 버려져 있는 것 같고, 각자의 삶을 각자가 알아서 챙겨야 하는 각자도생·외로움·고통 같은 것들이 많은 사람들을 힘겹게 하는 것 같다\"고 했다."
			+ "한동훈 국민의힘 비상대책위원장은 이날 이재명 대표가 \"법으로도 죽여보고 펜으로도 죽여보고 그래도 안 되니 칼로 죽이려고 하지만 결코 죽지 않는다\"고 발언한 것을 두고 \"칼로 죽여본다니, 누가 죽여본다는 것인가, 내가? 국민의힘이? 아니면 국민들이?\"라고 반문하면서 \"그 정도면 망상\"이라고 말했다. 이어 이 대표의 흉기 피습 사건에 대해 \"굉장히 이상한 사람이 굉장히 나쁜 범죄를 저지른 것뿐 아닌가\"라고 지적했다.";

	public static void main(String[] args) {
		JSONTest jsonTest = new JSONTest();
		System.out.println(jsonTest.getJsonData());
		jsonTest.jsonToMap();
		jsonTest.mapToJson();
	}
//  Json객체 -> JSON 
	public String getJsonData() {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("title", "이재명 복귀");
		jsonObject.addProperty("content", response);

		return gson.toJson(jsonObject);
	}

//	MAP -> JSON :서버와 클라이언트 간의 데이터 교환할 때 유용
	public void mapToJson() {

		Map<String, Object> mapData = new HashMap<>();
		mapData.put("title", "이재명 복귀");
		mapData.put("content", response);

		System.out.println(gson.toJson(mapData));
	}

//	JSON -> MAP(Java객체) :동적 데이터 구조 다룰 때 유용
//	JSON을 Java 객체로 역직렬화
	public void jsonToMap() {
		JSONTest jsonTest = new JSONTest();
		String jsonData = jsonTest.getJsonData();

//		TypeToken은 Gson의 제네릭 타입정보를 직렬화/역직렬화 시에 타입정보를 제공해준다.
		Map<String, Object> mapData = gson.fromJson(jsonData, new TypeToken<Map<String, Object>>() {
		}.getType());
		System.out.println(mapData.get("title"));
		System.out.println(mapData.get("content"));

	}

}
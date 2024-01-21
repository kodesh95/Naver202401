package com.mc.innuce;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;

public class ParsingKomoran {
	public HashMap<String, Integer> parsingData(String word) {

		Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);

		String path = System.getProperty("user.dir");
//		D:\fullstack\workspace_innuce\wordclouding

//		사전 경로 
		komoran.setFWDic(path + "/dictionary/fwd.user");
		komoran.setUserDic(path + "/dictionary/dic.user");

		String dataSource = new NaverCrawler().crawler(word);
//		String dataSource ="서울 아파트값이 7주 연속 하락세가 이어졌다. 부동산 프로젝트파이낸싱(PF) 부실 등 부동산 시장에 대한 불확실성과 부동산 비수기가 맞물린 영향이다. 특히 서울 자치구 중 가장 큰 폭으로 떨어진 송파구에서는 한 달 사이 2억원 가까이 하락했다."
//				+ ""
//				+ "18일 한국부동산원이 발표한 주간 아파트가격동향에 따르면, 1월 셋째 주(15일 기준) 서울 아파트 매매가격은 0.04% 하락했다. 하락폭은 전주와 같다."
//				+ ""
//				+ "강북권 14개 자치구는 0.03% 하락했다. 성동구(-0.05%)는 금호·행당·응봉동 주요단지 위주로, 마포구(-0.04%)는 대흥·염리·창전동 위주로 떨어졌다. 서대문구(-0.04%)는 남가좌·북가좌동 대단지 위주로, 은평구(-0.04%)는 갈현·불광·신사동의 구축 위주로 하락했다."
//				+ ""
//				+ "강남권 11개 자치구는 0.04% 떨어졌다. 금천구(-0.06%)는 독산·시흥동 중소형 규모 위주로, 서초구(-0.04%)는 잠원동과 반포동의 주요 단지 위주로 떨어졌다. 구로구(-0.04%)는 오류·개봉동 대단지 위주로 하락했다."
//				+ ""
//				+ "서울 자치구 중 가장 큰 하락폭을 보인 송파구(-0.13%)는 가락·잠실·문정동 대단지 위주로 하락했다. 하락폭도 전주(-0.11%) 대비 커졌다."
//				+ ""
//				+ "송파구에서는 올 들어 하락 거래가 이어졌다. 부동산 빅데이터 업체 ‘아실’에 따르면, 송파구 문정동 올림픽훼밀리 전용 117㎡은 지난 10일 18억7000만원에 거래됐다. 이는 지난달 거래가격인 20억5000만원에 비해 1억8000만원이 떨어진 가격이다. 거여동 송파위례리슈빌퍼스트클래스 전용 105㎡은 지난 3일 13억원에 거래됐다. 지난해 11월 거래가격인 14억5000만원에 비해 1억5000만원이 하락했다. 지난해 12월 19억5000만원에 거래된 잠실동 잠실엘스 전용 59㎡도 지난 10일 18억7000만원에 새 주인을 찾았다. 한 달 사이 6000만원이 빠졌다."
//				+ ""
//				+ "관망세가 짙어지며 서울 아파트 매물도 적체돼 있다. 서울 아파트 매물 수는 17일 기준, 7만6667건에 달한다. 6개월 전인 지난해 7월(17일 기준) 매물은 6만6174건이다. 현재는 지난해 7월 대비 16% 가량 증가한 수준이다. 지난 1일(7만3929건)에 비해서도 3000건 가량이 추가적으로 쌓였다."
//				+ ""
//				+ "부동산원 관계자는 “부동산시장 불확실성에 따른 매수 관망세가 지속되며 급매물 위주의 거래가 이뤄지고 일부 단지에서 매물가격 조정에 따른 하락 거래가 발생하는 등 하락세가 지속되고 있다”고 분석했다."
//				+ ""
//				+ "수도권 아파트 매매가격은 0.06% 떨어졌다. 하락폭은 전주와 동일했다. 인천이 0.05% 빠졌고, 경기는 0.07% 떨어졌다."
//				+ ""
//				+ "전국 아파트 매매가격도 0.04% 떨어지며 8주 연속 하락세를 이어갔다. 다만, 하락폭은 전주(-0.05%)에 비해 축소됐다. 지방은 0.03% 떨어졌지만, 전주(-0.04%)에 비해 하락폭이 줄었다."
//				+ ""
//				+ "한편, 전국 아파트 전세가격은 0.02% 올랐지만 지난주(0.03%) 대비 상승폭은 축소됐다. 수도권(0.05%→0.05%)은 상승폭이 유지됐다. 서울(0.08%→0.07%)은 상승폭이 축소되고, 지방(0.00%→-0.01%)은 하락 전환됐다.";
//		System.out.println("ParsingKomoran(parsingData): "+dataSource.toString());
//		String input = dataSource.toString();
		System.out.println(dataSource);
//		입력 텍스트에 대한 형태소 분석을 수행
		KomoranResult komoranResult = komoran.analyze(dataSource);
		System.out.println("ParsingKomoran(parsingData): "+komoranResult.getNouns());
//		고유명사 , 일반명사 , 의존명사 
//		="NNP", "NNG", "NNB"
		List<String> analyzeList = komoranResult.getMorphesByTags("NNP", "NNG", "NNB","NP");

		HashMap<String, Integer> listHash = new HashMap<>();

		for (String token : analyzeList) {
//			analyzeList에서 문자열 token의 빈도를 계산합니다. 
			int num = Collections.frequency(analyzeList, token);
			listHash.put(token, num);
		}
		System.out.println("ParsingKomoran(parsingData): "+listHash.toString());
		return listHash;

	}
}

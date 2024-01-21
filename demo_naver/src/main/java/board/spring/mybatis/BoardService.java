package board.spring.mybatis;

import java.util.List;

public interface BoardService {
	/*public*/void registerBoard(BoardDTO dto);
	int getTotalBoard();
	List<BoardDTO> boardList(int[] limit);
	BoardDTO updateViewcountAndGetDetail(int seq);
	int deleteBoard(int seq);
	int updateBoard(BoardDTO dto);
	
}

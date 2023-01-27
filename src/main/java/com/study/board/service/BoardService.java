package com.study.board.service;

import com.study.board.entity.board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService  {
    @Autowired
    private BoardRepository boardRepository;

    public void write(board board){
        boardRepository.save(board);

    }
    public List<board> boardList(){
        return boardRepository.findAll();
    }

    //특정 게시물 불러오기
    public board boardView(Integer id){
        return boardRepository.findById(id).get();
    }
    public void boardDelete(Integer id){
        boardRepository.deleteById(id);
    }


}

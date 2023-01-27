package com.study.board.controller;

import com.study.board.entity.board;
import com.study.board.repository.BoardRepository;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;
    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/board/write")
    public static String boardWriteForm() {

        return "boardWrite";
    }
    @PostMapping("/board/writePro")
    public String boardWritePro(board board){

        boardService.write(board);

        return "boardWritePro";

    }
    @GetMapping("/board/list")
    public String boardList(Model model){
        model.addAttribute("list",boardService.boardList());

        return "boardList";

    }
    @GetMapping("/board/view")
    public String boardView(Model model,Integer id){
        model.addAttribute("board",boardService.boardView(id));

        return "boardView";
    }

    @GetMapping("/board/delete")
    public String boardDelete(Integer id){
         boardService.boardDelete(id);
         return "redirect:/board/list";

    }

    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id") Integer id,Model model ){
        model.addAttribute("board",boardService.boardView(id));
        return "boardModify";
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id,board board){
        board temp=boardService.boardView(id);
        temp.setTitle(board.getTitle());
        temp.setContent(board.getContent());

        boardService.write(temp);//중요!!!!
        return "redirect:/board/list";
    }
}

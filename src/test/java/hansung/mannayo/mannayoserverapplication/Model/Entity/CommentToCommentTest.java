package hansung.mannayo.mannayoserverapplication.Model.Entity;

import hansung.mannayo.mannayoserverapplication.Model.Type.AccountType;
import hansung.mannayo.mannayoserverapplication.Model.Type.BoardType;
import hansung.mannayo.mannayoserverapplication.Model.Type.LoginType;
import hansung.mannayo.mannayoserverapplication.Repository.BoardRepository;
import hansung.mannayo.mannayoserverapplication.Repository.CommentRepository;
import hansung.mannayo.mannayoserverapplication.Repository.CommentToCommentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CommentToCommentTest {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    CommentToCommentRepository commentToCommentRepository;

    @Test
    public void Test(){
        Member member = new Member();
        member.setNickName("aa");
        member.setEmail("tmdhk502@naver.com");
        member.setAccountTypeEnum(AccountType.MEMBER);
        member.setPassword("tmdghk9609!");
        member.setPhoneNumber("010-0202-0303");
        member.setBirth(LocalDate.now());
        member.setLoginTypeEnum(LoginType.EMAIL);
        member.setReportCount(1);

        Board board = Board.builder()
                .member(member)
                .title("title")
                .contents("hi")
                .type(BoardType.ADVERTISE_BOARD)
                .build();

        Board savedBoard1 = boardRepository.save(board);


        Comment comment = Comment.builder()
                .board(savedBoard1)
                .nickName("seunghwa")
                .build();

        commentRepository.save(comment);

        CommentToComment c2c = CommentToComment.builder()
                .comment(comment)
                .nickName("aaa")
                .contents("hi")
                .build();

        commentToCommentRepository.save(c2c);

    }



}
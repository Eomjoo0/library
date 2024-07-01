package library.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import library.config.kafka.KafkaProcessor;
import library.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class MypageViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private MypageRepository mypageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBookCheckedout_then_CREATE_1(
        @Payload BookCheckedout bookCheckedout
    ) {
        try {
            if (!bookCheckedout.validate()) return;

            // view 객체 생성
            Mypage mypage = new Mypage();
            // view 객체에 이벤트의 Value 를 set 함
            mypage.setBookId(bookCheckedout.getBookId());
            // view 레파지 토리에 save
            mypageRepository.save(mypage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBookReturned_then_CREATE_2(
        @Payload BookReturned bookReturned
    ) {
        try {
            if (!bookReturned.validate()) return;

            // view 객체 생성
            Mypage mypage = new Mypage();
            // view 객체에 이벤트의 Value 를 set 함
            mypage.setBookId(bookReturned.getBookId());
            // view 레파지 토리에 save
            mypageRepository.save(mypage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenLoanCreated_then_CREATE_3(
        @Payload LoanCreated loanCreated
    ) {
        try {
            if (!loanCreated.validate()) return;

            // view 객체 생성
            Mypage mypage = new Mypage();
            // view 객체에 이벤트의 Value 를 set 함
            mypage.setLoanId(loanCreated.getLoanId());
            // view 레파지 토리에 save
            mypageRepository.save(mypage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenMemberResigtered_then_CREATE_4(
        @Payload MemberResigtered memberResigtered
    ) {
        try {
            if (!memberResigtered.validate()) return;

            // view 객체 생성
            Mypage mypage = new Mypage();
            // view 객체에 이벤트의 Value 를 set 함
            mypage.setMemberId(memberResigtered.getMemberId());
            // view 레파지 토리에 save
            mypageRepository.save(mypage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenLoanCreated_then_UPDATE_1(
        @Payload LoanCreated loanCreated
    ) {
        try {
            if (!loanCreated.validate()) return;
            // view 객체 조회
            Optional<Mypage> mypageOptional = mypageRepository.findById(
                loanCreated.getMemberId()
            );

            if (mypageOptional.isPresent()) {
                Mypage mypage = mypageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                mypage.setBookId(loanCreated.getBookId());
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenLoanExpired_then_DELETE_1(
        @Payload LoanExpired loanExpired
    ) {
        try {
            if (!loanExpired.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            mypageRepository.deleteByBookId(loanExpired.getBookId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}

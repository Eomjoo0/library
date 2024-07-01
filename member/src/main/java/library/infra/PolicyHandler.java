package library.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import library.config.kafka.KafkaProcessor;
import library.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    MemberRepository memberRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LoanCreated'"
    )
    public void wheneverLoanCreated_MemberStatusCheck(
        @Payload LoanCreated loanCreated
    ) {
        LoanCreated event = loanCreated;
        System.out.println(
            "\n\n##### listener MemberStatusCheck : " + loanCreated + "\n\n"
        );

        // Sample Logic //
        Member.memberStatusCheck(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LoanExpired'"
    )
    public void wheneverLoanExpired_MemberStatusCheck(
        @Payload LoanExpired loanExpired
    ) {
        LoanExpired event = loanExpired;
        System.out.println(
            "\n\n##### listener MemberStatusCheck : " + loanExpired + "\n\n"
        );

        // Sample Logic //
        Member.memberStatusCheck(event);
    }
}
//>>> Clean Arch / Inbound Adaptor

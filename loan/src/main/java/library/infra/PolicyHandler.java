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
    LoanRepository loanRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='BookCheckedout'"
    )
    public void wheneverBookCheckedout_BookStockCheck(
        @Payload BookCheckedout bookCheckedout
    ) {
        BookCheckedout event = bookCheckedout;
        System.out.println(
            "\n\n##### listener BookStockCheck : " + bookCheckedout + "\n\n"
        );

        // Sample Logic //
        Loan.bookStockCheck(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='BookReturned'"
    )
    public void wheneverBookReturned_BookStockCheck(
        @Payload BookReturned bookReturned
    ) {
        BookReturned event = bookReturned;
        System.out.println(
            "\n\n##### listener BookStockCheck : " + bookReturned + "\n\n"
        );

        // Sample Logic //
        Loan.bookStockCheck(event);
    }
}
//>>> Clean Arch / Inbound Adaptor

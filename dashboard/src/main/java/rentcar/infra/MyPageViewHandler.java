package rentcar.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import rentcar.config.kafka.KafkaProcessor;
import rentcar.domain.*;

@Service
public class MyPageViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private MyPageRepository myPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReserved_then_CREATE_1(@Payload Reserved reserved) {
        try {
            if (!reserved.validate()) return;

            // view 객체 생성
            MyPage myPage = new MyPage();
            // view 객체에 이벤트의 Value 를 set 함
            myPage.setId(reserved.getId());
            myPage.setUserId(reserved.getUserId());
            myPage.setReserveDt(reserved.getReserveDt());
            // view 레파지 토리에 save
            myPageRepository.save(myPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReserved_then_UPDATE_1(@Payload Reserved reserved) {
        try {
            if (!reserved.validate()) return;
            // view 객체 조회
            Optional<MyPage> myPageOptional = myPageRepository.findById(
                reserved.getId()
            );

            if (myPageOptional.isPresent()) {
                MyPage myPage = myPageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setId(reserved.getId());
                myPage.setUserId(reserved.getUserId());
                myPage.setReserveDt(reserved.getReserveDt());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}

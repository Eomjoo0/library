package library.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import library.MemberApplication;
import library.domain.MemberRemoved;
import library.domain.MemberResigtered;
import lombok.Data;

@Entity
@Table(name = "Member_table")
@Data
//<<< DDD / Aggregate Root
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberId;

    private String name;

    private Integer contactNumber;

    @PostPersist
    public void onPostPersist() {
        MemberResigtered memberResigtered = new MemberResigtered(this);
        memberResigtered.publishAfterCommit();

        MemberRemoved memberRemoved = new MemberRemoved(this);
        memberRemoved.publishAfterCommit();
    }

    public static MemberRepository repository() {
        MemberRepository memberRepository = MemberApplication.applicationContext.getBean(
            MemberRepository.class
        );
        return memberRepository;
    }

    //<<< Clean Arch / Port Method
    public static void memberStatusCheck(LoanCreated loanCreated) {
        //implement business logic here:

        /** Example 1:  new item 
        Member member = new Member();
        repository().save(member);

        MemberResigtered memberResigtered = new MemberResigtered(member);
        memberResigtered.publishAfterCommit();
        MemberRemoved memberRemoved = new MemberRemoved(member);
        memberRemoved.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(loanCreated.get???()).ifPresent(member->{
            
            member // do something
            repository().save(member);

            MemberResigtered memberResigtered = new MemberResigtered(member);
            memberResigtered.publishAfterCommit();
            MemberRemoved memberRemoved = new MemberRemoved(member);
            memberRemoved.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void memberStatusCheck(LoanExpired loanExpired) {
        //implement business logic here:

        /** Example 1:  new item 
        Member member = new Member();
        repository().save(member);

        MemberResigtered memberResigtered = new MemberResigtered(member);
        memberResigtered.publishAfterCommit();
        MemberRemoved memberRemoved = new MemberRemoved(member);
        memberRemoved.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(loanExpired.get???()).ifPresent(member->{
            
            member // do something
            repository().save(member);

            MemberResigtered memberResigtered = new MemberResigtered(member);
            memberResigtered.publishAfterCommit();
            MemberRemoved memberRemoved = new MemberRemoved(member);
            memberRemoved.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root

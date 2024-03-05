package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private  final MemberRepository memberRepository;

    //의존관계를 외부에서 주입해주는것 같다고 해서
    //DI(Dependenvy Injection) 의존관계 주입 또는 의존성 주입이라 한다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

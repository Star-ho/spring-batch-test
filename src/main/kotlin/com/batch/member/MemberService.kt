package com.batch.member

import org.springframework.dao.DuplicateKeyException
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class MemberService(
    private val memberRepository: com.batch.member.MemberRepository,
) {

    @Transactional
    fun registerMember(createMemberDto: com.batch.member.CreateMemberDto) {
        val exist = memberRepository.existsById(createMemberDto.memberId)
        if (exist) throw DuplicateKeyException("해당되는 아이디가 있습니다.")
        val member = com.batch.member.Member(
            memberId = createMemberDto.memberId,
            password = createMemberDto.password,
            role = createMemberDto.role
        )
        memberRepository.save(member)
    }

    fun getMemberList(): List<com.batch.member.Member> {
        return memberRepository.findAll()
    }

    fun getMember(memberId: Long): com.batch.member.Member {
        return memberRepository.findById(memberId).orElseThrow { throw IllegalArgumentException("해당 멤버가 없습니다") }
    }
}
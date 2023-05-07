package com.sungho.member

import org.springframework.dao.DuplicateKeyException
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class MemberService(
    private val memberRepository: com.sungho.member.MemberRepository,
) {

    @Transactional
    fun registerMember(createMemberDto: com.sungho.member.CreateMemberDto) {
        val exist = memberRepository.existsById(createMemberDto.memberId)
        if (exist) throw DuplicateKeyException("해당되는 아이디가 있습니다.")
        val member = com.sungho.member.Member(
            memberId = createMemberDto.memberId,
            password = createMemberDto.password,
            role = createMemberDto.role
        )
        memberRepository.save(member)
    }

    fun getMemberList(): List<com.sungho.member.Member> {
        return memberRepository.findAll()
    }

    fun getMember(memberId: Long): com.sungho.member.Member {
        return memberRepository.findById(memberId).orElseThrow { throw IllegalArgumentException("해당 멤버가 없습니다") }
    }
}
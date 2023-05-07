package com.batch.member

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(
    private val memberService: com.batch.member.MemberService,
) {

    @PostMapping("/signup")
    fun registerMember(@RequestBody createMemberDto: com.batch.member.CreateMemberDto): ResponseEntity<Unit> {
        memberService.registerMember(createMemberDto)
        return ResponseEntity.ok().build()
    }

    @GetMapping()
    fun getMembers(): List<com.batch.member.Member> {
        return memberService.getMemberList()
    }
}
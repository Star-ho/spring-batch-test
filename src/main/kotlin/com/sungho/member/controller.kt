package com.sungho.member

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(
    private val memberService: com.sungho.member.MemberService,
) {

    @PostMapping("/signup")
    fun registerMember(@RequestBody createMemberDto: com.sungho.member.CreateMemberDto): ResponseEntity<Unit> {
        memberService.registerMember(createMemberDto)
        return ResponseEntity.ok().build()
    }

    @GetMapping()
    fun getMembers(): List<com.sungho.member.Member> {
        return memberService.getMemberList()
    }
}
package com.sungho.member

class CreateMemberDto(
    val memberId: Long,
    val password: String,
    val email: String,
    val role: com.sungho.member.ROLE,
)

class LoginDto(
    val memberId: String,
    val password: String,
)
